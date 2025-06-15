import './App.css';
import CrudApp from './Componentes/CrudApp';
import AppF from './Formulario2/AppF';
import ApiFormulario from './FormularioAPi/ApiFormulario';

function App() {
  return (
    <div>
      <h1>Formulario Crud</h1>
      <ApiFormulario/>
      <br/>
      <br/>
      <hr/>
      <hr/>
      <hr/>
      <hr/>
      <AppF/>
      <br/>
      <br/>
      <hr/>
      <hr/>
      <hr/>
      <hr/>
      <CrudApp/>
      
    </div>
  );
}

export default App;
