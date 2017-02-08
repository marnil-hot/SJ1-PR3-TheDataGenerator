package com.sj1.pr3.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Viktor on 2017-02-07.
 */
public class GibberishTextTest {

    GibberishText gt = new GibberishText();


    @Test
    public void testGibberize() throws Exception {

        String[] expected = { "once", "upon", "a", "time", "there", "was", "cow", "called", "moo",
                "he", "she", "enjoyed", "eating", "green", "grass", "every", "day", ".", ",", "?"};

        String[] result = gt.getWordList();

        assertArrayEquals(expected, result);

    }
}