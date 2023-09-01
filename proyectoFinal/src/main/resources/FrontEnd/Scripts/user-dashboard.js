window.addEventListener("load", function(){

    const btnNuevoTurno = document.querySelector('#nuevo-turno');
    const formNuevoTurno = document.querySelector("#form-nuevo-turno");
    const divNuevoTurno = document.querySelector("#cont-nuevo-turno");
    const btnEnviarForm = document.querySelector("#enviar-form");


    btnNuevoTurno.addEventListener("click",()=>{

        console.log("Crear un nuevo turno");
        formNuevoTurno.classList.toggle('hidden')
        
    })

    btnEnviarForm.addEventListener("click",(e)=>{
        e.preventDefault();
    })



})