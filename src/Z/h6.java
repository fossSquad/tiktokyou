package Z;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.MediaStore;
import android.util.Log;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public abstract class h6 {
    public static final Object a = new Object();
    public static File b;
    public static File c;
    public static final SimpleDateFormat d;
    public static final SimpleDateFormat e;

    static {
        Locale locale = Locale.US;
        d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", locale);
        e = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", locale);
    }

    public static void a() {
        if (c == null) {
            return;
        }
        a("========== begin of log ==========\nTime: " + d.format(new Date()) + "\nDevice: " + Build.MANUFACTURER + " " + Build.MODEL + "\nAndroid OS: " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")\nDisplay: " + Build.DISPLAY + "\nBoard: " + Build.BOARD + "\nHardware: " + Build.HARDWARE + "\nABIs: " + Arrays.toString(Build.SUPPORTED_ABIS) + "\nVersion: " + Main.MOD_VERSION + "\nVersion code: 1790876728\n");
    }

    public static void b(final File file) {
        if (file != null) {
            synchronized (a) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                b = file;
                c = new File(file, "session_" + e.format(new Date()) + "_pid" + Process.myPid() + ".log");
                a();
            }
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    h6.c(file);
                }
            }).start();
        }
    }

    public static void c(File file) {
        synchronized (a) {
            File[] fileArrD = d(file);
            long jCurrentTimeMillis = System.currentTimeMillis() - 432000000;
            for (File file2 : fileArrD) {
                if (file2.lastModified() < jCurrentTimeMillis) {
                    file2.delete();
                }
            }
        }
    }

    public static File[] d(File file) {
        if (file == null) {
            return new File[0];
        }
        File[] fileArrListFiles = file.listFiles(new FilenameFilter() {
            @Override
            public final boolean accept(File file2, String str) {
                return h6.a(file2, str);
            }
        });
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles, Comparator.comparing(new Function() {
            @Override
            public final Object apply(Object obj) {
                return ((File) obj).getName();
            }
        }));
        return fileArrListFiles;
    }

    public static String a(String str, Object[] objArr) {
        if (str == null) {
            return "null";
        }
        if (objArr.length == 0) {
            return str;
        }
        try {
            return String.format(str, objArr);
        } catch (Throwable th) {
            return str;
        }
    }

    public static String b(Context context, File file, String str) throws Throwable {
        Throwable th = null;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "application/zip");
        contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS + "/TikTokYou");
        boolean z = true;
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = context.getContentResolver().insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert != null) {
            try {
                OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriInsert);
                if (outputStreamOpenOutputStream != null) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[65536];
                            while (true) {
                                int i = fileInputStream.read(bArr);
                                if (i != -1) {
                                    outputStreamOpenOutputStream.write(bArr, 0, i);
                                } else {
                                    fileInputStream.close();
                                    outputStreamOpenOutputStream.close();
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put("is_pending", (Integer) 0);
                                    context.getContentResolver().update(uriInsert, contentValues2, null, null);
                                    try {
                                        return Environment.DIRECTORY_DOWNLOADS + "/TikTokYou/" + str;
                                    } catch (Throwable th_2) {
                                        th = th_2;
                                    }
                                }
                                try {
                                    outputStreamOpenOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        outputStreamOpenOutputStream.close();
                        throw th5;
                    }
                }
                throw new IOException("MediaStore output stream is null");
            } catch (Throwable th6) {
                th = th6;
                z = false;
            }
            if (!z) {
                context.getContentResolver().delete(uriInsert, null, null);
            }
            throw th;
        }
        throw new IOException("MediaStore insert returned null");
    }

    public static void a(int i, String str, Throwable th) {
        String str2;
        String str3;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str2 = "TTU_" + stackTrace[3].getClassName();
        } else {
            str2 = "TTU_unk";
        }
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        if (str != null && !str.isEmpty()) {
            StringBuilder sb = null;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                char c2 = (cCharAt == '\n' || cCharAt == '\t' || !Character.isISOControl(cCharAt)) ? cCharAt : '?';
                if (c2 != cCharAt) {
                    if (sb == null) {
                        sb = new StringBuilder(str.length());
                        sb.append((CharSequence) str, 0, i2);
                    }
                    sb.append(c2);
                } else if (sb != null) {
                    sb.append(cCharAt);
                }
            }
            if (sb != null) {
                str = sb.toString();
            }
        }
        Log.println(i, str2, str);
        synchronized (a) {
            if (c != null) {
                String str4 = d.format(new Date());
                if (i == 3) {
                    str3 = "D";
                } else if (i == 4) {
                    str3 = "I";
                } else {
                    str3 = "E";
                }
                StringBuilder sb2 = new StringBuilder(str4.length() + str2.length() + str.length() + 8);
                sb2.append(str4).append(' ').append(str3).append('/').append(str2).append(": ").append(str).append('\n');
                a(sb2.toString());
            }
        }
    }

    public static void a(String str) {
        synchronized (a) {
            if (c == null) {
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(c, true);
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
            } catch (IOException e2) {
            }
        }
    }

    public static g6 a(Context context) throws IOException {
        File filesDir;
        String str;
        String strA;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext.getCacheDir() != null) {
            filesDir = applicationContext.getCacheDir();
        } else {
            filesDir = applicationContext.getFilesDir();
        }
        File file = new File(filesDir, "tty_log_exports");
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Cannot create log export directory");
        }
        synchronized (a) {
            str = e.format(new Date());
        }
        String str2 = "ttmod_logs_" + str + ".zip";
        File file2 = new File(file, str2);
        try {
            boolean zPauseNativeLoggingForSnapshot = HookBridge.pauseNativeLoggingForSnapshot();
            try {
                int iA = a(file2);
                if (zPauseNativeLoggingForSnapshot) {
                    HookBridge.resumeNativeLoggingAfterSnapshot();
                }
                long length = file2.length();
                if (Build.VERSION.SDK_INT >= 29) {
                    strA = b(applicationContext, file2, str2);
                } else {
                    strA = a(applicationContext, file2, str2);
                }
                g6 g6Var = new g6(strA, length, iA);
                if (file2.exists() && !file2.delete()) {
                    Log.e("TTU_L", "Failed to delete temporary log archive: " + file2.getAbsolutePath());
                }
                return g6Var;
            } catch (Throwable th) {
                if (zPauseNativeLoggingForSnapshot) {
                    HookBridge.resumeNativeLoggingAfterSnapshot();
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (file2.exists() && !file2.delete()) {
                Log.e("TTU_L", "Failed to delete temporary log archive: " + file2.getAbsolutePath());
            }
            throw new RuntimeException(th2);
        }
    }

    public static int a(File file) {
        Throwable th = null;
        int length;
        synchronized (a) {
            File[] fileArrD = d(b);
            if (fileArrD.length != 0) {
                byte[] bArr = new byte[65536];
                ZipOutputStream zipOutputStream;
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                } catch (Exception e) {
                    return 0;
                }
                try {
                    for (File file2 : fileArrD) {
                        ZipEntry zipEntry = new ZipEntry(file2.getName());
                        zipEntry.setTime(file2.lastModified());
                        zipOutputStream.putNextEntry(zipEntry);
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        while (true) {
                            try {
                                int i = fileInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, i);
                            } catch (Throwable th_2) {
                                th = th_2;
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                            try {
                                zipOutputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th;
                        }
                        fileInputStream.close();
                        zipOutputStream.closeEntry();
                    }
                    try {
                        zipOutputStream.close();
                    } catch (Throwable t9) { }
                    length = fileArrD.length;
                } catch (Throwable th4) {
                    try {
                        zipOutputStream.close();
                    } catch (Throwable t9) { }
                    throw new RuntimeException(th4);
                }
            } else {
                throw new RuntimeException("No log files found");
            }
        }
        return length;
    }

    public static  boolean a(File file, String str) {
        return str.startsWith("session_") && str.endsWith(".log");
    }

    public static String a(Context context, File file, String str) throws IOException {
        Throwable th = null;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        File file2 = new File(externalFilesDir, "TikTokYou");
        if (!file2.exists() && !file2.mkdirs()) {
            throw new IOException("Cannot create " + file2.getAbsolutePath());
        }
        File file3 = new File(file2, str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return file3.getAbsolutePath();
                    }
                    try {
                        fileInputStream.close();
                    } catch (Throwable th_2) {
                        th = th_2;
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw new RuntimeException(th2);
            }
        } catch (Throwable th4) {
            fileInputStream.close();
            throw new RuntimeException(th4);
        }
    }
}
