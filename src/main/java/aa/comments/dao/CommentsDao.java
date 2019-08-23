package aa.comments.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import aa.comments.model.CommentsVO;

@Repository
public class CommentsDao implements ICommentsDao {

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CommentsVO> commentsList(int writeId) {
		List<CommentsVO> list = sqlSession.selectList("comments.commentsList",writeId);
		return list;
	}

	@Override
	public int commentsCnt() {
		int cnt = sqlSession.selectOne("comments.commentsCnt");
		return cnt;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		int cnt = sqlSession.insert("comments.commentsInsert",vo);
		return cnt;
	}

	@Override
	public int commentsDelete(int comid) {
		int cnt = sqlSession.update("comments.commentsDelete",comid);
		return cnt;
	}

}
