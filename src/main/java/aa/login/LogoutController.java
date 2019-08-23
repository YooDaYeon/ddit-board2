package aa.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LogoutController {
	
	/**
	 * 사용자 로그아웃 요청 처리
	 * @return
	 */
	@RequestMapping(path="/logout", method = RequestMethod.GET)
	public String loginProcess(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		session.invalidate();
		
		return "login/login";
	}
	
	
	
	
	
}
