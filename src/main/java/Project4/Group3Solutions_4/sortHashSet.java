package Project4.Group3Solutions_4;

import java.util.*;

public class sortHashSet {

    /*
        Given the method whose name is sort
        Given allNumbers Integer Hashset as parameter
        Returns an ArrayList of Integers

        Sort the allNumbers hashset

        Change the result to ArrayList

        Return the ArrayList

        NOTE : DO NOT USE COLLECTION CLASS WHILE SOLVING THE QUESTION USE FOR LOOP OR DIFFERENT SET TYPES

     */

    public ArrayList<Integer> sort(HashSet<Integer> allNumbers){

        Set<Integer> sortedHashSet = new TreeSet<>(allNumbers);
        ArrayList<Integer> result  = new ArrayList<>(sortedHashSet);

        /*
        Integer[] array  = result.toArray(new Integer[0]);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {//!!!!!!!if change "<"to ">" ,will change sorting from smaller to bigger
                    // swap
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }


            }

        }

        result= new ArrayList<>(Arrays.asList(array)) ;
*/
        return  result;
    }

}
