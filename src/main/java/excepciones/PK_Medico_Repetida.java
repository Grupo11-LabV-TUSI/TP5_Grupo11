package excepciones;

public class PK_Medico_Repetida extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Medico_Repetida() {}

	@Override
	public String getMessage() {
		return "Clave PK Medico matricula repetida";
	}
}
