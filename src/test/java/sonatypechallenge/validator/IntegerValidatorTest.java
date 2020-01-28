package sonatypechallenge.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class IntegerValidatorTest {

	@Test
	public void inputCannotBeNull() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.checkNumberIsValidIntegerOrThrowValidationException(null);
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("The number to validate cannot be empty. Original input: null", e.getMessage());
		}
	}

	@Test
	public void inputCannotBeEmpty() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.checkNumberIsValidIntegerOrThrowValidationException("  ");
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("The number to validate cannot be empty. Original input: " + "  ", e.getMessage());
		}
	}

	@Test
	public void inputHasToBeNumber() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.checkNumberIsValidIntegerOrThrowValidationException("huafwsdihupfsd");
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("Input is not a number. Original input: huafwsdihupfsd", e.getMessage());
		}
	}

	@Test
	public void inputOutOfLowerBounds() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.checkNumberIsValidIntegerOrThrowValidationException("" + (Integer.MIN_VALUE - 1d));
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("Number is not within the bounds of an Integer. Original input: " + (Integer.MIN_VALUE - 1d),
					e.getMessage());
		}
	}

	@Test
	public void inputOutOfHigherBounds() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.checkNumberIsValidIntegerOrThrowValidationException("" + (Integer.MAX_VALUE + 1d));
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("Number is not within the bounds of an Integer. Original input: " + (Integer.MAX_VALUE + 1d),
					e.getMessage());
		}
	}

	@Test
	public void inputIsCorrect() throws IntegerValidationException {
		IntegerValidator integerValidator = new IntegerValidator();
		integerValidator.checkNumberIsValidIntegerOrThrowValidationException("9");
		try {
			integerValidator.checkNumberIsValidIntegerOrThrowValidationException("9");
		} catch (IntegerValidationException e) {
			throw new RuntimeException("Unexpected exception thrown", e);
		}
	}

	@Test
	public void sanitizeInputNumber_numberIsNull() {
		IntegerValidator integerValidator = new IntegerValidator();
		String sanitizedNumber = integerValidator.sanitizeInputNumber(null);
		assertEquals("", sanitizedNumber);
	}

	@Test
	public void sanitizeInputNumber_numberIsEmpty() {
		IntegerValidator integerValidator = new IntegerValidator();
		String sanitizedNumber = integerValidator.sanitizeInputNumber("");
		assertEquals("", sanitizedNumber);
	}

	@Test
	public void sanitizeInputNumber_numberHasTrailingSpaces() {
		IntegerValidator integerValidator = new IntegerValidator();
		String sanitizedNumber = integerValidator.sanitizeInputNumber("9   ");
		assertEquals("9", sanitizedNumber);
	}

	@Test
	public void sanitizeInputNumber_numberHasLeadingSpaces() {
		IntegerValidator integerValidator = new IntegerValidator();
		String sanitizedNumber = integerValidator.sanitizeInputNumber("   8");
		assertEquals("8", sanitizedNumber);
	}

	@Test
	public void sanitizeInputNumber_numberHasMiddleSpaces() {
		IntegerValidator integerValidator = new IntegerValidator();
		String sanitizedNumber = integerValidator.sanitizeInputNumber("6   8");
		assertEquals("68", sanitizedNumber);
	}

	@Test
	public void sanitizeInputNumber_numberHasCommas() {
		IntegerValidator integerValidator = new IntegerValidator();
		String sanitizedNumber = integerValidator.sanitizeInputNumber("9,8");
		assertEquals("98", sanitizedNumber);
	}

	@Test
	public void sanitizeInputNumber_numberHasDots() {
		IntegerValidator integerValidator = new IntegerValidator();
		String sanitizedNumber = integerValidator.sanitizeInputNumber("5.6");
		assertEquals("56", sanitizedNumber);
	}
}
