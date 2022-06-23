package objetos2tp9punto1;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ar.unrn.tp9.modelo.ColectivosSur;
import ar.unrn.tp9.modelo.Compra;
import ar.unrn.tp9.modelo.FormaDeEnvio;
import ar.unrn.tp9.modelo.OCA;
import ar.unrn.tp9.modelo.Producto;
import ar.unrn.tp9.modelo.Productos;

public class TestCompra {
	@Test
	public void testCompraColectivos() {
		// Set Up
		Producto celular = new Producto(100.0);
		Producto telefonoFijo = new Producto(50.0);

		FormaDeEnvio envio = new ColectivosSur();

		Productos productos = new Productos(List.of(celular, telefonoFijo, celular));

		Compra compra = new Compra(productos, envio);

		// Ejercitacion
		Double rtadoObtenido = compra.calcularMontoTotal();

		// Verificacion
		Double rtadoEsperado = 375.0;

		Assert.assertEquals(rtadoEsperado, rtadoObtenido);

	}

	@Test
	public void testCompraOCA() {
		// Set Up
		Producto celular = new Producto(100.0);
		Producto telefonoFijo = new Producto(50.0);
		Producto microondas = new Producto(150.0);

		FormaDeEnvio envio = new OCA();

		Productos productos = new Productos(
				List.of(celular, telefonoFijo, celular, microondas, microondas, telefonoFijo));

		Compra compra = new Compra(productos, envio);

		// Ejercitacion
		Double rtadoObtenido = compra.calcularMontoTotal();

		// Verificacion
		Double rtadoEsperado = 1320.0;

		Assert.assertEquals(rtadoEsperado, rtadoObtenido);

	}

}
