/*const sendForm = function sendForm(){
    event.preventDefault()
    console.log("funcionando")
    //var data = {'nombre': document.getElementById("username").value}
    var contenido = document.querySelector("#contenido")
    fetch("https://randomuser.me/api/"), {
        method: "GET", 
        mode: "no-cors",
        //body: JSON.stringify(data),
        headers:{'Content-Type':'application/json'}
        })
        .catch(err => console.error('Caught error: ', err))
    .then(res => res.json())
    .then(data => {
        console.log(data.results[0])
        contenido.innerHTML = `
        <p>Email: ${data.results[0].email} </p>
        `
    })

}*/

var formulario = document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault()

    var datos = new FormData(formulario);
    /*console.log(datos)
    console.log(datos.get("username"))
    console.log(datos.get("password"))*/
    //var booty = { "username" : datos.get("username"),  "password" : datos.get("password")};
    
    fetch('http://localhost:3000/chat/user/', {
        method: 'GET',
        //credentials: 'include',
        mode: 'no-cors',
        //headers: {'Content-Type': 'application/json'},
        //body: JSON.stringify(booty) //{"username": "mediavla", "password": "123"}//datos
    })
    .then(function(response) {
        if (response.ok) {
            console.log(response)
        } else {
            console.log(response.statusText)
        }
    })
});


