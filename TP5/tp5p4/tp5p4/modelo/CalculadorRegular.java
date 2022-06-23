package tp5p4.modelo;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public class CalculadorRegular extends Calculador {
	private LogTransaction log;
	private int mesEnPromocion;

	public CalculadorRegular(int mesEnPromocion, LogTransaction log) {
		super(mesEnPromocion, log);
		this.log = log;
		this.mesEnPromocion = mesEnPromocion;
	}

	public double aplicarDescuento(double precioProducto) {
		if (of(mesEnPromocion).equals(now().getMonth())) {
			return precioProducto + precioProducto * 0.15;
		} else {
			return precioProducto + precioProducto * 0.21;
		}
	}
}
