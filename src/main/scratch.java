// Klasse zur Überprüfung von Dezimalzahlen
package Validator;

import java.util.Scanner;

// ValidatorTest: Die Hauptklasse mit der main-Methode
public class ValidatorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        while (true) {
            System.out.print("Geben Sie einen String ein (oder leer für Beenden): ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }

            try {
                validator.validate(input);
                System.out.println("Gültig");
            } catch (ValidationException e) {
                System.out.println("Ungültig: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

// Die Validator-Klasse führt die Validierung durch
class Validator {
    private State state = new State0(); // Startzustand

    public void validate(String input) throws ValidationException {
        if (input.isEmpty()) {
            throw new ValidationException("Eingabe darf nicht leer sein");
        }

        for (char c : input.toCharArray()) {
            state = state.process(c); // Zustandsübergang
        }

        if (!state.isAccepting()) {
            throw new ValidationException("Endzustand ist nicht akzeptierend");
        }
    }
}

// Abstrakte Basisklasse für Zustände
abstract class State {
    private boolean accepting;

    public boolean isAccepting() {
        return accepting;
    }

    protected void setAccepting(boolean accepting) {
        this.accepting = accepting;
    }

    public abstract State process(char c) throws ValidationException;
}

// Exception-Klasse für Validierungsfehler
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

// Zustand S0 (Startzustand)
class State0 extends State {
    public State0() {
        setAccepting(false);
    }

    @Override
    public State process(char c) throws ValidationException {
        if (c == '+' || c == '-') {
            return new State1();
        } else if (Character.isDigit(c)) {
            return new State2();
        }
        throw new ValidationException("Ungültiges Zeichen in State0: " + c);
    }
}

// Zustand S1 (nach einem Vorzeichen)
class State1 extends State {
    public State1() {
        setAccepting(false);
    }

    @Override
    public State process(char c) throws ValidationException {
        if (Character.isDigit(c)) {
            return new State2();
        }
        throw new ValidationException("Ungültiges Zeichen in State1: " + c);
    }
}

// Zustand S2 (nach einer Ziffer)
class State2 extends State {
    public State2() {
        setAccepting(true);
    }

    @Override
    public State process(char c) throws ValidationException {
        if (Character.isDigit(c)) {
            return this; // Bleibt in State2
        } else if (c == '.') {
            return new State3();
        }
        throw new ValidationException("Ungültiges Zeichen in State2: " + c);
    }
}

// Zustand S3 (nach einem Dezimalpunkt)
class State3 extends State {
    public State3() {
        setAccepting(false);
    }

    @Override
    public State process(char c) throws ValidationException {
        if (Character.isDigit(c)) {
            return new State4();
        }
        throw new ValidationException("Ungültiges Zeichen in State3: " + c);
    }
}

// Zustand S4 (nach Ziffern hinter einem Dezimalpunkt)
class State4 extends State {
    public State4() {
        setAccepting(true);
    }

    @Override
    public State process(char c) throws ValidationException {
        if (Character.isDigit(c)) {
            return this; // Bleibt in State4
        }
        throw new ValidationException("Ungültiges Zeichen in State4: " + c);
    }
}
