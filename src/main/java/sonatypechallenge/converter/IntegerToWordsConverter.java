package sonatypechallenge.converter;

/**
 * Defines basic operations for a converter from an integer into words.
 * 
 */
public interface IntegerToWordsConverter {

	/**
	 * Transforms the given integer into words.
	 * 
	 * @param numberToConvert the number to transform
	 * @return representation of the number in words
	 */
	String transformIntoWords(int numberToConvert);

}
