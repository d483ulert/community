<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />

<title>Insert title here</title>
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


	<h1>회원정보 수정</h1>
	
	<form:form action="${cp}/member/modify" method="post" commandName="member">
	  <form:hidden path="memId" value="${member.memId}"/>
		<table class="table" style="text-align:center border:1px solid">
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
			<tr>
				<td colspan="2"><input type="submit" value="Modify" ></td>
			</tr>
		</table>
	</form:form>
	
	<div class="center1">
		<a href="${cp}/">메인화면으로</a>
	</div>
	
</body>
</html>