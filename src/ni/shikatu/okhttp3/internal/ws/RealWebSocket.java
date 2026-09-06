package ni.shikatu.okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Call;
import ni.shikatu.okhttp3.Callback;
import ni.shikatu.okhttp3.EventListener;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.WebSocket;
import ni.shikatu.okhttp3.WebSocketListener;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.concurrent.Task;
import ni.shikatu.okhttp3.internal.concurrent.TaskQueue;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.connection.BufferedSocket;
import ni.shikatu.okhttp3.internal.connection.BufferedSocketKt;
import ni.shikatu.okhttp3.internal.connection.RealCall;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004cdefBI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\rH\u0016J\b\u0010:\u001a\u00020;H\u0016J\u000e\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>J\f\u0010?\u001a\u000200*\u00020\u000fH\u0002J\u0015\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0000¢\u0006\u0002\bCJ\u001e\u0010D\u001a\u00020;2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020E2\u0006\u0010=\u001a\u000200J\u000e\u0010F\u001a\u00020;2\u0006\u0010A\u001a\u00020BJ\u0006\u0010G\u001a\u000200J\u0006\u0010H\u001a\u00020;J\u0006\u0010I\u001a\u00020;J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u000202J\u0006\u00107\u001a\u000202J\u0010\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020\u0017H\u0016J\u0010\u0010J\u001a\u00020;2\u0006\u0010L\u001a\u00020+H\u0016J\u0010\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u00020+H\u0016J\u0010\u0010O\u001a\u00020;2\u0006\u0010N\u001a\u00020+H\u0016J\u0018\u0010P\u001a\u00020;2\u0006\u0010Q\u001a\u0002022\u0006\u0010R\u001a\u00020\u0017H\u0016J\u0010\u0010S\u001a\u0002002\u0006\u0010K\u001a\u00020\u0017H\u0016J\u0010\u0010S\u001a\u0002002\u0006\u0010L\u001a\u00020+H\u0016J\u0018\u0010S\u001a\u0002002\u0006\u0010T\u001a\u00020+2\u0006\u0010U\u001a\u000202H\u0002J\u000e\u0010V\u001a\u0002002\u0006\u0010N\u001a\u00020+J\u001a\u0010W\u001a\u0002002\u0006\u0010Q\u001a\u0002022\b\u0010R\u001a\u0004\u0018\u00010\u0017H\u0016J \u0010W\u001a\u0002002\u0006\u0010Q\u001a\u0002022\b\u0010R\u001a\u0004\u0018\u00010\u00172\u0006\u0010X\u001a\u00020\rJ\b\u0010Y\u001a\u00020;H\u0002J\r\u0010Z\u001a\u000200H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020;H\u0000¢\u0006\u0002\b]J(\u0010^\u001a\u00020;2\n\u0010_\u001a\u00060`j\u0002`a2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010b\u001a\u000200R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/RealWebSocket;", "Lni/shikatu/okhttp3/WebSocket;", "Lni/shikatu/okhttp3/internal/ws/WebSocketReader$FrameCallback;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lni/shikatu/okhttp3/Request;", "listener", "Lni/shikatu/okhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", _UrlKt.FRAGMENT_ENCODE_SET, "extensions", "Lni/shikatu/okhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "webSocketCloseTimeout", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;JJ)V", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "key", _UrlKt.FRAGMENT_ENCODE_SET, "call", "Lni/shikatu/okhttp3/Call;", "getCall$okhttp", "()Lokhttp3/Call;", "setCall$okhttp", "(Lokhttp3/Call;)V", "writerTask", "Lni/shikatu/okhttp3/internal/concurrent/Task;", "reader", "Lni/shikatu/okhttp3/internal/ws/WebSocketReader;", "writer", "Lni/shikatu/okhttp3/internal/ws/WebSocketWriter;", "taskQueue", "Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", "name", "socket", "Lni/shikatu/okio/Socket;", "pongQueue", "Ljava/util/ArrayDeque;", "Lni/shikatu/okio/ByteString;", "messageAndCloseQueue", _UrlKt.FRAGMENT_ENCODE_SET, "queueSize", "enqueuedClose", _UrlKt.FRAGMENT_ENCODE_SET, "receivedCloseCode", _UrlKt.FRAGMENT_ENCODE_SET, "receivedCloseReason", "failed", "sentPingCount", "receivedPingCount", "receivedPongCount", "awaitingPong", "request", "cancel", _UrlKt.FRAGMENT_ENCODE_SET, "connect", "client", "Lni/shikatu/okhttp3/OkHttpClient;", "isValid", "checkUpgradeSuccess", "response", "Lni/shikatu/okhttp3/Response;", "checkUpgradeSuccess$okhttp", "initReaderAndWriter", "Lni/shikatu/okhttp3/internal/connection/BufferedSocket;", "loopReader", "processNextFrame", "finishReader", "tearDown", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "onReadClose", "code", "reason", "send", "data", "formatOpcode", "pong", "close", "cancelAfterCloseMillis", "runWriter", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "failWebSocket", "e", "Ljava/lang/Exception;", "Lni/shikatu/kotlin/Exception;", "isWriter", "Message", "Close", "WriterTask", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback, Lockable {
    public static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Socket socket;
    private TaskQueue taskQueue;
    private final long webSocketCloseTimeout;
    private WebSocketWriter writer;
    private Task writerTask;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);

    public RealWebSocket(TaskRunner taskRunner, Request originalRequest, WebSocketListener listener, Random random, long pingIntervalMillis, WebSocketExtensions extensions, long minimumDeflateSize, long webSocketCloseTimeout) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = pingIntervalMillis;
        this.extensions = extensions;
        this.minimumDeflateSize = minimumDeflateSize;
        this.webSocketCloseTimeout = webSocketCloseTimeout;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!Intrinsics.areEqual("GET", this.originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + this.originalRequest.method()).toString());
        }
        ByteString.Companion companion = ByteString.Companion;
        byte[] $this$_init__u24lambda_u241 = new byte[16];
        this.random.nextBytes($this$_init__u24lambda_u241);
        Unit unit = Unit.INSTANCE;
        this.key = ByteString.Companion.of$default(companion, $this$_init__u24lambda_u241, 0, 0, 3, null).base64();
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final Call getCall$okhttp() {
        return this.call;
    }

    public final void setCall$okhttp(Call call) {
        this.call = call;
    }

    @Override
    public Request request() {
        return this.originalRequest;
    }

    @Override
    public synchronized long queueSize() {
        return this.queueSize;
    }

    @Override
    public void cancel() {
        Call call = this.call;
        Intrinsics.checkNotNull(call);
        call.cancel();
    }

    public final void connect(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket$default(this, new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null, false, 6, null);
            return;
        }
        OkHttpClient webSocketClient = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request request = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        this.call = new RealCall(webSocketClient, request, true);
        Call call = this.call;
        Intrinsics.checkNotNull(call);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call2, Response response) throws IOException {
                Source source;
                Sink sink;
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    Socket socket = RealWebSocket.this.checkUpgradeSuccess$okhttp(response);
                    WebSocketExtensions extensions = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = extensions;
                    if (!RealWebSocket.this.isValid(extensions)) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        RealWebSocket realWebSocket2 = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            realWebSocket2.messageAndCloseQueue.clear();
                            realWebSocket2.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    String name = _UtilJvmKt.okHttpName + " WebSocket " + request.url().redact();
                    RealWebSocket.this.initReaderAndWriter(name, BufferedSocketKt.asBufferedSocket(socket), true);
                    RealWebSocket.this.loopReader(response);
                } catch (IOException e) {
                    RealWebSocket.failWebSocket$default(RealWebSocket.this, e, response, false, 4, null);
                    _UtilCommonKt.closeQuietly(response);
                    Socket socket2 = response.socket();
                    if (socket2 != null && (sink = socket2.getSink()) != null) {
                        _UtilCommonKt.closeQuietly(sink);
                    }
                    Socket socket3 = response.socket();
                    if (socket3 == null || (source = socket3.getSource()) == null) {
                        return;
                    }
                    _UtilCommonKt.closeQuietly(source);
                }
            }

            @Override
            public void onFailure(Call call2, IOException e) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                RealWebSocket.failWebSocket$default(RealWebSocket.this, e, null, false, 6, null);
            }
        });
    }

    public final boolean isValid(WebSocketExtensions $this$isValid) {
        if ($this$isValid.unknownValues || $this$isValid.clientMaxWindowBits != null) {
            return false;
        }
        if ($this$isValid.serverMaxWindowBits != null) {
            int iIntValue = $this$isValid.serverMaxWindowBits.intValue();
            if (!(8 <= iIntValue && iIntValue < 16)) {
                return false;
            }
        }
        return true;
    }

    public final Socket checkUpgradeSuccess$okhttp(Response response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String headerConnection = Response.header$default(response, "Connection", null, 2, null);
        if (!StringsKt.equals("Upgrade", headerConnection, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + headerConnection + '\'');
        }
        String headerUpgrade = Response.header$default(response, "Upgrade", null, 2, null);
        if (!StringsKt.equals("websocket", headerUpgrade, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + headerUpgrade + '\'');
        }
        String headerAccept = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        String acceptExpected = ByteString.Companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (!Intrinsics.areEqual(acceptExpected, headerAccept)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + acceptExpected + "' but was '" + headerAccept + '\'');
        }
        Socket socket = response.socket();
        if (socket != null) {
            return socket;
        }
        throw new ProtocolException("Web Socket socket missing: bad interceptor?");
    }

    public final void initReaderAndWriter(String name, BufferedSocket socket, boolean client) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(socket, "socket");
        WebSocketExtensions extensions = this.extensions;
        Intrinsics.checkNotNull(extensions);
        synchronized (this) {
            this.name = name;
            this.socket = socket;
            this.writer = new WebSocketWriter(client, socket.getSink(), this.random, extensions.perMessageDeflate, extensions.noContextTakeover(client), this.minimumDeflateSize);
            this.writerTask = new WriterTask();
            if (this.pingIntervalMillis != 0) {
                final long pingIntervalNanos = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                this.taskQueue.schedule(name + " ping", pingIntervalNanos, new Function0() {
                    @Override
                    public final Object invoke() {
                        return Long.valueOf(RealWebSocket.initReaderAndWriter$lambda$0$0(this.f$0, pingIntervalNanos));
                    }
                });
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(client, socket.getSource(), this, extensions.perMessageDeflate, extensions.noContextTakeover(!client));
    }

    public static final long initReaderAndWriter$lambda$0$0(RealWebSocket this$0, long $pingIntervalNanos) throws Throwable {
        this$0.writePingFrame$okhttp();
        return $pingIntervalNanos;
    }

    public final void loopReader(Response response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            this.listener.onOpen(this, response);
            while (this.receivedCloseCode == -1) {
                WebSocketReader webSocketReader = this.reader;
                Intrinsics.checkNotNull(webSocketReader);
                webSocketReader.processNextFrame();
            }
        } catch (Exception e) {
            failWebSocket$default(this, e, null, false, 6, null);
        } finally {
            finishReader();
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket$default(this, e, null, false, 6, null);
            return false;
        }
    }

    public final void finishReader() {
        int code;
        String str;
        Object readerToClose;
        boolean sendOnClosed;
        synchronized (this) {
            code = this.receivedCloseCode;
            str = this.receivedCloseReason;
            readerToClose = this.reader;
            this.reader = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                final WebSocketWriter writerToClose = this.writer;
                if (writerToClose != null) {
                    this.writer = null;
                    TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new Function0() {
                        @Override
                        public final Object invoke() {
                            return RealWebSocket.finishReader$lambda$0$0(writerToClose);
                        }
                    }, 2, null);
                }
                this.taskQueue.shutdown();
            }
            sendOnClosed = (this.failed || this.writer != null || this.receivedCloseCode == -1) ? false : true;
            Unit unit = Unit.INSTANCE;
        }
        if (sendOnClosed) {
            Intrinsics.checkNotNull(str);
            this.listener.onClosed(this, code, str);
        }
        if (readerToClose != null) {
            _UtilCommonKt.closeQuietly((Closeable) readerToClose);
        }
    }

    public static final Unit finishReader$lambda$0$0(WebSocketWriter $writerToClose) {
        _UtilCommonKt.closeQuietly($writerToClose);
        return Unit.INSTANCE;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override
    public void onReadMessage(String text) throws IOException {
        Intrinsics.checkNotNullParameter(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override
    public void onReadMessage(ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override
    public synchronized void onReadPing(ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override
    public synchronized void onReadPong(ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    @Override
    public void onReadClose(int code, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        boolean z = true;
        if (!(code != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("already closed".toString());
            }
            this.receivedCloseCode = code;
            this.receivedCloseReason = reason;
            Unit unit = Unit.INSTANCE;
        }
        this.listener.onClosing(this, code, reason);
    }

    @Override
    public boolean send(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    @Override
    public boolean send(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return send(bytes, 2);
    }

    private final synchronized boolean send(ByteString data, int formatOpcode) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) data.size()) > MAX_QUEUE_SIZE) {
                close(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, null);
                return false;
            }
            this.queueSize += (long) data.size();
            this.messageAndCloseQueue.add(new Message(formatOpcode, data));
            runWriter();
            return true;
        }
        return false;
    }

    public final synchronized boolean pong(ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            runWriter();
            return true;
        }
        return false;
    }

    @Override
    public boolean close(int code, String reason) {
        return close(code, reason, this.webSocketCloseTimeout);
    }

    public final synchronized boolean close(int code, String reason, long cancelAfterCloseMillis) {
        WebSocketProtocol.INSTANCE.validateCloseCode(code);
        ByteString reasonBytes = null;
        if (reason != null) {
            reasonBytes = ByteString.Companion.encodeUtf8(reason);
            if (!(((long) reasonBytes.size()) <= 123)) {
                throw new IllegalArgumentException(("reason.size() > 123: " + reason).toString());
            }
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(code, reasonBytes, cancelAfterCloseMillis));
            runWriter();
            return true;
        }
        return false;
    }

    private final void runWriter() {
        RealWebSocket $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            Task writerTask = this.writerTask;
            if (writerTask != null) {
                TaskQueue.schedule$default(this.taskQueue, writerTask, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public final boolean writeOneFrame$okhttp() throws IOException {
        boolean z;
        Object messageOrClose = null;
        int receivedCloseCode = -1;
        String str = null;
        boolean sendOnClosed = false;
        Object writerToClose = null;
        synchronized (this) {
            boolean z2 = false;
            if (!this.failed) {
                WebSocketWriter webSocketWriter = this.writer;
                Object pong = this.pongQueue.poll();
                if (pong == null) {
                    messageOrClose = this.messageAndCloseQueue.poll();
                    if (messageOrClose instanceof Close) {
                        receivedCloseCode = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (receivedCloseCode != -1) {
                            writerToClose = this.writer;
                            this.writer = null;
                            if (writerToClose != null && this.reader == null) {
                                z2 = true;
                            }
                            sendOnClosed = z2;
                            this.taskQueue.shutdown();
                            z = true;
                        } else {
                            long cancelAfterCloseMillis = ((Close) messageOrClose).getCancelAfterCloseMillis();
                            z = true;
                            TaskQueue.execute$default(this.taskQueue, this.name + " cancel", TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis), false, new Function0() {
                                @Override
                                public final Object invoke() {
                                    return RealWebSocket.writeOneFrame$lambda$0$0(this.f$0);
                                }
                            }, 4, null);
                        }
                    } else {
                        z = true;
                        if (messageOrClose == null) {
                        }
                    }
                } else {
                    z = true;
                }
                Unit unit = Unit.INSTANCE;
                try {
                    if (pong != null) {
                        Intrinsics.checkNotNull(webSocketWriter);
                        webSocketWriter.writePong((ByteString) pong);
                    } else if (messageOrClose instanceof Message) {
                        Object message = messageOrClose;
                        Intrinsics.checkNotNull(webSocketWriter);
                        webSocketWriter.writeMessageFrame(((Message) message).getFormatOpcode(), ((Message) message).getData());
                        synchronized (this) {
                            this.queueSize -= (long) ((Message) message).getData().size();
                            Unit unit2 = Unit.INSTANCE;
                        }
                    } else {
                        if (!(messageOrClose instanceof Close)) {
                            throw new AssertionError();
                        }
                        Object close = messageOrClose;
                        Intrinsics.checkNotNull(webSocketWriter);
                        webSocketWriter.writeClose(((Close) close).getCode(), ((Close) close).getReason());
                        if (sendOnClosed) {
                            Intrinsics.checkNotNull(str);
                            this.listener.onClosed(this, receivedCloseCode, str);
                        }
                    }
                    if (writerToClose != null) {
                        _UtilCommonKt.closeQuietly((Closeable) writerToClose);
                    }
                    return z;
                } catch (Throwable th) {
                    WebSocketWriter webSocketWriter2 = (WebSocketWriter) writerToClose;
                    if (webSocketWriter2 != null) {
                        _UtilCommonKt.closeQuietly(webSocketWriter2);
                    }
                    throw th;
                }
            }
            return false;
        }
    }

    public static final Unit writeOneFrame$lambda$0$0(RealWebSocket this$0) {
        this$0.cancel();
        return Unit.INSTANCE;
    }

    public final void writePingFrame$okhttp() throws Throwable {
        WebSocketWriter webSocketWriter;
        synchronized (this) {
            try {
                if (this.failed || (webSocketWriter = this.writer) == null) {
                    return;
                }
                try {
                    int failedPing = this.awaitingPong ? this.sentPingCount : -1;
                    try {
                        this.sentPingCount++;
                        this.awaitingPong = true;
                        Unit unit = Unit.INSTANCE;
                        if (failedPing != -1) {
                            failWebSocket$default(this, new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (failedPing - 1) + " successful ping/pongs)"), null, true, 2, null);
                            return;
                        }
                        try {
                            webSocketWriter.writePing(ByteString.EMPTY);
                        } catch (IOException e) {
                            failWebSocket$default(this, e, null, true, 2, null);
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static  void failWebSocket$default(RealWebSocket realWebSocket, Exception exc, Response response, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            response = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        realWebSocket.failWebSocket(exc, response, z);
    }

    public final void failWebSocket(Exception e, Response response, boolean isWriter) {
        WebSocketWriter webSocketWriter;
        Intrinsics.checkNotNullParameter(e, "e");
        final Ref.ObjectRef writerToClose = new Ref.ObjectRef();
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Socket socket = this.socket;
            writerToClose.element = this.writer;
            this.writer = null;
            if (!isWriter && writerToClose.element != 0) {
                TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new Function0() {
                    @Override
                    public final Object invoke() {
                        return RealWebSocket.failWebSocket$lambda$0$0(writerToClose);
                    }
                }, 2, null);
            }
            this.taskQueue.shutdown();
            Unit unit = Unit.INSTANCE;
            try {
                this.listener.onFailure(this, e, response);
                if (socket != null) {
                    socket.cancel();
                }
            } finally {
                Socket socket2 = socket;
                if (socket2 != null) {
                    socket2.cancel();
                }
                if (isWriter && (webSocketWriter = (WebSocketWriter) writerToClose.element) != null) {
                    _UtilCommonKt.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    public static final Unit failWebSocket$lambda$0$0(Ref.ObjectRef $writerToClose) {
        _UtilCommonKt.closeQuietly((Closeable) $writerToClose.element);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/RealWebSocket$Message;", _UrlKt.FRAGMENT_ENCODE_SET, "formatOpcode", _UrlKt.FRAGMENT_ENCODE_SET, "data", "Lni/shikatu/okio/ByteString;", "<init>", "(ILokio/ByteString;)V", "getFormatOpcode", "()I", "getData", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int formatOpcode, ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = formatOpcode;
            this.data = data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final ByteString getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/RealWebSocket$Close;", _UrlKt.FRAGMENT_ENCODE_SET, "code", _UrlKt.FRAGMENT_ENCODE_SET, "reason", "Lni/shikatu/okio/ByteString;", "cancelAfterCloseMillis", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(ILokio/ByteString;J)V", "getCode", "()I", "getReason", "()Lokio/ByteString;", "getCancelAfterCloseMillis", "()J", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int code, ByteString reason, long cancelAfterCloseMillis) {
            this.code = code;
            this.reason = reason;
            this.cancelAfterCloseMillis = cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/RealWebSocket$WriterTask;", "Lni/shikatu/okhttp3/internal/concurrent/Task;", "<init>", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e) {
                RealWebSocket.failWebSocket$default(RealWebSocket.this, e, null, true, 2, null);
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/RealWebSocket$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ONLY_HTTP1", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "MAX_QUEUE_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "CANCEL_AFTER_CLOSE_MILLIS", "DEFAULT_MINIMUM_DEFLATE_SIZE", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
