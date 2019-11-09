var formulario = document.getElementById("formulario");
var url = "http://192.168.0.127:8080/evaluacion";

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
        //sessionStorage.setItem("evaluacion", data)
        //ACA GUARDAR LA RESPUESTA EN EL LOCAL STORAGE DEL BROWSER
        //JSON CON PREGUNTAS, JSON CON EVALUACION, CREAR EL INDICE PARA RECORRER LAS PREGUNTAS
        //cargar nueva pagina
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error! :c")
    });
});

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
            listaPreguntas:[],
            listaRespuestasDTO:[]
        }],
        informe: ""
    };

    return evaluacion
}