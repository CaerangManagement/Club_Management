const title = document.getElementById('section_article_table_title');
const content = document.getElementById('section_article_table_main');
const btn = document.getElementById('save');

function nullChk(e){
    if(content.value==''&&title.value==''){
        alert('제목과 내용이 빈칸이여;');
        e.preventDefault();
    }else if(content.value==''){
        alert('내용이 빈칸이여');
        e.preventDefault();
    }else if(title.value==''){
        alert('제목이 빈칸이여');
        e.preventDefault();
    }
}
btn.addEventListener('click',nullChk);