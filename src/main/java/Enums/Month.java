package Enums;

public enum Month {

    JAN(31),
    FEB(28),
    MAR(30),
    APR(31);

    private final int days;

    private Month(int days){
        this.days = days;
    }

    public int getMonthDays(){
        return days;
    }

}
