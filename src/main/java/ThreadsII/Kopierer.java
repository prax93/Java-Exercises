package ThreadsII;

import java.io.*;

public class Kopierer extends Thread {

    private String filePath;

    public Kopierer(){

    }

    @Override
    public void run() {

        try(FileInputStream input = new FileInputStream(new File(filePath));
        FileOutputStream output = new FileOutputStream(new File("copy.jpg"))){

            byte[] buffer = new byte[100];

            while(true){
                int readbytes = input.read(buffer);


                if(readbytes == -1){
                    break;
                }
                output.write(buffer, 0, readbytes);
            }


        }
        catch (IOException e){

        }


    }


    public void setFilePath(String path) {
        this.filePath = path;
    }

}
