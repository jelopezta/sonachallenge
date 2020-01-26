package sonatypechallenge.converter.english;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of the numbers from 0 to 19 in numbers and words.
 */
enum EnglishNumbersBelowTwenty {
	ZERO(0, "000"), ONE(1, "001"), TWO(2, "002"), THREE(3, "003"), FOUR(4, "004"), FIVE(5, "005"), SIX(6, "006"),
	SEVEN(7, "007"), EIGHT(8, "008"), NINE(9, "009"), TEN(10, "010"), ELEVEN(11, "011"), TWELVE(12, "012"),
	THIRTEEN(13, "013"), FOURTEEN(14, "014"), FIFTEEN(15, "015"), SIXTEEN(16, "016"), SEVENTEEN(17, "017"),
	EIGHTEEN(18, "018"), NINETEEN(19, "019");

	private final int numberAsInt;
	private final String numberAsThreeDigitString;

	private final static Map<Integer, EnglishNumbersBelowTwenty> numberSearchByIntRepresentation = new HashMap<>();
	private final static Map<String, EnglishNumbersBelowTwenty> numberSearchByStringRepresentation = new HashMap<>();

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
		String numberAs3DigitString = numberToSearch.length() == 1 ? "00" + numberToSearch : "0" + numberToSearch;
		return numberSearchByStringRepresentation.get(numberAs3DigitString);
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
