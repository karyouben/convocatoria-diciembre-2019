package fp.vivienda.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.vivienda.Catalogo;
import fp.vivienda.FactoriaCatalogo;
import fp.vivienda.TipoVivienda;
import fp.vivienda.Vivienda;


public class TestCatalogo {

	public static void main(String[] args) {
		List<Vivienda> viviendas=FactoriaCatalogo.leeViviendas("data/catalogo.csv");
		Catalogo v=new Catalogo(viviendas);
		System.out.println("\nTestGetPrecioMedioPorDistritoDeTipos");
		System.out.println("======================================");
		testGetPrecioMedioPorDistritoDeTipos(v,Set.of(TipoVivienda.ADOSADO,TipoVivienda.CHALET));
		System.out.println("\nTestGetDistritosMasNViviendas");
		System.out.println("======================================");
		testGetDistritosMasNViviendas(v,3);
		System.out.println("\nTestGetTiposViviendasMasCarasCalle");
		System.out.println("======================================");
		testGetTiposViviendasMasCarasCalle(v,"Calle Mayor",3);
		System.out.println("\nTestGetViviendaMasBarataPorTipoEnCapital");
		System.out.println("======================================");
		testGetViviendaMasBarataPorTipoEnCapital(v);
		System.out.println("\nTestGetPorcViviendasPreciosMayorUmbralPorDistrito");
		System.out.println("======================================");
		testGetPorcViviendasPreciosMayorUmbralPorDistrito(v,0.1);

	}


	private static void testGetPrecioMedioPorDistritoDeTipos(Catalogo v, Set<TipoVivienda> tipo) {
		try {
			String msg=String.format("El precio medio por distrito de las viviendas del conjunto de tipos %s es: ",
					tipo);
			System.out.println(msg);
			Map<String,Double> p=v.getPrecioMedioPorDistritoDeTipos(tipo);
			p.entrySet().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.err.println("Excepcion inesesperada capturada " +e.getMessage());
		}
		
	}
	private static void testGetDistritosMasNViviendas(Catalogo v,Integer n) {
		try {
			String msg=String.format("Los distritos con mas de %d viviendas son: %s ",
					n,v.getDistritosMasNViviendas(n));
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Excepcion inesesperada capturada " +e.getMessage());
		}
		
	}
	
	private static void testGetTiposViviendasMasCarasCalle(Catalogo v, String direccion, Integer n) {
		try {
			String msg=String.format("Los %d tipos de vivienda mas caras de la direccion "+ direccion+" son: %s ",
					n,v.getTiposViviendasMasCarasCalle(direccion, n));
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Excepcion inesesperada capturada " +e.getMessage());
		}
		
	}
	
	private static void testGetViviendaMasBarataPorTipoEnCapital(Catalogo v) {
		try {
			String msg=String.format("Las viviendas mas baratas por tipo de la capital son: ");
			System.out.println(msg);
			Map<TipoVivienda,Vivienda> p=v.getViviendaMasBarataPorTipoEnCapital();
			p.entrySet().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.err.println("Excepcion inesesperada capturada " +e.getMessage());
		}
		
		
	}
	
	private static void testGetPorcViviendasPreciosMayorUmbralPorDistrito(Catalogo v, Double umbralPrecio) {
		try {
			String msg=String.format("El porcentaje de viviendas precio mayor umbral de "+umbralPrecio+" por distrito es: ");
			System.out.println(msg);
			Map<String,Double> p=v.getPorcViviendasPreciosMayorUmbralPorDistrito(umbralPrecio);
			p.entrySet().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.err.println("Excepcion inesesperada capturada " +e.getMessage());
		}
		
	}

}
