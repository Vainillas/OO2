package tp6p3.modelo;

public class Combo implements Comestibles {
	private String descripcion;
	private double precio;

	public Combo(String descripcion, double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public double calcularPrecio() {
		return precio;
	}

	public String añadirPorcion() {
		return descripcion;

	}
}