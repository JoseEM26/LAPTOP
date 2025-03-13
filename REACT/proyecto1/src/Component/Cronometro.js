import React,{Component} from "react";

class Cronometro extends Component{
   constructor(props){
    super(props);
    this.state={
        fecha:new Date().toLocaleTimeString(),
        mostrar:false
        
    };
    this.temporizador=null;
   }

   comenzar=()=>{
     this.temporizador=setInterval(()=>{
        this.setState({
            fecha:new Date().toLocaleTimeString()
        })
     },1000)
     this.setState({mostrar:true})
   }

   parar=()=>{
     clearInterval(this.temporizador)
     this.setState({mostrar:false})

   }


   render(){
    return(
        <>
        <hr></hr>
        <h1>Cronometro</h1>
        {this.state.mostrar && <h3>{this.state.fecha}</h3>}
        <button className="boton" onClick={this.comenzar}>COMENZAR</button>
        <button className="boton" onClick={this.parar}>DETENER</button>
        </>
    );
   }
}

export default Cronometro;













