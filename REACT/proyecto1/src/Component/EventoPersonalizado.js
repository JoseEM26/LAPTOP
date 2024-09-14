import React,{Component} from "react";



export class EventoPeronalizado extends Component{
   state={
    contador:0
   }

aumentar=(e)=>{
  this.setState({
    contador:this.state.contador+1
  })
}
reducir=(e)=>{
    this.setState({
      contador:this.state.contador-1
    })
  }

  render(){
    return(
        <>
        <Hijo MyEventoAumentar={this.aumentar} MyEventoReducir={this.reducir} contador={this.state.contador}></Hijo>
        </>
    );
  }

}

function Hijo(props){
    return(
        <>
        <br></br>
        <h1>EventoPersonalizado</h1>
        <button onClick={props.MyEventoAumentar}>+</button>
        <button onClick={props.MyEventoReducir}>-</button>
        <h3>{props.contador}</h3>
        </>
    );
}






















































