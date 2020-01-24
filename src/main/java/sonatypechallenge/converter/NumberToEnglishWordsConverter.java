package sonatypechallenge.converter;

/**
 * Transformer from number into english words.
 *
 */
public class NumberToEnglishWordsConverter implements NumberToWordsConverter {

	@Override
	public String transformIntoWords(int numberToConvert) {
		if (numberToConvert == 0) {
			return "zero";
		}

		return "invalid number";
	}

}
