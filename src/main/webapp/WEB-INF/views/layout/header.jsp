<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<title>Home</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#"> BoardService </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				</li>
				<li class="nav-item active"><a class="nav-link" href="/main">게시판
						목록</a></li>
				<li class="nav-item active"><a class="nav-link" href="/boardWrite">게시판
						작성</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<div class="container-fluid">
					<span class="navbar-text" id="userName"></span>
					<span class="navbar-text">로그아웃</span>
				</div>
			</form>
		</div>
	</nav>
	
	<script>
	$(document).ready(function() {
		$.ajax({
			url: '/user/info',
			type: 'GET',
			contentType:'application/json; charset=UTF-8',
			headers : {
				'Authorization' : sessionStorage.getItem('AccessToken')
			},
			dataType: 'json',
			success : function(data){ //성공
				if(data.result == "OK"){
					$("#userName").append(data.data.name+"님");
				}else{
					window.location = "/login";
				}
			},
			error : function(data){ //실패
				alert("관리자에게 문의바랍니다.");
			}
		})

	});
	</script>
</body>
</html>
