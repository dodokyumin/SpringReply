package kr.ac.kopo.ctc.spring.replyBoard.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;
import kr.ac.kopo.ctc.spring.replyBoard.repository.BoardItemRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService {

	@Autowired
	
	
	BoardItemRepository boardItemRepository;

	// Create
	public void create(BoardItem boardItem) {
		boardItemRepository.save(boardItem);
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
	public void createItem(String author, String title, BoardGroup boardGroup) {
		//제일 마지각 no 값.
		BoardItem boardItem = new BoardItem(author, new Date(), title, boardGroup);
		boardItemRepository.save(boardItem);
	}

	@Override
	public void deleteItem(int id) {
		BoardItem boardItem = boardItemRepository.findById(id).get();
		boardItemRepository.delete(boardItem);
	}


	@Override
	public BoardItem findItem(int id) {
		return boardItemRepository.findById(id).get();
	}


}
