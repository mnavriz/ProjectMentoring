package Project2.Group2Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class arrayContains {

    /*
        Given two arrays of ints sorted in increasing order,
        outer and inner,
        return true if all of the numbers in inner appear in outer.
        Verify first array contains second array.

        linearIn([1, 2, 4, 6], [2, 4]) → true
        
        linearIn([1, 2, 4, 6], [2, 3, 4]) → false
        linearIn([1, 2, 4, 4, 6], [2, 4]) → true

     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String myStr = scan.nextLine();
        String[] arr = myStr.split(" ");
        int[] myArr = new int[5];
        for(int i = 0 ; i< arr.length ; i++){
            int num = Integer.parseInt(arr[i]);
            myArr[i] = num;
        }
        int[] UseThisArray1 = new int[3];
        int[] UseThisArray2 = new int[2];

        for(int i = 0 ; i <3 ; i++){
            UseThisArray1[i] = myArr[i];

        }

        for(int i = 3 ; i <5 ; i++){
            UseThisArray2[i-3] = myArr[i];

        }

//        Code start here
//        Use the array name UseThisArray1 and UseThisArray2

        boolean result = true ;
        Arrays.sort(UseThisArray1);
        Arrays.sort(UseThisArray2);
        System.out.println(Arrays.toString(UseThisArray1));
        System.out.println(Arrays.toString(UseThisArray2));
        System.out.println(Arrays.toString(myArr));
        for (int i = 0; i < UseThisArray2.length; i++) {
            for (int j = 0; j < UseThisArray1.length; j++) {
                if(UseThisArray2[i]==UseThisArray1[j]){
                    result = true;
                    break;
                }
                else{
                    //System.out.println(result);
                    result = false;
               }
            }

       }
        System.out.println(result);


        for (int a:UseThisArray2) {
            for (int i = 0; i < UseThisArray1.length; i++) {
                if(a == UseThisArray1[i]){
                    result = true;
                    break;
                }
                else {
                    result = false;
                }
            }

        }
        System.out.println(result);
    }
}
