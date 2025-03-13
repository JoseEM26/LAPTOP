(() => {
    const Padre = document.getElementById("parrafo"),
        fragmento = document.createDocumentFragment();

    fetch("https://jsonplaceholder.typicode.com/users")
        .then((resultado) => {
            return resultado.ok ? resultado.json() : Promise.reject(resultado);
        })
        .then((json) => {
            json.forEach(el => {
                let li = document.createElement("li");
                li.innerHTML = `${el.id}---${el.name}---${el.username}---${el.email}---`;
                fragmento.appendChild(li);
            });
            Padre.appendChild(fragmento);
        })
        .catch((error) => {
            let MensajeNum = error.status;
            let MensajeText = "Ocurrió un error";
            Padre.innerHTML = `${MensajeNum} : ${MensajeText}`;
        });

})();

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////



(() => {
    const Parrafo = document.getElementById("Parrafo-asynk"),  // Asegúrate de que este ID es único
        fragmento = document.createDocumentFragment();

    async function GetData() {
        try {
            let data = await fetch("https://jsonplaceholder.typicode.com/users ");
            let json = await data.json();

            if (!data.ok) throw { statuss: data.status, statusText: data.statusText };

            json.forEach((dato) => {
                let li = document.createElement("li");
                li.innerHTML = `${dato.id}---${dato.name}---${dato.username}---${dato.email}---`;
                fragmento.appendChild(li);
            });
            Parrafo.appendChild(fragmento);  // Asegúrate de que este elemento existe

        } catch (error) {
            Parrafo.innerHTML = `${error.statuss} : ${error.statusText} Ocurrrio un errror`;  // Asegúrate de que este mensaje sea correcto
        }
    }
    GetData();
})();


/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////

//uso necesario para usar axios 
//<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


(() => {
    const parrafo = document.getElementById("axios"),
        fragmento = document.createDocumentFragment();

    axios
        .get("https://jsonplaceholder.typicode.com/users")
        .then((res) => {

            let json = res.data;
            json.forEach((dato) => {
                const li = document.createElement("li");
                li.innerHTML = `${dato.id}---${dato.name}---${dato.username}---${dato.email}---`
                fragmento.appendChild(li)
            })
            parrafo.appendChild(fragmento);
        })
        .catch((error) => {
            let mensajeNum = error.response.status;
            let MensajeText = "ocurrio un error";
            parrafo.innerHTML = `${mensajeNum}:${MensajeText}`
        })
})();


/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////


(() => {
    const parrafo = document.getElementById("axiosAsyncrono"),
        fragmento = document.createDocumentFragment();

    async function GetData() {
        try {
            let Datos = await axios.get("https://jsonplaceholder.typicode.com/users");
            let json =  await Datos.data;

            json.forEach((dato) => {
                let li = document.createElement("li");
                li.innerHTML = `${dato.id}---${dato.name}---${dato.username}---${dato.email}---`;
                fragmento.appendChild(li);
            })
            parrafo.appendChild(fragmento);

        } catch (error) {
           let ErrorNumero=error.response.status;
           let ErrorTexto="Ocurrio un error"

               parrafo.innerHTML=`${ErrorNumero}: ${ErrorTexto}`;
        }
    }

    GetData();
})();














