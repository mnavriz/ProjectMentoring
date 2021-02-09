package Project2.Group2Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class diffBetweenMaxMin {

    /*
    Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.

    Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.


    bigDiff([10, 3, 5, 6]) → 10-3 result = 7
    bigDiff([7, 2, 10, 9]) → 10-2 result = 8
    bigDiff([2, 10, 7, 1]) → 10-1 result = 9

    return type is int
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String myStr = scan.nextLine();

        String[] strArr = myStr.split(" ");

        int[] useThisArray = new int[strArr.length];

        int difference = 0;

        for(int i = 0 ; i< strArr.length ; i++){

            int num =Integer.parseInt(strArr[i]);
            useThisArray[i] = num;


        }

//        Your code start here. Don't remove or change anything before this line. Your array is -> useThisArray in line 27
        Arrays.sort(useThisArray);
        System.out.println(Arrays.toString(useThisArray));
        difference = useThisArray[useThisArray.length-1]-useThisArray[0];
        System.out.println(difference);

    }

}
