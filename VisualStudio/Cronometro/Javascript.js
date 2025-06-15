
let textito=document.getElementById("text");

function temporizador(){
    let numero=document.getElementById("cantidad").value;

    setTimeout(tiempocumplido,1000*numero)
}

function tiempocumplido(){
    alert("tiempo cunplido");
    textito.innerHTML="ENCENDIDO";
    textito.style.color="green";

}

















