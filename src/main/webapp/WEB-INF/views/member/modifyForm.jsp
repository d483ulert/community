<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />

<title>정보수정</title>
</head>
<body>
<nav class="navbar navbar-default">
	<div class="navbar-header">

		<a class="navbar-brand" style="text-align:center" href="${cp}"> JS커뮤니티 </a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<ul class="nav navbar-nav">
			<li style="text-align:right"><a href="${cp}/member/modifyForm">정보수정</a></li>
			<li style="text-align:right"><a href="${cp}/member/removeForm">회원탈퇴</a></li>
		</ul>
	</div>
</nav>

	<div style="text-align:center;">
		<h1>회원정보 수정</h1>
	</div>
	<form:form action="${cp}/member/modify" method="post" commandName="member">
	  <form:hidden path="memId" value="${member.memId}"/>
		<table class="table table-bordered" style="text-align:center border:1px solid">
			<tr>
				<td style="text-align:center">아이디</td>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<td style="text-align:center">비밀번호</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td style="text-align:center">이메일</td>
				<td><form:input path="memMail" value="${member.memMail}" /></td>
			</tr>
		</table>
		<div style="text-align:center;">		
			<button class="btn btn-light" type="submit">수정</button>
		</div>
	</form:form>
	

	
</body>
</html>