
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
        buildTree()
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en fetchSujetos! :c")
    });
}


//thisone
function cargarSujetos(sujetos) {
    var lista = document.getElementById("sujetos_header")
    var container = document.createElement("ul");
    container.className = "nested";
    lista.appendChild(container);
    lista = container

    for (i = 0; i < Object.keys(sujetos).length; i++){
        
        var container = document.createElement("li");
        container.id = "sujeto_" + sujetos[i].dni;
        //container.className = "nested";
        //container.value = opciones[i].ocupacionId;
        fetchTests(sujetos[i].dni, container)
        container.innerHTML = "<span class='caret'>" + sujetos[i].nombre + " " + sujetos[i].apellido + "</span>"
        lista.appendChild(container);
    }
}

function fetchTests(dni, lista) {
    url = base_url + "/sujeto/" + dni + "/obtenerEvaluaciones"
    
    fetch(url, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    })
    .then( res => res.json())
    .then( data => {
        console.log(data)
        cargarEvaluaciones(data, lista)
        //buildTree()
    })
    .catch(err => {
        console.error('Caught error: ', err)
        alert("Ocurrio un error en fetchSujetos! :c")
    });
}

function cargarEvaluaciones(evs, li) {

    var lista = li
    var container = document.createElement("ul");
    container.className = "nested";
    lista.appendChild(container);
    lista = container

    for (i=0; i< Object.keys(evs).length; i++){
        //console.log("crando ev " + i + " de " + Object.keys(evs).length)
        var container = document.createElement("li");
        container.id = "test_" + evs[i].evaluacionId;
        //container.className = "nested";
        //container.value = opciones[i].ocupacionId;
        container.innerHTML = "<span class='caret'>" +evs[i].evaluacionId+" - "+ evs[i].fechaInicio + "</span>"
        lista.appendChild(container);
        var aux = container
        var aplicados = evs[i].listaTestsAplicadosDTO
        cargarTests(aplicados, aux, evs[i].evaluacionId)
        //console.log("fin de " + i)
        //"http://localhost:8080/sujeto/" + dni + "/obtenerEvaluaciones"
    }
    
    buildTree()
}

function cargarTests(tests, li, id) {

    var lista = li
    var container = document.createElement("ul");
    container.className = "nested";
    lista.appendChild(container);
    lista = container

    for (j=0; j< Object.keys(tests).length; j++){
        //console.log("crando test " + j + " de " + Object.keys(tests).length)
        var container = document.createElement("li");
        container.id = tests[j].testCode + "_" + tests[j].testAplicadoId;
        //container.className = "nested";
        //container.value = opciones[i].ocupacionId;
        lista.appendChild(container);
        //container.innerHTML ="<a onclick = 'open(" + id + ")'>"+ tests[j].testCode +"</a>"
        //container.innerHTML ="<a onclick = 'showResults(" + id + ")'>"+ tests[j].testCode +"</a>"
        container.innerHTML ="<a href = 'show_test.html?id=" + id + "'>"+ tests[j].testCode +"</a>"
        
        //"http://localhost:8080/sujeto/" + dni + "/obtenerEvaluaciones"
    }
}
/*
function open(id) {
    //var url = "show_test.html?id=" + id;
    //myWindow = window.open(url, 'results', 'width=800,height=200,scrollbars=1');
    //myWindow.focus();
    window.location.href ="show_test.html?id=" + id;
}*/

function buildTree(){
    var toggler = document.getElementsByClassName("caret");
    var i;

    for (i = 0; i < toggler.length; i++) {
        toggler[i].addEventListener("click", function() {
            this.parentElement.querySelector(".nested").classList.toggle("active");
            this.classList.toggle("caret-down");
        });
    }
}


function saveResponse(name, data){
    if (typeof(Storage) !== 'undefined') {
        sessionStorage.setItem(name,data)
    } else {
        alert("No hay Local Storage! :c")
    }
}
