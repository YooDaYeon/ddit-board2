package aa.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aa.user.dao.IUserDao;
import aa.user.dao.UserDao;
import aa.user.model.UserVO;

@Service
public class UserService implements IUserService{

	@Resource(name="userDao")
	private IUserDao userDao ;
	
	public UserVO getUser(String userId) {
		
		UserVO user;
		user = userDao.getUser(userId);
		
		return user;
	}

}
