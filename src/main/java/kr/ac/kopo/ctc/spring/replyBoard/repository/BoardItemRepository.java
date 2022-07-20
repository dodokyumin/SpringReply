package kr.ac.kopo.ctc.spring.replyBoard.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;
import net.bytebuddy.description.annotation.AnnotationValue.Sort;

public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem> {

	List<BoardItem> findAllById(int id, Pageable pageable);
	
	Page<BoardItem> findAllByOrderById(PageRequest pageable);
//	// count rows
//	int RowCount();
//
//	// 조회수 더하기
//	void plusViewcnt(int inputId);
//
//	// 조회수 가져오기
//	int getViewcnt(int inputId);
//
//	// 마지막 id값 가져오기
//	int getLastId();
//
//	// 댓글 만들기
//	int createReplyOne(BoardItem boardItem);
//
//	// 서비스에서 현재 작성글의 recnt를 얻기 위해 사용되는 DB에 접근하는 메소드
//	ArrayList<Integer[]> findRecnt(int rootid, int MomRecnt);
//
//	// 서비스에서 현재 작성글의 밑 글들을 같이 삭제하게 만드는 메소드
//	int deleteLowerLevels(int rootid, int start, int end);
//
//	Page<BoardItem> findAllByOrderByNoAsc(PageRequest pageable);
	
}
