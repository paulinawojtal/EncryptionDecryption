package wojtal.paulina;

public class ShiftAlgorithm implements EncryptDecryptAlgorithm {

    private final String upperCaseCircle = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowerCaseCircle = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String encrypt( String message, int key ) {
        StringBuilder resultString = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character) && Character.isUpperCase(character)) {

                char resultCharacter = caseCircle(upperCaseCircle, key, character);

                resultString.append(resultCharacter);

            } else if (Character.isLetter(character) && Character.isLowerCase(character)) {

                char resultCharacter = caseCircle(lowerCaseCircle, key, character);

                resultString.append(resultCharacter);

            } else {
                resultString.append(character);
            }
        }

        return resultString.toString();
    }

    @Override
    public String decrypt( String message, int key ) {
        return encrypt(message, -key);
    }

    private char caseCircle(String caseCircle, int key, char character){

        int originalPosition = caseCircle.indexOf(character);

        int resultPosition;
        if (key < 0 && originalPosition < Math.abs(key)) {
            resultPosition = caseCircle.length() + (originalPosition + key) % caseCircle.length();
        } else {
            resultPosition = (originalPosition + key) % caseCircle.length();
        }

        return caseCircle.charAt(resultPosition);
    }
}