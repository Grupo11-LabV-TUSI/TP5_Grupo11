package UTNFRGP.TP4_Borrador;

import java.util.List;

import dao.DaoHibernateMedico;
import entidad.Medico;

public class App2 {
	public static void main(String[] args) {
	DaoHibernateMedico aux = new DaoHibernateMedico();

	 
	
	// #TK-3  generar consulta HQL definirla como notación en clase para mostrar todos los médicos ordenados 
	//según su legajo de menor a mayor. Los campos que se deben mostrar son legajo, nombre y apellido. 
	//Realizarlo como se explica en el video HQL SELECT SOME COLUMNS.//
	aux.ReadAll_AlgunasColumnas();
	}
	
}
