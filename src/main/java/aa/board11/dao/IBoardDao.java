package aa.board11.dao;

import java.util.List;

import aa.board11.model.BoardVO;


public interface IBoardDao {

	/**
	 * 
	* Method : boardList
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	 */
	List<BoardVO> boardList();
	
	/**
	 * 
	* Method : updateBoard
	* 작성자 : PC09
	* 변경이력 :
	* @param boardvo
	* @return
	* Method 설명 : 게시판 수정
	 */
	int updateBoard(BoardVO boardvo);
	
	/**
	 * 
	* Method : insertBoard
	* 작성자 : PC09
	* 변경이력 :
	* @param boardvo
	* @return
	* Method 설명 : 게시판 생성
	 */
	int insertBoard(BoardVO boardvo);
	
}
