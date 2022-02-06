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