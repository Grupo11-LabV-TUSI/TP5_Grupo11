package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(
		name = "findAllUsuarios",
		query = "SELECT u FROM Usuario u"
		)
})

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	// Implements Serializable
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",unique=true)
	private String nombre;
	
	@Column(name="clave")
	private String clave;
	
	@OneToOne(mappedBy="usuario", fetch = FetchType.LAZY)
	private Medico medico;

	// Constructor vacio para Hibernate
	public Usuario() {}

	public Usuario(Long id, String nombre, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
	}
	
	public Usuario(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	// Bidireccional
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public String toString() {
		String mensaje = "Usuario [id=" + id + ", nombre=" + nombre + ", clave=" + clave + ", medico=";
		if(medico != null) {
			mensaje += medico.getMatricula() + " " + medico.getNombre() + " " + medico.getApellido() + " " + medico.getEmail() + " " + medico.getTelefono() + " " + medico.getFecha_nacimiento() + " " + medico.getEspecialidad();
		}
		return mensaje;
	}

}
