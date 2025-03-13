function cambiarColor(){
    let seleccion=document.getElementById("listaColores");
    let indice=seleccion.selectedIndex;
    let color=seleccion.options[indice].text;
    let indicacion=seleccion.options[indice].value;

    document.getElementById("Index").value=indice+1;
    document.getElementById("color").value=color;
    document.getElementById("indicacion").value=indicacion;

}

function Saludar(){
    swal("Hola Mundo")
}
/////////////////////////////////////////////////////////////////

function Selecionados(){
    let contador=0;
    if(document.getElementById("check1").checked){
       contador++;
    }
    if(document.getElementById("check2").checked){
        contador++;
     }
     if(document.getElementById("check3").checked){
        contador++;
     }
     if(document.getElementById("check4").checked){
        contador++;
     }

     swal("usted tiene "+ contador +" lenguajes aprendidos")
}

/////////////////////////////////////////////////////////////////

function Vaciar(texto){
    document.getElementById("textito").value="";
}
function espacio(){
if(document.getElementById("textito").value==''){
    document.getElementById("textito").style.background="red"
    swal("No puede dejar espacio en blanco xd")
}
}

document.write("plugin: " , navigator.plugins.length)
















