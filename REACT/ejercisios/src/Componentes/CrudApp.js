import React,{useState} from 'react'
import CrudForm from './CrudForm';
import CrudTable from './CrudTable';

const initialDB=[
    {
        id: 1,
        nombre: "Seiya",
        raza: "Pegaso",
      },
      {
        id: 2,
        nombre: "Shiryu",
        raza: "Dragón",
      },
      {
        id: 3,
        nombre: "Hyoga",
        raza: "Cisne",
      },
      {
        id: 4,
        nombre: "Shun",
        raza: "Andrómeda",
      },
      {
        id: 5,
        nombre: "Ikki",
        raza: "Fénix",
      },
]

 const CrudApp = () => {
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


export default CrudApp;
