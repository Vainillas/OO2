package ar.unrn.tp3.ej2.modelo;

import javax.mail.MessagingException;

public interface EmisorDeCorreo {
	public boolean enviarCorreoCumpleaņos(String correoEmpleado) throws MessagingException;
}
