package ni.shikatu.okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.http2.flowcontrol.WindowCounter;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.AsyncTimeout;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0004`abcB3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020\bJ\b\u0010C\u001a\u0004\u0018\u00010\u000bJ$\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bJ\u000e\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020\u000bJ\u0006\u0010+\u001a\u00020LJ\u0006\u0010/\u001a\u00020LJ\u0018\u0010M\u001a\u00020E2\u0006\u0010N\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108J\b\u0010O\u001a\u00020EH\u0016J\u000e\u0010P\u001a\u00020E2\u0006\u00101\u001a\u000202J\u001a\u0010Q\u001a\u00020\b2\u0006\u00101\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0016\u0010R\u001a\u00020E2\u0006\u0010#\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0004J\u0016\u0010U\u001a\u00020E2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010V\u001a\u00020E2\u0006\u00101\u001a\u000202J\b\u0010W\u001a\u00020\bH\u0002J\r\u0010X\u001a\u00020EH\u0000¢\u0006\u0002\bYJ\u000e\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\u0017J\r\u0010\\\u001a\u00020EH\u0000¢\u0006\u0002\b]J\r\u0010^\u001a\u00020EH\u0000¢\u0006\u0002\b_R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\u00060$R\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010'\u001a\u00060(R\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010+\u001a\u00060,R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u00060,R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u001e\u00101\u001a\u0004\u0018\u0001028@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b?\u0010>R\u0011\u0010@\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b@\u0010>¨\u0006d"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Stream;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "Lni/shikatu/okio/Socket;", "id", _UrlKt.FRAGMENT_ENCODE_SET, "connection", "Lni/shikatu/okhttp3/internal/http2/Http2Connection;", "outFinished", _UrlKt.FRAGMENT_ENCODE_SET, "inFinished", "headers", "Lni/shikatu/okhttp3/Headers;", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getId", "()I", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "readBytes", "Lni/shikatu/okhttp3/internal/http2/flowcontrol/WindowCounter;", "getReadBytes", "()Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "writeBytesTotal", "getWriteBytesTotal", "()J", "setWriteBytesTotal$okhttp", "(J)V", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "headersQueue", "Ljava/util/ArrayDeque;", "hasResponseHeaders", "source", "Lni/shikatu/okhttp3/internal/http2/Http2Stream$FramingSource;", "getSource", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "sink", "Lni/shikatu/okhttp3/internal/http2/Http2Stream$FramingSink;", "getSink", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "readTimeout", "Lni/shikatu/okhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "writeTimeout", "getWriteTimeout$okhttp", "errorCode", "Lni/shikatu/okhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "isOpen", "()Z", "isLocallyInitiated", "isSourceComplete", "takeHeaders", "callerIsIdle", "peekTrailers", "writeHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "responseHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "flushHeaders", "enqueueTrailers", "trailers", "Lni/shikatu/okio/Timeout;", "close", "rstStatusCode", "cancel", "closeLater", "closeInternal", "receiveData", "Lni/shikatu/okio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "doReadTimeout", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "addBytesToWriteWindow", "delta", "checkOutNotClosed", "checkOutNotClosed$okhttp", "waitForIo", "waitForIo$okhttp", "FramingSource", "FramingSink", "Companion", "StreamTimeout", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Http2Stream implements Lockable, Socket {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private final WindowCounter readBytes;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    public Http2Stream(int id, Http2Connection connection, boolean outFinished, boolean inFinished, Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.id = id;
        this.connection = connection;
        this.readBytes = new WindowCounter(this.id);
        this.writeBytesMaximum = this.connection.getPeerSettings().getInitialWindowSize();
        this.headersQueue = new ArrayDeque<>();
        this.source = new FramingSource(this.connection.getOkHttpSettings().getInitialWindowSize(), inFinished);
        this.sink = new FramingSink(outFinished);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers != null) {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            this.headersQueue.add(headers);
        } else if (!isLocallyInitiated()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    public final int getId() {
        return this.id;
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final void setWriteBytesTotal$okhttp(long j) {
        this.writeBytesTotal = j;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final void setWriteBytesMaximum$okhttp(long j) {
        this.writeBytesMaximum = j;
    }

    @Override
    public FramingSource getSource() {
        return this.source;
    }

    @Override
    public FramingSink getSink() {
        return this.sink;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final ErrorCode getErrorCode$okhttp() {
        ErrorCode errorCode;
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            errorCode = this.errorCode;
        }
        return errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final boolean isOpen() {
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            return getErrorCode$okhttp() == null && !((getSource().getFinished$okhttp() || getSource().getClosed$okhttp()) && ((getSink().getFinished() || getSink().getClosed()) && this.hasResponseHeaders));
        }
    }

    public final boolean isLocallyInitiated() {
        boolean streamIsClient = (this.id & 1) == 1;
        return this.connection.getClient$okhttp() == streamIsClient;
    }

    public final boolean isSourceComplete() {
        boolean z;
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            z = getSource().getFinished$okhttp() && getSource().getReadBuffer().exhausted();
        }
        return z;
    }

    public static  Headers takeHeaders$default(Http2Stream http2Stream, boolean z, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = false;
        }
        return http2Stream.takeHeaders(z);
    }

    public final Headers takeHeaders(boolean callerIsIdle) throws IOException {
        Headers headers;
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            while (this.headersQueue.isEmpty() && getErrorCode$okhttp() == null) {
                boolean doReadTimeout = callerIsIdle || doReadTimeout();
                if (doReadTimeout) {
                    this.readTimeout.enter();
                }
                try {
                    waitForIo$okhttp();
                    if (doReadTimeout) {
                        this.readTimeout.exitAndThrowIfTimedOut();
                    }
                } catch (Throwable th) {
                    if (doReadTimeout) {
                        this.readTimeout.exitAndThrowIfTimedOut();
                    }
                    throw th;
                }
            }
            if (!this.headersQueue.isEmpty()) {
                Headers headersRemoveFirst = this.headersQueue.removeFirst();
                Intrinsics.checkNotNullExpressionValue(headersRemoveFirst, "removeFirst(...)");
                headers = headersRemoveFirst;
            } else {
                IOException iOException = this.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCode$okhttp = getErrorCode$okhttp();
                Intrinsics.checkNotNull(errorCode$okhttp);
                throw new StreamResetException(errorCode$okhttp);
            }
        }
        return headers;
    }

    public final Headers peekTrailers() throws IOException {
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (getSource().getFinished$okhttp() && getSource().getReceiveBuffer().exhausted() && getSource().getReadBuffer().exhausted()) {
                Headers trailers = getSource().getTrailers();
                if (trailers == null) {
                    trailers = Headers.EMPTY;
                }
                return trailers;
            }
            if (getErrorCode$okhttp() == null) {
                return null;
            }
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode$okhttp = getErrorCode$okhttp();
            Intrinsics.checkNotNull(errorCode$okhttp);
            throw new StreamResetException(errorCode$okhttp);
        }
    }

    public final void writeHeaders(List<Header> list, boolean outFinished, boolean flushHeaders) throws Throwable {
        boolean flushHeaders2;
        Intrinsics.checkNotNullParameter(list, "responseHeaders");
        Http2Stream $this$assertLockNotHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            Http2Stream $this$withLock$iv = this;
            synchronized ($this$withLock$iv) {
                this.hasResponseHeaders = true;
                if (outFinished) {
                    getSink().setFinished(true);
                    Http2Stream $this$notifyAll$iv = this;
                    Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                    $this$notifyAll$iv.notifyAll();
                }
                Unit unit = Unit.INSTANCE;
            }
            if (flushHeaders) {
                flushHeaders2 = flushHeaders;
            } else {
                Http2Stream $this$withLock$iv2 = this;
                synchronized ($this$withLock$iv2) {
                    try {
                        flushHeaders2 = this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum();
                        try {
                            Unit unit2 = Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            this.connection.writeHeaders$okhttp(this.id, outFinished, list);
            if (flushHeaders2) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    public final void enqueueTrailers(Headers trailers) {
        Intrinsics.checkNotNullParameter(trailers, "trailers");
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (getSink().getFinished()) {
                throw new IllegalStateException("already finished".toString());
            }
            if (!(trailers.size() != 0)) {
                throw new IllegalArgumentException("trailers.size() == 0".toString());
            }
            getSink().setTrailers(trailers);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public final void close(ErrorCode rstStatusCode, IOException errorException) throws IOException {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (!closeInternal(rstStatusCode, errorException)) {
            return;
        }
        this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
    }

    @Override
    public void cancel() {
        closeLater(ErrorCode.CANCEL);
    }

    public final void closeLater(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!closeInternal(errorCode, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode);
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException errorException) {
        Http2Stream $this$assertLockNotHeld$iv = this;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock($this$assertLockNotHeld$iv)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
        }
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (getErrorCode$okhttp() == null) {
                this.errorCode = errorCode;
                this.errorException = errorException;
                Http2Stream $this$notifyAll$iv = this;
                Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                $this$notifyAll$iv.notifyAll();
                if (!getSource().getFinished$okhttp() || !getSink().getFinished()) {
                    Unit unit = Unit.INSTANCE;
                    this.connection.removeStream$okhttp(this.id);
                    return true;
                }
            }
            return false;
        }
    }

    public final void receiveData(BufferedSource source, int length) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Http2Stream $this$assertLockNotHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            getSource().receive$okhttp(source, length);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    public final void receiveHeaders(Headers headers, boolean inFinished) {
        boolean open;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Http2Stream $this$assertLockNotHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            Http2Stream $this$withLock$iv = this;
            synchronized ($this$withLock$iv) {
                if (!this.hasResponseHeaders || headers.get(Header.RESPONSE_STATUS_UTF8) != null || headers.get(Header.TARGET_METHOD_UTF8) != null) {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                } else {
                    getSource().setTrailers(headers);
                }
                if (inFinished) {
                    getSource().setFinished$okhttp(true);
                }
                open = isOpen();
                Http2Stream $this$notifyAll$iv = this;
                Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                $this$notifyAll$iv.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (!open) {
                this.connection.removeStream$okhttp(this.id);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    public final void receiveRstStream(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Http2Stream $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (getErrorCode$okhttp() == null) {
                this.errorCode = errorCode;
                Http2Stream $this$notifyAll$iv = this;
                Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                $this$notifyAll$iv.notifyAll();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean doReadTimeout() {
        return !this.connection.getClient$okhttp() || getSink().getClosed() || getSink().getFinished();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u001d\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u0003H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006'"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Stream$FramingSource;", "Lni/shikatu/okio/Source;", "maxByteCount", _UrlKt.FRAGMENT_ENCODE_SET, "finished", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "getFinished$okhttp", "()Z", "setFinished$okhttp", "(Z)V", "receiveBuffer", "Lni/shikatu/okio/Buffer;", "getReceiveBuffer", "()Lokio/Buffer;", "readBuffer", "getReadBuffer", "trailers", "Lni/shikatu/okhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed$okhttp", "setClosed$okhttp", "read", "sink", "byteCount", "updateConnectionFlowControl", _UrlKt.FRAGMENT_ENCODE_SET, "receive", "source", "Lni/shikatu/okio/BufferedSource;", "receive$okhttp", "timeout", "Lni/shikatu/okio/Timeout;", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private Headers trailers;
        private final Buffer receiveBuffer = new Buffer();
        private final Buffer readBuffer = new Buffer();

        public FramingSource(long maxByteCount, boolean finished) {
            this.maxByteCount = maxByteCount;
            this.finished = finished;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j = 0;
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            while (true) {
                boolean tryAgain = false;
                long readBytesDelivered = -1;
                Object errorExceptionToDeliver = null;
                Lockable $this$withLock$iv = Http2Stream.this;
                Http2Stream http2Stream = Http2Stream.this;
                synchronized ($this$withLock$iv) {
                    boolean doReadTimeout = http2Stream.doReadTimeout();
                    if (doReadTimeout) {
                        http2Stream.getReadTimeout$okhttp().enter();
                    }
                    try {
                        if (http2Stream.getErrorCode$okhttp() == null || this.finished) {
                            j = j;
                        } else {
                            Object errorException$okhttp = http2Stream.getErrorException$okhttp();
                            if (errorException$okhttp == null) {
                                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                Intrinsics.checkNotNull(errorCode$okhttp);
                                errorException$okhttp = (IOException) new StreamResetException(errorCode$okhttp);
                            }
                            errorExceptionToDeliver = errorException$okhttp;
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        if (this.readBuffer.size() > j) {
                            long readBytesDelivered2 = this.readBuffer.read(sink, Math.min(byteCount, this.readBuffer.size()));
                            try {
                                WindowCounter.update$default(http2Stream.getReadBytes(), readBytesDelivered2, 0L, 2, null);
                                long unacknowledgedBytesRead = http2Stream.getReadBytes().getUnacknowledged();
                                if (errorExceptionToDeliver == null && unacknowledgedBytesRead >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                    http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), unacknowledgedBytesRead);
                                    WindowCounter.update$default(http2Stream.getReadBytes(), 0L, unacknowledgedBytesRead, 1, null);
                                }
                                readBytesDelivered = readBytesDelivered2;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } else if (!this.finished && errorExceptionToDeliver == null) {
                            http2Stream.waitForIo$okhttp();
                            tryAgain = true;
                        }
                        if (doReadTimeout) {
                            http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (doReadTimeout) {
                        http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                    }
                    throw th;
                }
                Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.size());
                if (!tryAgain) {
                    if (readBytesDelivered != -1) {
                        return readBytesDelivered;
                    }
                    if (errorExceptionToDeliver == null) {
                        return -1L;
                    }
                    throw ((Throwable) errorExceptionToDeliver);
                }
                j = j;
            }
        }

        private final void updateConnectionFlowControl(long read) throws Throwable {
            Lockable $this$assertLockNotHeld$iv = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(read);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
        }

        public final void receive$okhttp(BufferedSource source, long byteCount) throws Throwable {
            boolean finished;
            boolean wasEmpty;
            boolean flowControlError;
            Intrinsics.checkNotNullParameter(source, "source");
            Lockable $this$assertLockNotHeld$iv = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
                long remainingByteCount = byteCount;
                while (remainingByteCount > 0) {
                    Lockable $this$withLock$iv = Http2Stream.this;
                    synchronized ($this$withLock$iv) {
                        finished = this.finished;
                        wasEmpty = true;
                        flowControlError = this.readBuffer.size() + remainingByteCount > this.maxByteCount;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (flowControlError) {
                        source.skip(remainingByteCount);
                        Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    }
                    if (finished) {
                        source.skip(remainingByteCount);
                        return;
                    }
                    long read = source.read(this.receiveBuffer, remainingByteCount);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    remainingByteCount -= read;
                    Lockable $this$withLock$iv2 = Http2Stream.this;
                    Lockable lockable = Http2Stream.this;
                    synchronized ($this$withLock$iv2) {
                        if (this.closed) {
                            this.receiveBuffer.clear();
                        } else {
                            if (this.readBuffer.size() != 0) {
                                wasEmpty = false;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (wasEmpty) {
                                Lockable $this$notifyAll$iv = lockable;
                                Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                                $this$notifyAll$iv.notifyAll();
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                updateConnectionFlowControl(byteCount);
                Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.size());
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
        }

        @Override
        public Timeout timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }

        @Override
        public void close() throws Throwable {
            long bytesDiscarded;
            Lockable $this$withLock$iv = Http2Stream.this;
            Lockable lockable = Http2Stream.this;
            synchronized ($this$withLock$iv) {
                this.closed = true;
                bytesDiscarded = this.readBuffer.size();
                this.readBuffer.clear();
                Lockable $this$notifyAll$iv = lockable;
                Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                $this$notifyAll$iv.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (bytesDiscarded > 0) {
                updateConnectionFlowControl(bytesDiscarded);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean cancel;
        boolean open;
        Http2Stream $this$assertLockNotHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            Http2Stream $this$withLock$iv = this;
            synchronized ($this$withLock$iv) {
                cancel = !getSource().getFinished$okhttp() && getSource().getClosed$okhttp() && (getSink().getFinished() || getSink().getClosed());
                open = isOpen();
                Unit unit = Unit.INSTANCE;
            }
            if (cancel) {
                close(ErrorCode.CANCEL, null);
                return;
            } else {
                if (!open) {
                    this.connection.removeStream$okhttp(this.id);
                    return;
                }
                return;
            }
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t¨\u0006 "}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Stream$FramingSink;", "Lni/shikatu/okio/Sink;", "finished", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "getFinished", "()Z", "setFinished", "(Z)V", "sendBuffer", "Lni/shikatu/okio/Buffer;", "trailers", "Lni/shikatu/okhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed", "setClosed", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "emitFrame", "outFinishedOnLastFrame", "flush", "timeout", "Lni/shikatu/okio/Timeout;", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        private Headers trailers;

        public FramingSink(boolean finished) {
            this.finished = finished;
            this.sendBuffer = new Buffer();
        }

        public  FramingSink(Http2Stream http2Stream, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override
        public void write(Buffer source, long byteCount) throws Throwable {
            Intrinsics.checkNotNullParameter(source, "source");
            Lockable $this$assertLockNotHeld$iv = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
                this.sendBuffer.write(source, byteCount);
                while (this.sendBuffer.size() >= Http2Stream.EMIT_BUFFER_SIZE) {
                    emitFrame(false);
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
        }

        private final void emitFrame(boolean outFinishedOnLastFrame) throws Throwable {
            Lockable $this$withLock$iv = Http2Stream.this;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized ($this$withLock$iv) {
                try {
                    http2Stream.getWriteTimeout$okhttp().enter();
                    while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                        try {
                            http2Stream.waitForIo$okhttp();
                        } catch (Throwable th) {
                            http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                            throw th;
                        }
                    }
                    http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                    http2Stream.checkOutNotClosed$okhttp();
                    long toWrite = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                    try {
                        http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + toWrite);
                        boolean outFinished = outFinishedOnLastFrame && toWrite == this.sendBuffer.size();
                        try {
                            Unit unit = Unit.INSTANCE;
                            Http2Stream.this.getWriteTimeout$okhttp().enter();
                            try {
                                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), outFinished, this.sendBuffer, toWrite);
                            } finally {
                                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }

        @Override
        public void flush() throws Throwable {
            Lockable $this$assertLockNotHeld$iv = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
                Lockable $this$withLock$iv = Http2Stream.this;
                Http2Stream http2Stream = Http2Stream.this;
                synchronized ($this$withLock$iv) {
                    http2Stream.checkOutNotClosed$okhttp();
                    Unit unit = Unit.INSTANCE;
                }
                while (this.sendBuffer.size() > 0) {
                    emitFrame(false);
                    Http2Stream.this.getConnection().flush();
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
        }

        @Override
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override
        public void close() throws IOException {
            Lockable $this$assertLockNotHeld$iv = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock($this$assertLockNotHeld$iv)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
            }
            Lockable $this$withLock$iv = Http2Stream.this;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized ($this$withLock$iv) {
                if (this.closed) {
                    return;
                }
                boolean outFinished = http2Stream.getErrorCode$okhttp() == null;
                Unit unit = Unit.INSTANCE;
                if (!Http2Stream.this.getSink().finished) {
                    boolean hasData = this.sendBuffer.size() > 0;
                    boolean hasTrailers = this.trailers != null;
                    if (hasTrailers) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        Intrinsics.checkNotNull(headers);
                        connection.writeHeaders$okhttp(id, outFinished, _UtilJvmKt.toHeaderList(headers));
                    } else if (hasData) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else if (outFinished) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                Lockable $this$withLock$iv2 = Http2Stream.this;
                Lockable lockable = Http2Stream.this;
                synchronized ($this$withLock$iv2) {
                    this.closed = true;
                    Lockable $this$notifyAll$iv = lockable;
                    Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                    $this$notifyAll$iv.notifyAll();
                    Unit unit2 = Unit.INSTANCE;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Stream$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMIT_BUFFER_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void addBytesToWriteWindow(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            Http2Stream $this$notifyAll$iv = this;
            Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
            $this$notifyAll$iv.notifyAll();
        }
    }

    public final void checkOutNotClosed$okhttp() throws Throwable {
        if (getSink().getClosed()) {
            throw new IOException("stream closed");
        }
        if (getSink().getFinished()) {
            throw new IOException("stream finished");
        }
        if (getErrorCode$okhttp() != null) {
            Throwable streamResetException = this.errorException;
            if (streamResetException == null) {
                ErrorCode errorCode$okhttp = getErrorCode$okhttp();
                Intrinsics.checkNotNull(errorCode$okhttp);
                streamResetException = new StreamResetException(errorCode$okhttp);
            }
            throw streamResetException;
        }
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            Http2Stream $this$wait$iv = this;
            Intrinsics.checkNotNull($this$wait$iv, "null cannot be cast to non-null type java.lang.Object");
            $this$wait$iv.wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lni/shikatu/okio/AsyncTimeout;", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "timedOut", _UrlKt.FRAGMENT_ENCODE_SET, "newTimeoutException", "Ljava/io/IOException;", "cause", "exitAndThrowIfTimedOut", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        @Override
        protected void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }

        @Override
        protected IOException newTimeoutException(IOException cause) {
            SocketTimeoutException $this$newTimeoutException_u24lambda_u240 = new SocketTimeoutException("timeout");
            if (cause != null) {
                $this$newTimeoutException_u24lambda_u240.initCause(cause);
            }
            return $this$newTimeoutException_u24lambda_u240;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }
}
