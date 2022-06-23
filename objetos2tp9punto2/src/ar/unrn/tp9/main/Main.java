package ar.unrn.tp9.main;

import java.time.LocalDate;

import ar.unrn.tp9.modelo.DateManager;
import ar.unrn.tp9.modelo.FechaCorta;
import ar.unrn.tp9.modelo.Persona;

public class Main {
	public static void main(String args[]) {
		// DateManager date = new FechaLarga();
		DateManager date = new FechaCorta();
		Persona persona = new Persona(LocalDate.of(2001, 5, 24), date);
		System.out.println(persona.obtenerFechaNacimiento());
	}

}
