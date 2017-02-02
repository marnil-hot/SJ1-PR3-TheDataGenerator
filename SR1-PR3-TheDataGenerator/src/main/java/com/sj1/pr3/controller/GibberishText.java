package com.sj1.pr3.datagenerator;

import java.util.Random;

/**
 * Created by Viktor on 2017-02-02.
 */

public class GibberishText {

    // Put in the specified characters and the length to generate some gibberish

    public static char[] gibberize(char[] characters, int length) {

        Random r = new Random();
        char[] gibberText = new char[length];

        // Create the gibberized gibberish
        for (int i = 0; i < gibberText.length; i++) {
            int randomCharIndex = r.nextInt(characters.length);
            gibberText[i] = characters[randomCharIndex];
        }

        return gibberText;
    }
}