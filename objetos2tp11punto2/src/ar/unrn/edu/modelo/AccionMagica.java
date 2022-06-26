package ar.unrn.edu.modelo;

import aliberti.framework.Accion;

public class AccionMagica implements Accion {

  @Override
  public String descripcionItemMenu() {
    return "Esta accion realiza un truco magico";
  }

  @Override
  public void ejecutar() {
    System.out.println("Avada kedavra");
  }

  @Override
  public String nombreItemMenu() {
    return "Accion Magica";
  }
}
