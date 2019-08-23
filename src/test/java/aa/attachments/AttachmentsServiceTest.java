package aa.attachments;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.attachments.model.AttachmentsVO;
import aa.attachments.service.AttachmentsService;
import aa.attachments.service.IAttachmentsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class AttachmentsServiceTest {

	@Resource(name="attachmentsService")
	private IAttachmentsService service;
	
	
	@Test
	public void attachList() {
		
		/***Given***/
		int writeId = 2;
		
		/***When***/
		List<AttachmentsVO> list = service.attachList(writeId);

		/***Then***/
		assertEquals(0, list.size());
	}

	@Test
	public void attachAdd() {
		
		/***Given***/
		AttachmentsVO vo = new AttachmentsVO(3, "file경로1", "원본파일명1");
		
		/***When***/
		int cnt = service.attachAdd(vo);
		
		/***Then***/
		assertEquals(1, cnt);
		
	}
	
	@Test
	public void attachDelete() {
		/***Given***/
		int fileId = 1;
		/***When***/
		int cnt = service.attachDelete(fileId);
		
		
		/***Then***/
		assertEquals(cnt, 0);
		
	}
	
	@Test
	public void attachSelect() {
		/***Given***/
		int fileId = 24;
		
		/***When***/
		AttachmentsVO vo = service.attachSelect(fileId);
		
		/***Then***/
		assertEquals(fileId, vo.getFileId());
		
	}
	
	
}
