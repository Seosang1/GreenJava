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

//Runner Ŭ����(�׽�Ʈ �޼ҵ带 �����ϴ� Ŭ����) �� SpringJUnit4ClassRunner�� ��
@RunWith(SpringJUnit4ClassRunner.class)
//location �Ӽ� ��ο� �ִ� xml ������ �̿��ؼ� �������� �ε���
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class BoardDaoTest {
	//DAO �� ������ ��ü �ڵ����� ����
	@Inject
	private BoardDao dao;
	 
	@Test
	public void testSelectMember() throws Exception{
		List<BoardDto> vo = dao.getBoardList();
		System.out.println(vo);
	}
	
}
