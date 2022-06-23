package tp6p4.modelo;

import accesos.DataBaseDecorator;
import accesos.FileDecorator;
import servicios.RestCall;

public class Main {
	public static void main(String[] args) {
		Listados listado = new DataBaseDecorator(
				new FileDecorator(new RestCall("https://jsonplaceholder.typicode.com/posts")));
		System.out.println(listado.obtenerListado());
	}
}