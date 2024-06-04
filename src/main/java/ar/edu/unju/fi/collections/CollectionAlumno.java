package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> getAlumnos(){
		if(alumnos.isEmpty()) {
			alumnos.add(new Alumno(42731278, "Raul", "Lopéz", "raulopez@gmail.com", "3883446567", LocalDate.of(2000, 5, 2), "Ciudad de nieva", 6702));
			alumnos.add(new Alumno(44531879, "Camila", "Peréz", "cami002p@gmail.com", "3884766361", LocalDate.of(2004, 11, 6), "Centro", 7321));
			alumnos.add(new Alumno(43551231, "Celeste", "Martinez", "celemartinez@gmail.com", "3886443512", LocalDate.of(2002, 9, 9), "Los Perales", 5631));
		}
		return alumnos;
	}
	
	public static void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	public static void eliminarAlumno(int libretaUni) {
		Iterator<Alumno> iterator = alumnos.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLibretaUniversitaria()==libretaUni) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarAlumno(Alumno alumno) {
		Alumno alumnoAModificar = CollectionAlumno.buscarAlumno(alumno.getLibretaUniversitaria());
	    if (alumnoAModificar != null) {
	        alumnoAModificar.setDni(alumno.getDni());
	        alumnoAModificar.setNombre(alumno.getNombre());
	        alumnoAModificar.setApellido(alumno.getApellido());
	        alumnoAModificar.setEmail(alumno.getEmail());
	        alumnoAModificar.setTelefono(alumno.getTelefono());
	        alumnoAModificar.setFnacimiento(alumno.getFnacimiento());
	        alumnoAModificar.setDomicilio(alumno.getDomicilio());
			} else {
				System.out.println("No se encuentra libreta universitaria");
			}
		
	}
	
	public static Alumno buscarAlumno(int libretaUni) {
		Predicate<Alumno> filterLibreta = l -> l.getLibretaUniversitaria() == libretaUni;
		Optional<Alumno> alumno = alumnos.stream().filter(filterLibreta).findFirst();
		if(alumno.isPresent()) {
			return alumno.get();
		}else
			return null;
	}
}
