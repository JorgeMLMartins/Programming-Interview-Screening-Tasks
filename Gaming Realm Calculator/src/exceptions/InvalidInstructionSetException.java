package exceptions;

public class InvalidInstructionSetException extends RuntimeException {

	private static final long serialVersionUID = -4515835857367828649L;

	public InvalidInstructionSetException(String message) {
		super(message);
	}
}
