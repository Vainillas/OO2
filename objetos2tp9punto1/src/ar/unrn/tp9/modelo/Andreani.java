package ar.unrn.tp9.modelo;

public class Andreani implements FormaDeEnvio {

	@Override
	public Double costoDeEnvio(Productos productos) {
		return productos.obtenerMontoTotal() * 2;
	}

}
