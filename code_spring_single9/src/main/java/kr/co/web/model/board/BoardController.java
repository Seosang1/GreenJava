package kr.co.web.model.board;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
	@Autowired
	private SqlSession sqlSession;
	
	@Inject
	private BoardBiz boardBiz;

	@RequestMapping(value = "/board/qnaList", method = RequestMethod.GET)
	public String getBoardList(Model model) throws Exception {

		model.addAttribute("boardList", boardBiz.getBoardList());

		return "/jsp/board/qnaList"; 
	}
	
	@RequestMapping(value = "/board/writeQna")
	public String writeQna(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		// 비 로그인 시 하라고 시킴
		if(session.getAttribute("u_id") != null) { // == 로 바꿔야 작동
			System.out.println("writeQna boardController 로그인세션 없음");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 작성가능합니다.');"
					+ "location.href='http://localhost:8787/login'; "
					+ "</script>");
			out.flush();
		}
		return "jsp/board/writeQna";
	}
	
	@RequestMapping(value ="/writeQnaAct", method = RequestMethod.POST)

	public String Write(@ModelAttribute("BoardDto") BoardDto boardDto, RedirectAttributes rttr) throws Exception {

		boardBiz.insertBoard(boardDto);

		return "redirect:/jsp/board/qnaList";

	}
 
	@RequestMapping(value = "qnaDetail")
	public String qnaDetail(Model model) {
		
		return "jsp/board/qnaDetail";
	}
	@RequestMapping(value = "qnaView")
	public String qnaView(Model model) {
		
		return "jsp/board/qnaView";
	}
}
