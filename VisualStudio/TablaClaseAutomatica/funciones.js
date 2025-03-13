

class persona{
    constructor(nombre, apellido , dni){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;

    }
    

     hablar( palabra) {
        return "yo digo "+"'"+palabra+"'";
    }
}   

let ListaPersona=[
 p1=new persona("nombre1","apellido1",11111),
 p2=new persona("nombre1","apellido1",11111 ),
 p3=new persona("nombre1","apellido1",11111),
 p4=new persona("nombre1","apellido1",11111),
 p5=new persona("nombre1","apellido1",11111),
 p6=new persona("nombre1","apellido1",11111),
]

function tabla(){
    let tabla=document.getElementById("cuerpoTabla");

    ListaPersona.forEach(p => {
        let tr=document.createElement("tr");
        let celdaNombre=document.createElement("td");
        let celdaApellido=document.createElement("td");
        let celdaDNI=document.createElement("td");

        celdaNombre.textContent=p.nombre;
        tr.appendChild(celdaNombre);

        celdaApellido.textContent=p.apellido;
        tr.appendChild(celdaApellido);

        celdaDNI.textContent=p.dni;
        tr.appendChild(celdaDNI);

         tabla.appendChild(tr);
        
    });
    

    


}






