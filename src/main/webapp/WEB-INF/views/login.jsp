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
		<div class="vh-100 d-flex justify-content-center align-items-center">
			<div class="container">
				<div class="row d-flex justify-content-center">
					<div class="col-12 col-md-8 col-lg-6">
						<div class="border border-3 border-primary"></div>
						<div class="card bg-white shadow-lg">
							<div class="card-body p-5">
								<form class="mb-3 mt-md-4">
									<h2 class="fw-bold mb-2 text-uppercase ">Board</h2>
									<p class=" mb-5">아이디와 비밀번호를 입력해주세요.</p>
									<div class="mb-3">
										<label for="email" class="form-label ">ID</label> <input
											type="email" class="form-control" id="id"
											placeholder="test1234">
									</div>
									<div class="mb-3">
										<label for="password" class="form-label ">PASSWORD</label> <input
											type="password" class="form-control" id="password"
											placeholder="*******">
									</div>
									<!-- <p class="small"><a class="text-primary" href="forget-password.html">Forgot password?</a></p> -->
									<div class="d-grid">
										<button id="loginBtn" class="btn btn-outline-dark"
											type="button">Login</button>
									</div>
								</form>
								<!-- <div>
	              <p class="mb-0  text-center">Don't have an account? <a href="signup.html"
	                  class="text-primary fw-bold">Sign
	                  Up</a></p>
	            </div> -->

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src='<c:url value="/resources/js/login.js"/>'></script>
</body>
</html>
