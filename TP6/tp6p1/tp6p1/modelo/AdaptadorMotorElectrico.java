package tp6p1.modelo;

public class AdaptadorMotorElectrico implements Motor {
	private MotorElectrico motor;

	public AdaptadorMotorElectrico(MotorElectrico motor) {
		this.motor = motor;
	}

	public String arrancar() {
		return motor.conectar() + "\n" + motor.activar();
	}

	public String acelerar() {
		return motor.moverMasRapido();
	}

	public String apagar() {
		return motor.detener() + "\n" + motor.desconectar();
	}
}
