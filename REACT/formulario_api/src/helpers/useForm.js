import { useState } from 'react'
import helpHttps from './helpHttps';

export const useForm = (initially,validationForm) => {
    const [form, setform] = useState(initially)
    const [loading, setloading] = useState(false)
    const [error, seterror] = useState({})
    const [respuesta, setrespuesta] = useState(null)

    const handleChange = (e) => { 
        setform({
            ...form,[e.target.name]:e.target.value
        })
    }
    const handleBlur = (e) => {
        // handleChange(e);
        seterror(validationForm(form));
     };

    const handleSubmit = (e) => { 
        e.preventDefault();
        seterror(validationForm(form))

        if(Object.keys(error).length===0){
            alert("enviando un documento")
            setloading(true);
            helpHttps().post("https://formspree.io/f/xovabbyj",{
                body:form,
                headers:{
                    "content-type":"application/json",
                    Accept:"application/json"
                }
            }).then((res)=>{
                setloading(false);
                setrespuesta(true);
                setform(initially)
                setTimeout(
                   ()=> setloading(false),5000
                ) 

            })
        }else{
            return;
        }
        
    }

    return {
        form, loading, error, respuesta, handleChange, handleBlur, handleSubmit
    };
}
