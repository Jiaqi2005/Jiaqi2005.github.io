
public class Jugador {
	private int id;
	private String nombre; 
	private String descripcion;
	private String caracteritica;
	private int edad;
	
	
	public Jugador(int id, String nombre, String descripcion, String caracteritica, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caracteritica = caracteritica;
		this.edad = edad;
	}
	
	public Jugador(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCaracteritica() {
		return caracteritica;
	}


	public void setCaracteritica(String caracteritica) {
		this.caracteritica = caracteritica;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", caracteritica="
				+ caracteritica + ", edad=" + edad + "]";
	}
	
	
	
}
