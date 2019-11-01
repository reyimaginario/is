// A $( document ).ready() block.
$( document ).ready(function(){
    
});

//var declarations 

function clickFunc() {
    //onclick stuff
    event.preventDefault();
    console.log('clicked');
}

function main() {
    console.log('mian');
    var send = $('.ui-button');

    $("form[name='login']").submit(function() {
    var formInputs = $('.login-form').find('input');
    var inputItem;
    var inputVals;
    var dni = $('input[name$="dni"]').val();
    var pass = $('input[name$="txtPassword"]').val();
        
    if (dni === "") {
        $('.dni-error').text('ingresa tu DNI');
    } 
    if (pass === "") {
        $('.pwd-error').text('ingresa tu contraseña');
    }
   

        
       
    });
}

//functions



/* for(var i = 0; i < formInputs.length; i++) {
    inputItem = formInputs[i];

    inputVals = inputItem.val();

} */







