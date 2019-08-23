package aa.user;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aa.user.dao.IUserDao;
import aa.user.dao.UserDao;
import aa.user.model.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class UserDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	@Resource(name="userDao")
	private IUserDao userDao;
	

	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "sally";
		
		/***When***/
		UserVO userVO = userDao.getUser(userId);

		/***Then***/
		//assertEquals("brown", userVO.getUserId());
		assertEquals("샐리", userVO.getName());
		logger.debug("userVO : {}", userVO);
	}


}
