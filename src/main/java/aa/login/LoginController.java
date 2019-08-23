package aa.login;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aa.board11.model.BoardVO;
import aa.board11.service.IBoardService;
import aa.encrypt.kisa.sha256.KISA_SHA256;
import aa.user.model.UserVO;
import aa.user.service.IUserService;

@Controller
public class LoginController {

	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Resource(name="userService")
	private IUserService userService;
	
	@Resource(name = "boardService")
	private IBoardService boardService;
	
	/**
	 * 사용자 로그인 홤면 요청
	 * @param session
	 * @return
	 */
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public String loginView(HttpSession session) {
		if(session.getAttribute("USER_INFO") != null)
			return "main";
		else
			return "login/login";
	}
	
	/**
	 * 사용자 로그인 요청 처리
	 * @return
	 */
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public String loginProcess(String userId, String pass,
								HttpServletResponse response, HttpSession session) {
		logger.debug("user id log : {}",userId);
		logger.debug("userpass log : {}",pass);
		String encryptPassword = KISA_SHA256.encrypt(pass);
		UserVO userVo = userService.getUser(userId);
		
		if(userVo != null && encryptPassword.equals(userVo.getPass())) {
//		if(userVo != null && pass.equals(userVo.getPass())) {
			
			List<BoardVO> boardlist = boardService.boardList();
			session.setAttribute("USER_INFO", userVo);
			session.setAttribute("BOARDLIST", boardlist);
			
			return "main";
		}
		
		else
			return "login/login";
	}
	
	
	
}
