package com.digitalhouse.proyectoFinal;

import com.digitalhouse.proyectoFinal.Entity.Domicilio;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import com.digitalhouse.proyectoFinal.Repository.OdontologoRepository;
import com.digitalhouse.proyectoFinal.Repository.PacienteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFinalApplication {
	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private OdontologoRepository odontologoRepository;
	@PostConstruct
	public void cargarDatos() {
		/*Domicilio domicilio1 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio2 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio3 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio4 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio5 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio6 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio7 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio8 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio9 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio10 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio11 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio12 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio13 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio14 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio15 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio16 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio17 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio18 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio19 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio20 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio21 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio22 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio23 = Domicilio.generarDomicilioAleatorio();
		Domicilio domicilio24 = Domicilio.generarDomicilioAleatorio();*/

		Paciente paciente1 = Paciente.generarPacienteAleatorio();
		//paciente1.setDomicilio(domicilio1);
		Paciente paciente2 = Paciente.generarPacienteAleatorio();
		//paciente2.setDomicilio(domicilio2);
		Paciente paciente3 = Paciente.generarPacienteAleatorio();
		Paciente paciente4 = Paciente.generarPacienteAleatorio();
		Paciente paciente5 = Paciente.generarPacienteAleatorio();
		Paciente paciente6 = Paciente.generarPacienteAleatorio();
		Paciente paciente7 = Paciente.generarPacienteAleatorio();
		Paciente paciente8 = Paciente.generarPacienteAleatorio();
		Paciente paciente9 = Paciente.generarPacienteAleatorio();
		Paciente paciente10 = Paciente.generarPacienteAleatorio();
		Paciente paciente11 = Paciente.generarPacienteAleatorio();
		Paciente paciente12 = Paciente.generarPacienteAleatorio();
		Paciente paciente13 = Paciente.generarPacienteAleatorio();
		Paciente paciente14 = Paciente.generarPacienteAleatorio();
		Paciente paciente15 = Paciente.generarPacienteAleatorio();
		Paciente paciente16 = Paciente.generarPacienteAleatorio();
		Paciente paciente17 = Paciente.generarPacienteAleatorio();
		Paciente paciente18 = Paciente.generarPacienteAleatorio();
		Paciente paciente19 = Paciente.generarPacienteAleatorio();
		Paciente paciente20 = Paciente.generarPacienteAleatorio();
		Paciente paciente21 = Paciente.generarPacienteAleatorio();
		Paciente paciente22 = Paciente.generarPacienteAleatorio();
		Paciente paciente23 = Paciente.generarPacienteAleatorio();
		Paciente paciente24 = Paciente.generarPacienteAleatorio();
		//paciente1.setFechaAlta();
		pacienteRepository.save(paciente1);
		pacienteRepository.save(paciente2);
		pacienteRepository.save(paciente3);
		pacienteRepository.save(paciente4);
		pacienteRepository.save(paciente5);
		pacienteRepository.save(paciente6);
		pacienteRepository.save(paciente7);
		pacienteRepository.save(paciente8);
		pacienteRepository.save(paciente9);
		pacienteRepository.save(paciente10);
		pacienteRepository.save(paciente11);
		pacienteRepository.save(paciente12);
		pacienteRepository.save(paciente13);
		pacienteRepository.save(paciente14);
		pacienteRepository.save(paciente15);
		pacienteRepository.save(paciente16);
		pacienteRepository.save(paciente17);
		pacienteRepository.save(paciente18);
		pacienteRepository.save(paciente19);
		pacienteRepository.save(paciente20);
		pacienteRepository.save(paciente21);
		pacienteRepository.save(paciente22);
		pacienteRepository.save(paciente23);
		pacienteRepository.save(paciente24);

		Odontologo odontologo1 = Odontologo.generarOdontologoAleatorio();
		Odontologo odontologo2 = Odontologo.generarOdontologoAleatorio();
		Odontologo odontologo3 = Odontologo.generarOdontologoAleatorio();
		Odontologo odontologo4 = Odontologo.generarOdontologoAleatorio();
		Odontologo odontologo5 = Odontologo.generarOdontologoAleatorio();
		Odontologo odontologo6 = Odontologo.generarOdontologoAleatorio();
		Odontologo odontologo7 = Odontologo.generarOdontologoAleatorio();
		Odontologo odontologo8 = Odontologo.generarOdontologoAleatorio();
		odontologoRepository.save(odontologo1);
		odontologoRepository.save(odontologo2);
		odontologoRepository.save(odontologo3);
		odontologoRepository.save(odontologo4);
		odontologoRepository.save(odontologo5);
		odontologoRepository.save(odontologo6);
		odontologoRepository.save(odontologo7);
		odontologoRepository.save(odontologo8);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

}
