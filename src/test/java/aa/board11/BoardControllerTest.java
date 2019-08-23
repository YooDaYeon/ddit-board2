package aa.board11;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import aa.testenv.ControllerTestEnv;

public class BoardControllerTest extends ControllerTestEnv{

	private static final Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);
	@Test
	public void newGetTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/board/new")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		/***Then***/
		assertEquals("board/newBoard", mav.getViewName());
		
	}
	
	@Test
	public void newPostTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/board/new")
										.param("nboardName", "게시판이름")
										.param("nuse", "사용")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		/***Then***/
		assertEquals(mav.getViewName(), "board/newBoard");
		
		
	}
	
	@Test
	public void reviceTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/board/revice")
									.param("boardId", "1")
									.param("boardName", "일빠")
									.param("use","사용")
				
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals(mav.getViewName(), "redirect:/board/new");
		
	}

}
