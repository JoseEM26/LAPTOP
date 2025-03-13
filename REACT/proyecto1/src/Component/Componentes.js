import React,{Component} from "react";
import data from "./Frameworks.json"


function Contadorcito(props){
    return(
<>
     <h2>
        {props.contador2}
     </h2>
</>
    )

}

function Elementos (props){
    return(
     <li>
            <a href={props.enlace}>{props.name}</a>
     </li>
    );

}

class Componentes extends Component{
    constructor(props){
        super(props);
        this.state={
            contador:0,
            seasons:["otoño","primavera","invierno"]
        };

        setInterval(()=>{
            this.setState({contador:this.state.contador+1})

        },1000)


    }


   

    render(){
        return(
            <div>
                <h1 >{this.state.contador}</h1>
                <Contadorcito contador2={this.state.contador}/>
                <ul>
                    {this.state.seasons.map((i,index)=>
                        <li key={index}>{i}</li>
                   )}
                </ul>
                <hr></hr>
                <h3>Frameworks_:</h3>
                <ul>
                    {data.Frameworks.map((li,index)=>(
                        <Elementos key={index} name={li.nombre} enlace={li.enlace}></Elementos>
                    ))}
                </ul>

            </div>
        );
    }

}



//--------------------------------------------------------
//--------------------------------------------------------
export default Componentes;



















