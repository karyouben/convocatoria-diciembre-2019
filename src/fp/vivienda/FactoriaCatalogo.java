package fp.vivienda;

import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaCatalogo {
	
	public static List<Vivienda> leeViviendas(String fichero){
		Checkers.checkNoNull(fichero);
		List<String> lineas=Ficheros.leeFichero("Error al leer fichero", fichero);
		lineas.remove(0);
		
		List<Vivienda> res=new ArrayList<Vivienda>();
		for(String linea:lineas) {
			Vivienda r=parseaVivienda(linea);
			res.add(r);
		}return res;
	}

	private static Vivienda parseaVivienda(String linea) {
		Checkers.checkNoNull(linea);
		String[] trozos=linea.split(",");
		Checkers.check("Formato no valido", trozos.length==6);
		Double superficie=Double.parseDouble(trozos[0].trim());
		Double precio=Double.parseDouble(trozos[1].trim());
		Integer numHabitaciones=Integer.parseInt(trozos[2].trim());
		TipoVivienda tipo=TipoVivienda.valueOf(trozos[3].trim().toUpperCase());
		String direccion=trozos[4].trim();
		String distrito=trozos[5].trim();
		return new Vivienda(superficie, precio, numHabitaciones, tipo, direccion, distrito);
	}

}
