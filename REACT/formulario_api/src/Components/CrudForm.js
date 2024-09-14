import React, { useEffect, useState } from 'react'

const initialForm = {
  id: null,
  nombre: "",
  raza: "",
}

const CrudForm = ({ createData, updateData, dataToEdit, setDataToEdit }) => {
  const [form, setForm] = useState(initialForm)

  useEffect(() => {
    if (dataToEdit) {
      setForm(dataToEdit)
    } else {
      setForm(initialForm)
    }

  }, [dataToEdit])


  const handleChange = (e) => {
    setForm({
      ...form, [e.target.id]: e.target.value
    })
  }


  const handleSubmit = (e) => {
    e.preventDefault();
    if (!form.nombre) {
      alert("conpleta todos los campos")
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
    setDataToEdit(null)
  }

  return (
    <div>
      <h3>{dataToEdit?"Agregar>>>>>":"Actualizar>>>"}</h3>
      <form onSubmit={handleSubmit}>
        <input
          type='text'
          id='nombre'
          onChange={handleChange}
          placeholder='nombre'
          value={form.nombre}
        />

        <input
          type='text'
          id='raza'
          onChange={handleChange}
          placeholder='raza'
          value={form.raza}
        />

        <input
          type='submit'
          id='enviar'
          value="Enviar"
        />
        <input
          type='reset'
          id='eliminar'
          value="Eliminar"
          onClick={handleReset}
        />
      </form>
    </div>
  )
}

export default CrudForm;
