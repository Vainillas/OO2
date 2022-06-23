package tp6p2.modelo;

import java.io.File;

public class ReporteVerificacionNoNulo implements Reportes {
	private Reportes reporte;

	public ReporteVerificacionNoNulo(Reportes reporte) {
		this.reporte = reporte;
	}

	public void export(File file) {
		if (file == null) {
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		}
		reporte.export(file);

	}

	public String importar(File file, int cantidadCaracteres) {
		return reporte.importar(file, cantidadCaracteres);
	}

}
