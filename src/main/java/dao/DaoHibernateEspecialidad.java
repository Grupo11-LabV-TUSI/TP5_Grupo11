package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidad.Especialidad;
import excepciones.PK_Especialidad_NoExiste;
import excepciones.PK_Especialidad_Repetida;

public class DaoHibernateEspecialidad {
	// crear
	public static void crear(Especialidad especialidad) throws PK_Especialidad_Repetida {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		
		if(existe(especialidad.getId()) == true) {
			throw new PK_Especialidad_Repetida();
		} else {
			session.save(especialidad);			
		}
		
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}
	// leer
	public static Especialidad leer(int id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		Especialidad especialidad = (Especialidad)session.get(Especialidad.class,id);
		
		session.getTransaction().commit();		
		ch.cerrarSession();
		
		return especialidad;
	}
	// actualizar
	public static void actualizar(Especialidad especialidad) throws PK_Especialidad_NoExiste{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		if(existe(especialidad.getId()) == false) {
			throw new PK_Especialidad_NoExiste();
		} else {
			session.update(especialidad);
		}
		
		session.getTransaction().commit();		
		ch.cerrarSession();
	}
	// borrar
	public static void borrar(Especialidad especialidad) { //Este paciente tiene que venir cargado el ID de especialidad que se quiere eliminar
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
        session.delete(especialidad);
        
        session.getTransaction().commit();         
        ch.cerrarSession();
	}
	// listar
	public static List<Especialidad> leerTodos(){
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		Query query = session.getNamedQuery("findAllEspecialidades");
		List<Especialidad> lista = query.list();
		
		return lista;
	}
	// existe
	public static boolean existe(int id) {
		boolean existe = false;
		
		if(leer(id) != null) {
			existe = true;
		}
		
		return existe;
	}

}
