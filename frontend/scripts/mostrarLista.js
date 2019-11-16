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
        for (i = 0; i < preguntas.length; i++) {
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
            container.innerHTML = "<td><a href='' onclick='volverA(" + i + ")' id='pregId" + i + "'>" + preguntas[i].id + "</a></td>" + 
                                    "<td><a class='tab' id='pregText" + i + "'> - " + preguntas[i].texto + " - </a></td>" +
                                    "<td><a class='tab' id='pregText" + i + "'>" + textoResp + "</a></td>";
        }
    }

    function volverA(index){
        sessionStorage.setItem("actual", index)
        window.location.href = "pregunta.html";
    }
    
    function startTest(){
        var pregs = JSON.parse(sessionStorage.getItem("respuestas"))
        document.getElementById("ela").innerHTML = sessionStorage.getItem("respuestas")

    }

    function sendResults(){
        event.preventDefault()
        window.location.href = "../screens/listar_preguntas.html";
    }

    