package aa.comments.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aa.comments.model.CommentsVO;
import aa.comments.service.ICommentsService;
import aa.user.model.UserVO;

@RequestMapping("/comments")
@Controller
public class CommentsController {

	@Resource(name="commentsService")
	private ICommentsService comService;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
	
	@RequestMapping("/delete")
	public String delete(String comId,String writeId,Model model) {
		int comId1 = Integer.parseInt(comId);
		int writeId1 = Integer.parseInt(writeId);
		int cnt = comService.commentsDelete(comId1);
		List<CommentsVO> comList = comService.commentsList(writeId1);
		model.addAttribute("comList",comList);
		
		return "redirect:/boardWrite/detail?writeId=" + writeId1;
	}
	
	@RequestMapping("/insert")
	public String insert(String writeId,String boardId,String comcontents, HttpSession session) {
		int writeId1 = Integer.parseInt(writeId);
		int boardId1 = Integer.parseInt(boardId);
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		String userId = user.getUserId();
		logger.debug("comments insert vo log : {}",user);
		
		CommentsVO comvo = new CommentsVO(writeId1, userId, comcontents, "사용");
		int cnt = comService.commentsInsert(comvo);
		
		return "redirect:/boardWrite/detail?boardId=" + boardId1 + "&writeId=" + writeId1;
		
	}
	
	
}
