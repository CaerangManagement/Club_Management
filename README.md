# 동아리 홈페이지
___
*  ### 개발전, 후  느낀점
*  ### 웹 리뷰

## Front-End 김도현
첫 협업이라 깃 사용에 어려움이 있었다.
버전관리의 중요성을 인지하지 못했었고 서로 같은 부분을 만졌을때 conflict 오류로 손수 merge했던 어려움 등이 있었다.
이 문제들은 차츰차츰 Git에 적응이 되어가며 실수를 하지 않으면서 발생하지 않게 되었다.

내가 생각하기에 이번 프로젝트의 가장 큰 문제점을 디테일하게 기획하지 않았다는 것이다.
대충 '회원관리 웹사이트' 라는 주제를 가지고 무대포로 시작하다보니 여러 페이지가 생기고 프로젝트가 커지면서
자잘자잘한 문제점들이 나오기 시작했다. 문제점으로는 웹 퍼블리싱을 끝낸 후 백엔드 작업과 JS가 들어갔어야 했는데
동시에 들어가게 되며 생긴 Merge 오류들이 있다. 또한 JS를 먼저 작성함으로서 백엔드가 Html페이지의 ID, Class 또는 태그를 건드렸을때 생기는
오류들을 다시한번 만지게 되어 효율이 굉장히 떨어지는 문제 등이 있었다.

이번 협업 프로젝트를 통하여 협업할때에 일의 순서, 기획 단계의 중요성을 굉장히 크게 느끼게 되는 좋은 경험이었다.


___
## Back-End 박주영
<p>
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white">
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white">
<img src="https://img.shields.io/badge/Thymeleaf-6DB33F?style=for-the-badge&logo=thymeleaf&logoColor=FF9900">
</p>
<p>
<img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white">
<img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white">
<img src="https://img.shields.io/badge/Ubuntu-black?style=for-the-badge&logo=ubuntu&logoColor=FF9900">
</p>


### 동아리 홈페이지를 만들게 된 계기
<p>
2021년 군 전역 후 복학하기 전에 시간이남아서 개인적으로 관심이있던 웹공부를  
Spring-boot로 하게 되었다.
1학년 때에는 Front-End 인 html, css, javascript로만 구성하였지만 더 앞서서 데이터 통신에 대해서도 구현을 하고싶었고
Back-End 까지 공부를 하게되었다.
</p>
<br>

<br>
  
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  
1학년 때에도 깃을 사용했었지만 혼자 올리는 것뿐이라 단순 commit push만 했었는데 협업을 하면서 굉장히 많은 오류들을 겪었고
branch, merge 등을 사용하면서 깃을 통한 협업을 알아가는데 많은 도움이 되었다.
깃을 통한 협업을 하는데 가장 중요한점은 일의 순서라고 생각한다, front 에서 페이지 퍼블리싱을 끝낸 후 back 으로 넘겨줘야 동시에 만질 걱정이 없어 깃이 엉키지 않는다. (깃이 엉켜서 한번 초기화 한적이있다) 
그래서 작업을 시작할때 동료가 push를 했으면 pull을 하고 시작하고 현재 어떤부분을 만지고있는지 소통하여 겹치지 않게 작업하는것이 중요한 것 같다.

처음에는 막연히 동아리원 인사관리 페이지를 만들어보고 싶다고 생각하여 프로젝트를 시작하였지만 씨애랑 동아리 홈페이지까지 규모가 커져 게시판을 2개나
만들게 되었다. 처음 게시판을 만드는데는 여러가지 필요한것들이 많고 공부해야 할 것들이 많아서 1주일가량 걸렸지만 나중에 추가하게된 공지사항 게시판은 중복되는것이 많아
하루만에 만들게 되어서 정말 좋았다. 개인적으로 머리가 아팠던 것은 댓글구현 부분이였다. 지금까지 단순히 데이터를 받고 뿌리는 것만 했다면 댓글은 user id, board id를 연관
시켜서 jpa를 잘 활용해야만 구현 할 수 있었다. 많은 예제를 참고했지만 결국은 내가 만든 게시판과 연동하기 위해 시행착오를 많이 겪어야만 했고 결국 성공했다.
<p>
<img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white">
 <br>
 <br>
완성된 웹페이지 배포는 AWS를 사용하기로 했다. 프리티어계정을 생성 하고 EC2 인스턴스의 ubuntu os로 서버를 구축하고 RDS-mariaDB 를 연결하였는데 처음하는 작업들이라 시간이 꽤 많이 걸렸다.
</P>

## 웹 리뷰

### 메인 페이지

### 로그인

### 회원가입

### 소개글

### 게시판 

### 공지사항

### 회원관리


