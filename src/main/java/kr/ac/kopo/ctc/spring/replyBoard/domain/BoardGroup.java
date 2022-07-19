package kr.ac.kopo.ctc.spring.replyBoard.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BoardGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String author;

	@Column
	private Date created;

	@Column
	private String title;
	
	@Column
	private String content;

	@Column
	private int view;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "boardGroup")
	@JsonBackReference //순환참조 막기.
	private List<BoardItem> boardItems;

	public List<BoardItem> getBoardItems() {
		if (boardItems == null) {
			boardItems = new ArrayList<BoardItem>();
		}
		return boardItems;
	}
	
	public BoardGroup() {
		// TODO Auto-generated constructor stub
	}
	
	public void addBoardItem(BoardItem boardItem) {
		List<BoardItem> boardItems = getBoardItems();
		boardItems.add(boardItem);
	}

	public void setBoardItems(List<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BoardGroup(String author, Date created,  String title, String content) {
		this.author = author;
		this.created = created;
		this.title = title;
		this.content = content;
		this.view = 0;
	}

}
