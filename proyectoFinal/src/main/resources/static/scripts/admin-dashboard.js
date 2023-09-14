window.addEventListener('load',()=>{

//BOTONES Y FORMULARIO
    const btnPaciente = document.querySelector("#nuevo-paciente")
    const btnNuevoOdontologo = document.querySelector("#nuevo-odontologo") 
    const formPaciente = document.querySelector("#form-nuevo-paciente");
    const formOdontologo = document.querySelector("#form-nuevo-odontologo");

    const btnCrearPaciente =  document.querySelector("#enviar-form-paciente");
    const btnCrearOdontologo =  document.querySelector("#enviar-form-odontologo");

    const urlPacientes = "http://localhost:8080/pacientes";
    const urlOdontologos = "http://localhost:8080/odontologos";

    const btnListaPaciente = document.querySelector("#btn-pa-list")
    const btnListaOdontologos = document.querySelector("#btn-odo-list")

    btnListaPaciente.addEventListener("click",()=>{
      let win = window.open("http://localhost:8080/listaPacientes", '_blank');
        win.focus();
    })

    btnListaOdontologos.addEventListener("click", ()=>{
      let win = window.open("http://localhost:8080/listaOdontologos", '_blank');
        win.focus();
    })
//=========================================================================================================
//MOSTRAR O ESCONDER FORMULARIOS


    btnPaciente.addEventListener('click',()=>{
        console.log('click paciente')
        if (formPaciente.classList.contains("flex")) {
            formPaciente.classList.remove("flex");
            formPaciente.classList.add("hidden");
          } else {
            formPaciente.classList.remove("hidden");
            formPaciente.classList.add("flex");
          }
    })

    btnNuevoOdontologo.addEventListener('click', ()=>{
        console.log('click odontologo')
        if (formOdontologo.classList.contains("flex")) {
            formOdontologo.classList.remove("flex");
            formOdontologo.classList.add("hidden");
          } else {
            formOdontologo.classList.remove("hidden");
            formOdontologo.classList.add("flex");
          }

    })


//=========================================================================================================
//CREACION DE UN NUEVO PACIENTE
btnCrearPaciente.addEventListener("click", (e) => {
    e.preventDefault();
    const url = urlPacientes + "/crear"
    const nombrePac = document.getElementById('inputnombre').value;
    const apellidoPac = document.getElementById('apellido').value;
    const dniPac = document.getElementById("dni").value;
    const callePac = document.getElementById("calle").value;
    const numeroPac = document.getElementById("numero").value;
    const localidadPac = document.getElementById("localidad").value;
    const provinciaPac = document.getElementById("provincia").value;

    if((nombrePac == "" || nombrePac == null) || (apellidoPac == "" || apellidoPac == null) || (dniPac == "" || dniPac == null) ){
      alert("Los campos Nombre, Apellido y Dni no pueden estar vacíos")
    }else{

        let payload = {
            nombre: nombrePac,
            apellido: apellidoPac,
            dni: dniPac,
            domicilio: {
                calle: callePac,
                numero: numeroPac,
                localidad:localidadPac,
                provincia: provinciaPac
            }
        }
  
      console.log("El JSON que se enviara es:")
      console.log(JSON.stringify(payload));
  
      const settings = {
          method: "POST",
          body:JSON.stringify(payload),
          headers:{
            authorization:token,
            "Content-Type": "application/json"
          }
      }
      
      console.log("Preparando datos");
      fetch(url,settings)
      .then(res => console.log(res))
      .then(data=>{
        console.log(data) 
      })   
      console.log("Datos enviados");
    }
    
    

    
  });




//=========================================================================================================
//CREACION DE UN NUEVO ODONTOLOGO
btnCrearOdontologo.addEventListener("click", (e)=>{
    e.preventDefault();
    const url = urlOdontologos + "/crear"
    const nombreOdo = document.getElementById('nombreOdo').value;
    const apellidoOdo = document.getElementById('apellidoOdo').value;
    const matriculaOdo = document.getElementById("matricula").value;
  

    if((nombreOdo == "" || nombreOdo == null)|| (apellidoOdo == "" || apellidoOdo == null)|| (matriculaOdo  == "" || matriculaOdo  == null)){
      alert("Debe seleccionar un odontologo y un paciente para crear un turno")
    }else{
      let payload = {
        matricula:matriculaOdo,
        nombre:nombreOdo,
        apellido:apellidoOdo
    }

      console.log("El JSON que se enviara es:")
      console.log(JSON.stringify(payload));
  
      const settings = {
          method: "POST",
          body:JSON.stringify(payload),
          headers:{
            authorization:token,
            "Content-Type": "application/json"
          }
      }
      
      console.log("Preparando datos");
      fetch(url,settings)
      .then(res => console.log(res))
      .then(data=>{
        console.log(data)
      })   
      console.log("Datos enviados");
    }
    
    

    
  });





})


