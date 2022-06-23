package tp6p2.modelo;

import java.io.File;

public class Reporte implements Reportes {
	protected String reporte;
	protected GestorArchivo escritor;

	public Reporte(String reporte, GestorArchivo escritor) {
		this.reporte = reporte;
		this.escritor = escritor;
	}

	public void export(File file) {
		escritor.escribir(file, reporte);
	}

	public String importar(File file, int cantidadCaracteres) {
		if (file == null) {
			throw new IllegalArgumentException("File es NULL; no puedo importar...");
		}
		return escritor.leer(file, cantidadCaracteres);
	}
	/*
	 * if (file == null) { throw new
	 * IllegalArgumentException("File es NULL; no puedo exportar..."); } s if
	 * (file.exists()) { throw new
	 * IllegalArgumentException("El archivo ya existe..."); }
	 */
}
