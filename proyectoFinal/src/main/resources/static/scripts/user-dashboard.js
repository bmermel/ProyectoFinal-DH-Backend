window.addEventListener("load", function (){

  const urlPacientes = "http://localhost:8080/pacientes";
  const urlOdontologos = "http://localhost:8080/odontologos";
  const urlTurnos = "http://localhost:8080/turnos";
  const btnNuevoTurno = document.querySelector("#nuevo-turno");
  const formNuevoTurno = document.querySelector("#form-nuevo-turno");
  const btnEnviarForm = document.querySelector("#enviar-form");
  

  btnNuevoTurno.addEventListener("click", () => {
    console.log("Crear un nuevo turno");
    if (formNuevoTurno.classList.contains("flex")) {
      formNuevoTurno.classList.remove("flex");
      formNuevoTurno.classList.add("hidden");
    } else {
      formNuevoTurno.classList.remove("hidden");
      formNuevoTurno.classList.add("flex");
    }
  });

  // FUNCION PARA CONSULTAR TURNOS AL SERVIDOR
  function consultarTurnos(){
    const url = urlTurnos + "/listar";

    fetch(url)
      .then((res) => res.json())
      .then(turnos =>{
        console.table(turnos);
        renderizarTurnos(turnos)
        botonesEliminarTurno();
      })
  }
  //FUNCION PARA RENDERIZAR LOS TURNOS
  function renderizarTurnos(array){
    const ulTurnos = document.getElementById("turnos")
    
    array.forEach(turno =>{
      urlTurnos.innerHTML = "";
      ulTurnos.innerHTML += `
        <li class="turno" id="${turno.id}">
          <div><strong>Nombre Paciente:</strong>${turno.paciente.apellido + ", " + turno.paciente.nombre + " (DNI:" + turno.paciente.dni +")"}</div>
          <div><strong>Odontólogo:</strong> ${turno.odontologo.apellido + ", " + turno.odontologo.nombre + " (MT:" + turno.odontologo.matricula +")"} </div>
          <div><strong>Fecha:</strong> ${turno.fecha} </div>
          <div><strong>Hora:</strong> ${turno.hora}</div>
          <button class="eliminarTurno" id="${turno.id}">ELIMINAR</button>
        </li>`

    })
  }

  //FUNCION PARA BOTONES QUE SE RENDERIZAN AL CONSULTAR TURNOS
  function botonesEliminarTurno(){
    const btnEliminar = document.querySelectorAll(".eliminarTurno");
    const url = urlTurnos + "/borrar"
    btnEliminar.forEach(boton => {
      boton.addEventListener("click", ()=>{
        const id = boton.getAttribute("id")
        console.log("hiciste clic en el boton " + id)

      })

    })
  }  


  //FUNCION PARA MOSTRAR LISTA DE PACIENTES EN EL FORMULARIO DE NUEVO TURNO
  function renderizarPacientes() {
    const selectPacientes = document.getElementById("select-paciente");
    const url = urlPacientes + "/listar";
    console.log(url);
    fetch(url)
      .then((res) => res.json())
      .then((pacientes) => {
        pacientes.sort((a, b) => (a.apellido > b.apellido) ? 1 : -1);
        pacientes.forEach((paciente) => {
          selectPacientes.innerHTML += `<option value="${paciente.id}"> ${paciente.apellido + ", " + paciente.nombre + " (DNI:" + paciente.dni +")"}</option>"`;
        });
      });
  }

//FUNCION PARA MOSTRAR LISTA DE ODONTOLOGOS EN EL FORMULARIO DE NUEVO TURNO
  function renderizarOdontologos() {
    const selectOdontologos = document.getElementById("select-odontologo");
    const url = urlOdontologos + "/listar";
    console.log(url);
    fetch(url)
      .then((res) => res.json())
      .then((odontologos) => {
        odontologos.sort((a,b) =>(a.apellido > b.apellido) ? 1 : -1)   
        odontologos.forEach((odontologo) => {
          selectOdontologos.innerHTML += `<option value="${odontologo.id}"> ${odontologo.apellido + ", " + odontologo.nombre + " (MT:" + odontologo.matricula + ")"}</option>"`;
        });
      });
  }

//FUNCION PARA CREAR UN NUEVO TURNO

  btnEnviarForm.addEventListener("click", (e) => {
    e.preventDefault();
    const url = urlTurnos + "/crear"
    const paciente = document.getElementById('select-paciente').value;
    const odontologo = document.getElementById('select-odontologo').value;
    const fechaTurno = document.getElementById("fecha").value;
    const horaTurno = document.getElementById("select-hora").value;
  
    console.log("Paciente ID:"+ paciente);
    console.log("Odontologo ID:"+ odontologo);
    console.log("Fecha: " + fechaTurno);
    console.log("Hora: "+ horaTurno);

    if(odontologo == "none" || paciente == "none"){
      alert("Debe seleccionar un odontologo y un paciente para crear un turno")
    }else{
      let payload = {
        fecha: fechaTurno,
        hora: horaTurno,
        idOdontologo: odontologo,
        idPaciente: paciente,
      }
  
      console.log("El JSON que se enviara es:")
      console.log(JSON.stringify(payload));
  
      const settings = {
          method: "POST",
          body:JSON.stringify(payload),
          headers:{
            "Content-Type": "application/json"
          }
      }
      
      console.log("Preparando datos");
      fetch(url,settings)
      .then(res => console.log(res))
      .then(data=>{
        console.log(data)
        consultarTurnos();
        
      })   
      console.log("Datos enviados");
    }
    
    

    
  });




  renderizarPacientes();
  renderizarOdontologos();
  consultarTurnos();




});
