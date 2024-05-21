package excepciones;

public class PK_Paciente_NoExiste extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Paciente_NoExiste() {}

	@Override
	public String getMessage() {
		return "Clave PK Paciente NI no existe";
	}

}
