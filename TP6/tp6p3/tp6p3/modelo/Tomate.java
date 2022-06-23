package tp6p3.modelo;

public class Tomate implements Comestibles {

	private Comestibles comestible;

	private String descripcion;
	private double precio;

	public Tomate(Comestibles comestible, String descripcion, double precio) {
		this.comestible = comestible;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public double calcularPrecio() {
		return this.precio + this.comestible.calcularPrecio();
	}

	public String añadirPorcion() {
		return descripcion + " " + comestible.añadirPorcion();
	}

}