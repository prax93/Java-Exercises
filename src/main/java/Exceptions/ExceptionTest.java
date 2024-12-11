package Exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            System.out.print("1");
            foo();
            System.out.print("2");
        }
        catch (Exception e) {
            System.out.print("3");
        }
        finally {
            System.out.print("4");
        }
        System.out.print("5");
    }
    public static void foo() throws Exception {
        try {
            System.out.print("6");
            if (true) throw new Exception();
            System.out.print("7");
        }
        catch (Exception e) {
            System.out.print("8");
        }
        finally {
            System.out.print("9");
        }
        System.out.print("10");
    }
}
