package kr.ac.kopo.ctc.spring.replyBoard.service;

import java.text.SimpleDateFormat;
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
public class BoardGroupServiceImpl implements BoardGroupService{

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
//	// Read One
//	public BoardGroup readOne(int id) {
//		BoardGroup boardGroup = boardGroupRepository.findById(id).get();
//		return boardGroup;
//	}
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

	// Page
//	public Page<ReplyItem> findAllPage(int pageNum) {
//		PageRequest pageable = PageRequest.of(pageNum, countPerPage);
//		return replyItemRepository.findAll(pageable);
//	}
//
	// Search + Page
//	public Page<ReplyItem> findAllSearchPage(int firstContent, int lastContent, String searchTitle) {
//		PageRequest pageable = PageRequest.of(firstContent, lastContent);
//		Page<ReplyItem> page = replyItemRepository.findAllByTitleContaining(searchTitle, pageable);
//		return page;
//	}

	// 기존의 대댓글 게시판에서 가져온 코드
	@Override
	public Pagination getPagination(String strcPage) {
		int currPage = Integer.parseInt(strcPage);

		Pagination p = new Pagination();

		// 총 레코드 수 조회
		int totalCount = getRowCount();
		
		// >>
		int totalPage;
		if ((totalCount % COUNT_PER_PAGE) > 0) {
			totalPage = totalCount / COUNT_PER_PAGE + 1;
		} else {
			totalPage = totalCount / COUNT_PER_PAGE;
		}

		// currPage
		if (currPage > totalPage) {
			currPage = totalPage;
		} else if (currPage < 1) {
			currPage = 1;
		}
		p.setcPage(currPage);

		// pageSize
		p.setPageSize(PAGE_SIZE);

		// <<
		p.setPpPage(1);
		// >>
		p.setNnPage(totalPage);

		// >
		if ((totalPage - currPage) < PAGE_SIZE) {
			p.setnPage(totalPage);
		} else {
			p.setnPage((currPage / PAGE_SIZE + 1) * PAGE_SIZE + 1);
		}
		// <
		if ((currPage / PAGE_SIZE) == 0) {
			p.setpPage(1);
		} else {
			p.setpPage((currPage - PAGE_SIZE / PAGE_SIZE)); // 이 부분 문데
		}

		// 첫 페이지 번호
		int startPage = (currPage / PAGE_SIZE) * PAGE_SIZE + 1;
		if ((currPage % PAGE_SIZE) == 0) {
			startPage -= PAGE_SIZE;
		}
		p.setFirstPage(startPage);

		// 마지막 페이지 번호
		int lastPage = (startPage + PAGE_SIZE - 1) >= totalPage ? totalPage : (startPage + PAGE_SIZE - 1);
		p.setLastPage(lastPage);

		if (lastPage >= totalPage) {
			p.setLastPage(totalPage);
		}

		return p;
	}

	public int getRowCount() {
		int rowcount = (int) boardGroupRepository.count();
		return rowcount;
	}

//	@Override
//	public String checkcPage(String strcPage) {
//		if (strcPage == null) {
//			strcPage = "1";
//		}
//		return strcPage;
//	}

	@Override
	public String newDate() {
		Date nowDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		// 원하는 데이터 포맷 지정
		String date = simpleDateFormat.format(nowDate);
		return date;
	}

	@Override
	public int checkCPage(String strcPage) {
		// 현재 페이지 번호 null 체크
		int cPage = 0;
		if (strcPage == null) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(strcPage) - 1;
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

}
