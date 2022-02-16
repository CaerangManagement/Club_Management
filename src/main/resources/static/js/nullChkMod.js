const title = document.getElementById('section_article_table_title');
const content = document.getElementById('section_article_table_main');
const warning = document.getElementById('section_article_table_title_warning');
const btn = document.getElementById('update');

    btn.classList.remove('eventCancle');
    warning.classList.add('hidden');

    $("#section_article_table_title").blur(function(){
        if(title.value==''){
            btn.classList.add('eventCancle');
            warning.classList.remove('hidden');
        }else{
            btn.classList.remove('eventCancle');
            warning.classList.add('hidden');
        }
    });



