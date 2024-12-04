package Statics;

public class User {

    private static String color = "Black";
    private int age;
    private String name;


    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setColor(String color) {
        User.color = color;
    }


    public static String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
