package wojtal.paulina;

public class UnicodeAlgorithm implements EncryptDecryptAlgorithm {

    @Override
    public String encrypt( String message, int key ) {
        StringBuilder resultString = new StringBuilder();
        for (char character : message.toCharArray()) {
            int numericValue = character;
            int resultNumericValue = numericValue + key;
            char resultChar = (char) resultNumericValue;
            resultString.append(resultChar);
        }
        return resultString.toString();
    }

    @Override
    public String decrypt( String message, int key ) {
        return encrypt(message, -key);
    }
}
