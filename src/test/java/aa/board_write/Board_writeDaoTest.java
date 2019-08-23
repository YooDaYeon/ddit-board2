package aa.board_write;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.board_write.dao.BoardWriteDao;
import aa.board_write.dao.IBoardWriteDao;
import aa.board_write.model.BoardWriteVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class Board_writeDaoTest {

	@Resource(name= "boardWriteDao")
	IBoardWriteDao dao ;

	@Test
	public void boardwriteList() {
		/***Given***/
		int boardId = 1;
		
		/***When***/
		List<BoardWriteVO> list = dao.boardwriteList(boardId);

		/***Then***/	
		assertEquals(27, list.size());
	}
	
	
	@Test
	public void boardWritePaging() {
		/***Given***/
		
		
		/***When***/
		

		/***Then***/		
		
		
	}
	
	
	@Test
	public void boardWriteCnt() {
		/***Given***/
		int boardId = 1;
		
		/***When***/
		int cnt = dao.boardWriteCnt(boardId);

		/***Then***/	
		assertEquals(cnt, 29);
	}
	
	@Test
	public void insertBw() {
		/***Given***/
		BoardWriteVO vo = new BoardWriteVO(1, "brown", "제목이다", "내용이다");
		
		/***When***/
		int cnt = dao.insertBw(vo);

		/***Then***/		
		assertEquals(1, cnt);
	}
	
	@Test
	public void boardWriteDetail() {
		/***Given***/
		int writeId=14;
		
		/***When***/
		BoardWriteVO vo = dao.boardWriteDetail(writeId);

		/***Then***/
		assertEquals(writeId, vo.getWriteId());
	}
	
	@Test
	public void deleteBw() {
		/***Given***/
		int writeId = 2;
		
		/***When***/
		int cnt = dao.deleteBw(writeId);

		/***Then***/
		assertEquals(cnt, 0);
	}
	
	@Test
	public void bwRevice() {
		/***Given***/
		BoardWriteVO vo = new BoardWriteVO(1, "brown", "제목이다", "내용이다");
		
		/***When***/
		int cnt = dao.bwRevice(vo);

		/***Then***/		
		assertEquals(cnt, 0);
	}
	
	
	@Test
	public void replyBw() {
		/***Given***/
		BoardWriteVO vo = new BoardWriteVO(1, "brown", 16, "답글", "답글입니다");
		/***When***/
		int cnt = dao.replyBw(vo);

		/***Then***/		
		assertEquals(cnt, 1);
				
	}
	
	@Test
	public void maxWriteId() {
		/***Given***/
		
		
		/***When***/
		int num = dao.maxWriteId();

		/***Then***/		
		assertEquals(num, 29);
		
	}
	
	@Test
	public void updategroupseq() {
		/***Given***/
		int writeId = 3;
		
		/***When***/
		int cnt = dao.updategroupseq(writeId);

		/***Then***/		
		assertEquals(cnt, 1);
				
		
	}
}
