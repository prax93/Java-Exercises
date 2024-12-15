package WordCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {

    public static void main(String[] args) {
        // Überprüfen, ob der Benutzer eine Datei angegeben hat
        if (args.length != 1) {
            System.out.println("Bitte geben Sie den Dateinamen als Argument an.");
            return;
        }

        String filename = args[0];

        try {
            // Dateiinhalt lesen
            String text = Files.readString(Paths.get(filename));

            // Anzahl der Buchstaben berechnen
            int letterCount = countLetters(text);

            // Anzahl der Wörter berechnen
            int wordCount = countWords(text);

            // Anzahl der Zeilen berechnen
            int lineCount = countLines(text);

            // Ergebnisse ausgeben
            System.out.println("Anzahl der Buchstaben: " + letterCount);
            System.out.println("Anzahl der Wörter: " + wordCount);
            System.out.println("Anzahl der Zeilen: " + lineCount);
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }

    // Methode zur Zählung der Buchstaben
    private static int countLetters(String text) {
        int letterCount = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
            }
        }
        return letterCount;
    }

    // Methode zur Zählung der Wörter
    private static int countWords(String text) {
        // Ein Wort ist eine zusammenhängende Folge von Buchstaben
        Pattern wordPattern = Pattern.compile("\\b[A-Za-zÄÖÜäöüß]+\\b");
        Matcher matcher = wordPattern.matcher(text);
        int wordCount = 0;
        while (matcher.find()) {
            wordCount++;
        }
        return wordCount;
    }

    // Methode zur Zählung der Zeilen
    private static int countLines(String text) {
        // Zeilen werden durch das Zeilenumbruchzeichen '\n' getrennt
        return (int) text.lines().count();
    }
}