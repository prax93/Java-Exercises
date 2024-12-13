package CodeZeilen;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

    public class JavaLineCounter {
        public static void main(String[] args) {
            // Verzeichnis angeben
            Path startDir = Paths.get("./src"); // Beispielpfad, anpassen falls nötig

            try {
                // Verzeichnis traversieren
                Files.walkFileTree(startDir, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        // Nur .java-Dateien analysieren
                        if (file.toString().endsWith(".java")) {
                            countLines(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void countLines(Path file) {
            int emptyLines = 0;
            int commentLines = 0;
            int annotationLines = 0;
            int codeLines = 0;

            try {
                // Dateiinhalt lesen
                List<String> lines = Files.readAllLines(file);

                for (String line : lines) {
                    line = line.trim(); // Leerzeichen entfernen

                    if (line.isEmpty()) {
                        // Leerzeile
                        emptyLines++;
                    } else if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*")) {
                        // Kommentarzeile
                        commentLines++;
                    } else if (line.startsWith("@")) {
                        // Annotation
                        annotationLines++;
                    } else {
                        // Codezeile
                        codeLines++;
                    }
                }

                // Ergebnisse für diese Datei ausgeben
                System.out.println("Datei: " + file);
                System.out.println("Leerzeilen: " + emptyLines);
                System.out.println("Kommentarzeilen: " + commentLines);
                System.out.println("Annotationen: " + annotationLines);
                System.out.println("Codezeilen: " + codeLines);
                System.out.println();

            } catch (IOException e) {
                System.err.println("Fehler beim Lesen der Datei: " + file);
                e.printStackTrace();
            }
        }
    }


