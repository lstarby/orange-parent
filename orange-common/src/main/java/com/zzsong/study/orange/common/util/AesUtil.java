package com.zzsong.study.orange.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;

/**
 * Created by zzsong on 2017/10/14.
 */

public class AesUtil {
    private static String ALGORITHM = "AES";
    private static String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String encrypt(String plaintext, String aesToken) throws Exception {
        Key key = new SecretKeySpec(aesToken.getBytes(Charset.forName("UTF-8")), ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(Charset.forName("UTF-8")));
        return Base64.encodeBase64URLSafeString(ciphertext);
    }

    public static String decrypt(String ciphertext, String aesToken) throws Exception {
        Key key = new SecretKeySpec(aesToken.getBytes(Charset.forName("UTF-8")), ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plaintext = cipher.doFinal(Base64.decodeBase64(ciphertext));
        return new String(plaintext, Charset.forName("UTF-8"));
    }

}