package Project2.Group2Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class sameFirstAndLast {
   /*

    Given an array of ints, print true if the array is length 1 or more, and the first element and the last element are equal.

    sameFirstLast([1, 2, 3]) → false
    sameFirstLast([1, 2, 3, 1]) → true
    sameFirstLast([1, 2, 1]) → true
    sameFirstLast([1]) → true

    print just true or false

    */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String myStr = scan.nextLine();

        String[] useThisArray = myStr.split(" ");

//        code start here
        boolean result = true;
        int size = useThisArray.length;
        int[] parsed = new int[size];
        for (int i = 0; i < size; i++) {
            parsed[i] = Integer.parseInt(useThisArray[i]);
//            System.out.println(parsed[i]);
            if (size == 1){
                result = true;
            }
            else if (size>1 && parsed[0] == parsed[size-1]){
                result = true;
            }
            else{
                result = false;
            }
        }
        System.out.println(result);



    }


}
/*  Given an array of ints, print true if the array is length 1 or more, and the first element and the last element are equal
    sameFirstLast([1, 2, 3]) → false
    sameFirstLast([1, 2, 3, 1]) → true
    sameFirstLast([1, 2, 1]) → true
    sameFirstLast([1]) → true

    print just true or false

public static void main(String args[]) {
      String [] str = {"123", "345", "437", "894"};
      int size = str.length;
      int [] arr = new int [size];
      for(int i=0; i<size; i++) {
         arr[i] = Integer.parseInt(str[i]);
      }
      System.out.println(Arrays.toString(arr));
   } */