package ni.shikatu.okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableIterator;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.cache.CacheRequest;
import ni.shikatu.okhttp3.internal.cache.CacheStrategy;
import ni.shikatu.okhttp3.internal.cache.DiskLruCache;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.http.HttpMethod;
import ni.shikatu.okhttp3.internal.http.StatusLine;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.ForwardingSink;
import ni.shikatu.okio.ForwardingSource;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Path;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0004IJKLB)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020$H\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020-2\u0006\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b.J\u001d\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$H\u0000¢\u0006\u0002\b2J\u0016\u00103\u001a\u00020-2\f\u00104\u001a\b\u0018\u000105R\u00020\u0011H\u0002J\u0006\u00106\u001a\u00020-J\u0006\u00107\u001a\u00020-J\u0006\u00108\u001a\u00020-J\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010<\u001a\u00020\u0006J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010=\u001a\u00020-H\u0016J\b\u0010>\u001a\u00020-H\u0016J\r\u0010\u0003\u001a\u00020\u000eH\u0007¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020-H\u0000¢\u0006\u0002\bHJ\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0015R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0011\u0010\u0003\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0003\u0010?R\u0011\u0010@\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006M"}, d2 = {"Lni/shikatu/okhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Lni/shikatu/okio/Path;", "maxSize", _UrlKt.FRAGMENT_ENCODE_SET, "fileSystem", "Lni/shikatu/okio/FileSystem;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "<init>", "(Lokio/Path;JLokio/FileSystem;Lokhttp3/internal/concurrent/TaskRunner;)V", "(Lokio/FileSystem;Lokio/Path;J)V", "Ljava/io/File;", "(Ljava/io/File;J)V", "cache", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "writeSuccessCount", _UrlKt.FRAGMENT_ENCODE_SET, "getWriteSuccessCount$okhttp", "()I", "setWriteSuccessCount$okhttp", "(I)V", "writeAbortCount", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "networkCount", "hitCount", "requestCount", "isClosed", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "get", "Lni/shikatu/okhttp3/Response;", "request", "Lni/shikatu/okhttp3/Request;", "get$okhttp", "put", "Lni/shikatu/okhttp3/internal/cache/CacheRequest;", "response", "put$okhttp", "remove", _UrlKt.FRAGMENT_ENCODE_SET, "remove$okhttp", "update", "cached", "network", "update$okhttp", "abortQuietly", "editor", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Editor;", "initialize", "delete", "evictAll", "urls", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "size", "flush", "close", "()Ljava/io/File;", "directoryPath", "()Lokio/Path;", "-deprecated_directory", "trackResponse", "cacheStrategy", "Lni/shikatu/okhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "RealCacheRequest", "Entry", "CacheResponseBody", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public Cache(Path directory, long maxSize, FileSystem fileSystem, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.cache = new DiskLruCache(fileSystem, directory, VERSION, 2, maxSize, taskRunner);
    }

    public Cache(FileSystem fileSystem, Path directory, long maxSize) {
        this(directory, maxSize, fileSystem, TaskRunner.INSTANCE);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
    }

    public Cache(File directory, long maxSize) {
        this(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, directory, false, 1, (Object) null), maxSize);
        Intrinsics.checkNotNullParameter(directory, "directory");
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final Response get$okhttp(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String key = Companion.key(request.url());
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(key);
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (!entry.matches(request, response)) {
                    _UtilCommonKt.closeQuietly(response.body());
                    return null;
                }
                return response;
            } catch (IOException e) {
                _UtilCommonKt.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    public final CacheRequest put$okhttp(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        String requestMethod = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException e) {
            }
            return null;
        }
        if (!Intrinsics.areEqual(requestMethod, "GET") || Companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        DiskLruCache.Editor editor = null;
        try {
            DiskLruCache.Editor editorEdit$default = DiskLruCache.edit$default(this.cache, Companion.key(response.request().url()), 0L, 2, null);
            if (editorEdit$default == null) {
                return null;
            }
            editor = editorEdit$default;
            entry.writeTo(editor);
            return new RealCacheRequest(this, editor);
        } catch (IOException e2) {
            abortQuietly(editor);
            return null;
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final void update$okhttp(Response cached, Response network) {
        Intrinsics.checkNotNullParameter(cached, "cached");
        Intrinsics.checkNotNullParameter(network, "network");
        Entry entry = new Entry(network);
        ResponseBody responseBodyBody = cached.body();
        Intrinsics.checkNotNull(responseBodyBody, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        DiskLruCache.Snapshot snapshot = ((CacheResponseBody) responseBodyBody).getSnapshot();
        DiskLruCache.Editor editor = null;
        try {
            DiskLruCache.Editor editorEdit = snapshot.edit();
            if (editorEdit == null) {
                return;
            }
            editor = editorEdit;
            entry.writeTo(editor);
            editor.commit();
        } catch (IOException e) {
            abortQuietly(editor);
        }
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException e) {
            }
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0002J\t\u0010\n\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"ni/shikatu/okhttp3/Cache$urls$1", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "delegate", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Snapshot;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "nextUrl", "canRemove", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", "next", "remove", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<String>, KMutableIterator {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;

        AnonymousClass1(Cache $receiver) {
            this.delegate = $receiver.getCache$okhttp().snapshots();
        }

        @Override
        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                try {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        continue;
                        DiskLruCache.Snapshot snapshot = next;
                        BufferedSource metadata = Okio.buffer(snapshot.getSource(0));
                        this.nextUrl = metadata.readUtf8LineStrict();
                        CloseableKt.closeFinally(next, null);
                        return true;
                    } catch (Throwable th) {
                        try {
                            continue;
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(next, th);
                            throw th2;
                        }
                    }
                } catch (IOException e) {
                }
            }
            return false;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String result = this.nextUrl;
            Intrinsics.checkNotNull(result);
            this.nextUrl = null;
            this.canRemove = true;
            return result;
        }

        @Override
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            this.delegate.remove();
        }
    }

    public final Iterator<String> urls() throws IOException {
        return new AnonymousClass1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Override
    public void close() throws IOException {
        this.cache.close();
    }

    public final File directory() {
        return this.cache.getDirectory().toFile();
    }

    public final Path directoryPath() {
        return this.cache.getDirectory();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))

    public final File m1601deprecated_directory() {
        return this.cache.getDirectory().toFile();
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/Cache$RealCacheRequest;", "Lni/shikatu/okhttp3/internal/cache/CacheRequest;", "editor", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Editor;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "<init>", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "cacheOut", "Lni/shikatu/okio/Sink;", "body", "done", _UrlKt.FRAGMENT_ENCODE_SET, "getDone", "()Z", "setDone", "(Z)V", "abort", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final  Cache this$0;

        public RealCacheRequest(Cache this$0, DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.this$0 = this$0;
            this.editor = editor;
            this.cacheOut = this.editor.newSink(1);
            Sink sink = this.cacheOut;
            final Cache cache = this.this$0;
            this.body = new ForwardingSink(sink) {
                @Override
                public void close() throws IOException {
                    Cache cache2 = cache;
                    RealCacheRequest realCacheRequest = this;
                    Cache cache3 = cache;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache3.setWriteSuccessCount$okhttp(cache3.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }

        @Override
        public void abort() {
            Cache cache = this.this$0;
            Cache cache2 = this.this$0;
            synchronized (cache) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cache2.setWriteAbortCount$okhttp(cache2.getWriteAbortCount$okhttp() + 1);
                _UtilCommonKt.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException e) {
                }
            }
        }

        @Override
        public Sink body() {
            return this.body;
        }
    }

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u00060\u001dR\u00020\u001eJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u001e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\u0006\u001a\u00020\u00072\n\u0010,\u001a\u00060-R\u00020\u001eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lni/shikatu/okhttp3/Cache$Entry;", _UrlKt.FRAGMENT_ENCODE_SET, "rawSource", "Lni/shikatu/okio/Source;", "<init>", "(Lokio/Source;)V", "response", "Lni/shikatu/okhttp3/Response;", "(Lokhttp3/Response;)V", "url", "Lni/shikatu/okhttp3/HttpUrl;", "varyHeaders", "Lni/shikatu/okhttp3/Headers;", "requestMethod", _UrlKt.FRAGMENT_ENCODE_SET, "protocol", "Lni/shikatu/okhttp3/Protocol;", "code", _UrlKt.FRAGMENT_ENCODE_SET, "message", "responseHeaders", "handshake", "Lni/shikatu/okhttp3/Handshake;", "sentRequestMillis", _UrlKt.FRAGMENT_ENCODE_SET, "receivedResponseMillis", "writeTo", _UrlKt.FRAGMENT_ENCODE_SET, "editor", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Editor;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "readCertificateList", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "source", "Lni/shikatu/okio/BufferedSource;", "writeCertList", "sink", "Lni/shikatu/okio/BufferedSink;", "certificates", "matches", _UrlKt.FRAGMENT_ENCODE_SET, "request", "Lni/shikatu/okhttp3/Request;", "snapshot", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Snapshot;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;
        public static final Companion Companion = new Companion(null);
        private static final String SENT_MILLIS = Platform.Companion.get().getPrefix() + "-Sent-Millis";
        private static final String RECEIVED_MILLIS = Platform.Companion.get().getPrefix() + "-Received-Millis";

        public Entry(Source rawSource) throws IOException {
            Throwable th;
            Intrinsics.checkNotNullParameter(rawSource, "rawSource");
            Source source = rawSource;
            try {
                BufferedSource source2 = Okio.buffer(rawSource);
                String urlLine = source2.readUtf8LineStrict();
                HttpUrl httpUrl = HttpUrl.Companion.parse(urlLine);
                if (httpUrl == null) {
                    IOException it = new IOException("Cache corruption for " + urlLine);
                    Platform.Companion.get().log("cache corruption", 5, it);
                    throw it;
                }
                this.url = httpUrl;
                this.requestMethod = source2.readUtf8LineStrict();
                Headers.Builder varyHeadersBuilder = new Headers.Builder();
                int varyRequestHeaderLineCount = Cache.Companion.readInt$okhttp(source2);
                for (int i = 0; i < varyRequestHeaderLineCount; i++) {
                    varyHeadersBuilder.addLenient$okhttp(source2.readUtf8LineStrict());
                }
                this.varyHeaders = varyHeadersBuilder.build();
                StatusLine statusLine = StatusLine.Companion.parse(source2.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder responseHeadersBuilder = new Headers.Builder();
                int responseHeaderLineCount = Cache.Companion.readInt$okhttp(source2);
                for (int i2 = 0; i2 < responseHeaderLineCount; i2++) {
                    responseHeadersBuilder.addLenient$okhttp(source2.readUtf8LineStrict());
                }
                String sendRequestMillisString = responseHeadersBuilder.get(SENT_MILLIS);
                String receivedResponseMillisString = responseHeadersBuilder.get(RECEIVED_MILLIS);
                responseHeadersBuilder.removeAll(SENT_MILLIS);
                responseHeadersBuilder.removeAll(RECEIVED_MILLIS);
                this.sentRequestMillis = sendRequestMillisString != null ? Long.parseLong(sendRequestMillisString) : 0L;
                this.receivedResponseMillis = receivedResponseMillisString != null ? Long.parseLong(receivedResponseMillisString) : 0L;
                this.responseHeaders = responseHeadersBuilder.build();
                if (this.url.isHttps()) {
                    String blank = source2.readUtf8LineStrict();
                    if (blank.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + blank + '\"');
                    }
                    String cipherSuiteString = source2.readUtf8LineStrict();
                    CipherSuite cipherSuite = CipherSuite.Companion.forJavaName(cipherSuiteString);
                    List<Certificate> certificateList = readCertificateList(source2);
                    List<Certificate> certificateList2 = readCertificateList(source2);
                    TlsVersion tlsVersion = !source2.exhausted() ? TlsVersion.Companion.forJavaName(source2.readUtf8LineStrict()) : TlsVersion.SSL_3_0;
                    this.handshake = Handshake.Companion.get(tlsVersion, cipherSuite, certificateList, certificateList2);
                    th = null;
                } else {
                    th = null;
                    this.handshake = null;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(source, th);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(source, th2);
                    throw th3;
                }
            }
        }

        public Entry(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            Intrinsics.checkNotNullParameter(editor, "editor");
            BufferedSink bufferedSinkBuffer = Okio.buffer(editor.newSink(0));
            try {
                BufferedSink sink = bufferedSinkBuffer;
                sink.writeUtf8(this.url.toString()).writeByte(10);
                sink.writeUtf8(this.requestMethod).writeByte(10);
                sink.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
                int size = this.varyHeaders.size();
                for (int i = 0; i < size; i++) {
                    sink.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
                }
                sink.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                sink.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    sink.writeUtf8(this.responseHeaders.name(i2)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i2)).writeByte(10);
                }
                sink.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
                sink.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
                if (this.url.isHttps()) {
                    sink.writeByte(10);
                    Handshake handshake = this.handshake;
                    Intrinsics.checkNotNull(handshake);
                    sink.writeUtf8(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(sink, this.handshake.peerCertificates());
                    writeCertList(sink, this.handshake.localCertificates());
                    sink.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedSinkBuffer, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedSinkBuffer, th);
                    throw th2;
                }
            }
        }

        private final List<Certificate> readCertificateList(BufferedSource source) throws IOException {
            int length = Cache.Companion.readInt$okhttp(source);
            if (length == -1) {
                return CollectionsKt.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList result = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    String line = source.readUtf8LineStrict();
                    Buffer bytes = new Buffer();
                    ByteString certificateBytes = ByteString.Companion.decodeBase64(line);
                    if (certificateBytes == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    bytes.write(certificateBytes);
                    result.add(certificateFactory.generateCertificate(bytes.inputStream()));
                }
                return result;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(BufferedSink sink, List<? extends Certificate> list) throws IOException {
            try {
                sink.writeDecimalLong(list.size()).writeByte(10);
                for (Certificate element : list) {
                    byte[] bytes = element.getEncoded();
                    ByteString.Companion companion = ByteString.Companion;
                    Intrinsics.checkNotNull(bytes);
                    String line = ByteString.Companion.of$default(companion, bytes, 0, 0, 3, null).base64();
                    sink.writeUtf8(line).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            return Intrinsics.areEqual(this.url, request.url()) && Intrinsics.areEqual(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            String contentType = this.responseHeaders.get("Content-Type");
            String contentLength = this.responseHeaders.get("Content-Length");
            Request cacheRequest = new Request(this.url, this.varyHeaders, this.requestMethod, null, 8, null);
            return new Response.Builder().request(cacheRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, contentType, contentLength)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lni/shikatu/okhttp3/Cache$Entry$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "SENT_MILLIS", _UrlKt.FRAGMENT_ENCODE_SET, "RECEIVED_MILLIS", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0007\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lni/shikatu/okhttp3/Cache$CacheResponseBody;", "Lni/shikatu/okhttp3/ResponseBody;", "snapshot", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache$Snapshot;", "Lni/shikatu/okhttp3/internal/cache/DiskLruCache;", "contentType", _UrlKt.FRAGMENT_ENCODE_SET, "contentLength", "<init>", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "bodySource", "Lni/shikatu/okio/BufferedSource;", "Lni/shikatu/okhttp3/MediaType;", _UrlKt.FRAGMENT_ENCODE_SET, "source", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String contentType, String contentLength) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = contentType;
            this.contentLength = contentLength;
            Source source = this.snapshot.getSource(1);
            this.bodySource = Okio.buffer(new ForwardingSource(source) {
                @Override
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        @Override
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return _UtilCommonKt.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\n\u0010\u0019\u001a\u00020\u0012*\u00020\u0014J\u0012\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b*\u00020\u0016H\u0002J\n\u0010\u001c\u001a\u00020\u0016*\u00020\u0014J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lni/shikatu/okhttp3/Cache$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "VERSION", _UrlKt.FRAGMENT_ENCODE_SET, "ENTRY_METADATA", "ENTRY_BODY", "ENTRY_COUNT", "key", _UrlKt.FRAGMENT_ENCODE_SET, "url", "Lni/shikatu/okhttp3/HttpUrl;", "readInt", "source", "Lni/shikatu/okio/BufferedSource;", "readInt$okhttp", "varyMatches", _UrlKt.FRAGMENT_ENCODE_SET, "cachedResponse", "Lni/shikatu/okhttp3/Response;", "cachedRequest", "Lni/shikatu/okhttp3/Headers;", "newRequest", "Lni/shikatu/okhttp3/Request;", "hasVaryAll", "varyFields", _UrlKt.FRAGMENT_ENCODE_SET, "varyHeaders", "requestHeaders", "responseHeaders", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String key(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return ByteString.Companion.encodeUtf8(url.toString()).md5().hex();
        }

        public final int readInt$okhttp(BufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            try {
                long result = source.readDecimalLong();
                String line = source.readUtf8LineStrict();
                if (result >= 0 && result <= 2147483647L) {
                    if (!(line.length() > 0)) {
                        return (int) result;
                    }
                }
                throw new IOException("expected an int but was \"" + result + line + '\"');
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
            Intrinsics.checkNotNullParameter(newRequest, "newRequest");
            Iterable $this$none$iv = varyFields(cachedResponse.headers());
            if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
                return true;
            }
            for (Object element$iv : $this$none$iv) {
                String it = (String) element$iv;
                if (!Intrinsics.areEqual(cachedRequest.values(it), newRequest.headers(it))) {
                    return false;
                }
            }
            return true;
        }

        public final boolean hasVaryAll(Response $this$hasVaryAll) {
            Intrinsics.checkNotNullParameter($this$hasVaryAll, "<this>");
            return varyFields($this$hasVaryAll.headers()).contains("*");
        }

        private final Set<String> varyFields(Headers $this$varyFields) {
            Set result = null;
            int size = $this$varyFields.size();
            for (int i = 0; i < size; i++) {
                if (StringsKt.equals("Vary", $this$varyFields.name(i), true)) {
                    String value = $this$varyFields.value(i);
                    if (result == null) {
                        Set result2 = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                        result = result2;
                    }
                    for (String varyField : StringsKt.split$default((CharSequence) value, new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null)) {
                        result.add(StringsKt.trim((CharSequence) varyField).toString());
                    }
                }
            }
            return result == null ? SetsKt.emptySet() : result;
        }

        public final Headers varyHeaders(Response $this$varyHeaders) {
            Intrinsics.checkNotNullParameter($this$varyHeaders, "<this>");
            Response responseNetworkResponse = $this$varyHeaders.networkResponse();
            Intrinsics.checkNotNull(responseNetworkResponse);
            Headers requestHeaders = responseNetworkResponse.request().headers();
            Headers responseHeaders = $this$varyHeaders.headers();
            return varyHeaders(requestHeaders, responseHeaders);
        }

        private final Headers varyHeaders(Headers requestHeaders, Headers responseHeaders) {
            Set<String> setVaryFields = varyFields(responseHeaders);
            if (setVaryFields.isEmpty()) {
                return Headers.EMPTY;
            }
            Headers.Builder result = new Headers.Builder();
            int size = requestHeaders.size();
            for (int i = 0; i < size; i++) {
                String fieldName = requestHeaders.name(i);
                if (setVaryFields.contains(fieldName)) {
                    result.add(fieldName, requestHeaders.value(i));
                }
            }
            return result.build();
        }
    }

    @JvmStatic
    public static final String key(HttpUrl url) {
        return Companion.key(url);
    }
}
