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


function redireccionar(){
    const token = obtenerPayloadJWT(localStorage.getItem('jwt'));
    const rol = token.Rol.authority;
    const url = window.location.pathname
    switch (rol){
        case "USER":
            if(url != "/user-dashboard.html"){
                location.href = "/user-dashboard.html";
            }
        case "ADMIN":
            if(url != "/admin-dashboard.html"){
                location.href = "/admin-dashboard.html";    
            }
    }   
}