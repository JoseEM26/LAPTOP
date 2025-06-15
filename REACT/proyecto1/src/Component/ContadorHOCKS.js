import React,{useState} from "react";


export default function ContadorHOCKS(){
    const [numero,setNumero]=useState(0);

   const suma=()=> setNumero(numero+1)
   const resta=()=> setNumero(numero-1)

    return(
        <>
        <h1>Contador con HOCKs</h1>
        <h3>{numero}</h3>
        <button onClick={suma}>+</button>
        <button onClick={resta}>-</button>
        </>
    )
}