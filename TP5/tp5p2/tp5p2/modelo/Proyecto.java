package tp5p2.modelo;

import java.util.List;

public class Proyecto {
	List<Item> items;

	public Proyecto(List<Item> items) {
		this.items = items;
	}

	public int obtenerHorasTotales() {
		int horas = 0;
		for (Item i : items) {
			horas += i.calcularTiempo();
		}
		return horas;
	}

}
