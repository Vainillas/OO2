package ar.unrn.tp9.modelo;

import java.util.List;

public class Productos {
	private List<Producto> listaProductos;

	public Productos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Double obtenerMontoTotal() {
		Double montoTotal = 0.0;
		for (Producto p : listaProductos) {
			montoTotal += p.costo();
		}
		return montoTotal;
	}

	public int cantidad() {
		return this.listaProductos.size();
	}
}
