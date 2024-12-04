package Clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EnglishClock implements Clock{
    LocalTime localTime = LocalTime.now();

    public EnglishClock(){
    }

    @Override
    public String getTime(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return this.localTime.format(formatter);
    }
}
