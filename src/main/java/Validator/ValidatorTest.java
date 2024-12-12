package Validator;

import java.util.Scanner;

public class ValidatorTest {

    public static void main (String[] args){

        Scanner input = new Scanner(System.in);
        Validator validator = new Validator();

            String userInput = input.nextLine();

            if(!userInput.isEmpty()){

                try {
                    validator.validate(userInput);
                }
                catch (ValidationException e){
                    System.out.println(e.getMessage());

                }



        }


    }

}
