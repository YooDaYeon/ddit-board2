package aa.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import aa.mybatis.MyBatisUtil;
import aa.user.model.UserVO;

@Repository
public class UserDao implements IUserDao{

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserVO getUser(String userId) {
		UserVO user = sqlSession.selectOne("user.getUser",userId);
		return user;
	}

}
