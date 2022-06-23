package accesos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tp6p4.modelo.Listados;

public class FileDecorator implements Listados {
	Listados listador;

	public FileDecorator(Listados listador) {
		this.listador = listador;
	}

	@Override
	public String obtenerListado() {
		File miArchivo = new File("RegistroDePosts.txt");

		FileWriter myWriter;
		try {
			miArchivo.createNewFile();
			myWriter = new FileWriter(miArchivo, false);
			myWriter.write(listador.obtenerListado());
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listador.obtenerListado();
	}
}