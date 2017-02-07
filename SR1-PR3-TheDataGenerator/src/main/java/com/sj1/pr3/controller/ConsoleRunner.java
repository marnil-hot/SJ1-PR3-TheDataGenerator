package com.sj1.pr3.controller;

import com.sj1.pr3.datagenerator.DataGenerator;

/**
 * Hello world!
 *
 */
public class ConsoleRunner {

    private static char[] charset = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Let's get some of that random data: " + DataGenerator.randomData() );
    }
}
