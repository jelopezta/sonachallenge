package sonatypechallenge.converter.english;

import java.util.ArrayList;
import java.util.List;
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
			return EnglishNumbersBelowTwenty.ZERO.toString();
		}

		initializeTransformationValues(numberToConvert);
		addMinusForNegativeNumber();
		buildNumberRepresentationAsString();

		return words.stream().collect(Collectors.joining(" "));
	}

	private void buildNumberRepresentationAsString() {
		char[] groupCharArray = numberAsStringGroups[0].toCharArray();
		if (groupCharArray.length == 3 && groupCharArray[0] != '0') {
			EnglishNumbersBelowTwenty hundredDigit = EnglishNumbersBelowTwenty.findNumber("" + groupCharArray[0]);
			words.add(hundredDigit.toString());
			words.add(HUNDRED_MARKER_WORD);

			String numberToParse = "" + groupCharArray[1] + groupCharArray[2];
			parseTwoOrOneDigitNumber(numberToParse);
		} else {
			String numberToParse = groupCharArray.length == 1 ? String.valueOf(groupCharArray[0])
					: "" + groupCharArray[0] + groupCharArray[1];
			parseTwoOrOneDigitNumber(numberToParse);
		}
	}

	private void parseTwoOrOneDigitNumber(String numberToParse) {
		int parsedRemainder = Integer.parseInt(numberToParse);
		if (parsedRemainder == 0) {
			// 0 doesn't need representation for numbers above it
			return;
		}
		if (parsedRemainder < 20) {
			EnglishNumbersBelowTwenty numberBelowTwenty = EnglishNumbersBelowTwenty.findNumber(parsedRemainder);
			words.add(numberBelowTwenty.toString());
		} else {
			int tens = (parsedRemainder / 10) * 10;
			int units = parsedRemainder % 10;

			EnglishTens tensRepresentation = EnglishTens.findNumber(tens);
			EnglishNumbersBelowTwenty unitsRepresentation = EnglishNumbersBelowTwenty.findNumber(units);
			if (units == 0) {
				words.add(tensRepresentation.toString());
			} else {
				words.add(tensRepresentation.toString() + "-" + unitsRepresentation.toString());
			}
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

}
