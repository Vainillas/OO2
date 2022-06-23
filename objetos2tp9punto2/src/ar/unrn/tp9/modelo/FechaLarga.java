package ar.unrn.tp9.modelo;

import java.time.LocalDate;

public class FechaLarga implements DateManager {

	@Override
	public String obtenerFechaFormateada(LocalDate fecha) {
		return fecha.getDayOfMonth() + " de " + fecha.getMonth().name() + " de " + fecha.getYear();
	}

}
