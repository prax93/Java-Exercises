package Validator;

import java.util.List;

public class State1 extends State{


    @Override
    public State process(char c) throws ValidationException {

        if(this.getNumbersCharArray().contains(c) || c == '.'){
            //this.setAccepting(true);
            return new State2();
        } else{
            throw new ValidationException("Error: State1");
        }



    }

}
