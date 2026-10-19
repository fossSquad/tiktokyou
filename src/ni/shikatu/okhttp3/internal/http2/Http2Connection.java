package ni.shikatu.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.concurrent.TaskQueue;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.connection.BufferedSocket;
import ni.shikatu.okhttp3.internal.http2.flowcontrol.WindowCounter;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¡\u00012\u00020\u00012\u00020\u0002:\b\u009e\u0001\u009f\u0001 \u0001¡\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010V\u001a\u00020\u0011J\u0010\u0010W\u001a\u0004\u0018\u00010\u00122\u0006\u0010X\u001a\u00020\u0011J\u0017\u0010Y\u001a\u0004\u0018\u00010\u00122\u0006\u0010Z\u001a\u00020\u0011H\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020+H\u0000¢\u0006\u0002\b_J$\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\bJ\u001c\u0010f\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\bJ&\u0010f\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\bH\u0002J+\u0010g\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\b2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0002\bjJ(\u0010k\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\b2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020+J\u001d\u0010o\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010p\u001a\u00020qH\u0000¢\u0006\u0002\brJ\u001d\u0010s\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010t\u001a\u00020qH\u0000¢\u0006\u0002\buJ\u001d\u0010v\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010w\u001a\u00020+H\u0000¢\u0006\u0002\bxJ\u001e\u0010y\u001a\u00020]2\u0006\u0010z\u001a\u00020\b2\u0006\u0010{\u001a\u00020\u00112\u0006\u0010|\u001a\u00020\u0011J\u0006\u0010}\u001a\u00020]J\u0006\u0010y\u001a\u00020]J\u0006\u0010~\u001a\u00020]J\u0006\u0010\u007f\u001a\u00020]J\u000f\u0010\u0080\u0001\u001a\u00020]2\u0006\u0010t\u001a\u00020qJ\t\u0010\u0081\u0001\u001a\u00020]H\u0016J-\u0010\u0081\u0001\u001a\u00020]2\u0007\u0010\u0082\u0001\u001a\u00020q2\u0007\u0010\u0083\u0001\u001a\u00020q2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0000¢\u0006\u0003\b\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020]2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\u0014\u0010\u0089\u0001\u001a\u00020]2\t\b\u0002\u0010\u008a\u0001\u001a\u00020\bH\u0007J\u0010\u0010\u008b\u0001\u001a\u00020]2\u0007\u0010\u008c\u0001\u001a\u000207J\u0010\u0010\u008d\u0001\u001a\u00020\b2\u0007\u0010\u008e\u0001\u001a\u00020+J\u000f\u0010\u008f\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b\u0090\u0001J\u0017\u0010\u0091\u0001\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\u0011H\u0000¢\u0006\u0003\b\u0092\u0001J%\u0010\u0093\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0003\b\u0094\u0001J.\u0010\u0095\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0007\u0010\u0096\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b\u0097\u0001J2\u0010\u0098\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0006\u0010n\u001a\u00020\u00112\u0007\u0010\u0096\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b\u009b\u0001J\u001f\u0010\u009c\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010p\u001a\u00020qH\u0000¢\u0006\u0003\b\u009d\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u000203X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00109\"\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001e\u0010C\u001a\u00020+2\u0006\u0010B\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020+2\u0006\u0010B\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010ER\u0014\u0010H\u001a\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010L\u001a\u00020M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0015\u0010P\u001a\u00060QR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00110UX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "builder", "Lni/shikatu/okhttp3/internal/http2/Http2Connection$Builder;", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "client", _UrlKt.FRAGMENT_ENCODE_SET, "getClient$okhttp", "()Z", "listener", "Lni/shikatu/okhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "streams", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "connectionName", _UrlKt.FRAGMENT_ENCODE_SET, "getConnectionName$okhttp", "()Ljava/lang/String;", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "isShutdown", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "writerQueue", "Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", "pushQueue", "settingsListenerQueue", "pushObserver", "Lni/shikatu/okhttp3/internal/http2/PushObserver;", "intervalPingsSent", _UrlKt.FRAGMENT_ENCODE_SET, "intervalPongsReceived", "degradedPingsSent", "degradedPongsReceived", "awaitPingsSent", "awaitPongsReceived", "degradedPongDeadlineNs", "flowControlListener", "Lni/shikatu/okhttp3/internal/http2/FlowControlListener;", "getFlowControlListener$okhttp", "()Lokhttp3/internal/http2/FlowControlListener;", "okHttpSettings", "Lni/shikatu/okhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "readBytes", "Lni/shikatu/okhttp3/internal/http2/flowcontrol/WindowCounter;", "getReadBytes", "()Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "value", "writeBytesTotal", "getWriteBytesTotal", "()J", "writeBytesMaximum", "getWriteBytesMaximum", "socket", "Lni/shikatu/okhttp3/internal/connection/BufferedSocket;", "getSocket$okhttp", "()Lokhttp3/internal/connection/BufferedSocket;", "writer", "Lni/shikatu/okhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "readerRunnable", "Lni/shikatu/okhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "currentPushRequests", _UrlKt.FRAGMENT_ENCODE_SET, "openStreamCount", "getStream", "id", "removeStream", "streamId", "removeStream$okhttp", "updateConnectionFlowControl", _UrlKt.FRAGMENT_ENCODE_SET, "read", "updateConnectionFlowControl$okhttp", "pushStream", "associatedStreamId", "requestHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "out", "newStream", "writeHeaders", "outFinished", "alternating", "writeHeaders$okhttp", "writeData", "buffer", "Lni/shikatu/okio/Buffer;", "byteCount", "writeSynResetLater", "errorCode", "Lni/shikatu/okhttp3/internal/http2/ErrorCode;", "writeSynResetLater$okhttp", "writeSynReset", "statusCode", "writeSynReset$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "awaitPong", "flush", "shutdown", "close", "connectionCode", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "start", "sendConnectionPreface", "setSettings", "settings", "isHealthy", "nowNs", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "pushedStream", "pushedStream$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushHeadersLater", "inFinished", "pushHeadersLater$okhttp", "pushDataLater", "source", "Lni/shikatu/okio/BufferedSource;", "pushDataLater$okhttp", "pushResetLater", "pushResetLater$okhttp", "Builder", "ReaderRunnable", "Listener", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Http2Connection implements Closeable, Lockable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private final FlowControlListener flowControlListener;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private final WindowCounter readBytes;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final BufferedSocket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    public final void start() throws IOException {
        start$default(this, false, 1, null);
    }

    public Http2Connection(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.client = builder.getClient$okhttp();
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        this.connectionName = builder.getConnectionName$okhttp();
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        this.taskRunner = builder.getTaskRunner$okhttp();
        this.writerQueue = this.taskRunner.newQueue();
        this.pushQueue = this.taskRunner.newQueue();
        this.settingsListenerQueue = this.taskRunner.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        this.flowControlListener = builder.getFlowControlListener$okhttp();
        Settings $this$okHttpSettings_u24lambda_u240 = new Settings();
        if (builder.getClient$okhttp()) {
            $this$okHttpSettings_u24lambda_u240.set(4, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.okHttpSettings = $this$okHttpSettings_u24lambda_u240;
        this.peerSettings = DEFAULT_SETTINGS;
        this.readBytes = new WindowCounter(0);
        this.writeBytesMaximum = this.peerSettings.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(this.socket.getSink(), this.client);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(this.socket.getSource(), this.client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() == 0) {
            return;
        }
        final long pingIntervalNanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
        this.writerQueue.schedule(this.connectionName + " ping", pingIntervalNanos, new Function0() {
            @Override
            public final Object invoke() {
                return Long.valueOf(Http2Connection._init_$lambda$0(this.f$0, pingIntervalNanos));
            }
        });
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    public final FlowControlListener getFlowControlListener$okhttp() {
        return this.flowControlListener;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final void setPeerSettings(Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final BufferedSocket getSocket$okhttp() {
        return this.socket;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public static final long _init_$lambda$0(Http2Connection this$0, long $pingIntervalNanos) {
        int i;
        Http2Connection $this$withLock$iv = this$0;
        synchronized ($this$withLock$iv) {
            if (this$0.intervalPongsReceived < this$0.intervalPingsSent) {
                i = 1;
            } else {
                this$0.intervalPingsSent++;
                i = 0;
            }
        }
        if (i != 0) {
            this$0.failConnection(null);
            return -1L;
        }
        this$0.writePing(false, 1, 0);
        return $pingIntervalNanos;
    }

    public final int openStreamCount() {
        int size;
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            size = this.streams.size();
        }
        return size;
    }

    public final Http2Stream getStream(int id) {
        Http2Stream http2Stream;
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            http2Stream = this.streams.get(Integer.valueOf(id));
        }
        return http2Stream;
    }

    public final Http2Stream removeStream$okhttp(int streamId) {
        Http2Stream http2StreamRemove;
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            http2StreamRemove = this.streams.remove(Integer.valueOf(streamId));
            Http2Connection $this$notifyAll$iv = this;
            Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
            $this$notifyAll$iv.notifyAll();
        }
        return http2StreamRemove;
    }

    public final void updateConnectionFlowControl$okhttp(long read) throws Throwable {
        Throwable th;
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            try {
                try {
                    WindowCounter.update$default(this.readBytes, read, 0L, 2, null);
                    long readBytesToAcknowledge = this.readBytes.getUnacknowledged();
                    if (readBytesToAcknowledge >= this.okHttpSettings.getInitialWindowSize() / 2) {
                        writeWindowUpdateLater$okhttp(0, readBytesToAcknowledge);
                        WindowCounter.update$default(this.readBytes, 0L, readBytesToAcknowledge, 1, null);
                    }
                    this.flowControlListener.receivingConnectionWindowChanged(this.readBytes);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public final Http2Stream pushStream(int associatedStreamId, List<Header> list, boolean out) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.".toString());
        }
        return newStream(associatedStreamId, list, out);
    }

    public final Http2Stream newStream(List<Header> list, boolean out) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        return newStream(0, list, out);
    }

    private final Http2Stream newStream(int associatedStreamId, List<Header> list, boolean out) throws Throwable {
        boolean outFinished = !out;
        Lockable $this$withLock$iv = this.writer;
        synchronized ($this$withLock$iv) {
            try {
                Http2Connection $this$withLock$iv2 = this;
                synchronized ($this$withLock$iv2) {
                    try {
                        try {
                            if (this.nextStreamId > 1073741823) {
                                try {
                                    shutdown(ErrorCode.REFUSED_STREAM);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            }
                            try {
                                if (this.isShutdown) {
                                    throw new ConnectionShutdownException();
                                }
                                int streamId = this.nextStreamId;
                                this.nextStreamId += 2;
                                Http2Stream http2Stream = new Http2Stream(streamId, this, outFinished, false, null);
                                boolean flushHeaders = !out || this.writeBytesTotal >= this.writeBytesMaximum || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                                if (http2Stream.isOpen()) {
                                    this.streams.put(Integer.valueOf(streamId), http2Stream);
                                }
                                Unit unit = Unit.INSTANCE;
                                if (associatedStreamId == 0) {
                                    this.writer.headers(outFinished, streamId, list);
                                } else {
                                    if (this.client) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                                    }
                                    this.writer.pushPromise(associatedStreamId, streamId, list);
                                }
                                Unit unit2 = Unit.INSTANCE;
                                if (flushHeaders) {
                                    this.writer.flush();
                                }
                                return http2Stream;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        throw th;
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    public final void writeHeaders$okhttp(int streamId, boolean outFinished, List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "alternating");
        this.writer.headers(outFinished, streamId, list);
    }

    public final void writeData(int streamId, boolean outFinished, Buffer buffer, long byteCount) throws IOException {
        long j;
        int toWrite;
        long j2 = 0;
        if (byteCount == 0) {
            this.writer.data(outFinished, streamId, buffer, 0);
            return;
        }
        long byteCount2 = byteCount;
        while (byteCount2 > j2) {
            Http2Connection $this$withLock$iv = this;
            synchronized ($this$withLock$iv) {
                while (true) {
                    try {
                        j = j2;
                        if (this.writeBytesTotal >= this.writeBytesMaximum) {
                            if (!this.streams.containsKey(Integer.valueOf(streamId))) {
                                throw new IOException("stream closed");
                            }
                            Http2Connection $this$wait$iv = this;
                            Intrinsics.checkNotNull($this$wait$iv, "null cannot be cast to non-null type java.lang.Object");
                            $this$wait$iv.wait();
                            j2 = j;
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                toWrite = Math.min((int) Math.min(byteCount2, this.writeBytesMaximum - this.writeBytesTotal), this.writer.maxDataLength());
                this.writeBytesTotal += (long) toWrite;
                Unit unit = Unit.INSTANCE;
            }
            byteCount2 -= (long) toWrite;
            this.writer.data(outFinished && byteCount2 == j, streamId, buffer, toWrite);
            j2 = j;
        }
    }

    public final void writeSynResetLater$okhttp(final int streamId, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue.execute$default(this.writerQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] writeSynReset", 0L, false, new Function0() {
            @Override
            public final Object invoke() {
                return Http2Connection.writeSynResetLater$lambda$0(this.f$0, streamId, errorCode);
            }
        }, 6, null);
    }

    public static final Unit writeSynResetLater$lambda$0(Http2Connection this$0, int $streamId, ErrorCode $errorCode) {
        try {
            this$0.writeSynReset$okhttp($streamId, $errorCode);
        } catch (IOException e) {
            this$0.failConnection(e);
        }
        return Unit.INSTANCE;
    }

    public final void writeSynReset$okhttp(int streamId, ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.writer.rstStream(streamId, statusCode);
    }

    public final void writeWindowUpdateLater$okhttp(final int streamId, final long unacknowledgedBytesRead) {
        TaskQueue.execute$default(this.writerQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] windowUpdate", 0L, false, new Function0() {
            @Override
            public final Object invoke() {
                return Http2Connection.writeWindowUpdateLater$lambda$0(this.f$0, streamId, unacknowledgedBytesRead);
            }
        }, 6, null);
    }

    public static final Unit writeWindowUpdateLater$lambda$0(Http2Connection this$0, int $streamId, long $unacknowledgedBytesRead) {
        try {
            this$0.writer.windowUpdate($streamId, $unacknowledgedBytesRead);
        } catch (IOException e) {
            this$0.failConnection(e);
        }
        return Unit.INSTANCE;
    }

    public final void writePing(boolean reply, int payload1, int payload2) {
        try {
            this.writer.ping(reply, payload1, payload2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writePing() throws InterruptedException {
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final void awaitPong() throws InterruptedException {
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            while (this.awaitPongsReceived < this.awaitPingsSent) {
                Http2Connection $this$wait$iv = this;
                Intrinsics.checkNotNull($this$wait$iv, "null cannot be cast to non-null type java.lang.Object");
                $this$wait$iv.wait();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final void shutdown(ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Lockable $this$withLock$iv = this.writer;
        synchronized ($this$withLock$iv) {
            Http2Connection $this$withLock$iv2 = this;
            synchronized ($this$withLock$iv2) {
                try {
                    if (this.isShutdown) {
                        return;
                    }
                    try {
                        this.isShutdown = true;
                        int i = this.lastGoodStreamId;
                        Unit unit = Unit.INSTANCE;
                        this.writer.goAway(i, statusCode, _UtilCommonKt.EMPTY_BYTE_ARRAY);
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
    }

    @Override
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode connectionCode, ErrorCode streamCode, IOException cause) {
        int i;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        Http2Connection $this$assertLockNotHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            try {
                shutdown(connectionCode);
            } catch (IOException e) {
            }
            Object streamsToClose = null;
            Http2Connection $this$withLock$iv = this;
            synchronized ($this$withLock$iv) {
                if (!this.streams.isEmpty()) {
                    streamsToClose = this.streams.values().toArray(new Http2Stream[0]);
                    this.streams.clear();
                }
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) streamsToClose;
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    try {
                        http2Stream.close(streamCode, cause);
                    } catch (IOException e2) {
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException e3) {
            }
            try {
                this.socket.cancel();
            } catch (IOException e4) {
            }
            this.writerQueue.shutdown();
            this.pushQueue.shutdown();
            this.settingsListenerQueue.shutdown();
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    public final void failConnection(IOException e) {
        close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, e);
    }

    public static  void start$default(Http2Connection http2Connection, boolean z, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        http2Connection.start(z);
    }

    public final void start(boolean sendConnectionPreface) throws IOException {
        if (sendConnectionPreface) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int windowSize = this.okHttpSettings.getInitialWindowSize();
            if (windowSize != 65535) {
                this.writer.windowUpdate(0, windowSize - Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
        }
        TaskQueue.execute$default(this.taskRunner.newQueue(), this.connectionName, 0L, false, this.readerRunnable, 6, null);
    }

    public final void setSettings(Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Lockable $this$withLock$iv = this.writer;
        synchronized ($this$withLock$iv) {
            Http2Connection $this$withLock$iv2 = this;
            synchronized ($this$withLock$iv2) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
                Unit unit = Unit.INSTANCE;
            }
            this.writer.settings(settings);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final boolean isHealthy(long nowNs) {
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            return !this.isShutdown && (this.degradedPongsReceived >= this.degradedPingsSent || nowNs < this.degradedPongDeadlineNs);
        }
    }

    public final void sendDegradedPingLater$okhttp() {
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.degradedPongsReceived < this.degradedPingsSent) {
                return;
            }
            this.degradedPingsSent++;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);
            Unit unit = Unit.INSTANCE;
            TaskQueue.execute$default(this.writerQueue, this.connectionName + " ping", 0L, false, new Function0() {
                @Override
                public final Object invoke() {
                    return Http2Connection.sendDegradedPingLater$lambda$1(this.f$0);
                }
            }, 6, null);
        }
    }

    public static final Unit sendDegradedPingLater$lambda$1(Http2Connection this$0) {
        this$0.writePing(false, 2, 0);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020!J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J\u0006\u00103\u001a\u000204R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00065"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Connection$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "client", _UrlKt.FRAGMENT_ENCODE_SET, "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "socket", "Lni/shikatu/okhttp3/internal/connection/BufferedSocket;", "getSocket$okhttp", "()Lokhttp3/internal/connection/BufferedSocket;", "setSocket$okhttp", "(Lokhttp3/internal/connection/BufferedSocket;)V", "connectionName", _UrlKt.FRAGMENT_ENCODE_SET, "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lni/shikatu/okhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pushObserver", "Lni/shikatu/okhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "pingIntervalMillis", _UrlKt.FRAGMENT_ENCODE_SET, "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "flowControlListener", "Lni/shikatu/okhttp3/internal/http2/FlowControlListener;", "getFlowControlListener$okhttp", "()Lokhttp3/internal/http2/FlowControlListener;", "setFlowControlListener$okhttp", "(Lokhttp3/internal/http2/FlowControlListener;)V", "peerName", "build", "Lni/shikatu/okhttp3/internal/http2/Http2Connection;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private FlowControlListener flowControlListener;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public BufferedSocket socket;
        private final TaskRunner taskRunner;

        public Builder(boolean client, TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = client;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
            this.flowControlListener = FlowControlListener.None.INSTANCE;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final BufferedSocket getSocket$okhttp() {
            BufferedSocket bufferedSocket = this.socket;
            if (bufferedSocket != null) {
                return bufferedSocket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final void setSocket$okhttp(BufferedSocket bufferedSocket) {
            Intrinsics.checkNotNullParameter(bufferedSocket, "<set-?>");
            this.socket = bufferedSocket;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final void setConnectionName$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final void setListener$okhttp(Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "<set-?>");
            this.listener = listener;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public final FlowControlListener getFlowControlListener$okhttp() {
            return this.flowControlListener;
        }

        public final void setFlowControlListener$okhttp(FlowControlListener flowControlListener) {
            Intrinsics.checkNotNullParameter(flowControlListener, "<set-?>");
            this.flowControlListener = flowControlListener;
        }

        public final Builder socket(BufferedSocket socket, String peerName) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Builder $this$socket_u24lambda_u240 = this;
            $this$socket_u24lambda_u240.setSocket$okhttp(socket);
            $this$socket_u24lambda_u240.setConnectionName$okhttp($this$socket_u24lambda_u240.client ? _UtilJvmKt.okHttpName + ' ' + peerName : "MockWebServer " + peerName);
            return this;
        }

        public final Builder listener(Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Builder $this$listener_u24lambda_u240 = this;
            $this$listener_u24lambda_u240.listener = listener;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "pushObserver");
            Builder $this$pushObserver_u24lambda_u240 = this;
            $this$pushObserver_u24lambda_u240.pushObserver = pushObserver;
            return this;
        }

        public final Builder pingIntervalMillis(int pingIntervalMillis) {
            Builder $this$pingIntervalMillis_u24lambda_u240 = this;
            $this$pingIntervalMillis_u24lambda_u240.pingIntervalMillis = pingIntervalMillis;
            return this;
        }

        public final Builder flowControlListener(FlowControlListener flowControlListener) {
            Intrinsics.checkNotNullParameter(flowControlListener, "flowControlListener");
            Builder $this$flowControlListener_u24lambda_u240 = this;
            $this$flowControlListener_u24lambda_u240.flowControlListener = flowControlListener;
            return this;
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003H\u0096\u0002J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J.\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u0003H\u0016J \u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0016J \u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0016J(\u0010+\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\rH\u0016J&\u0010/\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J8\u00102\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020'2\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020*H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u00069"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lni/shikatu/okhttp3/internal/http2/Http2Reader$Handler;", "Lni/shikatu/kotlin/Function0;", _UrlKt.FRAGMENT_ENCODE_SET, "reader", "Lni/shikatu/okhttp3/internal/http2/Http2Reader;", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "invoke", "data", "inFinished", _UrlKt.FRAGMENT_ENCODE_SET, "streamId", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/BufferedSource;", "length", "headers", "associatedStreamId", "headerBlock", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "rstStream", "errorCode", "Lni/shikatu/okhttp3/internal/http2/ErrorCode;", "settings", "clearPrevious", "Lni/shikatu/okhttp3/internal/http2/Settings;", "applyAndAckSettings", "ackSettings", "ping", "ack", "payload1", "payload2", "goAway", "lastGoodStreamId", "debugData", "Lni/shikatu/okio/ByteString;", "windowUpdate", "windowSizeIncrement", _UrlKt.FRAGMENT_ENCODE_SET, "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "alternateService", "origin", _UrlKt.FRAGMENT_ENCODE_SET, "protocol", "host", "port", "maxAge", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        private final Http2Reader reader;
        final  Http2Connection this$0;

        public ReaderRunnable(Http2Connection this$0, Http2Reader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.this$0 = this$0;
            this.reader = reader;
        }

        @Override
        public /* bridge */  Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        public void invoke2() {
            ErrorCode streamErrorCode;
            ErrorCode connectionErrorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode streamErrorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException errorException = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    connectionErrorCode = ErrorCode.NO_ERROR;
                    streamErrorCode = ErrorCode.CANCEL;
                } catch (IOException e) {
                    errorException = e;
                    connectionErrorCode = ErrorCode.PROTOCOL_ERROR;
                    streamErrorCode = ErrorCode.PROTOCOL_ERROR;
                }
            } finally {
                this.this$0.close$okhttp(connectionErrorCode, streamErrorCode2, errorException);
                _UtilCommonKt.closeQuietly(this.reader);
            }
        }

        @Override
        public void data(boolean inFinished, int streamId, BufferedSource source, int length) throws Throwable {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushDataLater$okhttp(streamId, source, length, inFinished);
                return;
            }
            Http2Stream dataStream = this.this$0.getStream(streamId);
            if (dataStream == null) {
                this.this$0.writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
                this.this$0.updateConnectionFlowControl$okhttp(length);
                source.skip(length);
            } else {
                dataStream.receiveData(source, length);
                if (inFinished) {
                    dataStream.receiveHeaders(Headers.EMPTY, true);
                }
            }
        }

        @Override
        public void headers(boolean inFinished, int streamId, int associatedStreamId, List<Header> list) throws Throwable {
            Intrinsics.checkNotNullParameter(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushHeadersLater$okhttp(streamId, list, inFinished);
                return;
            }
            Lockable $this$withLock$iv = this.this$0;
            final Http2Connection http2Connection = this.this$0;
            synchronized ($this$withLock$iv) {
                try {
                    Http2Stream stream = http2Connection.getStream(streamId);
                    try {
                        if (stream != null) {
                            Unit unit = Unit.INSTANCE;
                            stream.receiveHeaders(_UtilJvmKt.toHeaders(list), inFinished);
                            return;
                        }
                        if (!http2Connection.isShutdown && streamId > http2Connection.getLastGoodStreamId$okhttp() && streamId % 2 != http2Connection.getNextStreamId$okhttp() % 2) {
                            Headers headers = _UtilJvmKt.toHeaders(list);
                            final Http2Stream newStream = new Http2Stream(streamId, http2Connection, false, inFinished, headers);
                            http2Connection.setLastGoodStreamId$okhttp(streamId);
                            http2Connection.getStreams$okhttp().put(Integer.valueOf(streamId), newStream);
                            TaskQueue.execute$default(http2Connection.taskRunner.newQueue(), http2Connection.getConnectionName$okhttp() + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onStream", 0L, false, new Function0() {
                                @Override
                                public final Object invoke() {
                                    return Http2Connection.ReaderRunnable.headers$lambda$0$0(http2Connection, newStream);
                                }
                            }, 6, null);
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public static final Unit headers$lambda$0$0(Http2Connection this$0, Http2Stream $newStream) {
            try {
                this$0.getListener$okhttp().onStream($newStream);
            } catch (IOException e) {
                Platform.Companion.get().log("Http2Connection.Listener failure for " + this$0.getConnectionName$okhttp(), 4, e);
                try {
                    $newStream.close(ErrorCode.PROTOCOL_ERROR, e);
                } catch (IOException e2) {
                }
            }
            return Unit.INSTANCE;
        }

        @Override
        public void rstStream(int streamId, ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushResetLater$okhttp(streamId, errorCode);
                return;
            }
            Http2Stream rstStream = this.this$0.removeStream$okhttp(streamId);
            if (rstStream != null) {
                rstStream.receiveRstStream(errorCode);
            }
        }

        @Override
        public void settings(final boolean clearPrevious, final Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            TaskQueue.execute$default(this.this$0.writerQueue, this.this$0.getConnectionName$okhttp() + " applyAndAckSettings", 0L, false, new Function0() {
                @Override
                public final Object invoke() {
                    return Http2Connection.ReaderRunnable.settings$lambda$0(this.f$0, clearPrevious, settings);
                }
            }, 6, null);
        }

        public static final Unit settings$lambda$0(ReaderRunnable this$0, boolean $clearPrevious, Settings $settings) {
            this$0.applyAndAckSettings($clearPrevious, $settings);
            return Unit.INSTANCE;
        }

        public final void applyAndAckSettings(boolean z, Settings settings) {
            T t;
            long initialWindowSize;
            Http2Stream[] http2StreamArr;
            Http2Stream[] http2StreamArr2;
            Intrinsics.checkNotNullParameter(settings, "settings");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Http2Writer writer = this.this$0.getWriter();
            final Http2Connection http2Connection = this.this$0;
            synchronized (writer) {
                synchronized (http2Connection) {
                    Settings peerSettings = http2Connection.getPeerSettings();
                    if (z) {
                        t = settings;
                    } else {
                        Settings settings2 = new Settings();
                        settings2.merge(peerSettings);
                        settings2.merge(settings);
                        t = settings2;
                    }
                    objectRef.element = t;
                    initialWindowSize = ((long) ((Settings) objectRef.element).getInitialWindowSize()) - ((long) peerSettings.getInitialWindowSize());
                    if (initialWindowSize == 0 || http2Connection.getStreams$okhttp().isEmpty()) {
                        http2StreamArr = null;
                    } else {
                        http2StreamArr = (Http2Stream[]) http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                    }
                    http2StreamArr2 = http2StreamArr;
                    http2Connection.setPeerSettings((Settings) objectRef.element);
                    TaskQueue.execute$default(http2Connection.settingsListenerQueue, http2Connection.getConnectionName$okhttp() + " onSettings", 0L, false, new Function0() {
                        @Override
                        public final Object invoke() {
                            return Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$0$0$1(http2Connection, objectRef);
                        }
                    }, 6, null);
                    Unit unit = Unit.INSTANCE;
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) objectRef.element);
                } catch (IOException e) {
                    http2Connection.failConnection(e);
                }
                Unit unit2 = Unit.INSTANCE;
            }
            if (http2StreamArr2 != null) {
                for (Http2Stream http2Stream : http2StreamArr2) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
        }

        public static final Unit applyAndAckSettings$lambda$0$0$1(Http2Connection this$0, Ref.ObjectRef $newPeerSettings) {
            this$0.getListener$okhttp().onSettings(this$0, (Settings) $newPeerSettings.element);
            return Unit.INSTANCE;
        }

        @Override
        public void ackSettings() {
        }

        @Override
        public void ping(boolean ack, final int payload1, final int payload2) {
            if (!ack) {
                TaskQueue taskQueue = this.this$0.writerQueue;
                String str = this.this$0.getConnectionName$okhttp() + " ping";
                final Http2Connection http2Connection = this.this$0;
                TaskQueue.execute$default(taskQueue, str, 0L, false, new Function0() {
                    @Override
                    public final Object invoke() {
                        return Http2Connection.ReaderRunnable.ping$lambda$1(http2Connection, payload1, payload2);
                    }
                }, 6, null);
                return;
            }
            Lockable $this$withLock$iv = this.this$0;
            Http2Connection http2Connection2 = this.this$0;
            synchronized ($this$withLock$iv) {
                try {
                    switch (payload1) {
                        case 1:
                            long j = http2Connection2.intervalPongsReceived;
                            http2Connection2.intervalPongsReceived = 1 + j;
                            Long.valueOf(j);
                            break;
                        case 2:
                            long j2 = http2Connection2.degradedPongsReceived;
                            http2Connection2.degradedPongsReceived = 1 + j2;
                            Long.valueOf(j2);
                            break;
                        case 3:
                            http2Connection2.awaitPongsReceived++;
                            Http2Connection $this$notifyAll$iv = http2Connection2;
                            Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                            $this$notifyAll$iv.notifyAll();
                            Unit unit = Unit.INSTANCE;
                            break;
                        default:
                            Unit unit2 = Unit.INSTANCE;
                            break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public static final Unit ping$lambda$1(Http2Connection this$0, int $payload1, int $payload2) {
            this$0.writePing(true, $payload1, $payload2);
            return Unit.INSTANCE;
        }

        @Override
        public void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
            int i;
            Object streamsCopy;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.size();
            Lockable $this$withLock$iv = this.this$0;
            Http2Connection http2Connection = this.this$0;
            synchronized ($this$withLock$iv) {
                streamsCopy = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                http2Connection.isShutdown = true;
                Unit unit = Unit.INSTANCE;
            }
            for (Http2Stream http2Stream : (Http2Stream[]) streamsCopy) {
                if (http2Stream.getId() > lastGoodStreamId && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override
        public void windowUpdate(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                Lockable $this$withLock$iv = this.this$0;
                Http2Connection http2Connection = this.this$0;
                synchronized ($this$withLock$iv) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + windowSizeIncrement;
                    Http2Connection $this$notifyAll$iv = http2Connection;
                    Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                    $this$notifyAll$iv.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(streamId);
            if (stream != null) {
                Http2Stream $this$withLock$iv2 = stream;
                synchronized ($this$withLock$iv2) {
                    stream.addBytesToWriteWindow(windowSizeIncrement);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        @Override
        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        @Override
        public void pushPromise(int streamId, int promisedStreamId, List<Header> list) {
            Intrinsics.checkNotNullParameter(list, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(promisedStreamId, list);
        }

        @Override
        public void alternateService(int streamId, String origin, ByteString protocol, String host, int port, long maxAge) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Intrinsics.checkNotNullParameter(host, "host");
        }
    }

    public final boolean pushedStream$okhttp(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    public final void pushRequestLater$okhttp(final int streamId, final List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        Http2Connection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
            } else {
                this.currentPushRequests.add(Integer.valueOf(streamId));
                TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onRequest", 0L, false, new Function0() {
                    @Override
                    public final Object invoke() {
                        return Http2Connection.pushRequestLater$lambda$1(this.f$0, streamId, list);
                    }
                }, 6, null);
            }
        }
    }

    public static final Unit pushRequestLater$lambda$1(Http2Connection this$0, int $streamId, List $requestHeaders) {
        boolean cancel = this$0.pushObserver.onRequest($streamId, $requestHeaders);
        if (cancel) {
            try {
                this$0.writer.rstStream($streamId, ErrorCode.CANCEL);
                Http2Connection $this$withLock$iv = this$0;
                synchronized ($this$withLock$iv) {
                    this$0.currentPushRequests.remove(Integer.valueOf($streamId));
                    Unit unit = Unit.INSTANCE;
                }
            } catch (IOException e) {
            }
        }
        return Unit.INSTANCE;
    }

    public final void pushHeadersLater$okhttp(final int streamId, final List<Header> list, final boolean inFinished) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onHeaders", 0L, false, new Function0() {
            @Override
            public final Object invoke() {
                return Http2Connection.pushHeadersLater$lambda$0(this.f$0, streamId, list, inFinished);
            }
        }, 6, null);
    }

    public static final Unit pushHeadersLater$lambda$0(Http2Connection this$0, int $streamId, List $requestHeaders, boolean $inFinished) {
        boolean cancel = this$0.pushObserver.onHeaders($streamId, $requestHeaders, $inFinished);
        if (cancel) {
            try {
                this$0.writer.rstStream($streamId, ErrorCode.CANCEL);
            } catch (IOException e) {
            }
        }
        if (cancel || $inFinished) {
            Http2Connection $this$withLock$iv = this$0;
            synchronized ($this$withLock$iv) {
                this$0.currentPushRequests.remove(Integer.valueOf($streamId));
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final void pushDataLater$okhttp(final int streamId, BufferedSource source, final int byteCount, final boolean inFinished) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        final Buffer buffer = new Buffer();
        source.require(byteCount);
        source.read(buffer, byteCount);
        TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onData", 0L, false, new Function0() {
            @Override
            public final Object invoke() {
                return Http2Connection.pushDataLater$lambda$0(this.f$0, streamId, buffer, byteCount, inFinished);
            }
        }, 6, null);
    }

    public static final Unit pushDataLater$lambda$0(Http2Connection this$0, int $streamId, Buffer $buffer, int $byteCount, boolean $inFinished) {
        try {
            boolean cancel = this$0.pushObserver.onData($streamId, $buffer, $byteCount, $inFinished);
            if (cancel) {
                this$0.writer.rstStream($streamId, ErrorCode.CANCEL);
            }
            if (cancel || $inFinished) {
                Http2Connection $this$withLock$iv = this$0;
                synchronized ($this$withLock$iv) {
                    this$0.currentPushRequests.remove(Integer.valueOf($streamId));
                    Unit unit = Unit.INSTANCE;
                }
            }
        } catch (IOException e) {
        }
        return Unit.INSTANCE;
    }

    public final void pushResetLater$okhttp(final int streamId, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onReset", 0L, false, new Function0() {
            @Override
            public final Object invoke() {
                return Http2Connection.pushResetLater$lambda$0(this.f$0, streamId, errorCode);
            }
        }, 6, null);
    }

    public static final Unit pushResetLater$lambda$0(Http2Connection this$0, int $streamId, ErrorCode $errorCode) {
        this$0.pushObserver.onReset($streamId, $errorCode);
        Http2Connection $this$withLock$iv = this$0;
        synchronized ($this$withLock$iv) {
            this$0.currentPushRequests.remove(Integer.valueOf($streamId));
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Connection$Listener;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "onStream", _UrlKt.FRAGMENT_ENCODE_SET, "stream", "Lni/shikatu/okhttp3/internal/http2/Http2Stream;", "onSettings", "connection", "Lni/shikatu/okhttp3/internal/http2/Http2Connection;", "settings", "Lni/shikatu/okhttp3/internal/http2/Settings;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            @Override
            public void onStream(Http2Stream stream) throws IOException {
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        public abstract void onStream(Http2Stream http2Stream) throws IOException;

        public void onSettings(Http2Connection connection, Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Connection$Listener$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "REFUSE_INCOMING_STREAMS", "Lni/shikatu/okhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Connection$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "OKHTTP_CLIENT_WINDOW_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "DEFAULT_SETTINGS", "Lni/shikatu/okhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "INTERVAL_PING", "DEGRADED_PING", "AWAIT_PING", "DEGRADED_PONG_TIMEOUT_NS", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    static {
        Settings $this$DEFAULT_SETTINGS_u24lambda_u240 = new Settings();
        $this$DEFAULT_SETTINGS_u24lambda_u240.set(4, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        $this$DEFAULT_SETTINGS_u24lambda_u240.set(5, 16384);
        DEFAULT_SETTINGS = $this$DEFAULT_SETTINGS_u24lambda_u240;
    }
}
