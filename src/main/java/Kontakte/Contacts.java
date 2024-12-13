package Kontakte;

import java.io.*;
import java.util.*;

public class Contacts {

    public static void main(String[] args) throws IOException{
        // Überprüfen, ob der Pfad zur CSV-Datei als Argument übergeben wurde
        if (args.length != 1) {
            throw new IOException("Kein Pfad angegeben");
        }

        String filePath = args[0];

        // Anzeigen der bestehenden Kontakte
        readContacts(filePath);

        // Scanner für Benutzereingaben
        Scanner scanner = new Scanner(System.in);

        // Eingabe eines neuen Kontakts
        System.out.println("\nMöchten Sie einen neuen Kontakt hinzufügen? (ja/nein)");
        String answer = scanner.nextLine();

        if ("ja".equalsIgnoreCase(answer)) {
            System.out.println("Geben Sie den Namen des Kontakts ein:");
            String name = scanner.nextLine();
            System.out.println("Geben Sie die Telefonnummer ein:");
            String phone = scanner.nextLine();
            System.out.println("Geben Sie die E-Mail-Adresse ein:");
            String email = scanner.nextLine();

            // Hinzufügen des neuen Kontakts zur Datei
            addContact(filePath, name, phone, email);
        }

        // Schließen des Scanners
        scanner.close();
    }

    // Methode zum Lesen der CSV-Datei und Anzeigen der Kontakte
    public static void readContacts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Kontakte aus der Datei:");
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(",");
                System.out.println("Name: " + contact[0] + ", Telefon: " + contact[1] + ", E-Mail: " + contact[2]);
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }

    // Methode zum Hinzufügen eines neuen Kontakts zur CSV-Datei
    public static void addContact(String filePath, String name, String phone, String email) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(name + "," + phone + "," + email);
            bw.newLine();
            System.out.println("Neuer Kontakt wurde hinzugefügt.");
        } catch (IOException e) {
            System.out.println("Fehler beim Hinzufügen des Kontakts: " + e.getMessage());
        }
    }


}
