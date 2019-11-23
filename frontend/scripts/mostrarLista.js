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
            if(respuestas[i].respuesta === 1){
                textoResp = "True"
            }else if(respuestas[i].respuesta === 0){
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
        var pregs = JSON.parse(sessionStorage.getItem("respuestas"))
        //document.getElementById("ela").innerHTML = sessionStorage.getItem("respuestas")

    }
    
    function finTest(){
        event.preventDefault()
        window.location.href = "../screens/finalizarTest.html";
    }

    function sendResults(){
        event.preventDefault()

        var end_url= "http://localhost:8080/" + sessionStorage.getItem("evaluacion_id") + "/finalizar"
        
        fetch(end_url, {
            method: 'GET',
            headers: {'Content-Type': 'application/json'},
         })
        .then( res => res.json())
        .then( data => {
            console.log(data)
        })
        .catch(err => {
            console.error('Caught error: ', err)
            alert("Ocurrio un error en GET! :c")
        });

        //window.location.href = "../screens/listar_preguntas.html";
    }

    