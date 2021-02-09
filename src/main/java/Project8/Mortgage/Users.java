package Project8.Mortgage;

public class Users {
  /*
            Create  following private variables
            String username
            String WhichCondition
            String houseType
            int roomCount
            int downPayment
            int longTerm
            StatesTax statesTax;
        Create a constructor  using all the variables.
         */

    private String username, WhichCondition, houseType;
    private int roomCount, downPayment, longTerm;
    private StatesTax statesTax;

    public Users(String username, String WhichCondition, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        this.username = username;
        this.WhichCondition = WhichCondition;
        this.houseType = houseType;
        this.roomCount = roomCount;
        this.downPayment = downPayment;
        this.longTerm = longTerm;
        this.statesTax = statesTax;
    }

/*
    Create the read-only method of the all variables
     */

    public String getUsername() {
        return username;
    }

    public String getWhichCondition() {
        return WhichCondition;
    }

    public String getHouseType() {
        return houseType;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public int getLongTerm() {
        return longTerm;
    }

    public StatesTax getStatesTax() {
        return statesTax;
    }
}

