
document.getElementById("textArea").addEventListener("keyup",caracteres);

function caracteres(){
    let can=document.getElementById("textArea").value.length;
    let disponible=20 - parseInt(can);
    document.getElementById("limite").innerHTML=disponible;

    if(disponible==0){
        alert("Se han acabado los words disponibles")
    }



}












