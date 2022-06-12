package fp.vivienda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Catalogo {
	private List<Vivienda> viviendas;

	public List<Vivienda> getViviendas() {
		return viviendas;
	}
	
	public Catalogo(Stream<Vivienda> viviendas) {
		this.viviendas=viviendas.collect(Collectors.toList());
	}
	
	public Catalogo(List<Vivienda> viviendas) {
		this.viviendas=new ArrayList<Vivienda>(viviendas);
	}
	
	public Catalogo() {
		viviendas=new ArrayList<>();
	}
	
	public Catalogo(Collection<Vivienda> viviendas) {
		this.viviendas=new ArrayList<Vivienda>(viviendas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(viviendas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalogo other = (Catalogo) obj;
		return Objects.equals(viviendas, other.viviendas);
	}

	@Override
	public String toString() {
		return "Catalogo [viviendas=" + viviendas + "]";
	}
	
	//ejercicio 1
	public Map<String,Double> getPrecioMedioPorDistritoDeTipos(Set<TipoVivienda> conjTipos){
		return viviendas.stream()
				.filter(v->conjTipos.contains(v.tipo()))
				.collect(Collectors.groupingBy(Vivienda::distrito,Collectors.averagingDouble(Vivienda::precio)));
	}
	
	//ejercicio 2
	
	public Map<String,Long> getNumViviendasPorDistrito(){
		return viviendas.stream()
				.collect(Collectors.groupingBy(Vivienda::distrito,Collectors.counting()));
	}
	
	public Set<String> getDistritosMasNViviendas(Integer n){
		Map<String,Long> m=getNumViviendasPorDistrito();
		return m.entrySet().stream()
				.filter(v->v.getValue()>n)
				.map(v->v.getKey())
				.collect(Collectors.toSet());
	}
	
	public List<TipoVivienda> getTiposViviendasMasCarasCalle(String calle,Integer n){
		
		return viviendas.stream()
				.filter(v->v.direccion().equals(calle))
				.sorted(Comparator.comparing(Vivienda::PMetroCuadrado).reversed())
				.limit(n)
				.map(Vivienda::tipo)
				.distinct()
				.collect(Collectors.toList());
		
	}
	
	public Map<TipoVivienda,Vivienda> getViviendaMasBarataPorTipoEnCapital(){
		return viviendas.stream()
				.filter(v->v.capital())
				.collect(Collectors.groupingBy(Vivienda::tipo,
						Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Vivienda::precio)), v->v.get())));
	}
	
	public Map<String,Double> getPorcViviendasPreciosMayorUmbralPorDistrito(Double umbralPrecio){
		
	}
	
	

}
