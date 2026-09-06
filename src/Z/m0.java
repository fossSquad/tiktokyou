package Z;

import android.content.Context;
import android.text.TextUtils;
import com.windukk.stable.ResourceOverlay;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.collections.MapsKt;

public abstract class m0 {
    public static final char[] a;
    public static final char[] b;
    public static final char[] c;

    static {
        a = new char[]{'.', 'i', 'm', 'g'};
        b = new char[]{'.', 's', 't', 'a', 'm', 'p'};
        c = new char[]{'i', 'm', 'a', 'g', 'e', 's'};
    }

    public static boolean a(File file, File file2, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (file.exists() && file.length() > 0) {
            long jLastModified = jCurrentTimeMillis - file.lastModified();
            if (jLastModified >= 0 && jLastModified < j) {
                return false;
            }
        }
        if (!file2.exists()) {
            return true;
        }
        long jLastModified2 = jCurrentTimeMillis - file2.lastModified();
        return jLastModified2 < 0 || jLastModified2 >= 1200000;
    }

    public static String b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                InputStream inputStreamOpen = ResourceOverlay.open(context, str);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = inputStreamOpen.read(bArr);
                            if (i == -1) {
                                String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                                byteArrayOutputStream.close();
                                inputStreamOpen.close();
                                return string;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    throw th4;
                }
            } catch (IOException e) {
            } catch (Throwable th5) {
                h6.a(6, h6.a("Failed to read asset %s: %s", new Object[]{str, th5.getMessage()}), (Throwable) null);
                return null;
            }
        }
        return null;
    }

    public static String a(String str) {
        String strDecrypt = "TTMod-BadgeHooks/1.0";
        AtomicBoolean atomicBoolean = p.a;
        byte[] bArr = p.a(str, strDecrypt, null, 16777216, MapsKt.emptyMap()).b;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String a(File file) {
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i != -1) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        } else {
                            String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                            byteArrayOutputStream.close();
                            fileInputStream.close();
                            return string;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (IOException e) {
            h6.a(6, h6.a("Failed to read cache file %s: %s", new Object[]{file.getName(), e.getMessage()}), (Throwable) null);
            return null;
        }
    }

    public static LinkedHashMap b(Context context) {
        int iIndexOf;
        String strA = a(new File(a(context), "image_redirects.txt"));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!TextUtils.isEmpty(strA)) {
            for (String str : strA.split("\n")) {
                if (!TextUtils.isEmpty(str) && (iIndexOf = str.indexOf(9)) > 0 && iIndexOf < str.length() - 1) {
                    String strTrim = str.substring(0, iIndexOf).trim();
                    String strTrim2 = str.substring(iIndexOf + 1).trim();
                    if (!TextUtils.isEmpty(strTrim) && !TextUtils.isEmpty(strTrim2)) {
                        linkedHashMap.put(strTrim, strTrim2);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static File a(Context context, String str) {
        File file = new File(a(context), new String(c));
        char[] cArr = a;
        if (str == null) {
            str = "";
        }
        return new File(file, v5.a(str.getBytes(StandardCharsets.UTF_8)) + new String(cArr));
    }

    public static void a(File file, String str) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
            throw new IOException("Failed to create " + parentFile.getAbsolutePath());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void b(File file) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                throw new IOException("Failed to create " + parentFile.getAbsolutePath());
            }
            if (!file.exists()) {
                new FileOutputStream(file).close();
            }
            file.setLastModified(System.currentTimeMillis());
        } catch (IOException e) {
        }
    }

    public static File a(Context context) {
        return new File(context.getCacheDir() != null ? context.getCacheDir() : context.getFilesDir(), "tty_badges");
    }
}
