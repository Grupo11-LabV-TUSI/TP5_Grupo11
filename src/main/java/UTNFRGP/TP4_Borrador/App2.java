package UTNFRGP.TP4_Borrador;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import dao.ConfigHibernate;
import dao.DaoHibernateMedico;
import dao.DaoHibernateTurno;
import entidad.Medico;

public class App2 {
	public static void main(String[] args) {
		DaoHibernateMedico aux = new DaoHibernateMedico();

//		// TK-2: generar método que use la consulta defina en la tk1, en el dao
//		// correspondiente a Medico
//		// y aplicarlo en main donde Los campos que se deben mostrar son todos.
//		// Realizarlo como se explica
//		// en el video HQL SELECT ALL.
//
//		aux.listarPorMatriculaDESC();
//
//		// #TK-3 generar consulta HQL definirla como notación en clase para mostrar
//		// todos los médicos ordenados
//		// según su legajo de menor a mayor. Los campos que se deben mostrar son legajo,
//		// nombre y apellido.
//		// Realizarlo como se explica en el video HQL SELECT SOME COLUMNS.//
//
//		aux.ReadAll_AlgunasColumnas();
//
//		// #TK-5: generar consulta HQL definirla como notación en clase para mostrar
//		// todos los turnos que
//		// posee el médico con legajo 1234 en el día 01/01/2025.
//		// Los campos que se deben mostrar son legajo, fecha de alta y estado.
//		// Realizarlo como se explica en el video HQL INNER JOIN
//
//		aux.traerPorFecha(1234, LocalDate.of(2025, 1, 1));
//		
		// 5) Mostrar el médico con mayor número de legajo
		// El campo que se debe mostrar es número de legajo. Realizarlo como se explica
		// en el
		// video HQL UNIQUE RESULT

		aux.obtenerMedicoConMayorLegajo();
		// Definir las fechas de inicio y fin
		LocalDate fechaInicio = LocalDate.of(2024, 1, 1);
		LocalDate fechaFin = LocalDate.of(2024, 3, 1);
		Date startDate = Date.valueOf(fechaInicio);
		Date endDate = Date.valueOf(fechaFin);

		// Contar turnos presentes y ausentes entre las fechas
		long turnosPresente = DaoHibernateTurno.contarTurnosPresenteEntreFechas(startDate, endDate);
		long turnosAusente = DaoHibernateTurno.contarTurnosAusenteEntreFechas(startDate, endDate);
		long totalTurnos = turnosPresente + turnosAusente;

		// Calcular y mostrar los porcentajes
		if (totalTurnos > 0) {
			double porcentajePresente = (turnosPresente * 100.0) / totalTurnos;
			double porcentajeAusente = (turnosAusente * 100.0) / totalTurnos;
			System.out.println("Porcentaje de turnos presentes: " + porcentajePresente + "%");
			System.out.println("Porcentaje de turnos ausentes: " + porcentajeAusente + "%");
		} else {
			System.out.println("No hay turnos en el rango de fechas especificado.");
		}
	}

}
