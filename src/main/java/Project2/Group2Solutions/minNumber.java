package Project2.Group2Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class minNumber {

      /*
        Create int 2D array

        Which is {{1,2,3}, {2,3,1} , {5,5,5} , {2,1,3}}

        print the min number from the 2d array
     */

    public static void main(String[] args) {
        int[][] numArray = new int[][]{{1,2,3}, {2,3,1} , {5,5,5} , {2,1,3}};
        int min = numArray[0][0];
        for (int i = 0; i < numArray.length; i++) {
            for (int j = 0; j < numArray[i].length; j++) {
                if(numArray[i][j]<min){
                    min = numArray[i][j];
                }

            }

        }
        System.out.println(min);

    }

}
