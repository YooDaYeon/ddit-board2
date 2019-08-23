package aa.board11;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.board11.model.BoardVO;
import aa.board11.service.BoardService;
import aa.board11.service.IBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class BoardServiceTest {

	@Resource(name="boardService")
	private IBoardService service ;
	
	@Test
	public void boardList() {
		/***Given***/
		
		
		/***When***/
		List<BoardVO> list = service.boardList();

		/***Then***/
		assertEquals(3, list.size());
	}
	
	@Test
	public void updateBoard() {
		
		/***Given***/
		String boardName="똥강아지사랑a";
		String boardUseYn = "미사용a";
		int boardId = 3;
		
		BoardVO vo = new BoardVO(boardId, boardName, boardUseYn);
		/***When***/
		int cnt = service.updateBoard(vo);
		
		/***Then***/
		assertEquals(cnt, 0);
	}
	
	
	
	@Test
	public void insertBoard() throws ParseException {
		/***Given***/
		BoardVO vo = new BoardVO("brown", "똥강아지", "사용");
		/***When***/
		int cnt = service.insertBoard(vo);
		
		/***Then***/
		assertEquals(1, cnt);
		
		
	}

}
