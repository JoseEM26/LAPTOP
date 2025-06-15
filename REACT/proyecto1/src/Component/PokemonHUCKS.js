import React,{useState,useEffect} from "react";

function MostrarPokemon({imagen,nombre}){
return(
    <>
    <figure>
        <img src={imagen} alt={nombre}></img>
        <figcaption>{nombre}</figcaption>
    </figure>
    </>
)
}

export default function PokemonHUCKS(){
    const [PokemonList,setPokemonList]=useState([]);

    useEffect(()=>{
        let PokemonesAJAX= async ()=>{
            try {
                let res= await fetch("https://pokeapi.co/api/v2/pokemon/"),
                json= await res.json();

                let PokemonArreglo=[];
                for (const p of json.results) {
                    let res=await fetch(p.url),
                        json=await res.json();

                    let pokemonJSON={
                        nombre:json.name,
                        id:json.id,
                        imagen:json.sprites.front_shiny
                    }
                    PokemonArreglo.push(pokemonJSON);
                }
                setPokemonList(PokemonArreglo);

            } catch (error) {
                alert(`Ocurrio un error:${error}`)
            }


        }
        PokemonesAJAX();
    },[])

    return(
        <>
        <h1>POKEMONES CON HOCKS</h1>
        {PokemonList.length>0?(
            PokemonList.map((el)=>{
                return <MostrarPokemon key={el.id} imagen={el.imagen} nombre={el.nombre}></MostrarPokemon>
            })
        ):(<p>Cargando......</p>)}
        <hr></hr>
        </>
    )
}