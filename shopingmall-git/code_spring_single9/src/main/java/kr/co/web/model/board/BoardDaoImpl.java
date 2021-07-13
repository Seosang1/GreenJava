package kr.co.web.model.board;

import java.util.List; 
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kr.co.web.model.board.BoardDto;


@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Inject
	private SqlSession sqlSession;
	

	@Override

	public List<BoardDto> getBoardList() throws Exception {

		return sqlSession.selectList("kr.co.web.mappers.board.boardMapper.getBoardList");

	}

	/*
	@Override
	public void write(BoardDto boardDto) {
		// TODO Auto-generated method stub
		
	}
	*/


	
}
