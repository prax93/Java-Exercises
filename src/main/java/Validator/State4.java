package Validator;

public class State4 extends State {



    @Override
    public State process(char c) throws ValidationException {
        if(this.getNumbersCharArray().contains(c)){
            return this;
        }
        else{
            throw new ValidationException("Invalid Input");
        }
    }
}
