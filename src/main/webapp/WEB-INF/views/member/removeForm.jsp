<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />

<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="navbar-header">

		<a class="navbar-brand" href="${cp}"> JS커뮤니티 </a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<ul class="nav navbar-nav">			
			<li style="text-align:right"><a href="${cp}/member/modifyForm">정보수정</a></li>
			<li style="text-align:right"><a href="${cp}/member/removeForm">회원탈퇴</a></li>		
		</ul>
	</div>
</nav>

	<br><br>

	<div style="text-align:center;">
		<h1>회원정보 삭제</h1>
	</div>
	
	<form:form action="${cp}/member/remove" method="post" commandName="member">
		<input type="hidden" name="memId" value="${member.memId}">
		<table class="table table-bordered" style="text-align:center border: 1px solid">
			<tr>
				<td style="text-align:center">아이디</td>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<td style="text-align:center">비밀번호</td>
				<td><form:password path="memPw" /></td>
			</tr>
		</table>
		<div style="text-align:center;">		
			<button class="btn btn-light" type="submit">삭제</button>
		</div>
	</form:form>
	
</body>
</html>