import React,{useState} from 'react'
import CrudForm from '../Componentes/CrudForm';
import CrudTable from '../Componentes/CrudTable';

 const ApiFormulario = () => {
    const [db, setDb] = useState(initialDB)
    const [dataToEdit, setDataToEdit] = useState(null)

    const createData=(data)=>{
      data.id=Date.now();
      setDb([
        ...db,data
      ])
    }
    
    const updateData=(data)=>{
      let newData=db.map((el)=>(
        el.id===data.id?data:el
      ))
      setDb(newData)
    }
    const deleteData=(id)=>{
        let isDelete=db.filter((el)=>(id!==el.id))
        setDb(isDelete);
    }

  return (
    <div id='contenedor'>
        <CrudForm
        createData={createData}
        updateData={updateData}
        dataToEdit={dataToEdit}
        setDataToEdit={setDataToEdit}
        />
        <CrudTable 
        deleteData={deleteData}
        setDataToEdit={setDataToEdit}
        data={db}/>

    </div>
  )
}


export default ApiFormulario;
