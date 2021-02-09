package Project2.Group2Solutions;

import java.util.Arrays;

public class sumTotal {

    /*
        Create String 2D array

        {{"$12" , "$22" , "5"},{"€9" , "€40" , "$1" , "$2"}, {"€12"}}

        if the String has $ multiply by 3.2

        if the String has € multiply by 4.2

        return the double

     */

    public static void main(String[] args) {

//        Code Start Here
        String[][] myStrArray = {{"$12", "$22", "5"}, {"€9", "€40", "$1", "$2"}, {"€12"}};
        String subStr = "";
        int dollar = 0;
        int sumD = 0 ;
        int euro = 0;
        int sumEuro = 0;
        int num = 0;
        int numSum = 0;
        double totalSum = 0;
        for (int i = 0; i < myStrArray.length; i++) {
            for (int j = 0; j < myStrArray[i].length; j++) {
                if (myStrArray[i][j].contains("$")){
                    subStr = myStrArray[i][j];
//                    System.out.println(myStrArray[i][j]);
                    subStr=myStrArray[i][j].replace("$","");
                    dollar = Integer.parseInt(subStr);
                    sumD += dollar;

                }
                else if (myStrArray[i][j].contains("€")){
                    subStr = myStrArray[i][j];
//                    System.out.println(myStrArray[i][j]);
                    subStr=myStrArray[i][j].replace("€","");
                    euro = Integer.parseInt(subStr);
                    sumEuro += euro;
                }
                else{
                    subStr = myStrArray[i][j];
                    num = Integer.parseInt(subStr);
                    numSum += num;
                }

            }

        }
        System.out.println(sumD+" is sum of $ ");
        System.out.println(sumEuro+" is sum of € ");
        System.out.println(numSum+" is sum of numbers ");
        totalSum = sumD*3.2 + sumEuro*4.2 + numSum;
        System.out.println(totalSum);
    }

}
/*
            converted = Arrays.toString(myStrArray[i]);
            replaced = converted.replace("$", "").replace("€", "");
//            System.out.println(replaced);
//               for (int j = 0; j < myStrArray[i].length; j++) {
//                numbers[0] = Integer.parseInt(replaced);
//                   System.out.println(numbers);
////                sum = sum + numbers[i];
//            }



//            System.out.println(sum);

int sum = 0;

    String [] str = {"123", "345", "437", "894"};
    int size = str.length;
    int [] arr = new int [size];
            for(int i=0; i<size; i++) {
        arr[i] = Integer.parseInt(str[i]);
        sum = sum+arr[i];
        }
        System.out.println(sum);*/
//  String replace = convert.replace("1", "one ").replace("0", "zero ");

/* for (int row = 0; row < board.length; row++)
    { for (int col = 0; col < board[row].length; col++)
        { board[row][col] = row * col; }

        Read more: https://javarevisited.blogspot.com/2015/09/how-to-loop-two-dimensional-array-in-java.html#ixzz6akovLNtw*/

/*  String  anyString = "Hello World!";
        String replacedSpring = anyString.replace('l','L');
        System.out.println(replacedSpring);

        System.out.println(anyString.replace("Hello","Hi"));

    }*/