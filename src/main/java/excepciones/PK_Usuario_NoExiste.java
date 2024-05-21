package excepciones;

public class PK_Usuario_NoExiste extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Usuario_NoExiste() {}

	@Override
	public String getMessage() {
		return "Clave PK Usuario ID no existe";
	}

}
