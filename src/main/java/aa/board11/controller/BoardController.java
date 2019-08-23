package aa.board11.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aa.board11.model.BoardVO;
import aa.board11.service.IBoardService;
import aa.user.model.UserVO;

@RequestMapping("/board")
@Controller
public class BoardController {

	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Resource(name = "boardService")
	private IBoardService boardService;
	
	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public String newboardGet(Model model) {
		List<BoardVO> boardList = boardService.boardList();
		
		model.addAttribute("boardList", boardList);
		return "board/newBoard";
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public String newboardPost(String nboardName, String nuse, 
								HttpSession session, Model model) {
		
		UserVO vo = (UserVO) session.getAttribute("USER_INFO");
		logger.debug("newboard uservo log : {}",vo);
		
		BoardVO boardvo = new BoardVO(vo.getUserId(), nboardName, nuse);
		
		List<BoardVO> boardList = (List<BoardVO>) session.getAttribute("BOARDLIST");
		
		int insertcnt = boardService.insertBoard(boardvo);
		
		if(insertcnt == 1)
			boardList.add(boardvo);
		
		return "board/newBoard";
	}
	
	@RequestMapping(path = "/revice", method = RequestMethod.POST)
	public String revice(String boardId,String boardName,String use,HttpSession session) {
		int boardId1 = Integer.parseInt(boardId);
		UserVO vo = (UserVO) session.getAttribute("USER_INFO");
		List<BoardVO> boardList = (List<BoardVO>) session.getAttribute("BOARDLIST");
		BoardVO boardvo = new BoardVO(boardId1, boardName, use);
		
		int updatecnt = boardService.updateBoard(boardvo);
		
		for(int i=0;i<boardList.size();i++) {
			if(boardvo.getBoardId() == boardList.get(i).getBoardId()) {
				boardList.get(i).setBoardName(boardvo.getBoardName());
				boardList.get(i).setBoardUseYn(boardvo.getBoardUseYn());
				
			}
			
		}
		
		return "redirect:/board/new";
	}
	
}
