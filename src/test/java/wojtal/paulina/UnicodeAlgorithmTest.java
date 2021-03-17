package wojtal.paulina;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeAlgorithmTest {

    @Test
    void encrypt() {

        UnicodeAlgorithm unicodeAlgorithm = new UnicodeAlgorithm();
        String result = unicodeAlgorithm.encrypt("Welcome to hyperskill!", 5);

        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", result);
    }

    @Test
    void checkdecrypt(){
        UnicodeAlgorithm unicodeAlgorithm = new UnicodeAlgorithm();
        String result = unicodeAlgorithm.decrypt("\\jqhtrj%yt%m~ujwxpnqq&", 5);

        assertEquals("Welcome to hyperskill!", result);
    }
}