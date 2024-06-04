package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	public static List<Carrera> getCarreras(){
		if(carreras.isEmpty()) {
			carreras.add(new Carrera(100, "A.P.U.", (byte) 3, true));
			carreras.add(new Carrera(101, "Ingenieria Química", (byte)5, false));
			carreras.add(new Carrera(102, "Ingenieria Industrial", (byte)5, true));
		}
		return carreras;
	}
	public static void agregarCarrera(Carrera carrera) {
		carreras.add(carrera);
	}
	public static void eliminarCarrera(int codCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()==codCarrera) {
				iterator.remove();
			}
		}
	}
	public static void modificarCarrera(Carrera carrera) {
		for(Carrera carre : carreras) {
			if(carre.getCodigo() == carrera.getCodigo()) {
				carre.setNombre(carrera.getNombre());
				carre.setCantidadAnios(carrera.getCantidadAnios());
				carre.setEstado(carrera.getEstado());
			}else {
				System.out.println("No se encuentra el código de la carrera");
			}
		}
	}
	public static Carrera buscarCarrera(int codigo) {
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		if(carrera.isPresent()) {
			return carrera.get();
		}else {
			return null;
		}
	} 
}
