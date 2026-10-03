package com.vapro.vae.stringfog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesFog implements IStringFog {
    private static final int BLOCK = 16;
    private static final String KEY_DIGEST = "SHA-256";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private static SecretKeySpec secretKey(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(KEY_DIGEST);
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(messageDigest.digest(bArr), 0, bArr2, 0, 16);
        return new SecretKeySpec(bArr2, "AES");
    }

    @Override
    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            try {
                if (bArr.length >= 16) {
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(bArr, 0, bArr3, 0, 16);
                    int length = bArr.length - 16;
                    byte[] bArr4 = new byte[length];
                    System.arraycopy(bArr, 16, bArr4, 0, length);
                    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                    cipher.init(2, secretKey(bArr2), new IvParameterSpec(bArr3));
                    return cipher.doFinal(bArr4);
                }
            } catch (Exception e) {
                throw new IllegalStateException("AesFog decrypt failed", e);
            }
        }
        return bArr;
    }

    @Override
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bArr3 = new byte[16];
            SECURE_RANDOM.nextBytes(bArr3);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, secretKey(bArr2), new IvParameterSpec(bArr3));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] bArr4 = new byte[bArrDoFinal.length + 16];
            System.arraycopy(bArr3, 0, bArr4, 0, 16);
            System.arraycopy(bArrDoFinal, 0, bArr4, 16, bArrDoFinal.length);
            return bArr4;
        } catch (Exception e) {
            throw new IllegalStateException("AesFog encrypt failed", e);
        }
    }
}
