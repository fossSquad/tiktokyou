package Z;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;

public abstract class y2 {
    public static final ExecutorService a = Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public final Thread newThread(Runnable runnable) {
            return y2.a(runnable);
        }
    });

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "TikTokYou-DashMux");
        thread.setDaemon(true);
        return thread;
    }

    public static final Unit b(h3 h3Var, Throwable th) {
        h3Var.a();
        return Unit.INSTANCE;
    }

    public static void a(a3 a3Var, File file, long j, String str, final int i, final int i2, final Function1 function1) throws Throwable {
        Throwable th;
        int i3;
        List listEmptyList = a3Var.a.urlList;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = listEmptyList.iterator();
        while (true) {
            th = null;
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str2 = (String) next;
            if (StringsKt.startsWith$default(str2, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(str2, "http://", false, 2, (Object) null)) {
                arrayList.add((String) next);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalStateException(new StringBuilder().append(str).append(" track has no URL").toString().toString());
        }
        for (String str3 : arrayList) {
            i3++;
            try {
                function1.invoke(Integer.valueOf(i));
                try {
                    a(str3, file, new Function2() {
                        public final Object invoke(Object obj, Object obj2) {
                            return y2.a(function1, i, i2, ((Long) obj).longValue(), ((Long) obj2).longValue());
                        }
                    });
                    if (file.length() <= 0) {
                        throw new IllegalStateException((str + " track is empty").toString());
                    }
                    AtomicLong atomicLong = c4.a;
                    c4.a(Long.valueOf(j), str, Integer.valueOf(i3), Long.valueOf(file.length()));
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    file.delete();
                    AtomicLong atomicLong2 = c4.a;
                    c4.a(Long.valueOf(j), str, Integer.valueOf(i3), th.getClass().getSimpleName());
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (th != null) {
            throw th;
        }
        throw new IllegalStateException(new StringBuilder().append(str).append(" download failed").toString());
    }

    public static final void a(Context context, a4 a4Var, z2 z2Var, se seVar, final h3 h3Var, boolean z) {
        File file = new File(context.getCacheDir(), "tiktokyou_dash/session_" + a4Var.a);
        try {
            if (!file.mkdirs() && !file.isDirectory()) {
                throw new IllegalStateException("Cannot create DASH cache directory".toString());
            }
            File file2 = new File(file, "video.track");
            File file3 = new File(file, "audio.track");
            File file4 = new File(file, "result.mp4");
            a(z2Var.a, file2, a4Var.a, "video", 0, 50, new v2(seVar));
            a(z2Var.b, file3, a4Var.a, "audio", 50, 85, new w2(seVar));
            seVar.a(88);
            a(file2, file3, file4);
            seVar.a(95);
            a(context, a4Var, file4);
            AtomicLong atomicLong = c4.a;
            c4.a(Long.valueOf(a4Var.a), Long.valueOf(file4.length()));
            x2 x2Var = new x2(h3Var);
            seVar.a(re.a, x2Var);
            a(file);
        } catch (Throwable th) {
            try {
                h6.a(6, h6.a("DASH download/mux failed", new Object[0]), th);
                AtomicLong atomicLong2 = c4.a;
                c4.a(Long.valueOf(a4Var.a), th.getClass().getSimpleName(), th.getMessage());
                if (z) {
                    Function0 function0 = new Function0() {
                        public final Object invoke() {
                            return y2.a(h3Var, th);
                        }
                    };
                    seVar.getClass();
                    seVar.a(re.c, function0);
                } else {
                    Function0 function1 = new Function0() {
                        public final Object invoke() {
                            return y2.b(h3Var, th);
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

    public static void a(final a4 a4Var, b3 b3Var, final boolean z, final h3 h3Var) {
        final z2 z2Var = b3Var.t;
        if (z2Var == null) {
            new IllegalArgumentException("DASH selection is missing tracks");
            h3Var.a();
            return;
        }
        final Context contextA = Main.getApplicationContext();
        Lazy lazy = se.f;
        final se seVar = new se(a4Var);
        a.execute(new Runnable() {
            @Override
            public final void run() {
                y2.a(contextA, a4Var, z2Var, seVar, h3Var, z);
            }
        });
    }

    public static final Unit a(h3 h3Var, Throwable th) {
        h3Var.a();
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, int i, int i2, long j, long j2) {
        if (j2 > 0) {
            int i3 = i2 - i;
            function1.invoke(Integer.valueOf(RangesKt.coerceIn((int) (((double) i3) * (j / j2)), 0, i3) + i));
        }
        return Unit.INSTANCE;
    }

    public static void a(String str, File file, Function2 function2) throws IOException {
        Throwable th = null;
        Object obj;
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
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
                long contentLengthLong = httpURLConnection.getContentLengthLong();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 131072);
                try {
                    OutputStream fileOutputStream = new FileOutputStream(file);
                    BufferedOutputStream bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 131072);
                    try {
                        byte[] bArr = new byte[131072];
                        long j = 0;
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i >= 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                                j += (long) i;
                                function2.invoke(Long.valueOf(j), Long.valueOf(contentLengthLong));
                            } else {
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(bufferedOutputStream, (Throwable) null);
                                CloseableKt.closeFinally(bufferedInputStream, (Throwable) null);
                                httpURLConnection.disconnect();
                                return;
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
                    throw new RuntimeException(th5);
                }
            }
            throw new IllegalStateException(("HTTP " + responseCode).toString());
        } catch (Throwable th6) {
            httpURLConnection.disconnect();
            throw new RuntimeException(th6);
        }
    }

    public static void a(File file, File file2, File file3) throws Throwable {
        Throwable th = null;
        MediaMuxer mediaMuxer;
        Unit unit;
        MediaExtractor mediaExtractor = new MediaExtractor();
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        Unit unit2 = null;
        try {
            mediaExtractor.setDataSource(file.getAbsolutePath());
            mediaExtractor2.setDataSource(file2.getAbsolutePath());
            int iA = a(mediaExtractor, "video/");
            int iA2 = a(mediaExtractor2, "audio/");
            if (iA < 0) {
                throw new IllegalStateException("Downloaded video has no video track".toString());
            }
            if (iA2 < 0) {
                throw new IllegalStateException("Downloaded audio has no audio track".toString());
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(iA);
            MediaFormat trackFormat2 = mediaExtractor2.getTrackFormat(iA2);
            a(trackFormat, trackFormat2);
            mediaMuxer = new MediaMuxer(file3.getAbsolutePath(), 0);
            try {
                if (trackFormat.containsKey("rotation-degrees")) {
                    mediaMuxer.setOrientationHint(trackFormat.getInteger("rotation-degrees"));
                }
                int iAddTrack = mediaMuxer.addTrack(trackFormat);
                int iAddTrack2 = mediaMuxer.addTrack(trackFormat2);
                mediaMuxer.start();
                a(mediaExtractor, iA, mediaMuxer, iAddTrack, trackFormat);
                a(mediaExtractor2, iA2, mediaMuxer, iAddTrack2, trackFormat2);
                try {
                    Result.Companion companion = Result.Companion;
                    mediaMuxer.stop();
                    RCompat.m6constructorimpl(Unit.INSTANCE);
                } catch (Throwable th_2) {
                    th = th_2;
                    Result.Companion companion2 = Result.Companion;
                    RCompat.m6constructorimpl(ResultKt.createFailure(th));
                }
                try {
                    Result.Companion companion3 = Result.Companion;
                    mediaMuxer.release();
                    RCompat.m6constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    RCompat.m6constructorimpl(ResultKt.createFailure(th2));
                }
                mediaExtractor.release();
                mediaExtractor2.release();
                if (file3.length() <= 0) {
                    throw new IllegalStateException("Muxer produced an empty file".toString());
                }
                MediaExtractor mediaExtractor3 = new MediaExtractor();
                try {
                    mediaExtractor3.setDataSource(file3.getAbsolutePath());
                    if (a(mediaExtractor3, "video/") >= 0) {
                        if (a(mediaExtractor3, "audio/") < 0) {
                            throw new IllegalStateException("Muxed file has no audio track".toString());
                        }
                        mediaExtractor3.release();
                        return;
                    }
                    throw new IllegalStateException("Muxed file has no video track".toString());
                } catch (Throwable th3) {
                    mediaExtractor3.release();
                    throw th3;
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    Result.Companion companion5 = Result.Companion;
                    if (mediaMuxer != null) {
                        mediaMuxer.stop();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    RCompat.m6constructorimpl(unit);
                } catch (Throwable th5) {
                    Result.Companion companion6 = Result.Companion;
                    RCompat.m6constructorimpl(ResultKt.createFailure(th5));
                }
                try {
                    Result.Companion companion7 = Result.Companion;
                    if (mediaMuxer != null) {
                        mediaMuxer.release();
                        unit2 = Unit.INSTANCE;
                    }
                    RCompat.m6constructorimpl(unit2);
                } catch (Throwable th6) {
                    Result.Companion companion8 = Result.Companion;
                    RCompat.m6constructorimpl(ResultKt.createFailure(th6));
                }
                mediaExtractor.release();
                mediaExtractor2.release();
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            mediaMuxer = null;
        }
    }

    public static void a(MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        String string = mediaFormat.getString("mime");
        if (string == null) {
            string = "";
        }
        String string2 = mediaFormat2.getString("mime");
        String str = string2 != null ? string2 : "";
        if (!SetsKt.setOf(new String[]{"video/avc", "video/hevc", "video/mp4v-es", "video/av01"}).contains(string)) {
            throw new IllegalStateException(new StringBuilder().append("Unsupported DASH video codec: ").append(string).toString().toString());
        }
        if (!SetsKt.setOf(new String[]{"audio/mp4a-latm", "audio/mpeg", "audio/opus", "audio/vorbis"}).contains(str)) {
            throw new IllegalStateException(new StringBuilder().append("Unsupported DASH audio codec: ").append(str).toString().toString());
        }
    }

    public static int a(MediaExtractor mediaExtractor, String str) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString("mime");
            if (string == null) {
                string = "";
            }
            if (StringsKt.startsWith$default(string, str, false, 2, (Object) null)) {
                return i;
            }
        }
        return -1;
    }

    public static void a(MediaExtractor mediaExtractor, int i, MediaMuxer mediaMuxer, int i2, MediaFormat mediaFormat) {
        mediaExtractor.selectTrack(i);
        mediaExtractor.seekTo(0L, 2);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(RangesKt.coerceAtMost(Math.max(2097152, mediaFormat.containsKey("max-input-size") ? mediaFormat.getInteger("max-input-size") : 2097152), 33554432));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        do {
            byteBufferAllocateDirect.clear();
            int sampleData = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
            if (sampleData < 0) {
                break;
            }
            if (sampleData <= byteBufferAllocateDirect.capacity()) {
                bufferInfo.offset = 0;
                bufferInfo.size = sampleData;
                bufferInfo.presentationTimeUs = RangesKt.coerceAtLeast(mediaExtractor.getSampleTime(), 0L);
                bufferInfo.flags = mediaExtractor.getSampleFlags();
                mediaMuxer.writeSampleData(i2, byteBufferAllocateDirect, bufferInfo);
            } else {
                throw new IllegalStateException("Media sample exceeds mux buffer".toString());
            }
        } while (mediaExtractor.advance());
        mediaExtractor.unselectTrack(i);
    }

    public static void a(Context context, a4 a4Var, File file) {
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
                throw new RuntimeException(th5);
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
