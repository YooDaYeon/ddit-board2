package aa.board11.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aa.board11.dao.BoardDao;
import aa.board11.dao.IBoardDao;
import aa.board11.model.BoardVO;

@Service
public class BoardService implements IBoardService {

	@Resource(name = "boardDao")
	private IBoardDao boarddao;
	
	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		list = boarddao.boardList();
		
		return list;
	}

	@Override
	public int updateBoard(BoardVO boardvo) {

		return boarddao.updateBoard(boardvo);
	}

	@Override
	public int insertBoard(BoardVO boardvo) {
		
		return boarddao.insertBoard(boardvo);
	}

}
