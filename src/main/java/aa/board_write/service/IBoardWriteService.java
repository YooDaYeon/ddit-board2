package aa.board_write.service;

import java.util.List;
import java.util.Map;

import aa.board_write.model.BoardWriteVO;
import aa.paging.PageVO;

public interface IBoardWriteService {

	/**
	 * 
	* Method : boardwriteList
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 게시판에 맞는 게시글 전체 출력
	 */
	List<BoardWriteVO> boardwriteList(int boardId);
	
	/**
	 * 
	* Method : boardWritePaging
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 페이징한 게시글
	 */
	Map<String, Object> boardWritePaging(Map<String, Object> resultMap);
	
	/**
	* Method : boardWriteCnt
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 게시판에 해당하는 게시글 전체 수 조회
	 */
	int boardWriteCnt(int boardId);
	
	/**
	 * 
	* Method : insertBw
	* 작성자 : PC09
	* 변경이력 :
	* @param bwvo
	* @return
	* Method 설명 : 게시글 신규 생성
	 */
	int insertBw(BoardWriteVO bwvo);
	
	/**
	 * 
	* Method : replyBw
	* 작성자 : PC09
	* 변경이력 :
	* @param bwvo
	* @return
	* Method 설명 : 게시글 답글 생성
	 */
	int replyBw(BoardWriteVO bwvo);
	
	
	/**
	 * 
	* Method : boardWriteDetail
	* 작성자 : PC09
	* 변경이력 :
	* @param bwvo
	* @return
	* Method 설명 : 게시글 상세보기
	 */
	BoardWriteVO boardWriteDetail(int writeId);
	
	/**
	 * 
	* Method : deleteBw
	* 작성자 : PC09
	* 변경이력 :
	* @param bwvo
	* @return
	* Method 설명 : 게시글 삭제하기 ( 수정)
	 */
	int deleteBw(int writeId);
	
	/**
	 * 
	* Method : bwRevice
	* 작성자 : PC09
	* 변경이력 :
	* @param bwvo
	* @return
	* Method 설명 : 게시글 수정하기
	 */
	int bwRevice(BoardWriteVO bwvo);
	
	/**
	 * 
	* Method : maxWriteId
	* 작성자 : PC09
	* 변경이력 :  게시글 최대값 구하기
	* @return
	* Method 설명 :
	 */
	int maxWriteId();
	
	/**
	 * 
	* Method : updategroupseq
	* 작성자 : PC09
	* 변경이력 :
	* @param writeId
	* @return
	* Method 설명 : 그룹 시퀀스 수정
	 */
	int updategroupseq(int writeId);
	
}
