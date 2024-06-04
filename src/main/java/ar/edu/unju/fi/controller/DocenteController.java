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

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("docentes")
public class DocenteController {
	@Autowired
	private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		model.addAttribute("docentes", CollectionDocente.getDocentes());
		return "docentes";
	}
	
	@GetMapping("/nuevo")
	public String getCreateForm(Model model) {
		model.addAttribute("docente", docente);
		return "docentes-create-form";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
		ModelAndView modelView = new ModelAndView("docentes");
		CollectionDocente.agregarDocente(docente);
		modelView.addObject("docentes", CollectionDocente.getDocentes());
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getEditForm(Model model, @PathVariable(value="legajo") int legajo) {
		Docente docenteEncontrado = new Docente();
		docenteEncontrado = CollectionDocente.buscarDocente(legajo);
		model.addAttribute("docente", docenteEncontrado);
		return "docentes-edit-form";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") Docente docente) {
		CollectionDocente.modificarDocente(docente);
		return "redirect:/docentes/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String deleteDocente(@PathVariable(value="legajo") int legajo) {
		CollectionDocente.eliminarDocente(legajo);
		return "redirect:/docentes/listado";
	}
}
