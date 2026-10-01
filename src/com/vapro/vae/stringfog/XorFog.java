package com.vapro.vae.stringfog;

public final class XorFog implements IStringFog {
    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length == 0) {
            return (byte[]) bArr.clone();
        }
        int length = bArr2.length;
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % length]);
        }
        return bArr3;
    }

    @Override
    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return xor(bArr, bArr2);
    }

    @Override
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return xor(bArr, bArr2);
    }
}
