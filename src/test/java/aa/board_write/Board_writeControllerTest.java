package aa.board_write;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import aa.paging.PageVO;
import aa.testenv.ControllerTestEnv;

public class Board_writeControllerTest extends ControllerTestEnv{


	@Test
	public void deletePostTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/boardWrite/delete")
										.param("boardId", "1")
										.param("writeId","27")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		/***Then***/
		assertEquals(mav.getViewName(), "redirect:/boardWrite/main?boardId=1");
	}
	
	@Test
	public void detailGet() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/boardWrite/detail").param("writeId", "2")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals(mav.getViewName(), "boardWrite/detailBoardWrite");
		
		
	}
	
	@Test
	public void mainGet() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/boardWrite/main")
										.param("boardId", "1")
										.param("page", "2")
										.param("pageSize", "10")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals(mav.getViewName(), "boardWrite/mainBoardWrite");
		
	}
	
	@Test
	public void newGet() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/boardWrite/new")
												.param("boardId", "1")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals(mav.getViewName(), "boardWrite/newBoardWrite");
	}
	
	@Test
	public void newPost() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/boardWrite/new")
								.param("title", "테스트용이야")
								.param("smarteditor", "테스트의 내용")
								.param("boardId", "1")
								.param("file", "파일")
					).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals(mav.getViewName(), "redirect:/boardWrite/detail");
	}
	@Test
	public void replyGet() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/boardWrite/reply")
											.param("writeId", "2")
											.param("boardId", "1")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals(mav.getViewName(),"boardWrite/replyBoardWrite" );
	}
	@Test
	public void replyPost() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/reply")
							.param("writeId", "2")
							.param("boardId", "1")
							.param("title", "와우")
							.param("smarteditor", "수정내용이야")
							.param("file", "file내용")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		
	}
	@Test
	public void reviceGet() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/boardWrite/revice")
										.param("writeId", "2")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals(mav.getViewName(), "boardWrite/reviceBoardWrite");
	}
	@Test
	public void revicePost() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/boardWrite/revice")
										.param("writeId", "10")
										.param("boardId", "1")
										.param("title", "수정하자")
										.param("smarteditor", "수정내용")
										.param("file", "파일이다")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals(mav.getViewName(), "redirect:/boardWrite/detail?boardId=1&writeId=10" );
	}
	
	
	
	

}
