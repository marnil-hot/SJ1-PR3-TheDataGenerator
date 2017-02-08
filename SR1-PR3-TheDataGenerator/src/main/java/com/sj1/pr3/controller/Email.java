package com.sj1.pr3.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Email {
     public static String emailRandom(int length){
         String[] stringArray = {"hotmail","gmail","yahoo"};
         String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
         Random rand = new Random();
         StringBuilder sb = new StringBuilder();
        
         Collections.shuffle(Arrays.asList(stringArray));
        
         for(int i = 0; i < length; i++){
             int index = rand.nextInt(alphabet.length());
             char c = alphabet.charAt(index);
             sb.append(c);
         }
         if(length == 0){
             System.err.println("Enter a number higher than 0");
             System.exit(0);
         }if(length > 255){
             System.err.println("Number to high");
             System.exit(0);
         }
        return sb.toString() + "@" + stringArray[0] + ".com";
    
     }
}