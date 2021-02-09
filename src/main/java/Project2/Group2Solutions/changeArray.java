package Project2.Group2Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class changeArray {

      /*
        Given one arrays of Strings
        If string contains Orange change all Orange to Apple

        For Example:
        Array : Peach , Berry , Orange , WaterMelon , Orange

        Result should be Peach , Berry , Apple , WaterMelon , Apple

        Print the Array

     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String myStr = scan.nextLine();
        String[] UseThisArray = myStr.split(" ");

//        Code Start here
//        You should use -> UseThisArray
//        System.out.println(UseThisArray[1]);
        String[] newStr = UseThisArray;
        for (int i = 0; i < UseThisArray.length ; i++) {
            newStr[i] = UseThisArray[i].replaceAll("Orange","Apple");

            //System.out.print(UseThisArray[i].replaceAll("Orange","Apple")+"\t");
            //System.out.println(newStr[i]);
        }

        System.out.println(Arrays.toString(newStr));
    }

}
