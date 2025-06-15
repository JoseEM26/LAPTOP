
function tiktak(){
   

    setInterval(()=>{
        let fecha=new Date();
        let hora=fecha.getHours();
        let min=fecha.getMinutes();
        let seg=fecha.getSeconds();
        seg<10?seg="0"+seg:seg
        let reloj=document.getElementById("reloj");
        reloj.textContent=hora+":"+min+":"+seg;
    },1000)



}