package Project6.Settings;

public class UserSettings {

    /*
    Create the instance variables
    All variables  should be public
    Strings are   username
                  password
                  Address1
                  City
                  ZipCode
                  ItemName
                  customText
                  color

    boolean       wanaCustomText
    double        myPrice

     */
    public String username, password, Address1, City, ZipCode, ItemName, customText, color;
    public boolean wanaCustomText;
    public double myPrice;

    /*

     Create a toString method
         return all the variables like

                "\nusername : " + username +
                "\npassword :" + password +
                "\nAddress1 " + Address1+
                 ........

     */
    public String ToString() {
        return
                "username: " + username +
                        "password: " + password +
                        "Address1: " + Address1 +
                        "City: " + City +
                        "ZipCode: " + ZipCode +
                        "ItemName: " + ItemName +
                        "customText: " + customText +
                        "color: " + color +
                        "wanaCustomText: " + wanaCustomText +
                        "myPrice: " + myPrice;
    }

}
