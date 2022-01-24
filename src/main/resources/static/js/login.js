//로그인 빈칸 체크 함수(끝 건들 ㄴㄴ)
const loginEmail = document.getElementById('email_div');
const loginPass = document.getElementById('password_div');
const loginLoginForm = document.getElementById('login_form');
const idNullChkText = document.getElementById('login_id_null_notice');
const passNullChkText = document.getElementById('login_pass_null_notice');
function loginNullChk(e){

    if(loginLoginForm.username.value=="" && loginLoginForm.password.value==""){
        e.preventDefault();
        document.loginForm.username.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.remove('hidden');
    }else if(loginLoginForm.username.value==""){
        e.preventDefault();
        document.loginForm.username.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.add('hidden');
    }else if(loginLoginForm.password.value==""){
        e.preventDefault();
        document.loginForm.password.focus();
        passNullChkText.classList.remove('hidden');
        idNullChkText.classList.add('hidden');
    }
}
loginLoginForm.addEventListener('submit',loginNullChk);


e.preventDefault();
document.loginForm.email.focus();
idNullChkText.classList.remove('hidden');
passNullChkText.classList.remove('hidden');