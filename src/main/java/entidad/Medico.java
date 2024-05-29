package entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(
		name = "findMedicoByMatricula",
		query = "SELECT m FROM Medico m WHERE matricula=:matricula"
		),
	@NamedQuery(
			name = "findAllMedicos",
			query = "SELECT m FROM Medico m"
		),
	@NamedQuery(
			name = "findAllMedicosOrderByMatricula",
			query = "FROM Medico m ORDER BY m.matricula ASC"
		),
	@NamedQuery(
	        name = "findAllMedicoLegajos",
	        query = "SELECT m.matricula FROM Medico m"
	    )
})

@Entity
@Table(name="Medico")
public class Medico implements Serializable{
	// Implementa Serializable
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="matricula")
	private int matricula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fecha_nacimiento;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="especialidad_id")
	private Especialidad especialidad;
	
	// Constructor vacio para hibernate
	public Medico() {}

	public Medico(int matricula, String nombre, String apellido, String email, String telefono,
			LocalDate fecha_nacimiento, Usuario usuario, Especialidad especialidad) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.usuario = usuario;
		this.especialidad = especialidad;
	}

	// Getters y Setters
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	// toString
	@Override
	public String toString() {
		return "Medico [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", usuario=" + usuario
				+ ", especialidad=" + especialidad + "]";
	}
	
}
