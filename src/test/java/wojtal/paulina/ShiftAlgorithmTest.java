package wojtal.paulina;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftAlgorithmTest {

    @Test
    void encrypt1() {
        ShiftAlgorithm shiftAlgorithm = new ShiftAlgorithm();
        String resultString = shiftAlgorithm.encrypt("Welcome to hyperskill!", 5);

        assertEquals("Bjqhtrj yt mdujwxpnqq!", resultString);
    }

    @Test
    void encrypt2() {
        ShiftAlgorithm shiftAlgorithm = new ShiftAlgorithm();
        String resultString = shiftAlgorithm.encrypt("Bjqhtrj yt mdujwxpnqq!", 21);

        assertEquals("Welcome to hyperskill!", resultString);
    }

    @Test
    void decrypt1() {
        ShiftAlgorithm shiftAlgorithm = new ShiftAlgorithm();
        String resultString = shiftAlgorithm.decrypt("Bjqhtrj yt mdujwxpnqq!", 5);

        assertEquals("Welcome to hyperskill!", resultString);
    }

    @Test
    public void decrypt2() {
        ShiftAlgorithm shiftAlgorithm = new ShiftAlgorithm();
        String resultString = shiftAlgorithm.decrypt("Welcome to hyperskill!", 21);

        assertEquals("Bjqhtrj yt mdujwxpnqq!", resultString);
    }
}