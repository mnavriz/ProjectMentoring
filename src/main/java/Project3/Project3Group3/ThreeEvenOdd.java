package Project3.Project3Group3;

public class ThreeEvenOdd {

    /*

    Given an int array as a parameter
    return true if the array contains either 3 even or 3 odd values .

    for Example:

    intArray([2, 1, 3, 5]) result should be true
    intArray([2, 1, 2, 5]) result should be  false
    intArray([2, 4, 2, 5]) result should be  true

     */

        public boolean  threeEvenOrOdd(int[] intArr) {
            boolean contain = false;

            int count_even = 0;
            int count_odd = 0;
            for (int i = 0; i < intArr.length; i++) {
                if (intArr[i] % 2 == 0) {
                    count_even++;
                } else if (intArr[i] % 2 != 0) {
                    count_odd++;
                }}

                if (count_even == 3 || count_odd == 3) {

                    contain = true;

                }
                return contain;

            }
        }