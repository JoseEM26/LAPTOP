const d = document;
let $table = d.querySelector(".crud-table"),
    $titulo = d.querySelector(".crud-titulo"),
    $template = d.getElementById("crud-template").content,
    $formulario = d.querySelector(".crud-formulario"),
    fragmento = d.createDocumentFragment();

// Leer/READ
d.addEventListener("DOMContentLoaded", async () => {
    try {
        const resultado = await fetch("http://localhost:3000/gerreros"),
            json = await resultado.json();
        if (!resultado.ok) throw { errorNumero: resultado.status, ErrorText: "ocurrio un error" };

        json.forEach(el => {
            $clon = d.importNode($template, true);
            $clon.querySelector(".nombre").innerHTML = el.nombre;
            $clon.querySelector(".raza").innerHTML = el.raza;

            // almacenamos el indice en el boton
            $clon.querySelector(".eliminar").dataset.id = el.id;
            //le creamos un data Propiedad a los botones para que almacenen nuestro datos
            $clon.querySelector(".editar").dataset.id = el.id;
            $clon.querySelector(".editar").dataset.nombre = el.nombre;
            $clon.querySelector(".editar").dataset.raza = el.raza;
            /////////////////////////////////////////////

            fragmento.appendChild($clon);
        });
        $table.querySelector("tbody").appendChild(fragmento);

    } catch (error) {
        $table.insertAdjacentHTML("afterend", `<p>${error.errorNumero}:${error.ErrorText}</p>`);
    }

})

//Los prodedimiento crud-prup

d.addEventListener("submit", async (e) => {
    if (e.target === $formulario) {
        e.preventDefault();

        if (!e.target.id.value) {
            //Create----POST
            try {
                let opciones = {
                    method: "POST",
                    headers: {
                        "content-type": "application/json"
                        // "content-type": "application/json; charset=utf-8"
                    },
                    body: JSON.stringify({
                        nombre: e.target.nombre.value,
                        raza: e.target.raza.value,
                    })
                };
                let resultado = await fetch("http://localhost:3000/gerreros", opciones),
                    json = await resultado.json();

                location.reload();

                if (!resultado.ok) throw { errorNumero: resultado.status, ErrorText: "ocurrio un error" };

            } catch (error) {
                $table.insertAdjacentHTML("afterend", `<p>${error.errorNumero}:${error.ErrorText}</p>`);
            }

        } else {
            //Update----PUT
            try {
                let opciones = {
                    method: "PUT",
                    headers: {
                        "content-type": "application/json"
                        // "content-type": "application/json; charset=utf-8"
                    },
                    body: JSON.stringify({
                        nombre: e.target.nombre.value,
                        raza: e.target.raza.value,
                    })
                };
                let resultado = await fetch(`http://localhost:3000/gerreros/${e.target.id.value}`, opciones),
                    json = await resultado.json();

                location.reload();

                if (!resultado.ok) throw { errorNumero: resultado.status, ErrorText: "ocurrio un error" };

            } catch (error) {
                $table.insertAdjacentHTML("afterend", `<p>${error.errorNumero}:${error.ErrorText}</p>`);
            }
        }


    }
})


//colocar Los Datos En el formulario
d.addEventListener("click", async (e) => {
    if (e.target.matches(".editar")) {
        $titulo.innerHTML = "Editar Gerreros"
        $formulario.nombre.value = e.target.dataset.nombre;
        $formulario.raza.value = e.target.dataset.raza;
        $formulario.id.value = e.target.dataset.id;
    }

    if (e.target.matches(".eliminar")) {
        try {
            let opciones = {
                method: "DELETE",
                headers: {
                    "content-type": "application/json"
                    // "content-type": "application/json; charset=utf-8"
                }
            };
            let resultado = await fetch(`http://localhost:3000/gerreros/${e.target.dataset.id}`, opciones),
                json = await resultado.json();

            location.reload();

            if (!resultado.ok) throw { errorNumero: resultado.status, ErrorText: "ocurrio un error" };

        } catch (error) {
            $table.insertAdjacentHTML("afterend", `<p>${error.errorNumero}:${error.ErrorText}</p>`);
        }
    }
})
