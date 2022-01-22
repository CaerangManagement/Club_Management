//preventDaefault();
function stopEvent(event){
    event.preventDefault();
}
//list.html에서 삭제버튼 눌렀을때 JS임.
const getout_btn = document.querySelector('#getout');
function getOut(){
    stopEvent();
    const a=confirm('제명하시겠습니까?');
    if(a===false){
        stopEvent();
    }
    console.log(a);
}


const cancle_btn = document.querySelector('#cancle_btn');
function can(eve){
    const b=confirm('취소하시겠습니까?');
    if(b){
        alert("취소되었습니다.");
        location.href="../../templates/member/list.html";
    }else{
        event.preventDefault();
    }
}


const page_btn = document.querySelector('.page_btn');
function page(event){
    event.preventDefault();
}
