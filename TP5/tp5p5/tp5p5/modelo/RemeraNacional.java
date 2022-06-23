package tp5p5.modelo;

public class RemeraNacional extends Remera {
	private double precioUnitario;

	public RemeraNacional(double precioUnitario) {
		super(precioUnitario);
		this.precioUnitario = precioUnitario;
	}

	protected double calcularRecargos() {

		return 0.015 + 0.15;
	}

	protected double calcularBonificaciones() {
		return 0.20;
	}
}
