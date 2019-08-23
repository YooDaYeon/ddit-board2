package aa.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;

import aa.user.model.UserVO;


public class ProfileView implements View{

	
	private static final Logger logger = LoggerFactory.getLogger(ProfileView.class);
	@Override
	public String getContentType() {
		return "img";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("profileView.render()");
		
		UserVO userVo = (UserVO) model.get("userVo");
		
		 //path정보로 file을 읽어온다 
		  ServletOutputStream sos = null;
		  sos = response.getOutputStream();
		  
		  String filePath=null;
		  FileInputStream fis = null;
		  
		  
		  //사용자가 업로드한 파일이 존재할경우
		  if(userVo.getPath()!=null){
		     filePath=userVo.getPath();
		  }
		  
		  //사용자가 업로드한 파일이 존재하지 않을경우
		  
		  else
		     filePath= request.getServletContext().getRealPath("/img/no_image.gif");
		     
		  
		  File file = new File(filePath);
		 
			fis = new FileInputStream(file);
			byte[] buffer = new byte[512];
			while( fis.read(buffer ,0 ,512) !=-1){
				sos.write(buffer);
			}
		fis.close();
		sos.close();
	}

}
