import React, { Component } from "react";

function CuerpoPokemon(props){
  return(
    <>
        
         <h1>Pokemones</h1>
         <figure>
          <img src={props.url} alt={props.nombre}></img>
          <figcaption>{props.nombre}</figcaption>
         </figure>

    </>
  )
}

export default class Pokemon extends Component{
  state={
    pokemonState:[]
  }

  async componentDidMount(){
    try {
      let respuesta=await fetch("https://pokeapi.co/api/v2/pokemon/"),
          json     =await respuesta.json();

          // console.log(json);

          let pokemonesLista=[];
          for(let pokemones of json.results ){
            let res=await fetch(pokemones.url),
                json=await res.json();

                // console.log(json)

                let pokemonJSON={
                  id:json.id,
                  nombre:json.name,
                  imagen:json.sprites.front_shiny
                }

                pokemonesLista.push(pokemonJSON);

          }

          this.setState({pokemonState:pokemonesLista})

    } catch (error) {
      console.log(`Ocurrio un error:`,error);
    }
  }

  render() {
    return (
      <>
        <br></br>
        <br></br>
        <hr></hr>
        {this.state.pokemonState.length === 0 ? (
          <h3>CARGANDO........</h3>
        ) : (
          this.state.pokemonState.map((el) => (
            <CuerpoPokemon url={el.imagen} key={el.id} nombre={el.nombre} />
          ))
        )}
      </>
    );
  }
  

}
// function Pokemon(props) {
//   return (
//     <figure>
//       <img src={props.avatar} alt={props.name} />
//       <figcaption>{props.name}</figcaption>
//     </figure>
//   );
// }

// export default class AjaxApis extends Component {
//   state = {
//     pokemons: [],
//   };

//   async componentDidMount() {
//     let url = "https://pokeapi.co/api/v2/pokemon/";

//     try {
//       const res = await fetch(url);
//       const json = await res.json();

//     //   console.log(json  )

//       // Array para almacenar los Pokémon
//       let pokemonList = [];

//       for (const el of json.results) {
//         const res = await fetch(el.url);
//         const json = await res.json();

// console.log(json);

//         let pokemonJSON = {
//           id: json.id,
//           name: json.name,
//           avatar: json.sprites.back6_shiny,
//         };

//         // Añadir el Pokémon al array
//         pokemonList.push(pokemonJSON);
//       }

//       // Actualizar el estado una sola vez
//       this.setState({ pokemons:pokemonList });

//     } catch (error) {
//       console.error("Error fetching the Pokémon data:", error);
//     }
//   }

//   render() {
//     return (
//       <>
//         <h2>Peticiones Asíncronas en Componentes de Clase</h2>
//         {this.state.pokemons.length === 0 ? (
//           <h3>Cargando...</h3>
//         ) : (
//           this.state.pokemons.map((el) => (
//             <Pokemon key={el.id} name={el.name} avatar={el.avatar} />
//           ))
//         )}
//       </>
//     );
//   }
// }
