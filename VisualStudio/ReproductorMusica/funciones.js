let audio = document.getElementById("audio");
let ListaMusica = document.getElementById("listaCanciones");

ListaMusica.addEventListener("change", () => {
    let cancionElegida = ListaMusica.value;
    audio.src = cancionElegida;
    audio.play();
});