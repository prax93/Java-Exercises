package Threads1;

import java.util.Scanner;

public class StopWatch {

    public static void main (String[] args) throws InterruptedException {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Hit anything to start the timer");
        userInput.nextLine();

        Timer timer = new Timer();
        timer.start();

        System.out.println("Press Enter to stop the timer...");
        userInput.nextLine(); // Warte auf die zweite Eingabe

        timer.interrupt(); // Unterbreche den Timer-Thread
        try {
            timer.join(); // Warte darauf, dass der Timer-Thread beendet wird
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Timer has been stopped.");
        userInput.close();


    }
}
