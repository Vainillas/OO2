package ar.unrn.edu.main;

import aliberti.framework.Menu;

public class Main {

  public static void main(String[] args) {
    Menu menu = new Menu("/framework/config/config.properties");
    menu.run();
  }
}
