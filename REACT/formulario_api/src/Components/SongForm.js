import React,{useState} from 'react'

const initialForm={
    autor:"",
    musica:"",
};

 const SongForm = ({handleSearch}) => {
    const [form, setform] = useState(initialForm)

    const handleChange=(e)=>{
        setform({
            ...form,[e.target.name]:e.target.value
        })
    }
    

    const handleSubmit=(e)=>{
        e.preventDefault();

        if(!form.autor || !form.musica){
            alert("Ingresa todos los datos completos")
            return;
        }

        handleSearch(form);

        setform(initialForm)
    }
    // console.log(form)

  return (
    <>
    <form onSubmit={handleSubmit}>
        <input
        type='text'
        name='autor'
        id='autor'
        placeholder='Autor'
        onChange={handleChange}
        value={form.autor}
        />

        <input
        type='text'
        name='musica'
        id='musica'
        placeholder='Musica'
        onChange={handleChange}
        value={form.musica}
        />

        <input
        type='submit'
        />
    </form>
    </>
  )
}

export default SongForm;