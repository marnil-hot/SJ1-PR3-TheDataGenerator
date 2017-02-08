package com.sj1.pr3.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Email {
	 public static String emailRandom(){
         String[] stringArray = {"hotmail","gmail","yahoo"};
         String alphabet = "abcdefghijklmnopqrstuvwxyz";
         Scanner scan = new Scanner(System.in);

         int n = alphabet.length();
         Random rand = new Random();


         int number;

         System.out.println("enter number");
         number = scan.nextInt();


         if(number <= 26 && number >= 1){
             System.out.print(alphabet.charAt(rand.nextInt(n)));

             while(number > 1){
                 System.out.print(alphabet.charAt(rand.nextInt(n)));
                 number--;
             }
         }else{
             System.out.println("Maximum characters is 26");
         }
         Collections.shuffle(Arrays.asList(stringArray));
         String result = alphabet + "@" + stringArray[0] + ".com";
         System.out.println( "@" + stringArray[0] + ".com");
         return result;
     }
}
