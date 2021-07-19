package kr.co.web.model.board;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.web.Pagination;

@Service
public class BoardBizImpl implements BoardBiz {


	@Inject
	private BoardDao boardDao;


	@Override
	public List<BoardDto> getBoardList(Pagination pagination) throws Exception {
		return boardDao.getBoardList(pagination);
	}


	@Override
	public void insertBoard(BoardDto boardDto) throws Exception {

		boardDao.insertBoard(boardDto);

	}

	@Override
	public BoardDto qnaDetail(int seq) throws Exception{
		boardDao.viewCnt(seq);
		return boardDao.qnaDetail(seq);

	}
	@Override
	public void updateQna(BoardDto boardDto) throws Exception {
		boardDao.updateQna(boardDto);

	}

	@Override
	public void deleteQna(int seq) throws Exception {
		boardDao.deleteQna(seq);

	}

	// 총 게시글 개수 확인
	@Override

	public int getBoardListCnt() throws Exception {

		return boardDao.getBoardListCnt();

	}











}
