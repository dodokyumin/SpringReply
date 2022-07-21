package kr.ac.kopo.ctc.spring.replyBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;
import kr.ac.kopo.ctc.spring.replyBoard.service.BoardGroupService;
import kr.ac.kopo.ctc.spring.replyBoard.service.BoardItemService;

@Controller
public class BoardItemController {

	@Autowired
	private BoardItemService BoardItemService;

	@Autowired
	private BoardGroupService boardGroupService;
	
	@RequestMapping(value = "/createReply/{id}")
	public String createReplyItem(Model model, @PathVariable("id") int id) {
		model.addAttribute("boardGroupId", id);
		return "createReply";
	}
	
	@RequestMapping(value = "/createReplyDone")
	public String createReplyDone(Model model, @ModelAttribute BoardItem boardItem) {
		int groupId = boardItem.getBoardGroup().getId();
		BoardGroup boardGroup = boardGroupService.findById(groupId);
		BoardItemService.createItem(boardItem.getAuthor(), boardItem.getTitle(), boardGroup);
		model.addAttribute("boardGroup", groupId);
		return "createReplyDone";
	}
	
	@RequestMapping(value = "/deleteReply/{id}")
	public String deleteReplyItem(Model model, @PathVariable("id") int id) {
		int boardGroupId = BoardItemService.findItem(id).getBoardGroup().getId();
		BoardItemService.deleteItem(id);
		model.addAttribute("boardGroupId", boardGroupId);
		return "deleteReply";
	}
}
