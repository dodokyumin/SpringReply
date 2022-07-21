package kr.ac.kopo.ctc.spring.replyBoard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;

@Repository
public interface BoardGroupRepository extends JpaRepository<BoardGroup, Integer>, JpaSpecificationExecutor<BoardGroup>{
	//ReadAll
	List<BoardItem> findAllById(int id, Pageable pageable);

	Page<BoardGroup> findAllByOrderByIdDesc(Pageable pageable);
	
	//검색기능
	List<BoardGroup> findByTitleContains(String searchStr);
	
	//검색 + page
	Page<BoardGroup> findByTitleContainsOrderByIdDesc(String searchStr, Pageable pageable);
		
}
