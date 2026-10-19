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

public abstract class ie {
    public static final ExecutorService a = Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public final Thread newThread(Runnable runnable) {
            return ie.a(runnable);
        }
    });

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "TikTokYou-Progressive");
        thread.setDaemon(true);
        return thread;
    }

    public static final Unit b(t3 t3Var, Throwable th) {
        t3Var.getClass();
        if (t3Var.b != null) {
            g7.a(4, g7.a("Direct progressive download failed, starting official fallback source=%s", new Object[]{t3Var.b.b}), (Throwable) null);
            ThreadLocal threadLocal = v3.a;
            v3.a(t3Var.b, t3Var.a, t3Var.c, t3Var.d);
        } else {
            AtomicLong atomicLong = r4.a;
            r4.a(t3Var.a);
        }
        return Unit.INSTANCE;
    }

    public static void a(final p4 p4Var, final o3 o3Var, final boolean z, final t3 t3Var) {
        final Context contextA = Main.getApplicationContext();
        Lazy lazy = fg.f;
        final fg fgVar = new fg(p4Var);
        a.execute(new Runnable() {
            @Override
            public final void run() {
                ie.a(contextA, p4Var, o3Var, fgVar, t3Var, z);
            }
        });
    }

    public static final void a(Context context, p4 p4Var, o3 o3Var, fg fgVar, final t3 t3Var, boolean z) {
        File file = new File(context.getCacheDir(), "tiktokyou_progressive/session_" + p4Var.a);
        try {
            if (!file.mkdirs() && !file.isDirectory()) {
                throw new IllegalStateException("Cannot create progressive cache directory".toString());
            }
            File file2 = new File(file, "result.mp4");
            a(p4Var, o3Var, file2, new ge(fgVar));
            a(o3Var, file2);
            a(context, p4Var, file2);
            AtomicLong atomicLong = r4.a;
            r4.a(Long.valueOf(p4Var.a), o3Var.b, Long.valueOf(file2.length()));
            he heVar = new he(t3Var);
            fgVar.getClass();
            fgVar.a(eg.a, heVar);
            a(file);
        } catch (Throwable th) {
            try {
                g7.a(6, g7.a("Direct progressive download failed", new Object[0]), th);
                AtomicLong atomicLong2 = r4.a;
                r4.a(Long.valueOf(p4Var.a), th.getClass().getSimpleName(), th.getMessage());
                if (z) {
                    Function0 function0 = new Function0() {
                        public final Object invoke() {
                            return ie.a(t3Var, th);
                        }
                    };
                    fgVar.getClass();
                    fgVar.a(eg.c, function0);
                } else {
                    Function0 function1 = new Function0() {
                        public final Object invoke() {
                            return ie.b(t3Var, th);
                        }
                    };
                    fgVar.getClass();
                    fgVar.a(eg.b, function1);
                }
            } finally {
                a(file);
            }
        }
    }

    public static void a(p4 p4Var, o3 o3Var, File file, ge geVar) throws Throwable {
        Throwable th;
        List listEmptyList = o3Var.a.urlList;
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
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            int i = 0;
            for (String str2 : arrayList) {
                i++;
                try {
                    geVar.invoke(0);
                    long jA = a(str2, file, o3Var.g, geVar);
                    long length = file.length();
                    if (length > 0) {
                        if (jA > 0 && length != jA) {
                            throw new IllegalStateException(("Incomplete HTTP body: " + length + " of " + jA + " bytes").toString());
                        }
                        long j = o3Var.g;
                        if (j > 0 && length != j) {
                            throw new IllegalStateException(("Unexpected file size: " + length + " instead of " + j + " bytes").toString());
                        }
                        AtomicLong atomicLong = r4.a;
                        r4.a(Long.valueOf(p4Var.a), Integer.valueOf(i), Long.valueOf(length), Long.valueOf(o3Var.g));
                        return;
                    }
                    throw new IllegalStateException("Downloaded file is empty".toString());
                } catch (Throwable th2) {
                    th = th2;
                    file.delete();
                    AtomicLong atomicLong2 = r4.a;
                    r4.a(Long.valueOf(p4Var.a), Integer.valueOf(i), th.getClass().getSimpleName(), th.getMessage());
                }
            }
            if (th != null) {
                throw th;
            }
            throw new IllegalStateException("Progressive download failed");
        }
        throw new IllegalStateException("Progressive choice has no URL".toString());
    }

    public static final Unit a(t3 t3Var, Throwable th) {
        t3Var.getClass();
        if (t3Var.b != null) {
            g7.a(4, g7.a("Direct progressive download failed, starting official fallback source=%s", new Object[]{t3Var.b.b}), (Throwable) null);
            ThreadLocal threadLocal = v3.a;
            v3.a(t3Var.b, t3Var.a, t3Var.c, t3Var.d);
        } else {
            AtomicLong atomicLong = r4.a;
            r4.a(t3Var.a);
        }
        return Unit.INSTANCE;
    }

    public static long a(String str, File file, long j, ge geVar) throws IOException {
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
            obj = Result.constructor-impl(CookieManager.getInstance().getCookie(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
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
                                        geVar.invoke(Integer.valueOf(RangesKt.coerceIn((int) ((j3 / jLongValue) * 99.0d), 0, 99)));
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
    }

    public static void a(o3 o3Var, File file) {
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
                ci ciVar = o3Var.f;
                if ((ciVar != ci.a && ciVar != ci.c) || i >= 0) {
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
                        int i5 = o3Var.j;
                        if (i5 > 0 && (i2 = o3Var.k) > 0 && integer > 0 && integer2 > 0) {
                            boolean z = integer == i5 && integer2 == i2;
                            boolean z2 = integer == i2 && integer2 == i5;
                            if (!z && !z2) {
                                throw new IllegalStateException(("Unexpected dimensions: " + integer + "x" + integer2 + " instead of " + i5 + "x" + i2).toString());
                            }
                        }
                        AtomicLong atomicLong = r4.a;
                        r4.a(str, Integer.valueOf(integer), Integer.valueOf(integer2), Boolean.valueOf(i >= 0));
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
    }

    public static void a(Context context, p4 p4Var, File file) {
        Uri contentUri;
        ContentResolver contentResolver = context.getContentResolver();
        Object objValueOf = p4Var.c.aid;
        if (objValueOf == null) {
            objValueOf = Long.valueOf(p4Var.a);
        }
        String strA = d3.a("sRkwx1pMwvoiawlKe6a9by4v8SNfBbJ7DE7fZ0RD/kk=", "TO1aFLI3JdpKl6Ng", "aes", new StringBuilder().append("TikTok_").append(objValueOf));
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", strA);
        contentValues.put("mime_type", "video/mp4");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            contentValues.put("relative_path", w3.a());
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
