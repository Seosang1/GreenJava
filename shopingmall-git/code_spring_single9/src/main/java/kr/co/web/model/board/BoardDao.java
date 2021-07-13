package kr.co.web.model.board;

import java.util.List;
 

import kr.co.web.model.board.BoardDto;


public interface BoardDao {  
	

		public List<BoardDto> getBoardList() throws Exception;
		
		/*
		// 게시글 작성
		public void write(BoardDto boardDto);
		 */
	}
	
