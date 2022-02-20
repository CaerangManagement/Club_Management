//signup 빈칸이 있는지 확인하는 함수(끝 건들 ㄴㄴ)
const signUpEmail = document.getElementById('email_div');
const signUpPass = document.getElementById('password_div');
const signUpPassVer = document.getElementById('password_verify_div');
const loginForm = document.getElementById('login_form');

const idNullChkText = document.getElementById('login_id_null_notice');
const passNullChkText = document.getElementById('login_pass_null_notice');
const passverNullChkText = document.getElementById('login_passver_null_notice');
const signUpBox = document.getElementById('box1');
const signUpBoxHeight = document.getElementById('box1').style.height;



//빈값 체크 및 비번 확인
function loginNullChk(e){
    //모두 안적혀있을때
    if(!signUpEmail.value && !signUpPass.value && !signUpPassVer.value){
        e.preventDefault();
        document.loginForm.email.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.remove('hidden');
    }
    //이메일만 안적혀있을때
    else if(!signUpEmail.value){
        e.preventDefault();
        document.loginForm.email.focus();
        idNullChkText.classList.remove('hidden');
        passNullChkText.classList.add('hidden');
    }
    //비번과 비번체크가 안적혀있을때
    else if(!signUpPass.value && !signUpPassVer.value){
        e.preventDefault();
        document.loginForm.password.focus();
        passNullChkText.classList.remove('hidden');
        idNullChkText.classList.add('hidden');
    }
    //비번만 안적혀있을때
    else if(!signUpPass.value){
        e.preventDefault();
        document.loginForm.password.focus();
        passNullChkText.classList.remove('hidden');
        idNullChkText.classList.add('hidden');
    }
    //비번체크가 안적혀있을때
    else if(!signUpPassVer.value){
        e.preventDefault();
        document.loginForm.passwordver.focus();
        passverNullChkText.classList.remove('hidden');
        passNullChkText.classList.add('hidden');
        idNullChkText.classList.add('hidden');
        }
    //비번과 비번체크가 다를때
    else if(signUpPass.value != signUpPassVer.value){
        e.preventDefault();
        document.loginForm.passwordver.focus();
        passverNullChkText.classList.remove('hidden');
        passNullChkText.classList.add('hidden');
        idNullChkText.classList.add('hidden');
    }
    //모두 이상없을 경우
    else{
        passNullChkText.classList.add('hidden');
        passverNullChkText.classList.add('hidden');
        idNullChkText.classList.add('hidden');
    }
}
loginForm.addEventListener('submit',loginNullChk);


//관리자 비밀번호
function adminPasswordChk(event){
    const adminPasswordInput = document.getElementById('admin_password');
    const adminWrap = document.getElementById('hidden_admin');
    if(adminPasswordInput.value=='001020'){
        adminWrap.classList.remove('hidden');
        alert('관리자 계정으로 회원가입이 가능합니다.');
    }else{
        alert('관리자만 입력해주세요.');
    }
}

//singup email 중복 체크
$("#email_div").blur(function() {
		var user_id = $('#email_div').val();
        const idCheck = document.getElementById('id_check');
		$.ajax({
			url : 'user/idCheck?userId='+ user_id,
			type : 'GET',
			success : function(data) {
                if (data == 1) {
                    idCheck.classList.remove('hidden');
                    $("#id_check").text("중복된 이메일입니다");
                    $("#id_check").css("color", "red");
                    $("#login_btn").attr("disabled", true);
                        }
                else if(data == 2){
                    idCheck.classList.remove('hidden');
                    $("#id_check").text("사용가능한 이메일입니다.");
                    $("#id_check").css("color", "blue");
                    $("#login_btn").attr("disabled", false);
                }
                else if(data == 3){
                    idCheck.classList.add('hidden');
                    $("#id_check").text("");
                }
                    }, error : function() {
                            console.log("실패");
                    }
        });
});

//password 특수문자 정규식

function check_passwd(e)  {
    var check1 = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$~!%*#?&])[A-Za-z\d$@$~!%*#?&]{8,20}$/.test(signUpPass.value);  
    if(!check1){
        e.preventDefault();			
        alert("비밀번호는 영문,숫자,특수문자(~!@$%^&* 만 허용)를\n조합하여 8~20자 이상으로 구성하세요.");
    }

    if(/(\w)\1\1/.test(signUpPass.value)){
        e.preventDefault();			
        alert('같은 문자를 3번 이상 사용하실 수 없습니다.');
    }				
    
    var cnt = 0;
    var cnt2 = 0;
    var tmp = "";
    var tmp2 = "";
    var tmp3 = "";
    for (var i = 0; i < signUpPass.value.length; i++) {
        tmp = signUpPass.value.charAt(i);
        tmp2 = signUpPass.value.charAt(i + 1);
        tmp3 = signUpPass.value.charAt(i + 2);

        if (tmp.charCodeAt(0) - tmp2.charCodeAt(0) == 1
                && tmp2.charCodeAt(0) - tmp3.charCodeAt(0) == 1) {
            cnt = cnt + 1;
        }
        if (tmp.charCodeAt(0) - tmp2.charCodeAt(0) == -1
                && tmp2.charCodeAt(0) - tmp3.charCodeAt(0) == -1) {
            cnt2 = cnt2 + 1;
        }
    }
}
loginForm.addEventListener('submit',check_passwd);