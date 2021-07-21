package kr.co.web.model.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.web.Pagination;
import kr.co.web.Search;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private SqlSession sqlSession;

	@Inject
	private BoardBiz boardBiz;

	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public String getBoardList(Model model
			,@RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "title") String searchType
			, @RequestParam(required = false) String keyword

			) throws Exception {

		Search search = new Search();

		search.setSearchType(searchType);

		search.setKeyword(keyword);


		//전체 게시글 개수
		int listCnt = boardBiz.getBoardListCnt(search);

		search.pageInfo(page, range, listCnt);

		// Pagination 객체생성
		Pagination pagination = new Pagination();

		pagination.pageInfo(page, range, listCnt);


		model.addAttribute("pagination", search);
		model.addAttribute("boardList", boardBiz.getBoardList(search));
		return "/jsp/board/qnaList";
	}

	@RequestMapping(value = "writeQna")
	public String writeQna(@ModelAttribute("boardDto") BoardDto boardDto, Model model, HttpSession session,
			HttpServletResponse response) throws IOException {
		// 비 로그인 시 하라고 시킴
		if (session.getAttribute("u_id") == null) { // == 로 바꿔야 작동
			System.out.println("writeQna boardController 로그인세션 없음");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(
					"<script>alert('로그인 후 작성가능합니다.');" + "location.href='http://localhost:8787/login'; " + "</script>");
			out.flush();
		}

		System.out.println("writeQna 컨트롤러 실행");
		return "jsp/board/writeQna";
	}

	@RequestMapping(value = "updateQna", method = RequestMethod.GET)
	public String updateQna(@RequestParam("seq") int seq, @RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("qnaDetail", boardBiz.qnaDetail(seq));
		model.addAttribute("mode", mode);
		model.addAttribute("boardDto", new BoardDto());

		return "jsp/board/writeQna";

	}
	@RequestMapping(value ="/writeQnaAct", method = RequestMethod.POST)
	public String Write(@ModelAttribute("BoardDto") BoardDto boardDto, @RequestParam("mode") String mode,
			RedirectAttributes rttr) throws Exception {

		if (mode.equals("edit")) {
			System.out.println("수정 controller 시작");
			boardBiz.updateQna(boardDto);
			rttr.addFlashAttribute("result", "update success");
		} else {
			boardBiz.insertBoard(boardDto);
			System.out.println("새글작성 controller 시작");
			rttr.addFlashAttribute("result", "insert success");
		}
		System.out.println("controller 종료");
		return "redirect:/board/qnaList";
	}



	@RequestMapping(value = "qnaDetail", method = RequestMethod.GET)
	public String qndDetail(Model model, @RequestParam("seq") int seq) throws Exception {
		model.addAttribute("qnaDetail", boardBiz.qnaDetail(seq));
		model.addAttribute("boardDto", new BoardDto());

		return "jsp/board/qnaDetail";
	}


	@RequestMapping(value = "deleteQna", method = RequestMethod.GET)
	public String deleteQna(RedirectAttributes rttr, @RequestParam("seq") int seq) throws Exception {
		boardBiz.deleteQna(seq);
		return "redirect:/board/qnaList";

	}





}
