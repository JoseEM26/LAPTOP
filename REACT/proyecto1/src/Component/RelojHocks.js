import React, { useState, useEffect } from "react";

function Hora(props) {
    return (
        <>
            <h1>
                <br></br>
                <hr></hr>
                <h1>Reloj HOCKS</h1>
                {props.tiempo}
            </h1>
        </>
    )
}

export default function RelojHocks() {
    const [hora, setHora] = useState(new Date().toLocaleTimeString());
    const [visible, setVisible] = useState(false);


    useEffect(() => {

        let temporizador;

        if (visible) {
            temporizador = setInterval(() => {
                setHora(new Date().toLocaleTimeString())
            }, 1000)
        }else{
            clearInterval(temporizador)

        }
        // return(clearInterval(temporizador))
    }, [visible])



    return (
        <>
            {visible && <Hora tiempo={hora}></Hora>}
            <button onClick={() => setVisible(true)}>iNICIAR</button>
            <button onClick={() => setVisible(false)}>DETENER</button>
        </>
    )
}