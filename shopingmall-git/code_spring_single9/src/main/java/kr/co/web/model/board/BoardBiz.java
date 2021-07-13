package kr.co.web.model.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import kr.co.web.model.board.*; 


public interface BoardBiz {
	
	/*
	public void write(BoardDto boardDtO) throws Exception;
	*/ 
	 
	public List<BoardDto> getBoardList() throws Exception;
}