package kr.ac.kopo.ctc.spring.replyBoard.service;

import java.util.Date;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;

public interface BoardItemService {

	final int COUNT_PER_PAGE = 10;
	final int PAGE_SIZE = 10;

	//Page<ReplyItem> findAllPage(int pageCnt);

	// 페이지 불러오기
	Pagination getPagination(String strcPage);

	// cPage null 체크
	String checkcPage(String strcPage);

	// 새로운 날짜 받기
	String newDate();

	// 페이지 null 체크
	public int checkCPage(String strcPage);

	// 조회수 1추가
	int plusViewcnt(int inputId);

	// 조회수 가져오기
	int getViewcnt(int inputId);

	// 댓글 추가하기
	void createItem(String author, Date create, String title, BoardGroup boardGroup);
	
}
