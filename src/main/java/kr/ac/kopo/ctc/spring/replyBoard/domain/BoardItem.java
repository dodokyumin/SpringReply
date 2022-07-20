package kr.ac.kopo.ctc.spring.replyBoard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BoardItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private Date created;
	
	@Column
	private int view;

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonManagedReference //참조 통과 어노테이션
	@JoinColumn(name="board_group_id")
	private BoardGroup boardGroup;
	
	public BoardItem(String author, Date date, String title, BoardGroup boardGroup) {
		this.author = author;
		this.created = date;
		this.title = title;
		this.view = 0;
		this.boardGroup = boardGroup;
	}
	
	public BoardItem() {
		// TODO Auto-generated constructor stub
	}

	public BoardGroup getBoardGroup() {
		return boardGroup;
	}
	public void setBoardGroup(BoardGroup boardGroup) {
		this.boardGroup = boardGroup;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}

	
}
