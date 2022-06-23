package tp6p1.test;

import tp6p1.modelo.AdaptadorMotorElectrico;
import tp6p1.modelo.Motor;
import tp6p1.modelo.MotorComun;
import tp6p1.modelo.MotorEconomico;
import tp6p1.modelo.MotorElectrico;

public class TestEstadoMotor {

	public static void main(String args[]) {
		Motor motorComun = new MotorComun();
		Motor motorEco = new MotorEconomico();
		MotorElectrico motorElectrico = new MotorElectrico();
		Motor AdaptadorMotorElectrico = new AdaptadorMotorElectrico(motorElectrico);

		System.out.println("||||||||||||Motor Común||||||||||||");
		System.out.println(motorComun.arrancar());
		System.out.println(motorComun.acelerar());
		System.out.println(motorComun.apagar());

		System.out.println("||||||||||||Motor Económico||||||||||||");
		System.out.println(motorEco.arrancar());
		System.out.println(motorEco.acelerar());
		System.out.println(motorEco.apagar());

		System.out.println("||||||||||||Motor Eléctrico||||||||||||");
		System.out.println(AdaptadorMotorElectrico.arrancar());
		System.out.println(AdaptadorMotorElectrico.acelerar());
		System.out.println(AdaptadorMotorElectrico.apagar());
	}

}
