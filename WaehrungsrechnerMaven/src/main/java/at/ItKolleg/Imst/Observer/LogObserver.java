package at.ItKolleg.Imst.Observer;
import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogObserver implements Observer{

    private Path logPath;

   private static final String LOG_DIRECTORY = "logs";
   private static final String LOG_FILE_NAME = "logdatei.txt";

    public LogObserver() {
        this.logPath = Paths.get(LOG_DIRECTORY, LOG_FILE_NAME).toAbsolutePath();
        try {
            Files.createDirectories(logPath.getParent());
            if (Files.notExists(logPath)){
                Files.createFile(logPath);
            }
        }catch (IOException e){
            throw new RuntimeException("Fehler beim Erstellen der Log-Datei" + logPath,e);
        }
    }

    @Override
    public void update(String message) {
        String logEntry = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " - "
                + message + System.lineSeparator();
        try {
            Files.writeString(logPath, logEntry, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Fehler beim Schreibem in die Log-Datei " + e.getMessage());
        }
    }
}
