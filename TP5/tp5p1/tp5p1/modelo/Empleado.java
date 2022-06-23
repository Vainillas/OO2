package tp5p1.modelo;

import java.util.List;

public abstract class Empleado {
	private List<Empleado> empleadosACargo;
	private Double salario;

	public Empleado(Double salario, List<Empleado> listaGerentes) {
		this.salario = salario;
		empleadosACargo = listaGerentes;
	}

	public Double calcularSalario() {
		Double sumaSalario = this.salario;
		if (empleadosACargo != null) {
			for (Empleado e : empleadosACargo) {
				sumaSalario += e.calcularSalario();
			}
		}
		return sumaSalario;
	}
}
