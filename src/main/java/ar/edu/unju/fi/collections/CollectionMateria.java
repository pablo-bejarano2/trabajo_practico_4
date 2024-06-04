package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Component
public class CollectionMateria {

	private static List<Materia> materias = new ArrayList<Materia>();
	public static List<Materia> getMaterias(){
		if(materias.isEmpty()) {
			materias.add(new Materia(300, "Biologia", 50, "Anfiteatro", true, new Docente(200, "Roberto", "Lastiri", "robertLastiri@gmail.com", "3885407867"), new Carrera(101, "Ingenieria Química", (byte)5, false)));
			materias.add(new Materia(301, "Programacion", 60, "Aula Virtual 11", false, new Docente(201, "Joaquin", "Martinez", "joaquinmartines@gmail.com", "3889504354"), new Carrera(100, "A.P.U.", (byte) 3, true)));
		}
		return materias;
	}
	
	public static void agregarMateria(Materia materia) {
		materias.add(materia);
	}
	
	public static void eliminarMateria(int codMateria) {
		Iterator<Materia> iterator = materias.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()==codMateria) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarMateria(Materia materia) {
		for(Materia mat : materias) {
			if(mat.getCodigo() == materia.getCodigo()) {
				mat.setNombre(materia.getNombre());
				mat.setCantidadHoras(materia.getCantidadHoras());
				mat.setCurso(materia.getCurso());
				mat.setModalidad(materia.getModalidad());
				mat.setDocente(materia.getDocente());
				mat.setCarrera(materia.getCarrera());
			}
		}
	}
	
	public static Materia buscarMateria(int codigo) {
		Predicate<Materia> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		if(materia.isPresent()) {
			return materia.get();
		}else {
			return null;
		}
	}
}
