$('.summernote').summernote({
      placeholder: '내용을 입력해주세요.',
      height: 350,
      lang: "ko-KR",
      disableResizeEditor: true,
      focus : true,
	  toolbar: [
		    // 글꼴 설정
		    ['fontname', ['fontname']],
		    // 글자 크기 설정
		    ['fontsize', ['fontsize']],
		    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		    // 글자색
		    ['color', ['forecolor','color']],
		    // 표만들기
		    ['table', ['table']],
		    // 문단 정렬
		    ['para', ['ul', 'ol', 'paragraph']],
		    // 줄간격
		    ['height', ['height']],
		    // 그림첨부, 링크만들기, 동영상첨부
		    ['insert',['picture','link','video']],
		  ],
		  // 추가한 글꼴
		fontNames: ['맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New'],
		 // 추가한 폰트사이즈
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
});