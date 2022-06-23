package ar.unrn.tp9.modelo;

import java.time.LocalDate;

public class FechaCorta implements DateManager {

	@Override
	public String obtenerFechaFormateada(LocalDate fecha) {
		return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
	}

}
