package sonatypechallenge.validator;

/**
 * Exception to carry validation message from a failed verification of an
 * Integer input.
 */
public class IntegerValidationException extends Exception {

	private static final long serialVersionUID = 6542709493960917454L;

	/** The original input that was validated and caused the exception. */
	private String input;

	/**
	 * Basic constructor for the validation exception.
	 * 
	 * @param number  the original input that was validated and caused the exception
	 * @param message the error message
	 */
	public IntegerValidationException(String number, String message) {
		super(message);
		this.input = number;
	}

	public IntegerValidationException(String number, String message, NumberFormatException e) {
		super(message, e);
		this.input = number;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + " Original input: " + input;
	}
}
