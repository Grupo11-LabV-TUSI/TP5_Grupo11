package UTNFRGP.TP4_Borrador;

import java.time.LocalDate;
import java.util.List;

import dao.DaoHibernateMedico;
import entidad.Medico;

public class App2 {
	public static void main(String[] args) {
	DaoHibernateMedico aux = new DaoHibernateMedico();

	 
	
	
	// TK-2: generar método que use la consulta defina en la tk1, en el dao correspondiente a Medico 
	//y aplicarlo en main donde Los campos que se deben mostrar son todos. Realizarlo como se explica 
	//en el video HQL SELECT ALL.
	
	 aux.listarPorMatriculaDESC();
	
	// #TK-3  generar consulta HQL definirla como notación en clase para mostrar todos los médicos ordenados 
	//según su legajo de menor a mayor. Los campos que se deben mostrar son legajo, nombre y apellido. 
	//Realizarlo como se explica en el video HQL SELECT SOME COLUMNS.//
	
	 aux.ReadAll_AlgunasColumnas();

	
	
	// #TK-5: generar consulta HQL definirla como notación en clase para mostrar todos los turnos que
	//posee el médico con legajo 1234 en el día 01/01/2025.
	//Los campos que se deben mostrar son legajo, fecha de alta y estado. Realizarlo como se explica en el video HQL INNER JOIN
	
	 aux.traerPorFecha(1234, LocalDate.of(2025, 1, 1));
	
	
	
	
	
	
	}
	
}
