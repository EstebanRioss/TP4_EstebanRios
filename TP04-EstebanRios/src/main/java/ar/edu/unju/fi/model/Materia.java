package ar.edu.unju.fi.model;

public class Materia {
	private String codigo;
    private String nombre;
    private int curso;
    private int cantidadHoras;
    private String modalidad;
    private int docenteLegajo;
    private String carreraCodigo;

    public Materia(String codigo, String nombre, int curso, int cantidadHoras, String modalidad, int docenteLegajo, String carreraCodigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.curso = curso;
        this.cantidadHoras = cantidadHoras;
        this.modalidad = modalidad;
        this.docenteLegajo = docenteLegajo;
        this.carreraCodigo = carreraCodigo;
    }
    
    public Materia() {
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public int getDocenteLegajo() {
		return docenteLegajo;
	}

	public void setDocenteLegajo(int docenteLegajo) {
		this.docenteLegajo = docenteLegajo;
	}

	public String getCarreraCodigo() {
		return carreraCodigo;
	}

	public void setCarreraCodigo(String carreraCodigo) {
		this.carreraCodigo = carreraCodigo;
	}
}
