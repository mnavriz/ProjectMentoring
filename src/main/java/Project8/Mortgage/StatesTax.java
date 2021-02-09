package Project8.Mortgage;

/*
     Create a enum name is StatesTax
         Add Enumerated data types as
             NEWYORK amount of the tax 20
             NEWJERSEY amount of the tax 15
             FLORIDA amount of the tax 5
             OHIO amount of the tax 12
             create a private vairable int tax;
             create the constructor
             create a read method of the tax
 */
public enum StatesTax {

    NEWYORK(20), NEWJERSEY(15), FLORIDA(5), OHIO(12);

    private int percent;

    StatesTax(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return this.percent;
    }
}


