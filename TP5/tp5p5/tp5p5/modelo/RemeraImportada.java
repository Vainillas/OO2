package tp5p5.modelo;

public class RemeraImportada extends Remera {
	private double precioUnitario;

	public RemeraImportada(double precioUnitario) {
		super(precioUnitario);
		this.precioUnitario = precioUnitario;
	}

	protected double calcularRecargos() {
		return 0.03 + 0.05 + 0.25;
	}

	protected double calcularBonificaciones() {
		return 0;
	}
}
