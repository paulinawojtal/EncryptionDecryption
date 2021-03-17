package wojtal.paulina;

import java.util.Arrays;

public class MessageChecker {

    private boolean isMode;
    private boolean isEncMode;
    private boolean isInArgument;
    private boolean isOutArgument;
    private boolean isKeyValue;
    private boolean isDataString;
    private boolean isAlgMode;

    public MessageChecker(String[] array){
        isMode = ifContains(array, "-mode");
        isEncMode = ifContains(array, "enc");
        isInArgument = ifContains(array, "-in");
        isOutArgument = ifContains(array, "-out");
        isKeyValue = ifContains(array, "-key");
        isDataString = ifContains(array, "-data");
        isAlgMode = ifContains(array, "-alg");
    }

    private static boolean ifContains(String[] array, String mode) {
        return Arrays.asList(array).contains(mode);
    }

    public boolean isMode() {
        return isMode;
    }

    public boolean isEncMode() {
        return isEncMode;
    }

    public boolean isInArgument() {
        return isInArgument;
    }

    public boolean isOutArgument() {
        return isOutArgument;
    }

    public boolean isKeyValue() {
        return isKeyValue;
    }

    public boolean isDataString() {
        return isDataString;
    }

    public boolean isAlgMode() {
        return isAlgMode;
    }
}
