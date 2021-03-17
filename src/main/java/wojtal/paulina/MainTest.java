package wojtal.paulina;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final InputStream systemIn = System.in;
    private static final PrintStream systemOut = System.out;

    private MessageChecker messageChecker;

    @Test
    public void checkNoMode() {
        String[] message = {"java", "Main", "-key", "5", "-data", "Welcome to hyperskill!", "-alg", "unicode"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", resultString);
    }

    @Test
    public void checkNoKey() {
        String[] message = {"java", "Main", "-mode", "enc", "-data", "Welcome", "-alg", "unicode"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("Welcome", resultString);
    }

    @Test
    public void checkNoDataNoIn() {
        String[] message = {"java", "Main", "-key", "5", "-alg", "shift", "-mode", "enc"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("", resultString);
    }

    @Test
    public void checkDataAndIn() {
        String[] message = {"java", "Main", "-in", "road_to_treasure.txt", "-key", "5", "-alg", "shift", "-data", "Welcome to hyperskill!", "-mode", "enc"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("Bjqhtrj yt mdujwxpnqq!", resultString);
    }

    @Test
    public void checkPrintOutput() {
        String[] message = {"java", "Main", "-in", "road_to_treasure.txt", "-key", "5", "-alg", "shift", "-data", "Welcome to hyperskill!", "-mode", "enc"};
        String expected = "Bjqhtrj yt mdujwxpnqq!";
        messageChecker = new MessageChecker(message);

        String resultString = Main.input(messageChecker, message);

        final ByteArrayInputStream testInput = new ByteArrayInputStream(expected.getBytes());
        System.setIn(testInput);

        PrintStream saveOut = System.out;
        final ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        Main.writeOutput(message, resultString, messageChecker);

    }


    @Test
    public void checkFileInOut(){
        String[] message = {"java", "Main", "-mode", "enc", "-in", "road_to_treasure.txt", "-out", "protected.txt", "-key", "5", "-alg", "unicode"};
        messageChecker = new MessageChecker(message);
        Main.input(messageChecker, message);
    }

    @Test
    public void checkFileIn(){
        String[] message = {"java", "Main", "-mode", "enc", "-in", "road_to_treasure.txt", "-out", "protected.txt", "-key", "5", "-alg", "unicode"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", resultString);
    }

    @Test
    public void checkUnicodeEncMode() {
        String[] message = {"java", "Main", "-mode", "enc", "-key", "5", "-data", "Welcome to hyperskill!", "-alg", "unicode"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", resultString);
    }

    @Test
    public void checkUnicodeDecMode() {
        String[] message = {"java", "Main", "-key", "5", "-alg", "unicode", "-data", "\\jqhtrj%yt%m~ujwxpnqq&", "-mode", "dec"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("Welcome to hyperskill!", resultString);
    }

    @Test
    public void checkShiftEncMode() {
        String[] message = {"java", "Main", "-key", "5", "-alg", "shift", "-data", "Welcome to hyperskill!", "-mode", "enc"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("Bjqhtrj yt mdujwxpnqq!", resultString);
    }

    @Test
    public void checkShiftDecMode() {
        String[] message = {"java", "Main", "-key", "5", "-alg", "shift", "-data", "Bjqhtrj yt mdujwxpnqq!", "-mode", "dec"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("Welcome to hyperskill!", resultString);
    }

    @Test
    public void checkEncModeNoAlg() {
        String[] message = {"java", "Main", "-key", "5", "-data", "Welcome to hyperskill!", "-mode", "enc"};
        messageChecker = new MessageChecker(message);
        String resultString = Main.input(messageChecker, message);

        assertEquals("Bjqhtrj yt mdujwxpnqq!", resultString);
    }

    @AfterAll
    public static void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}