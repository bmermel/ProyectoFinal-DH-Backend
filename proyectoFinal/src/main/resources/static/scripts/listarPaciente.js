window.addEventListener('load',()=>{
    
    const ul = document.querySelector('render');
    const urlPacientes = "http://localhost:8080/pacientes"
    const token = JSON.stringify(this.localStorage.getItem("jwt"))



    function consultarPacientes(){
        const url = urlPacientes + "/listar";
        const settings ={
            method: "GET",
            headers:{
                authorization:token
            }
        }

        fetch(url, settings)
        .then(res => res.json)
        .then(pacientes =>{
            renderizarPacientes(pacientes)
        })
        

    }
    function renderizarPacientes(pacientes){
        ul.innerHTML = ""
        pacientes.forEach(paciente =>{
            ul.innerHTML += `
            <li class="card-paciente">
                <div><strong>Nombre: </strong>${paciente.nombre}</div>
                <div><strong>Apellido: </strong>${paciente.apellido}</div> 
                <div><strong>Dni:</strong>${paciente.dni}</div> 
                <div><strong>Direccion:</strong>${paciente.domicilio.calle +" " + paciente.domicilio.numero + ", " + paciente.domicilio.localidad + " ("+paciente.domicilio.provincia+ ")"}</div> 
            </li>
            `
            
        });
    }

consultarPacientes()






})