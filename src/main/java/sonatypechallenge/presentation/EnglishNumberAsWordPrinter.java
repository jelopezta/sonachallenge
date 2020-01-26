package sonatypechallenge.presentation;

import java.util.Scanner;

import sonatypechallenge.converter.english.IntegerToEnglishWordsConverter;

/**
 * Basic printer in console for numbers as words.
 */
public class EnglishNumberAsWordPrinter {

	public static void main(String[] args) {
		System.out.println("Please write a number to transform into words:");

		String inputNumber = null;
		try (Scanner inScanner = new Scanner(System.in);) {
			inputNumber = inScanner.nextLine();
		}

		System.out.println("Input number was: " + inputNumber);

		int parsedInt = 0;
		try {
			parsedInt = Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			System.err.print("Invalid number");
			System.exit(1);
		}

		String numberAsWords = new IntegerToEnglishWordsConverter().transformIntoWords(parsedInt);
		System.out.println("The number in words is: \n" + numberAsWords);
		System.exit(0);
	}
}
