package util;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

public final class PkgBridge {
    private PkgBridge() {
    }

    public static c.b a(byte[] bArr) throws IOException {
        return c.b.a(bArr);
    }

    public static boolean a(String str, String str2) {
        return b.a.a(str, str2);
    }

    public static String b(byte[] bArr) {
        return b.a.a(bArr);
    }

    public static void c(List list) throws IOException {
        a.c.a(list);
    }

    public static LinkedHashSet a(File file) throws IOException {
        return a.b.a(file);
    }

    public static LinkedHashSet b(File file) throws IOException {
        return a.b.b(file);
    }
}
