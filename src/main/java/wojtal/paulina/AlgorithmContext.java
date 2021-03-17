package wojtal.paulina;

public class AlgorithmContext {

    private boolean toEncrypt;
    private EncryptDecryptAlgorithm algorithm;

    public void setToEncrypt(boolean toEncrypt) {
        this.toEncrypt = toEncrypt;
    }

    public void setAlgorithm(EncryptDecryptAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String changeData(String message, int key) {
        if (toEncrypt) {
            return algorithm.encrypt(message, key);
        } else {
            return algorithm.decrypt(message, key);
        }
    }
}
