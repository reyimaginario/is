var paramData = [
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [

    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [

    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [

    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [

    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [

    ]
  }
];

var chart;

function getBaremoData() {
  var url = 'http://localhost:8080/baremo/filtrarcoso/';
    var filtro = createJson()
    
    fetch(url, {
        method: 'POST',
        //mode: 'no-cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(filtro) 
    })
    .then( res => res.json())
    .then( data => {
        console.log(JSON.stringify(data))
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
        chart.render()
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en POST! :c")
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
  chart.render()
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

function createJson(){
 /* var datos = new FormData(formulario);

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
          localidad: datos.get("localidad"),
          edad: datos.get("edad"),
          genero: datos.get("genero"),
          nivelDeEstudio: datos.get("nivelDeEstudio"),
          ocupacion: datos.get("ocupacion"),
          profesionalDTO: {
              dni: "11222333",
              nombre: "",
              matricula: "",
              apellido: "",
              listaSujetosDTO: []
          }
      },
      listaTestsAplicadosDTO: [{
          testCode:"mmpi2",
          listaRespuestasDTO:[]
      }],
      informe: ""
  };*/

  return {};
}