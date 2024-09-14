import React from 'react'
import TablaRow from './TablaRow';

 const Tabla = ({data,setDataToUpdate,EliminarData}) => {
  return (
    <>
    <h3>Tabla de Personajes</h3>
    <table>
        <thead>
            <tr>
                <td>Nombre</td>
                <td>Raza</td>
                <td>Acciones</td>
            </tr>
        </thead>
        <tbody>
            {data.length===0?(
                <td style={{color:"red"}}>No hay datos</td>
            ):(
                data.map((el,index)=>(
                    <TablaRow 
                    el={el}
                    key={index}
                    setDataToUpdate={setDataToUpdate}
                    EliminarData={EliminarData}
                    />
               ))
            )}
        </tbody>
    </table>
    </>
  )
}

export default Tabla;
