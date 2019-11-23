const noRes = -1;

var formulario = document.getElementById("formulario");
//var url = "http://localhost:8080/evaluacion";

formulario.addEventListener("submit", function(e){
    e.preventDefault()

    //var url = "http://localhost:8080/evaluacion";
    var url = "http://192.168.0.127:8080/evaluacion";
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

        saveResponse("evaluacion_id", JSON.stringify(data.evaluacionId))
        saveResponse("actual", 0)
        
        getPreguntas()

        //
        
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en POST! :c")
    });

    
});

function getPreguntas(){
    var url = "http://192.168.0.127:8080/test/mmpi2/preguntas"
    //var url = "http://localhost:8080/test/mmpi2/preguntas"
    fetch(url, {
        method: 'GET',
        //credentials: 'include',
        //mode: 'no-cors',
        headers: {'Content-Type': 'application/json'},
        //body: JSON.stringify(booty) //{"username": "mediavla", "password": "123"}//datos
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        saveResponse("preguntas", JSON.stringify(data))
        //ACA createAnswers y guardar en sesStor
        var respuestas = createAnswers(data);
        saveResponse("respuestas", JSON.stringify(respuestas));

        window.location.href = "pregunta.html";
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en GET! :c")
    });

}


function saveResponse(name, data){
    if (typeof(Storage) !== 'undefined') {
        sessionStorage.setItem(name,data)
    } else {
        alert("No hay Local Storage! :c")
    }
}



function createAnswers(preguntas){
    var lista = [];
    var evId = parseInt(sessionStorage.getItem("evaluacion_id"));
    //var preguntas = JSON.parse(sessionStorage.getItem("preguntas"));
    
    //if(JSON.parse(sessionStorage.getItem("respuestas")) === null){
        
    for (i = 1; i <= Object.keys(preguntas).length; i++){
        var respuesta = {
            "evaluacionId": evId,
            "testCode": "mmpi2",
            "pregunta": i,
            "respuesta": noRes
        };
        lista.push(respuesta);
    }
    return lista
    /*}else{
        return JSON.parse(sessionStorage.getItem("respuestas"))
    }*/
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
            listaRespuestasDTO:[]
        }],
        informe: ""
    };

    return evaluacion
}