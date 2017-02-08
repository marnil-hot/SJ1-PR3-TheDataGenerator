package com.sj1.pr3.controller;

import com.sj1.pr3.datagenerator.DataGenerator;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class ConsoleRunner {

    private static char[] charset = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    private static String[] wordList = { "once", "upon", "a", "time", "there", "was", "cow", "called", "moo",
            "he", "she", "enjoyed", "eating", "green", "grass", "every", "day", ".", ",", "?"};

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Let's get some of that random data: " + DataGenerator.randomData() );


        for (String url : GibberishText.gibberize(wordList, 20))
            System.out.print(url + " ");

    }
}