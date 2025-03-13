import React, { useState } from 'react'
import Formulario from './Formulario';
import Tabla from './Tabla';

const initialDB = [
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

const AppF = () => {
    const [db, setDb] = useState(initialDB)
    const [dataToUpdate, setDataToUpdate] = useState(null)

    const createData = (data) => {
        data.id=Date.now();
        setDb([
            ...db,data
        ])
    }
    const updateData = (data) => {
     let newData= db.map((el)=>(el.id===data.id?data:el))
     setDb(newData)
    }
    const EliminarData = (id) => {
    let newData=db.filter((el)=>(el.id!==id))
    setDb(newData);
    }

    return (
        <>
            <Formulario
                createData={createData}
                updateData={updateData}
                dataToUpdate={dataToUpdate}
                setDataToUpdate={setDataToUpdate}
            />

            <Tabla
                data={db}
                EliminarData={EliminarData}
                setDataToUpdate={setDataToUpdate}
            />
        </>
    )
}

export default AppF;
