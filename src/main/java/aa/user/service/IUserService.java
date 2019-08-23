package aa.user.service;

import aa.user.model.UserVO;

public interface IUserService {

	/**
	 * 
	* Method : getUser
	* 작성자 : PC09
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	UserVO getUser(String userId);
	
	
	
	
}
