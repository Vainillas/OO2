package tp6p3.modelo;

public class Carne implements Comestibles {
	private Comestibles comestible;

	private String descripcion;
	private double precio;

	public Carne(Comestibles comestible, String descripcion, double precio) {
		this.comestible = comestible;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String añadirPorcion() {
		return descripcion + " " + comestible.añadirPorcion();
	}

	public double calcularPrecio() {
		return this.precio + this.comestible.calcularPrecio();
	}

}
