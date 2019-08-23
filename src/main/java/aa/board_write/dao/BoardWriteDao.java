package aa.board_write.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import aa.board_write.model.BoardWriteVO;
import aa.mybatis.MyBatisUtil;
import aa.paging.PageVO;

@Repository
public class BoardWriteDao implements IBoardWriteDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardWriteDao.class);

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardWriteVO> boardwriteList(int boardId) {
		List<BoardWriteVO> list = sqlSession.selectList("boardwrite.bwList", boardId);
		return list;
	}

	@Override
	public List<BoardWriteVO> boardWritePaging(Map<String, Object> resultMap) {
		List<BoardWriteVO> list = sqlSession.selectList("boardwrite.bwPagingList", resultMap);
		return list;
	}

	@Override
	public int boardWriteCnt(int boardId) {
		int cnt = sqlSession.selectOne("boardwrite.bwCnt",boardId);
		return cnt;
	}

	@Override
	public int insertBw(BoardWriteVO bwvo) {
		int cnt = sqlSession.insert("boardwrite.bwInsert",bwvo);
		return cnt;
	}

	@Override
	public BoardWriteVO boardWriteDetail(int writeId) {
		BoardWriteVO vo = sqlSession.selectOne("boardwrite.bwDetail",writeId);
		return vo;
	}

	@Override
	public int deleteBw(int writeId) {
		int cnt = sqlSession.update("boardwrite.bwDelete",writeId);
		return cnt;
	}

	@Override
	public int bwRevice(BoardWriteVO bwvo) {
		int cnt = sqlSession.update("boardwrite.bwRevice", bwvo);
		return cnt;
	}

	@Override
	public int replyBw(BoardWriteVO bwvo) {
		int cnt = sqlSession.insert("boardwrite.bwReply",bwvo);
		return cnt;
	}

	@Override
	public int maxWriteId() {
		int max = sqlSession.selectOne("boardwrite.maxWriteId");
		return max;
	}

	@Override
	public int updategroupseq(int writeId) {
		int cnt = sqlSession.update("boardwrite.updategroupseq", writeId);
		return cnt;
	}



}
