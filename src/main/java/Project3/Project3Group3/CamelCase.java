package Project3.Project3Group3;

public class CamelCase {

    /*
       First letter to upper case
        parameter is one String
        return type is String
        words are delimited by a space.
        All the words first letter should be camel case

       For Example:

            my family live in united states

      Result should be

            My Family Live In United States

     */

    public  String camelcase(String sentence){


        String delimeter = " ";
        String [] array = sentence.split(delimeter);
//String [] newarray = new String[array.length];
        String newstring  ="";
        for (int i = 0; i < array.length; i++) {

            newstring+=array[i].substring(0,1).toUpperCase().concat(array[i].substring(1))+" ";
            // System.out.println(newarray.toString());
        }return newstring.trim();
    }


}
