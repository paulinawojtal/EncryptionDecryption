package wojtal.paulina;

public interface EncryptDecryptAlgorithm {

    String encrypt(String message, int key);

    String decrypt(String message, int key);

}
