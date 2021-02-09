package Project2.Group2Solutions;

public class maxNumber {


      /*
        Create int 2D array

        Which is {{1,2,3}, {2,3,1} , {5,5,5} , {2,10,3}}

        print the max number from the 2d array

     */

    public static void main(String[] args) {

        int[][] i1 = new int[][]{{1,2,3}, {2,3,1} , {5,5,5} , {2,10,3}};

        int max = 0 ;
        for( int i = 0 ; i < i1.length ; i++){
            for(int j =0 ; j< i1[i].length ; j++){

                if(i1[i][j] > max){
                    max = i1[i][j];
                }
            }

        }

        System.out.println(max);

    }

}
