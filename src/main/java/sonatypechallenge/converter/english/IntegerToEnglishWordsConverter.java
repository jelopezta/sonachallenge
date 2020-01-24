package sonatypechallenge.converter.english;

import java.util.HashMap;
import java.util.Map;

import sonatypechallenge.converter.IntegerToWordsConverter;

/**
 * Transformer from integer into english words.
 *
 */
public class IntegerToEnglishWordsConverter implements IntegerToWordsConverter {
	private static final String HUNDRED_MARKER_WORD = "hundred";
	private static final String THOUSAND_MARKER_WORD = "thousand";
	private static final String MILLION_MARKER_WORD = "million";
	private static final String BILLION_MARKER_WORD = "billion";

	private StringBuilder wordsFromNumberBuilder;
	private int numberToConvert;

	@Override
	public String transformIntoWords(int numberToConvert) {
		initializeTransformationValues(numberToConvert);
		addMinusForNegativeNumber();
		if (numberToConvert == 0) {
			return "zero";
		}

		return "invalid number";
	}

	private void initializeTransformationValues(int numberToConvert) {
		this.numberToConvert = numberToConvert;
		wordsFromNumberBuilder = new StringBuilder();
	}

	private void addMinusForNegativeNumber() {
		if (numberToConvert < 0) {
			wordsFromNumberBuilder.append("minus ");
		}
	}

}

enum EnglishDigits {
	ONE(1, "one"), TWO(2, "two"), THREE(3, "three"), FOUR(4, "four"), FIVE(5, "five"), SIX(6, "six"), SEVEN(7, "seven"),
	EIGHT(8, "eight"), NINE(9, "nine");

	private int digitAsInt;
	private String digitAsString;
	private static Map<Integer, EnglishDigits> digitSearchByIntRepresentation = new HashMap<>();
	static {
		for (EnglishDigits digit : EnglishDigits.values()) {
			digitSearchByIntRepresentation.put(digit.digitAsInt, digit);
		}
	}

	EnglishDigits(int digitAsInt, String digitAsString) {
		this.digitAsInt = digitAsInt;
		this.digitAsString = digitAsString;
	}

	public static EnglishDigits findDigit(int digit) {
		return digitSearchByIntRepresentation.get(digit);
	}
}
