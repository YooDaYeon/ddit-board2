package aa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PartUtil {

	
	private static final String UPLOAD_PATH = "d:\\upload\\";

	/**
	 * 
	* Method : getFileName
	* 작성자 : PC09
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다
	 */
	public static String getFileName(String contentDisposition) {
		// form-data; name="profile"; filename="sally.png"
		String[] splited = contentDisposition.split("; ");
		for(String split : splited)
			if(split.startsWith("filename=")) {
				int startIndex = split.indexOf("\"")+1;
				int lastIndex = split.lastIndexOf("\"");
				return split.substring(startIndex, lastIndex);//이상 ,미만
			}
		
		return "";

	}

	/**
	 * 
	* Method : getExt
	* 작성자 : PC09
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		
//		String ext = "";
//		String[] splited = fileName.split("\\.");
//		if(splited.length == 1)
//			return splited[splited.length-1];
		
		
		//lastIndexOf()는 찾는 문자가 없으면 -1을 반환
		String ext = "";
		int startIndex = fileName.lastIndexOf(".")+1;
		
		if(startIndex != 0)
			ext =  fileName.substring(startIndex);
			
		
		return ext.equals("") ? "" : "." + ext ;
		
	}
	
	/**
	 * 
	* Method : checkUploadFolder
	* 작성자 : PC09
	* 변경이력 :
	* @param yyyy
	* @param mm
	* Method 설명 :연, 월 업로드 폴더가 존재하는지 체크 ,없을 경우 폴더 생성
	 */
	public static void checkUploadFolder(String yyyy, String mm) {
		
		File yyyyFolder = new File(UPLOAD_PATH + yyyy);
		//신규 연도로 넘어갔을 때 해당 연도의 폴더를 생성
		if(!yyyyFolder.exists()) {
			yyyyFolder.mkdir();
		}
		
		//월에 해당하는 폴더가 있는지 확인
		File mmFolder = new File(UPLOAD_PATH + yyyy + File.separator + mm);
		if(!mmFolder.exists()) {
			mmFolder.mkdir();
		}
		
	}
	
	
	public static String getUpLoadPath() {
		//업로드할 폴더 확인
		//연도에 해당하는 폴더가 있는지, 연도안에 월에 해당하는 폴더가 있는지
		Date dt = new Date();
		SimpleDateFormat yyyySdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat mmSdf = new SimpleDateFormat("MM");
		String yyyy = yyyySdf.format(dt);
		String mm = mmSdf.format(dt);
		
		PartUtil.checkUploadFolder(yyyy,mm);
		return UPLOAD_PATH + yyyy + File.separator + mm;
	}
	
	
	
	
	
}
