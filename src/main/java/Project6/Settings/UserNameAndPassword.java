package Project6.Settings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UserNameAndPassword {

   /*
        Create the instance variables which are private String userName and private password
        Create an Arraylist . Arraylist type should be String. ArrayList should be static and private . Name is UserNameLists
     */

    private String userName, password;
    static private ArrayList<String> UserNameLists = new ArrayList<>();
    /*
       Given default constructor.
    */

    public UserNameAndPassword() {

    }

    /*
       Given constructor. Parameters are String Username , String Password.
        This constructor is calling the setUsername and setPassword methods.

    */
    public UserNameAndPassword(String Username, String Password) {
        setUsername(Username);
        setPassword(Password);
    }
       /*
        DO NOT CHANGE THE addUserToList METHOD

        addUserToList is adding default email address to the UserNameLists

     */

    public void addUserToList() {
        UserNameLists.add("Steven@gmail.com");
        UserNameLists.add("James@hotmail.com");
        UserNameLists.add("David@gmail.com");
        UserNameLists.add("Jerry@hotmail.com");
        UserNameLists.add("Emily@yahoo.com");
        UserNameLists.add("Barbara@gmail.com");
    }


    /*
        Create a method name is setUsername
        return type is String
        parameter is String(myUsername)

        if the myUsername length is less then 6
        return Username length should be more then 6

        if the myUsername contains space(" ")
        return  Username should NOT contain space

        if the myUsername does NOT contains @
        return Username should contain @ symbol

        if the UserNameLists has myusername
        return Username should be unique

        if all these are false
        private userName(comes from class variable) = myUsername

        and return the username

    */
    public String setUsername(String myUsername) {
        if (myUsername.length() < 6)
            return "Username length should be more then 6";
        if (myUsername.contains(" "))
            return "Username should NOT contain space";
        if (!myUsername.contains("@"))
            return "Username should contain @ symbol";
        if (UserNameLists.contains(myUsername))
            return "Username should be unique";

        return userName = myUsername;
    }

    /*
    Create a method name is setPassword
    Return type is String
    Parameter is String(myPassword)

    if myPassword length is less or equal than 5
    return  Password length more then 5 character

    if first condition is false
    private password variable((comes from class variable) is equal to myPassword

    and return the myPassword

     */
    public String setPassword(String myPassword) {
        if (myPassword.length() <= 5) {
            return "Password length more then 5 character";
        } else {
            return password = myPassword;
        }
    }

}
