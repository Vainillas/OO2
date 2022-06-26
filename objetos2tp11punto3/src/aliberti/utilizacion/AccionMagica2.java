package aliberti.utilizacion;

import aliberti.framework.Accion;

public class AccionMagica2 implements Accion {

	@Override
	public String descripcionItemMenu() {
		return "Esta accion realiza un truco magico";
	}

	@Override
	public void ejecutar() {
		System.out.println("Kadabra");
	}

	@Override
	public String nombreItemMenu() {
		return "Accion Magica 2";
	}
}
