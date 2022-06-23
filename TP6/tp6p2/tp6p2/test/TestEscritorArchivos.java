package tp6p2.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tp6p2.modelo.GestorArchivo;
import tp6p2.modelo.Reporte;
import tp6p2.modelo.ReporteVerificacionExistencia;
import tp6p2.modelo.ReporteVerificacionNoNulo;
import tp6p2.servicios.GestorArchivoImpl;

public class TestEscritorArchivos {

	@Test
	public void testEscritorArchivoExistente() throws IOException { // Da error la primera vez
		// Inicialización
		File archivo = new File("C:\\Mateo\\Universidad\\OO2\\archivoTp6Reporte.txt");
		FileWriter writer = new FileWriter(archivo);
		FileReader reader = new FileReader(archivo);
		GestorArchivo gestor = new GestorArchivoImpl(writer, reader);
		ReporteVerificacionExistencia reporte = new ReporteVerificacionExistencia(
				new Reporte("Reporte Liquidacion 6", gestor));

		// Ejercitación
		try {
			reporte.export(archivo);
			Assert.fail("Debería haber tirado una excepción");
		}
		// Validación
		catch (IllegalArgumentException e) {
			String mensajeError = "El archivo ya existe...";
			Assert.assertEquals("Las excepciones no son las mismas ", mensajeError, e.getMessage());
		}

	}

	@Test
	public void testEscritorArchivoNoExistente() throws IOException {
		// Inicialización
		int random = (int) Math.pow(Math.random(), -3);
		File archivo = new File("C:\\Mateo\\Universidad\\OO2\\archivoTp6Reporte" + random + ".txt");
		FileWriter writer = new FileWriter(archivo);
		FileReader reader = new FileReader(archivo);
		GestorArchivo gestor = new GestorArchivoImpl(writer, reader);
		Reporte reporte = new Reporte("Reporte Liquidacion 6", gestor);

		// Ejercitación
		reporte.export(archivo);
		String texto = gestor.leer(archivo, 21);
		// Validación
		Assert.assertEquals("Reporte Liquidacion 6", texto);
	}

	@Test
	public void testEscritorArchivoNoNulo() throws IOException {
		// Inicialización
		File archivo = null;
		FileWriter writer = null;
		FileReader reader = null;
		GestorArchivo gestor = new GestorArchivoImpl(writer, reader);
		ReporteVerificacionNoNulo reporte = new ReporteVerificacionNoNulo(new Reporte("Reporte Liquidacion 6", gestor));

		// Ejercitación
		try {
			reporte.export(archivo);
			Assert.fail("Debería haber tirado una excepción");
		}
		// Validación
		catch (IllegalArgumentException e) {
			String mensajeError = "File es NULL; no puedo exportar...";
			Assert.assertEquals("Las excepciones no son las mismas ", mensajeError, e.getMessage());
		}
	}
}
