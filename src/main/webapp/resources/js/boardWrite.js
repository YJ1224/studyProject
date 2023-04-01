$("#write").click(function() {
	const title = $("#title").val();
	const content = $("#content").val();
	if(!title || !content){
		return alert("제목과 내용은 필수입니다.");
	}else{
		$.ajax({
			url: '/board/wirte',
			type: 'POST',
			contentType:'application/json; charset=UTF-8',
			headers : {
				'Authorization' : sessionStorage.getItem('AccessToken')
			},
			data: JSON.stringify({
				title : title,
				content : content.replace(/(?:\r\n|\r|\n)/g, '<br/>')
			}),
			dataType: 'json',
			success : function(data){ //성공
				if(data.result == "OK"){
					alert("게시물 등록이 완료되었습니다.");
					window.location = "/main";
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