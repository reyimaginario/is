var preguntas = JSON.parse(sessionStorage.getItem("preguntas"))
var respuestas = JSON.parse(sessionStorage.getItem("respuestas"))

//const base_url = "http://192.168.0.127:8080"
const base_url = "http://localhost:8080"

function crearLista(sujetos) {
    var lista = document.getElementById("lista_sujetos");
    
    for (i = 0; i < Object.keys(sujetos).length; i++) {
        var container = document.createElement("tr");
        container.id = "linea_sujeto" + i;
        container.className = "form-group";
        container.onclick = function (num) {
            return function () {
                volverA(num);
            };
        }(i);
        lista.appendChild(container);
        container.innerHTML =   "<td><a id='sujeto" + i + "'>" + sujetos[i].nombre + " " + sujetos[i].apellido + "</a></td>" 
    }
}

function volverA(index){
    sessionStorage.setItem("actual", index-1)
    window.location.href = "../screens/pregunta.html";
}

function cargarSujetos(){
    url = base_url + "/profesional/11222333/obtenerSujetos"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        crearLista(data)
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

function saveResponse(name, data){
    if (typeof(Storage) !== 'undefined') {
        sessionStorage.setItem(name,data)
    } else {
        alert("No hay Local Storage! :c")
    }
}
