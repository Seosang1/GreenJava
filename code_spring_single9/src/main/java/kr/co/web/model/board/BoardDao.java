package kr.co.web.model.board;

import java.util.List;
import java.util.Map;

import kr.co.web.Pagination;
import kr.co.web.model.board.BoardDto;


public interface BoardDao {  
	  

		public List<BoardDto> getBoardList(Pagination pagination) throws Exception;

		public int insertBoard(BoardDto boardDto) throws Exception; 
		
		public BoardDto qnaDetail(int seq) throws Exception;

		public int updateQna(BoardDto boardDto) throws Exception;

		public int deleteQna(int seq) throws Exception;

		public int viewCnt(int seq) throws Exception;
		
		//총 게시글 개수 확인
		public int getBoardListCnt() throws Exception;

		 
	}
	
