package com.exam.service;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

import com.exam.logger.CustomLogger;

public class PasswordService 
{
	//DES Encryption & Decryption Algorithm
    private static final String UNICODE_FORMAT = "UTF8";
    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    private byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    private SecretKey key;

    public PasswordService() throws Exception 
    {
        myEncryptionKey = "ThisIsSpartaThisIsSparta";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }

    //Encryption Algorithm
    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
        	CustomLogger.info("--------Before encryption : "+unencryptedString);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
            CustomLogger.info("--------After encryption : "+encryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    //Decryption Algorithm
    public String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
        	CustomLogger.info("--------Before decryption : "+encryptedString);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
            CustomLogger.info("--------After decryption : "+decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return decryptedText;
    }

//    public static void main(String args []) throws Exception
//    {
//        PasswordService td= new PasswordService();
//
//        String target="imparator";
//        String encrypted=td.encrypt(target);
//        String decrypted=td.decrypt(encrypted);
//
//        System.out.println("String To Encrypt: "+ target);
//        System.out.println("Encrypted String:" + encrypted);
//        System.out.println("Decrypted String:" + decrypted);
//
//    }

}