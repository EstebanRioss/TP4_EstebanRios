package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
public static List<Docente> Docentes = new ArrayList<Docente>();
	
	public static List<Docente> listarDocentes(){
		return Docentes;
	}
	
	public static Docente buscarDocentePorCodigo(String codigo) {
		for(Docente c : Docentes) {
			if(c.getLegajo().equals(codigo)){
				return c;
			}
		}
		return null;
	}
	
	public static void agregarDocente(Docente c) {
		Docentes.add(c);
	}
	
	public static void modificarDocente(Docente DocenteModificada) {
		for(int i = 0 ; i < Docentes.size() ; i++) {
			Docente Docente = Docentes.get(i);
			if(Docente.getLegajo().equals(DocenteModificada.getLegajo())) {
				Docentes.set(i, DocenteModificada);
				break;
			}
		}
	}
	
	public static void eliminarDocente(String codigo) {
		Iterator<Docente> iterator = Docentes.iterator();
	    while (iterator.hasNext()) {
	        Docente c = iterator.next();
	        if (c.getLegajo().equals(codigo)) {
	            iterator.remove();
	            break;
	        }
	    }
	}
}
