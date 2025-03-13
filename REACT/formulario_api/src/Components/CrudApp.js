import React, { useEffect, useState } from 'react'
import CrudForm from './CrudForm';
import CrudTable from './CrudTable';
import helpHttps from '../helpers/helpHttps';
import Mensaje from './Mensaje';
import Loading from './Loading';



const CrudApp = () => {
  const [db, setDb] = useState(null)
  const [dataToEdit, setDataToEdit] = useState(null)
  const [loader, setloader] = useState(false)
  const [mensaje, setmensaje] = useState(null)

  const api = helpHttps();
  const url = "http://localhost:5000/guerreros";

  useEffect(() => {
    setloader(true)

    api.get(url).then((res) => {

      if (!res.error) {
        setDb(res)
        setmensaje(null)
      } else {
        setDb([])
        setmensaje(res)
      }
      setloader(false)
    });

  }, [])

  const createData = (data) => {

    let id = Date.now().toString();

    data.id = id;

    const options = {
      headers: { "content-type": "application/json" },
      body: data
    }
    api.post(url, options).then((res) => {
      if (!res.error) {
        setDb([...db, res])
      } else {
        alert(`${res.errorT}:${res.errorN}`)
      }
    })

  }

  const updateData = (data) => {
    const options = {
      methoad: { "content-type": "application/json" },
      body: data
    };
    const urlUpdate = `${url}/${data.id}`

    api.put(urlUpdate, options).then((res) => {
      if (!res.error) {
        let newData = db.map((el) => (
          el.id === data.id ? data : el
        ))
        setDb(newData)
      }
    })
  }


  const deleteData = (id) => {

    let options = {
      headers: { "content-type": "application/json" }
    }

    api.del(`${url}/${id}`, options).then((res) => {
      if (!res.error) {
        let isDelete = db.filter((el) => (id !== el.id))
        setDb(isDelete);
      }
    })
  }

  return (
    <div id='contenedor'>
      <CrudForm
        createData={createData}
        updateData={updateData}
        dataToEdit={dataToEdit}
        setDataToEdit={setDataToEdit}
      />



      {db && <CrudTable
        deleteData={deleteData}
        setDataToEdit={setDataToEdit}
        data={db} />}
      {loader && <Loading />}
      {mensaje && <Mensaje error={mensaje} />}
    </div>
  )
}


export default CrudApp;
