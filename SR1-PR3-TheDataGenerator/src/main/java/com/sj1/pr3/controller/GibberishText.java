package com.sj1.pr3.controller;

import java.util.Random;

/**
 * Created by Viktor on 2017-02-02.
 */

public class GibberishText {

    // Put in the specified characters and the length to generate some gibberish

    public static String[] getWordList() {
        return wordList;
    }

    private static String[] wordList = { "once", "upon", "a", "time", "there", "was", "cow", "called", "moo",
                                         "he", "she", "enjoyed", "eating", "green", "grass", "every", "day", ".", ",", "?"};

    public static String[] gibberize(String[] words, int length) {
        Random r = new Random();
        String[] gibberText = new String[length];

        for (int i = 0; i < gibberText.length; i++) {
            int randomWordIndex = r.nextInt(words.length);
            gibberText[i] = words[randomWordIndex];
        }

        return gibberText;
    }



}