package excepciones;

public class PK_Paciente_Repetida extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Paciente_Repetida() {}

	@Override
	public String getMessage() {
		return "Clave PK Paciente DNI repetida";
	}

}
