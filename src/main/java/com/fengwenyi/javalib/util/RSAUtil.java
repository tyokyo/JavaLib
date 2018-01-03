package com.fengwenyi.javalib.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * NoSuchAlgorithmException：无此加密算法
 * InvalidKeyException：非法密钥
 * NoSuchPaddingException：无明文数据
 * BadPaddingException：明文数据损坏
 * UnsupportedEncodingException：不支持的编码
 * InvalidKeySpecException：密文格式不正确
 * IllegalBlockSizeException：密文长度非法
 *
 * Wenyi Feng(xfsy_2015@163.com)
 */
public class RSAUtil {

    private static final String RSA = "RSA";
    private static int LENGTH = 512;

    /**
     * 获取密钥
     * @param keySize 64的整数倍
     * @return 数组
     *         [0]=>privateKey
     *         [1]=>publicKey
     */
    public static String[] getKey(int keySize) throws NoSuchAlgorithmException {
        LENGTH = keySize;
        return commonKey(LENGTH);
    }

    /**
     * 获取密钥
     * @return 数组
     *         [0]=>privateKey
     *         [1]=>publicKey
     */
    public static String[] getKey() throws NoSuchAlgorithmException {
       return commonKey(LENGTH);
    }

    /**
     * 私钥加密
     */
    public static String privateKeyEncrypt(String key, String plainText) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException,
            IllegalBlockSizeException, InvalidKeyException {
        PrivateKey privateKey = commonGetPrivatekeyByText(key);
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte [] result = cipher.doFinal(plainText.getBytes(Constant.DEFAULT_CHATSET));

        return Base64.byteArrayToBase64(result);
    }

    /**
     * 公钥解密
     */
    public static String publicKeyDecrypt(String key, String cipherText) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        PublicKey publicKey = commonGetPublickeyByText(key);
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(Base64.base64ToByteArray(cipherText));

        return new String(result);
    }

    /**
     * 公钥加密
     */
    public static String publicKeyEncrypt(String key, String plainText) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, UnsupportedEncodingException {
        PublicKey publicKey = commonGetPublickeyByText(key);
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte [] result = cipher.doFinal(plainText.getBytes(Constant.DEFAULT_CHATSET));

        return Base64.byteArrayToBase64(result);
    }

    /**
     * 私钥解密
     */
    public static String privateKeyDecrypt(String key, String cipherText) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException,
            BadPaddingException, IllegalBlockSizeException {
        PrivateKey privateKey = commonGetPrivatekeyByText(key);
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(Base64.base64ToByteArray(cipherText));

        return new String(result);
    }

    /**
     * (common)获取密钥
     */
    private static String[] commonKey(int size) throws NoSuchAlgorithmException {
        String [] keys = new String[2];

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(size);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();

        // 私钥
        keys[0] = Base64.byteArrayToBase64(rsaPrivateKey.getEncoded());
        // 公钥
        keys[1] = Base64.byteArrayToBase64(rsaPublicKey.getEncoded());

        return keys;
    }

    /**
     * (common)通过公钥文本获取公钥
     */
    private static PublicKey commonGetPublickeyByText(String keyText)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.base64ToByteArray(keyText);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        return keyFactory.generatePublic(x509KeySpec);
    }

    /**
     * (common)通过私钥文本获取私钥
     */
    private static PrivateKey commonGetPrivatekeyByText(String keyText)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.base64ToByteArray(keyText);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

}
