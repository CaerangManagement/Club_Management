//navbar
window.onload = function(){
    const NavbarName = document.getElementById('navName');
    const NavbarNameWrap = document.getElementById('navNameWrap');
    const NavbarLogoutWrap = document.getElementById('navLogoutWrap');
    if(!NavbarName){
        NavbarLogoutWrap.style.display='none';
        NavbarNameWrap.style.display='none';
    }
}

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

