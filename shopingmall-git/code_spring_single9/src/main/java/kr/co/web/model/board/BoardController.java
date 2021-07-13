package kr.co.web.model.board;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Inject
	private BoardBiz boardBiz;

	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public String getBoardList(Model model) throws Exception {

		model.addAttribute("boardList", boardBiz.getBoardList());

		return "/jsp/board/qnaList"; 
	}
	
	@RequestMapping(value = "/board/qnaDetail")
	public String qnaDetail(Model model) {
		
		return "jsp/board/qnaDetail";
	}
	@RequestMapping(value = "/board/qnaView")
	public String qnaView(Model model) {
		
		return "jsp/board/qnaView";
	}
}
