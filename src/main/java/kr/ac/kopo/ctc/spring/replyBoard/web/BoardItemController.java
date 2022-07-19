package kr.ac.kopo.ctc.spring.replyBoard.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.replyBoard.service.BoardItemService;

@Controller
public class BoardItemController {

	@Autowired
	private BoardItemService replyItemService;

	
//	@RequestMapping(value = "/index")
//	@ResponseBody
//	public String list(Model model) {
//		List<BoardItem> replyItems = replyItemService.
//		
//	}

//	// DB없이 url로 전송한 데이터를 매핑하여 보내주는 실습
//	@Controller
//	@RequestMapping(value = "/boardItem")
//	public class BoardItemController {
//
//		@RequestMapping(value = "")
//		public String replyItem(Model model) {
//
//			// 여기서 "name"은 hello.jsp의 Hello, ${name}!
//			model.addAttribute("name", "홍규민");
//
//			// "hello" 에 application.properties에서 설정해주었던 prefix suffix가 앞 뒤로 붙어 view로 보내주는
//			// url이 완성되는 것
//			return "hello";
//		}
//
//		@RequestMapping(value = "/getParameter")
//		public String getParameter(Model model, HttpServletRequest req) {
//			String name = req.getParameter("name");
//			model.addAttribute("name", name);
//			return "hello";
//		}
//
//		@RequestMapping(value = "/requestParam")
//		public String requestParam(Model model, @RequestParam(value = "name") String name) {
//			model.addAttribute("name", name);
//			return "hello";
//		}
//
//		@RequestMapping(value = "/pathVariable/{name}")
//		public String pathVariable(Model model, @PathVariable(value = "name") String name) {
//			model.addAttribute("name", name);
//			return "hello";
//		}
//
//		// http://localhost:8088/boardItem/modelAttribute?author=홍규민5
//		@RequestMapping(value = "/modelAttribute")
//		public String modelAttribute(Model model, @ModelAttribute ReplyItem replyItem) {
//			model.addAttribute("name", replyItem.getTitle());
//			return "hello";
//		}
//
//		@RequestMapping(value = "/requsetBody1")
//		public String requsetBody1(Model model, @RequestBody Map<String, Object> obj) {
//			model.addAttribute("name", obj.get("name"));
//			return "hello";
//		}
//		// http://localhost:8088/boardItem/requsetBody2
//		// {
//		// "name" : "홍규민6"
//		// }
//
//		@RequestMapping(value = "/requsetBody2")
//		public String requsetBody1(Model model, @RequestBody ReplyItem replyItem) {
//			model.addAttribute("name", replyItem.getTitle());
//			return "hello";
//		}
//		// http://localhost:8088/boardItem/requsetBody2
//		// {
//		// "author" : "홍규민6"
//		// }
//	}
}
