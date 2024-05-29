package UTNFRGP.TP4_Borrador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.DaoHibernateEspecialidad;
import dao.DaoHibernateMedico;
import dao.DaoHibernatePaciente;
import dao.DaoHibernateTurno;
import dao.DaoHibernateUsuario;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Turno;
import entidad.Usuario;
import enums.EstadoTurno;
import excepciones.PK_Especialidad_NoExiste;
import excepciones.PK_Especialidad_Repetida;
import excepciones.PK_Medico_NoExiste;
import excepciones.PK_Medico_Repetida;
import excepciones.PK_Paciente_NoExiste;
import excepciones.PK_Paciente_Repetida;
import excepciones.PK_Turno_NoExiste;
import excepciones.PK_Turno_Repetida;
import excepciones.PK_Usuario_NoExiste;
import excepciones.PK_Usuario_Repetida;

public class App {
	public static void main(String[] args) {
	
		
	
		// CARGAR //
		// Turno turno = new Turno(medico, paciente, LocalDate.of(2028, 5, 14),
		// LocalTime.of(18, 0), "Bien", EstadoTurno.PENDIENTE);
		// Paciente //
		List<Paciente> listaPaciente = new ArrayList<Paciente>();
		listaPaciente.add(new Paciente(399547, "Aldo", "Ramirez", "aldoRamirez@gmail.com", "16546545",
				LocalDate.of(2000, 1, 2), "Calle 1", "Benavidez", "BSAS"));
		listaPaciente.add(new Paciente(123456, "María", "González", "mariaGonzalez@gmail.com", "12345678",
				LocalDate.of(1995, 8, 15), "Avenida 2", "La Plata", "BSAS"));
		listaPaciente.add(new Paciente(789012, "Juan", "López", "juanLopez@gmail.com", "98765432",
				LocalDate.of(1987, 12, 31), "Calle 3", "Rosario", "Santa Fe"));
		listaPaciente.add(new Paciente(246810, "Lucía", "Martínez", "luciaMartinez@gmail.com", "98765432",
				LocalDate.of(1998, 5, 20), "Calle 4", "Córdoba", "Córdoba"));
		listaPaciente.add(new Paciente(135790, "Carlos", "Gutiérrez", "carlosGutierrez@gmail.com", "54321678",
				LocalDate.of(1980, 9, 10), "Avenida 5", "Mendoza", "Mendoza"));
		listaPaciente.add(new Paciente(112233, "Laura", "Díaz", "lauraDiaz@gmail.com", "12348765",
				LocalDate.of(1975, 3, 25), "Calle 6", "Tucumán", "Tucumán"));
		listaPaciente.add(new Paciente(987654, "Martín", "López", "martinLopez@gmail.com", "87654321",
				LocalDate.of(1993, 7, 12), "Avenida 7", "Salta", "Salta"));
		listaPaciente.add(new Paciente(564738, "Julieta", "Fernández", "julietaFernandez@gmail.com", "65432187",
				LocalDate.of(1988, 11, 5), "Calle 8", "Santa Fe", "Santa Fe"));
		listaPaciente.add(new Paciente(9645654, "Pedro", "Rodríguez", "pedroRodriguez@gmail.com", "36985214",
				LocalDate.of(2002, 2, 28), "Avenida 9", "Neuquén", "Neuquén"));
		
		// cargar
		for (Paciente paciente : listaPaciente) {
			try {
				// crear
				DaoHibernatePaciente.crear(paciente);
				// leer
				System.out.println(DaoHibernatePaciente.leer(paciente.getDni()));
				// actualizar
				paciente.setFecha_nacimiento(paciente.getFecha_nacimiento().plusDays(1));
			DaoHibernatePaciente.actualizar(paciente);
				// leer
				System.out.println(DaoHibernatePaciente.leer(paciente.getDni()));
			} catch (PK_Paciente_Repetida e) {
				e.printStackTrace();
			} catch (PK_Paciente_NoExiste e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// leer
				System.out.println(DaoHibernatePaciente.leer(paciente.getDni()));
			}
		}
		
		// listar
		System.out.println(DaoHibernatePaciente.leerTodos());

		// Especialidad //
		List<Especialidad> listaEspecialidad = new ArrayList<Especialidad>();
		listaEspecialidad.add(new Especialidad("Cardiología"));
		listaEspecialidad.add(new Especialidad("Psiquiatría"));
		listaEspecialidad.add(new Especialidad("Pediatría"));
		listaEspecialidad.add(new Especialidad("Dermatología"));
		listaEspecialidad.add(new Especialidad("Ginecología"));
		listaEspecialidad.add(new Especialidad("Oftalmología"));
		listaEspecialidad.add(new Especialidad("Neurología"));
		listaEspecialidad.add(new Especialidad("Ortopedia"));
		listaEspecialidad.add(new Especialidad("Urología"));
		listaEspecialidad.add(new Especialidad("Endocrinología"));
		listaEspecialidad.add(new Especialidad("Odontologia"));
		listaEspecialidad.add(new Especialidad("Cirugia"));
		// cargar
		for (int i = 0; i < listaEspecialidad.size(); i++) {
			try {
				// crear
				listaEspecialidad.get(i).setId((long) (i + 1));
				DaoHibernateEspecialidad.crear(listaEspecialidad.get(i));
				// leer
				System.out.println(DaoHibernateEspecialidad.leer(listaEspecialidad.get(i).getId()));
				// actualizar
				listaEspecialidad.get(i).setNombre(listaEspecialidad.get(i).getNombre() + " " + (i + 1));
				DaoHibernateEspecialidad.actualizar(listaEspecialidad.get(i));
				// leer
				System.out.println(DaoHibernateEspecialidad.leer(listaEspecialidad.get(i).getId()));
			} catch (PK_Especialidad_Repetida e) {
				e.printStackTrace();
			} catch (PK_Especialidad_NoExiste e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// leer
				System.out.println(DaoHibernateEspecialidad.leer(listaEspecialidad.get(i).getId()));
			}
		}
		// listar
		System.out.println(DaoHibernateEspecialidad.leerTodos());

		// Usuario // // PROBANDO BIDIRECCIONES USUARIO MEDICO//
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		listaUsuario.add(new Usuario("JGarcia", "JG123"));
		listaUsuario.add(new Usuario("JPepe", "JP456"));
		listaUsuario.add(new Usuario("JPerez", "JP789"));
		listaUsuario.add(new Usuario("JRamirez", "JR101"));
		listaUsuario.add(new Usuario("JLopez", "JL112"));
		listaUsuario.add(new Usuario("JMartinez", "JM131"));
		listaUsuario.add(new Usuario("JGomez", "JG141"));
		listaUsuario.add(new Usuario("JSanchez", "JS151"));
		listaUsuario.add(new Usuario("JFernandez", "JF161"));
		listaUsuario.add(new Usuario("JRodriguez", "JR171"));
		listaUsuario.add(new Usuario("ERanco", "ER976"));
		listaUsuario.add(new Usuario("JShakira", "JS654"));
		// cargar
		for (int i = 0; i < listaUsuario.size(); i++) {
			try {
				// crear
				listaUsuario.get(i).setId((long) (i + 1));
				DaoHibernateUsuario.crear(listaUsuario.get(i));
				// leer
				System.out.println(DaoHibernateUsuario.leer(listaUsuario.get(i).getId()));
				// actualizar
				listaUsuario.get(i).setNombre(listaUsuario.get(i).getNombre() + " " + (i + 1));
				DaoHibernateUsuario.actualizar(listaUsuario.get(i));
				// leer
				System.out.println(DaoHibernateUsuario.leer(listaUsuario.get(i).getId()));
			} catch (PK_Usuario_Repetida e) {
				e.printStackTrace();
			} catch (PK_Usuario_NoExiste e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// leer
				System.out.println(DaoHibernateUsuario.leer(listaUsuario.get(i).getId()));
			}
		}
		// listar
		System.out.println(DaoHibernateUsuario.leerTodos());

		// Medico //
		List<Medico> listaMedico = new ArrayList<Medico>();
		listaMedico.add(new Medico(1234, "Jose", "Garcia", "emailM1@email.com", "telefono M1",
				LocalDate.of(1961, 1, 1), listaUsuario.get(0), listaEspecialidad.get(0)));
		listaMedico.add(new Medico(200, "Juan", "Pepe", "emailM2@email.com", "telefono M2",
				LocalDate.of(1962, 2, 2), listaUsuario.get(1), listaEspecialidad.get(1)));
		listaMedico.add(new Medico(300, "Juan", "Perez", "emailM3@email.com", "telefono M3",
				LocalDate.of(1963, 3, 3), listaUsuario.get(2), listaEspecialidad.get(2)));
		listaMedico.add(new Medico(400, "Juan", "Ramirez", "emailM4@email.com", "telefono M4",
				LocalDate.of(1964, 4, 4), listaUsuario.get(3), listaEspecialidad.get(3)));
		listaMedico.add(new Medico(500, "Juan", "Lopez", "emailM5@email.com", "telefono M5",
				LocalDate.of(1965, 5, 5), listaUsuario.get(4), listaEspecialidad.get(4)));
		listaMedico.add(new Medico(600, "Juan", "Martinez", "emailM6@email.com", "telefono M6",
				LocalDate.of(1966, 6, 6), listaUsuario.get(5), listaEspecialidad.get(5)));
		listaMedico.add(new Medico(700, "Juan", "Gomez", "emailM7@email.com", "telefono M7",
				LocalDate.of(1967, 7, 7), listaUsuario.get(6), listaEspecialidad.get(6)));
		listaMedico.add(new Medico(800, "Juan", "Sanchez", "emailM8@email.com", "telefono M8",
				LocalDate.of(1968, 8, 8), listaUsuario.get(7), listaEspecialidad.get(7)));
		listaMedico.add(new Medico(900, "Juan", "Fernandez", "emailM9@email.com", "telefono M9",
				LocalDate.of(1969, 9, 9), listaUsuario.get(8), listaEspecialidad.get(8)));
		listaMedico.add(new Medico(110, "Juan", "Rodriguez", "emailM10@email.com", "telefono M10",
				LocalDate.of(1970, 10, 10), listaUsuario.get(9), listaEspecialidad.get(9)));
		listaMedico.add(new Medico(111, "Elena", "Ranco", "emailM11@email.com", "telefono M11",
				LocalDate.of(1961, 11, 11), listaUsuario.get(10), listaEspecialidad.get(10)));
		listaMedico.add(new Medico(112, "Juana", "Shakira", "emailM12@email.com", "telefono M12",
				LocalDate.of(1962, 2, 2), listaUsuario.get(11), listaEspecialidad.get(11)));
		// cargar
		for (Medico medico : listaMedico) {
			try {
				// crear
				DaoHibernateMedico.crear(medico);
				// leer
				System.out.println(DaoHibernateMedico.leer(medico.getMatricula()));
				// actualiar
				medico.setFecha_nacimiento(medico.getFecha_nacimiento().minusDays(1));
				DaoHibernateMedico.actualizar(medico);
				// leer
				System.out.println(DaoHibernateMedico.leer(medico.getMatricula()));
			} catch (PK_Medico_Repetida e) {
				e.printStackTrace();
			} catch (PK_Medico_NoExiste e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// leer
				System.out.println(DaoHibernateMedico.leer(medico.getMatricula()));
			}
		}
		// listo
		System.out.println(DaoHibernateMedico.leerTodos());

		// Turno //
		List<Turno> listaTurno = new ArrayList<Turno>();
		listaTurno.add(new Turno(listaMedico.get(0), listaPaciente.get(0), LocalDate.of(2025, 1, 1),
				LocalTime.of(15, 30), "Reuma", EstadoTurno.AUSENTE));
		listaTurno.add(new Turno(listaMedico.get(0), listaPaciente.get(1), LocalDate.of(2026, 1, 1),
				LocalTime.of(20, 30), "Tiene piojos", EstadoTurno.PENDIENTE));
		listaTurno.add(new Turno(listaMedico.get(0), listaPaciente.get(3), LocalDate.of(2025, 1, 1),
				LocalTime.of(10, 45), "Fiebre", EstadoTurno.PENDIENTE));
		listaTurno.add(new Turno(listaMedico.get(3), listaPaciente.get(3), LocalDate.of(2023, 7, 15),
				LocalTime.of(8, 0), "Dolor de cabeza", EstadoTurno.PRESENTE));
		listaTurno.add(new Turno(listaMedico.get(4), listaPaciente.get(4), LocalDate.of(2023, 9, 30),
				LocalTime.of(14, 30), "Gripe", EstadoTurno.PENDIENTE));
		listaTurno.add(new Turno(listaMedico.get(5), listaPaciente.get(5), LocalDate.of(2024, 2, 10),
				LocalTime.of(11, 0), "Dolor de garganta", EstadoTurno.PRESENTE));
		listaTurno.add(new Turno(listaMedico.get(6), listaPaciente.get(6), LocalDate.of(2024, 4, 5),
				LocalTime.of(9, 45), "Resfriado", EstadoTurno.AUSENTE));
		listaTurno.add(new Turno(listaMedico.get(7), listaPaciente.get(7), LocalDate.of(2024, 8, 20),
				LocalTime.of(17, 20), "Alergia", EstadoTurno.PENDIENTE));
		listaTurno.add(new Turno(listaMedico.get(8), listaPaciente.get(2), LocalDate.of(2024, 10, 12),
				LocalTime.of(13, 0), "Control de rutina", EstadoTurno.PRESENTE));
		listaTurno.add(new Turno(listaMedico.get(9), listaPaciente.get(7), LocalDate.of(2024, 11, 28),
				LocalTime.of(16, 40), "Presión alta", EstadoTurno.AUSENTE));
		listaTurno.add(new Turno(listaMedico.get(10), listaPaciente.get(7), LocalDate.of(2025, 1, 5),
				LocalTime.of(18, 30), "Reuma", EstadoTurno.PENDIENTE));
		// cargar
		for (int i = 0; i < listaTurno.size(); i++) {
			try {
				// crear
				listaTurno.get(i).setId((long) (i+1));
				DaoHibernateTurno.crear(listaTurno.get(i));
				// leer
				System.out.println(DaoHibernateTurno.leer(listaTurno.get(i).getId()));
				// actualizar
			//	listaTurno.get(i).setFecha(listaTurno.get(i).getFecha().plusYears(1));
			//	DaoHibernateTurno.actualizar(listaTurno.get(i));
				// leer
				System.out.println(DaoHibernateTurno.leer(listaTurno.get(i).getId()));
			} catch (PK_Turno_Repetida e) {
				e.printStackTrace();
			} catch (PK_Turno_NoExiste e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// leer
				System.out.println(DaoHibernateTurno.leer(listaTurno.get(i).getId()));
			}
		}
		// listar
		System.out.println(DaoHibernateTurno.leerTodos());

		// BORRAR //
		// Turno //
		// borrar
		//DaoHibernateTurno.borrar(listaTurno.get(listaTurno.size()-1));
		// leer
		//System.out.println(DaoHibernateTurno.leer(listaTurno.get(listaTurno.size()-1).getId()));

		// Medico //
		// borrar
		//DaoHibernateMedico.borrar(listaMedico.get(listaMedico.size()-1));
		// leer
		//System.out.println(DaoHibernateMedico.leer(listaMedico.get(listaMedico.size()-1).getMatricula()));

		// Usuario //
		// borrar
		//DaoHibernateUsuario.borrar(listaUsuario.get(listaUsuario.size()-1));
		// leer
		//System.out.println(DaoHibernateUsuario.leer(listaUsuario.get(listaUsuario.size()-1).getId()));

		// Especialidad //
		// borrar
		//DaoHibernateEspecialidad.borrar(listaEspecialidad.get(listaEspecialidad.size()-1));
		// leer
		//System.out.println(DaoHibernateEspecialidad.leer(listaEspecialidad.get(listaEspecialidad.size()-1).getId()));

		// Paciente //
		// borrar
		//System.out.println(DaoHibernatePaciente.leer(listaPaciente.get(listaPaciente.size()-1).getDni()));
		//DaoHibernatePaciente.borrar(listaPaciente.get(listaPaciente.size()-1));
		// leer
		//System.out.println(DaoHibernatePaciente.leer(listaPaciente.get(listaPaciente.size()-1).getDni()));
		//DaoHibernateMedico aux = new DaoHibernateMedico();
		 
		 
		
		
		
		 
	}
}
