package excepciones;

public class PK_Turno_Repetida extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Turno_Repetida() {}

	@Override
	public String getMessage() {
		return "Clave PK Turno id repetida";
	}

}
