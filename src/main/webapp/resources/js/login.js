$("#loginBtn").click(function() {
	const userId = $("#id").val();
	const userPassword = $("#password").val();
	if(!userId || !userPassword){
		return alert("아이디 및 비밀번호를 입력해주세요.");
	}else{
		$.ajax({
			url: '/user/login',
			type: 'POST',
			contentType:'application/json; charset=UTF-8',
			data: JSON.stringify({
				user_id : userId,
				password : userPassword
			}),
			dataType: 'json',
			success : function(data){ //성공
				if(data.result == "OK"){
					sessionStorage.setItem("AccessToken",data.data.access_TOKEN);
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