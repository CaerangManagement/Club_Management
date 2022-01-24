//signup 빈칸이 있는지 확인하는 함수(끝 건들 ㄴㄴ)
const signUpEmail = document.getElementById('email_div');
const signUpPass = document.getElementById('password_div');
const signUpPassVer = document.getElementById('password_verify_div');
const loginForm = document.getElementById('login_form');

const idNullChkText = document.getElementById('login_id_null_notice');
const passNullChkText = document.getElementById('login_pass_null_notice');

const signUpBox = document.getElementById('box1');

function loginNullChk(e){
    if(loginForm.email.value=="" && loginForm.password.value=="" && loginForm.passver.value==""){
        e.preventDefault();
        document.loginForm.email.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.remove('hidden');
        signUpBox.style.height='580px';
    }else if(loginForm.email.value==""){
        e.preventDefault();
        document.loginForm.email.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.add('hidden');
    }else if(loginForm.password.value=="" && loginForm.passver.value==""){
        e.preventDefault();
        document.loginForm.password.focus();
        passNullChkText.classList.remove('hidden');
        idNullChkText.classList.add('hidden');
    }else{
        passNullChkText.classList.add('hidden');
        idNullChkText.classList.add('hidden');
    }
}
loginForm.addEventListener('submit',loginNullChk);

//signup form 비밀번호 확인 함수(끝 건들 ㄴㄴ)
const pass1 = document.getElementById('password_div');
const pass2 = document.getElementById('password_verify_div');
const signUpForm = document.getElementById('login_form');
const passverNullChkText = document.getElementById('login_passver_null_notice');

function passwordChk(event){
        if(pass1.value!=pass2.value){
            event.preventDefault();
            passverNullChkText.classList.remove('hidden');
        }else if(pass1.value==pass2.value){
            passverNullChkText.classList.add('hidden');
        }
}
signUpForm.addEventListener('submit',passwordChk);

//signup form Admin password 확인 함수(끝 건들 ㄴㄴ)
function adminPasswordChk(event){
    const adminPasswordInput = document.getElementById('admin_password');
    const adminWrap = document.getElementById('hidden_admin');
    const signUpBox = document.getElementById('box1');
    if(adminPasswordInput.value=='asdf'){
        adminWrap.classList.remove('hidden');
        alert('관리자 계정으로 회원가입이 가능합니다.');
    }else{
        alert('관리자만 입력해주세요.');
    }
}