
/*                   logica aplicada en la pantalla de LOGIN                  */

const apiUrl = 'http://localhost:8080/auth/login';

window.addEventListener('load', function(){

    console.log("Entramos en el EventListener");
    //asociamos el formulario para tener una referencia al mismo
    const formulario =  this.document.querySelector('#form');
    
    //creamos una referencia a la entrada del mail, que utilizaremos para constatar contra la base de datos
    const inputEmail = this.document.querySelector('#username');
    //creamos una referencia a la entrada del password que utilizaremos para constatar contra la base de datos
    const inputPassword =  this.document.querySelector('#password');
    const btnForm = document.getElementById("btnForm");

    btnForm.addEventListener('click', function(event){
        event.preventDefault();
        console.log(formulario,inputEmail,inputPassword);

        /* utilizamos la funcion "validacionNoVacio" para verificar que los datos del mail y password no son vacíos
        y lo guardamos en la constante "validacion". */
        const validacion = validacionNoVacio(inputEmail.value) && validacionNoVacio(inputPassword.value);
        //const validacion = true;
        // si "validacion" es igual a TRUE, osea, no está vacío
        if(validacion){
            console.log("Entramos en validación");
            const datosUsuario = normalizacionLogin(inputEmail.value, inputPassword.value);
            console.log(datosUsuario);
            //consultamos al servidor y esperamos su respuesta
            fetchApiLogin(apiUrl, datosUsuario);
        }else{
            // si "validacion" es igual a FALSE, osea, está vacío.
            console.log("algun dato no es correcto");
        }
        formulario.reset();
    });
});

/*                      seccion de funciones disponibles                      */

function validacionNoVacio(texto) {
    let resultado = true;

    if(texto === ""){
        resultado = false;
    }

    return resultado
}

function normalizacionLogin(email, password) {
    const usuario = {
        usuario: email.trim(),
        contrasena: password.trim()

    }
    localStorage.setItem("usuario",email.trim())

    return usuario;
}

function fetchApiLogin(url,payload) {

    const configuraciones = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(payload)
    }

    fetch(url, configuraciones)
    .then( respuesta => {
        console.log("las configuraciones son: ");
        console.log(configuraciones);
        console.log(respuesta);
        return respuesta.json()
    })
    .then( data => {
        console.log(data);
        console.log(data.token);
        console.log("TOKEN desde login.js: ", data.token);
        //console.log(data.jwt);
        if(data.token){
            
            localStorage.setItem('jwt', JSON.stringify(data.token));
            const payloadTraducido = obtenerPayloadJWT(data.token);
            const rol = payloadTraducido.Rol.authority;
            if(rol === "USER"){
                location.href = '/user-dashboard.html'
            }else if(rol === "ADMIN"){
                location.href = '/admin-dashboard.html'
                console.log(rol);
        }else{
            localStorage.removeItem("usuario")
        }
    }}).catch( error => console.log(error))
}

//funcion para decodificar token jwt
function obtenerPayloadJWT(token) {
    const partes = token.split('.');
    if (partes.length !== 3) {
        throw new Error('El token JWT no tiene el formato esperado');
    }

    const payloadCodificado = partes[1];
    const payloadDecodificado = atob(payloadCodificado);
    const payloadObjeto = JSON.parse(payloadDecodificado);

    return payloadObjeto;
}
