package tp6p3.modelo;

public class Queso implements Comestibles {
	Comestibles comestible;

	private String descripcion;
	private double precio;

	public Queso(Comestibles combo, String descripcion, double precio) {
		this.comestible = combo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String aņadirPorcion() {
		return descripcion + " " + comestible.aņadirPorcion();
	}

	public double calcularPrecio() {
		return this.precio + this.comestible.calcularPrecio();
	}

}