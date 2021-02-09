package Project3.Project3Group3;

public class SubtractionSquare {

    /*

    Given one method name is substSquare
    This method get two ints as parameter
    return type is int

    Get square of the sum of the numbers using getSumOfSquares(scroll down to see explanation) method ,
    Parameter 1 square of the sum + Parameter 2 square of the sum  = your result

    for example:
    int 1 = 10

    int 2 = 5;

    3025 + 225 = 3250

    return 3250

     */
        public int  substSquare(int num1 , int num2){
            return getSumOfSquares(num1)+getSumOfSquares(num2 );
        }

    /*

    Create one method name is getSumOfSquares
    This method get one int as parameter
    Return type is int

    Get the square of the sum of the numbers

    for example:

    int is 10
     (1+2+...+10)²=55²=3025
     return 3025
     */
public static int getSumOfSquares(int num1){
int sqr=0;
int sum=0;
    for (int i = 0; i <= num1; i++) {
        sum+=i;
    }

sqr=sum*sum;

    return sqr;
}


}
