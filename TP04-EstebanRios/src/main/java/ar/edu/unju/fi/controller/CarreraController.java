package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	
	@GetMapping("formularioCarrera")
	public ModelAndView getFormCarrera() {
		ModelAndView modelView = new ModelAndView("/carrera/formCarrera");
		modelView.addObject("nuevaCarrera",new Carrera());
		
		return modelView;
	}
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute ("nuevaCarrera") Carrera carrera) {
		
		ListadoCarreras.agregarCarrera(carrera);
		ModelAndView modelView = new ModelAndView("/carrera/listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView borrarCarrera(@PathVariable(name="codigo") String codigo){
		ListadoCarreras.eliminarCarrera(codigo);
		ModelAndView modelView = new ModelAndView("/carrera/listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView mostrarFormularioModificarCarrera(@PathVariable("codigo") String codigo){
		nuevaCarrera = ListadoCarreras.buscarCarreraPorCodigo(codigo);
		ModelAndView modelView = new ModelAndView("/carrera/modificacionCarrera");
		modelView.addObject("carrera", nuevaCarrera);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionCarrera")
	public ModelAndView guardarModificacionCarrera(@ModelAttribute ("carrera") Carrera carrera) {
		
		ListadoCarreras.modificarCarrera(carrera);
		ModelAndView modelView = new ModelAndView("/carrera/listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	
	@GetMapping("/darDeBajaCarrera/{codigo}")
	public ModelAndView darDeBajaCarrera(@PathVariable(name="codigo") String codigo){
		ListadoCarreras.darDeBajaCarrera(codigo);
		ModelAndView modelView = new ModelAndView("/carrera/listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	@GetMapping("/darDeAltaCarrera/{codigo}")
	public ModelAndView darDeAltaCarrera(@PathVariable(name="codigo") String codigo){
		ListadoCarreras.darDeAltaCarrera(codigo);
		ModelAndView modelView = new ModelAndView("/carrera/listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	
	
}
