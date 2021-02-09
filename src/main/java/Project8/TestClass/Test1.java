package Project8.TestClass;

import Project8.Mortgage.HousePrices;
import Project8.Mortgage.StatesTax;
import org.junit.Assert;
import org.junit.Test;

public class Test1 {

    @Test
    public void test1(){

        HousePrices housePrices= new HousePrices("Fernando" , "new" ,  "Apartment" ,3 ,40000 ,30 , StatesTax.OHIO);

        Assert.assertEquals("Fernando",housePrices.getUsername());

        int total = housePrices.getPriceTotal();
        int eachMonth = housePrices.getPriceEachMonth();

        Assert.assertEquals("Result should be 123200 but your result is " + total, 123200, total);
        Assert.assertEquals("Result should be 2773 but your result is " +eachMonth, 2773, eachMonth);

    }

    @Test
    public void test2(){

        HousePrices housePrices= new HousePrices("David" , "LikeNew"  , "House" ,5 ,50000 ,30 , StatesTax.NEWYORK);

        Assert.assertEquals("David",housePrices.getUsername());

        int total = housePrices.getPriceTotal();
        int eachMonth = housePrices.getPriceEachMonth();

        Assert.assertEquals("Result should be 168000 but your result is " + total, 168000, total);
        Assert.assertEquals("Result should be 3933 but your result is " +eachMonth, 3933, eachMonth);

    }

    @Test
    public void test3(){

        HousePrices housePrices= new HousePrices("Emily" , "Old" ,  "condo" ,4,30000 ,36 , StatesTax.FLORIDA);

        Assert.assertEquals("Emily",housePrices.getUsername());

        int total = housePrices.getPriceTotal();
        int eachMonth = housePrices.getPriceEachMonth();

        Assert.assertEquals("Result should be 115500 but your result is " + total, 115500, total);
        Assert.assertEquals("Result should be 2375 but your result is " +eachMonth, 2375, eachMonth);


    }

    @Test
    public void test4(){

        HousePrices housePrices= new HousePrices("Rinda" , "Renew Required" ,  "condo" ,1,50000 ,35 , StatesTax.NEWJERSEY);

        Assert.assertEquals("Rinda",housePrices.getUsername());

        int total = housePrices.getPriceTotal();
        int eachMonth = housePrices.getPriceEachMonth();

        Assert.assertEquals("Result should be 74750 but your result is " + total, 74750, total);
        Assert.assertEquals("Result should be 707 but your result is " +eachMonth, 707, eachMonth);

    }
}
