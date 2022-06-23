package tp6p2.servicios;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import tp6p2.modelo.GestorArchivo;

public class GestorArchivoImpl implements GestorArchivo {
	Writer escritor;
	Reader lector;

	public GestorArchivoImpl(Writer escritor, Reader lector) {
		this.escritor = escritor;
		this.lector = lector;

	}

	public void escribir(File file, String mensaje) {
		try {
			escritor.append(mensaje);
			escritor.close();
		} catch (IOException e) {
			throw new RuntimeException("No se pudo escribir el archivo: " + e.getCause());
		}
	}

	public String leer(File file, int cantCaracteres) {
		char[] i = new char[cantCaracteres];
		try {
			lector.read(i);
			lector.close();
		} catch (IOException e) {
			throw new RuntimeException("No se pudo leer el archivo: " + e.getCause());
		}
		return String.valueOf(i);

	}
}
