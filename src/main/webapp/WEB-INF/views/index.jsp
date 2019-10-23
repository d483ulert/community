<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
<script src="${cp}/resources/js/js.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


</head>
<body>

	<c:if test="${empty member}">

<nav class="navbar navbar-default">
	<div class="navbar-header">

		<a class="navbar-brand" href="${cp}"> JS커뮤니티 </a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<ul class="nav navbar-nav">
			<li class="liright"><a href="${cp}/member/loginForm">로그인</a></li>
			<li class="liright"><a href="${cp}/member/joinForm">회원가입</a></li>
			<li class="liright"><a onclick="loginplz();">자유게시판</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		function loginplz(){
			alert("로그인을 먼저해 주세요.");
			location.href="${cp}/member/loginForm";
		}
	</script>
</nav>

	<div class="images">
		<img src="resources/img/1.jpg" id =mainImage alt="Image" style="width:600px; height:500px; align:center;">
	</div>
	<footer class=modal-footer>

		<h4 style=text-align:center;>안녕하세요. 한신대학교 컴퓨터공학과를 재학중인 김지성입니다.</h4>
		<h4 style="text-align:center;">spring, jsp,mybatis, oracle을 이용해 웹 페이지를 제작해봤습니다.</h4>
		<h4 style="text-align:center;">제작기간은 한달입니다.</h4>
	</footer>
	
	</c:if>
	
	<c:if test="${!empty member}">
	
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
	<div class="images">
		<img src="resources/img/1.jpg" id =mainImage alt="Image" style="width:600px; height:500px; align:center;">
	</div>
	
	<footer class=modal-footer>
		<h4 style=text-align:center;>자유로운 커뮤니티 입니다.</h4>
		<h4 style="text-align:center;">Copyright 2019 welcome JS Community All Right Reserved.</h4>
	</footer>
	</c:if>
	
</body>
</html>