package wojtal.paulina;

import java.util.Arrays;

public class Main {

    public static void main( String[] args ) {

        MessageChecker messageChecker = new MessageChecker(args);
        String input = input(messageChecker, args);
        writeOutput(args, input, messageChecker);
    }

    public static String input(MessageChecker messageChecker, String[] input) {

        int key = 0;
        String inputDataString = "";

        if (messageChecker.isDataString()) {
            InputReader inputReader = new InputReader();
            inputDataString = inputReader.getDataStringFromStringArray(input);
        } else if (messageChecker.isInArgument()) {
            inputDataString = StringFileReader.getDataFromFile(input);
        }

        if (messageChecker.isKeyValue()) {
            key = getKey(input);
        }

        AlgorithmContext algorithmContext = new AlgorithmContext();

        if (messageChecker.isMode()) {
            algorithmContext.setToEncrypt(messageChecker.isEncMode());
        } else {
            algorithmContext.setToEncrypt(true);
        }

        if (messageChecker.isAlgMode()) {
            algorithmContext.setAlgorithm(create(getAlgMode(input)));
        } else {
            algorithmContext.setAlgorithm(create("shift"));
        }

        return algorithmContext.changeData(inputDataString, key);
    }

    private static EncryptDecryptAlgorithm create(String algMode){
        switch (algMode) {
            case "shift":
                return new ShiftAlgorithm();
            case "unicode":
                return new UnicodeAlgorithm();
            default:
                throw new IllegalArgumentException("Unknown algorithm type " + algMode);
        }
    }

    private static int getKey(String[] message) {

        int dataKey = Arrays.asList(message).indexOf("-key");

        int key = 0;
        try {
            key = Integer.parseInt(message[dataKey + 1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return key;
    }

    private static String getAlgMode(String[] message) {

        int algIndex = Arrays.asList(message).indexOf("-alg");

        String algModeIndex = "";
        try {
            algModeIndex = message[algIndex + 1];
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return algModeIndex;
    }

    public static void writeOutput(String[] input, String outputString, MessageChecker messageChecker) {

        int outputFileIndex = Arrays.asList(input).indexOf("-out") + 1;

        String outFileName = input[outputFileIndex];

        if(messageChecker.isOutArgument()) {
            StringFileWriter.writeOutputToFile(outFileName, outputString);
            System.out.println("Result saved in file " + outFileName);
        } else {
            System.out.println(outputString);
        }
    }
}
