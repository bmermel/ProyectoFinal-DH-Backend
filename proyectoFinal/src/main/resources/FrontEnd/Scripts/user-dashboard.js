window.addEventListener("load", function(){

    const btnNuevoTurno = document.querySelector('#nuevo-turno');
    const btnCancelar = document.querySelector('#cancelar-turno');
    const btnVerTurnos = document.querySelector('#ver-todos')

    btnNuevoTurno.addEventListener("click",()=>{
        console.log("Crear un nuevo turno");
    })
    btnCancelar.addEventListener("click",()=>{
        console.log("Cancelar un turno");
    })
    btnVerTurnos.addEventListener("click",()=>{
        console.log("Listar todos los turnos");
    })



})