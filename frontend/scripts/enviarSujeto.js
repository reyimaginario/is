const noRes = -1;
//const base_url = "http://192.168.0.127:8080"
const base_url = "http://localhost:8080";
var formulario = document.getElementById("formulario");

formulario.addEventListener("submit", function(e) {
  e.preventDefault();

  var url = base_url + "/evaluacion";
  var evaluacion = createJson();
  console.log(evaluacion);
  fetch(url, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(evaluacion)
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);

      saveResponse("evaluacion_id", JSON.stringify(data.evaluacionId));
      saveResponse("actual", 0);

      getPreguntas();
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en POST! :c");
    });
});

function getPreguntas() {
  var url = base_url + "/test/mmpi2/preguntas";

  fetch(url, {
    method: "GET",
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      saveResponse("preguntas", JSON.stringify(data));
      //ACA createAnswers y guardar en sesStor
      var respuestas = createAnswers(data);
      saveResponse("respuestas", JSON.stringify(respuestas));

      window.location.href = "pregunta.html";
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en GET! :c");
    });
}

function saveResponse(name, data) {
  if (typeof Storage !== "undefined") {
    sessionStorage.setItem(name, data);
  } else {
    alert("No hay Local Storage! :c");
  }
}

function createAnswers(preguntas) {
  var lista = [];
  var evId = parseInt(sessionStorage.getItem("evaluacion_id"));

  for (i = 1; i <= Object.keys(preguntas).length; i++) {
    var respuesta = {
      evaluacionId: evId,
      testCode: "mmpi2",
      pregunta: i,
      respuesta: noRes
    };
    lista.push(respuesta);
  }
  return lista;
}

function createJson() {
  var datos = new FormData(formulario);
  var loc = document.getElementById("localidades");
  var ocu = document.getElementById("ocupaciones");
  var gen = document.getElementById("generos");
  var est = document.getElementById("estudios");

  var evaluacion = {
    evaluacionId: null,
    fechaInicio: "",
    fechaFin: "",
    motivo: "psicotecnico",
    profesionalDTO: {
      dni: "11222333",
      matricula: "",
      nombre: "",
      apellido: "",
      listaSujetosDTO: []
    },
    sujetoDTO: {
      dni: datos.get("dni"),
      nombre: datos.get("nombre"),
      apellido: datos.get("apellido"),
      localidad: loc.options[loc.selectedIndex].value,
      edad: datos.get("edad"),
      genero: gen.options[gen.selectedIndex].value,
      nivelDeEstudio: est.options[est.selectedIndex].value,
      ocupacion: ocu.options[ocu.selectedIndex].value,
      profesionalDTO: {
        dni: "11222333",
        nombre: "",
        matricula: "",
        apellido: "",
        listaSujetosDTO: []
      }
    },
    listaTestsAplicadosDTO: [
      {
        testCode: "mmpi2",
        listaRespuestasDTO: []
      }
    ],
    informe: ""
  };

  return evaluacion;
}
