package kr.ac.kopo.ctc.spring.replyBoard.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.replyBoard.service.Pagination;
import net.bytebuddy.description.annotation.AnnotationValue.Sort;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;
import kr.ac.kopo.ctc.spring.replyBoard.repository.BoardItemRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService {

	@Autowired
	
	
	BoardItemRepository boardItemRepository;

	// Create
	public void create(BoardItem replyItem) {
		boardItemRepository.save(replyItem);
	}

	// Read
	public Page<BoardItem> readAll(String strcPage) {

		int cPage = checkCPage(strcPage);

		PageRequest pageable = PageRequest.of(cPage, COUNT_PER_PAGE);
		Page<BoardItem> page = boardItemRepository.findAllByOrderById(pageable);

		return page;
	}

	public BoardItem findById(int id) {
		return boardItemRepository.findById(id).get();
	}

	// Update
	public void Update(BoardItem boardItem) {
		BoardItem oldBoardItem = boardItemRepository.findById(boardItem.getId()).get();

		oldBoardItem.setTitle(boardItem.getTitle());
		oldBoardItem.setCreated(new Date());
		oldBoardItem.setView(boardItem.getView());

		boardItemRepository.save(oldBoardItem);
	}

	// Delete
	public void DeleteOne(int id) {
		boardItemRepository.deleteById(id);
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
		int rowcount = (int) boardItemRepository.count();
		return rowcount;
	}

	@Override
	public String checkcPage(String strcPage) {
		if (strcPage == null) {
			strcPage = "1";
		}
		return strcPage;
	}

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
			cPage = Integer.parseInt(strcPage);
		}
		return cPage;
	}

	@Override
	public int plusViewcnt(int inputId) {
		BoardItem boardItem = findById(inputId);
		boardItem.setView(boardItem.getView() + 1);
		boardItemRepository.save(boardItem);
		return 0;
	}

	@Override
	public int getViewcnt(int inputId) {
		int vc = findById(inputId).getView();
		return vc;
	}

	@Override
	public void createItem(String author, Date create, String title, BoardGroup boardGroup) {
		//제일 마지각 no 값.
		
		BoardItem boardItem = new BoardItem(author, create, title, boardGroup);
		boardItemRepository.save(boardItem);
	}


}
