package ar.unrn.tp9.modelo;

public class CorreoArgentino implements FormaDeEnvio {

	@Override
	public Double costoDeEnvio(Productos productos) {
		return 150.0;
	}

}
