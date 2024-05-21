package excepciones;

public class PK_Especialidad_Repetida extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Especialidad_Repetida() {}

	@Override
	public String getMessage() {
		return "Clave PK Especialidad ID repetida";
	}
}
