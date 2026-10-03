package com.vapro.vae.stringfog;

import java.security.SecureRandom;

public final class RandomKeyGenerator implements IKeyGenerator {
    public static final int DEFAULT_KEY_LENGTH = 16;
    private final int keyLength;
    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final SecureRandom RANDOM = new SecureRandom();

    public RandomKeyGenerator() {
        this(16);
    }

    @Override
    public String generateKey(String str) {
        StringBuilder sb = new StringBuilder(this.keyLength);
        for (int i = 0; i < this.keyLength; i++) {
            char[] cArr = ALPHABET;
            sb.append(cArr[RANDOM.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public RandomKeyGenerator(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("keyLength 必须为正，当前=" + i);
        }
        this.keyLength = i;
    }
}
