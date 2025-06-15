import React,{Component} from "react";


class Eventos extends Component{
  constructor(props){
  super(props);
  this.state={
    contador:0
  }
  this.sumar=this.sumar.bind(this)
  this.restar=this.restar.bind(this)
  }

  sumar(e){
    this.setState({
        contador:this.state.contador+1,
    })
  }

  restar(e){
    this.setState({
        contador:this.state.contador-1
    })
  }


  render(){
    return(
        <>
        <hr></hr>
        <h3>Contador Con Botones</h3>
        <p>{this.state.contador}</p>
        <button className="boton" onClick={this.sumar}>+</button>
        <button className="boton" onClick={this.restar}>-</button>
        
        </>
    );
  }
}


export default Eventos;