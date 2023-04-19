package Cryptography;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RC4 {
    public static void main(String[] args) throws Exception {
        SecretKey key = KeyGenerator.getInstance("Blowfish").generateKey();
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String message = "Hello World";
        byte[] byte_message = message.getBytes(StandardCharsets.UTF_8);
        byte[] encrypted_ = cipher.doFinal(byte_message);
        String encrypted = Base64.getEncoder().encodeToString(encrypted_);
        System.out.println("Original Message :" + message);
        System.out.println("Encrypted Message :" + encrypted);
    }
}
