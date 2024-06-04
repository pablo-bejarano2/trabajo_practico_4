package ar.edu.unju.fi.controller;

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
	public String getCreateForm(Model model) {
		model.addAttribute("materia", materia);
		return "materias-create-form";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
		ModelAndView modelView = new ModelAndView("materias");
		CollectionMateria.agregarMateria(materia);
		modelView.addObject("materias", CollectionMateria.getMaterias());
		return modelView;
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
		CollectionMateria.modificarMateria(materia);
		return "redirect:/materias/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String deleteMateria(@PathVariable(value="codigo") int codigo) {
		CollectionMateria.eliminarMateria(codigo);
		return "redirect:/materias/listado";
	}
}
