package wojtal.paulina;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFileReaderTest {

    @Test
    void getDataFromFile() {

        String[] message = {"java", "Main", "-mode", "enc", "-in", "road_to_treasure.txt", "-out", "protected.txt", "-key", "5", "-alg", "unicode"};

        String resultString = StringFileReader.getDataFromFile(message);

        assertEquals("Welcome to hyperskill!", resultString);
    }
}