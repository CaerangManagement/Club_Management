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

/*
//signup form 이멜,패스워드 등 빼먹은거 있나 확인하는 함수

const signUpEmail = document.getElementById('email_div');
const signUpPass = document.getElementById('password_div');
const signUpPassver = document.getElementById('password_verify_div');
const signUpBtn = document.getElementById('login_bnt');
function signUpNullChk(event){
        event.preventDefault();
        alert('이멜써');
}
*/

//signup form 비밀번호 확인 함수(끝 건들 ㄴㄴ)
const pass1 = document.getElementById('password_div');
const pass2 = document.getElementById('password_verify_div');
const signUpForm = document.getElementById('login_form');
function passwordChk(event){
        event.preventDefault();
        alert('비밀번호를 다시 확인해주세요.');
}
signUpForm.addEventListener('submit',passwordChk);

//signup form Admin password 확인 함수(끝 건들 ㄴㄴ)
function AdminPasswordChk(event){
    const adminPasswordInput = document.getElementById('admin_password');
    const adminWrap = document.getElementById('hidden_admin');
    const signUpBox = document.getElementById('box1');
    if(adminPasswordInput.value=='asdf'){
        adminWrap.classList.remove('hidden');
        signUpBox.style.height='520px';
        alert('관리자 계정으로 회원가입이 가능합니다.');
    }else{
        alert('Please only admin');
    }
}
