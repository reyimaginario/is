//sqlite integrado a chrome - 
//carlos.ruiz@ort.edu.ar

    var preguntas = JSON.parse(sessionStorage.getItem("preguntas"))
    var respuestas = JSON.parse(sessionStorage.getItem("respuestas"))
    //var actual = 0;

    //sqlite integrado a chrome - 
    //carlos.ruiz@ort.edu.ar

    function crearLista() {
        //console.log(preguntas)
        var lista = document.getElementById("lista_preguntas");
        var textoResp = "";
        for (i = 1; i < 6/*Object.keys(preguntas).length*/; i++) {
            if(respuestas[i-1].respuesta === 1){
                textoResp = "True"
            }else if(respuestas[i-1].respuesta === 0){
                textoResp = "False"
            }else{
                textoResp = "Null"
            }
            var container = document.createElement("tr");
            container.id = "pregunta" + i;
            container.className = "form-group";
            lista.appendChild(container);
            container.innerHTML = "<td><a href='' onclick='volverA(" + i + ")' id='pregId" + i + "'>" + respuestas[i-1].pregunta + "</a></td>" + 
                                    "<td><a class='tab' id='pregText" + i + "'> - " + preguntas[i] + " - </a></td>" +
                                    "<td><a class='tab' id='pregText" + i + "'>" + textoResp + "</a></td>";
        }
    }

    function volverA(index){
        sessionStorage.setItem("actual", index-1)
        window.location.href = "pregunta.html";
    }
    
    function startTest(){
        document.getElementById("btn_show").hidden = true
        var pregs = JSON.parse(sessionStorage.getItem("respuestas"))
        //document.getElementById("ela").innerHTML = sessionStorage.getItem("respuestas")

    }
    
    function finTest(){
        event.preventDefault()
        window.location.href = "../screens/finalizarTest.html";
    }

    function sendResults(){
        event.preventDefault()
        var evId = sessionStorage.getItem("evaluacion_id")
        //var end_url= "http://localhost:8080/evaluacion/" + sessionStorage.getItem("evaluacion_id") + "/finalizar"
        var end_url= "http://192.168.0.127:8080/evaluacion/" + String(evId) + "/finalizar"
        
        console.log(end_url)

        fetch(end_url, {
            method: 'GET',
            headers: {'Content-Type': 'application/json'},
         })
        .then( res => res.json())
        .then( data => {
            console.log("Whatisdis")
            console.log(data)
            saveResponse("evaluacion_finalizada", JSON.stringify(data))
            document.getElementById("btn_send").hidden = true
            document.getElementById("btn_show").hidden = false
        })
        .catch(err => {
            console.error('Caught error: ', err)
            alert("Ocurrio un error en GET! :c")
        });

        /*testFetch(end_url, {
            method: 'GET',
            headers: {'Content-Type': 'application/json'},
         }, 5000) // throw after max 5 seconds timeout error
        .then((result) => {
            console.log(result.json())
        })
        .catch((e) => {
            // handle errors and timeout error
            console.log(e)
        })*/
        
        //
    }

    function showResults(){
        event.preventDefault()
        window.location.href = "../screens/show_results.html";
    }

    function testFetch (url, options, timeout = 7000) {
        return Promise.race([
            fetch(url, options),
            new Promise((_, reject) =>
                setTimeout(() => reject(new Error('timeout')), timeout)
            )
        ]);
    }

    function saveResponse(name, data){
        if (typeof(Storage) !== 'undefined') {
            sessionStorage.setItem(name,data)
        } else {
            alert("No hay Local Storage! :c")
        }
    }
