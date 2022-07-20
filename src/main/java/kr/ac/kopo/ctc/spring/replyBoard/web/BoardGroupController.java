package kr.ac.kopo.ctc.spring.replyBoard.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.replyBoard.domain.BoardItem;
import kr.ac.kopo.ctc.spring.replyBoard.service.BoardGroupService;
import kr.ac.kopo.ctc.spring.replyBoard.service.Pagination;

@Controller
public class BoardGroupController {

	@Autowired
	private BoardGroupService boardGroupService;

	//매핑 밸류 두가지를 정하여 default경로와 cPage 파라미터 받았을 때 모두 매핑해주기.
	@RequestMapping(value = {"/boardGroup/{strCurrPage}","/boardGroup" })
	public String list(Model model, @PathVariable(required = false) String strCurrPage) {
		//string은 null이여도 바로 에러를 받지 않기 때문에 String으ㅜ로 strcurrPage를 받자.
		Pagination pagination = boardGroupService.getPagination(strCurrPage);
		model.addAttribute("boardGroupList", boardGroupService.readAll(strCurrPage));
		
		// readAll(strCurrPage)로 해당 페이지의 totalElements만 가져오는 것이 아니라, getTotalElements는 page타입의 내장 함수로 slice하기 전의 토탈 갯수를 cnt하는 변수도 내포하고 있기 때문에. 
		//readAll(strCurrPage)에 이어서 getTotalElements를 하여도 총 갯수가 나오는 것이다.
		model.addAttribute("boardGroupTotalCount", boardGroupService.readAll(strCurrPage).getTotalElements());
		model.addAttribute("pagination", pagination);

		return "index";
	}
	
	@RequestMapping(value = "/readOne/{id}")
	public String oneView(Model model, @PathVariable("id") String strId) {
		System.out.println(strId);
		int id = Integer.parseInt(strId);
		model.addAttribute("boardGroup", boardGroupService.readOne(id));
		model.addAttribute("boardItemList", boardGroupService.findBoardItems(id));
		System.out.println("Dfd");
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
	
	@RequestMapping(value = "/boardGroup/search")
	public String searchGroup(Model model, @ModelAttribute BoardGroup boardGroup) {
		
		Page<BoardGroup> searchBoardGroupListPage = boardGroupService.searchBoardGroup(boardGroup.getTitle());
		//null예외처리를 해주었으므로 그냥""는 오류남.
		String strCurrPage = null;
		Pagination pagination = boardGroupService.getPagination(strCurrPage);
		
		
		model.addAttribute("boardGroupList", searchBoardGroupListPage);
		
		//검색 후 총 갯수를 가져와야할 것
		model.addAttribute("boardGroupTotalCount", searchBoardGroupListPage.getNumberOfElements());
		
		//pagination의  totalCount가 검색한 내용만 가져오는 것으로 능동적으로 바뀌게 한 후의 pagination이어야할 것.
		model.addAttribute("pagination", pagination);
		return "index";
	}


}

