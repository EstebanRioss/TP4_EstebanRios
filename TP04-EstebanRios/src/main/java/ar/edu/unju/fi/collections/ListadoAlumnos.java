package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;


public class ListadoAlumnos {
	public static List<Alumno> Alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos(){
		return Alumnos;
	}
	
	public static Alumno buscarAlumnoPorCodigo(String codigo){
		for(Alumno c : Alumnos) {
			if(c.getDni().equals(codigo)){
				return c;
			}
		}
		return null;
	}
	
	public static void agregarAlumno(Alumno c) {
		Alumnos.add(c);
	}
	
	public static void modificarAlumno(Alumno AlumnoModificada) {
		for(int i = 0 ; i < Alumnos.size() ; i++) {
			Alumno Alumno = Alumnos.get(i);
			if(Alumno.getDni().equals(AlumnoModificada.getDni())) {
				Alumnos.set(i, Alumno);
				break;
			}
		}
	}
	
	public static void eliminarAlumno(String codigo) {
		Alumnos.removeIf(Alumno -> Alumno.getDni().equals(codigo));
	}
	
}
