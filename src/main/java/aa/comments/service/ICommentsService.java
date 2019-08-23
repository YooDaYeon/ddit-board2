package aa.comments.service;

import java.util.List;

import aa.comments.model.CommentsVO;

public interface ICommentsService {
	

	//댓글 리스트
	List<CommentsVO> commentsList(int writeId);

	//전체 댓글 개수
	int commentsCnt();

	//댓글 입력
	int commentsInsert(CommentsVO vo);

	//댓글 삭제
	int commentsDelete(int comid);
}
