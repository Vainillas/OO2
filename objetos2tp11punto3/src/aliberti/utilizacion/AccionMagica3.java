package aliberti.utilizacion;

import aliberti.framework.Accion;

public class AccionMagica3 implements Accion {

	@Override
	public String descripcionItemMenu() {
		return "Esta accion realiza un truco magico";
	}

	@Override
	public void ejecutar() {
		System.out.println("Alakazam");
	}

	@Override
	public String nombreItemMenu() {
		return "Accion Magica 3";
	}
}
