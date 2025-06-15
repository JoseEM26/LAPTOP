import React from 'react'
import "./Modales.css"

const Modal = ({children,inicio,closeModel}) => {
    const handleModelClick=(e)=>e.stopPropagation();
  return (
    <article className={`seccion ${inicio && "is-open"}`} onClick={closeModel}>
        <div className='contenedor' onClick={handleModelClick}>
        <button className='boton' onClick={closeModel}>X</button>
        {children}
        </div>
    </article>
  )
}

export default Modal