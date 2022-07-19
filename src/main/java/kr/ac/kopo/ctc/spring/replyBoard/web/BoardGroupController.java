package kr.ac.kopo.ctc.spring.replyBoard.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.service.BoardGroupService;

@Controller
public class BoardGroupController {

	@Autowired
	private BoardGroupService boardGroupService;
	
	@RequestMapping(value = "/boardGroup")
	public String list(Model model) {
		model.addAttribute("boardGroupList", boardGroupService.readAll("1"));
		
		return "index";
	}
}
