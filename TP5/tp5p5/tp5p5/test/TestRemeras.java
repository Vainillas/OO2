package tp5p5.test;

import org.junit.Assert;
import org.junit.Test;

import tp5p5.modelo.Remera;
import tp5p5.modelo.RemeraImportada;
import tp5p5.modelo.RemeraNacional;

public class TestRemeras {

	@Test
	public void TestRemeraImportada() {
		Remera remeraI = new RemeraImportada(1500);
		double resultado = remeraI.calcularPrecio();
		Assert.assertEquals(1995, resultado, 0.01f);

	}

	@Test
	public void TestRemeraNacional() {
		Remera remeraN = new RemeraNacional(1500);
		double resultado = remeraN.calcularPrecio();
		Assert.assertEquals(1447.5, resultado, 0.01f);

	}
}
