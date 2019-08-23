package aa.board_write.model;

import java.util.Date;

public class BoardWriteVO {

	private int writeId; //게시글아이디
	private int boardId; //게시판아이디(외래키 - board11)
	private String userId; //작성자 (외래키 - users)
	private int parentId; //부모게시글 아이디 (댓글달때 쓸것)
	private String title; //제목
	private String writeContent; //내용
	private Date writeDate; //작성일시
	private String writeUseYn;//사용여부
	private int lv;
	private int rn;
	
	public BoardWriteVO() {
		
	}

	
	public BoardWriteVO(int writeId, int boardId, String title, String writeContent) {
		super();
		this.writeId = writeId;
		this.boardId = boardId;
		this.title = title;
		this.writeContent = writeContent;
	}


	

	public BoardWriteVO(int writeId, int boardId) {
		super();
		this.writeId = writeId;
		this.boardId = boardId;
	}
	
	public BoardWriteVO(int writeId) {
		super();
		this.writeId = writeId;
	}



	//게시글 답글 등록
	public BoardWriteVO(int boardId, String userId, int parentId, String title, String writeContent) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.parentId = parentId;
		this.title = title;
		this.writeContent = writeContent;
	}


	//첫번째 게시글 입력 시 사용
	public BoardWriteVO(int boardId, String userId, String title, String writeContent) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.writeContent = writeContent;
	}
	
	
	
	
	public int getRn() {
		return rn;
	}


	public void setRn(int rn) {
		this.rn = rn;
	}


	public int getLv() {
		return lv;
	}



	public void setLv(int lv) {
		this.lv = lv;
	}



	public int getWriteId() {
		return writeId;
	}


	public void setWriteId(int writeId) {
		this.writeId = writeId;
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriteContent() {
		return writeContent;
	}

	public void setWriteContent(String writeContent) {
		this.writeContent = writeContent;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getWriteUseYn() {
		return writeUseYn;
	}

	public void setWriteUseYn(String writeUseYn) {
		this.writeUseYn = writeUseYn;
	}

	@Override
	public String toString() {
		return "BoardWriteVO [writeId=" + writeId + ", boardId=" + boardId + ", userId=" + userId + ", parentId="
				+ parentId + ", title=" + title + ", writeContent=" + writeContent + ", writeDate=" + writeDate
				+ ", writeUseYn=" + writeUseYn + "]";
	}

	
	
	
	
}
