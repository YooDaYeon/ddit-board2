package aa.attachments.model;

public class AttachmentsVO {

	private int fileId; //첨부파일아이디
	private int writeId; //게시글아이디
	private String filePath; //첨부파일경로
	private String originalFileName; //원본파일명
	
	
	public AttachmentsVO() {
		
	}


	public int getFileId() {
		return fileId;
	}


	public void setFileId(int fileId) {
		this.fileId = fileId;
	}


	public int getWriteId() {
		return writeId;
	}


	public void setWriteId(int writeId) {
		this.writeId = writeId;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getOriginalFileName() {
		return originalFileName;
	}


	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}


	public AttachmentsVO(int writeId, String filePath, String originalFileName) {
		super();
		this.writeId = writeId;
		this.filePath = filePath;
		this.originalFileName = originalFileName;
	}


	
	
	
	
	
	
	
	
	
	
}
