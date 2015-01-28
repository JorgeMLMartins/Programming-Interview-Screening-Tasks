package exceptions;

public class NoInstructionFoundException extends RuntimeException {

	private static final long serialVersionUID = 6260781291810700121L;

	public NoInstructionFoundException(String message) {
		super(message);
	}
}
