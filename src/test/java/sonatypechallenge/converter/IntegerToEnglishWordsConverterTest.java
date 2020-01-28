package sonatypechallenge.converter;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import sonatypechallenge.converter.english.IntegerToEnglishWordsConverter;

public class IntegerToEnglishWordsConverterTest {

	@Test
	public void convertZero() {
		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		String transformIntoWords = englishConverter.transformIntoWords(0);
		assertEquals("zero", transformIntoWords);
	}

	@Test
	public void convertOneToNinePositiveNumbers() {
		Map<Integer, String> expectedResults = new TreeMap<>();
		expectedResults.put(0, "zero");
		expectedResults.put(1, "one");
		expectedResults.put(2, "two");
		expectedResults.put(3, "three");
		expectedResults.put(4, "four");
		expectedResults.put(5, "five");
		expectedResults.put(6, "six");
		expectedResults.put(7, "seven");
		expectedResults.put(8, "eight");
		expectedResults.put(9, "nine");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertTwoDigitNumbers_10To19() {
		Map<Integer, String> expectedResults = new TreeMap<>();
		expectedResults.put(10, "ten");
		expectedResults.put(11, "eleven");
		expectedResults.put(12, "twelve");
		expectedResults.put(13, "thirteen");
		expectedResults.put(14, "fourteen");
		expectedResults.put(15, "fifteen");
		expectedResults.put(16, "sixteen");
		expectedResults.put(17, "seventeen");
		expectedResults.put(18, "eighteen");
		expectedResults.put(19, "nineteen");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertTwoDigitNumbers_MultipleOfTen() {
		Map<Integer, String> expectedResults = new TreeMap<>();
		expectedResults.put(10, "ten");
		expectedResults.put(20, "twenty");
		expectedResults.put(30, "thirty");
		expectedResults.put(40, "forty");
		expectedResults.put(50, "fifty");
		expectedResults.put(60, "sixty");
		expectedResults.put(70, "seventy");
		expectedResults.put(80, "eighty");
		expectedResults.put(90, "ninety");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertTwoDigitNumbers_Above20_below100() {
		Map<Integer, String> expectedResults = new TreeMap<>();
		expectedResults.put(23, "twenty-three");
		expectedResults.put(35, "thirty-five");
		expectedResults.put(47, "forty-seven");
		expectedResults.put(52, "fifty-two");
		expectedResults.put(69, "sixty-nine");
		expectedResults.put(71, "seventy-one");
		expectedResults.put(89, "eighty-nine");
		expectedResults.put(94, "ninety-four");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertThreeDigitNumbers_MultipleOfHundred() {
		Map<Integer, String> expectedResults = new TreeMap<>();
		expectedResults.put(100, "one hundred");
		expectedResults.put(200, "two hundred");
		expectedResults.put(300, "three hundred");
		expectedResults.put(400, "four hundred");
		expectedResults.put(500, "five hundred");
		expectedResults.put(600, "six hundred");
		expectedResults.put(700, "seven hundred");
		expectedResults.put(800, "eight hundred");
		expectedResults.put(900, "nine hundred");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertFourDigitNumbers() {
		Map<Integer, String> expectedResults = new TreeMap<>();
		expectedResults.put(1_000, "one thousand");
		expectedResults.put(2_200, "two thousand two hundred");
		expectedResults.put(3_240, "three thousand two hundred forty");
		expectedResults.put(4_248, "four thousand two hundred forty-eight");
		expectedResults.put(5_098, "five thousand ninety-eight");
		expectedResults.put(6_001, "six thousand one");
		expectedResults.put(7_505, "seven thousand five hundred five");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertSevenDigitNumbers() {
		Map<Integer, String> expectedResults = new LinkedHashMap<>();
		expectedResults.put(1_000_000, "one million");
		expectedResults.put(2_200_000, "two million two hundred thousand");
		expectedResults.put(3_540_000, "three million five hundred forty thousand");
		expectedResults.put(4_769_000, "four million seven hundred sixty-nine thousand");
		expectedResults.put(5_098_000, "five million ninety-eight thousand");
		expectedResults.put(6_005_000, "six million five thousand");
		expectedResults.put(7_509_000, "seven million five hundred nine thousand");

		expectedResults.put(8_500_003, "eight million five hundred thousand three");
		expectedResults.put(9_300_014, "nine million three hundred thousand fourteen");
		expectedResults.put(8_400_310, "eight million four hundred thousand three hundred ten");
		expectedResults.put(7_400_668, "seven million four hundred thousand six hundred sixty-eight");
		expectedResults.put(6_200_702, "six million two hundred thousand seven hundred two");
		expectedResults.put(5_900_900, "five million nine hundred thousand nine hundred");

		expectedResults.put(4_940_001, "four million nine hundred forty thousand one");
		expectedResults.put(4_940_016, "four million nine hundred forty thousand sixteen");
		expectedResults.put(4_940_769, "four million nine hundred forty thousand seven hundred sixty-nine");
		expectedResults.put(4_940_804, "four million nine hundred forty thousand eight hundred four");
		expectedResults.put(4_940_600, "four million nine hundred forty thousand six hundred");

		expectedResults.put(9_856_007, "nine million eight hundred fifty-six thousand seven");
		expectedResults.put(9_856_026, "nine million eight hundred fifty-six thousand twenty-six");
		expectedResults.put(9_856_753, "nine million eight hundred fifty-six thousand seven hundred fifty-three");
		expectedResults.put(9_856_501, "nine million eight hundred fifty-six thousand five hundred one");
		expectedResults.put(9_856_300, "nine million eight hundred fifty-six thousand three hundred");

		expectedResults.put(6_704_002, "six million seven hundred four thousand two");
		expectedResults.put(6_704_012, "six million seven hundred four thousand twelve");
		expectedResults.put(6_704_762, "six million seven hundred four thousand seven hundred sixty-two");
		expectedResults.put(6_704_902, "six million seven hundred four thousand nine hundred two");
		expectedResults.put(6_704_300, "six million seven hundred four thousand three hundred");

		expectedResults.put(9_074_005, "nine million seventy-four thousand five");
		expectedResults.put(9_074_015, "nine million seventy-four thousand fifteen");
		expectedResults.put(9_074_655, "nine million seventy-four thousand six hundred fifty-five");
		expectedResults.put(9_074_705, "nine million seventy-four thousand seven hundred five");
		expectedResults.put(9_074_500, "nine million seventy-four thousand five hundred");

		expectedResults.put(3_001_006, "three million one thousand six");
		expectedResults.put(3_001_016, "three million one thousand sixteen");
		expectedResults.put(3_001_646, "three million one thousand six hundred forty-six");
		expectedResults.put(3_001_906, "three million one thousand nine hundred six");
		expectedResults.put(3_001_300, "three million one thousand three hundred");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertTenDigitNumbers() {
		Map<Integer, String> expectedResults = new LinkedHashMap<>();
		expectedResults.put(Integer.MAX_VALUE, "two billion " + "one hundred forty-seven million "
				+ "four hundred eighty-three thousand " + "six hundred forty-seven");
		expectedResults.put(1_674_875_984, "one billion " + "six hundred seventy-four million "
				+ "eight hundred seventy-five thousand " + "nine hundred eighty-four");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}

	@Test
	public void convertNegativeNumbers() {
		Map<Integer, String> expectedResults = new TreeMap<>();
		expectedResults.put(-8, "minus eight");
		expectedResults.put(-12, "minus twelve");
		expectedResults.put(-55, "minus fifty-five");
		expectedResults.put(-200, "minus two hundred");
		expectedResults.put(-320, "minus three hundred twenty");
		expectedResults.put(-8_500_003, "minus eight million five hundred thousand three");
		expectedResults.put(-9_300_014, "minus nine million three hundred thousand fourteen");
		expectedResults.put(-8_400_310, "minus eight million four hundred thousand three hundred ten");
		expectedResults.put(-7_400_668, "minus seven million four hundred thousand six hundred sixty-eight");
		expectedResults.put(-6_200_702, "minus six million two hundred thousand seven hundred two");
		expectedResults.put(-5_900_900, "minus five million nine hundred thousand nine hundred");

		expectedResults.put(Integer.MIN_VALUE + 1, "minus two billion " + "one hundred forty-seven million "
				+ "four hundred eighty-three thousand " + "six hundred forty-seven");

		IntegerToWordsConverter englishConverter = new IntegerToEnglishWordsConverter();
		for (Entry<Integer, String> entry : expectedResults.entrySet()) {
			assertEquals(entry.getValue(), englishConverter.transformIntoWords(entry.getKey()));
		}
	}
}
