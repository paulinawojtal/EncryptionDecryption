package wojtal.paulina;

import java.util.Arrays;

public class InputReader {

    public String getDataStringFromStringArray(String[] message) {

        int dataIndex = Arrays.asList(message).indexOf("-data");

        return message[dataIndex + 1];
    }
}
