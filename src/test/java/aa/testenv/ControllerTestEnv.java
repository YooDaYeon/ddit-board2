package aa.testenv;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:aa/spring/application-context.xml",
	"classpath:aa/spring/root-context.xml",
	"classpath:aa/spring/application-datasource.xml",
	"classpath:aa/spring/application-transaction.xml"})
@WebAppConfiguration
public class ControllerTestEnv {
	
	@Resource(name="datasource")
	private DataSource datasource;
	
	@Autowired
	protected WebApplicationContext ctx;//webAppliacationContext spring container
	protected MockMvc mockMvc; //mockMvc  //dispatcher servlet
	
	 @Before
	 public void setup() {
		 mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		 
	 }
	 
	 @Ignore // 무시함
	 @Test
	 public void dummy() {};
}
