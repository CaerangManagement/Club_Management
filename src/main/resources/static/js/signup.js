//signup 빈칸이 있는지 확인하는 함수(끝 건들 ㄴㄴ)
const signUpEmail = document.getElementById('email_div');
const signUpPass = document.getElementById('password_div');
const signUpPassVer = document.getElementById('password_verify_div');
const loginForm = document.getElementById('login_form');

function loginNullChk(e){

    if(loginForm.email.value=="" || loginForm.password.value=="" || loginForm.passver.value==""){
        e.preventDefault();
        document.loginForm.email.focus();
        signUpEmail.style.border="2px solid blue";

        alert("아이디와 비밀번호를 입력해주세요.");
    }
}
loginForm.addEventListener('submit',loginNullChk);

//signup form 비밀번호 확인 함수(끝 건들 ㄴㄴ)
const pass1 = document.getElementById('password_div');
const pass2 = document.getElementById('password_verify_div');
const signUpForm = document.getElementById('login_form');
function passwordChk(event){
        if(pass1.value!=pass2.value){
            event.preventDefault();
            alert('비밀번호가 같게 다시 입력해주세요.');
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
        signUpBox.style.height='520px';
        alert('관리자 계정으로 회원가입이 가능합니다.');
    }else{
        alert('관리자만 입력해주세요.');
    }
}