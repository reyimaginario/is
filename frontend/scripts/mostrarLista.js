var preguntas = JSON.parse(sessionStorage.getItem("preguntas"));
var respuestas = JSON.parse(sessionStorage.getItem("respuestas"));

function crearLista() {
  //console.log(preguntas)
  var lista = document.getElementById("lista_preguntas");
  var textoResp = "";
  for (i = 1; i < Object.keys(preguntas).length; i++) {
    if (respuestas[i - 1].respuesta === 1) {
      textoResp = "Verdadero";
    } else if (respuestas[i - 1].respuesta === 0) {
      textoResp = "Falso";
    } else if (respuestas[i - 1].respuesta === -1) {
      textoResp = "No Responde";
    } else {
      textoResp = "-";
    }
    var container = document.createElement("tr");
    container.id = "pregunta" + i;
    container.className = "form-group";
    container.onclick = (function(num) {
      return function() {
        volverA(num);
      };
    })(i);
    lista.appendChild(container);
    container.innerHTML =
      "<td align='right'><a id='pregId" +
      i +
      "'>" +
      respuestas[i - 1].pregunta +
      "</a></td>" +
      "<td><a class='tab' id='pregText" +
      i +
      "'>- " +
      preguntas[i] +
      "</a></td>" +
      "<td width=97px align='center'><a class='tab' id='pregText" +
      i +
      "'>" +
      textoResp +
      "</a></td>";
  }
}

function volverA(index) {
  sessionStorage.setItem("actual", index - 1);
  window.location.href = "../screens/pregunta.html";
}

function startTest() {
  document.getElementById("btn_show").hidden = true;
  var pregs = JSON.parse(sessionStorage.getItem("respuestas"));
  //document.getElementById("ela").innerHTML = sessionStorage.getItem("respuestas")
}

function finTest() {
  event.preventDefault();
  window.location.href = "../screens/gracias.html";
}

function sendResults() {
  event.preventDefault();
  var evId = sessionStorage.getItem("evaluacion_id");
  //var end_url= "http://localhost:8080/evaluacion/" + sessionStorage.getItem("evaluacion_id") + "/finalizar"

  var end_url =
    "http://localhost:8080/evaluacion/" + String(evId) + "/finalizar";

  console.log(end_url);

  fetch(end_url, {
    method: "GET",
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      saveResponse("evaluacion_finalizada", JSON.stringify(data));
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Este test ya ha finalizado.");
    });
}

function showResults() {
  event.preventDefault();
  window.location.href = "../screens/show_results.html";
}

function testFetch(url, options, timeout = 7000) {
  return Promise.race([
    fetch(url, options),
    new Promise((_, reject) =>
      setTimeout(() => reject(new Error("timeout")), timeout)
    )
  ]);
}

function saveResponse(name, data) {
  if (typeof Storage !== "undefined") {
    sessionStorage.setItem(name, data);
  } else {
    alert("No hay Local Storage! :c");
  }
}
