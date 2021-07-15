package kr.co.web;



import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.web.model.board.BoardDto;
import kr.co.web.model.board.BoardDao;

//Runner 클래스(테스트 메소드를 실행하는 클래스) 를 SpringJUnit4ClassRunner로 함
@RunWith(SpringJUnit4ClassRunner.class)
//location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class BoardDaoTest {
	//DAO 를 구현한 객체 자동으로 생성
	@Inject
	private BoardDao dao;
	 
	@Test
	public void testSelectMember() throws Exception{
		List<BoardDto> vo = dao.getBoardList();
		System.out.println(vo);
	}
	
}
