var boardId;
$(document).ready(function() {
	boardList(1, 10);

});

function move(idx){
	var form = document.createElement('form');
	var objs;
	objs = document.createElement('input'); // 값이 들어있는 녀석의 형식
	objs.setAttribute('type', 'text'); // 값이 들어있는 녀석의 type
	objs.setAttribute('name', 'boardId'); // 객체이름
	objs.setAttribute('value', idx); //객체값
	form.appendChild(objs);
	form.setAttribute('method', 'post'); //get,post 가능
	form.setAttribute('action', "/boardDetail"); //보내는 url
	document.body.appendChild(form);
	form.submit();

}
function boardList(page, pageCount) {
	let boardList = [];
	$.ajax({
		url : '/board/list',
		type : 'POST',
		contentType : 'application/json; charset=UTF-8',
		headers : {
			'Authorization' : sessionStorage.getItem('AccessToken')
		},
		data : JSON.stringify({
			page : page,
			pageCount : pageCount
		}),
		dataType : 'json',
		success : function(data) { // 성공
			if (data.result == "OK") {
				boardList = data.data.boardList;

				if (boardList.length > 0) {
					$.each(boardList, function(index, item) {
						$("#boardTbody").append(
						"<tr>" +
							"<td onclick='move("+item.board_id+")'>"+item.title+
						"</td>"+
						"<td>"+item.name+"</td>"+
						"<td>"+item.create_date.split(' ')[0]+"</td>"+
						"<td>"+(item.use_YN == 'Y' ? "<button type='button' class='btn btn-primary'>수정</button>" : "")+"</td>"+
						"<td>"+(item.use_YN == 'Y' ? "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#modal' role='button' data-id='10'>삭제</button>" : "")+"</td></tr>"
						)
						
					});
				} else {
					$("#boardTbody").append("<tr><td colspan='5'>현재 작성된 게시판이 없습니다.</td></tr>")

				}
			} else {
				alert(data.reason);
			}
		},
		error : function(data) { // 실패
			alert("관리자에게 문의바랍니다.");
		}
	})
}
$('#modal').on('show.bs.modal', function (e) {
    var myRoomNumber = $(e.relatedTarget).attr('data-id');
   console.log(myRoomNumber)
});
$(".modal-content").load("/boardDeleteModal",{"boardId" : boardId});