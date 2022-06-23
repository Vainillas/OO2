package tp5p1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import tp5p1.modelo.EmpleadoConGenteACargo;
import tp5p1.modelo.EmpleadoRegular;

public class SumaSalariosTest {
	@Test
	public void sumaDeSalariosNormal() {
		// Set up
		EmpleadoRegular r1 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r2 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r3 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r4 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r5 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r6 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r7 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r8 = new EmpleadoRegular(2500.0);

		EmpleadoConGenteACargo l1 = new EmpleadoConGenteACargo(3500.0, List.of(r1, r2));
		EmpleadoConGenteACargo l2 = new EmpleadoConGenteACargo(3500.0, List.of(r3, r4));
		EmpleadoConGenteACargo l3 = new EmpleadoConGenteACargo(3500.0, List.of(r5, r6));
		EmpleadoConGenteACargo l4 = new EmpleadoConGenteACargo(3500.0, List.of(r7, r8));

		EmpleadoConGenteACargo m1 = new EmpleadoConGenteACargo(5000.0, List.of(l1, l2));
		EmpleadoConGenteACargo m2 = new EmpleadoConGenteACargo(5000.0, List.of(l3, l4));

		EmpleadoConGenteACargo g1 = new EmpleadoConGenteACargo(7500.0, List.of(m1));
		EmpleadoConGenteACargo g2 = new EmpleadoConGenteACargo(7500.0, List.of(m2));

		EmpleadoConGenteACargo d1 = new EmpleadoConGenteACargo(10000.0, List.of(g1, g2));

		// Ejercitación
		Double totalSalarios = d1.calcularSalario();

		// Verificacion

		Double rtadoEsperado = 69000.0;

		assertEquals(rtadoEsperado, totalSalarios);

	}

	@Test
	public void sumaDeSalariosNormalSegundoCaso() {
		// Set up
		EmpleadoRegular r1 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r2 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r3 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r4 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r5 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r6 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r7 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r8 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r9 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r10 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r11 = new EmpleadoRegular(2500.0);
		EmpleadoRegular r12 = new EmpleadoRegular(2500.0);

		EmpleadoConGenteACargo l1 = new EmpleadoConGenteACargo(3500.0, List.of(r1, r2));
		EmpleadoConGenteACargo l2 = new EmpleadoConGenteACargo(3500.0, List.of(r3, r4));
		EmpleadoConGenteACargo l3 = new EmpleadoConGenteACargo(3500.0, List.of(r5, r6));
		EmpleadoConGenteACargo l4 = new EmpleadoConGenteACargo(3500.0, List.of(r7, r8));
		EmpleadoConGenteACargo l5 = new EmpleadoConGenteACargo(3500.0, List.of(r9, r10));
		EmpleadoConGenteACargo l6 = new EmpleadoConGenteACargo(3500.0, List.of(r11, r12));

		EmpleadoConGenteACargo m1 = new EmpleadoConGenteACargo(5000.0, List.of(l1, l2));
		EmpleadoConGenteACargo m2 = new EmpleadoConGenteACargo(5000.0, List.of(l3, l4));
		EmpleadoConGenteACargo m3 = new EmpleadoConGenteACargo(5000.0, List.of(l5, l6));

		EmpleadoConGenteACargo g1 = new EmpleadoConGenteACargo(7500.0, List.of(m1));
		EmpleadoConGenteACargo g2 = new EmpleadoConGenteACargo(7500.0, List.of(m2, m3));

		EmpleadoConGenteACargo d1 = new EmpleadoConGenteACargo(10000.0, List.of(g1, g2));

		// Ejercitación
		Double totalSalarios = d1.calcularSalario();

		// Verificacion

		Double rtadoEsperado = 91000.0;

		assertEquals(rtadoEsperado, totalSalarios);

	}
}
