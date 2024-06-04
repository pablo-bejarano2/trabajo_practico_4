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

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("alumnos")
public class AlumnoController {
	@Autowired
	private Alumno alumno;
	
	@GetMapping("/listado")
	public String getAlumnoPage(Model model) {
		model.addAttribute("alumnos", CollectionAlumno.getAlumnos());
		return "alumnos";
	}
	
	@GetMapping("/nuevo")
	public String getCreateForm(Model model) {
		model.addAttribute("alumno", alumno);
		return "alumnos-create-form";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		ModelAndView modelView = new ModelAndView("alumnos");
		CollectionAlumno.agregarAlumno(alumno);
		modelView.addObject("carreras", CollectionAlumno.getAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificar/{libreta}")
	public String getEditForm(Model model, @PathVariable(value="libreta") int libreta) {
		Alumno alumnoEncontrado = new Alumno();
		alumnoEncontrado = CollectionAlumno.buscarAlumno(libreta);
		model.addAttribute("alumno", alumnoEncontrado);
		return "alumnos-edit-form";
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		CollectionAlumno.modificarAlumno(alumno);
		return "redirect:/alumnos/listado";
	}
	
	@GetMapping("/eliminar/{libreta}")
	public String deleteAlumno(@PathVariable(value="libreta") int libreta) {
		CollectionAlumno.eliminarAlumno(libreta);
		return "redirect:/alumnos/listado";
	}
}


