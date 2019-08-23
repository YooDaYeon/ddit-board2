package aa.attachments;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.attachments.dao.AttachmentsDao;
import aa.attachments.dao.IAttachmentsDao;
import aa.attachments.model.AttachmentsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class AttachmentsDaoTest {

	@Resource(name="attachmentsDao")
	private IAttachmentsDao dao ;
	

	@Test
	public void attachAdd() {
		/***Given***/
		AttachmentsVO vo = new AttachmentsVO(3, "file경로1", "원본파일명1");
		
		/***When***/
		int cnt = dao.attachAdd(vo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void attachList() {
		/***Given***/
		List<AttachmentsVO> list ;
		int writeId = 2;
		/***When***/
		list = dao.attachList(writeId);
		
		/***Then***/
		assertEquals(0, list.size());
		
	}
	
	@Test
	public void attachDelete() {
		/***Given***/
		int fileId = 1;
		/***When***/
		int cnt = dao.attachDelete(fileId);
		
		
		/***Then***/
		assertEquals(cnt, 0);
		
	}
	
	@Test
	public void attachSelect() {
		/***Given***/
		int fileId = 24;
		
		/***When***/
		AttachmentsVO vo = dao.attachSelect(fileId);
		
		/***Then***/
		assertEquals(fileId, vo.getFileId());
		
	}

}
