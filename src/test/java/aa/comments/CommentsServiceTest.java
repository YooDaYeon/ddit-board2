package aa.comments;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.comments.model.CommentsVO;
import aa.comments.service.CommentsService;
import aa.comments.service.ICommentsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class CommentsServiceTest {

	@Resource(name="commentsService")
	ICommentsService service ;
	
	
	@Test
	public void commentsList() {
		/***Given***/
		int writeId = 2;
		
		/***When***/
		List<CommentsVO> list = service.commentsList(writeId);

		/***Then***/
		assertEquals(0, list.size());
	}
	
	@Test
	public void commentsCnt() {
		/***Given***/
		
		
		/***When***/
		int cnt = service.commentsCnt();
		

		/***Then***/
		assertEquals(7, cnt);
		
	}
	
	@Test
	public void commentsInsert() {
		/***Given***/
		CommentsVO vo = new CommentsVO(6, "brown", "반가워용", "사용");
		
		/***When***/
		int cnt = service.commentsInsert(vo);
		

		/***Then***/
		assertEquals(1, cnt);
		
	}
	
	@Test
	public void commentsDelete() {
		/***Given***/
		int comid = 1;
		
		/***When***/
		int cnt = service.commentsDelete(comid);
		

		/***Then***/
		assertEquals(0, cnt);
		
	}

}
