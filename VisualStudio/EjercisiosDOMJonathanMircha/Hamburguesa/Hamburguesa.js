let boton=document.getElementById("hamburger");
let contador=0;
let aside = document.getElementById("aside");


boton.addEventListener("click",()=>{
    contador++;
    if(contador % 2 ==0){
        aside.style.transform="translate(0,-100%)"
        boton.classList.toggle("is-active")

    }else{
        aside.style.transform="translate(0,0)"
        boton.classList.toggle("is-active")
    }
});






