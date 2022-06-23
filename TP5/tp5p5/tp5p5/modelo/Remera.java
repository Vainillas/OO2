package tp5p5.modelo;

public abstract class Remera {
	private double precioUnitario;

	public Remera(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double calcularPrecio() {
		return this.precioUnitario - this.precioUnitario * calcularBonificaciones()
				+ this.precioUnitario * calcularRecargos();
	}

	protected abstract double calcularRecargos();

	protected abstract double calcularBonificaciones();
}
