package kr.co.web;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.web.model.board.BoardDao;
import kr.co.web.model.board.BoardDto;

//Runner 클래스(테스트 메소드를 실행하는 클래스) 를 SpringJUnit4ClassRunner로 함
@RunWith(SpringJUnit4ClassRunner.class)
//location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class BoardDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);

	@Inject
	private BoardDao dao;


	/* @Ignore
	public void testSelectMember() throws Exception {
		List<BoardDto> vo = dao.getBoardList(Pagination pagination);
		System.out.println(vo);

		logger.info("\n Board List \n ");
		if (vo.size() > 0) {
			for (BoardDto list : vo) {
				logger.info(list.getTitle());
			}
		} else {
			logger.info("데이터가 없습니다.");
		}
	}
	 */



	@Ignore
	public void testInsertBoard() throws Exception {

		BoardDto vo = new BoardDto();

		vo.setU_id("test1");
		vo.setTitle("첫번째 게시물 입니다.");
		vo.setContents("첫번째 게시물입니다.");
		vo.setCategory("etc");

		int result = dao.insertBoard(vo);

		logger.info("\n Insert Board Result " + result);

		if (result == 1) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}
	}
	/*
	@Test
	public void testModify() {
		BoardDto vo = new BoardDto();
		BoardBiz biz = new BoardBiz();

		vo.setSeq(100);
		vo.setTitle("수정 제목");
		vo.setContents("수정 내용");

		int result = BoardBiz.updateQna(vo);
		log.info("result : " + result);

	}
	 */

	@Ignore
	public void insert() throws Exception {

		BoardDto vo = new BoardDto();


		for( int i = 1; i < 100 ; i++) {

			vo.setTitle(i + " 번째 Q&A.");

			vo.setContents(i + " 번째 Q&A 내용");

			vo.setCategory("etc");

			vo.setU_id("test1");

			int result = dao.insertBoard(vo);

			logger.info("\n Insert Board Result " +result);
			if(result == 1) {
				logger.info("\n 게시물 등록 성공 ");

			} else {

				logger.info("\n 게시물 등록 실패");

			}
		}

	}


	@Ignore
	public void testUpdateViewCnt() throws Exception {
		int result = dao.viewCnt(1);

		logger.info("\n Update View Count Result \n ");

		if (result > 0) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}
	}

	@Ignore
	public void testUpdateBoard() throws Exception {

		BoardDto vo = new BoardDto();

		vo.setSeq(100);
		vo.setTitle("수정- ");
		vo.setContents("MM ");
		int result = dao.updateQna(vo);

		logger.info("\n Update Board Result \n ");

		if (result > 0) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}
	}

	@Ignore

	public void tesDeleteBoard() throws Exception {

		int result = dao.deleteQna(1);

		logger.info("\n Delete Board Result \n ");

		if (result > 0) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}

	}

}
