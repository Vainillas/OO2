package ar.unrn.tp9.modelo;

public class ViaCargo implements FormaDeEnvio {

	@Override
	public Double costoDeEnvio(Productos productos) {
		if (productos.cantidad() > 15)
			return productos.obtenerMontoTotal() * 0.8;
		else
			return 150.0;
	}

}
