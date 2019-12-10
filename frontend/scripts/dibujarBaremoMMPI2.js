var paramData = [{}];
var chart;

var formulario = document.getElementById("filtroform");

formulario.addEventListener("submit", function(e) {
  e.preventDefault();
});

function getBaremoData() {
  var url = "http://localhost:8080/baremo/filtrarburbuja/";
  var filtro = createJson();
  console.log(JSON.stringify(filtro));
  fetch(url, {
    method: "POST",
    //mode: 'no-cors',
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(filtro)
  })
    .then(res => res.json())
    .then(data => {
      console.log(JSON.stringify(data));
      var filterData = data;
      chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        zoomEnabled: true,
        axisX: {
          title: "Subescala"
        },
        axisY: {
          title: "Valor",
          maximum: 100,
          interval: 10
        },
        data: filterData
      });
      chart.render();
    })
    .catch(err => {
      console.error("Caught error: ", err);
      alert("Ocurrio un error en POST! :c");
    });
}

async function dibujar() {
  chart = new CanvasJS.Chart("chartContainer", {
    animationEnabled: true,
    zoomEnabled: true,
    axisX: {
      title: "Subescala"
    },
    axisY: {
      title: "Valor"
    },
    data: paramData
  });
  chart.render();
}

/*
var formulario = document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault()

    var url = 'http://localhost:8080/baremo/filtrarcoso/';
    var evaluacion = createJson()
    
    fetch(url, {
        method: 'GET',
        //mode: 'no-cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(evaluacion) 
    })

    .then( res => res.json())
    .then( data => {
        console.log(data)
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en POST! :c")
    });

    
});
*/

function createJson() {
  var datos = new FormData(formulario);
  var loc = document.getElementById("localidades");
  var ocu = document.getElementById("ocupaciones");
  var gen = document.getElementById("generos");
  var est = document.getElementById("estudios");

  var paramLocalidad = loc.options[loc.selectedIndex].value;
  var paramedadDesde = datos.get("edadDesde");
  var paramedadHasta = datos.get("edadHasta");
  var paramgenero = gen.options[gen.selectedIndex].value;
  var paramnivelDeEstudio = est.options[est.selectedIndex].value;
  var paramocupacion = ocu.options[ocu.selectedIndex].value;

  var filtro = {
    localidad: paramLocalidad === "" ? null : paramLocalidad,
    edadDesde: paramedadDesde === "" ? null : paramedadDesde,
    edadHasta: paramedadHasta === "" ? null : paramedadHasta,
    genero: paramgenero === "" ? null : paramgenero,
    nivelDeEstudio: paramnivelDeEstudio === "" ? null : paramnivelDeEstudio,
    ocupacion: paramocupacion === "" ? null : paramocupacion
  };

  return filtro;
}
