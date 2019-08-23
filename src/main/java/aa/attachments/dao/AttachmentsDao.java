package aa.attachments.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import aa.attachments.model.AttachmentsVO;

@Repository
public class AttachmentsDao implements IAttachmentsDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<AttachmentsVO> attachList(int writeId) {
		List<AttachmentsVO> list= sqlSession.selectList("attachments.attachList",writeId);
		return list;
	}

	@Override
	public int attachAdd(AttachmentsVO vo) {
		int cnt = sqlSession.insert("attachments.attachAdd",vo);
		return cnt;
	}

	@Override
	public int attachDelete(int fileId) {
		int cnt = sqlSession.delete("attachments.attachDelete",fileId);
		return cnt;
	}

	@Override
	public AttachmentsVO attachSelect(int fileId) {
		AttachmentsVO vo= sqlSession.selectOne("attachments.attachSelect",fileId);
		return vo;
	}

}
