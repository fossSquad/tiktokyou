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
        Context applicationContext = context.getApplicationContext();
        File cacheDir = applicationContext.getCacheDir();
        if (cacheDir == null) {
            cacheDir = applicationContext.getFilesDir();
        }
        File fileResolve = FilesKt.resolve(cacheDir, "tty_heap_dumps");
        if (!fileResolve.exists() && !fileResolve.mkdirs()) {
            throw new IOException("Cannot create heap dump directory");
        }
        String strA2 = ((new StringBuilder()).append("ttmod_heap_").append(new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US).format(new Date()))).append(".hprof").toString();
        File fileResolve2 = FilesKt.resolve(fileResolve, strA2);
        try {
            Debug.dumpHprofData(fileResolve2.getAbsolutePath());
            long length = fileResolve2.length();
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    a.getClass();
                    strA = b(applicationContext, fileResolve2, strA2);
                } else {
                    a.getClass();
                    strA = a(applicationContext, fileResolve2, strA2);
                }
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                throw new IOException(th);
            }
            p6 p6Var = new p6(length, strA);
            return p6Var;
        } finally {
            if (fileResolve2.exists() && !fileResolve2.delete()) {
                g7.a(6, g7.a("Failed to delete temporary heap dump: %s", new Object[]{fileResolve2.getAbsolutePath()}), (Throwable) null);
            }
        }
    }

    public static String b(Context context, File file, String str) throws Throwable {
        Throwable thU = null;
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "application/octet-stream");
        contentValues.put("relative_path", (new StringBuilder().append(Environment.DIRECTORY_DOWNLOADS)).append("/TikTokYou").toString());
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
            thU = th6;
            z = false;
        }
        if (!z) {
            contentResolver.delete(uriInsert, null, null);
        }
        throw thU;
    }

    public static String a(Context context, File file, String str) throws IOException {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        File fileResolve = FilesKt.resolve(externalFilesDir, "TikTokYou");
        if (!fileResolve.exists() && !fileResolve.mkdirs()) {
            throw new IOException("Cannot create " + fileResolve.getAbsolutePath());
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
