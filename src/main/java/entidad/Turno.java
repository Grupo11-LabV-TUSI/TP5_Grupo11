package entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import enums.EstadoTurno;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(
		name = "findTurnoById",
		query = "SELECT t FROM Turno t WHERE id=:id"
		),
	@NamedQuery(
			name = "findAllTurnos",
			query = "SELECT t FROM Turno t"
		)
})

@Entity
@Table(name="Turno")
public class Turno  implements Serializable{
	// Implemnetar serializable
	private static final long serialVersionUID = 1L;
	// atributos
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="medico_id")
	private Medico medico;
	
	@ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	
	
	@Column(name="fecha")
	private LocalDate fecha;
	
	
	
	
	@Column(name="hora")
	private LocalTime hora;
	
	@Column(name="observacion")
	private String observacion;
	
	@Column(name="estado")
	private EstadoTurno estado;
	
	// constructor vacio para hibernate
	public Turno() {}

	public Turno(Medico medico, Paciente paciente, LocalDate fecha, LocalTime hora, String observacion,
			EstadoTurno estado) {
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observacion = observacion;
		this.estado = estado;
	}

	public Turno(Long id, Medico medico, Paciente paciente, LocalDate fecha, LocalTime hora, String observacion,
			EstadoTurno estado) {
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observacion = observacion;
		this.estado = estado;
	}
	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public EstadoTurno getEstado() {
		return estado;
	}

	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}
	// toString
	@Override
	public String toString() {
		return "Turno [id=" + id + ", medico=" + medico + ", paciente=" + paciente + ", fecha=" + fecha + ", hora="
				+ hora + ", observacion=" + observacion + ", estado=" + estado + "]";
	}

}
