package aa.board_write.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import aa.board_write.dao.BoardWriteDao;
import aa.board_write.dao.IBoardWriteDao;
import aa.board_write.model.BoardWriteVO;
import aa.paging.PageVO;

@Service
public class BoardWriteService implements IBoardWriteService {

	@Resource(name="boardWriteDao")
	private IBoardWriteDao boardwritedao ;
	private static final Logger logger = LoggerFactory.getLogger(BoardWriteService.class);
	
	@Override
	public List<BoardWriteVO> boardwriteList(int boardId) {
		List<BoardWriteVO> list = boardwritedao.boardwriteList(boardId);
		
		return list;
	}



	@Override
	public int boardWriteCnt(int boardId) {
		int cnt = boardwritedao.boardWriteCnt(boardId);
		return cnt;
	}



	@Override
	public Map<String, Object> boardWritePaging(Map<String, Object> resultMap) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("bwList",boardwritedao.boardWritePaging(resultMap));
		int boardId = (int) resultMap.get("boardId");
		int page = (int) resultMap.get("page");
		int pageSize = (int) resultMap.get("pageSize");
		
		int cnt = boardwritedao.boardWriteCnt(boardId);
		logger.debug("cnt : {}",cnt);
		
		int paginationSize = (int)Math.ceil((double)cnt/pageSize);
		result.put("paginationSize",paginationSize);
		
		return result;
	}



	@Override
	public int insertBw(BoardWriteVO bwvo) {
		int cnt = boardwritedao.insertBw(bwvo);
		return cnt;
	}



	@Override
	public BoardWriteVO boardWriteDetail(int writeId) {
		BoardWriteVO vo = boardwritedao.boardWriteDetail(writeId);
		return vo;
	}



	@Override
	public int deleteBw(int writeId) {
		int cnt = boardwritedao.deleteBw(writeId);
		return cnt;
	}



	@Override
	public int bwRevice(BoardWriteVO bwvo) {
		int cnt = boardwritedao.bwRevice(bwvo);
		return cnt;
	}



	@Override
	public int replyBw(BoardWriteVO bwvo) {
		int cnt = boardwritedao.replyBw(bwvo);
		return cnt;
	}



	@Override
	public int maxWriteId() {
		int max =  boardwritedao.maxWriteId();
		return max;
	}



	@Override
	public int updategroupseq(int writeId) {
		int cnt = boardwritedao.updategroupseq(writeId);
		return cnt;
	}

 

	

}
