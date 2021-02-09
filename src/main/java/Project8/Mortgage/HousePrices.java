package Project8.Mortgage;

public class HousePrices extends Users {
   /*
            This class is extending the Users class
            1 private int variable price
     */

    private int price;

    public HousePrices(String username, String WhichCondition, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        super(username, WhichCondition, houseType, roomCount, downPayment, longTerm, statesTax);

    }

    /*
        Create a method name is roomCountToPrice
        no parameter
        no return type
        if the roomCount in the Users class equal to 0
            add 10000 to price
        if the roomCount in the Users class equal to 1
            add 20000 to price
        if the roomCount in the Users class equal to 2
            add 30000 to price
        if the roomCount in the Users class equal to 3
            add 40000 to price
        if the roomCount in the Users class equal to 4
            add 50000 to price
        if the roomCount in the Users class equal to 5
            add 60000 to price
     */

    public void roomCountToPrice() {
        price += (getRoomCount() + 1) * 10000;
    }

    /*
        Create a method name is ConditionToPrice
        no parameter
        no return type
            if WhichCondition variable in the Users class equal to "new"
                add 50000 to price
            if WhichCondition variable in the Users class equal to "LikeNew"
                add 40000 to price
            if WhichCondition variable in the Users class equal to "Old"
                add 30000 to price
            if WhichCondition variable in the Users class equal to "Renew Required"
                add 15000 to price
     */

    public void ConditionToPrice() {
        switch (getWhichCondition()) {
            case "new":
                price += 50000;
                break;
            case "LikeNew":
                price += 40000;
                break;
            case "Old":
                price += 30000;
                break;
            case "Renew Required":
                price += 15000;
                break;
        }
    }


    /*
        Create a method name is houseTypeToPrice
        no parameter
        no return type
            if HouseType is equal to "Apartment"
                add 20000 to price
            if HouseType is equal to "condo"
                add 30000 to price
            if HouseType is equal to "House"
                add 40000 to price
     */

    public void houseTypeToPrice() {
        switch (getHouseType()) {
            case "Apartment":
                price += 20000;
                break;
            case "condo":
                price += 30000;
                break;
            case "House":
                price += 40000;
                break;
        }
    }

    /*
            Create a method name is getPriceTotal
            return type is int
            Return the total price(housetype, condition and roomcount prices)
            Also you need to calculate the tax and add  to the price
            For the tax percentage use the StatesTax enum
     */

    public int getPriceTotal() {
        roomCountToPrice();
        ConditionToPrice();
        houseTypeToPrice();
        int percent = getStatesTax().getPercent();
        price = price + price * percent / 100;
        return price;
    }


    /*
        Create a method name is getPriceEachMonth
            Return the monthly payment amount.
            reduce the downpayment and calculate the each month's payment
     */

    public int getPriceEachMonth() {
        return (getPriceTotal() - getDownPayment() ) / getLongTerm();
    }
}
