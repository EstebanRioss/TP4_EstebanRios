package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente = new Docente();
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView = new ModelAndView("docente/formDocente");
		modelView.addObject("nuevoDocente",nuevoDocente);
		
		return modelView;
	}
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute ("nuevoDocente") Docente Docente) {
		
		ListadoDocentes.agregarDocente(Docente);
		ModelAndView modelView = new ModelAndView("docente/listadoDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView borrarDocente(@PathVariable(name="legajo") String legajo){
		ListadoDocentes.eliminarDocente(legajo);
		ModelAndView modelView = new ModelAndView("docente/listadoDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView mostrarFormularioModificarDocente(@PathVariable(name="legajo") String legajo){
		nuevoDocente = ListadoDocentes.buscarDocentePorCodigo(legajo);
		ModelAndView modelView = new ModelAndView("docente/modificacionDocente");
		modelView.addObject("Docente", nuevoDocente);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionDocente")
	public ModelAndView guardarModificacionDocente(@ModelAttribute ("Docente") Docente Docente) {
		
		ListadoDocentes.modificarDocente(Docente);
		ModelAndView modelView = new ModelAndView("docente/listadoDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		
		return modelView;
	}
}
