package entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(
		name = "findAllPacientes",
		query = "SELECT p FROM Paciente p"
		)
})

@Entity
@Table(name="Paciente")
public class Paciente implements Serializable {
	// Implementar serializable
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dni")
	private int dni;
	
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
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="provincia")
	private String provincia;
	
	// Constructor vacio requerido por Hibernate
	public Paciente() {}

	public Paciente(int dni, String nombre, String apellido, String email, String telefono, LocalDate fecha_nacimiento,
			String direccion, String localidad, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	// Getters y Setters
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	// toString
	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + "]";
	}
	
}
