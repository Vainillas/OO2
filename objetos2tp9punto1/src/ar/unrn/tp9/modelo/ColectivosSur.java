package ar.unrn.tp9.modelo;

public class ColectivosSur implements FormaDeEnvio {

	@Override
	public Double costoDeEnvio(Productos productos) {
		return productos.obtenerMontoTotal() * 0.5;
	}

}
