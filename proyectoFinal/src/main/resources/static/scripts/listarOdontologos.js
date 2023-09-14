window.addEventListener('load',()=>{
    
    const ul = document.querySelector('render');
    const urlOdontologos = "http://localhost:8080/odontologos"
    const token = JSON.stringify(this.localStorage.getItem("jwt"))



    function consultarOdontologos(){
        const url = urlOdontologos + "/listar";
        const settings ={
            method: "GET",
            headers:{
                authorization: token
            }
        }

        fetch(url, settings)
        .then(res => res.json)
        .then(odontologos =>{
            renderizarOdontologos(odontologos)
        })
        

    }
    function renderizarOdontologos(odontologos){
        ul.innerHTML = "";
        pacientes.forEach(odontologo =>{
            ul.innerHTML += `
            <li class="card-paciente">
                <div><strong>Nombre: </strong>${odontologo.nombre}</div>
                <div><strong>Apellido: </strong>${odontologo.apellido}</div> 
                <div><strong>Matricula:</strong>${odontologo.dni}</div> 
            </li>
            `
        });
    }

consultarOdontologos()

})