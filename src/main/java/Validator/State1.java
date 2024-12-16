package Validator;

import java.util.List;

public class State1 extends State{


    @Override
    public State process(char c) {

        if(this.getNumbersCharArray().contains(c)){
            //this.setAccepting(true);
            return new State1();
        }
        else
        {
            return new State2();
        }

    }

}
