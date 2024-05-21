package dao;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidad.Paciente;
import excepciones.PK_Paciente_NoExiste;
import excepciones.PK_Paciente_Repetida;

public class DaoHibernatePaciente {
	public static void crear(Paciente paciente) throws PK_Paciente_Repetida {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		
		if(existe(paciente.getDni()) == true) {
			throw new PK_Paciente_Repetida();
		} else {
			session.save(paciente);			
		}
		
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}
	
	public static Paciente leer(int dni) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		Paciente paciente = (Paciente)session.get(Paciente.class,dni);
		
		session.getTransaction().commit();		
		ch.cerrarSession();
		
		return paciente;
	}
	
	public static void actualizar(Paciente paciente) throws PK_Paciente_NoExiste {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		if(existe(paciente.getDni()) == false) {
			throw new PK_Paciente_NoExiste();
		} else {
			session.update(paciente);			
		}
		
		session.getTransaction().commit();		
		ch.cerrarSession();
	}
	
	public static void borrar(Paciente paciente) { //Este paciente tiene que venir cargado el DNI del usuario que se quiere eliminar
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
        session.delete(paciente);
        
        session.getTransaction().commit();         
        ch.cerrarSession();
	}
	
	public static List<Paciente> leerTodos(){
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		//List<Paciente> lista = new ArrayList<Paciente>();
		
		session.beginTransaction();
		
		//Query queryPaciente = session.createQuery("Select p FROM Paciente p");
		//lista = queryPaciente.list();
		
		Query query = session.getNamedQuery("findAllPacientes");
		List<Paciente> lista = query.list();
		
		return lista;
	}
	
	public static boolean existe(int dni) {
		boolean existe = false;
		
		if(leer(dni) != null) {
			existe = true;
		}
		
		return existe;
	}
	
}
