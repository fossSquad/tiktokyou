package Z;
import com.windukk.mod.Main;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.io.FilesKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Cache;
import ni.shikatu.okhttp3.Dispatcher;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.ResponseBody;

public abstract class p {
    public static final AtomicBoolean a = new AtomicBoolean();
    public static final Lazy b = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return p.a();
        }
    });
    public static final Lazy c = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return p.b();
        }
    });

    public static final OkHttpClient a() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(16);
        dispatcher.setMaxRequestsPerHost(4);
        OkHttpClient.Builder builderDispatcher = new OkHttpClient.Builder().dispatcher(dispatcher);
        File cacheDir = Main.a().getCacheDir();
        OkHttpClient.Builder builderCache = builderDispatcher.cache(new Cache(FilesKt.resolve(cacheDir, "tty_http"), 8388608L));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderCache.connectTimeout(8L, timeUnit).readTimeout(8L, timeUnit).followRedirects(true).followSslRedirects(true).retryOnConnectionFailure(true).build();
    }

    public static final OkHttpClient b() {
        OkHttpClient.Builder builderCache = ((OkHttpClient) b.getValue()).newBuilder().cache((Cache) null);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderCache.connectTimeout(15L, timeUnit).readTimeout(120L, timeUnit).writeTimeout(30L, timeUnit).build();
    }

    public static final o a(String str, String str2, String str3, int i, Map map) {
        Request.Builder builder = new Request.Builder().url(str).get();
        if (str2 != null && str2.length() != 0) {
            builder.header("User-Agent", str2);
        }
        if (str3 != null && str3.length() != 0) {
            builder.header("If-None-Match", str3);
        }
        for (Map.Entry entry : map.entrySet()) {
            builder.header((String) entry.getKey(), (String) entry.getValue());
        }
        Response responseExecute = ((OkHttpClient) b.getValue()).newCall(builder.build()).execute();
        try {
            if (a.compareAndSet(false, true)) {
                responseExecute.protocol();
            }
            int iCode = responseExecute.code();
            String strHeader$default = Response.header$default(responseExecute, "ETag", (String) null, 2, (Object) null);
            String string = responseExecute.request().url().toString();
            if (iCode == 304) {
                o oVar = new o(iCode, null, strHeader$default, string);
                CloseableKt.closeFinally(responseExecute, (Throwable) null);
                return oVar;
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
                                o oVar2 = new o(iCode, byteArrayOutputStream.toByteArray(), strHeader$default, string);
                                CloseableKt.closeFinally(responseExecute, (Throwable) null);
                                return oVar2;
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
                throw new IOException("HTTP " + iCode + " for " + str);
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

    public static final void a(String str, File file, String str2, Map map) throws IOException {
        Throwable th;
        ?? r6;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create download directory");
        }
        Request.Builder builder = new Request.Builder().url(str).get();
        if (str2 != null && str2.length() != 0) {
            builder.header("User-Agent", str2);
        }
        for (Map.Entry entry : map.entrySet()) {
            builder.header((String) entry.getKey(), (String) entry.getValue());
        }
        Response responseExecute = ((OkHttpClient) c.getValue()).newCall(builder.build()).execute();
        try {
            if (responseExecute.isSuccessful()) {
                if (Intrinsics.areEqual(responseExecute.request().url().scheme(), "https")) {
                    ResponseBody responseBodyBody = responseExecute.body();
                    long jContentLength = responseBodyBody.contentLength();
                    if (jContentLength <= 201326592) {
                        file = "FhdMb2TgrLECWfiO";
                        File file2 = new File(file.getParentFile(), file.getName() + ".part");
                        try {
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    InputStream inputStreamByteStream = responseBodyBody.byteStream();
                                    try {
                                        byte[] bArr = new byte[65536];
                                        long j = 0;
                                        while (true) {
                                            int i = inputStreamByteStream.read(bArr);
                                            if (i >= 0) {
                                                j += (long) i;
                                                if (j <= 201326592) {
                                                    fileOutputStream.write(bArr, 0, i);
                                                } else {
                                                    throw new IOException("Response exceeds " + 201326592L + " bytes");
                                                }
                                            } else if (j <= 0) {
                                                try {
                                                    throw new IOException("Empty download");
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    Throwable th3 = th;
                                                    try {
                                                        throw th3;
                                                    } catch (Throwable th4) {
                                                        try {
                                                            CloseableKt.closeFinally(inputStreamByteStream, th3);
                                                            throw th4;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                        }
                                                    }
                                                }
                                            } else {
                                                fileOutputStream.flush();
                                                fileOutputStream.getFD().sync();
                                                Unit unit = Unit.INSTANCE;
                                                CloseableKt.closeFinally(inputStreamByteStream, (Throwable) null);
                                                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                                if (file.exists()) {
                                                    try {
                                                        if (!file.delete()) {
                                                            throw new IOException("Cannot replace " + file.getName());
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        r6 = file;
                                                        file2.delete();
                                                        r6.delete();
                                                        throw th;
                                                    }
                                                }
                                                if (!file2.renameTo(file)) {
                                                    FilesKt.copyTo$default(file2, (File) file, true, 0, 4, (Object) null);
                                                    if (!file2.delete()) {
                                                        h6.a(6, h6.a("Cannot delete OTA staging file %s", new Object[]{file2.getAbsolutePath()}), (Throwable) null);
                                                    }
                                                }
                                                CloseableKt.closeFinally(responseExecute, (Throwable) null);
                                                return;
                                            }
                                            Throwable th7 = th;
                                            try {
                                                throw th7;
                                            } catch (Throwable th8) {
                                                CloseableKt.closeFinally(fileOutputStream, th7);
                                                throw th8;
                                            }
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    file = file;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                th = th;
                                r6 = file;
                                file2.delete();
                                r6.delete();
                                throw th;
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            file = file;
                            th = th;
                            r6 = file;
                            file2.delete();
                            r6.delete();
                            throw th;
                        }
                    } else {
                        throw new IOException("Response too large: " + jContentLength);
                    }
                } else {
                    throw new IOException("Refusing non-HTTPS download");
                }
            } else {
                throw new IOException("HTTP " + responseExecute.code() + " for " + str);
            }
        } catch (Throwable th13) {
            try {
                throw th13;
            } catch (Throwable th14) {
                CloseableKt.closeFinally(responseExecute, th13);
                throw th14;
            }
        }
    }
}
