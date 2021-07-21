package kr.co.web.model.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.web.Search;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<BoardDto> getBoardList(Search search) throws Exception {
		return sqlSession.selectList("kr.co.web.mappers.board.boardMapper.getBoardList", search);
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
		Integer result = sqlSession.update("kr.co.web.mappers.board.boardMapper.updateQna", boardDto);
		System.out.println("BoardDaoImpl result : " + result);

		return sqlSession.update("kr.co.web.mappers.board.boardMapper.updateQna", boardDto);
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
	public int getBoardListCnt(Search search) throws Exception {
		return sqlSession.selectOne("kr.co.web.mappers.board.boardMapper.getBoardListCnt", search);
	}




	// 댓글기능
	@Override
	public List<BoardDto> getReplyList(int seq) throws Exception {
		return sqlSession.selectList("kr.co.web.mappers.board.replyMapper.getReplyList", seq);
	}

	@Override
	public int saveReply(BoardDto boardDto) throws Exception {
		return sqlSession.insert("kr.co.web.mappers.board.replyMapper.saveReply", boardDto);
	}

	@Override
	public int updateReply(BoardDto boardDto) throws Exception {
		return sqlSession.update("kr.co.web.mappers.board.replyMapper.updateReply", boardDto);
	}

	@Override
	public int deleteReply(int rid) throws Exception {
		return sqlSession.delete("kr.co.web.mappers.board.replyMapper.deleteReply", rid);
	}















}
