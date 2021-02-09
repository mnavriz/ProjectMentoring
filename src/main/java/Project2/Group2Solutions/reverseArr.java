package Project2.Group2Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class reverseArr {

      /*
        Given String array

        reverse the String array

        print the reversed array

        NOTE: While printing the array dont use for loop
        Use Arrays.toString(your_array_name);


     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String myStr = scan.nextLine();

        String[] useThisArray = myStr.split(" ");

//        code start here
        String[] reversed = new String[useThisArray.length];
//        String subStr = "";
//        System.out.println(Arrays.toString(useThisArray));

            for (int j = useThisArray.length-1; j >=0 ; j--) {
                reversed[useThisArray.length-j-1]=useThisArray[j];
  //              subStr = useThisArray[j];

//                System.out.print(subStr+"  ");
 //               System.out.println();
 //               reversed[useThisArray.length-j-1] = subStr;

            }
        System.out.println(Arrays.toString(reversed));
    }

}
