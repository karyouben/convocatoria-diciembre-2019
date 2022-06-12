package fp.vivienda.test;

import java.util.List;

import fp.vivienda.FactoriaCatalogo;
import fp.vivienda.Vivienda;

public class TestFactoriaCatalogo {

	public static void main(String[] args) {
		testLeeVivienda("data/catalogo.csv");

	}

	private static void testLeeVivienda(String fichero) {
		System.out.println("\nTestLeeVivienda =========");
		List<Vivienda> viviendas = FactoriaCatalogo.leeViviendas(fichero);
		System.out.println(" Vivienda: ");
		for(Vivienda v:viviendas) {
			System.out.println(v);
		}
		
	}

}
