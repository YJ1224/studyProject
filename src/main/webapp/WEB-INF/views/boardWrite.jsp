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
	<div class="container">
		<div class="jumbotron text-center">
			<h2>게시판 작성</h2>
		</div>
		<div class="mb-3">
			<label for="title" class="form-label">제목</label> <input type="text" class="form-control"
				id="title" placeholder="제목을 입력해주세요.">
		</div>
		<div class="mb-3">
			<label for="content" class="form-label">내용</label>
			<textarea class="form-control" id="content"
				rows="15"></textarea>
		</div>
		<button id="write" type="button" class="btn btn-primary">등록</button>
		<button type="button" class="btn btn-secondary" onclick="window.location = '/main'">취소</button>
	</div>
	<script src='<c:url value="/resources/js/boardWrite.js"/>'></script>
</body>
</html>
