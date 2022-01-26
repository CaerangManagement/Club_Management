//signup 빈칸이 있는지 확인하는 함수(끝 건들 ㄴㄴ)
const signUpEmail = document.getElementById('email_div');
const signUpPass = document.getElementById('password_div');
const signUpPassVer = document.getElementById('password_verify_div');
const loginForm = document.getElementById('login_form');

const idNullChkText = document.getElementById('login_id_null_notice');
const passNullChkText = document.getElementById('login_pass_null_notice');
const signUpBox = document.getElementById('box1');
const signUpBoxHeight = document.getElementById('box1').style.height;




function loginNullChk(e){
    if(loginForm.email.value=="" && loginForm.password.value=="" && loginForm.passver.value==""){
        e.preventDefault();
        document.loginForm.email.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.remove('hidden'); 
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
            return true;
        }else if(pass1.value==pass2.value){
            passverNullChkText.classList.add('hidden');
            return false;
        }
}
signUpForm.addEventListener('submit',passwordChk);

//signup form Admin password 확인 함수(끝 건들 ㄴㄴ)
function adminPasswordChk(event){
    const adminPasswordInput = document.getElementById('admin_password');
    const adminWrap = document.getElementById('hidden_admin');
    if(adminPasswordInput.value=='asdf'){
        adminWrap.classList.remove('hidden');
        alert('관리자 계정으로 회원가입이 가능합니다.');
    }else{
        alert('관리자만 입력해주세요.');
    }
}

//singup email 중복 체크 <박주영>
$("#email_div").blur(function() {
		var user_id = $('#email_div').val();
		$.ajax({
			url : 'user/idCheck?userId='+ user_id,
			type : 'get',
			success : function(data) {
                        if (data == true) {
                                    $("#id_check").text("사용중인 이메일입니다");
                                    $("#id_check").css("color", "red");
                                    $("#login_bnt").attr("disabled", true);
                                }
                        else{
                        $("#id_check").text("사용가능한 이메일입니다.");
                        $("#id_check").css("color", "blue");
                        $("#login_bnt").attr("disabled", false);
                        }
                            }, error : function() {
                                    console.log("실패");
                            }
                        });
                    });
