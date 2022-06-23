package ar.unrn.tp9.modelo;

public class Compra {
	private Productos productos;
	private FormaDeEnvio formaDeEnvio;

	public Compra(Productos productos, FormaDeEnvio formaDeEnvio) {
		this.productos = productos;
		this.formaDeEnvio = formaDeEnvio;
	}

	public Double calcularMontoTotal() {
		return this.productos.obtenerMontoTotal() + this.formaDeEnvio.costoDeEnvio(this.productos);
	}

}
