package wojtal.paulina;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmContextTest {

    private static AlgorithmContext algorithmContext;
    private String resultString;

    @BeforeAll
    public static void setUp() {
        algorithmContext = new AlgorithmContext();
    }

    @Test
    void changeDataShiftAlgEncMode() {

        algorithmContext.setToEncrypt(true);
        algorithmContext.setAlgorithm(new ShiftAlgorithm());

        resultString = algorithmContext.changeData("Welcome to hyperskill!", 5);

        assertEquals("Bjqhtrj yt mdujwxpnqq!", resultString);
    }

    @Test
    void changeDataShiftAlgDecMode() {

        algorithmContext.setToEncrypt(false);
        algorithmContext.setAlgorithm(new ShiftAlgorithm());

        resultString = algorithmContext.changeData("Bjqhtrj yt mdujwxpnqq!", 5);

        assertEquals("Welcome to hyperskill!", resultString);
    }

    @Test
    void changeDataUnicodeAlgEncMode() {

        algorithmContext.setToEncrypt(true);
        algorithmContext.setAlgorithm(new UnicodeAlgorithm());

        resultString = algorithmContext.changeData("Welcome to hyperskill!", 5);

        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", resultString);
    }

    @Test
    void changeDataUnicodeAlgDecMode() {

        algorithmContext.setToEncrypt(false);
        algorithmContext.setAlgorithm(new UnicodeAlgorithm());

        resultString = algorithmContext.changeData("\\jqhtrj%yt%m~ujwxpnqq&", 5);

        assertEquals("Welcome to hyperskill!", resultString);
    }
}