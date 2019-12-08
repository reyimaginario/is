/*function getUrlVars() {
    var par = "file:///C:/Users/aguch/Desktop/Keep%20It%20Simple/IS/is/frontend/screens/show_test.html?id=1482".replace("file:///C:/Users/aguch/Desktop/Keep%20It%20Simple/IS/is/frontend/screens/show_test.html?id=", "")
    return par;
}*/

function getUrlVars() {
  var vars = {};
  var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(
    m,
    key,
    value
  ) {
    vars[key] = value;
  });
  return vars;
}

function getUrlParam(parameter, defaultvalue) {
  var urlparameter = defaultvalue;
  if (window.location.href.indexOf(parameter) > -1) {
    urlparameter = getUrlVars()[parameter];
  }
  return urlparameter;
}

function showResults() {
  var evaluacion_id = getUrlParam("id", "1482");
  console.log(evaluacion_id);

  var url = "http://localhost:8080/evaluacion/" + evaluacion_id + "/calcular";
  fetch(url, {
    method: "GET",
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      //saveResponse("resultados", JSON.stringify(data))
      crearLista(data);
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en showResults! :c");
    });
}

var titulos = [
  "Basicas",
  "Contenido",
  "Suplementarias",
  "Adicionales de Validez"
];

function crearLista(data) {
  //showResults()
  var tabla = document.getElementById("lista_preguntas");
  tabla.innerHTML = "";
  jason = data; //JSON.parse(sessionStorage.getItem("resultados"))
  console.log(jason);
  for (j = 0; j < titulos.length; j++) {
    crearTabla(titulos[j]);
    console.log(j);
  }
}

function crearTabla(titulo) {
  var lista = jason[0][titulo];
  console.log(lista);
  var tabla = document.getElementById("lista_preguntas");
  tabla.className = "result-table";
  var header = document.createElement("th");
  tabla.append(header);
  header.colSpan = 4;
  header.innerHTML = titulo;

  var body = document.createElement("tbody");
  //body.id = titulo;
  body.className = "form-group";
  tabla.appendChild(body);
  body.innerHTML = "";

  var topRow = document.createElement("tr");
  topRow.className = "form-group";
  body.appendChild(topRow);
  topRow.innerHTML =
    "<td ><h4>Escala</h4></td>" +
    "<td align='center'><h4>PB</h4></td>" +
    "<td align='center'><h4>PTF</h4></td>" +
    "<td align='center'><h4>PTM</h4></td>";

  for (i = 0; i < lista.length; i++) {
    var container = document.createElement("tr");
    container.className = "form-group";
    body.appendChild(container);
    container.innerHTML =
      "<td><a>" +
      lista[i].Escala.replace("SUBESCALA_", "") +
      "</a></td>" +
      "<td align='center'><a>" +
      lista[i].PB +
      "</a></td>" +
      "<td align='center'><a>" +
      (lista[i].PTF != null ? lista[i].PTF : "-") +
      "</a></td>" +
      "<td align='center'><a>" +
      (lista[i].PTM != null ? lista[i].PTM : "-") +
      "</a></td>";
  }
}

function saveResponse(name, data) {
  if (typeof Storage !== "undefined") {
    sessionStorage.setItem(name, data);
  } else {
    alert("No hay Local Storage! :c");
  }
}
