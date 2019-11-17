<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>글쓰기</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
<script src="${cp}/resources/js/js.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="${cp}/resources/ckeditor/ckeditor.js"></script>

</head>
<body>
<nav class="navbar navbar-default">
	<div class="navbar-header">

		<a class="navbar-brand" href="${cp}"> JS커뮤니티 </a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<ul class="nav navbar-nav">
			<li class="liright"><a href="${cp}/member/modifyForm">정보수정</a></li>
			<li class="liright"><a href="${cp}/member/logout">로그아웃</a></li>
			<li class="liright"><a href="${cp}/member/removeForm">회원탈퇴</a></li>	
			<li class="liright"><a href="${cp}/board/boardList">자유게시판</a></li>
		</ul>
	</div>
</nav>

	<div class="container">
 		<form name="bdto" method="post" action="${cp}/board/boardWrite">
 			<table class="table table-hover">
 				<tr>
 					<th>제목 <input name="title" id="title" size="10" placeholder="제목"></th>
 			 		
 			 	</tr>
 			 	<tr>
 			 		<th>이름</th>
 				</tr>	
 				
 				<tr>
 					<td><textarea name="content" id="description" rows="10" cols="100" placeholder="내용"></textarea></td>
 				</tr>
 				 <tr>
        			<td>파일첨부
            			<input type="file" name="file1" id="file1"> 
        			</td>
    			</tr>
			</table> 
			<button class="btn btn-Light" type="submit">확인</button>
		</form>
	<script>

	CKEDITOR.replace("description");

	</script> 

	<script>

    var editorConfig = { filebrowserUploadUrl : "/fileUpload.do" };
    
    var ck = null;

    window.onload = function(){
        ck = CKEDITOR.replace("textarea ID" , editorConfig);
    };
	</script>
	
    <script type = "text/javascript">
        window.parent.CKEDITOR.tools.callFunction('${CKEditorFuncNum}','${filePath}', '업로드완료');
    </script>

	
	</div>
</body>
</html>