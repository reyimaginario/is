const noRes = -1;
//const base_url = "http://192.168.0.127:8080"
const base_url = "http://localhost:8080"
var formulario = document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault()
    
    var url = base_url + "/evaluacion";
    var evaluacion = createJson()
    
    fetch(url, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(evaluacion) 
    })

    .then( res => res.json())
    .then( data => {
        console.log(data)

        saveResponse("evaluacion_id", JSON.stringify(data.evaluacionId))
        saveResponse("actual", 0)
        
        getPreguntas()
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en POST! :c")
    });    
});

function getPreguntas(){
    var url = base_url + "/test/mmpi2/preguntas"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
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

function cargarGeneros(opciones) {
    var lista = document.getElementById("generos")
    for (i = 0; i < Object.keys(opciones).length; i++){
        
        var container = document.createElement("option");
        container.id = "estudio" + opciones[i].generoId;
        container.value = opciones[i].generoId;
        lista.appendChild(container);
        container.innerHTML = opciones[i].genero;
    }
}

function cargarEstudios(opciones) {
    var lista = document.getElementById("estudios")
    for (i = 0; i < Object.keys(opciones).length; i++){
        
        var container = document.createElement("option");
        container.id = "estudio" + opciones[i].estudioId;
        container.value = opciones[i].estudioId;
        lista.appendChild(container);
        container.innerHTML = opciones[i].estudio;
    }
}

function cargarPantalla(){
    fetchGeneros();
    fetchEstudios();
    fetchLocalidades();
    fetchOcupaciones();
}

function fetchGeneros() {
    var url = base_url + "/genero"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        cargarGeneros(data)
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en GET genero! :c")
    });
}

function fetchEstudios(){
    url = base_url + "/estudio"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        cargarEstudios(data)
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en GET estudios! :c")
    });
}

function fetchOcupaciones(){
    url = base_url + "/ocupacion"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        cargarOcupaciones(data)
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en GET estudios! :c")
    });
}

function cargarOcupaciones(opciones) {
    var lista = document.getElementById("ocupaciones")
    for (i = 0; i < Object.keys(opciones).length; i++){
        
        var container = document.createElement("option");
        container.id = "ocupaciones" + opciones[i].ocupacionId;
        container.value = opciones[i].ocupacionId;
        lista.appendChild(container);
        container.innerHTML = opciones[i].ocupacion;
    }
}

function fetchLocalidades(){
    url = base_url + "/localidad"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        cargarLocalidades(data)
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en GET estudios! :c")
    });
}

function cargarLocalidades(opciones) {
    var lista = document.getElementById("localidades")
    for (i = 0; i < Object.keys(opciones).length; i++){
        
        var container = document.createElement("option");
        container.id = "localidad" + opciones[i].localidadId;
        container.value = opciones[i].localidadId;
        lista.appendChild(container);
        container.innerHTML = opciones[i].localidad;
    }
}

function createAnswers(preguntas){
    var lista = [];
    var evId = parseInt(sessionStorage.getItem("evaluacion_id"));
    
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