package aa.user;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.user.model.UserVO;
import aa.user.service.IUserService;
import aa.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class UserServiceTest {

	@Resource(name="userService")
	IUserService service;
	

	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVO userVO = service.getUser(userId);

		/***Then***/
		//assertEquals("brown", userVO.getUserId());
		assertEquals("브라운", userVO.getName());
	}


}
