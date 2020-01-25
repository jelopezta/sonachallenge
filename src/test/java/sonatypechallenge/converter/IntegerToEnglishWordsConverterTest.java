package sonatypechallenge.converter;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import sonatypechallenge.converter.english.IntegerToEnglishWordsConverter;

public class IntegerToEnglishWordsConverterTest {

	@Test
	public void convertZero() {
		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		String transformIntoWords = englishConverter.transformIntoWords(0);
		assertEquals("zero", transformIntoWords);
	}

	@Test
	public void convertOneToNinePositiveNumbers() {
		Map<Integer, String> expectedResults = new HashMap<>(10);
		expectedResults.put(0, "zero");
		expectedResults.put(1, "one");
		expectedResults.put(2, "two");
		expectedResults.put(3, "three");
		expectedResults.put(4, "four");
		expectedResults.put(5, "five");
		expectedResults.put(6, "six");
		expectedResults.put(7, "seven");
		expectedResults.put(8, "eight");
		expectedResults.put(9, "nine");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertTwoDigitNumbers_10To19() {
		Map<Integer, String> expectedResults = new HashMap<>(10);
		expectedResults.put(10, "ten");
		expectedResults.put(11, "eleven");
		expectedResults.put(12, "twelve");
		expectedResults.put(13, "thirteen");
		expectedResults.put(14, "fourteen");
		expectedResults.put(15, "fifteen");
		expectedResults.put(16, "sixteen");
		expectedResults.put(17, "seventeen");
		expectedResults.put(18, "eighteen");
		expectedResults.put(19, "nineteen");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertTwoDigitNumbers_MultipleOfTen() {
		Map<Integer, String> expectedResults = new HashMap<>(10);
		expectedResults.put(10, "ten");
		expectedResults.put(20, "twenty");
		expectedResults.put(30, "thirty");
		expectedResults.put(40, "forty");
		expectedResults.put(50, "fifty");
		expectedResults.put(60, "sixty");
		expectedResults.put(70, "seventy");
		expectedResults.put(80, "eighty");
		expectedResults.put(90, "ninety");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertTwoDigitNumbers_Above20_below100() {
		Map<Integer, String> expectedResults = new HashMap<>(10);
		expectedResults.put(23, "twenty-three");
		expectedResults.put(35, "thirty-five");
		expectedResults.put(47, "forty-seven");
		expectedResults.put(52, "fifty-two");
		expectedResults.put(69, "sixty-nine");
		expectedResults.put(71, "seventy-one");
		expectedResults.put(89, "eighty-nine");
		expectedResults.put(94, "ninety-four");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertThreeDigitNumbers_MultipleOfHundred() {
		Map<Integer, String> expectedResults = new HashMap<>(10);
		expectedResults.put(100, "one hundred");
		expectedResults.put(200, "two hundred");
		expectedResults.put(300, "three hundred");
		expectedResults.put(400, "four hundred");
		expectedResults.put(500, "five hundred");
		expectedResults.put(600, "six hundred");
		expectedResults.put(700, "seven hundred");
		expectedResults.put(800, "eight hundred");
		expectedResults.put(900, "nine hundred");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertNegativeNumbers() {
		Map<Integer, String> expectedResults = new HashMap<>(9);
		expectedResults.put(-8, "minus eight");
		expectedResults.put(-12, "minus twelve");
		expectedResults.put(-55, "minus fifty-five");
		expectedResults.put(-200, "minus two hundred");
		expectedResults.put(-320, "minus three hundred twenty");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}
}
