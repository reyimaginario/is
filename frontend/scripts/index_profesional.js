
//const base_url = "http://192.168.0.127:8080"
const base_url = "http://localhost:8080"

function fetchSujetos(){
    url = base_url + "/profesional/11222333/obtenerSujetos"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        cargarSujetos(data)
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en fetchSujetos! :c")
    });
}

function cargarSujetos(sujetos) {
    var lista = document.getElementById("sujetos")
    for (i = 0; i < Object.keys(sujetos).length; i++){
        
        var container = document.createElement("option");
        container.id = "sujeto" + sujetos[i].dni;
        container.value = sujetos[i].dni;
        lista.appendChild(container);
        container.innerHTML = sujetos[i].nombre + " " + sujetos[i].apellido;
    }
}


function fetchEvaluaciones() {
    var dropdown = document.getElementById("sujetos")
    var dni = dropdown.children[dropdown.selectedIndex].value
    //console.log(dni)
    url = base_url + "/sujeto/" + dni + "/obtenerEvaluaciones"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        var dropdown_ev = document.getElementById("evaluaciones")
        dropdown_ev.innerHTML = "<option value='' hidden>Seleccione Evaluacion</option>"
        dropdown_ev.disabled = true
        var dropdown_test = document.getElementById("tests")
        dropdown_test.innerHTML = "<option value='' hidden>Seleccione Test</option>"
        dropdown_test.disabled = true
        cargarEvaluaciones(data)
        saveResponse("evaluaciones", JSON.stringify(data))
        //buildTree()
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en fetch Evs! :c")
    });

    //var dropdown = document.getElementById("evaluaciones")
    //dropdown.innerHTML = "<option value='' hidden>Seleccione Evaluacion</option>"
    
}

function cargarEvaluaciones(evs) {

    var lista = document.getElementById("evaluaciones")
    lista.innerHTML = "<option value='' hidden>Seleccione Evaluacion</option>"
    lista.disabled = false

    for (i = 0; i < Object.keys(evs).length; i++){
        if  (evs[i].finalizado === 1){
            var container = document.createElement("option");
            container.id = "evaluacion_" + evs[i].evaluacionId;
            container.value = evs[i].evaluacionId;
            lista.appendChild(container);
            container.innerHTML = evs[i].fechaInicio + " " + evs[i].motivo;
        }
    }
    
}

function cargarTests() {
    var dropdown = document.getElementById("evaluaciones")
    var id = dropdown.children[dropdown.selectedIndex].value
    
    var evs = JSON.parse(sessionStorage.getItem("evaluaciones"))
    
    var lista = document.getElementById("tests")
    lista.innerHTML = "<option value='' hidden>Seleccione Test</option>"
    lista.disabled = false

    for (i = 0; i < Object.keys(evs).length; i++){
        if (evs[i].evaluacionId == id){
            var tests = evs[i].listaTestsAplicadosDTO
            for (j = 0; j < Object.keys(tests).length; j++){
                var container = document.createElement("option");
                container.id = tests[j].testCode +"_" + tests[j].testAplicadoId;
                container.value = evs[i].evaluacionId;
                lista.appendChild(container);
                container.innerHTML = tests[j].testCode;
            }
        }
    }
}

function saveResponse(name, data){
    if (typeof(Storage) !== 'undefined') {
        sessionStorage.setItem(name, data)
    } else {
        alert("No hay Local Storage! :c")
    }
}