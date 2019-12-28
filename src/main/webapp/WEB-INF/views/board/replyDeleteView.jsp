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
<script src="${cp}/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="${cp}"> JS커뮤니티 </a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
				<li class="liright"><a href="${cp}/member/modifyForm">정보수정</a></li>
				<li class="liright"><a href="${cp}/member/logout">로그아웃</a></li>
				<li class="liright"><a href="${cp}/member/removeForm">회원탈퇴</a></li>
				<li class="liright"><a href="${cp}/board/boardList">자유게시판</a></li>
			</ul>
		</div>
	</nav>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			$(".cancel_btn").on("click", function(){
				location.href = "boardRead?bno=${replyDelete.bno}"
					   + "&page=${scri.page}"
					   + "&perPageNum=${scri.perPageNum}"
					   + "&searchType=${scri.searchType}"
					   + "&keyword=${scri.keyword}";
			})
			
		})
		
	</script>


	<section id="container">
		<form name="updateForm" role="form" method="post" action="replyDelete">
			<input type="hidden" name="bno" value="${replyDelete.bno}" readonly="readonly"/>
			<input type="hidden" id="rno" name="rno" value="${replyDelete.rno}" />
			<input type="hidden" id="page" name="page" value="${scri.page}"> 
			<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
			<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
			<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
						
			<div>
				<p>삭제 하시겠습니까?</p>
				<button type="submit" class="delete_btn btn btn-Light">예 삭제합니다.</button>
				<button type="button" class="cancel_btn btn btn-Light">아니오. 삭제하지 않습니다.</button>
			</div>
		</form>
	</section>


</body>
</html>