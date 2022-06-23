package ar.unrn.tp9.modelo;

import java.time.LocalDate;

public class Persona {
	LocalDate fechaCumple;
	DateManager dateManager;

	public Persona(LocalDate fechaCumple, DateManager dateManager) {
		this.fechaCumple = fechaCumple;
		this.dateManager = dateManager;
	}

	public String obtenerFechaNacimiento() {
		return dateManager.obtenerFechaFormateada(fechaCumple);
	}
}
