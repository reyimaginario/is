var formulario = document.getElementById("formulario");
var url = "http://localhost:3000/chat/user/login/";

formulario.addEventListener("submit", function(e){
    e.preventDefault()

    var datos = new FormData(formulario);
    var booty = {
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
    
    fetch(url, {
        method: 'POST',
        mode: 'no-cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(booty) 
    })

    .then( res => res.json())
    .then( data => {
        console.log(data)
    })
    .catch(err => console.error('Caught error: ', err))
});