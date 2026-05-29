package com.transaction.api.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESUtil {

    private static final String SECRET_KEY =
            "12345678901234567890123456789012";

    private AESUtil() {
    }

    public static String encrypt(String value)
            throws Exception {

        SecretKeySpec secretKey =
                new SecretKeySpec(
                        SECRET_KEY.getBytes(
                                StandardCharsets.UTF_8),
                        "AES"
                );

        Cipher cipher =
                Cipher.getInstance("AES");

        cipher.init(
                Cipher.ENCRYPT_MODE,
                secretKey
        );

        byte[] encrypted =
                cipher.doFinal(
                        value.getBytes(
                                StandardCharsets.UTF_8
                        )
                );

        return Base64.getEncoder()
                .encodeToString(encrypted);
    }

    public static String decrypt(String value)
            throws Exception {

        SecretKeySpec secretKey =
                new SecretKeySpec(
                        SECRET_KEY.getBytes(
                                StandardCharsets.UTF_8),
                        "AES"
                );

        Cipher cipher =
                Cipher.getInstance("AES");

        cipher.init(
                Cipher.DECRYPT_MODE,
                secretKey
        );

        byte[] decrypted =
                cipher.doFinal(
                        Base64.getDecoder()
                                .decode(value)
                );

        return new String(
                decrypted,
                StandardCharsets.UTF_8
        );
    }
}