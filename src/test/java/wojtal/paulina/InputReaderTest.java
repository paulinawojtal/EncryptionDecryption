package wojtal.paulina;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    private String[] str1 = {"java", "Main", "-mode", "enc", "-key", "5", "-data", "Welcome to hyperskill!", "-alg", "unicode"};
    private String[] str2 = {"java", "Main", "-mode", "dec", "-key", "5", "-data", "jqhtrj%yt%m~ujwxpnqq&"};
    private String[] str3 = {"java", "Main", "-data", "Welcome to hyperskill!", "-mode", "enc", "-key", "5", "-alg", "unicode"};
    private String[] str4 = {"java", "Main", "-mode", "enc", "-data", "Bjqhtrj yt mdujwxpnqq!", "-key", "5", "-alg", "unicode"};

    @Test
    public void checkString1() {
        InputReader inputReader = new InputReader();
        String resultString = inputReader.getDataStringFromStringArray(str1);

        assertEquals("Welcome to hyperskill!", resultString);
    }

    @Test
    public void checkString2() {
        InputReader inputReader = new InputReader();
        String resultString = inputReader.getDataStringFromStringArray( str2 );

        assertEquals("jqhtrj%yt%m~ujwxpnqq&",resultString);
    }

    @Test
    public void checkString3() {
        InputReader inputReader = new InputReader();
        String resultString = inputReader.getDataStringFromStringArray( str3 );

        assertEquals( "Welcome to hyperskill!", resultString );
    }

    @Test
    public void checkString4() {
        InputReader inputReader = new InputReader();
        String resultString = inputReader.getDataStringFromStringArray( str4 );

        assertEquals("Bjqhtrj yt mdujwxpnqq!", resultString );
    }
}