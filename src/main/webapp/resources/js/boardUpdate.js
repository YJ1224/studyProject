$(document).ready(function() {
	if(!$("#boardId").val()){
		console.log($("#boardId").val());
		alert("게시글이 존재하지 않습니다.");
		window.location = "/main";
	}else{
		boardDetail();
	}
	

});

function boardMove (){
	window.location = "/main";
}
function boardDetail() {
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
				$("#title").val(data.data.title);
				$("#name").val(data.data.name);
				$("#content").val(data.data.content.replaceAll("<br/>", "\r\n"));
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

$("#write").click(function() {
	const title = $("#title").val();
	const content = $("#content").val();
	const boardId = $("#boardId").val();
	if(!title || !content){
		return alert("제목과 내용은 필수입니다.");
	}else{
		$.ajax({
			url: '/board/update',
			type: 'PUT',
			contentType:'application/json; charset=UTF-8',
			headers : {
				'Authorization' : sessionStorage.getItem('AccessToken')
			},
			data: JSON.stringify({
				board_id : boardId,
				title : title,
				content : content.replace(/(?:\r\n|\r|\n)/g, '<br/>')
			}),
			dataType: 'json',
			success : function(data){ //성공
				if(data.result == "OK"){
					alert("게시물 수정이 완료되었습니다.");
					location.reload();
				}else{
					alert(data.reason);
				}
			},
			error : function(data){ //실패
				alert("관리자에게 문의바랍니다.");
			}
		})
	}
});