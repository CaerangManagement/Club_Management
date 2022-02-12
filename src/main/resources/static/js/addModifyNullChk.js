const title = document.getElementById('section_article_table_title');
const content = document.getElementById('section_article_table_main');
const btn = document.getElementById('save');

var xhr = $.ajax({
    type: "POST",
    url: "some.php",
    data: "name=John&location=Boston",
    success: function(msg){
       alert( "Data Saved: " + msg );
    }
});

function nullChk(e){
    if(content.value==''&&title.value==''){
        alert('제목과 내용이 빈칸이여;');
        e.preventDefault();
        xhr.abort();
    }else if(content.value==''){
        alert('내용이 빈칸이여');
        e.preventDefault();
        xhr.abort();
    }else if(title.value==''){
        alert('제목이 빈칸이여');
        e.preventDefault();
        xhr.abort();
    }
}
btn.addEventListener('click',nullChk);