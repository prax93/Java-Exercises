package Threads1;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {

    private LocalTime startTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Timer(){
        this.startTime = LocalTime.now();
    }
    @Override
    public void run() {
        while(!currentThread().isInterrupted()){
            startTime = LocalTime.now();
            System.out.println(formatter.format(startTime)+ " " + this.currentThread().getName());
            try {
                System.out.print('\u000C');
                Thread.sleep(1000);// Ausgabe alle 1 Sekunde
            } catch (InterruptedException e) {
                // Unterbrechung des Threads erkannt
                Thread.currentThread().interrupt(); // set the interrupt flag again
            }
        }
    }



}
