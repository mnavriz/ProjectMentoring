package Project3.Project3Solutions;

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
        String[] parts = sentence.split(" ");
        String camelCaseString = "";
        for (String part : parts){
            if(part!=null && part.trim().length()>0)
                camelCaseString = camelCaseString + toProperCase(part);
            else
                camelCaseString=camelCaseString+part+" ";
        }
        return camelCaseString;


    }

    public String toProperCase(String s) {
//        String temp=s.trim();
//        String spaces="";
//        if(temp.length()!=s.length())
//        {
//            int startCharIndex=s.charAt(temp.indexOf(0));
//            spaces=s.substring(0,startCharIndex);
//        }
//        temp=temp.substring(0, 1).toUpperCase() +
//                spaces+temp.substring(1).toLowerCase()+" ";
//        return temp;

        String[] word = s.split(" ");

        String result = "";

        for(String value :word){

            value = value.substring(0,1).toUpperCase() + value.substring(1).toLowerCase()+" ";

            result = result.concat(value);

        }

        return result;
    }


}
