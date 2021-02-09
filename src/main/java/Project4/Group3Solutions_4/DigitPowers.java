package Project4.Group3Solutions_4;

public class DigitPowers {
    /*

          Given one method name is power4
          Parameter is one int
          Return type is an int

          Get each digit from the parameter int number
          Take the each number to the power 4
          Sum powered numbers
          Return the result

          Example: parameter int is 1234

          1⁴ + 2⁴ + 3⁴ + 4⁴ = 1 + 16 + 81 + 256

          result should be 354

       */

        public static   int power4(int num){
            String parameter = Integer.toString(num);
            char[] nums = parameter.toCharArray();

            int sum = 0;
            for (int i = 0; i <nums.length; i++) {
                int digit = Integer.parseInt(String.valueOf(nums[i]));
                sum= (int) (sum +Math.pow(digit,4));

            }
            return sum;
        }

}
