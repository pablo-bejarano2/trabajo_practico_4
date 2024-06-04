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

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("carreras")
public class CarreraController {
	@Autowired
	private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarreraPage(Model model) {
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		return "carreras";
	}
	
	@GetMapping("/nuevo")
	public String getCreateForm(Model model) {
		model.addAttribute("carrera", carrera);
		return "carreras-create-form";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		ModelAndView modelView = new ModelAndView("carreras");
		carrera.setEstado(true);
		CollectionCarrera.agregarCarrera(carrera);
		modelView.addObject("carreras", CollectionCarrera.getCarreras());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getEditForm(Model model, @PathVariable(value="codigo") int codigo) {
		Carrera carreraEncontrada = new Carrera();
		carreraEncontrada = CollectionCarrera.buscarCarrera(codigo);
		model.addAttribute("carrera", carreraEncontrada);
		return "carreras-edit-form";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		CollectionCarrera.modificarCarrera(carrera);
		return "redirect:/carreras/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String deleteCarrera(@PathVariable(value="codigo") int codigo) {
		CollectionCarrera.eliminarCarrera(codigo);
		return "redirect:/carreras/listado";
	}
}
