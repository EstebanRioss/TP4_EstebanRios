package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView = new ModelAndView("/materia/formMateria");
		modelView.addObject("nuevaMateria",nuevaMateria);
		
		return modelView;
	}
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute ("nuevaMateria") Materia Materia) {
		
		ListadoMateria.agregarMateria(Materia);
		ModelAndView modelView = new ModelAndView("/materia/listadoDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMateria.listarMaterias());
		
		return modelView;
	}
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView borrarMateria(@PathVariable(name="codigo") String codigo){
		ListadoMateria.eliminarMateria(codigo);
		ModelAndView modelView = new ModelAndView("/materia/listadoDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMateria.listarMaterias());
		
		return modelView;
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView mostrarFormularioModificarMateria(@PathVariable("codigo") String codigo){
		nuevaMateria = ListadoMateria.buscarMateriaPorCodigo(codigo);
		ModelAndView modelView = new ModelAndView("/materia/modificacionMateria");
		modelView.addObject("Materia", nuevaMateria);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionMateria")
	public ModelAndView guardarModificacionMateria(@ModelAttribute ("Materia") Materia Materia) {
		
		ListadoMateria.modificarMateria(Materia);
		ModelAndView modelView = new ModelAndView("/materia/listadoDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMateria.listarMaterias());
		
		return modelView;
	}
	
}
