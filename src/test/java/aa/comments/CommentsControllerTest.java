package aa.comments;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import aa.testenv.ControllerTestEnv;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class CommentsControllerTest extends ControllerTestEnv{


	@Test
	public void deleteTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/comments/delete")
									.param("comId", "5")
									.param("writeId", "107")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		/***Then***/
		assertEquals(mav.getViewName(), "redirect:/boardWrite/detail?writeId=107");
	}

	@Test
	public void insertTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/comments/insert")
							.param("writeId", "25")
							.param("boardId", "1")
							.param("comcontents", "내용입니다")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		/***Then***/
		assertEquals(mav.getViewName(), "redirect:/boardWrite/detail?boardId=1&writeId=25");
		
	}
}
