package tp5p4.test;

import java.time.LocalDate;

import tp5p4.modelo.InterfazProveedorDeFechas;

public class ProveedorFechaTest implements InterfazProveedorDeFechas {

	public ProveedorFechaTest() {

	}

	public int obtenerMesNoPromocion() {
		return LocalDate.now().getMonth().getValue() - 1;
	}

	public int obtenerMesActual() {
		return LocalDate.now().getMonth().getValue();
	}

}