package kr.ac.kopo.ctc.spring.replyBoard.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;
import kr.ac.kopo.ctc.spring.replyBoard.repository.BoardGroupRepository;

@Service
public class BoardGroupServiceImpl implements BoardGroupService {

	@Autowired
	BoardGroupRepository boardGroupRepository;

	// Create
	public void create(BoardGroup boardgroup) {
		boardGroupRepository.save(boardgroup);
	}

	// Read All
	@Override
	public Page<BoardGroup> readAll(String strcPage) {

		int cPage = checkCPage(strcPage);

		PageRequest pageable = PageRequest.of(cPage, COUNT_PER_PAGE);

		Page<BoardGroup> page = boardGroupRepository.findAllByOrderByIdDesc(pageable);

		return page;
	}

	// Read One
	@Override
	public BoardGroup readOne(int id) {
		plusViewcnt(id);
		return boardGroupRepository.findById(id).get();
	}

	@Override
	public BoardGroup findById(int id) {
		return boardGroupRepository.findById(id).get();
	}

	// Update
	@Override
	public void updateGroup(int id, String title, String content) {

		BoardGroup oldBoardGroup = boardGroupRepository.findById(id).get();

		oldBoardGroup.setTitle(title);
		oldBoardGroup.setCreated(new Date());
		oldBoardGroup.setContent(content);

		boardGroupRepository.save(oldBoardGroup);
	}

	// Delete
	@Override
	public void deleteGroup(int id) {
		boardGroupRepository.deleteById(id);
	}

	// 기존의 대댓글 게시판에서 가져온 코드

	@Override
	public Pagination getPagination(int cPage) {
		long totalCount = boardGroupRepository.count();

		Pagination pagination = new Pagination();

		double dTotal = (double) totalCount;
		Integer nnPage = (int) Math.ceil(dTotal / COUNT_PER_PAGE);

		if (cPage < 1) {
			cPage = 1;
		}

		if (cPage > nnPage) {
			cPage = nnPage;
		}

		int startPage = 0;

		if (cPage % PAGE_SIZE != 0) {
			startPage = cPage - (cPage % PAGE_SIZE) + 1;
		} else {
			startPage = cPage - PAGE_SIZE + 1;
		}

		int endPage = startPage + PAGE_SIZE - 1;
		int nPage = startPage + PAGE_SIZE;
		int pPage = startPage - PAGE_SIZE;

		if (pPage < 1) {
			pPage = 1;
		}

		if (nPage > nnPage) {
			nPage = nnPage - (nnPage % PAGE_SIZE) + 1;
		}

		if (endPage > nnPage) {
			endPage = nnPage;
		}

		pagination.setcPage(cPage);
		pagination.setFirstPage(startPage);
		pagination.setLastPage(endPage);
		pagination.setPpPage(1);
		pagination.setNnPage(nnPage);
		pagination.setnPage(nPage);
		pagination.setpPage(pPage);

		return pagination;
	}

	@Override
	public int getRowCount() {
		int rowcount = (int) boardGroupRepository.count();
		return rowcount;
	}

	@Override
	public int checkCPage(String strcPage) {
		// 현재 페이지 번호 null 체크
		int cPage;
		if (strcPage == null) {
			cPage = 0;
		} else {
			cPage = Integer.parseInt(strcPage);
		}
		return cPage;
	}


	@Override
	public int plusViewcnt(int id) {
		int newView = boardGroupRepository.findById(id).get().getView() + 1;
		BoardGroup boardGroup = boardGroupRepository.findById(id).get();
		boardGroup.setView(newView);
		boardGroupRepository.save(boardGroup);
		return 0;
	}

	@Override
	public int getViewcnt(int inputId) {
		int vc = findById(inputId).getView();
		return vc;
	}

	@Override
	public void createGroup(String author, String title, String content) {
		BoardGroup boardGroup = new BoardGroup(author, new Date(), title, content);
		boardGroupRepository.save(boardGroup);
	}

	@Override
	public List<BoardItem> findBoardItems(int id) {
		List<BoardItem> BoardItemList = boardGroupRepository.findById(id).get().getBoardItems();
		return BoardItemList;
	}

	@Override
	public Page<BoardGroup> searchBoardGroupList(String strcurrPage, String searchStr) {
		int cPage = checkCPage(strcurrPage)-1;

		PageRequest pageable = PageRequest.of(cPage, COUNT_PER_PAGE);

		Page<BoardGroup> BoardGroupList = boardGroupRepository.findByTitleContainsOrderByIdDesc(searchStr, pageable);

		return BoardGroupList;
	}

	// 키워드를 받는 페이지네이션
	@Override
	public Pagination getPagination(int cPage, String keyword) {

		long totalCount = boardGroupRepository.findByTitleContains(keyword).size(); 
		Pagination pagination = new Pagination();

		double dTotal = (double) totalCount;
		Integer nnPage = (int) Math.ceil(dTotal / COUNT_PER_PAGE);

		if (cPage < 1) {
			cPage = 1;
		}

		if (cPage > nnPage) {
			cPage = nnPage;
		}

		int startPage = 0;
 
		if (cPage % PAGE_SIZE != 0) {
			startPage = cPage - (cPage % PAGE_SIZE) + 1;
		} else {
			startPage = cPage - PAGE_SIZE + 1;
		}
 
		int endPage = startPage + PAGE_SIZE - 1;
		int nPage = startPage + PAGE_SIZE;
		int pPage = startPage - PAGE_SIZE;

		if (pPage < 1) {
			pPage = 1;
		}

		if (nPage > nnPage) {
			nPage = nnPage - (nnPage % PAGE_SIZE) + 1;
		}

		if (endPage > nnPage) {
			endPage = nnPage;
		}

		pagination.setcPage(cPage);
		pagination.setFirstPage(startPage);
		pagination.setLastPage(endPage);
		pagination.setPpPage(1);
		pagination.setNnPage(nnPage);
		pagination.setnPage(nPage);
		pagination.setpPage(pPage);

		return pagination;

	}

	// 제공되는 페이지네이션으로 변경
	@Override
	public Page<BoardGroup> currPagination(String strCurrPage) {
		int cPage = Integer.parseInt(strCurrPage);
		Page<BoardGroup> page = boardGroupRepository.findAllByOrderByIdDesc(PageRequest.of(cPage-1, PAGE_SIZE));
		return page;
	}

}
