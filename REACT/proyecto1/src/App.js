import './App.css';
import Componentes from './Component/Componentes';
import Eventos from './Component/Eventos';
import { EventoPeronalizado } from './Component/EventoPersonalizado';
import Cronometro from './Component/Cronometro';
import Pokemon from './Component/Pokemon';
import ContadorHOCKS from './Component/ContadorHOCKS';
import RelojHocks from './Component/RelojHocks';
import PokemonHUCKS from './Component/PokemonHUCKS';
import ReferenciasHUCKS from './Component/ReferenciasHUCKS';
import Formularios from './Component/Formularios';

function App() {
  return (
    <div className="App">
      <Formularios></Formularios>
      
      <ReferenciasHUCKS></ReferenciasHUCKS>

      <PokemonHUCKS></PokemonHUCKS>

      <RelojHocks></RelojHocks>

      <ContadorHOCKS></ContadorHOCKS>

      <Pokemon></Pokemon>

      <Cronometro></Cronometro>
      
      <EventoPeronalizado></EventoPeronalizado>
      
      <Eventos></Eventos>
      
      <Componentes/>
      
    </div>
  );
}

export default App;
