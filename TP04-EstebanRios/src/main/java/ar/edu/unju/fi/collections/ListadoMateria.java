package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;

public class ListadoMateria {
public static List<Materia> Materias = new ArrayList<Materia>();
	
	public static List<Materia> listarMaterias(){
		return Materias;
	}
	
	public static Materia buscarMateriaPorCodigo(String codigo) {
		for(Materia c : Materias) {
			if(c.getCodigo().equals(codigo)){
				return c;
			}
		}
		return null;
	}
	
	public static void agregarMateria(Materia c) {
		Materias.add(c);
	}
	
	public static void modificarMateria(Materia MateriaModificada) {
		for(int i = 0 ; i < Materias.size() ; i++) {
			Materia Materia = Materias.get(i);
			if(Materia.getCodigo().equals(MateriaModificada.getCodigo())) {
				Materias.set(i, Materia);
				break;
			}
		}
	}
	
	public static void eliminarMateria(String codigo) {
		Materias.removeIf(Materia -> Materia.getCodigo().equals(codigo));
	}
}
