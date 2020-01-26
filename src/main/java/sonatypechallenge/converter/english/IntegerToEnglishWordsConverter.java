package sonatypechallenge.converter.english;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
		String group = numberAsStringGroups[0];
		if (group.length() == 3 && group.charAt(0) != '0') {
			EnglishNumbersBelowTwenty hundredDigit = EnglishNumbersBelowTwenty.findNumber("" + group.charAt(0));
			words.add(hundredDigit.toString());
			words.add(HUNDRED_MARKER_WORD);

			String numberToParse = "" + group.charAt(1) + group.charAt(2);
			parseTwoOrOneDigitNumber(numberToParse);
		} else {
			String numberToParse = group.length() == 1 ? String.valueOf(group.charAt(0))
					: "" + group.charAt(0) + group.charAt(1);
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
		// Use a custom separator to prevent locale specific problems when splitting
		DecimalFormatSymbols customDecimalFormatSeparator = new DecimalFormatSymbols(Locale.getDefault());
		customDecimalFormatSeparator.setGroupingSeparator('|');

		// we have to use comma as the grouping separator in the pattern, even when
		// using a custom one
		String formatPattern = "#,###";
		DecimalFormat formatter = new DecimalFormat(formatPattern, customDecimalFormatSeparator);
		String format = formatter.format(numberToConvert);
		return format.split("\\|");
	}

	private void addMinusForNegativeNumber() {
		if (isNegativeNumber) {
			words.add("minus");
		}
	}

}
