package sonatypechallenge.converter;

/**
 * Defines basic operations for a converter from numbers into words.
 * 
 */
public interface NumberToWordsConverter {

	/**
	 * Transforms the given number into words.
	 * 
	 * @param numberToConvert the nubmer to transform
	 * @return representation of the number in words
	 */
	String transformIntoWords(int numberToConvert);

}
