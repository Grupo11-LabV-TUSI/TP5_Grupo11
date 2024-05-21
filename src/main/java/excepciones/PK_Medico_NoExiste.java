package excepciones;

public class PK_Medico_NoExiste extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Medico_NoExiste() {}

	@Override
	public String getMessage() {
		return "Clave PK Medico matricula no existe";
	}

}
