
//bxslider
$(document).ready(function(){ $('.bxslider').bxSlider({
    auto: true,  // 자동 슬라이드 
    controls: true, // prev/next 버튼 노출 여부 
    pager: true,
    pause: 7000,
    autoHover: true,
    maxSlides: 10,
    minSlides: 1,
    });
});

//owl slide
$(document).ready(function(){
	var owl = $('.owl-carousel');
	owl.owlCarousel({
    items:4,
    loop:true,
    margin:10,
    autoplay:true,
    autoplayTimeout:10000,
    autoplayHoverPause:true
});
  });

