import React, { useState } from "react";

export default function Formularios() {
    const [form,setForm]=useState({});

    const handleChange=(e)=>{
        setForm({
            ...form,[e.target.name]:e.target.value
        })
    }

    console.log(form)


    const handleChecked=(e)=>{
        setForm({
            ...form,[e.target.name]:e.target.checked
        })
    }

    const handleSubmit=(e)=>{
        e.preventDefault();
        alert("envio de formulario")
    
    }

    return (
        <>
            <h1>FORMULARIOS CON HOCKS</h1>
           <form id="formulario" onSubmit={handleSubmit}>

            
            <label htmlFor="nombre">Nombre:</label>
            <input
            type="text"
            id="nombre"
            name="nombre"
            onChange={handleChange}
            />

            <br/>   
            <br/>

            <p>Elije tu sabor favorito:</p>
            <input
            type="radio"
            name="sabor"
            value="vainilla"
            id="vainilla"
            onChange={handleChange}
            defaultChecked
            />
            <label htmlFor="vainilla"> vainilla</label>

            <input
            type="radio"
            name="sabor"
            value="Chocolate"
            onChange={handleChange}
            id="Chocolate"
            />
            <label htmlFor="Chocolate"> Chocolate</label>

            <input
            type="radio"
            name="sabor"
            onChange={handleChange}
            value="Fresa"
            id="Fresa"
            />
            <label htmlFor="Fresa"> Fresa</label>

            <input
            type="radio"
            onChange={handleChange}
            name="sabor"
            value="Nescuit"
            id="Nescuit"
            />
            <label htmlFor="Nescuit">Nescuit</label>

            

            <p>Elije tu lenguaje Favorito</p>
            <select id="lenguaje"
            onChange={handleChange}
            >
                <option value="---">---</option>
                <option value="React">React</option>
                <option value="VIU">VIU</option>
                <option value="AJAX">AJAX</option>
            </select>

<br/>
<br/>
            <label htmlFor="terminos">Activar terminos y condiciones</label>
            <input 
            type="checkbox"
            name="terminos"
            onChange={handleChecked}
            />

<br/>
<br/>

            <input
            type="submit"
            value="EnviarInformacion"
            
            />



           </form>
           <hr></hr>
        </>
    )
}