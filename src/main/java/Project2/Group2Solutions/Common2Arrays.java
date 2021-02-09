package Project2.Group2Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class Common2Arrays {

    /*
         Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element.
         Both arrays will be length 1 or more.

        commonEnd([1, 2, 3], [7, 3]) → true
        commonEnd([1, 2, 3], [7, 3, 2]) → false
        commonEnd([1, 2, 3], [1, 3]) → true

     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String myStr = scan.nextLine();
        String[] arr = myStr.split(" ");
        int[] myArr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            myArr[i] = num;
        }
        int[] array1 = new int[3];
        int[] array2 = new int[2];
        for (int i = 0; i < 3; i++) {
            array1[i] = myArr[i];
        }
        for (int i = 3; i < 5; i++) {
            array2[i - 3] = myArr[i];
        }

/*
        your code start here .
        Use array 1 and array 2 .
        Don't change or delete anything before this line
 */
//        String str1 = Arrays.toString(array1);
//        String str2 = Arrays.toString(array2);
//      System.out.println(array1);
//      System.out.println(array2);

        /*

        boolean result = true;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[0] == array2[0] || array1[array1.length-1] == array2[array2.length-1]){

                }
                else{
                    result = false;
                }

            }

        }
         */

        boolean result = false;
        if (array1[0] == array2[0] || array1[array1.length - 1] == array2[array2.length - 1]) {
            result = true;
        }
        System.out.println(result);

    }

}
