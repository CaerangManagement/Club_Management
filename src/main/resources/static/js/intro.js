const latteBtn = document.getElementById('latte_select');
const raonBtn = document.getElementById('raon_select');
const coreBtn = document.getElementById('core_select');
const tagBtn = document.getElementById('tag_select');
const tensorBtn = document.getElementById('tensor_select');

var latteOnOff = false;
var raonOnOff = false;
var coreOnOff = false;
var tagOnOff = false;
var tensorOnOff = false;

const latteImg = document.getElementById('latte_img');
const raonImg = document.getElementById('raon_img');
const coreImg = document.getElementById('core_img');
const tagImg = document.getElementById('tag_img');
const tensorImg = document.getElementById('tensor_img');

const selectWrap = document.getElementById('select_wrap');
const sect = document.getElementById('sect');

const selectContent = document.getElementById('select_content');

function latteOn(){
    if(raonOnOff||coreOnOff||tagOnOff||tensorOnOff == true){
        latteImg.classList.remove('hidden');
        raonImg.classList.add('hidden');
        coreImg.classList.add('hidden');
        tagImg.classList.add('hidden');
        tensorImg.classList.add('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
        selectWrap.style.height='90%';
        selectWrap.style.backgroundColor='rgb(245, 245, 245)';
        sect.style.height='180%';
        latteBtn.style.opacity='0.7';
        raonBtn.style.opacity='0.7';
        coreBtn.style.opacity='0.7';
        tagBtn.style.opacity='0.7';
        tensorBtn.style.opacity='0.7';
        latteOnOff = true;
        raonOnOff = false;
        coreOnOff = false;
        tagOnOff = false;
        tensorOnOff = false;
    }else{
        if(latteOnOff==true){
            latteImg.classList.add('hidden');
            selectContent.style.backgroundColor='none';
            selectWrap.style.height='8%';
            selectWrap.style.backgroundColor='white';
            sect.style.height='100%';
            latteBtn.style.opacity='1';
            raonBtn.style.opacity='1';
            coreBtn.style.opacity='1';
            tagBtn.style.opacity='1';
            tensorBtn.style.opacity='1';
            latteOnOff = false;
            selectContent.style.backgroundColor='transparent';

        }else{
            latteImg.classList.remove('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
            selectWrap.style.height='90%';
            selectWrap.style.backgroundColor='rgb(245, 245, 245)';
            sect.style.height='180%';
            latteBtn.style.opacity='0.7';
            raonBtn.style.opacity='0.7';
            coreBtn.style.opacity='0.7';
            tagBtn.style.opacity='0.7';
            tensorBtn.style.opacity='0.7';

            latteOnOff = true;
        }
    }
}

function raonOn(){
    if(latteOnOff||coreOnOff||tagOnOff||tensorOnOff == true){
        latteImg.classList.add('hidden');
        raonImg.classList.remove('hidden');
        coreImg.classList.add('hidden');
        tagImg.classList.add('hidden');
        tensorImg.classList.add('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
        selectWrap.style.height='90%';
        selectWrap.style.backgroundColor='rgb(245, 245, 245)';
        sect.style.height='180%';
        latteBtn.style.opacity='0.7';
        raonBtn.style.opacity='0.7';
        coreBtn.style.opacity='0.7';
        tagBtn.style.opacity='0.7';
        tensorBtn.style.opacity='0.7';


        latteOnOff = false;
        raonOnOff = true;
        coreOnOff = false;
        tagOnOff = false;
        tensorOnOff = false;
    }else{
        if(raonOnOff==true){
            raonImg.classList.add('hidden');
            selectContent.style.backgroundColor='transparent';
            selectWrap.style.height='8%';
            selectWrap.style.backgroundColor='white';
            sect.style.height='100%';
            latteBtn.style.opacity='1';
            raonBtn.style.opacity='1';
            coreBtn.style.opacity='1';
            tagBtn.style.opacity='1';
            tensorBtn.style.opacity='1';
            raonOnOff = false;
        }else{
            raonImg.classList.remove('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
            selectWrap.style.height='90%';
            selectWrap.style.backgroundColor='rgb(245, 245, 245)';
            latteBtn.style.opacity='0.7';
            raonBtn.style.opacity='0.7';
            coreBtn.style.opacity='0.7';
            tagBtn.style.opacity='0.7';
            tensorBtn.style.opacity='0.7';

            sect.style.height='180%';

            raonOnOff = true;
        }
    }
}

function coreOn(){
    if(latteOnOff||raonOnOff||tagOnOff||tensorOnOff == true){
        latteImg.classList.add('hidden');
        raonImg.classList.add('hidden');
        coreImg.classList.remove('hidden');
        tagImg.classList.add('hidden');
        tensorImg.classList.add('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
        selectWrap.style.height='90%';
        selectWrap.style.backgroundColor='rgb(245, 245, 245)';
        latteBtn.style.opacity='0.7';
        raonBtn.style.opacity='0.7';
        coreBtn.style.opacity='0.7';
        tagBtn.style.opacity='0.7';
        tensorBtn.style.opacity='0.7';

        sect.style.height='180%';

        latteOnOff = false;
        raonOnOff = false;
        coreOnOff = true;
        tagOnOff = false;
        tensorOnOff = false;
    }else{
        if(coreOnOff==true){
            coreImg.classList.add('hidden');
            selectContent.style.backgroundColor='transparent';
            selectWrap.style.height='8%';
            selectWrap.style.backgroundColor='white';
            sect.style.height='100%';
            latteBtn.style.opacity='1';
            raonBtn.style.opacity='1';
            coreBtn.style.opacity='1';
            tagBtn.style.opacity='1';
            tensorBtn.style.opacity='1';
            coreOnOff = false;
        }else{
            coreImg.classList.remove('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
            selectWrap.style.height='90%';
            selectWrap.style.backgroundColor='rgb(245, 245, 245)';
            latteBtn.style.opacity='0.7';
            raonBtn.style.opacity='0.7';
            coreBtn.style.opacity='0.7';
            tagBtn.style.opacity='0.7';
            tensorBtn.style.opacity='0.7';

            sect.style.height='180%';

            coreOnOff = true;
        }
    }
}

function tagOn(){
    if(latteOnOff||raonOnOff||coreOnOff||tensorOnOff == true){
        latteImg.classList.add('hidden');
        raonImg.classList.add('hidden');
        coreImg.classList.add('hidden');
        tagImg.classList.remove('hidden');
        tensorImg.classList.add('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
        selectWrap.style.height='90%';
        selectWrap.style.backgroundColor='rgb(245, 245, 245)';
        latteBtn.style.opacity='0.7';
        raonBtn.style.opacity='0.7';
        coreBtn.style.opacity='0.7';
        tagBtn.style.opacity='0.7';
        tensorBtn.style.opacity='0.7';

        sect.style.height='180%';

        latteOnOff = false;
        raonOnOff = false;
        coreOnOff = false;
        tagOnOff = true;
        tensorOnOff = false;
    }else{
        if(tagOnOff==true){
            tagImg.classList.add('hidden');
            selectContent.style.backgroundColor='transparent';
            selectWrap.style.height='8%';
            selectWrap.style.backgroundColor='white';
            sect.style.height='100%';
            latteBtn.style.opacity='1';
            raonBtn.style.opacity='1';
            coreBtn.style.opacity='1';
            tagBtn.style.opacity='1';
            tensorBtn.style.opacity='1';
            tagOnOff = false;
        }else{
            tagImg.classList.remove('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
            selectWrap.style.height='90%';
            selectWrap.style.backgroundColor='rgb(245, 245, 245)';
            latteBtn.style.opacity='0.7';
            raonBtn.style.opacity='0.7';
            coreBtn.style.opacity='0.7';
            tagBtn.style.opacity='0.7';
            tensorBtn.style.opacity='0.7';

            sect.style.height='180%';

            tagOnOff = true;
        }
    }
}

function tensorOn(){
    if(latteOnOff||raonOnOff||coreOnOff||tagOnOff == true){
        latteImg.classList.add('hidden');
        raonImg.classList.add('hidden');
        coreImg.classList.add('hidden');
        tagImg.classList.add('hidden');
        tensorImg.classList.remove('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
        selectWrap.style.height='90%';
        selectWrap.style.backgroundColor='rgb(245, 245, 245)';
        latteBtn.style.opacity='0.7';
        raonBtn.style.opacity='0.7';
        coreBtn.style.opacity='0.7';
        tagBtn.style.opacity='0.7';
        tensorBtn.style.opacity='0.7';

        sect.style.height='180%';

        latteOnOff = false;
        raonOnOff = false;
        coreOnOff = false;
        tagOnOff = false;
        tensorOnOff = true;
    }else{
        if(tensorOnOff==true){
            tensorImg.classList.add('hidden');
            selectContent.style.backgroundColor='transparent';
            selectWrap.style.height='8%';
            selectWrap.style.backgroundColor='white';
            sect.style.height='100%';
            latteBtn.style.opacity='1';
            raonBtn.style.opacity='1';
            coreBtn.style.opacity='1';
            tagBtn.style.opacity='1';
            tensorBtn.style.opacity='1';
            tensorOnOff = false;
        }else{
            tensorImg.classList.remove('hidden');
        selectContent.style.backgroundColor='#EBEBEB';
            selectWrap.style.height='90%';
            selectWrap.style.backgroundColor='rgb(245, 245, 245)';
            latteBtn.style.opacity='0.7';
            raonBtn.style.opacity='0.7';
            coreBtn.style.opacity='0.7';
            tagBtn.style.opacity='0.7';
            tensorBtn.style.opacity='0.7';

            sect.style.height='180%';

            tensorOnOff = true;
        }
    }
}

latteBtn.addEventListener('click',latteOn);
raonBtn.addEventListener('click',raonOn);
coreBtn.addEventListener('click',coreOn);
tagBtn.addEventListener('click',tagOn);
tensorBtn.addEventListener('click',tensorOn);
