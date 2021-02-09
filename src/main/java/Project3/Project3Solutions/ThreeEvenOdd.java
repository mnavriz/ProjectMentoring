package Project3.Project3Solutions;

public class ThreeEvenOdd {

    /*

    Given an int array as a parameter
    return true if the array contains either 3 even or 3 odd values .

    for Example:

    intArray([2, 1, 3, 5]) result should be true
    intArray([2, 1, 2, 5]) result should be  false
    intArray([2, 4, 2, 5]) result should be  true

     */

        public boolean threeEvenOrOdd(int[] intArr){

        int evenCounter = 0 ;
        int oddCounter = 0 ;

        for(int i = 0 ; i< intArr.length ; i++){

            if(intArr[i]%2==0){
                evenCounter++;

            }else{
                oddCounter++;

            }

        }

        boolean result = false;

        if(evenCounter==3 || oddCounter==3){
            result= true;
        }


        return result;
    }

}
