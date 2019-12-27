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
	<script type="text/javascript">
		
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/page/board/updateView");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				
				var deleteYN = confirm("삭제하시겠습니까?");
				if(deleteYN == true){
					
				formObj.attr("action", "/page/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
					
				}
			})
			
			// 목록
			$(".list_btn").on("click", function(){
				
				location.href = "/page/board/list?page=${scri.page}"
						      +"&perPageNum=${scri.perPageNum}"
						      +"&searchType=${scri.searchType}&keyword=${scri.keyword}";
			})

			
			$(".replyWriteBtn").on("click", function(){
				var formObj = $("form[name='replyForm']");
				formObj.attr("action", "replyWrite");
				formObj.submit();
			});
			
			//댓글 수정 View
			$(".replyUpdateBtn").on("click", function(){
				location.href = "/page/board/replyUpdateView?bno=${read.bno}"
								+ "&page=${scri.page}"
								+ "&perPageNum=${scri.perPageNum}"
								+ "&searchType=${scri.searchType}"
								+ "&keyword=${scri.keyword}"
								+ "&rno="+$(this).attr("data-rno");
			});
			
			//댓글 삭제 View
			$(".replyDeleteBtn").on("click", function(){
				location.href = "/page/board/replyDeleteView?bno=${read.bno}"
					+ "&page=${scri.page}"
					+ "&perPageNum=${scri.perPageNum}"
					+ "&searchType=${scri.searchType}"
					+ "&keyword=${scri.keyword}"
					+ "&rno="+$(this).attr("data-rno");
			});
		})
	</script>
	
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
	<table class="table table-borderd">
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
   <div id="container">
    		<c:forEach items="${replyList}" var="replyList">
      			<li>
        			<p>
        			작성자 : ${replyList.writer}<br />
        			작성 날짜 :  <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
        			</p>
        			<p>${replyList.content}</p>
        			
        			<c:if test="${member.memId == replay.writer}">
        				<div>
  							<button type="button" class="replyUpdateBtn" data-rno="${replyList.rno}">수정</button>
  							<button type="button" class="replyDeleteBtn" data-rno="${replyList.rno}">삭제</button>
						</div>
					</c:if>
      			</li>
    		</c:forEach>   
	</div>
	<form name="replyForm" method="POST">
		<input type="hidden" id="bno" name="bno" value="${data.bno}" /> 
		<input type="hidden" id="page" name="page" value="${scri.page}"> 
		<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
		<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}">
		<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}">
		
		<div class="form-group">
			<label for="writer" class="col-sm-2 control-label">${member.memId}</label>
			<div class="col-sm-10">
				 <input type="hidden" name="writer" id="writer" value="${member.memId}">
			</div>
		</div>

		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">댓글 내용</label>
			<div class="col-sm-10">
				<input type="text" id="content" name="content" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="replyWriteBtn btn btn-success">작성</button>
			</div>
		</div>
	</form>
<br>


	<div style="text-align:center;">
	<c:if test="${member.memId == data.writer}">
		<button class="btn btn-Light" onclick="location.href='${cp}/board/updatepage?bno=${data.bno}';">수정</button>
		<button class="btn btn-Light" onclick="location.href='${cp}/board/delete?bno=${data.bno}';">삭제</button>
	</c:if>
		<button class="btn btn-Light" onclick="location.href='${cp}/board/boardList';">글목록</button>
	</div>
</body>
</html>