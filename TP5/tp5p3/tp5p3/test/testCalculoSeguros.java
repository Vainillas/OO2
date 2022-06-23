package tp5p3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import tp5p3.modelo.Paquete;
import tp5p3.modelo.SeguroRegular;

public class testCalculoSeguros {
	@Test
	public void sumaDeSeguros() {
		SeguroRegular sr1 = new SeguroRegular(25);
		SeguroRegular sr2 = new SeguroRegular(25);
		SeguroRegular sr3 = new SeguroRegular(25);
		SeguroRegular sr4 = new SeguroRegular(25);
		SeguroRegular sr5 = new SeguroRegular(25);
		SeguroRegular sr6 = new SeguroRegular(25);
		SeguroRegular sr7 = new SeguroRegular(25);
		SeguroRegular sr8 = new SeguroRegular(25);
		Paquete p1 = new Paquete(List.of(sr1, sr2, sr3, sr4));
		Paquete p2 = new Paquete(List.of(sr5, sr6, sr7, sr8));
		Paquete p3 = new Paquete(List.of(p1, p2));
		assertEquals(144.0, p3.calcularMonto());
	}

	@Test
	public void sumaDeSegurosSegundoCaso() {
		SeguroRegular sr1 = new SeguroRegular(25);
		SeguroRegular sr2 = new SeguroRegular(25);
		SeguroRegular sr3 = new SeguroRegular(25);
		SeguroRegular sr4 = new SeguroRegular(25);
		SeguroRegular sr5 = new SeguroRegular(25);
		SeguroRegular sr6 = new SeguroRegular(25);
		SeguroRegular sr7 = new SeguroRegular(25);
		SeguroRegular sr8 = new SeguroRegular(25);

		Paquete p1 = new Paquete(List.of(sr1, sr2, sr3, sr4));// 80
		Paquete p2 = new Paquete(List.of(sr5));// 23.75

		Paquete p3 = new Paquete(List.of(sr6, sr7, sr8));// 63.75
		Paquete p4 = new Paquete(List.of(p1, p2, p3));

		assertEquals(142.375, p4.calcularMonto());
	}
}
