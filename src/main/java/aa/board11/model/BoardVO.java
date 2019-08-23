package aa.board11.model;

import java.util.Date;

public class BoardVO {

	private int boardId; //게시판 아이디
	private String userId; //생성자 아이디 (외래키)
	private String boardName; //게시판 이름
	private String boardUseYn; //사용여부
	private Date boardRegDt; //생성일시
	
	
	public BoardVO() {
		
	}

	
	public BoardVO(String userId, String boardName, String boardUseYn) {
		super();
		
		this.userId = userId;
		this.boardName = boardName;
		this.boardUseYn = boardUseYn;
		
	}

	


	public BoardVO(int boardId, String boardName, String boardUseYn) {
		super();
		this.boardId = boardId;
		this.boardName = boardName;
		this.boardUseYn = boardUseYn;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getBoardName() {
		return boardName;
	}


	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}


	public String getBoardUseYn() {
		return boardUseYn;
	}


	public void setBoardUseYn(String boardUseYn) {
		this.boardUseYn = boardUseYn;
	}


	public Date getBoardRegDt() {
		return boardRegDt;
	}


	public void setBoardRegDt(Date boardRegDt) {
		this.boardRegDt = boardRegDt;
	}


	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", userId=" + userId + ", boardName=" + boardName + ", boardUseYn="
				+ boardUseYn + ", boardRegDt=" + boardRegDt + "]";
	}
	
	
	
	
}
