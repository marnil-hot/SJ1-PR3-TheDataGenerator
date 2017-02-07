package aplicationTeam2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStringLenght  {
	 public static String repeat(int len, String ch) {

	        String s = IntStream.generate(() -> 1).limit(len).mapToObj(x -> ch).collect(Collectors.joining());
	      System.out.println (s);
	        return s;    
	    }
}