package Clock;

public class Main {

    public static void main (String[] args){

        EnglishClock engClock = new EnglishClock();
        IsoClock isoClock = new IsoClock();

        System.out.println(engClock.getTime());
        System.out.println(isoClock.getTime());

    }
}
