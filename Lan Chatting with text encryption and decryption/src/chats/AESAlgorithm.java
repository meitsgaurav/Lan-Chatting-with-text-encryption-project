/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author shilpi
 */
public class AESAlgorithm {
    public static String algo ="AES";
    public byte[] keyValue;
    public AESAlgorithm(byte key[]){
        keyValue = key;
    }

    public Key generatekey() throws Exception{
        Key key = new SecretKeySpec(keyValue, algo);
        return key;
    }
    public String encrypt(String msg) throws Exception{
        Key key = generatekey();
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(msg.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        System.out.println(encryptedValue);
        return encryptedValue;
    }
     public String decrypt(String msg) throws Exception{
        Key key = generatekey();
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(msg);
        byte[] decVal = c.doFinal(decodedValue);
        String decryptedValue = new String(decVal);
        return decryptedValue;
    }

}
