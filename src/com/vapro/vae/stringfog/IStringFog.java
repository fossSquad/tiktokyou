package com.vapro.vae.stringfog;

public interface IStringFog {
    byte[] decrypt(byte[] bArr, byte[] bArr2);

    byte[] encrypt(byte[] bArr, byte[] bArr2);

    default boolean shouldFog(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }
}
