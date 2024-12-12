package Validator;

public class State3 extends State{


    @Override
    public State process(char c) throws ValidationException{
        if(this.getNumbersCharArray().contains(c)){
            return new State4();
        }
        else{
            throw new ValidationException("Error: State3");
        }

    }

}
