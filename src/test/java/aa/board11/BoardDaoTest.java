package aa.board11;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.board11.dao.BoardDao;
import aa.board11.dao.IBoardDao;
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
public class BoardDaoTest {

	@Resource(name="boardDao")
	private IBoardDao dao ;
	

	@Test
	public void boardList() {
		/***Given***/
		
		
		/***When***/
		List<BoardVO> list = dao.boardList();

		/***Then***/
		assertEquals(3, list.size());
	}
	
	@Test
	public void updateBoard() {
		
		/***Given***/
		String boardName="똥강아지사랑";
		String boardUseYn = "미사용";
		int boardId = 3;
		
		BoardVO vo = new BoardVO(boardId, boardName, boardUseYn);
		/***When***/
		int cnt = dao.updateBoard(vo);
		
		/***Then***/
		assertEquals(cnt, 0);
	}
	
	
	
	@Test
	public void insertBoard()  {
		/***Given***/
		BoardVO vo = new BoardVO("brown", "똥강아지", "사용");
		/***When***/
		int cnt = dao.insertBoard(vo);
		
		/***Then***/
		assertEquals(1, cnt);
		
		
	}
	

	
	
}
