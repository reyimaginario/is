//console.log("funcionando")

var formulario = document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault()

    var datos = new FormData(formulario);
    /*console.log(datos)
    console.log(datos.get("username"))
    console.log(datos.get("password"))*/
    var booty = { "username" : datos.get("username"),  "password" : datos.get("password")};
    
    fetch("http://localhost:3000/chat/user/login/", {
        method: 'POST',
        credentials: 'include',
        mode: 'no-cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(booty) //{"username": "mediavla", "password": "123"}//datos
    })

    .then( res => res.json())
    .then( data => {
        console.log(data)
    })
    .catch(err => console.error('Caught error: ', err))
    /*
    fetch(...).then(function(response) {
    if (response.ok) {
        return response
    } else {
        var error = new Error(response.statusText)
        error.response = response
        throw error
    }
    })


    .then(res => {
        if(res.ok) {
            console.log( res)
        } else {
          throw Error(`Request rejected with status ${res.status}`);
        }
      })
      .catch(console.error)*/
});