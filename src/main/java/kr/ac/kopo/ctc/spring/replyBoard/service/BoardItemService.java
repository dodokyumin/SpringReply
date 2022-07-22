package kr.ac.kopo.ctc.spring.replyBoard.service;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;

public interface BoardItemService {

	final int COUNT_PER_PAGE = 10;
	final int PAGE_SIZE = 10;

	//Page<ReplyItem> findAllPage(int pageCnt);

	// 페이지 불러오기
	//Pagination getPagination(int cPage, int PAGE_SIZE, int COUNT_PER_PAGE);

	// 페이지 null 체크
	public int checkCPage(String strcPage);

	// 조회수 1추가
	int plusViewcnt(int inputId);

	// 조회수 가져오기
	int getViewcnt(int inputId);

	// 댓글 추가하기
	void createItem(String author, String title, BoardGroup boardGroup);

	// 댓글 삭제하기
	void deleteItem(int id);

	// 댓글 아이디로 찾기(부모 원글 아이디 찾기 용)
	BoardItem findItem(int id);
	
}
