package kr.co.web.model.board;

import java.util.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.web.model.board.BoardDao;

@Service
public class BoardBizImpl implements BoardBiz { 
	
 
	@Inject 
	private BoardDao boardDao;
	

	@Override
	public List<BoardDto> getBoardList() throws Exception {
		return boardDao.getBoardList();
	}	
	 
	
	@Override
	public void insertBoard(BoardDto boardDto) throws Exception {

		boardDao.insertBoard(boardDto);

	}




 
}
