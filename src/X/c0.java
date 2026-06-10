package X;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.LinkedHashMap;

public abstract class c0 {
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

    public static String b(String str) {
        byte[] bArr = a(str).a;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String c(Context context) {
        if (context != null && !TextUtils.isEmpty("ttmod_badges/supporters_fallback.json")) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("ttmod_badges/supporters_fallback.json");
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
                th5.getMessage();
                int i2 = p4.a;
                return null;
            }
        }
        return null;
    }

    public static String b(File file) {
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
            file.getName();
            e.getMessage();
            int i2 = p4.a;
            return null;
        }
    }

    public static b0 a(String str) throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(8000);
                httpURLConnection2.setReadTimeout(8000);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestProperty("User-Agent", "TTMod-BadgeHooks/1.0");
                InputStream inputStream = httpURLConnection2.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                            }
                            throw th;
                        }
                        URL url = httpURLConnection2.getURL();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (url != null) {
                            str = url.toString();
                        }
                        b0 b0Var = new b0(byteArray, str);
                        byteArrayOutputStream.close();
                        inputStream.close();
                        httpURLConnection2.disconnect();
                        return b0Var;
                    } catch (Throwable th2) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th4;
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static LinkedHashMap b(Context context) {
        int iIndexOf;
        String strB = b(new File(a(context), "image_redirects.txt"));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!TextUtils.isEmpty(strB)) {
            for (String str : strB.split("\n")) {
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

    public static void c(File file) {
        try {
            a(file);
            if (!file.exists()) {
                new FileOutputStream(file).close();
            }
            file.setLastModified(System.currentTimeMillis());
        } catch (IOException e) {
        }
    }

    public static String c(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Throwable th) {
            return Integer.toHexString(str.hashCode());
        }
    }

    public static void a(File file, String str) throws IOException {
        if (file == null) {
            return;
        }
        a(file);
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

    public static void a(File file, byte[] bArr) throws IOException {
        a(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            fileOutputStream.write(bArr);
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

    public static void a(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
            throw new IOException("Failed to create " + parentFile.getAbsolutePath());
        }
    }

    public static File a(Context context) {
        return new File(context.getCacheDir() != null ? context.getCacheDir() : context.getFilesDir(), "ttmod_badges");
    }
}
