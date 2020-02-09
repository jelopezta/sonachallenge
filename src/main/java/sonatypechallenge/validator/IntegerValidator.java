package sonatypechallenge.validator;

import org.apache.commons.lang3.StringUtils;

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
		String numberToCheck = sanitizeInputNumber(number);
		if (numberToCheck.isEmpty()) {
			throw new IntegerValidationException(number, "The number to validate cannot be empty.");
		}

		Double parsedNumber = null;
		try {
			parsedNumber = Double.parseDouble(numberToCheck);
		} catch (NumberFormatException e) {
			throw new IntegerValidationException(number, "Input is not a number.", e);
		}

		if (parsedNumber > Integer.MAX_VALUE || parsedNumber < Integer.MIN_VALUE) {
			throw new IntegerValidationException(number, "Number is not within the bounds of an Integer.");
		}
	}

	/**
	 * Performs transformation to try to ensure only a number is present in the
	 * passed string
	 * 
	 * @param number the number to sanitize
	 * @return the number as string without trailing spaces or separators
	 */
	public String sanitizeInputNumber(String number) {
		final String emptyString = StringUtils.EMPTY;
		String finalString = number == null ? "" : number.trim().replace(" ", emptyString);
		int indexOfComma = finalString.indexOf(",");
		if (indexOfComma > 0) {
			finalString = finalString.substring(0, indexOfComma);
		}

		int indexOfDot = finalString.indexOf(".");
		if (indexOfDot > 0) {
			finalString = finalString.substring(0, indexOfDot);
		}

		// prevent strings that are only , or .
		finalString = finalString.replace(",", ".").replace(".", "");
		return finalString;
	}
}
