const d=document;
let $table = d.querySelector(".crud-table"),
    $titulo = d.querySelector(".crud-titulo"),
    $template = d.getElementById("crud-template").content,
    $formulario = d.querySelector(".crud-formulario"),
    $fragmento = d.createDocumentFragment();

d.addEventListener("DOMContentLoaded",async()=>{
    try {
        let resultado=await fetch("http://localhost:3000/gerreros"),
            json=await resultado.json();
        
            if(!resultado.ok) throw{errorTexto:resultado.statusText,errorNmero:resultado.status}

            json.forEach(el => {
                let $clon=d.importNode($template,true);
                $clon.querySelector(".nombre").innerHTML=el.nombre;
                $clon.querySelector(".raza").innerHTML=el.raza;
                
                $clon.querySelector(".editar").dataset.nombre=el.nombre;
                $clon.querySelector(".editar").dataset.raza=el.raza;
                $clon.querySelector(".editar").dataset.id=el.id;
                
                $clon.querySelector(".eliminar").dataset.id=el.id;

                $fragmento.appendChild($clon);
            });

            $table.querySelector("tbody").appendChild($fragmento);


    } catch (error) {
        $formulario.insertAdjacentHTML(`afterend","<p><b>${error.errorNmero}:${error.errorTexto}</b></p>`)
    }
});



d.addEventListener("click",async (e)=>{
    if(e.target.matches(".editar")){
        $formulario.nombre.value=e.target.dataset.nombre;
        $formulario.raza.value=e.target.dataset.raza;
        $formulario.id.value=e.target.dataset.id;
        $titulo.innerHTML="EditarGuerrero"

    }

    if(e.target.matches(".eliminar")){
        try {
            let opciones={
                method:"DELETE",
                headers:{"content-type":"application/json"}
            };
            let resultado=await fetch(`http://localhost:3000/gerreros/${e.target.dataset.id}`,opciones),
                json=await resultado.json();
    
                if(!resultado.ok) throw{errorTexto:resultado.statusText,errorNmero:resultado.status}
    
        
        } catch (error) {
        $table.insertAdjacentHTML("afterend",`<p><b>${error.errorNmero}:${error.errorTexto}</b></p>`)
        }
    }
})


d.addEventListener("submit",async (e)=>{
    if(e.target===$formulario){
        e.preventDefault;

        if(!e.target.id.value){
            try {
                let opciones={
                    method:"POST",
                    headers:{"content-type":"application/json"},
                    body:JSON.stringify({
                        nombre:e.target.nombre.value,
                        raza:e.target.raza.value,
                    })
                }
                let resultado=await fetch(`http://localhost:3000/gerreros`,opciones)  ,
                    json=await resultado.json();

                if(!resultado.ok) throw{errorTexto:resultado.statusText,errorNmero:resultado.status}

                    
            } catch (error) {
        $formulario.insertAdjacentHTML("afterend",`<p><b>${error.errorNmero}:${error.errorTexto}</b></p>`)
            }
        }

        if(e.target.id.value){
            try {
                let opciones={
                    method:"put",
                    headers:{"content-type":"application/json"},
                    body:JSON.stringify({
                        nombre:e.target.nombre.value,
                        raza:e.target.raza.value,
                    })
                }
                let resultado=await fetch(`http://localhost:3000/gerreros/${e.target.id.value}`,opciones)  ,
                    json=await resultado.json();

                if(!resultado.ok) throw{errorTexto:resultado.statusText,errorNmero:resultado.status}

                    
            } catch (error) {
        $formulario.insertAdjacentHTML("afterend",`<p><b>${error.errorNmero}:${error.errorTexto}</b></p>`)
            }
        }
    }
})






























