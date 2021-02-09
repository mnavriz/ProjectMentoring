package Project3.Project3Solutions;

public class CamelCase2 {

    public static void main(String[] args) {

        String a = "asd asASwew qWe qW asd";

        String[] word = a.split(" ");

        String result = "";

        for(String s :word){

            s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase()+" ";

            result = result.concat(s);

        }

        System.out.println(result);

    }
}
