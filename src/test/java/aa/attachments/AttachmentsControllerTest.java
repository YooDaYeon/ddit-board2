package aa.attachments;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import aa.testenv.ControllerTestEnv;

public class AttachmentsControllerTest extends ControllerTestEnv{


	@Test
	public void deleteTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/attach/delete")
									.param("fileId", "62")
									.param("writeId", "2")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("redirect:/boardWrite/revice?fileId=62&writeId=2", mav.getViewName());
		
		
	}

	
	 @Test
	 public void downTest() throws Exception {
	 	/***Given***/
	 	
	 	/***When***/
	 	MvcResult mvcResult = mockMvc.perform(get("/attach/down")
	 			.param("fileId", "25")
	 			
	 	).andReturn();
	 	ModelAndView mav = mvcResult.getModelAndView();
	 	/***Then***/
	 	assertEquals(null, mvcResult.getModelAndView());
	 }
	 	
	
	
}
