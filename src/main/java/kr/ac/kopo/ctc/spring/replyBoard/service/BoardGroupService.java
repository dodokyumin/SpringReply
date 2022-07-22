package kr.ac.kopo.ctc.spring.replyBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;
import kr.ac.kopo.ctc.spring.replyBoard.repository.BoardGroupRepository;

public interface BoardGroupService {
	
	final int COUNT_PER_PAGE = 10;
	final int PAGE_SIZE = 10;

	// 페이지 불러오기
	Pagination getPagination(int cPage);
	// 키워드 있을 때
	Pagination getPagination(int cPage, String searchStr);

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

	BoardGroup readOne(int id);

	BoardGroup findById(int id);

	List<BoardItem> findBoardItems(int id);
	
	//전체 데이터 조회
	int getRowCount();

	//검색 기능 + page
	Page<BoardGroup> searchBoardGroupList(String strcurrPage, String keyword);
	
	Page<BoardGroup> currPagination(String strCurrPage);
}
