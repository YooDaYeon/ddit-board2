package aa.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "aa/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//SqlSession sqlSession =  sqlSessionFactory.openSession();
			
//			sqlSession.insert(statement);
//			sqlSession.delete(statement);
//			sqlSession.update(statement);
//			sqlSession.selectList(statement);
//			sqlSession.selectOne(statement);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static SqlSession getSqlSession() { //instance없이 호출 가능하게 하려고 static
		return sqlSessionFactory.openSession();
	}
	
	
	
}
