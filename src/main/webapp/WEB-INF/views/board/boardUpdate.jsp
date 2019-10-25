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
	<form name ="updateform" method="POST" action="${cp}/board/boardUpdate">
		<div>글번호</div>
		<div><input name="bno" value="${data.bno}" type="text" readonly="readonly"></div>
		<div>작성자</div>	
		<div><input name="writer" value="${data.writer}" type="text" readonly="readonly"></div>
		<div>게시글제목:</div>	
		<div><input name="title" value="${data.title}" type="text" readonly="readonly"></div>
		<div>게시글내용</div>	
		<div><textarea name="content" rows="10" cols="100">${data.content }</textarea></div>
		<div>조회수</div>	
        <div><input name="viewcnt" value="${data.viewcnt}" type="text" readonly="readonly"/></div>
        <div>작성일자</div>
        <div><fmt:formatDate value="${data.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
        
		<div>
			<input type="submit" value="글수정"/>
			<input type="reset" value="리셋"/>
		</div>
	</form>


</body>
</html>