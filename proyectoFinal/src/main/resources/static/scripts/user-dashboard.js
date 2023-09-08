window.addEventListener("load", function(){
    const urlPacientes = "http://localhost:8080/pacientes"
    const urlOdontologos = "http://localhost:8080/odontologos"
    const btnNuevoTurno = document.querySelector('#nuevo-turno');
    const formNuevoTurno = document.querySelector("#form-nuevo-turno");
    const btnEnviarForm = document.querySelector("#enviar-form");

    btnNuevoTurno.addEventListener("click",()=>{

        console.log("Crear un nuevo turno");
        if(formNuevoTurno.classList.contains("flex")){
            formNuevoTurno.classList.remove("flex");
            formNuevoTurno.classList.add("hidden");
        }else{
            formNuevoTurno.classList.remove("hidden");
            formNuevoTurno.classList.add("flex");
        }
        
    })

    btnEnviarForm.addEventListener("click",(e)=>{
        e.preventDefault();
    })

function renderizarPacientes(){
    const selectPacientes = document.getElementById("select-paciente")
    const url = urlPacientes + "/listar"
    console.log(url);
    fetch(url)
    .then(res =>res.json())
    .then(pacientes =>{
        pacientes.forEach(paciente =>{
            selectPacientes.innerHTML += `<option value="${paciente.id}"> ${paciente.nombre + " " + paciente.apellido}</option>"`
            
        })
    })
}

function renderizarOdontologos(){
    const selectOdontologos = document.getElementById("select-odontologo")
    const url = urlOdontologos + "/listar"
    console.log(url);
    fetch(url)
    .then(res =>res.json())
    .then(odontologos =>{
        odontologos.forEach(odontologo =>{
            selectOdontologos.innerHTML += `<option value="${odontologo.id}"> ${odontologo.nombre + " " + odontologo.apellido}</option>"`
            
        })
    })
}

renderizarPacientes();
renderizarOdontologos();









});