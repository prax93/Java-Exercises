package Validator;

public class State0 extends State {

    public State0(){
        super();
    }

    @Override
    public State process(char c) throws ValidationException {

        if (c == '+' || c == '-') {
            //this.setAccepting(true);
            return new State1();
        }
        else if (this.getNumbersCharArray().contains(c)) {
            return new State1();
        }
/*        else if(c == '.'){
            return new State2();
        }*/

        throw new ValidationException("Error: State0");
    }

}
