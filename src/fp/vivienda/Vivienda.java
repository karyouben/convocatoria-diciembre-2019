package fp.vivienda;

import fp.utiles.Checkers;

//como es un record esta ya implementado por default el constructor base, criterio de igualdad y representacion como cadena
public record Vivienda(Double superficie, Double precio,Integer numHabitaciones,
		TipoVivienda tipo,String direccion,String distrito) implements Comparable<Vivienda> {
	
	public Vivienda{
		Checkers.check("La superficie debe ser mayor que cero ", superficie>0);
		Checkers.check("La el precio debe ser mayor que cero ", precio>0);
		Checkers.check("El número de habitaciones debe ser mayor o igual que cero ", numHabitaciones>=0);
		Checkers.check("El distrito postal debe estar compuesto por 5 dígitos ", distrito.length()==5);
	}
	
	public Boolean capital() {
		Boolean res=null;
		if(distrito.charAt(2)=='0') {
			res=true;
		}else if(distrito.charAt(2)!='0') {
			res=false;
		}return res;
	}
	
	public Double PMetroCuadrado() {
		return precio()/superficie();
	}
	
	public int compareTo(Vivienda o) {
		int res=this.direccion().compareTo(o.direccion());
		if(res==0) {
			res=this.distrito().compareTo(o.distrito());
		}return res;
	}

}
