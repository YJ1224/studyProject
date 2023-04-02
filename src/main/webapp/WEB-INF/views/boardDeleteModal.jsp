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
	<input type="hidden" id="boardId" value="<%=request.getParameter("boardId")%>" />
      <div class="modal-header">
        <h5 class="modal-title">게시판 삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true">x</button>
      </div>
      <div class="modal-body">
        <p>정말로 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="boardDelete()">네</button>
      </div>
      <script>
      	function boardDelete(){
      		$.ajax({
      			url : '/board/delete',
      			type : 'DELETE',
      			contentType : 'application/json; charset=UTF-8',
      			headers : {
      				'Authorization' : sessionStorage.getItem('AccessToken')
      			},
      			data : JSON.stringify({
      				board_id : $("#boardId").val()
      			}),
      			dataType : 'json',
      			success : function(data) { // 성공
      				if(data.result == "OK"){
    					alert("게시물 삭제가 완료되었습니다.");
    					location.reload();
    				}else{
    					alert(data.reason);
    				}
      			},
      			error : function(data) { // 실패
      				alert("관리자에게 문의바랍니다.");
      			}
      		})
      	}
      </script>
</body>
</html>
