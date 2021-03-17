package wojtal.paulina;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringFileWriterTest {

    @Test
    void writeOutputToFile( @TempDir Path tempDir ) throws IOException {
        String[] message = {"java", "Main", "-mode", "enc", "-in", "road_to_treasure.txt", "-out", "protected.txt", "-key", "5", "-alg", "unicode"};
        String outputString = "\\jqhtrj%yt%m~ujwxpnqq&";

        String fileName = "protected.txt";
        Path path = tempDir.resolve(fileName);

        StringFileWriter.writeOutputToFile(path.toString(), outputString);

        assertAll(
                () -> assertTrue( Files.exists(path)),
                () -> assertLinesMatch( Stream.of(outputString).collect( Collectors.toList()), Files.readAllLines(path))
        );
    }
}