window.addEventListener("load", function () {
  const urlPacientes = "http://localhost:8080/pacientes";
  const urlOdontologos = "http://localhost:8080/odontologos";
  const urlTurnos = "http://localhost:8080/turnos"
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

  btnEnviarForm.addEventListener("click", (e) => {
    e.preventDefault();
    const url = urlTurnos + "/crear"
    const paciente = document.getElementById('select-paciente').value;
    const odontologo = document.getElementById('select-odontologo').value;
    const fecha = document.getElementById("fecha").value;
    const hora = document.getElementById("select-hora").value;

    console.log("Paciente ID:"+ paciente);
    console.log("Odontologo ID:"+ odontologo);
    console.log("Fecha: " + fecha);
    console.log(hora);

    if(odontologo == "none"){alert("Debe seleccionar un odontologo")}
    if(paciente == "none"){this.alert("Debe seleccion un paciente")}

    const settings = {
        method: "POST",
        body:{
            fecha: "10-09-2023",
            hora: "10:30",
            idOdontologo: odontologo,
            idPaciente: paciente
        }
    }
    
    console.log("Preparando datos");
    fetch(url,settings)
    .then(res => console.log(res))
    .then(data=>console.log(data))
    console.log("Datos enviados");

  });

  function renderizarPacientes() {
    const selectPacientes = document.getElementById("select-paciente");
    const url = urlPacientes + "/listar";
    console.log(url);
    fetch(url)
      .then((res) => res.json())
      .then((pacientes) => {
        pacientes.sort((a, b) => (a.apellido > b.apellido) ? 1 : -1);
        pacientes.forEach((paciente) => {
          selectPacientes.innerHTML += `<option value="${paciente.id}"> ${paciente.apellido + ", " + paciente.nombre}</option>"`;
        });
      });
  }

  function renderizarOdontologos() {
    const selectOdontologos = document.getElementById("select-odontologo");
    const url = urlOdontologos + "/listar";
    console.log(url);
    fetch(url)
      .then((res) => res.json())
      .then((odontologos) => {
        odontologos.sort((a,b) =>(a.apellido > b.apellido) ? 1 : -1)   
        odontologos.forEach((odontologo) => {
          selectOdontologos.innerHTML += `<option value="${odontologo.id}"> ${odontologo.apellido + ", " + odontologo.nombre}</option>"`;
        });
      });
  }

  renderizarPacientes();
  renderizarOdontologos();
});
