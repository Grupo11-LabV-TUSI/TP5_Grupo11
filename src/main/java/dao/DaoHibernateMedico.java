package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidad.Medico;
import entidad.Turno;
import excepciones.PK_Medico_NoExiste;
import excepciones.PK_Medico_Repetida;

public class DaoHibernateMedico {
	// crear
	public static void crear(Medico medico) throws PK_Medico_Repetida {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		
		if(existe(medico.getMatricula()) == true) {
			throw new PK_Medico_Repetida();
		} else {
			session.save(medico);			
		}
		
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}
	// leer
	public static Medico leer(int matricula) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		Medico medico= (Medico)session.get(Medico.class,matricula);
		//Query query = session.getNamedQuery("findMedicoByMatricula");
		//query.setParameter("matricula", matricula);
		//Medico medico = (Medico)query.uniqueResult();

		session.getTransaction().commit();
		ch.cerrarSession();
		
		return medico;
	}
	// actualizar
	public static void actualizar(Medico medico) throws PK_Medico_NoExiste{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		if(existe(medico.getMatricula()) == false) {
			throw new PK_Medico_NoExiste();
		} else {
			session.update(medico);
		}
		
		session.getTransaction().commit();		
		ch.cerrarSession();
	}
	// borrar
	public static void borrar(Medico medico) { //Este medico tiene que venir cargado la matricula de medico que se quiere eliminar
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
        session.delete(medico);
        
        session.getTransaction().commit();         
        ch.cerrarSession();
	}
	// listar
	public static List<Medico> leerTodos(){
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		Query query = session.getNamedQuery("findAllMedicos");
		List<Medico> lista = query.list();
		
		return lista;
	}
	// listar ordendos por matricula
	public static List<Medico> leerOrdenadosMatricula(){
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		Query query = session.getNamedQuery("findAllMedicosOrderByMatricula");
		List<Medico> lista = query.list();
		
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
	
	public static void traerPorFecha(int numLegajo, LocalDate fecha) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		Query query = session.createQuery("SELECT tur, med FROM Turno tur INNER JOIN tur.medico med WHERE med.matricula = :legajo AND tur.fecha = :fechaTur");
		query.setParameter("legajo", numLegajo);
		query.setParameter("fechaTur", fecha);
		List<Object[]> listaTurnos =(List<Object[]>)query.list();
	
		for(Object[] turnoFecha : listaTurnos)
		{
			Turno turno = (Turno)turnoFecha[0];
			Medico medico = (Medico)turnoFecha[1];
			
				System.out.println(" Matricula / Legajo del medico : " + medico.getMatricula() + " Fecha del turno: " + turno.getFecha().toString()+ " Estado del turno: " + turno.getEstado());
				
		}
	}
	
	
	

}
