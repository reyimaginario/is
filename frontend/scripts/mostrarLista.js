var preguntas = [
    {
            "id": "001",
            "texto": "mayor a 18?",
            "respuesta": null
        },
        {
            "id": "002",
            "texto": "mayor a 21?",
            "respuesta": null
        },
        {
            "id": "003",
            "texto": "mayor a 40?",
            "respuesta": null
        },
        {
            "id": "004",
            "texto": "mayor a 70?",
            "respuesta": null
        }
    ];
    
//sqlite integrado a chrome - 
//carlos.ruiz@ort.edu.ar

    function crearLista() {
        var lista = document.getElementById("lista");
        for (i = 0; i < preguntas.length; i++) {
            var container = document.createElement("div");
            container.id = "pregunta" + i;
            container.style.border = "1px solid #808080";
            lista.appendChild(container);
            container.innerHTML = "<b>Id:<b><span id='pregId" + i + "'>" + preguntas[i].id + "</span>";
        }
    }