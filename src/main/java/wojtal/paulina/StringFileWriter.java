package wojtal.paulina;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringFileWriter {

    public static void writeOutputToFile(String path, String outputString) {

        try (FileWriter fileWriter = new FileWriter(path)) {

            fileWriter.write(outputString);

        } catch (IOException e) {
            System.out.println("Unable to save result to a file");
        }
    }
}
