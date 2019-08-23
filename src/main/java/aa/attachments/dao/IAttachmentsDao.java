package aa.attachments.dao;

import java.util.List;

import aa.attachments.model.AttachmentsVO;

public interface IAttachmentsDao {

	/**
	 * 
	* Method : attachList
	* 작성자 : PC09
	* 변경이력 :
	* @param writeId
	* @return
	* Method 설명 : 게시글당 첨부파일 리스트 출력
	 */
	List<AttachmentsVO> attachList(int writeId);
	
	/**
	 * 
	* Method : attachAdd
	* 작성자 : PC09
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 첨부파일 입력
	 */
	int attachAdd(AttachmentsVO vo);
	
	/**
	 * 
	* Method : attachDelete
	* 작성자 : PC09
	* 변경이력 :
	* @param fileId
	* @return
	* Method 설명 : 파일삭제
	 */
	int attachDelete(int fileId);
	
	/**
	 * 
	 * @param fileId
	 * @return 
	 *  파일 아이디에 맞는 파일 정보 가져오기
	 */
	AttachmentsVO attachSelect(int fileId);
	
}
