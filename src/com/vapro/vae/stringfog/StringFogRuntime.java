package com.vapro.vae.stringfog;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class StringFogRuntime {
    public static final String ALGORITHM_AES = "aes";
    public static final String ALGORITHM_XOR = "xor";
    private static final Map<String, IStringFog> REGISTRY;

    // bytes: "z9N!kX3pKARnZqh3"
    static final byte[] DEFAULT_KEY = {122, 57, 78, 33, 107, 88, 51, 112, 75, 65, 82, 110, 90, 113, 104, 51};
    private static final IStringFog DEFAULT_FOG = new XorFog();

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        REGISTRY = concurrentHashMap;
        concurrentHashMap.put(ALGORITHM_XOR, new XorFog());
        concurrentHashMap.put(ALGORITHM_AES, new AesFog());
    }

    private StringFogRuntime() {
    }

    private static String decodeUtf8(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String decrypt(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return decodeUtf8(DEFAULT_FOG.decrypt(Base64.getDecoder().decode(str), DEFAULT_KEY));
            } catch (Throwable th) {
            }
        }
        return str;
    }

    public static byte[] defaultKey() {
        return (byte[]) DEFAULT_KEY.clone();
    }

    private static byte[] keyBytes(String str) {
        return str == null ? new byte[0] : str.getBytes(StandardCharsets.UTF_8);
    }

    public static void register(String str, IStringFog iStringFog) {
        if (str == null || iStringFog == null) {
            return;
        }
        REGISTRY.put(str, iStringFog);
    }

    public static String decrypt(String str, String str2, String str3) {
        if (str != null && !str.isEmpty()) {
            try {
                IStringFog iStringFog = REGISTRY.get(str3);
                if (iStringFog != null) {
                    return decodeUtf8(iStringFog.decrypt(Base64.getDecoder().decode(str), keyBytes(str2)));
                }
            } catch (Throwable th) {
            }
        }
        return str;
    }

    public static String decrypt(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return decodeUtf8(DEFAULT_FOG.decrypt(bArr, DEFAULT_KEY));
        } catch (Throwable th) {
            return "";
        }
    }

    public static String decrypt(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            IStringFog iStringFog = REGISTRY.get(str2);
            return iStringFog == null ? "" : decodeUtf8(iStringFog.decrypt(bArr, keyBytes(str)));
        } catch (Throwable th) {
            return "";
        }
    }
}
