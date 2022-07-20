package kr.ac.kopo.ctc.spring.replyBoard.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;

@Repository
public interface BoardGroupRepository extends JpaRepository<BoardGroup, Integer>, JpaSpecificationExecutor<BoardGroup>{
	//ReadAll

	List<BoardItem> findAllById(int id, Pageable pageable);
//	
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
//	// 대댓댓글 생성시 뒤 recnt 한칸씩 밀기
//	void pushBackRecnt(int rootid, int relevel, int recnt);
//
//	// 서비스에서 현재 작성글의 recnt를 얻기 위해 사용되는 DB에 접근하는 메소드
//	ArrayList<Integer[]> findRecnt(int rootid, int MomRecnt);
//
//	// 서비스에서 현재 작성글의 밑 글들을 같이 삭제하게 만드는 메소드
//	int deleteLowerLevels(int rootid, int start, int end);

	Page<BoardGroup> findAllByOrderByIdDesc(Pageable pageable);
	
//	@Query(value="SELECT COUNT(*) FROM board_group", nativeQuery=true)
//    public int rowCnt;
	
	
}
