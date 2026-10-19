package Z;

import android.os.Looper;
import android.os.SystemClock;
import com.windukk.mod.Main;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.io.FilesKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Cache;
import ni.shikatu.okhttp3.Dispatcher;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.ResponseBody;

public abstract class t {
    public static final AtomicBoolean a = new AtomicBoolean();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return t.c();
        }
    });
    public static final ThreadLocal c = new ThreadLocal();
    public static final Lazy d = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return t.a();
        }
    });
    public static final Lazy e = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return t.b();
        }
    });

    public static final OkHttpClient a() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(16);
        dispatcher.setMaxRequestsPerHost(4);
        OkHttpClient.Builder builderDispatcher = new OkHttpClient.Builder().dispatcher(dispatcher);
        File cacheDir = Main.getApplicationContext().getCacheDir();
        OkHttpClient.Builder builderCache = builderDispatcher.cache(new Cache(FilesKt.resolve(cacheDir, "tty_http"), 8388608L));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderCache.connectTimeout(8L, timeUnit).readTimeout(8L, timeUnit).followRedirects(true).followSslRedirects(true).retryOnConnectionFailure(true).build();
    }

    public static final OkHttpClient b() {
        OkHttpClient.Builder builderCache = ((OkHttpClient) d.getValue()).newBuilder().cache((Cache) null);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderCache.connectTimeout(15L, timeUnit).readTimeout(120L, timeUnit).writeTimeout(30L, timeUnit).build();
    }

    public static final Boolean c() {
        return Boolean.FALSE;
    }

    public static final s b(String str, String str2, int i, Map map, String str3) {
        Request.Builder builder = new Request.Builder().url(str3).get();
        if (str != null && str.length() != 0) {
            builder.header("User-Agent", str);
        }
        if (str2 != null && str2.length() != 0) {
            builder.header("If-None-Match", str2);
        }
        for (Map.Entry entry : map.entrySet()) {
            builder.header((String) entry.getKey(), (String) entry.getValue());
        }
        Response responseExecute = ((OkHttpClient) d.getValue()).newCall(builder.build()).execute();
        try {
            if (a.compareAndSet(false, true)) {
                responseExecute.protocol();
            }
            int iCode = responseExecute.code();
            String strHeader$default = Response.header$default(responseExecute, "ETag", (String) null, 2, (Object) null);
            String string = responseExecute.request().url().toString();
            if (iCode == 304) {
                s sVar = new s(iCode, null, strHeader$default, string, responseExecute.headers());
                CloseableKt.closeFinally(responseExecute, (Throwable) null);
                return sVar;
            }
            if (responseExecute.isSuccessful()) {
                ResponseBody responseBodyBody = responseExecute.body();
                long jContentLength = responseBodyBody.contentLength();
                long j = i;
                if (jContentLength <= j) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((1 > jContentLength || jContentLength > j) ? 8192 : (int) jContentLength);
                    InputStream inputStreamByteStream = responseBodyBody.byteStream();
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i2 = inputStreamByteStream.read(bArr);
                            if (i2 >= 0) {
                                if (byteArrayOutputStream.size() + i2 <= i) {
                                    byteArrayOutputStream.write(bArr, 0, i2);
                                } else {
                                    throw new IOException("Response exceeds " + i + " bytes");
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStreamByteStream, (Throwable) null);
                                s sVar2 = new s(iCode, byteArrayOutputStream.toByteArray(), strHeader$default, string, responseExecute.headers());
                                CloseableKt.closeFinally(responseExecute, (Throwable) null);
                                return sVar2;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamByteStream, th);
                            throw th2;
                        }
                    }
                } else {
                    throw new IOException("Response too large: " + jContentLength);
                }
            } else {
                throw new r(iCode, str3);
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(responseExecute, th3);
                throw th4;
            }
        }
    }

    public static final Object a(Callable callable) {
        ThreadLocal threadLocal = b;
        Boolean bool = (Boolean) threadLocal.get();
        threadLocal.set(Boolean.TRUE);
        try {
            return callable.call();
        } finally {
            b.set(bool);
        }
    }

    public static final s a(String str, final String str2, final int i, final Map map, final String str3) {
        return (s) a(str, new Function1() {
            public final Object invoke(Object obj) {
                return t.b(str2, str3, i, map, (String) obj);
            }
        });
    }

    public static final void a(String str, final File file, final String str2, final Map map) throws IOException {
        final long j = 201326592;
        a(str, new Function1() {
            public final Object invoke(Object obj) {
                return t.a(file, str2, j, map, (String) obj);
            }
        });
    }

    public static final Unit a(File file, String str, long j, Map map, String str2) throws IOException {
        if (j > 0) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create download directory");
            }
            Request.Builder builder = new Request.Builder().url(str2).get();
            if (str != null && str.length() != 0) {
                builder.header("User-Agent", str);
            }
            for (Map.Entry entry : map.entrySet()) {
                builder.header((String) entry.getKey(), (String) entry.getValue());
            }
            Response responseExecute = ((OkHttpClient) e.getValue()).newCall(builder.build()).execute();
            try {
                if (responseExecute.isSuccessful()) {
                    if (Intrinsics.areEqual(responseExecute.request().url().scheme(), "https")) {
                        ResponseBody responseBodyBody = responseExecute.body();
                        long jContentLength = responseBodyBody.contentLength();
                        if (jContentLength <= j) {
                            File file2 = new File(file.getParentFile(), file.getName() + ".part");
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    InputStream inputStreamByteStream = responseBodyBody.byteStream();
                                    try {
                                        byte[] bArr = new byte[65536];
                                        long j2 = 0;
                                        while (true) {
                                            int i = inputStreamByteStream.read(bArr);
                                            if (i < 0) {
                                                if (j2 > 0) {
                                                    fileOutputStream.flush();
                                                    fileOutputStream.getFD().sync();
                                                    Unit unit = Unit.INSTANCE;
                                                    CloseableKt.closeFinally(inputStreamByteStream, (Throwable) null);
                                                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                                    if (file.exists() && !file.delete()) {
                                                        throw new IOException("Cannot replace " + file.getName());
                                                    }
                                                    if (!file2.renameTo(file)) {
                                                        FilesKt.copyTo$default(file2, file, true, 0, 4, (Object) null);
                                                        if (!file2.delete()) {
                                                            g7.a(6, g7.a("Cannot delete OTA staging file %s", new Object[]{file2.getAbsolutePath()}), (Throwable) null);
                                                        }
                                                    }
                                                    CloseableKt.closeFinally(responseExecute, (Throwable) null);
                                                    return unit;
                                                }
                                                throw new IOException("Empty download");
                                            }
                                            j2 += (long) i;
                                            if (j2 <= j) {
                                                fileOutputStream.write(bArr, 0, i);
                                            } else {
                                                throw new IOException("Response exceeds " + j + " bytes");
                                            }
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            CloseableKt.closeFinally(inputStreamByteStream, th);
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
                            } catch (Throwable th5) {
                                file2.delete();
                                file.delete();
                                throw th5;
                            }
                        } else {
                            throw new IOException("Response too large: " + jContentLength);
                        }
                    } else {
                        throw new IOException("Refusing non-HTTPS download");
                    }
                } else {
                    throw new r(responseExecute.code(), str2);
                }
            } catch (Throwable th6) {
                try {
                    throw th6;
                } catch (Throwable th7) {
                    CloseableKt.closeFinally(responseExecute, th6);
                    throw th7;
                }
            }
        } else {
            throw new IOException("Invalid download size limit");
        }
    }

    public static Object a(String str, Function1 function1) throws IOException {
        int i;
        Looper mainLooper;
        if (!Intrinsics.areEqual(b.get(), Boolean.TRUE)) {
            int i2 = q.a;
            if ((StringsKt.startsWith$default(str, "https://tiktokyou.yzewe.ru/", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://tiktokyou-fb.yzewe.ru/", false, 2, (Object) null)) && ((mainLooper = Looper.getMainLooper()) == null || mainLooper != Looper.myLooper())) {
                Long l = (Long) c.get();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (l == null || jElapsedRealtime - l.longValue() >= 30000) {
                    long jA = q.a();
                    if (jA > 0) {
                        try {
                            Thread.sleep(jA);
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    c.set(Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        }
        try {
            return function1.invoke(str);
        } catch (IOException e3) {
            String strDecrypt = "https://tiktokyou.yzewe.ru/";
            if (StringsKt.startsWith$default(str, strDecrypt, false, 2, (Object) null) && (!(e3 instanceof r) || (i = ((r) e3).a) == 408 || i == 429 || (500 <= i && i < 600))) {
                try {
                    return function1.invoke("https://tiktokyou-fb.yzewe.ru/" + StringsKt.removePrefix(str, strDecrypt));
                } catch (IOException e4) {
                    ExceptionsKt.addSuppressed(e4, e3);
                    throw e4;
                }
            }
            throw e3;
        }
    }
}
