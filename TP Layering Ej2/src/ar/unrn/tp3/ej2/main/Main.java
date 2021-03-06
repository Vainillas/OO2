package ar.unrn.tp3.ej2.main;

import java.io.IOException;

import ar.unrn.tp3.ej2.accesos.Lector;
import ar.unrn.tp3.ej2.correo.EmailManager;
import ar.unrn.tp3.ej2.modelo.CumpleaņosEmpleado;
import ar.unrn.tp3.ej2.modelo.ProveedorFechas;

public class Main {

	public static void main(String[] args) {
		ProveedorFechas proveedorFecha = new ProveedorFechas();
		EmailManager managerCorreo = new EmailManager(proveedorFecha);
		Lector lector = new Lector("C:\\Mateo\\Universidad\\OO2\\archivoLayeringEj2.txt");
		CumpleaņosEmpleado cumpleaņosEmpleado = new CumpleaņosEmpleado(lector, managerCorreo, proveedorFecha);
		try {
			cumpleaņosEmpleado.enviarFelicitaciones();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
