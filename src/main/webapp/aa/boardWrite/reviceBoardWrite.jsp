<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>


<script src="${cp }/SE2/js/HuskyEZCreator.js"></script>
<title>사용자 등록</title>
<%@include file="/aa/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
var oEditors = [];
$(document).ready(function(){
		
	

		//파일
// 		var size = '${size}';	
// 		var max_file_number = 5 - size,
// 		      $form = $('#frm'), 
// 		      $file_upload = $('#file', $form), 
// 		      $button = $('#savebutton', $form); 
// 		  $file_upload.on('change', function () {
// 		    var number_of_images = $(this)[0].files.length;
// 		    if (number_of_images > max_file_number) {
// 		      alert("파일은 5개까지 업로드 할 수 있습니다");
// 		      $(this).val('');
// 		    }
// 		  });
	
		
// 		var inputList = "";
// 		var fileCnt = "";
		
		
// 		$("#plus").on("click", function(){
// 			if($(".fileWrap p").length < 5){
// 				fileCnt = $(".fileWrap input").length; 
// 				inputList = '<p id="fileList'+ fileCnt +'"><input type="file" id="profile" name="profile"><input type="button" onclick="minus('+fileCnt+')" value="-"></p>';
// 				$(".fileWrap").append(inputList);
// 			}
// 		});
		$("#fileadd").on("click",function(){
			if($(".file").length <= 5){
				 $( '#filediv' ).append( '<input type="file" class="file" name="file"/>' );
				}else{
					alert("첨부파일은 5개만 가능합니다");
				}
		
		});
	
		
		
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "${cp }/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true, 
			}
		});

		// 전송버튼 클릭이벤트
		$("#savebutton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				// id가 smarteditor인 textarea에 에디터에서 대입
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

				// 이부분에 에디터 validation 검증
				if(validation()) {
					$("#frm").submit();
				}
			}
		})
		
		//주소찾기 버튼 클릭 이벤트 핸들러
		$("#addrSearchBtn").on("click",function(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		            //주소 input value에 설정 data.roadAddress
		            //우편번호 input value에 설정 data.zonecode
		            console.log
		            $("#addr1").val(data.roadAddress);
		            $("#zipcd").val(data.zonecode);
		            
		            
		            
		        }
		    }).open();
			
		});
		
		//사용자 등록 버튼 클릭 이벤트 핸들러
		$("#userRegBtn").on("click",function(){
			//유효성 체크
			//console.log("userRegBtn click");
			
			//여기까지 도달하면 유효성 검사 완료(submit)
			$("#frm").submit();
			
			
			
		});
		
// 		$("#col10").find("input[type=button]").on("click",function(){
// 			$("#frm").attr("action", "${cp }/attachdelete");
// 			$("#frm").submit();
// 		});
		
		
		
		
// 		$(".delete1").on("click",function(){
// 			$("#frm").attr("action", "${cp }/attachdelete");
// 			$("#frm").submit();
											
// 		});
		
		
		
	});
	
//필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
};

//file 리스트 제거
function minus(minusNum){
	$("#fileList"+minusNum).remove();
};

</script>
</head>

<body>
	<%@include file="/aa/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/aa/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글 수정</h2>
						
						<form id="frm" class="form-horizontal" action="${cp }/boardWrite/revice" role="form" method="post"
							enctype="multipart/form-data"> 
							<input type="hidden" id="boardId" name="boardId" value="${detailvo.boardId}"/>
							<input type="hidden" id="writeId" name="writeId" value="${detailvo.writeId}"/>
							
							<div class="form-group">
								<label for="pass" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="title" name="title" 
									value="${detailvo.title}" placeholder="제목입니다" >
								</div>
							</div>
							
							<div class="form-group">
								<label for="pass" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									<textarea name="smarteditor" id="smarteditor" rows="10" cols="50" 
									 style="width:100%; height:200px;" >${detailvo.writeContent }</textarea>
								</div>
							</div>
						
				
							<div class="form-group">
								<label for="filename" class="col-sm-2 control-label">파일 첨부</label>
								<div class="col-sm-10" >
									<input type="button" class = "form-control" id="fileadd" value="파일추가" />
									<div class="col-sm-10 file" id="filediv" >
										<c:forEach items="${attachList }" var = "attachList" varStatus="i">
											<label class="file control-label" >${attachList.originalFileName}</label>
										    <a href="${cp}/attach/delete?fileId=${attachList.fileId}&writeId=${attachList.writeId}">&nbsp;X</a>
	<%-- 										<button class="delete1" value="${attachList.fileId }" name="fileId${i.index}">x</button> --%>
											
											<br>
											
										</c:forEach>
									</div>
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="pass" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<input type="submit" class="form-control" id="savebutton" name="savebutton" value="저장" >
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>