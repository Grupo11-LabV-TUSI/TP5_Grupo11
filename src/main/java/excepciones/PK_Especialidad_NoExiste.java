package excepciones;

public class PK_Especialidad_NoExiste extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Especialidad_NoExiste() {}

	@Override
	public String getMessage() {
		return "Clave PK Especialidad ID no existe";
	}
}
