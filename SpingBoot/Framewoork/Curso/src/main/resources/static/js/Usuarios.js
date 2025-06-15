// Call the dataTables jQuery plugin
$(document).ready(function() {

  CargarUsuario();

  $('#Usuarios').DataTable();
});

async function CargarUsuario(){

const Request = await fetch('usuario/9999', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await Request.json();

  console.log(usuarios);

}