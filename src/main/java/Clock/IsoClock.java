package Clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IsoClock implements Clock{

    private LocalTime localTime = LocalTime.now();;

    public IsoClock(){

    }

    @Override
    public String getTime(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String time = localTime.format(formatter);
        return time;


    }


}
