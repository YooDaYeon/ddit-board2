package aa.comments.model;

import java.util.Date;

public class CommentsVO {
	
	private int comId; //댓글아이디
	private int writeId ;//게시글 아이디(외래키 - board_write)
	private String userId; //작성자(외래키 - users)
	private String comContents; //내용
	private Date comDate; //작성일시
	private String comYn; //댓글 삭제유무
	
	public CommentsVO() {
		
	}

	
	
	public CommentsVO(int writeId, String userId, String comContents, String comYn) {
		super();
		this.writeId = writeId;
		this.userId = userId;
		this.comContents = comContents;
		this.comYn = comYn;
	}



	public CommentsVO(int comId, int writeId, String userId, String comContents, Date comDate, String comYn) {
		super();
		this.comId = comId;
		this.writeId = writeId;
		this.userId = userId;
		this.comContents = comContents;
		this.comDate = comDate;
		this.comYn = comYn;
	}


	public int getComId() {
		return comId;
	}


	public void setComId(int comId) {
		this.comId = comId;
	}


	public int getWriteId() {
		return writeId;
	}


	public void setWriteId(int writeId) {
		this.writeId = writeId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getComContents() {
		return comContents;
	}


	public void setComContents(String comContents) {
		this.comContents = comContents;
	}


	public Date getComDate() {
		return comDate;
	}


	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}


	public String getComYn() {
		return comYn;
	}


	public void setComYn(String comYn) {
		this.comYn = comYn;
	}


	@Override
	public String toString() {
		return "CommentsVO [comId=" + comId + ", writeId=" + writeId + ", userId=" + userId + ", comContents="
				+ comContents + ", comDate=" + comDate + ", comYn=" + comYn + "]";
	}

	
	
	
	
}
