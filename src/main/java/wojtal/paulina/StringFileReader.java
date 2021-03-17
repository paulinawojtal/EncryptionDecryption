package wojtal.paulina;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class StringFileReader {

    public static String getDataFromFile(String[] input) {
        int fileIndex = Arrays.asList( input ).indexOf( "-in") + 1;

        String directory = Paths.get("").toAbsolutePath().toString();

        String filePath = input[fileIndex];

        try (Scanner scanner = new Scanner(new File( filePath ) )) {

            return scanner.nextLine();

        } catch (FileNotFoundException e) {
            System.out.println("Error. File doesn't exist.");
        }
        return "";
    }
}
