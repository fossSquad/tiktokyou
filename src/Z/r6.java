package Z;

import java.security.MessageDigest;
import java.util.Arrays;

public abstract class r6 {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final char[] b = {'S', 'H', 'A', '-', '2', '5', '6'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(new String(b)).digest(bArr);
            if (bArrDigest != null && bArrDigest.length != 0) {
                char[] cArr = new char[bArrDigest.length * 2];
                for (int i = 0; i < bArrDigest.length; i++) {
                    byte b2 = bArrDigest[i];
                    int i2 = i * 2;
                    char[] cArr2 = a;
                    cArr[i2] = cArr2[(b2 & 255) >>> 4];
                    cArr[i2 + 1] = cArr2[b2 & 15];
                }
                return new String(cArr);
            }
            return "";
        } catch (Throwable th) {
            return Integer.toHexString(Arrays.hashCode(bArr));
        }
    }
}
