package com.sj1.pr3.model;

import java.util.Random;



public class GenerateRandomEmail {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    /**
     * Developed by Hampus Bohlin in User Story 3. Method which generates a a
     * random string, and adds "@" and a "."
     * 
     * @param length
     *            is the length of the random generated email address
     */
    public String generateRandomEmail(int length) {
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i <= length; i++) {
            int randomLimitedInt = leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        // Generate position for . and @.
        int dotPosition = generateRandomNumber(generatedString.length() - 4, generatedString.length() - 3);
        int atPosition = generateRandomNumber(1, dotPosition - 2);
        
        StringBuffer stringBuffer = new StringBuffer(generatedString);
        stringBuffer.setCharAt(dotPosition, '.');
        generatedString = "" + stringBuffer;
        stringBuffer = new StringBuffer(generatedString);
        stringBuffer.setCharAt(atPosition, '@');
        generatedString = "" + stringBuffer;
        return generatedString;
    }
    /*
     * Developed by Hampus Bohlin in User Story 3. Method which randomize two
     * int , min-max then returns the value.
     */
    public int generateRandomNumber(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }
}
