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

//signup form 비밀번호 확인 함수
const pass1 = document.querySelector('#password_div');
const pass2 = document.querySelector('#password_verify_div');
const signUpForm = document.querySelector('#login_form');
function passwordChk(event){
    if(pass1.value != pass2.value){
        event.preventDefault();
        alert('비밀번호를 다시 확인해주세요.');
    }
}
signUpForm.addEventListener('submit',passwordChk);

//signup form Admin password 확인 함수
const adminPasswordInput = document.querySelector('#admin_password');
const input1 = document.querySelector('.hidden');
function AdminPasswordChk(event){
    event.preventDefault();
    if(adminPasswordInput.value=='asdf'){
        input1.classList.remove('.hidden');
    }
}
