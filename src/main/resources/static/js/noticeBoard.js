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
        url: "/api/notice/board/add",
        method: "POST",
        data: jsonData,
        contentType: 'application/json;charset=utf-8',
        dataType: "json",
        beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
        success: function(){
            alert('글쓰기 성공 :)');
            location.href = '/notice/board/list';
        },
        error: function(){
            alert('저장 실패 :(');
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
            url: "/api/notice/board/update/" + $('#notice_board_id').val(),
            method: "PUT",
            data: jsonData,
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            beforeSend: function(xhr){
                    xhr.setRequestHeader(header, token);
                },
            success: function(){
                alert('수정 성공 :)');
                location.href = '/notice/board/' + $('#notice_board_id').val();
            },
            error: function(){
                alert('수정 실패 :(');
            }
    });
});

//글 삭제
$('#section_article_delete').click(function() {
         $.ajax({
            url: "/api/notice/board/delete/" + $('#notice_board_id').val(),
            method: "DELETE",
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success: function(){
                alert('삭제 성공 :)');
                location.href = '/notice/board/list';
            },
            error: function(){
                alert('삭제 실패 :(');
                location.href = '/notice/board/list';
            }
        });
})

