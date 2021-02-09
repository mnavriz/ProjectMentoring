package Project4.Group3Solutions_4;

public class PalindromeNumber {

      /*
        Given a method name is returnNum
        Parameter is one int
        Return type is int

        Reverse int (that is, re-form an int by reversing the order of the digits of the parameter int)
        Return the reversed int

        Example:
        int  = 1234

        return should be 4321
     */

    public int returnNum(int number) {
        String num = Integer.toString(number);
        int j = num.length();
        String reversed = "";
        for (int i = 0; i <num.length(); i++) {
            reversed=reversed+num.charAt(j-1);
            j--;
        }

        int result = Integer.parseInt(reversed);

        return result;
    }

    /*
        Given palindromeNum method
        Parameter is one int (num1)
        Return type is one int

        Palindrome means a word or number reads the same backward as forward like "mom" , "refer" , "131" , "1221"

       Add num1 and reverse of num1, find the result.
       Check if the result is a palindrome or not.
       If the result is not a palindrome number, find the reverse of the result.
       And add the result and reverse of the result, find the new total.
       Check if the new total is a palindrome or not.
       Do the same steps until you reach a palindrome number in your result.
       After you reached the palindrome number, find the count that how many times you did the same operation to reach a palindrome number.
       Return the count

        Example:
            num1 = 349  --> 349  + 943 = 1292     Note : since 1292 is not palindrome do the same step for this  // first operation
                            1292 + 2921 = 4213   Note : 4213 is not palindrome  do the same step for this // second operation
                            4213 + 3124 = 7337   Note : 7337 is palindrome      // third operation  you reached the palindrome so count is 3

        return should be 3
        HINT: You better use while loop for this question

     */

    public int palindromeNum(int num) {
        int count = 0;
        do {


            num = num+returnNum(num);
            count++;
        }while(num!=returnNum(num));

        return count;
    }


}
