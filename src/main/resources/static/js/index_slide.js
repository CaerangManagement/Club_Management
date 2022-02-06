//bxslider
$(document).ready(function(){ $('.bxslider').bxSlider({
    auto: true,  // 자동 슬라이드 
    controls: true, // prev/next 버튼 노출 여부 
    pager: true,
    pause: 5000,
    autoHover: true,
    maxSlides: 1,
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

//navbar
$(document).ready(function(){
  
	$('#main_menu > li > a').click(function(){
	  $(this).next($('.snd_menu')).slideToggle('fast');
	})
	$('.snd_menu > li > a').click(function(e){
	  e.stopPropagation();
	  $(this).next($('.trd_menu')).slideToggle('fast');
	})
	
  })