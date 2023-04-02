var page = 1;
var listEmpty = false;
$(document).ready(
		function() {
			// 로딩 되자마자 리스트 조회
			boardList(10);

			var docHeight = $(document).height();
			var scrollHeight = $(window).scrollTop() + $(window).height();
			$(window).scroll(
					function() {
						var docHeight = $(document).height();
						var scrollHeight = Math.round($(window).scrollTop()
								+ $(window).height());
						if (docHeight == scrollHeight && !listEmpty) {
							boardList(10);
						}
					});
		});

// 제목 클릭시 게시물 상세 페이지 post이동
function boardDetail(idx) {
	var form = document.createElement('form');
	var objs;
	objs = document.createElement('input'); // 값이 들어있는 녀석의 형식
	objs.setAttribute('type', 'text'); // 값이 들어있는 녀석의 type
	objs.setAttribute('name', 'boardId'); // 객체이름
	objs.setAttribute('value', idx); // 객체값
	form.appendChild(objs);
	form.setAttribute('method', 'post'); // get,post 가능
	form.setAttribute('action', "/boardDetail"); // 보내는 url
	document.body.appendChild(form);
	form.submit();

}

// 페이징 리스트 호출
function boardList(pageCount) {
	let boardList = [];
	$
			.ajax({
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
							page += 1;
							listEmpty = false;
							$
									.each(
											boardList,
											function(index, item) {
												$("#boardTbody")
														.append(
																"<tr>"
																		+ "<td onclick='boardDetail("
																		+ item.board_id
																		+ ")'>"
																		+ item.title
																		+ "</td>"
																		+ "<td>"
																		+ item.name
																		+ "</td>"
																		+ "<td>"
																		+ item.create_date
																				.split(' ')[0]
																		+ "</td>"
																		+ "<td>"
																		+ (item.use_YN == 'Y' ? "<button type='button' class='btn btn-primary' onclick='boardUpdate("
																				+ item.board_id
																				+ ")'>수정</button>"
																				: "")
																		+ "</td>"
																		+ "<td>"
																		+ (item.use_YN == 'Y' ? "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#modal' role='button' onclick='deleteModal("
																				+ item.board_id
																				+ ")'>삭제</button>"
																				: "")
																		+ "</td></tr>")
											});
						} else {
							listEmpty = true;
						}
						// } else{
						// $("#boardTbody").append("<tr><td colspan='5'>현재 작성된
						// 게시판이 없습니다.</td></tr>")
						// }
					} else {
						alert(data.reason);
					}
				},
				error : function(data) { // 실패
					alert("관리자에게 문의바랍니다.");
				}
			})
}

// 삭제 모달 띄우기
function deleteModal(idx) {
	$(".modal-content").load("/boardDeleteModal", {
		"boardId" : idx
	});
}

// 게시물 수정하기 post 방식으로 페이지 이동
function boardUpdate(idx) {
	var form = document.createElement('form');
	var objs;
	objs = document.createElement('input'); // 값이 들어있는 녀석의 형식
	objs.setAttribute('type', 'text'); // 값이 들어있는 녀석의 type
	objs.setAttribute('name', 'boardId'); // 객체이름
	objs.setAttribute('value', idx); // 객체값
	form.appendChild(objs);
	form.setAttribute('method', 'post'); // get,post 가능
	form.setAttribute('action', "/boardUpdate"); // 보내는 url
	document.body.appendChild(form);
	form.submit();

}
