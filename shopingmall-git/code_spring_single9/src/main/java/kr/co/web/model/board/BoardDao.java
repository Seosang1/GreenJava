package kr.co.web.model.board;

import java.util.List;
 

import kr.co.web.model.board.BoardDto;


public interface BoardDao {  
	

		public List<BoardDto> getBoardList() throws Exception;
		
		/*
		// �Խñ� �ۼ�
		public void write(BoardDto boardDto);
		 */
	}
	
