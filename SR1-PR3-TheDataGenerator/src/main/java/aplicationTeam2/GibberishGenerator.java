
package aplicationTeam2;

import java.util.Random;

/*
 * Created by Namir Wesaf.
 * User story : 8
 * This class generates random gibberish words and returns the result back.
 * It takes integer as parameter  and returns string.
 * */

public class GibberishGenerator {

	private String result = "";

	public String generateRandomWords(int numberOfWords)

	{
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for (int i = 0; i < numberOfWords; i++) {
			/* Generate random words between 3-8 chars, */
			char[] word = new char[random.nextInt(8) + 3];
			for (int j = 0; j < word.length; j++) {
				/* Chars between A-Z Unicode. */
				word[j] = (char) ('a' + random.nextInt(26));
			}
			randomStrings[i] = new String(word);

		}

		// Fill in result string with strings from array.
		for (int i = 0; i <= randomStrings.length - 1; i++) {
			if (i == 0) {
				// This one does not create a space at the first index.
				result = randomStrings[i];
			} else {
				result = result + " " + randomStrings[i];
			}

		}
		return result;

	}

}
