package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(
		name = "findAllEspecialidades",
		query = "SELECT e FROM Especialidad e"
		)
})

@Entity
@Table(name="Especialidad")
public class Especialidad implements Serializable{
	// Serializable
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre",unique=true)
	private String nombre;

	// Constructor vacio requerido por Hibernate
	public Especialidad() {}
	
	public Especialidad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Especialidad(String nombre) {
		this.nombre = nombre;
	}

	// Getters y Setters
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

	// toString
	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", nombre=" + nombre + "]";
	}	

}
