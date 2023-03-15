package Cryptography;
import java.security.*;
import java.util.*;
import javax.crypto.*;

public class DES
{
    public static void main(String[] argv) {
        try{
            System.out.println("------ DES Algorithm ------");
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Message :");
            String message = sc.nextLine();
            byte[] text = message.getBytes();
            byte[] textEncrypted = desCipher.doFinal(text);
            System.out.println("Encrypted Message: " + new String(textEncrypted));
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);
            System.out.println("Decrypted Message: " + new String(textDecrypted));
        }
        catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e){
            e.printStackTrace();
        }
    }
}
