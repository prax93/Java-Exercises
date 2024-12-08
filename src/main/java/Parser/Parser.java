package Parser;

import java.util.Scanner;

public class Parser {

    public static void main (String[] args){

        try {
            int decimal = parse(args[0]);
            System.out.println(decimal);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public static int parse(String input) throws ParserException {

        char[] byteCharArray = input.toCharArray();
        Character[] reversedCharArray = new Character[byteCharArray.length];
        int counter = 0;
        int sum = 0;

        // Check for Empty input and throw Error
        if(input.isEmpty() || input.isBlank()){
            throw new IllegalArgumentException("Null Value");
        }

        // Reverse the CharArray and safe it into a new array
        for (int i = byteCharArray.length -1; i >= 0 ; i--) {
            reversedCharArray[counter] = byteCharArray[i];
            counter++;
        }

        // Check for char Value and Calculate Decimal Value
        for(int i = 0; i <= reversedCharArray.length -1; i++){
            char tmpChar = reversedCharArray[i];
            if(tmpChar == '1'){
                sum += (int) Math.pow(2, i);
            }

            if( tmpChar != '1' && tmpChar != '0'){
                throw new ParserException("Exception Thrown: ByteString contains different letters");
            }
        }

        return sum;

    }
}
