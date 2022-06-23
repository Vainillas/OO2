package tp5p4.modelo;

public abstract class Calculador {
	private LogTransaction log; // Necesita una interfaz
	private int mesEnPromocion;

	public Calculador(int mesEnPromocion, LogTransaction log) {
		this.log = log;
		this.mesEnPromocion = mesEnPromocion;
	}

	public double calcularPrecio(double precioProducto) {
		double precioTotal = this.aplicarDescuento(precioProducto);
		this.loggear(this.getClass().getName());
		return precioTotal;
	}

	protected abstract double aplicarDescuento(double precioProducto);

	public void loggear(String clase) {
		log.log(clase);
	}
}
