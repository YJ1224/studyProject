$(document).ready(function() {
	if(!$("#boardId").val()){
		alert("게시글이 존재하지 않습니다.");
		window.location = "/main";
	}else{
		boardDetail();
	}
	

});

function boardMove (){
	window.location = "/main";
}

function move(){
	var form = document.createElement('form');
	var objs;
	objs = document.createElement('input'); // 값이 들어있는 녀석의 형식
	objs.setAttribute('type', 'text'); // 값이 들어있는 녀석의 type
	objs.setAttribute('name', 'boardId'); // 객체이름
	objs.setAttribute('value', $("#boardId").val()); //객체값
	form.appendChild(objs);
	form.setAttribute('method', 'post'); //get,post 가능
	form.setAttribute('action', "/boardUpdate"); //보내는 url
	document.body.appendChild(form);
	form.submit();

}
function boardDetail() {
	let boardList = [];
	$.ajax({
		url : '/board/detail',
		type : 'POST',
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify({
			boardId : $("#boardId").val(),
		}),
		headers : {
			'Authorization' : sessionStorage.getItem('AccessToken')
		},
		dataType : 'json',
		success : function(data) { // 성공
			if (data.result == "OK") {
				$("#title").append(data.data.title);
				$("#name").append(data.data.name);
				$("#createDate").append(data.data.create_date);
				$("#content").append(data.data.content);
				console.log(data)
				if (data.data.use_YN == 'Y'){
					$("#btnGroup").append(
						"<button type='button' class='btn btn-primary mr-2' onclick='move()'>수정</button>"+
						"<button type='button' class='btn btn-danger mr-2'>삭제</button>"
					)
					
				}
				$("#btnGroup").append(
						"<button type='button' class='btn btn-secondary' onclick='boardMove()'>목록으로</button>"
				)
				
				
			} else {
				alert("게시글이 존재하지 않습니다.");
				window.location = "/main";
			}
		},
		error : function(data) { // 실패
			alert("관리자에게 문의바랍니다.");
			window.location = "/main";
		}
	})
}