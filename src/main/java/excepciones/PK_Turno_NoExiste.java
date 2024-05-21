package excepciones;

public class PK_Turno_NoExiste extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Turno_NoExiste() {}

	@Override
	public String getMessage() {
		return "Clave PK Turno id no existe";
	}

}
