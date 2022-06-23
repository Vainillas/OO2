package tp6p2.modelo;

import java.io.File;

public interface Reportes {
	public void export(File file);

	public String importar(File file, int cantidadCaracteres);
}
