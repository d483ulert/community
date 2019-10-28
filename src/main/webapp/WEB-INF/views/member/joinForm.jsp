<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>로그인해주세요</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
<nav class="navbar navbar-default">
	<div class="navbar-header">

		<a class="navbar-brand" href="${cp}"> JS커뮤니티 </a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<ul class="nav navbar-nav">
			<li><a href="${cp}/member/loginForm">로그인</a></li>
			<li><a href="${cp}/member/joinForm">회원가입</a></li>
		</ul>
	</div>
</nav>

<br><br>
	<h1 style="text-align:center">회원가입</h1>
	
	<form:form action="${cp}/member/join" method="post" commandName="member">
		<table class="table table-striped" style="text-align:center border:1px solid">
			<tr>
				<td style="text-align:center" >아이디</td>
				<td ><form:input path="memId" /></td>
			</tr>
			<tr>
				<td style="text-align:center" >패스워드</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td style="text-align:center">이메일</td>
				<td><form:input path="memMail" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:right">
					<input type="submit" value="Join" >
					<input type="reset" value="Cancel" >
				</td>
			</tr>
		</table>
</form:form>

	<div style="text-align:center;">
		<a href="${cp}/">메인화면으로</a>
	</div>
</body>
</html>