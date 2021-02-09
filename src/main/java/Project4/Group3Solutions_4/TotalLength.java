package Project4.Group3Solutions_4;

import java.util.HashSet;

public class TotalLength {

    /*

        Given getTotalLength method
        Parameter is one Set of Strings
        Return type is an int

       Get the total length of each String in the Set
       return the total

       Example:
       Set String is "repl" "is" "homework"

       result should be 14

       NOTE : IF RESULT IS EQUAL TO 0 THEN CHANGE IT TO -1

     */

    public int getTotalLength(HashSet<String> mySet) {
        int sum = 0;

        for (String str : mySet) {
            sum += str.length();
        }

        /*
        ArrayList<String> list = new ArrayList<>(mySet);
        int sum=0;
        int sum_t = 0;
        for (int i = 0; i < list.size(); i++) {
            sum_t = list.get(i).length();
            sum = sum +sum_t;
        }
        */
        if (sum == 0) {

            return -1;
        } else
            return sum;


    }

}
