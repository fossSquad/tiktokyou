package b;

import com.vapro.vae.stringfog.StringFogRuntime;

public abstract class a {
    public static boolean a(String str, String str2) {
        if (str != null && str.length() == str2.length()) {
            int lowerCase = 0;
            for (int i = 0; i < str.length(); i++) {
                lowerCase |= Character.toLowerCase(str.charAt(i)) ^ Character.toLowerCase(str2.charAt(i));
            }
            if (lowerCase == 0) {
                return true;
            }
        }
        return false;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        char[] charArray = "0123456789abcdef".toCharArray();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            byte b2 = bArr[i];
            cArr[i2] = charArray[(b2 >>> 4) & 15];
            cArr[i2 + 1] = charArray[b2 & 15];
        }
        return new String(cArr);
    }
}
