package Z;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.webkit.CookieManager;
import com.windukk.mod.Main;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.io.ByteStreamsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;

public abstract class tc {
    public static final ExecutorService a = Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public final Thread newThread(Runnable runnable) {
            return tc.a(runnable);
        }
    });

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "TikTokYou-Progressive");
        thread.setDaemon(true);
        return thread;
    }

    public static final Unit b(g3 g3Var, Throwable th) {
        g3Var.getClass();
        if (g3Var.b != null) {
            h6.a(4, h6.a("Direct progressive download failed, starting official fallback source=%s", new Object[]{g3Var.b.b}), (Throwable) null);
            ThreadLocal threadLocal = i3.a;
            i3.a(g3Var.b, g3Var.a, g3Var.c, g3Var.d);
        } else {
            AtomicLong atomicLong = c4.a;
            c4.a(g3Var.a);
        }
        return Unit.INSTANCE;
    }

    public static void a(final a4 a4Var, final b3 b3Var, final boolean z, final g3 g3Var) {
        final Context contextA = Main.getApplicationContext();
        Lazy lazy = se.f;
        final se seVar = new se(a4Var);
        a.execute(new Runnable() {
            @Override
            public final void run() {
                tc.a(contextA, a4Var, b3Var, seVar, g3Var, z);
            }
        });
    }

    public static final void a(Context context, a4 a4Var, b3 b3Var, se seVar, final g3 g3Var, boolean z) {
        File file = new File(context.getCacheDir(), "tiktokyou_progressive/session_" + a4Var.a);
        try {
            if (!file.mkdirs() && !file.isDirectory()) {
                throw new IllegalStateException("Cannot create progressive cache directory".toString());
            }
            File file2 = new File(file, "result.mp4");
            a(a4Var, b3Var, file2, new rc(seVar));
            a(b3Var, file2);
            a(context, a4Var, file2);
            AtomicLong atomicLong = c4.a;
            c4.a(Long.valueOf(a4Var.a), b3Var.b, Long.valueOf(file2.length()));
            sc scVar = new sc(g3Var);
            seVar.getClass();
            seVar.a(re.a, scVar);
            a(file);
        } catch (Throwable th) {
            try {
                h6.a(6, h6.a("Direct progressive download failed", new Object[0]), th);
                AtomicLong atomicLong2 = c4.a;
                c4.a(Long.valueOf(a4Var.a), th.getClass().getSimpleName(), th.getMessage());
                if (z) {
                    Function0 function0 = new Function0() {
                        public final Object invoke() {
                            return tc.a(g3Var, th);
                        }
                    };
                    seVar.getClass();
                    seVar.a(re.c, function0);
                } else {
                    Function0 function1 = new Function0() {
                        public final Object invoke() {
                            return tc.b(g3Var, th);
                        }
                    };
                    seVar.getClass();
                    seVar.a(re.b, function1);
                }
            } finally {
                a(file);
            }
        }
    }

    public static void a(a4 a4Var, b3 b3Var, File file, rc rcVar) throws Throwable {
        Throwable th;
        List listEmptyList = b3Var.a.urlList;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = listEmptyList.iterator();
        while (true) {
            th = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            if (StringsKt.startsWith$default(str, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "http://", false, 2, (Object) null)) {
                arrayList.add((String) next);
            }
        }
        if (!arrayList.isEmpty()) {
            int i = 0;
            for (String str2 : arrayList) {
                i++;
                try {
                    rcVar.invoke(0);
                    long jA = a(str2, file, b3Var.g, rcVar);
                    long length = file.length();
                    if (length > 0) {
                        if (jA > 0 && length != jA) {
                            throw new IllegalStateException(("Incomplete HTTP body: " + length + " of " + jA + " bytes").toString());
                        }
                        long j = b3Var.g;
                        if (j > 0 && length != j) {
                            throw new IllegalStateException(("Unexpected file size: " + length + " instead of " + j + " bytes").toString());
                        }
                        AtomicLong atomicLong = c4.a;
                        c4.a(Long.valueOf(a4Var.a), Integer.valueOf(i), Long.valueOf(length), Long.valueOf(b3Var.g));
                        return;
                    }
                    throw new IllegalStateException("Downloaded file is empty".toString());
                } catch (Throwable th2) {
                    th = th2;
                    file.delete();
                    AtomicLong atomicLong2 = c4.a;
                    c4.a(Long.valueOf(a4Var.a), Integer.valueOf(i), th.getClass().getSimpleName(), th.getMessage());
                }
            }
            if (th != null) {
                throw th;
            }
            throw new IllegalStateException("Progressive download failed");
        }
        throw new IllegalStateException("Progressive choice has no URL".toString());
    }

    public static final Unit a(g3 g3Var, Throwable th) {
        g3Var.getClass();
        if (g3Var.b != null) {
            h6.a(4, h6.a("Direct progressive download failed, starting official fallback source=%s", new Object[]{g3Var.b.b}), (Throwable) null);
            ThreadLocal threadLocal = i3.a;
            i3.a(g3Var.b, g3Var.a, g3Var.c, g3Var.d);
        } else {
            AtomicLong atomicLong = c4.a;
            c4.a(g3Var.a);
        }
        return Unit.INSTANCE;
    }

    public static long a(String str, File file, long j, rc rcVar) throws IOException {
        try {
            Throwable th = null;
            Object obj;
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(45000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "video/mp4,video/*;q=0.9,*/*;q=0.8");
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 Chrome/120.0 Mobile Safari/537.36");
            httpURLConnection.setRequestProperty("Referer", "https://www.tiktok.com/");
            try {
                Result.Companion companion = Result.Companion;
                obj = RCompat.m6constructorimpl(CookieManager.getInstance().getCookie(str));
            } catch (Throwable th_2) {
                th = th_2;
                Result.Companion companion2 = Result.Companion;
                obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
            }
            if (RCompat.m12isFailureimpl(obj)) {
                obj = null;
            }
            String str2 = (String) obj;
            if (str2 != null) {
                if (StringsKt.isBlank(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    httpURLConnection.setRequestProperty("Cookie", str2);
                }
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (200 <= responseCode && responseCode < 300) {
                    String contentType = httpURLConnection.getContentType();
                    if (contentType == null) {
                        contentType = "";
                    }
                    String lowerCase = contentType.toLowerCase(Locale.ROOT);
                    if (!StringsKt.startsWith$default(lowerCase, "text/", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase, "json", false, 2, (Object) null)) {
                        long contentLengthLong = httpURLConnection.getContentLengthLong();
                        Long lValueOf = Long.valueOf(contentLengthLong);
                        long j2 = 0;
                        if (contentLengthLong <= 0) {
                            lValueOf = null;
                        }
                        long jLongValue = lValueOf != null ? lValueOf.longValue() : j;
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 131072);
                        try {
                            OutputStream fileOutputStream = new FileOutputStream(file);
                            BufferedOutputStream bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 131072);
                            try {
                                byte[] bArr = new byte[131072];
                                long j3 = 0;
                                while (true) {
                                    int i = bufferedInputStream.read(bArr);
                                    if (i >= 0) {
                                        bufferedOutputStream.write(bArr, 0, i);
                                        long j4 = j2;
                                        j3 += (long) i;
                                        if (jLongValue > j4) {
                                            rcVar.invoke(Integer.valueOf(RangesKt.coerceIn((int) ((j3 / jLongValue) * 99.0d), 0, 99)));
                                        }
                                        j2 = j4;
                                        contentLengthLong = contentLengthLong;
                                    } else {
                                        long j5 = contentLengthLong;
                                        Unit unit = Unit.INSTANCE;
                                        CloseableKt.closeFinally(bufferedOutputStream, (Throwable) null);
                                        CloseableKt.closeFinally(bufferedInputStream, (Throwable) null);
                                        httpURLConnection.disconnect();
                                        return j5;
                                    }
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        CloseableKt.closeFinally(bufferedInputStream, th);
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th3) {
                                try {
                                    throw th3;
                                } catch (Throwable th4) {
                                    CloseableKt.closeFinally(bufferedOutputStream, th3);
                                    throw th4;
                                }
                            }
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    }
                    throw new IllegalStateException(("Unexpected content type: " + lowerCase).toString());
                }
                throw new IllegalStateException(("HTTP " + responseCode).toString());
            } catch (Throwable th6) {
                httpURLConnection.disconnect();
                throw th6;
            }
        } catch (Throwable t) {
            return 0;
        }
    }

    public static void a(b3 b3Var, File file) {
        try {
            String str;
            int i;
            int i2;
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(file.getAbsolutePath());
                String strDecrypt = "video/";
                int trackCount = mediaExtractor.getTrackCount();
                int i3 = 0;
                while (true) {
                    str = "";
                    if (i3 >= trackCount) {
                        i3 = -1;
                        break;
                    }
                    String string = mediaExtractor.getTrackFormat(i3).getString("mime");
                    if (string == null) {
                        string = "";
                    }
                    if (StringsKt.startsWith$default(string, strDecrypt, false, 2, (Object) null)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                String strDecrypt2 = "audio/";
                int trackCount2 = mediaExtractor.getTrackCount();
                int i4 = 0;
                while (true) {
                    if (i4 >= trackCount2) {
                        i = -1;
                        break;
                    }
                    String string2 = mediaExtractor.getTrackFormat(i4).getString("mime");
                    if (string2 == null) {
                        string2 = "";
                    }
                    if (StringsKt.startsWith$default(string2, strDecrypt2, false, 2, (Object) null)) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i3 >= 0) {
                    jg jgVar = b3Var.f;
                    if ((jgVar != jg.a && jgVar != jg.c) || i >= 0) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                        String string3 = trackFormat.getString("mime");
                        if (string3 != null) {
                            str = string3;
                        }
                        if (SetsKt.setOf(new String[]{"video/avc", "video/hevc", "video/mp4v-es", "video/av01"}).contains(str)) {
                            String strDecrypt3 = "width";
                            int integer = trackFormat.containsKey(strDecrypt3) ? trackFormat.getInteger(strDecrypt3) : 0;
                            String strDecrypt4 = "height";
                            int integer2 = trackFormat.containsKey(strDecrypt4) ? trackFormat.getInteger(strDecrypt4) : 0;
                            int i5 = b3Var.j;
                            if (i5 > 0 && (i2 = b3Var.k) > 0 && integer > 0 && integer2 > 0) {
                                boolean z = integer == i5 && integer2 == i2;
                                boolean z2 = integer == i2 && integer2 == i5;
                                if (!z && !z2) {
                                    throw new IllegalStateException(("Unexpected dimensions: " + integer + "x" + integer2 + " instead of " + i5 + "x" + i2).toString());
                                }
                            }
                            AtomicLong atomicLong = c4.a;
                            c4.a(str, Integer.valueOf(integer), Integer.valueOf(integer2), Boolean.valueOf(i >= 0));
                            mediaExtractor.release();
                            return;
                        }
                        throw new IllegalStateException(("Unsupported video codec: " + str).toString());
                    }
                    throw new IllegalStateException("Downloaded MP4 has no audio track".toString());
                }
                throw new IllegalStateException("Downloaded MP4 has no video track".toString());
            } catch (Throwable th) {
                mediaExtractor.release();
                throw th;
            }
        } catch (Throwable t) {
        }
    }

    public static void a(Context context, a4 a4Var, File file) {
        try {
            Uri contentUri;
            ContentResolver contentResolver = context.getContentResolver();
            Object objValueOf = a4Var.c.aid;
            if (objValueOf == null) {
                objValueOf = Long.valueOf(a4Var.a);
            }
            String strA = new StringBuilder().append("TikTok_").append(objValueOf).append(".mp4").toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", strA);
            contentValues.put("mime_type", "video/mp4");
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                contentValues.put("relative_path", tg.a());
                contentValues.put("is_pending", (Integer) 1);
            }
            if (i >= 29) {
                contentUri = MediaStore.Video.Media.getContentUri("external_primary");
            } else {
                contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            }
            Uri uriInsert = contentResolver.insert(contentUri, contentValues);
            if (uriInsert != null) {
                try {
                    OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert, "w");
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            InputStream fileInputStream = new FileInputStream(file);
                            BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 131072);
                            try {
                                ByteStreamsKt.copyTo(bufferedInputStream, outputStreamOpenOutputStream, 131072);
                                CloseableKt.closeFinally(bufferedInputStream, (Throwable) null);
                                CloseableKt.closeFinally(outputStreamOpenOutputStream, (Throwable) null);
                                if (i >= 29) {
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put("is_pending", (Integer) 0);
                                    Unit unit = Unit.INSTANCE;
                                    contentResolver.update(uriInsert, contentValues2, null, null);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(bufferedInputStream, th);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(outputStreamOpenOutputStream, th3);
                                throw th4;
                            }
                        }
                    }
                    throw new IllegalStateException("MediaStore output stream unavailable".toString());
                } catch (Throwable th5) {
                    contentResolver.delete(uriInsert, null, null);
                    throw th5;
                }
            }
            throw new IllegalStateException("MediaStore insert returned null".toString());
        } catch (Throwable t) {
        }
    }

    public static void a(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                } else {
                    file2.delete();
                }
            }
        }
        file.delete();
    }
}
