package ThreadsII;

public class Printer extends Thread {

    private Boolean finished = false;
    private Printer printer ;
    private long size = 0;
    private Kopierer kopierer;


    public Printer(Kopierer kopierer){
        this.kopierer = kopierer;
    }
    @Override
    public void run(){

        try{
            while(!finished){
                System.out.println("Copied: "+ size + "Bytes");
                Thread.sleep(5000);
            }
        }
        catch (InterruptedException e){
            System.out.println("Copy Thread Interrupted due to exception");
        }

    }


    public void setFinished(Boolean finished){
        this.finished = finished;
    }

    public void setSize(long copiedSize){
        this.size = copiedSize;
    }



}
