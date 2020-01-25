package sonatypechallenge.converter;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import sonatypechallenge.converter.english.IntegerToEnglishWordsConverter;

public class IntegerToEnglishWordsConverterTest {

	@Test
	public void convertZeroToNinePositiveNumbers() {
		final int start = 0;
		final int end = 10;

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
		for (int i = start; i < end; i++) {
			String numberInWords = englishConverter.transformIntoWords(i);
			assertEquals(expectedResults.get(i), numberInWords);
		}
	}

	@Test
	public void convertTwoDigitNumbers_10To19() {
		final int start = 10;
		final int end = 20;

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
		for (int i = start; i < end; i++) {
			String numberInWords = englishConverter.transformIntoWords(i);
			assertEquals(expectedResults.get(i), numberInWords);
		}
	}

	@Test
	public void convertTwoDigitNumbers_MultipleOfTen() {
		final int start = 10;
		final int end = 90;

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
		for (int i = start; i < end; i += 10) {
			String numberInWords = englishConverter.transformIntoWords(i);
			assertEquals(expectedResults.get(i), numberInWords);
		}
	}

	@Test
	public void convertNegativeNumber() {
		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		Map<Integer, String> expectedResults = new HashMap<>(9);
		expectedResults.put(-8, "minus eight");
		expectedResults.put(-12, "minus twelve");
		expectedResults.put(-320, "minus three hundred twenty");

		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}
}
