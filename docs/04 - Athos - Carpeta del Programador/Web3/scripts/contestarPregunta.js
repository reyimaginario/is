const isTrue = 1
const isFalse = 0
const noRes = -1

//obtener json
var preguntas = [
    {
            "id": "001",
            "texto": "Me gustan las revistas de mecanica.",
            "respuesta": noRes
        },
        {
            "id": "002",
            "texto": "Tengo buen apetito.",
            "respuesta": noRes
        },
        {
            "id": "022",
            "texto": "Nadie parece comprenderme.",
            "respuesta": noRes
        },
        {
            "id": "049",
            "texto": "Soy una persona sociable.",
            "respuesta": noRes
        }
    ];
    var actual = 0;


    function showPregunta(offset) {
        event.preventDefault()
        actual = actual + offset;
    
        if (actual < 0) actual = 0;
        if (actual >= preguntas.length) actual = preguntas.length - 1;
    
        var pregunta = preguntas[actual];
    
        document.getElementById("pregTexto").innerText = pregunta.id + " - " + pregunta.texto;
        document.getElementById("btn_true").style.backgroundColor = (pregunta.respuesta === isTrue) ? "#757575" : "";
        document.getElementById("btn_false").style.backgroundColor = (pregunta.respuesta === isFalse) ? "#757575" : "";
        
        document.getElementById("btn_next").innerHTML = (actual == preguntas.length - 1) ? "FINALIZAR" : "SIGUIENTE";
        //si es la ultima pregunta finalizar
    }

    function selectTrue() {
        var pregunta = preguntas[actual];
        if (pregunta.respuesta == isTrue) pregunta.respuesta = noRes;
        else (pregunta.respuesta = isTrue);
        showPregunta(0);
    }

    function selectFalse() {
        var pregunta = preguntas[actual];
        if (pregunta.respuesta == isFalse) pregunta.respuesta = noRes;
        else (pregunta.respuesta = isFalse);
        showPregunta(0);
    }

    function sendForm(){
        event.preventDefault()
        //Actualizar json en el local storage
        //Enviar mini json de respuesta
        
        showPregunta(+1)
    }

    function postAnswer(){
        var url = "http://192.168.0.127:8080/evaluacion/respuestaTemporal";
        
        var pregunta = preguntas[actual];

        var respuesta = {
            evaluacionId: 4, //sale de la evaluacion que recibi despues de post sujeto
            testCode: "mmpi2",
            pregunta: pregunta.id, //empieza en 0?
            respuesta: pregunta.respuesta
        }

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
        })
        .catch(err => {
            console.error('Caught error: ', err)
            alert("Ocurrio un error! :c")
        });
    }

    function saveResponse(){
        if (typeof(Storage) !== 'undefined') {
            sessionStorage.setItem("key","value")
            sessionStorage.getItem("key")
            sessionStorage.removeItem("key")
            sessionStorage.clear()
        // Código cuando Storage es compatible
        } else {
        // Código cuando Storage NO es compatible
        }
    }