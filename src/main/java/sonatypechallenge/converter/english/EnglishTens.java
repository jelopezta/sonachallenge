package sonatypechallenge.converter.english;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of the numbers from 1 to 100 which are multiple of 10 in
 * numbers and words.
 */
enum EnglishTens {
	TEN(10), TWENTY(20), THIRTY(30), FORTY(40), FIFTY(50), SIXTY(60), SEVENTY(70), EIGHTY(80), NINETY(90);

	private final int numberAsInt;
	private final static Map<Integer, EnglishTens> numberSearchByIntRepresentation = new HashMap<>();

	static {
		for (EnglishTens number : EnglishTens.values()) {
			numberSearchByIntRepresentation.put(number.numberAsInt, number);
		}
	}

	EnglishTens(int tensAsInt) {
		numberAsInt = tensAsInt;
	}

	static EnglishTens findNumber(int numberToSearch) {
		return numberSearchByIntRepresentation.get(numberToSearch);
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
