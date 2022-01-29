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
        position: $('#position').val(),
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


//글 수정
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

//글 삭제
$('#delete').click(function() {
         $.ajax({
            url: "/api/member/delete/" + $('#member_code').val(),
            method: "DELETE",
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
                const a=confirm('제명하시겠습니까?');
                    if(a===false){
                        stopEvent(this);
                    }
            },
            success: function(){
                alert('제명 성공!');
                location.href = '/member/list';
            },
            error: function(){
                alert('제명 실패!');
            }
        });
})

//모바일버전 제명
$('#delete_mobile').click(function() {
         $.ajax({
            url: "/api/member/delete/" + $('#member_code_mobile').val(),
            method: "DELETE",
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
                const a=confirm('제명하시겠습니까?');
                        if(a===false){
                            stopEvent(this);
                        }
             },
            success: function(){
                alert('제명 성공!');
                location.href = '/member/list';
            },
            error: function(){
                alert('제명 실패!');
            }
        });
})



