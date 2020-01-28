package sonatypechallenge.converter.english;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import sonatypechallenge.converter.IntegerToWordsConverter;

/**
 * Transformer from integer into English words.
 *
 */
public class IntegerToEnglishWordsConverter implements IntegerToWordsConverter {
	private static final String HUNDRED_MARKER_WORD = "hundred";
	private static final String THOUSAND_MARKER_WORD = "thousand";
	private static final String MILLION_MARKER_WORD = "million";
	private static final String BILLION_MARKER_WORD = "billion";
	private static final String[] MARKERS_PER_GROUP = new String[] { "", THOUSAND_MARKER_WORD, MILLION_MARKER_WORD,
			BILLION_MARKER_WORD };

	private List<String> words;
	private String[] numberAsStringGroups;
	private boolean numberLessThanZero;

	@Override
	public String transformIntoWords(int numberToConvert) {
		if (numberToConvert == 0) {
			return EnglishNumbersBelowTwenty.ZERO.toString();
		}

		initializeTransformationValues(numberToConvert);
		addMinusForNegativeNumber();
		buildNumberRepresentationAsString();

		return words.stream().collect(Collectors.joining(" ")).trim();
	}

	private void buildNumberRepresentationAsString() {
		int totalMarkersNeeded = numberAsStringGroups.length - 1;
		for (String group : numberAsStringGroups) {
			int currentWords = words.size();
			if (group.length() == 3 && group.charAt(0) != '0') {
				EnglishNumbersBelowTwenty hundredDigit = EnglishNumbersBelowTwenty.findNumber("" + group.charAt(0));
				words.add(hundredDigit.toString());
				words.add(HUNDRED_MARKER_WORD);

			}
			String groupRemainderToParse = getRemainderToParse(group);
			parseTwoOrOneDigitNumber(groupRemainderToParse);

			boolean wordsAddedForGroup = words.size() > currentWords;
			if (wordsAddedForGroup) {
				// only add marker if words were added for the group
				words.add(MARKERS_PER_GROUP[totalMarkersNeeded--]);
			} else {
				totalMarkersNeeded--;
			}
		}
	}

	private String getRemainderToParse(String number) {
		String numberToParse;
		switch (number.length()) {
		case 3:
			numberToParse = "" + number.charAt(1) + number.charAt(2);
			break;
		case 2:
			numberToParse = "" + number.charAt(0) + number.charAt(1);
			break;
		default:
			numberToParse = String.valueOf(number.charAt(0));
			break;
		}
		return numberToParse;
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
		numberLessThanZero = numberToConvert < 0;
		numberAsStringGroups = getThreeDigitNumberTokensOfPositiveNumber(numberToConvert);
		words = new ArrayList<>();
	}

	private String[] getThreeDigitNumberTokensOfPositiveNumber(int numberToConvert) {
		int absoluteNumberToConvert = getAbsoluteInteger(numberToConvert);

		// Use a custom separator to prevent locale specific problems when splitting
		DecimalFormatSymbols customDecimalFormatSeparator = new DecimalFormatSymbols(Locale.getDefault());
		customDecimalFormatSeparator.setGroupingSeparator('|');

		// we have to use comma as the grouping separator in the pattern, even when
		// using a custom one
		String formatPattern = "#,###";
		DecimalFormat formatter = new DecimalFormat(formatPattern, customDecimalFormatSeparator);
		String format = formatter.format(absoluteNumberToConvert);
		return format.split("\\|");
	}

	private int getAbsoluteInteger(int numberToConvert) {
		return Math.abs(numberToConvert);
	}

	private void addMinusForNegativeNumber() {
		if (numberLessThanZero) {
			words.add("minus");
		}
	}

}
