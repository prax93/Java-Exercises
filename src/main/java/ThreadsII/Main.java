package ThreadsII;

import java.io.File;
import java.security.KeyPair;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();

        Kopierer kopierer = new Kopierer();
        kopierer.setFilePath(filePath);

        Printer printer = new Printer(kopierer);
        printer.setSize(new File("/Users/prashanthsritharan/Private/Coding/Java-Exercises/copy.jpg").length());


        kopierer.start();

        printer.start();



        String cancel = input.nextLine();

        if(cancel.equals("c")){
            kopierer.interrupt();
        }


    }
}
