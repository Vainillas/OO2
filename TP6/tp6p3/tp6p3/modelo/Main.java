package tp6p3.modelo;

public class Main {
	public static void main(String[] args) {
		Comestibles combo = new Carne(new Queso(new Combo("Combo con Lasagna y Ajo", 250.0), "Queso", 450.0), "Carne",
				99.99);

		System.out.println("La descripcion del Pedido es: " + combo.añadirPorcion());
		System.out.println("El costo total del Pedido es: " + combo.calcularPrecio());

	}

}