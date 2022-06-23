package tp5p3.modelo;

import java.util.List;

public abstract class Seguro {
	private double monto;
	private List<Seguro> listaSeguros;

	public Seguro(double monto, List<Seguro> listaSeguros) {
		this.monto = monto;
		this.listaSeguros = listaSeguros;
	}

	public Double calcularMonto() {
		Double sumaSalario = this.monto;
		if (listaSeguros != null) {
			for (Seguro s : listaSeguros) {
				sumaSalario += s.calcularMonto();
			}
		}
		if (listaSeguros != null)
			sumaSalario = sumaSalario - (sumaSalario / 100) * this.listaSeguros.size() * 5;
		else
			sumaSalario = sumaSalario - (sumaSalario / 100) * 0 * 5;
		// monto 200 ! 5 seguros * 5 = 25%
		// suma = 150
		return sumaSalario;

	}
}
