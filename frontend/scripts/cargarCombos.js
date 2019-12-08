const base_url_cmb = "http://localhost:8080";

function cargarGeneros(opciones) {
  var lista = document.getElementById("generos");
  for (i = 0; i < Object.keys(opciones).length; i++) {
    var container = document.createElement("option");
    container.id = "estudio" + opciones[i].generoId;
    container.value = opciones[i].genero;
    lista.appendChild(container);
    container.innerHTML = opciones[i].genero;
  }
}

function cargarEstudios(opciones) {
  var lista = document.getElementById("estudios");
  for (i = 0; i < Object.keys(opciones).length; i++) {
    var container = document.createElement("option");
    container.id = "estudio" + opciones[i].estudioId;
    container.value = opciones[i].estudio;
    lista.appendChild(container);
    container.innerHTML = opciones[i].estudio;
  }
}

function cargarPantalla() {
  fetchGeneros();
  fetchEstudios();
  fetchLocalidades();
  fetchOcupaciones();
}

function fetchGeneros() {
  var url = base_url_cmb + "/genero";

  fetch(url, {
    method: "GET",
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      cargarGeneros(data);
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en GET genero! :c");
    });
}

function fetchEstudios() {
  url = base_url_cmb + "/estudio";

  fetch(url, {
    method: "GET",
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      cargarEstudios(data);
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en GET estudios! :c");
    });
}

function fetchOcupaciones() {
  url = base_url_cmb + "/ocupacion";

  fetch(url, {
    method: "GET",
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      cargarOcupaciones(data);
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en GET estudios! :c");
    });
}

function cargarOcupaciones(opciones) {
  var lista = document.getElementById("ocupaciones");
  for (i = 0; i < Object.keys(opciones).length; i++) {
    var container = document.createElement("option");
    container.id = "ocupaciones" + opciones[i].ocupacionId;
    container.value = opciones[i].ocupacion;
    lista.appendChild(container);
    container.innerHTML = opciones[i].ocupacion;
  }
}

function fetchLocalidades() {
  url = base_url_cmb + "/localidad";

  fetch(url, {
    method: "GET",
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      cargarLocalidades(data);
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en GET estudios! :c");
    });
}

function cargarLocalidades(opciones) {
  var lista = document.getElementById("localidades");
  for (i = 0; i < Object.keys(opciones).length; i++) {
    var container = document.createElement("option");
    container.id = "localidad" + opciones[i].localidadId;
    container.value = opciones[i].localidad;
    lista.appendChild(container);
    container.innerHTML = opciones[i].localidad;
  }
}
