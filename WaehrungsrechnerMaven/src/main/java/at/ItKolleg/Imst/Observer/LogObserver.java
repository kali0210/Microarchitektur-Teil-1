package at.ItKolleg.Imst.Observer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;

public class LogObserver implements Observer {
    private String logFilePath;
    private static final String LOG_FILE_NAME = "logdatei.txt";

    public LogObserver() {

        this.logFilePath = LOG_FILE_NAME;

        try {
            File logFile = new File(logFilePath);

            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Erstellen der Log-Datei: " + logFilePath, e);
        }
    }

    @Override
    public void update(String message) {
        String logEntry = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " - " + message + System.lineSeparator();

        try {
            try (FileWriter writer = new FileWriter(this.logFilePath, true)) {

                writer.write(logEntry);
                System.out.println("Nachricht  in Log-Datei geschrieben: " + message);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Log-Datei: " + e.getMessage());
        }
    }
}
