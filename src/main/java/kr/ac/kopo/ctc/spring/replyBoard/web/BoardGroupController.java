package kr.ac.kopo.ctc.spring.replyBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.service.BoardGroupService;

@Controller
public class BoardGroupController {

	@Autowired
	private BoardGroupService boardGroupService;

	@RequestMapping(value = "/boardGroup")
	public String list(Model model) {
		model.addAttribute("boardGroupList", boardGroupService.readAll("1"));
		model.addAttribute("Pagination", boardGroupService.getPagination("1"));
		return "index";
	}
	
	@RequestMapping(value = "/readOne/{id}")
	public String oneView(Model model, @PathVariable("id") String strId) {
		int id = Integer.parseInt(strId);
		model.addAttribute("boardGroup", boardGroupService.readOne(id));
		model.addAttribute("boardItemList", boardGroupService.findBoardItems(id));
		return "readOne";
	}
	
	@RequestMapping(value = "/createOne")
	public String createOne(Model model) {
		model.addAttribute("boardGroupCreate", boardGroupService);
		return "createOne"; 
	}
	

	@RequestMapping(value = "/createDone")
	public String createDone(Model model, @ModelAttribute BoardGroup boardGroup) {
		boardGroupService.createGroup(boardGroup.getAuthor(), boardGroup.getTitle(), boardGroup.getContent());
		model.addAttribute("boardGroup", 1);
		return "createDone";
	}
	
	@RequestMapping(value = "/updateOne/{id}")
	public String updateOne(Model model, @PathVariable("id") int id) {
		//int id = Integer.parseInt(strId);
		model.addAttribute("boardGroup", boardGroupService.findById(id));
		return "updateOne";
	}

	@RequestMapping(value = "/UpdateDone/{id}")
	public String updateDone(Model model, @ModelAttribute BoardGroup boardGroup) {
		boardGroupService.updateGroup(boardGroup.getId(), boardGroup.getTitle(), boardGroup.getContent());
		model.addAttribute("boardGroup", 1);
		return "UpdateDone";
	}

	@RequestMapping(value = "/deleteOne/{id}")
	public String deleteOne(Model model, @ModelAttribute BoardGroup boardGroup) {
		int id = boardGroup.getId();
		boardGroupService.deleteGroup(id);
		model.addAttribute("boardGroup", 1);
		return "deleteOne";
	}

	
//	@RequestMapping(value = "/boardGroup")
//	public String Pagination(Model model) {
//		return "index";
//	}
}

