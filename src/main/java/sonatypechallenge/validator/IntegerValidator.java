package sonatypechallenge.validator;

/**
 * Class to determine if a passed input is a valid integer.
 *
 */
public class IntegerValidator {

	/**
	 * Determines if an input is a valid integer number.
	 * 
	 * @param number the input number to validate
	 * @throws IntegerValidationException if the input doesn't contain a valid
	 *                                    number that can be stored as an integer.
	 */
	public void checkNumberIsValidIntegerOrThrowValidationException(String number) throws IntegerValidationException {
		if (number == null || number.trim().isEmpty()) {
			throw new IntegerValidationException(number, "The number to validate cannot be empty.");
		}

		Double parsedNumber = null;
		try {
			parsedNumber = Double.parseDouble(number);
		} catch (NumberFormatException e) {
			throw new IntegerValidationException(number, "Input is not a number.", e);
		}

		if (parsedNumber > Integer.MAX_VALUE || parsedNumber <= Integer.MIN_VALUE) {
			throw new IntegerValidationException(number, "Number is not within the bounds of an Integer.");
		}
	}
}
