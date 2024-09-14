let retroceder=document.getElementById("retroceder")
let avanzar=document.getElementById("avanzar")
let baner=document.getElementById("banner")

let ArregloBanner=[
    "baner1.jpg",
    "baner2.jpg",
    "baner3.jpg"
]
let i=0;
retroceder.addEventListener("click",()=>{
  baner.src=ArregloBanner[i--];
  if(i<0){
    i=2;
  }
})

avanzar.addEventListener("click",()=>{
    baner.src=ArregloBanner[i++];
  if(i>ArregloBanner.length-1){
    i=0;
  }
})





