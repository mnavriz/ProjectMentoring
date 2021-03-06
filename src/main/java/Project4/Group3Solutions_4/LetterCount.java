package Project4.Group3Solutions_4;

import java.util.LinkedHashMap;

public class LetterCount {


    /*
            Given one method name is charCount
            Parameter is a String
            Return type is LinkedHashMap<Character, Integer>

            Get an each char from String return the number of each charin the String

            For Example:

            String = aabbbcccc

            return should be a , 2
                             b , 3
                             c , 4

            Note: There could be any char in the String.

     */

    public LinkedHashMap<Character, Integer> charCount(String myStr){
        LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < myStr.length(); i++) {
            Character charAt = myStr.charAt(i);
            Integer numberOfTimes = result.getOrDefault(charAt, 0);
            result.put(charAt, ++numberOfTimes);
        }



        return  result;


    }

}
