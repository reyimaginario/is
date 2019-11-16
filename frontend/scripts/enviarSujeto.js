var formulario = document.getElementById("formulario");
var url = "http://192.168.0.127:8080/evaluacion";
//var url = "http://localhost:8080/evaluacion";

formulario.addEventListener("submit", function(e){
    e.preventDefault()

    var evaluacion = createJson()
    
    fetch(url, {
        method: 'POST',
        //mode: 'no-cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(evaluacion) 
    })

    .then( res => res.json())
    .then( data => {
        console.log(data)
        
        saveResponse("evaluacion", JSON.stringify(data.evaluacion))
        saveResponse("preguntas", JSON.stringify(data.evaluacion.listaTestsAplicadosDTO[0].listaPreguntas))
        saveResponse("actual", 0)
        //ACA createAnswers y guardar en sesStor
        window.location.href = "pregunta.html";
        
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error! :c")
    });
});

function saveResponse(name, data){
    if (typeof(Storage) !== 'undefined') {
        sessionStorage.setItem(name,data)
        /*sessionStorage.getItem("key")
        sessionStorage.removeItem("key")
        sessionStorage.clear()*/
    // Código cuando Storage es compatible
    } else {
        alert("No hay Local Storage! :c")
    // Código cuando Storage NO es compatible
    }
}


function createJson(){
    var datos = new FormData(formulario);

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
            listaPreguntas:[{
                "id": "001",
                "texto": "mayor a 18?"
            },
            {
                "id": "002",
                "texto": "mayor a 21?"
            },
            {
                "id": "003",
                "texto": "mayor a 40?"
            },
            {
                "id": "004",
                "texto": "mayor a 70?"
            }],
            listaRespuestasDTO:[]
        }],
        informe: ""
    };

    return evaluacion
}