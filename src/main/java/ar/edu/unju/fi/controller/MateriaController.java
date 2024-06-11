package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("materias")
public class MateriaController {
	@Autowired
	private Materia materia;
	
	@GetMapping("/listado")
	public String getMateriaPage(Model model) {
		model.addAttribute("materias", CollectionMateria.getMaterias());
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public ModelAndView getCreateForm() {
		Materia materia = new Materia();
		List<Carrera> carreras = CollectionCarrera.getCarreras();
		List<Docente> docentes = CollectionDocente.getDocentes();
		ModelAndView model = new ModelAndView("materias-create-form");
		model.addObject("docente", docentes);
		model.addObject("carrera", carreras);
		model.addObject("materia", materia);
		return model;
	}
	
	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute("materia") Materia materia) {
		System.out.println(materia);
		Carrera carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		Docente docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		System.out.println(carrera);
		System.out.println(docente);
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		materia.setModalidad(true);
		CollectionMateria.agregarMateria(materia);
		return "redirect:/materias/listado";
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getEditForm(Model model, @PathVariable(value="codigo") int codigo) {
		Materia materiaEncontrada = new Materia();
		materiaEncontrada = CollectionMateria.buscarMateria(codigo);
		model.addAttribute("docente", CollectionDocente.getDocentes());
		model.addAttribute("carrera", CollectionCarrera.getCarreras());
		model.addAttribute("materia", materiaEncontrada);
		return "materias-edit-form";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") Materia materia) {
		System.out.println(materia);
		Carrera carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		Docente docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		CollectionMateria.modificarMateria(materia);
		return "redirect:/materias/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String deleteMateria(@PathVariable(value="codigo") int codigo) {
		CollectionMateria.eliminarMateria(codigo);
		return "redirect:/materias/listado";
	}
}
