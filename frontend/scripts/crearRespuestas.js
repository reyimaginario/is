export function createAnswers(){
    var lista = [];
    var evId = parseInt(sessionStorage.getItem("evaluacion_id"));
    var preguntas = JSON.parse(sessionStorage.getItem("preguntas"));

    if(JSON.parse(sessionStorage.getItem("respuestas")) === null){

        for (i = 0; i < preguntas.length; i++){
            var respuesta = {
                "evaluacionId": evId,
                "testCode": "mmpi2",
                "pregunta": preguntas[i].id,
                "respuesta": noRes,
                "respuestaTemporalId": null
            };
            lista.push(respuesta);
        }
        return lista
    }else{
        return JSON.parse(sessionStorage.getItem("respuestas"))
    }
}