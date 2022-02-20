//로그인 빈칸 체크 함수(끝 건들 ㄴㄴ)
const loginEmail = document.getElementById('email_div');
const loginPass = document.getElementById('password_div');
const loginLoginForm = document.getElementById('login_form');
const idNullChkText = document.getElementById('login_id_null_notice');
const passNullChkText = document.getElementById('login_pass_null_notice');
const loginBox = document.getElementById('box1');

function loginNullChk(event){
    if(loginLoginForm.username.value=="" && loginLoginForm.password.value==""){
        event.preventDefault();
        document.loginForm.username.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.remove('hidden');
        loginBox.style.height='440px';
    }else if(loginLoginForm.username.value==""){
        event.preventDefault();
        document.loginForm.username.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.add('hidden');
        loginBox.style.height='440px';
    }else if(loginLoginForm.password.value==""){
        event.preventDefault();
        document.loginForm.password.focus();
        passNullChkText.classList.remove('hidden');
        idNullChkText.classList.add('hidden');
        loginBox.style.height='440px';
    }
}
loginLoginForm.addEventListener('submit',loginNullChk);
