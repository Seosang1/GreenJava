package kr.co.web.model.board;

import java.util.List;
import java.util.Map;

import kr.co.web.model.board.BoardDto;


public interface BoardDao {  
	

		public List<BoardDto> getBoardList() throws Exception;

		public void insertBoard(BoardDto boardDto) throws Exception;
		 
	}
	
