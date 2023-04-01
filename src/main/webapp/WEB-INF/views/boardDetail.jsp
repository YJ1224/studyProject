<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<title>Home</title>
</head>
<body>
	<%
		String boardId = request.getParameter("boardId");
	%>
	<div class="container">
		<input type="hidden" id="boardId" value="<%=request.getParameter("boardId")%>" />
		<div class="jumbotron text-center">
			<h2>게시판 상세</h2>
		</div>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3" id="title"></td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td id="name"></td>
					<th scope="row">작성 일자</th>
					<td id="createDate"></td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td colspan="3" id="content"></td>
				</tr>
			</tbody>
		</table>
		<div id="btnGroup">
		</div>
	</div>
	<script src='<c:url value="/resources/js/boardDetail.js"/>'></script>
</body>
</html>
