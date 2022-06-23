package tp5p4.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tp5p4.modelo.Calculador;
import tp5p4.modelo.CalculadorJubilado;
import tp5p4.modelo.CalculadorRegular;
import tp5p4.modelo.InterfazProveedorDeFechas;
import tp5p4.modelo.LogTransaction;

public class CalculadorTest {
	LogTransaction log = new LogTransaction();
	InterfazProveedorDeFechas proveedorFecha = new ProveedorFechaTest();

	@Test
	public void testJubiladosSinPromocion() {
		Calculador calculador = new CalculadorJubilado(proveedorFecha.obtenerMesNoPromocion(), log);
		double resultado = calculador.calcularPrecio(200);
		Assert.assertEquals(220d, resultado, 0.01f);
	}

	@Test
	public void testJubiladosConPromocion() {
		Calculador calculador = new CalculadorJubilado(proveedorFecha.obtenerMesActual(), log);
		double resultado = calculador.calcularPrecio(200);
		Assert.assertEquals(200d, resultado, 0.01f);
	}

	@Test
	public void testRegularConPromocion() {
		Calculador calculador = new CalculadorRegular(proveedorFecha.obtenerMesActual(), log);
		double resultado = calculador.calcularPrecio(200);
		Assert.assertEquals(230d, resultado, 0.01f);
	}

	@Test
	public void testRegularSinPromocion() {
		Calculador calculador = new CalculadorRegular(proveedorFecha.obtenerMesNoPromocion(), log);
		double resultado = calculador.calcularPrecio(200);
		Assert.assertEquals(242d, resultado, 0.01f);
	}

}
