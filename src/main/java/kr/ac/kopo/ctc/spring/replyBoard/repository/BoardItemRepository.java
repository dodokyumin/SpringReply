package kr.ac.kopo.ctc.spring.replyBoard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;

public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem> {

	List<BoardItem> findAllById(int id, Pageable pageable);
	
	Page<BoardItem> findAllByOrderById(PageRequest pageable);
	
}
