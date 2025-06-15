import React, { useEffect, useState } from 'react'

const initialForm = {
  nombre: "",
  raza: "",
  id: null,
}

const Formulario = ({ createData, updateData, dataToUpdate, setDataToUpdate }) => {
  const [form, setForm] = useState(initialForm)

  useEffect(() => {
    if (dataToUpdate) {
      setForm(dataToUpdate)
    } else {
      setForm(initialForm)
    }
  }, [dataToUpdate])

  const handleChange = (e) => {
    setForm({
      ...form, [e.target.id]: e.target.value
    })
  }
  console.log(form)

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!form.nombre) {
      alert("no tiene todos los datos completos")
      return;
    }

    if (form.id === null) {
      createData(form)
    } else {
      updateData(form)
    }

    handleReset();
  }

  const handleReset = (e) => {
    setForm(initialForm);
    setDataToUpdate(null);
  }



  return (
    <>
      <h2>Actualizar</h2>
      <form onSubmit={handleSubmit}>
        <input
          type='text'
          id='nombre'
          name='nombre'
          placeholder='nombre'
          onChange={handleChange}
          value={form.nombre}
        />

        <input
          type='text'
          id='raza'
          name='raza'
          onChange={handleChange}
          value={form.raza}
          placeholder='raza'
        />

        <input
          type='submit'
          value="enviar"
        />
        <input
          type='reset'
          value="Limpiar"
          onClick={handleReset}
        />
      </form>
    </>
  )
}
export default Formulario;
