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
			,@RequestParam(required = false, defaultValue = "1") int range
			) throws Exception {

		//��ü �Խñ� ����
		int listCnt = boardBiz.getBoardListCnt();

		// Pagination ��ü����
		Pagination pagination = new Pagination();

		pagination.pageInfo(page, range, listCnt);


		model.addAttribute("pagination", pagination);
		model.addAttribute("boardList", boardBiz.getBoardList(pagination));
		return "/jsp/board/qnaList";
	}

	@RequestMapping(value = "writeQna")
	public String writeQna(@ModelAttribute("boardDto") BoardDto boardDto, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		// �� �α��� �� �϶�� ��Ŵ
		if(session.getAttribute("u_id") != null) { // == �� �ٲ�� �۵�
			System.out.println("writeQna boardController �α��μ��� ����");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�α��� �� �ۼ������մϴ�.');"
					+ "location.href='http://localhost:8787/login'; "
					+ "</script>");
			out.flush();
		}
		return "jsp/board/writeQna";
	}

	@RequestMapping(value ="writeQnaAct", method = RequestMethod.POST)
	public String Write(@ModelAttribute("BoardDto") BoardDto boardDto, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception {
		if (mode.equals("edit")) {
			boardBiz.updateQna(boardDto);
			System.out.println("����");
		} else {
			boardBiz.insertBoard(boardDto);
			System.out.println("�����ۼ�");
		}
		rttr.addFlashAttribute("result", "update success");

		return "redirect:/board/qnaList";

	}



	@RequestMapping(value = "qnaDetail", method = RequestMethod.GET)
	public String qndDetail(Model model, @RequestParam("seq") int seq) throws Exception {
		model.addAttribute("qnaDetail", boardBiz.qnaDetail(seq));

		return "jsp/board/qnaDetail";
	}

	@RequestMapping(value = "updateQna", method = RequestMethod.GET)
	public String updateQna(@RequestParam("seq") int seq, @RequestParam("mode") String mode, Model model) throws Exception {

		model.addAttribute("qnaDetail", boardBiz.qnaDetail(seq));
		model.addAttribute("mode", mode);
		model.addAttribute("boardDto", new BoardDto());

		return "jsp/board/writeQna";

	}

	@RequestMapping(value = "deleteQna", method = RequestMethod.GET)
	public String deleteQna(RedirectAttributes rttr, @RequestParam("seq") int seq) throws Exception {
		boardBiz.deleteQna(seq);
		return "redirect:/board/qnaList";

	}





}
