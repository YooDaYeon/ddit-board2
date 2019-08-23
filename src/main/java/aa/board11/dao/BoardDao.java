package aa.board11.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import aa.board11.model.BoardVO;
import aa.mybatis.MyBatisUtil;

@Repository
public class BoardDao implements IBoardDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> list = sqlSession.selectList("board.boardList");
		return list;
	}

	@Override
	public int updateBoard(BoardVO boardvo) {
		int cnt = sqlSession.update("board.updateBoard",boardvo);
		return cnt;
		
	}

	@Override
	public int insertBoard(BoardVO boardvo) {
		int cnt = sqlSession.insert("board.insertBoard",boardvo);
		return cnt;
	}

}
