package aa.comments;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.board11.model.BoardVO;
import aa.comments.dao.CommentsDao;
import aa.comments.dao.ICommentsDao;
import aa.comments.model.CommentsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class CommentsDaoTest {

	@Resource(name="commentsDao")
	ICommentsDao dao ;
	

	@Test
	public void commentsList() {
		/***Given***/
		int writeId = 2;
		
		/***When***/
		List<CommentsVO> list = dao.commentsList(writeId);

		/***Then***/
		assertEquals(0, list.size());
	}
	
	@Test
	public void commentsCnt() {
		/***Given***/
		
		
		/***When***/
		int cnt = dao.commentsCnt();
		

		/***Then***/
		assertEquals(8, cnt);
		
	}
	
	@Test
	public void commentsInsert() {
		/***Given***/
		CommentsVO vo = new CommentsVO(17, "brown", "반가워용", "사용");
		
		/***When***/
		int cnt = dao.commentsInsert(vo);
		

		/***Then***/
		assertEquals(1, cnt);
		
	}
	
	@Test
	public void commentsDelete() {
		/***Given***/
		int comid = 1;
		
		/***When***/
		int cnt = dao.commentsDelete(comid);
		

		/***Then***/
		assertEquals(0, cnt);
		
	}
	
	
	
	
	
	
	
	
	

}
