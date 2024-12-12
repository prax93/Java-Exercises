package Validator;

import java.util.List;

public abstract class State {

    private boolean accepting;

    private final String numbers = "0123456789";

    private final List<Character> numbersCharArray = numbers.chars().mapToObj(i -> (char) i).toList();

    public boolean isAccepting() {
        return accepting;
    }

    public abstract State process(char c) throws ValidationException;

    public List<Character> getNumbersCharArray() {
        return numbersCharArray;
    }

    public void setAccepting(boolean accepting) {
        this.accepting = accepting;
    }
}
