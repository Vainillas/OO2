package tp6p2.modelo;

import java.io.File;

public interface GestorArchivo {

	public void escribir(File file, String mensaje);

	public String leer(File file, int cantCaracteres);

}
