package aa.comments.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aa.comments.dao.ICommentsDao;
import aa.comments.model.CommentsVO;

@Service
public class CommentsService implements ICommentsService {

	@Resource(name="commentsDao")
	private ICommentsDao commentsDao ;
	
	
	@Override
	public List<CommentsVO> commentsList(int writeId) {
		List<CommentsVO> list = commentsDao.commentsList(writeId);
		return list;
	}

	@Override
	public int commentsCnt() {
		int cnt = commentsDao.commentsCnt();
		return cnt;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		int cnt = commentsDao.commentsInsert(vo);
		return cnt;
	}

	@Override
	public int commentsDelete(int comid) {
		int cnt = commentsDao.commentsDelete(comid);
		return cnt;
	}

}
