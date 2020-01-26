package sonatypechallenge.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntegerValidatorTest {

	@Test
	public void inputCannotBeNull() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			boolean inputIsValidInteger = integerValidator.isValidIntegerNumber(null);
		} catch (IntegerValidationException e) {
			assertEquals("The number to validate cannot be empty. Original input: null", e.getMessage());
		}
	}

	@Test
	public void inputCannotBeEmpty() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			boolean inputIsValidInteger = integerValidator.isValidIntegerNumber("  ");
		} catch (IntegerValidationException e) {
			assertEquals("The number to validate cannot be empty. Original input: " + "  ", e.getMessage());
		}
	}

	@Test
	public void inputHasToBeNumber() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			boolean inputIsValidInteger = integerValidator.isValidIntegerNumber("huafwsdihupfsd");
		} catch (IntegerValidationException e) {
			assertEquals("Input is not a number. Original input: huafwsdihupfsd", e.getMessage());
		}
	}

	@Test
	public void inputOutOfLowerBounds() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			boolean inputIsValidInteger = integerValidator.isValidIntegerNumber("" + (Integer.MIN_VALUE - 1));
		} catch (IntegerValidationException e) {
			assertEquals("Number is not within the bounds of an Integer. Original input: " + (Integer.MIN_VALUE - 1),
					e.getMessage());
		}
	}

	@Test
	public void inputOutOfHigherBounds() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			boolean inputIsValidInteger = integerValidator.isValidIntegerNumber("" + (Integer.MAX_VALUE + 1));
		} catch (IntegerValidationException e) {
			assertEquals("Number is not within the bounds of an Integer. Original input: " + (Integer.MAX_VALUE + 1),
					e.getMessage());
		}
	}

	@Test
	public void inputIsCorrect() throws IntegerValidationException {
		IntegerValidator integerValidator = new IntegerValidator();
		boolean inputIsValidInteger = integerValidator.isValidIntegerNumber("9");
		assertTrue(inputIsValidInteger);
	}
}
