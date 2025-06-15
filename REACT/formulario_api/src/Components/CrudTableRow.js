import React from 'react'

 const CrudTableRow = ({el,deleteData,setDataToEdit}) => {

  return (
        <tr>
            <td>{el.nombre}</td>
            <td>{el.raza}</td>
            <td>
                <button onClick={()=>setDataToEdit(el)}>Editar</button>
                <button onClick={()=>deleteData(el.id)}>Eliminar</button>
            </td>
        </tr>
  )
}

export default CrudTableRow;