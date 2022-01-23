//로그인 빈칸 체크 함수(끝 건들 ㄴㄴ)
const loginEmail = document.getElementById('email_div');
const loginPass = document.getElementById('password_div');
const loginLoginForm = document.getElementById('login_form');
function loginNullChk(e){

    if(loginLoginForm.username.value=="" && loginLoginForm.password.value==""){
        e.preventDefault();
        document.loginForm.username.focus();
        alert("아이디와 비밀번호를 입력해주세요.");
    }else if(loginLoginForm.username.value==""){
        e.preventDefault();
        document.loginForm.username.focus();
        alert('아이디를 입력해주세요.');
    }else if(loginLoginForm.password.value==""){
        e.preventDefault();
        document.loginForm.password.focus();
        alert('비밀번호를 입력해주세요.');
    }
}
loginLoginForm.addEventListener('submit',loginNullChk);