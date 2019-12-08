const isTrue = 1
const isFalse = 0
const noRes = -1

//obtener json
var preguntas = JSON.parse(sessionStorage.getItem("preguntas"))

    
    function createAnswers(){
        return JSON.parse(sessionStorage.getItem("respuestas"))
    }

    var actual = 0;
    
    if (sessionStorage.getItem("actual") === null){
        actual = 0;
    }else{
        actual = parseInt(sessionStorage.getItem("actual"));
    }
    var respuestas = createAnswers();

    function showPregunta(offset) {
        event.preventDefault()
        saveResponse("respuestas", JSON.stringify(respuestas))

        actual = actual + offset;
        if (actual < 0) actual = 0;
        if (actual > preguntas.length) actual = preguntas.length - 1;
        
        saveResponse("actual", actual)
        
        var index = respuestas[actual].pregunta
        document.getElementById("pregTexto").innerText = index + " - " + preguntas[index];
        document.getElementById("btn_true").style.backgroundColor = (respuestas[actual].respuesta === isTrue) ? "#757575" : "";
        document.getElementById("btn_false").style.backgroundColor = (respuestas[actual].respuesta === isFalse) ? "#757575" : "";
        
        document.getElementById("btn_next").innerHTML = (actual == Object.keys(preguntas).length - 1) ? "FINALIZAR" : "SIGUIENTE";
        
    }

    function selectTrue() {
        if (respuestas[actual].respuesta == isTrue) respuestas[actual].respuesta = noRes;
        else (respuestas[actual].respuesta = isTrue);
        
        showPregunta(0);
    }

    function selectFalse() {
        if (respuestas[actual].respuesta == isFalse) respuestas[actual].respuesta = noRes;
        else (respuestas[actual].respuesta = isFalse);
        
        showPregunta(0);
    }

    function mostrarPreguntas() {
        sendForm()
        window.location.href="../screens/listar_preguntas.html"
    }

    function sendForm(){
        event.preventDefault()
        
        //Enviar mini json de respuesta
        postAnswer()

        //Actualizar json en el local storage
        saveResponse("actual", actual)
        saveResponse("respuestas", JSON.stringify(respuestas))
        if(document.getElementById("btn_next").innerHTML === "FINALIZAR"){
            window.location.href = "../screens/gracias.html";

            //aca send results
        }else{
            showPregunta(+1)
        }
    }


    function postAnswer(){
        //var url = "http://localhost:8080/evaluacion/respuestaTemporal";
        var url = "http://localhost:8080/evaluacion/respuestaTemporal";
        var respuesta = respuestas[actual]
        console.log(respuesta)
        fetch(url, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(respuesta) 
        })
    
        .then( res => res.json())
        .then( data => {
            console.log(data)//true
            respuesta.respuestaTemporalId = data.respuestaTemporalId
        })
        .catch(err => {
            console.error('Caught error: ', err)
        });
    }

    function saveResponse(name, data){
        if (typeof(Storage) !== 'undefined') {
            sessionStorage.setItem(name, data)
        } else {
            alert("No hay Local Storage! :c")
        }
    }

    