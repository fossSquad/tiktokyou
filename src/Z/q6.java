package Z;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.ByteStreamsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.io.FilesKt;

public final class q6 {
    public static final q6 a;

    static {
        a = new q6();
    }

    public static final p6 a(Context context) throws IOException {
        String strA;
        boolean zDelete;
        Context applicationContext = context.getApplicationContext();
        File cacheDir = applicationContext.getCacheDir();
        if (cacheDir == null) {
            cacheDir = applicationContext.getFilesDir();
        }
        File fileResolve = FilesKt.resolve(cacheDir, "tty_heap_dumps");
        if (!fileResolve.exists() && !fileResolve.mkdirs()) {
            throw new IOException("Cannot create heap dump directory");
        }
        String strA2 = d3.a("SZmmJ7L9eLqe7HtF1mKQAoi9KK/7/nKsKSZnBZZwN/4=", "bNbfKYVPefcpiv0c", "aes", ve.a("vMxeV1nzAaAdlaTF5W1sulj5vZSoeqAC/JQOJiOF4O4=", "tHgYiLNHWeK23dCo", "aes", new StringBuilder(), new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US).format(new Date())));
        File fileResolve2 = FilesKt.resolve(fileResolve, strA2);
        try {
            Debug.dumpHprofData(fileResolve2.getAbsolutePath());
            long length = fileResolve2.length();
            if (Build.VERSION.SDK_INT >= 29) {
                a.getClass();
                strA = b(applicationContext, fileResolve2, strA2);
            } else {
                a.getClass();
                strA = a(applicationContext, fileResolve2, strA2);
            }
            p6 p6Var = new p6(length, strA);
            if (fileResolve2.exists()) {
                if (!zDelete) {
                    String strDecrypt = "Failed to delete temporary heap dump: %s";
                }
            }
            return p6Var;
        } finally {
            if (fileResolve2.exists() && !fileResolve2.delete()) {
                g7.a(6, g7.a("Failed to delete temporary heap dump: %s", new Object[]{fileResolve2.getAbsolutePath()}), (Throwable) null);
            }
        }
    }

    public static String b(Context context, File file, String str) throws Throwable {
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "application/octet-stream");
        contentValues.put("relative_path", d3.a("fWTZL6wl3c5Z+seEQkmezEfZtTa+PutKbywv5e4pv/s=", "Ub9LG8BmOQp358Vn", "aes", new StringBuilder().append(Environment.DIRECTORY_DOWNLOADS)));
        boolean z = true;
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            throw new IOException("MediaStore insert returned null");
        }
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            if (outputStreamOpenOutputStream == null) {
                throw new IOException("MediaStore output stream is null");
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    ByteStreamsKt.copyTo(fileInputStream, outputStreamOpenOutputStream, 1048576);
                    CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                    CloseableKt.closeFinally(outputStreamOpenOutputStream, (Throwable) null);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("is_pending", (Integer) 0);
                    Unit unit = Unit.INSTANCE;
                    contentResolver.update(uriInsert, contentValues2, null, null);
                    try {
                        return Environment.DIRECTORY_DOWNLOADS + "/TikTokYou/" + str;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(fileInputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.closeFinally(outputStreamOpenOutputStream, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            z = false;
        }
        if (!z) {
            contentResolver.delete(uriInsert, null, null);
        }
        throw th;
    }

    public static String a(Context context, File file, String str) throws IOException {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        File fileResolve = FilesKt.resolve(externalFilesDir, "TikTokYou");
        if (!fileResolve.exists() && !fileResolve.mkdirs()) {
            throw new IOException(di.a("aMRWxeBd3sfr2X6SmWk3yOrRDabNUEcqLcYVOZsCo1Y=", "CKajoXDKZIv6MENN", "aes", new StringBuilder(), fileResolve.getAbsolutePath()));
        }
        File fileResolve2 = FilesKt.resolve(fileResolve, str);
        FileOutputStream fileOutputStream = new FileOutputStream(fileResolve2);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteStreamsKt.copyTo(fileInputStream, fileOutputStream, 1048576);
                CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                String absolutePath = fileResolve2.getAbsolutePath();
                return absolutePath;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileOutputStream, th3);
                throw th4;
            }
        }
    }
}
