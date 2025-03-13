import React from 'react'

const TablaRow = ({ el, setDataToUpdate,EliminarData }) => {
  return (
    <>
      <tr>
        <td>{el.nombre}</td>
        <td>{el.raza}</td>
        <td>
        <button onClick={()=>setDataToUpdate(el)}>Editar</button>
        <button onClick={()=>EliminarData(el.id)}>Eliminar</button>
        </td>
      </tr>
    </>
  )
}

export default TablaRow;
