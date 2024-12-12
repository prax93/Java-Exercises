package Validator;

public class State2 extends State{


    @Override
    public State process(char c) throws ValidationException {

        if(c == '.'){
            //this.setAccepting(true);
            return new State3();
        }
        else if(this.getNumbersCharArray().contains(c)){
            return new State3();
        }
        throw new ValidationException("Error: State2");
    }
}
