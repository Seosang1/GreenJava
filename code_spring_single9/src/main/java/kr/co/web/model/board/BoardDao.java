package kr.co.web.model.board;

import java.util.List;

import kr.co.web.Search;


public interface BoardDao {


	public List<BoardDto> getBoardList(Search search) throws Exception;

	public int insertBoard(BoardDto boardDto) throws Exception;

	public BoardDto qnaDetail(int seq) throws Exception;

	public int updateQna(BoardDto boardDto) throws Exception;

	public int deleteQna(int seq) throws Exception;

	public int viewCnt(int seq) throws Exception;

	public int getBoardListCnt(Search search) throws Exception;

	public List<BoardDto> getReplyList(int seq) throws Exception;

	public int saveReply(BoardDto boardDto) throws Exception;

	public int updateReply(BoardDto boardDto) throws Exception;

	public int deleteReply(int rid) throws Exception;




}

