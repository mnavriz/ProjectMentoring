/*package Project7.bankAccount;


import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Users {

    /*
        Create instance variables String ( name, password ,dateOfBirth, marriageStatus,  relativeName, relativeAge, isTransferedSuceesfully)
        Create int  variables (accountNumber ,amountAccount1, accountNumber2, amountAccount2)
        all public
     */
   /* public String name, password, dateOfBirth, marriageStatus, relativeName, relativeDoB, isTransferedSuceesfully;
    public int accountNumber, amountAccount1, accountNumber2, amountAccount2;

    /*
    NOTE:
    Before the constructor create the methods which given under the constructor and than come back to create the constructor
     */
//
    /*
    Create a constructor
    Parameters are String name , password , dateOfBirth , marriageStatus
    int amountAccount1 , amountAccount2
    instance variable name equals to parameter name
    same for password
    same for amountAccount1
    same for amountAccount2
    Following also in the constructor
    variable accountNumber get the the number from the  randomNumberCreator method
    variable accountNumber2 get the the number from the  randomNumberCreator method
    variable marriageStatus equals to CheckMariageStatus method return
    variable dateOfBirth equals to checkAge method return
     */

   /* public Users(String name, String password, String dateOfBirth, String marriageStatus, int amountAccount1, int amountAccount2) {
        this.amountAccount1 = amountAccount1;
        this.amountAccount2 = amountAccount2;
        this.name = name;
        this.password = password;
        this.accountNumber = randomNumberCreator();
        do {
            this.accountNumber2 = randomNumberCreator();
        } while (accountNumber == accountNumber2);
        this.marriageStatus = CheckMariageStatus(marriageStatus);
        this.dateOfBirth = checkAge(dateOfBirth);


    }


    /*
        Create method name is  CheckMariageStatus
        parameter is String(marriageStatus)
        return type is String
        if String marriageStatus equals married
        Ask to user (use scanner class)
        Do you want to add add your relative?
        if the user says Yes
        Ask to user
        What is your relative name?
        Ask to user
        Date of birth relative?
        Then Add the relative(Use AddRelative class ) (Hint create an object of AddRelative class)
        relativeName variable equals to AddRelative class fullName
        relativeDoB variable equals to AddRelative class relativeDoB
            if relativeDoB equals to "0"
                then change the relativeName to "Relative should be more then 18 years old";
                then change the relativeDoB to "Relative should be more then 18 years old";
                return the "Relative should be more then 18 years old";
            if the relativeDoB is not equal to "0"
               return "Transaction done successfully"
        If the user say No
        then return no need to add relative.
     */

//    relative;

  /*/  public String CheckMariageStatus(String marriageStatus) {
        if (marriageStatus.equals("married")) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Do you want to add your relative?");
            String wannaAdd = keyboard.next();
            if (wannaAdd.equals(("Yes"))) {
                System.out.println("What is your relative name?");
                relativeName = keyboard.next();
                System.out.println("Date of birth relative?");
                relativeDoB = keyboard.next();
                AddRelative relative = new AddRelative(relativeName, relativeDoB);
                if (relative.relativeDoB.equals("0")) {
                    relative.fullName = "Relative should be more then 18 years old";
                    return relativeDoB = "Relative should be more then 18 years old";
                } else {
                    return "Transaction done successfully";
                }
            }
        }
        return "";
    }




    /*
        Create a static method name is checkAge
        parameter is one String(myDOB)
        return type is String
        Compare today's date to myDOB
        if myDOB compare to today date is greater than  18 then return "You can get a credit card"
        if myDOB compare to today date is less then 18 "You should be at least 18 years old to get a credit card."
        if myDOB compare to today date equals 18 then you need to compare the months.(use nested if)
        if today's monthvalue is greater than myDOB's monthvalue return "You can get a credit card"
        if today's monthvalue is less than myDOB's monthvalue return "You should be at least 18 years old to get a credit card."
        if today's monthvalue is equal to myDOB's monthvalue , you need to compare day of the months. (use nested if)
        If today's amount of day is greater than myDOB's amount of days return "You can get a credit card"
        else return "You should be at least 18 years old to get a credit card."
        For example today date is 10/05/2020
        if myDOB is 09/05/2002
        return should be  "You can get a credit card"
        if myDOB is 11/05/2002
        return should be  "You should be at least 18 years old to get a credit card."
        Hint: Use LocalDate and Period classes,
     */

  /*  public static String checkAge(String myDOB) {

        boolean isEligible = false;
        String[] dob = myDOB.split("/");

        int yearDifference = LocalDate.now().getYear() - Integer.parseInt(dob[2]);
        if (yearDifference > 18) {
            isEligible = true;
        } else if (yearDifference == 18) {
            int monthDifference = LocalDate.now().getMonthValue() - Integer.parseInt(dob[0]);
            if (monthDifference > 0) {
                isEligible = true;
            } else if (monthDifference == 0) {
                int dayDifference = LocalDate.now().getDayOfMonth() - Integer.parseInt(dob[1]);
                if (dayDifference >= 0) {
                    isEligible = true;
                }
            }
        }
        if (isEligible) {
            return "You can get a credit card";
        } else {
            return "You should be at least 18 years old to get a credit card.";
        }
    }


    /*
        Create a randomNumberCreator method  which is returning 8 digit number
            it should be between 10_000_000 - 99_999_999
            return type is int
     */
  /*  public int randomNumberCreator() {
        Random rdm = new Random();
        return 10_000_000 + rdm.nextInt(90_000_000);
    }


    /*
        Create a method name is transfer
        Parameters are two Users(own, other) object
        Return type is void
        In this method
            First ask to user "Do you want to transfer between your accounts or different user" (use scanner class)
        if the answer is own
        Ask to user "Enter amount of money you want to enter"
       this amount will be your transferAmount to use for the transferToOwnAccount method that below
           instance variable isTransferedSuceesfully equals to the the method transferToOwnAccount in the Account class
        if the answer different
        Ask to user "Enter amount of money you want to enter"
        this amount will be your transferAmount to use for the transferOtherUser method that below
         instance variable isTransferedSuceesfully equals to the the method transferOtherUser in the Account class
     */

  /*  public void transfer(Users own, Users other) {

        System.out.println("Do you want to transfer between your accounts or different user");
        Scanner keybord = new Scanner(System.in);
        String accountType = keybord.next();

        if (accountType.equals("own")) {
            System.out.println("Enter amount of money you want to enter");
            int transferAmount = keybord.nextInt();
            isTransferedSuceesfully = Account.transferToOwnAccount(own, transferAmount);
        }

        if (accountType.equals("different")) {
            System.out.println("Enter amount of money you want to enter");
            int transferAmount = keybord.nextInt();
            isTransferedSuceesfully = Account.transferOtherUser(own, other, transferAmount);
        }
    }

    /*
        Print the objects using toString method
        like
         return "\nname: " + name +
                "\npassword: " + password+
                "\ndateOfBirth: " + dateOfBirth+
                ......
     */

  /*  public String toString() {
        return "\nname: " + name +
                "\npassword: " + password +
                "\ndateOfBirth: " + dateOfBirth +
                "\nmarriageStatus: " + marriageStatus +
                "\naccountNumber: " + accountNumber +
                "\namount in account 1 : " + amountAccount1 +
                "\naccountNumber2: " + accountNumber2 +
                "\namount in account 2 : " + amountAccount2 +
                "\nrelativeName: " + relativeName +
                "\nrelativeAge: " + relativeDoB;
    }

}*/