package kr.co.web.model.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import kr.co.web.Pagination;
import kr.co.web.model.board.BoardDto; 
 

public interface BoardBiz {
	
	public void insertBoard(BoardDto boardDtO) throws Exception;
	
	
	public List<BoardDto> getBoardList(Pagination pagination) throws Exception;
	

	public BoardDto qnaDetail(int seq) throws Exception;
	
	public void deleteQna(int seq) throws Exception;

	public void updateQna(BoardDto boardDto) throws Exception; 

	//총 게시글 개수 확인
	public int getBoardListCnt() throws Exception;

 


}