<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>회원가입해주세요</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/nvd3/1.8.2/nv.d3.min.js"></script>
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
	<h1 style="text-align:center;">회원가입</h1>
	
	
	<form:form action="${cp}/member/join" method="post" commandName="member">
		<table class="table table-bordered" style="text-align:center border:1px solid">
			<tr>
				<td style="text-align:center" >아이디</td>
				<td><form:input path="memId"  /></td>
				
			</tr>
			<tr>
				<td style="text-align:center" >패스워드</td>
				<td><form:password path="memPw"  /></td>
			</tr>
			<tr>
				<td style="text-align:center">이메일</td>
				<td><form:input path="memMail"  /></td>
			</tr>

		</table>
		<div style="text-align:center;">				
			<button class="btn" type="submit">회원가입</button>
			<button class="btn" type="reset">취소</button>
		</div>
	</form:form>

</body>
</html>