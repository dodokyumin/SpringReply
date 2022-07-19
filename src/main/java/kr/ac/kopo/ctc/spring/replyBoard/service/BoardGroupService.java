package kr.ac.kopo.ctc.spring.replyBoard.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;

public interface BoardGroupService {

	final int COUNT_PER_PAGE = 10;
	final int PAGE_SIZE = 10;

	//Page<ReplyItem> findAllPage(int pageCnt);

	// 페이지 불러오기
	Pagination getPagination(String strcPage);

//	// cPage null 체크
//	String checkcPage(String strcPage);

	// 새로운 날짜 받기
	String newDate();

	// 페이지 null 체크
	public int checkCPage(String strcPage);

	// 조회수 1추가
	int plusViewcnt(int inputId);

	// 조회수 가져오기
	int getViewcnt(int inputId);

	void createGroup(String author, String title, String content);

	void updateGroup(int id, String title, String content);
	
	void deleteGroup(int id);
	
	public Page<BoardGroup> readAll(String strcPage);

	BoardGroup findById(int id);
	
}
