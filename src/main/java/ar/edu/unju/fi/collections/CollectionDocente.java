package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {
	private static List<Docente> docentes = new ArrayList<Docente>();
	
	public static List<Docente> getDocentes(){
		if(docentes.isEmpty()) {
			docentes.add(new Docente(200, "Roberto", "Lastiri", "robertLastiri@gmail.com", "3885407867"));
			docentes.add(new Docente(201, "Joaquin", "Martinez", "joaquinmartines@gmail.com", "3889504354"));
		}
		return docentes;
	}
	
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	public static void eliminarDocente(int legajo) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLegajo() == legajo) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarDocente(Docente docente) {
		 Docente docenteAModificar = CollectionDocente.buscarDocente(docente.getLegajo());
		    if (docenteAModificar != null) {
		        docenteAModificar.setNombre(docente.getNombre());
		        docenteAModificar.setApellido(docente.getApellido());
		        docenteAModificar.setEmail(docente.getEmail());
		        docenteAModificar.setTelefono(docente.getTelefono());
			}else {
				System.out.println("No se encuentra el legajo");
			}
		
	}
	
	public static Docente buscarDocente(int legajo) {
		Predicate<Docente> filterLegajo = d -> d.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
		if(docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}
	}
}
