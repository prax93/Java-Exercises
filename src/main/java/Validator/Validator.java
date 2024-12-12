package Validator;


public class Validator {

    private State state = new State0();


    public void validate(String input) throws ValidationException {

        if(!input.isEmpty()){
            for(char c: input.toCharArray()){
                state = state.process(c);

            }
        }
    }
}
