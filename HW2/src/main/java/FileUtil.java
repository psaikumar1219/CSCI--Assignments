import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static CSVWriter getCSVWriter(String filepath) throws IOException {
        createFile(filepath);
        FileWriter fileWriter = new FileWriter(filepath);
        return new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,
                             CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
    }

    public static void createFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        Files.deleteIfExists(path);
        Files.createFile(path);
    }

    public static String cleanUrl(String url) {
        return url.replace(",", "-");
    }

}
