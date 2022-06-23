package tp5p2.modelo;

import java.util.List;

public abstract class Item {
	private int horas;
	private List<Item> listaItems;

	public Item(int horas, List<Item> listaItems) {
		this.horas = horas;
		this.listaItems = listaItems;
	}

	public int calcularTiempo() {
		int sumaHorasTotal = this.horas;
		if (listaItems != null) {
			for (Item i : listaItems) {
				sumaHorasTotal += i.calcularTiempo();
			}
		}
		return sumaHorasTotal;
	}

}
