package sonatypechallenge.converter.english;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	private List<String> words;
	private int absoluteNumberToConvert;
	private String[] numberAsStringGroups;
	boolean isNegativeNumber;

	@Override
	public String transformIntoWords(int numberToConvert) {
		if (numberToConvert == 0) {
			return EnglishNumbersBelowTwenty.ZERO.getStringRepresentation();
		}

		initializeTransformationValues(numberToConvert);
		addMinusForNegativeNumber();

		if (this.absoluteNumberToConvert < 20) {
			words.add(EnglishNumbersBelowTwenty.findNumber(absoluteNumberToConvert).getStringRepresentation());
			return words.stream().collect(Collectors.joining(" "));
		}

		if (numberAsStringGroups.length > 0) {
			buildNumberRepresentationAsString();
		}

		return words.stream().collect(Collectors.joining(" "));
	}

	private void buildNumberRepresentationAsString() {
		char[] groupCharArray = numberAsStringGroups[0].toCharArray();
		if (groupCharArray.length == 3 && groupCharArray[0] != '0') {
			EnglishNumbersBelowTwenty hundredDigit = EnglishNumbersBelowTwenty.findNumber("00" + groupCharArray[0]);
			words.add(hundredDigit.getStringRepresentation());
			words.add(HUNDRED_MARKER_WORD);

			String numberToParse = "" + groupCharArray[1] + groupCharArray[2];

			parseTwoDigitNumber(numberToParse);
		} else {
			String numberToParse = groupCharArray.length == 1 ? String.valueOf(groupCharArray[0])
					: "" + groupCharArray[0] + groupCharArray[1];

			parseTwoDigitNumber(numberToParse);
		}
	}

	private void parseTwoDigitNumber(String numberToParse) {
		int parsedRemainder = Integer.parseInt(numberToParse);
		if (parsedRemainder < 20) {
			EnglishNumbersBelowTwenty numberBelowTwenty = EnglishNumbersBelowTwenty.findNumber(parsedRemainder);
			words.add(numberBelowTwenty.getStringRepresentation());
		} else {
			words.add("unavailable conversion");
		}
	}

	private void initializeTransformationValues(int numberToConvert) {
		isNegativeNumber = numberToConvert < 0;
		absoluteNumberToConvert = Math.abs(numberToConvert);
		numberAsStringGroups = getNumberTokens(this.absoluteNumberToConvert);
		words = new ArrayList<>();
	}

	private String[] getNumberTokens(int numberToConvert) {
		final StringBuilder tokensBuilder = new StringBuilder();
		int counter = 1;
		char[] numberAsCharArray = Integer.toString(numberToConvert).toCharArray();

		for (char digitInCharArray : numberAsCharArray) {
			tokensBuilder.append(digitInCharArray);
			if (counter % 3 == 0) {
				tokensBuilder.append('.');
			}
			counter++;
		}

		return tokensBuilder.toString().split("\\.");
	}

	private void addMinusForNegativeNumber() {
		if (isNegativeNumber) {
			words.add("minus");
		}
	}

	public static void main(String[] args) {
		String transformIntoWords = new IntegerToEnglishWordsConverter().transformIntoWords(111);
		System.out.println(transformIntoWords);
	}
}

enum EnglishNumbersBelowTwenty {
	ZERO(0, "000"), ONE(1, "001"), TWO(2, "002"), THREE(3, "003"), FOUR(4, "004"), FIVE(5, "005"), SIX(6, "006"),
	SEVEN(7, "007"), EIGHT(8, "008"), NINE(9, "009"), TEN(10, "010"), ELEVEN(11, "011"), TWELVE(12, "012"),
	THIRTEEN(13, "013"), FOURTEEN(14, "014"), FIFTEEN(15, "015"), SIXTEEN(16, "016"), SEVENTEEN(17, "017"),
	EIGHTEEN(18, "018"), NINETEEN(19, "019");

	private int numberAsInt;
	private String numberAsThreeDigitString;

	private static Map<Integer, EnglishNumbersBelowTwenty> numberSearchByIntRepresentation = new HashMap<>();
	private static Map<String, EnglishNumbersBelowTwenty> numberSearchByStringRepresentation = new HashMap<>();

	static {
		for (EnglishNumbersBelowTwenty number : EnglishNumbersBelowTwenty.values()) {
			numberSearchByIntRepresentation.put(number.numberAsInt, number);
			numberSearchByStringRepresentation.put(number.numberAsThreeDigitString, number);
		}
	}

	EnglishNumbersBelowTwenty(int digitAsInt, String numberAsThreeDigitString) {
		this.numberAsInt = digitAsInt;
		this.numberAsThreeDigitString = numberAsThreeDigitString;
	}

	static EnglishNumbersBelowTwenty findNumber(int numberToSearch) {
		return numberSearchByIntRepresentation.get(numberToSearch);
	}

	static EnglishNumbersBelowTwenty findNumber(String numberToSearch) {
		return numberSearchByStringRepresentation.get(numberToSearch);
	}

	String getStringRepresentation() {
		return name().toLowerCase();
	}

}
