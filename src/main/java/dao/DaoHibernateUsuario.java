package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidad.Usuario;
import excepciones.PK_Usuario_NoExiste;
import excepciones.PK_Usuario_Repetida;

public class DaoHibernateUsuario {
	// crear
	public static void crear(Usuario usuario) throws PK_Usuario_Repetida {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		
		if(existe(usuario.getId()) == true) {
			throw new PK_Usuario_Repetida();
		} else {
			session.save(usuario);			
		}
		
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}
	// leer
	public static Usuario leer(Long id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		Usuario usuario= (Usuario)session.get(Usuario.class,id);
		
		session.getTransaction().commit();		
		ch.cerrarSession();
		
		return usuario;
	}
	// actualizar
	public static void actualizar(Usuario usuario) throws PK_Usuario_NoExiste{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		if(existe(usuario.getId()) == false) {
			throw new PK_Usuario_NoExiste();
		} else {
			session.update(usuario);
		}
		
		session.getTransaction().commit();		
		ch.cerrarSession();
	}
	// borrar
	public static void borrar(Usuario usuario) { //Este usuario tiene que venir cargado el ID de especialidad que se quiere eliminar
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
        session.delete(usuario);
        
        session.getTransaction().commit();         
        ch.cerrarSession();
	}
	// listar
	public static List<Usuario> leerTodos(){
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		Query query = session.getNamedQuery("findAllUsuarios");
		List<Usuario> lista = query.list();
		
		return lista;
	}
	// existe
	public static boolean existe(Long id) {
		boolean existe = false;
		
		if(leer(id) != null) {
			existe = true;
		}
		
		return existe;
	}

}
