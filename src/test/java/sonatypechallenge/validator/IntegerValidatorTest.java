package sonatypechallenge.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class IntegerValidatorTest {

	@Test
	public void inputCannotBeNull() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.isValidIntegerNumber(null);
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("The number to validate cannot be empty. Original input: null", e.getMessage());
		}
	}

	@Test
	public void inputCannotBeEmpty() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.isValidIntegerNumber("  ");
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("The number to validate cannot be empty. Original input: " + "  ", e.getMessage());
		}
	}

	@Test
	public void inputHasToBeNumber() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.isValidIntegerNumber("huafwsdihupfsd");
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("Input is not a number. Original input: huafwsdihupfsd", e.getMessage());
		}
	}

	@Test
	public void inputOutOfLowerBounds() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.isValidIntegerNumber("" + (Integer.MIN_VALUE));
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("Number is not within the bounds of an Integer. Original input: " + (Integer.MIN_VALUE),
					e.getMessage());
		}
	}

	@Test
	public void inputOutOfHigherBounds() {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.isValidIntegerNumber("" + (Integer.MAX_VALUE + 1d));
			fail("Expected exception not thrown");
		} catch (IntegerValidationException e) {
			assertEquals("Number is not within the bounds of an Integer. Original input: " + (Integer.MAX_VALUE + 1d),
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
