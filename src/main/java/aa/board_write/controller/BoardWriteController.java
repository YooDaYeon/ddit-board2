package aa.board_write.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import aa.attachments.model.AttachmentsVO;
import aa.attachments.service.IAttachmentsService;
import aa.board_write.model.BoardWriteVO;
import aa.board_write.service.IBoardWriteService;
import aa.comments.model.CommentsVO;
import aa.comments.service.ICommentsService;
import aa.paging.PageVO;
import aa.user.model.UserVO;
import aa.util.PartUtil;

@RequestMapping("/boardWrite")
@Controller
public class BoardWriteController {

	private static final Logger logger = LoggerFactory.getLogger(BoardWriteController.class);

	@Resource(name = "boardWriteService")
	private IBoardWriteService bwService;
	@Resource(name = "commentsService")
	private ICommentsService comService;
	@Resource(name = "attachmentsService")
	private IAttachmentsService attachService;

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(String boardId, String writeId, Model model) {

		int boardId1 = Integer.parseInt(boardId);
		int writeId1 = Integer.parseInt(writeId);

		String viewName = "";
		List<BoardWriteVO> list = bwService.boardwriteList(boardId1);
		model.addAttribute("bwList", list);
		model.addAttribute("boardId", boardId);

		int cnt = 0;
		cnt = bwService.deleteBw(writeId1);

		if (cnt != 0) {
			// request.getRequestDispatcher("/mainbw").forward(request, response);
			viewName = "redirect:/boardWrite/main?boardId=" + boardId1;
		}

		return viewName;
	}

	@RequestMapping(path = "/detail", method = RequestMethod.GET)
	public String detail(String writeId, Model model) {
		int writeId1 = Integer.parseInt(writeId);

		List<CommentsVO> comList = comService.commentsList(writeId1);

		BoardWriteVO detailvo = bwService.boardWriteDetail(writeId1);
		model.addAttribute("detailvo", detailvo);
		model.addAttribute("comList", comList);

		// 첨부파일 리스트
		List<AttachmentsVO> attachList = attachService.attachList(writeId1);
		model.addAttribute("attachList", attachList);

		return "boardWrite/detailBoardWrite";
	}

	@RequestMapping(path = "/main", method = RequestMethod.GET)
	public String main(String boardId, PageVO pageVo, Model model) {

		int boardId1 = Integer.parseInt(boardId);
		List<BoardWriteVO> bwlist = bwService.boardwriteList(boardId1);
		logger.debug("bwList : {}", bwlist);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("page", pageVo.getPage());
		resultMap.put("pageSize", pageVo.getPageSize());
		resultMap.put("boardId", boardId1);
		// resultMap.put("bwList", bwlist);

		Map<String, Object> result = bwService.boardWritePaging(resultMap);

		logger.debug("paginationSize : {}",result.get("paginationSize"));
		model.addAttribute("bwList", result.get("bwList"));
		model.addAttribute("paginationSize", result.get("paginationSize"));
		model.addAttribute("pageVO", pageVo);

		return "boardWrite/mainBoardWrite";
	}

	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public String newbw(String boardId, Model model) {
		int boardId1 = Integer.parseInt(boardId);
		model.addAttribute("boardId", boardId1);

		return "boardWrite/newBoardWrite";
	}

	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public String newbwpost(String title, String smarteditor, HttpSession session, Model model,
			String boardId, HttpServletRequest request, MultipartFile[] file) {

		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		String userId = user.getUserId();
		int boardId1 = Integer.parseInt(boardId);

		BoardWriteVO bwvo = new BoardWriteVO(boardId1, userId, title, smarteditor);
		int cnt = bwService.insertBw(bwvo);
		int writeId = bwService.maxWriteId();

		BoardWriteVO vo = bwService.boardWriteDetail(writeId);

		model.addAttribute("boardId", boardId1);
		model.addAttribute("writeId", writeId);

		if (file.length > 0) {
			for(MultipartFile files : file) {
				AttachmentsVO attachvo =null;
				
				String path = PartUtil.getUpLoadPath();
				String ext = PartUtil.getExt(files.getOriginalFilename());
				String fileName = UUID.randomUUID().toString();
				
				File uploadfile = new File(path + File.separator + fileName + ext);
				String filePath = path + File.separator + fileName + ext;
				attachvo = new AttachmentsVO(writeId, filePath, files.getOriginalFilename());
				
				try {
					files.transferTo(uploadfile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				logger.debug("attachvo : {}", attachvo);
				cnt = attachService.attachAdd(attachvo);
			}
		}
		
	
		return "redirect:/boardWrite/detail";
	}

	@RequestMapping(path = "/reply", method = RequestMethod.GET)
	public String replyget(String writeId, String boardId, Model model) {
		int writeId1 = Integer.parseInt(writeId);
		int boardId1 = Integer.parseInt(boardId);

		model.addAttribute("writeId", writeId1);
		model.addAttribute("boardId", boardId1);

		return "boardWrite/replyBoardWrite";
	}

	@RequestMapping(path = "/reply", method = RequestMethod.POST)
	public String replypost(String writeId, String boardId, HttpSession session, String title,
			String smarteditor, HttpServletRequest request,MultipartFile[] file, Model model) {

		int parentId = Integer.parseInt(writeId);
		int boardId1 = Integer.parseInt(boardId);
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		String userId = user.getUserId();
		BoardWriteVO bwvo = new BoardWriteVO(boardId1, userId, parentId, title, smarteditor);
		int cnt = bwService.replyBw(bwvo);

		int writeIdmax = bwService.maxWriteId();
		int cnt1 = bwService.updategroupseq(parentId);

		
		if (file.length > 0) {
			for(MultipartFile files : file) {
				AttachmentsVO attachvo =null;
				
				String path = PartUtil.getUpLoadPath();
				String ext = PartUtil.getExt(files.getOriginalFilename());
				String fileName = UUID.randomUUID().toString();
				
				File uploadfile = new File(path + File.separator + fileName + ext);
				String filePath = path + File.separator + fileName + ext;
				attachvo = new AttachmentsVO(writeIdmax, filePath, files.getOriginalFilename());
				
				try {
					files.transferTo(uploadfile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				logger.debug("attachvo : {}", attachvo);
				cnt = attachService.attachAdd(attachvo);
			}
		}

		return "redirect:/boardWrite/detail?writeId=" + writeIdmax;
	}

	
	@RequestMapping(path = "/revice", method = RequestMethod.GET)
	public String reviceget(String writeId, Model model) {
		int writeId1 = Integer.parseInt(writeId);
		BoardWriteVO detailvo =bwService.boardWriteDetail(writeId1);
		model.addAttribute("detailvo", detailvo);
		
		List<AttachmentsVO> attachList = attachService.attachList(writeId1);
		model.addAttribute("attachList",attachList);
		
		return "boardWrite/reviceBoardWrite";
	}
	
	@RequestMapping(path = "/revice", method = RequestMethod.POST)
	public String revicepost(String writeId, String boardId, String title,
							String smarteditor, Model model, MultipartFile[] file, HttpSession session) {
		int writeId1 = Integer.parseInt(writeId);
		int boardId1 = Integer.parseInt(boardId);
		
		List<AttachmentsVO> attachList = attachService.attachList(writeId1);
		model.addAttribute("attachList",attachList);
		
		BoardWriteVO vo = new BoardWriteVO(writeId1, boardId1, title, smarteditor);
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		int cnt = bwService.bwRevice(vo);
		
		BoardWriteVO detailvo = bwService.boardWriteDetail(writeId1);
		model.addAttribute("detailvo",detailvo);
		
		
		
		if (file.length > 0) {
			for(MultipartFile files : file) {
				AttachmentsVO attachvo =null;
				
				String path = PartUtil.getUpLoadPath();
				String ext = PartUtil.getExt(files.getOriginalFilename());
				String fileName = UUID.randomUUID().toString();
				
				File uploadfile = new File(path + File.separator + fileName + ext);
				String filePath = path + File.separator + fileName + ext;
				attachvo = new AttachmentsVO(writeId1, filePath, files.getOriginalFilename());
				
				try {
					files.transferTo(uploadfile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				logger.debug("attachvo : {}", attachvo);
				cnt = attachService.attachAdd(attachvo);
			}
		}
		
		
		
		
		return "redirect:/boardWrite/detail?boardId=" + boardId1 + "&writeId=" + writeId1;
	}
	
	
	
	
	
	
	
	
}
