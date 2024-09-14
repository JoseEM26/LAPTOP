import React from 'react'
import { useForm } from '../helpers/useForm'
import Loading from "../Components/Loading"

const initially = {
    name: "",
    email: "",
    subject: "",
    coment: "",

};

let styles = {
    color: "red",
    fontSize: "20px",
    padding: "0",
    margin: "0"
}

const validationForm = (form) => {
    let errores = {};
    let regexName = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
    let regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; 
    let regexComments = /^.{1,255}$/;

    if (!form.name.trim()) {
        errores.name = "Debe ingresar algun nombre"
    }else if(!regexName.test(form.name.trim())){
        errores.name="solo se permite ingresar letras y nombres"
    }

    if (!form.email.trim()) {
        errores.email = "Debe ingresar algun Correo Electronico"
    }else if(!regexEmail.test(form.email.trim())){
        errores.email="debe ingresar un comentario valido"
    }

    if (!form.subject.trim()) {
        errores.subject = "Debe ingresar algun Asunto"
    }

    if (!form.coment.trim()) {
        errores.coment = "Debe ingresar algun Comentario"
    }else if(!regexComments.test(form.coment.trim())){
        errores.coment="El campo solo acepta 255 caracteres"
    }

    return errores;
}

const ContatcForm = () => {
    const {
        form,
        loading,
        error,
        respuesta,
        handleChange,
        handleBlur,
        handleSubmit
    } = useForm(initially, validationForm)

    return (
        <>
            <h1>
                Validaciones de Formulario
            </h1>
            {loading && <Loading/>}
            <form onSubmit={handleSubmit}>
                <input
                    name='name'
                    type='text'
                    id='name'
                    placeholder='name'
                    required
                    onChange={handleChange}
                    value={form.name}
                    onBlur={handleBlur}
                />
                {error.name && <p style={styles}>{error.name}</p>}
                <br />
                <input
                    name='email'
                    type='text'
                    id='email'
                    placeholder='correo electronico'
                    required
                    onChange={handleChange}
                    onBlur={handleBlur}
                    value={form.email}
                />

                {error.email && <p style={styles}>{error.email}</p>}
                <br />
                <input
                    name='subject'
                    type='text'
                    id='subject'
                    placeholder='asunto a tratar'
                    required
                    onChange={handleChange}
                    onBlur={handleBlur}
                    value={form.subject}
                />
                {error.subject && <p style={styles}>{error.subject}</p>}
                <br />
                <textarea
                    id='coment'
                    placeholder='escribe tu comentario'
                    name='coment'
                    cols="50"
                    rows="5"
                    onChange={handleChange}
                    onBlur={handleBlur}
                    value={form.coment}
                />

                {error.coment && <p style={styles}>{error.coment}</p>}
                <br />
                <input
                    type='submit'
                    value="enviar"
                    id='button'
                />

            </form>
        </>
    )
}

export default ContatcForm