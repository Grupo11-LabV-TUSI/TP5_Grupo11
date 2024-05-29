package dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidad.Medico;
import entidad.Turno;
import excepciones.PK_Medico_NoExiste;
import excepciones.PK_Medico_Repetida;
import excepciones.PK_Turno_NoExiste;
import excepciones.PK_Turno_Repetida;

public class DaoHibernateTurno {
	// crear
	public static void crear(Turno turno) throws PK_Turno_Repetida {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		if (existe(turno.getId()) == true) {
			throw new PK_Turno_Repetida();
		} else {
			session.save(turno);
		}

		session.getTransaction().commit();

		ch.cerrarSession();
	}

	// leer
	public static Turno leer(Long id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, id);
		// Query query = session.getNamedQuery("findTurnoById");
		// query.setParameter("id", id);
		// Turno turno = (Turno)query.uniqueResult();

		session.getTransaction().commit();
		ch.cerrarSession();

		return turno;
	}

	// actualizar
	public static void actualizar(Turno turno) throws PK_Turno_NoExiste {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		if (existe(turno.getId()) == false) {
			throw new PK_Turno_NoExiste();
		} else {
			session.update(turno);
		}

		session.getTransaction().commit();
		ch.cerrarSession();
	}

	// borrar
	public static void borrar(Turno turno) { // Este turno tiene que venir cargado el id de turnio que se quiere
												// eliminar
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.delete(turno);

		session.getTransaction().commit();
		ch.cerrarSession();
	}

	// listar
	public static List<Turno> leerTodos() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		Query query = session.getNamedQuery("findAllTurnos");
		List<Turno> lista = query.list();

		return lista;
	}

	// existe
	public static boolean existe(Long id) {
		boolean existe = false;

		if (leer(id) != null) {
			existe = true;
		}

		return existe;
	}

	public static long contarTurnosPresenteEntreFechas(Date startDate, Date endDate) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();

		String hql = "SELECT COUNT(*) FROM Turno WHERE estado = 'Presente' AND fecha BETWEEN :startDate AND :endDate";
		Query query = session.createQuery(hql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		long count = (Long) query.uniqueResult();

		session.getTransaction().commit();
		ch.cerrarSession();
		return count;
	}

	public static long contarTurnosAusenteEntreFechas(Date startDate, Date endDate) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();

		String hql = "SELECT COUNT(*) FROM Turno WHERE estado = 'Ausente' AND fecha BETWEEN :startDate AND :endDate";
		Query query = session.createQuery(hql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		long count = (Long) query.uniqueResult();

		session.getTransaction().commit();
		ch.cerrarSession();
		return count;
	}

}
