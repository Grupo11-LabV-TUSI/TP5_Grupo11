package excepciones;

public class PK_Usuario_Repetida extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Usuario_Repetida() {}

	@Override
	public String getMessage() {
		return "Clave PK Usuario ID repetida";
	}

}
