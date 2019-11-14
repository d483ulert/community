<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 보기</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
<script src="${cp}/resources/js/js.js"></script>
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
	<table class="table table-hover">
		<tr>
        	<th>${data.bno}</th>
            <th>${data.title}</th>
            <th>${data.writer}</th>
            <th> <fmt:formatDate value="${data.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
            <th>${data.viewcnt}</th>
        </tr>
        <tr>
        	<td colspan="5">${data.content}</td>
        </tr>
    </table>
   </div>
	<div style="text-align:center;">
	<c:if test="${memId == $memId}">
		<button class="btn btn-Light" onclick="location.href='${cp}/board/updatepage?bno=${data.bno}';">수정</button>
		<button class="btn btn-Light" onclick="location.href='${cp}/board/delete?bno=${data.bno}';">삭제</button>
	</c:if>
		<button class="btn btn-Light" onclick="location.href='${cp}/board/boardList';">글목록</button>
	</div>
</body>
</html>