var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');
/*csrf토큰 가져오기*/


//글 작성
$('#save').click(function () {
    var jsonData = JSON.stringify({
        title: $('#section_article_table_title').val(),
        content: $('#section_article_table_main').val()
    });
    $.ajax({
        url: "/api/board/add",
        method: "POST",
        data: jsonData,
        contentType: 'application/json;charset=utf-8',
        dataType: "json",
        beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
        success: function(){
            alert('글쓰기 성공:)');
            location.href = '/board/list';
        },
        error: function(){
            alert('저장 실패:(');
        }
    });
});


//글 수정
$('#update').click(function () {
    var jsonData = JSON.stringify({
            title: $('#section_article_table_title').val(),
            content: $('#section_article_table_main').val()
        });
        $.ajax({
            url: "/api/board/update/" + $('#board_id').val(),
            method: "PUT",
            data: jsonData,
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            beforeSend: function(xhr){
                    xhr.setRequestHeader(header, token);
                },
            success: function(){
                alert('수정 성공:)');
                location.href = '/board/list';
            },
            error: function(){
                alert('수정 실패:(');
            }
    });
});

//글 삭제
$('#section_article_delete').click(function() {
         $.ajax({
            url: "/api/board/delete/" + $('#board_id').val(),
            method: "DELETE",
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success: function(){
                alert('삭제 성공:)');
                location.href = '/board/list';
            },
            error: function(){
                alert('삭제 실패:(');
            }
        });
})

//댓글 추가
$('#btn_reply_save').click(function() {
        var jsonData = JSON.stringify({
                    title: $('#reply_content').val()
                });
         $.ajax({
            url: "/api/board/" + $('#board_id').val() +"/reply",
            method: "POST",
            data: jsonData,
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success: function(){
                alert('댓글작성이 완료되었습니다. :)');
                location.href = '/board/' + $('#board_id').val();
            },
            error: function(){
                alert('댓글작성을 실패했습니다. :(');
            }
        });
})


