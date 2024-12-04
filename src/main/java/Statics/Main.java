package Statics;

public class Main {

    public static void main(String[] args){


        User black = new User("Shana", 31);
        User white = new User("Alessia", 25);

        black.setColor("pink");
        white.setColor("blue");


        System.out.println(User.getColor());



    }
}
