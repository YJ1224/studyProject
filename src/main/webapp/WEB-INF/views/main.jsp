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

<style>

td {
	padding: 5px;
	text-align: center;
}
</style>
<head>
<title>Home</title>
</head>
<body>
	<div class="container" id="main">
		<div class="jumbotron text-center">
			<h2>게시판 목록</h2>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col" class="text-center">제목</th>
					<th scope="col" class="text-center">작성자</th>
					<th scope="col" class="text-center">작성일자</th>
					<th scope="col" class="text-center">수정</th>
					<th scope="col" class="text-center">삭제</th>
				</tr>
			</thead>
			<tbody id="boardTbody">
			</tbody>
		</table>
	</div>
	<div id="modal" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content"></div>
		</div>
	</div>
	<script src='<c:url value="/resources/js/boardList.js"/>'></script>
</body>
</html>
