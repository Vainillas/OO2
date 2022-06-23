package ar.unrn.tp9.modelo;

public class OCA implements FormaDeEnvio {

	@Override
	public Double costoDeEnvio(Productos productos) {
		if (productos.cantidad() > 5)
			return productos.obtenerMontoTotal() * 1.2;
		else
			return productos.obtenerMontoTotal() * 0.3;
	}

}
