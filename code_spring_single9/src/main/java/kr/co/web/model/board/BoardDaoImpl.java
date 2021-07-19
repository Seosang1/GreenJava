package kr.co.web.model.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.web.Pagination;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Inject
	private SqlSession sqlSession;


	@Override

	public List<BoardDto> getBoardList(Pagination pagination) throws Exception {

		return sqlSession.selectList("kr.co.web.mappers.board.boardMapper.getBoardList", pagination);

	}

	@Override
	public int insertBoard(BoardDto boardDto) {
		return sqlSession.insert("kr.co.web.mappers.board.boardMapper.insertBoard", boardDto);
	}



	@Override
	public BoardDto qnaDetail(int seq) throws Exception {
		return sqlSession.selectOne("kr.co.web.mappers.board.boardMapper.qnaDetail", seq);
	}

	@Override
	public int updateQna(BoardDto boardDto) throws Exception {
		return sqlSession.update("updateQna", boardDto);
	}




	@Override
	public int deleteQna(int seq) throws Exception {
		return sqlSession.delete("kr.co.web.mappers.board.boardMapper.deleteQna", seq);
	}

	@Override
	public int viewCnt(int seq) throws Exception {
		return sqlSession.update("kr.co.web.mappers.board.boardMapper.viewCnt", seq);
	}


	// 총 게시글 개수 확인
	@Override

	public int getBoardListCnt() throws Exception {

		return sqlSession.selectOne("kr.co.web.mappers.board.boardMapper.getBoardListCnt");

	}















}
