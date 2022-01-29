var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');
/*csrf토큰 가져오기*/

//preventDaefault();
function stopEvent(event){
    event.preventDefault();
}

//회원 추가
$('#save').click(function () {
    var jsonData = JSON.stringify({
        position: $('#member_form_level_select').val(),
        department: $('#department').val(),
        grade: $('#grade').val(),
        studentId: $('#studentId').val(),
        memberName: $('#memberName').val(),
        contact: $('#contact').val()
    });
    $.ajax({
        url: "/api/member/add",
        method: "POST",
        data: jsonData,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
        success: function(){
            alert('회원추가 성공!');
            location.href = '/member/list';
        },
        error: function(){
            alert('회원추가 실패!');
        }
    });
});


//회원 수정
$('#update').click(function () {
    var jsonData = JSON.stringify({
            position: $('#member_form_level_select').val(),
            department: $('#department').val(),
            grade: $('#grade').val(),
            studentId: $('#studentId').val(),
            memberName: $('#memberName').val(),
            contact: $('#contact').val()
        });
        $.ajax({
            url: "/api/member/update/" + $('#member_code').val(),
            method: "PUT",
            data: jsonData,
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            beforeSend: function(xhr){
                    xhr.setRequestHeader(header, token);
                },
            success: function(){
                alert('수정 성공!');
                location.href = '/member/list';
            },
            error: function(){
                alert('수정 실패!');
            }
    });
});

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ모바일ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

//회원 추가
$('#mobile_save').click(function () {
    var jsonData = JSON.stringify({
        position: $('#member_form_level_span').val(),
        department: $('#mobile_department').val(),
        grade: $('#mobile_grade').val(),
        studentId: $('#mobile_studentId').val(),
        memberName: $('#mobile_memberName').val(),
        contact: $('#mobile_contact').val()
    });
    $.ajax({
        url: "/api/member/add",
        method: "POST",
        data: jsonData,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
        success: function(){
            alert('회원추가 성공!');
            location.href = '/member/list';
        },
        error: function(){
            alert('회원추가 실패!');
        }
    });
});


//글 수정
$('#update_mobile').click(function () {
    var jsonData = JSON.stringify({
            position: $('#member_form_level_select').val(),
            department: $('#mobile_department').val(),
            grade: $('#mobile_grade').val(),
            studentId: $('#mobile_studentId').val(),
            memberName: $('#mobile_memberName').val(),
            contact: $('#mobiel_contact').val()
        });
        $.ajax({
            url: "/api/member/update/" + $('#member_code').val(),
            method: "PUT",
            data: jsonData,
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            beforeSend: function(xhr){
                    xhr.setRequestHeader(header, token);
                },
            success: function(){
                alert('수정 성공!');
                location.href = '/member/list';
            },
            error: function(){
                alert('수정 실패!');
            }
    });
});




/*제명은 모바일, pc 공통*/

function deletemember(idx) {

	if (!confirm('회원을 제명하시겠어요?')) {
		return false;
	}

	var uri = "/api/member/delete/" + idx;

	var headers = {"Content-Type": "application/json", "X-HTTP-Method-Override": "DELETE"};

	$.ajax({
		url: uri,
		type: "DELETE",
		headers: headers,
		dataType: "json",
		beforeSend: function(xhr){
                        xhr.setRequestHeader(header, token);
                    },
		success: function(response) {
		        alert('제명 성공!');
                location.href = '/member/list';

		},
		error: function(xhr, status, error) {
			alert("에러가 발생하였습니다.");
			return false;
		}
	});
}



