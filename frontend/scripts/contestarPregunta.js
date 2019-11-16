const isTrue = 1
const isFalse = 0
const noRes = -1

//obtener json
var preguntas = JSON.parse(sessionStorage.getItem("preguntas"))
/*var preguntas = [
    {
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
        }
    ];*/
    
    var respFactory = require("./crearRespuestas")
    /*function createAnswers(){
        var lista = [];
        var evId = 123 //JSON.parse(sessionStorage.getItem("evaluacion")).evaluacionId;

        if(JSON.parse(sessionStorage.getItem("respuestas")) === null){

            for (i = 0; i < preguntas.length; i++){
                var respuesta = {
                    "evaluacionId": evId,
                    "testCode": "mmpi2",
                    "pregunta": preguntas[i].id,
                    "respuesta": noRes
                };
                lista.push(respuesta);
            }
            return lista
        }else{
            return JSON.parse(sessionStorage.getItem("respuestas"))
        }
    }*/

    var actual = 0;
    
    if (sessionStorage.getItem("actual") === null){
        actual = 0;
        //console.log("CEOR")
    }else{
        actual = parseInt(sessionStorage.getItem("actual"));
        //console.log(typeof(sessionStorage.getItem("actual")))
    }
    var respuestas = respFactory.createAnswers();// JSON.parse(sessionStorage.getItem("respuestas")) //se crean en enviarSujeto

    /*saveResponse("actual", actual)
    saveResponse("respuestas", JSON.stringify(respuestas))
    saveResponse("preguntas", JSON.stringify(preguntas))*/

    function showPregunta(offset) {
        event.preventDefault()
        saveResponse("respuestas", JSON.stringify(respuestas))

        actual = actual + offset;
        if (actual < 0) actual = 0;
        if (actual >= preguntas.length) actual = preguntas.length - 1;
        
        saveResponse("actual", actual)
        
        var pregunta = preguntas[actual];
    
        document.getElementById("pregTexto").innerText = pregunta.id + " - " + pregunta.texto;
        document.getElementById("btn_true").style.backgroundColor = (respuestas[actual].respuesta === isTrue) ? "#757575" : "";
        document.getElementById("btn_false").style.backgroundColor = (respuestas[actual].respuesta === isFalse) ? "#757575" : "";
        
        document.getElementById("btn_next").innerHTML = (actual == preguntas.length - 1) ? "FINALIZAR" : "SIGUIENTE";
        
        
        //si es la ultima pregunta finalizar
    }

    function selectTrue() {
        //var pregunta = preguntas[actual];
        if (respuestas[actual].respuesta == isTrue) respuestas[actual].respuesta = noRes;
        else (respuestas[actual].respuesta = isTrue);
        //console.log(respuestas[actual])
        showPregunta(0);
    }

    function selectFalse() {
        //var pregunta = preguntas[actual];
        if (respuestas[actual].respuesta == isFalse) respuestas[actual].respuesta = noRes;
        else (respuestas[actual].respuesta = isFalse);
        //console.log(respuestas[actual])
        showPregunta(0);
    }

    function sendForm(){
        event.preventDefault()
        if(document.getElementById("btn_next").innerHTML === "FINALIZAR"){
            window.location.href = "../screens/finalizarTest.html";
        }else{
        //Enviar mini json de respuesta
        //postAnswer()

        showPregunta(+1)
        //Actualizar json en el local storage
        saveResponse("actual", actual)
        saveResponse("respuestas", JSON.stringify(respuestas))
        }
    }

    function postAnswer(){
        var url = "http://192.168.0.127:8080/evaluacion/respuestaTemporal";
        
        var respuesta = respuestas[actual]
        
        fetch(url, {
            method: 'POST',
            //mode: 'no-cors',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(respuesta) 
        })
    
        .then( res => res.json())
        .then( data => {
            console.log(data)
            //ACA GUARDAR LA RESPUESTA EN EL LOCAL STORAGE DEL BROWSER
            //JSON CON PREGUNTAS, JSON CON EVALUACION, CREAR EL INDICE PARA RECORRER LAS PREGUNTAS
            //cargar nueva pagina
            saveResponse("actual", 0)
        })
        .catch(err => {
            console.error('Caught error: ', err)
            alert("Ocurrio un error! :c")
        });
    }

    function saveResponse(name, data){
        if (typeof(Storage) !== 'undefined') {
            sessionStorage.setItem(name, data)
            /*sessionStorage.getItem("key")
            sessionStorage.removeItem("key")
            sessionStorage.clear()*/
        // Código cuando Storage es compatible
        } else {
            alert("No hay Local Storage! :c")
        // Código cuando Storage NO es compatible
        }
    }