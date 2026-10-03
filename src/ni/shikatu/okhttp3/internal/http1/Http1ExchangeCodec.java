package ni.shikatu.okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.CookieJar;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.RequestBody;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.connection.BufferedSocket;
import ni.shikatu.okhttp3.internal.http.ExchangeCodec;
import ni.shikatu.okhttp3.internal.http.HttpHeaders;
import ni.shikatu.okhttp3.internal.http.RequestLine;
import ni.shikatu.okhttp3.internal.http.StatusLine;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.ForwardingTimeout;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0007>?@ABCDB!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0014H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010)\u001a\u00020\"H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\u0016\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u0013H\u0016J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\u0018\u00104\u001a\u00020'2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020 H\u0002J\u0010\u00108\u001a\u00020'2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00109\u001a\u00020'2\u0006\u00105\u001a\u000206H\u0002J\u0010\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020<H\u0002J\u000e\u0010=\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0015R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006E"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec;", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec;", "client", "Lni/shikatu/okhttp3/OkHttpClient;", "carrier", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec$Carrier;", "socket", "Lni/shikatu/okhttp3/internal/connection/BufferedSocket;", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/ExchangeCodec$Carrier;Lokhttp3/internal/connection/BufferedSocket;)V", "getCarrier", "()Lokhttp3/internal/http/ExchangeCodec$Carrier;", "getSocket", "()Lokhttp3/internal/connection/BufferedSocket;", "state", _UrlKt.FRAGMENT_ENCODE_SET, "headersReader", "Lni/shikatu/okhttp3/internal/http1/HeadersReader;", "isChunked", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Response;", "(Lokhttp3/Response;)Z", "Lni/shikatu/okhttp3/Request;", "(Lokhttp3/Request;)Z", "trailers", "Lni/shikatu/okhttp3/Headers;", "isResponseComplete", "()Z", "createRequestBody", "Lni/shikatu/okio/Sink;", "request", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "cancel", _UrlKt.FRAGMENT_ENCODE_SET, "writeRequestHeaders", "reportedContentLength", "response", "openResponseBodySource", "Lni/shikatu/okio/Source;", "peekTrailers", "flushRequest", "finishRequest", "writeRequest", "headers", "requestLine", _UrlKt.FRAGMENT_ENCODE_SET, "readResponseHeaders", "Lni/shikatu/okhttp3/Response$Builder;", "expectContinue", "newChunkedSink", "newKnownLengthSink", "newFixedLengthSource", "url", "Lni/shikatu/okhttp3/HttpUrl;", "length", "newChunkedSource", "newUnknownLengthSource", "detachTimeout", "timeout", "Lni/shikatu/okio/ForwardingTimeout;", "skipConnectBody", "KnownLengthSink", "ChunkedSink", "AbstractSource", "FixedLengthSource", "ChunkedSource", "UnknownLengthSource", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Http1ExchangeCodec implements ExchangeCodec {
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final ExchangeCodec.Carrier carrier;
    private final OkHttpClient client;
    private final HeadersReader headersReader;
    private final BufferedSocket socket;
    private int state;
    private Headers trailers;
    public static final Companion Companion = new Companion(null);
    private static final Headers TRAILERS_RESPONSE_BODY_TRUNCATED = Headers.Companion.of("OkHttp-Response-Body", "Truncated");

    public Http1ExchangeCodec(OkHttpClient client, ExchangeCodec.Carrier carrier, BufferedSocket socket) {
        Intrinsics.checkNotNullParameter(carrier, "carrier");
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.client = client;
        this.carrier = carrier;
        this.socket = socket;
        this.headersReader = new HeadersReader(getSocket().getSource());
    }

    @Override
    public ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override
    public BufferedSocket getSocket() {
        return this.socket;
    }

    private final boolean isChunked(Response $this$isChunked) {
        return StringsKt.equals("chunked", Response.header$default($this$isChunked, "Transfer-Encoding", null, 2, null), true);
    }

    private final boolean isChunked(Request $this$isChunked) {
        return StringsKt.equals("chunked", $this$isChunked.header("Transfer-Encoding"), true);
    }

    @Override
    public boolean isResponseComplete() {
        return this.state == 6;
    }

    @Override
    public Sink createRequestBody(Request request, long contentLength) throws ProtocolException {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBodyBody = request.body();
        boolean z = false;
        if (requestBodyBody != null && requestBodyBody.isDuplex()) {
            z = true;
        }
        if (z) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (isChunked(request)) {
            return newChunkedSink();
        }
        if (contentLength != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override
    public void cancel() {
        getCarrier().mo1740cancel();
    }

    @Override
    public void writeRequestHeaders(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getCarrier().getRoute().proxy().type();
        Intrinsics.checkNotNullExpressionValue(type, "type(...)");
        String requestLine2 = requestLine.get(request, type);
        writeRequest(request.headers(), requestLine2);
    }

    @Override
    public long reportedContentLength(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (isChunked(response)) {
            return -1L;
        }
        return _UtilJvmKt.headersContentLength(response);
    }

    @Override
    public Source openResponseBodySource(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(response.request().url(), 0L);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        }
        long contentLength = _UtilJvmKt.headersContentLength(response);
        if (contentLength != -1) {
            return newFixedLengthSource(response.request().url(), contentLength);
        }
        return newUnknownLengthSource(response.request().url());
    }

    @Override
    public Headers peekTrailers() throws IOException {
        if (this.trailers == TRAILERS_RESPONSE_BODY_TRUNCATED) {
            throw new IOException("Trailers cannot be read because the response body was truncated");
        }
        if (!(this.state == 5 || this.state == 6)) {
            throw new IllegalStateException(("Trailers cannot be read because the state is " + this.state).toString());
        }
        return this.trailers;
    }

    @Override
    public void flushRequest() throws IOException {
        getSocket().getSink().flush();
    }

    @Override
    public void finishRequest() throws IOException {
        getSocket().getSink().flush();
    }

    public final void writeRequest(Headers headers, String requestLine) throws IOException {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (!(this.state == 0)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        getSocket().getSink().writeUtf8(requestLine).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            getSocket().getSink().writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        getSocket().getSink().writeUtf8("\r\n");
        this.state = 1;
    }

    @Override
    public Response.Builder readResponseHeaders(boolean expectContinue) throws IOException {
        boolean z = false;
        if (!(this.state == 0 || this.state == 1 || this.state == 2 || this.state == 3)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            StatusLine statusLine = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder responseBuilder = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(this.headersReader.readHeaders());
            if (!expectContinue || statusLine.code != 100) {
                if (statusLine.code == 100) {
                    this.state = 3;
                } else {
                    int i = statusLine.code;
                    if (102 <= i && i < 200) {
                        z = true;
                    }
                    if (z) {
                        this.state = 3;
                    } else {
                        this.state = 4;
                    }
                }
                return responseBuilder;
            }
            return null;
        } catch (EOFException e) {
            String address = getCarrier().getRoute().address().url().redact();
            throw new IOException("unexpected end of stream on " + address, e);
        }
    }

    private final Sink newChunkedSink() {
        if (!(this.state == 1)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new ChunkedSink();
    }

    private final Sink newKnownLengthSink() {
        if (!(this.state == 1)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new KnownLengthSink();
    }

    private final Source newFixedLengthSource(HttpUrl url, long length) {
        if (!(this.state == 4)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new FixedLengthSource(this, url, length);
    }

    private final Source newChunkedSource(HttpUrl url) {
        if (!(this.state == 4)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new ChunkedSource(this, url);
    }

    private final Source newUnknownLengthSource(HttpUrl url) {
        if (!(this.state == 4)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        getCarrier().noNewExchanges();
        return new UnknownLengthSource(this, url);
    }

    public final void detachTimeout(ForwardingTimeout timeout) {
        Timeout oldDelegate = timeout.delegate();
        timeout.setDelegate(Timeout.NONE);
        oldDelegate.clearDeadline();
        oldDelegate.clearTimeout();
    }

    public final void skipConnectBody(Response response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        long contentLength = _UtilJvmKt.headersContentLength(response);
        if (contentLength == -1) {
            return;
        }
        Source body = newFixedLengthSource(response.request().url(), contentLength);
        _UtilJvmKt.skipAll(body, IntCompanionObject.MAX_VALUE, TimeUnit.MILLISECONDS);
        body.close();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lni/shikatu/okio/Sink;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "timeout", "Lni/shikatu/okio/ForwardingTimeout;", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/Timeout;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "flush", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class KnownLengthSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public KnownLengthSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.getSocket().getSink().timeout());
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public void write(Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            _UtilCommonKt.checkOffsetAndCount(source.size(), 0L, byteCount);
            Http1ExchangeCodec.this.getSocket().getSink().write(source, byteCount);
        }

        @Override
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.getSocket().getSink().flush();
        }

        @Override
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lni/shikatu/okio/Sink;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "timeout", "Lni/shikatu/okio/ForwardingTimeout;", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/Timeout;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "flush", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.getSocket().getSink().timeout());
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public void write(Buffer source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            if (byteCount == 0) {
                return;
            }
            BufferedSink $this$write_u24lambda_u241 = Http1ExchangeCodec.this.getSocket().getSink();
            $this$write_u24lambda_u241.writeHexadecimalUnsignedLong(byteCount);
            $this$write_u24lambda_u241.writeUtf8("\r\n");
            $this$write_u24lambda_u241.write(source, byteCount);
            $this$write_u24lambda_u241.writeUtf8("\r\n");
        }

        @Override
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.getSocket().getSink().flush();
        }

        @Override
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.getSocket().getSink().writeUtf8("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b¢\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lni/shikatu/okio/Source;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "getUrl", "()Lokhttp3/HttpUrl;", "timeout", "Lni/shikatu/okio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "getClosed", "()Z", "setClosed", "(Z)V", "Lni/shikatu/okio/Timeout;", "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "responseBodyComplete", _UrlKt.FRAGMENT_ENCODE_SET, "trailers", "Lni/shikatu/okhttp3/Headers;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private abstract class AbstractSource implements Source {
        private boolean closed;
        final  Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;
        private final HttpUrl url;

        public AbstractSource(Http1ExchangeCodec this$0, HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.this$0 = this$0;
            this.url = url;
            this.timeout = new ForwardingTimeout(this.this$0.getSocket().getSource().timeout());
        }

        public final HttpUrl getUrl() {
            return this.url;
        }

        protected final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        protected final boolean getClosed() {
            return this.closed;
        }

        protected final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return this.this$0.getSocket().getSource().read(sink, byteCount);
            } catch (IOException e) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw e;
            }
        }

        public final void responseBodyComplete(Headers trailers) {
            OkHttpClient okHttpClient;
            CookieJar cookieJar;
            Intrinsics.checkNotNullParameter(trailers, "trailers");
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state == 5) {
                this.this$0.detachTimeout(this.timeout);
                this.this$0.trailers = trailers;
                this.this$0.state = 6;
                if (trailers.size() <= 0 || (okHttpClient = this.this$0.client) == null || (cookieJar = okHttpClient.cookieJar()) == null) {
                    return;
                }
                HttpHeaders.receiveHeaders(cookieJar, this.url, trailers);
                return;
            }
            throw new IllegalStateException("state: " + this.this$0.state);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "bytesRemaining", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;J)V", "read", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "close", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final  Http1ExchangeCodec this$0;

        public FixedLengthSource(Http1ExchangeCodec this$0, HttpUrl url, long bytesRemaining) {
            super(this$0, url);
            Intrinsics.checkNotNullParameter(url, "url");
            this.this$0 = this$0;
            this.bytesRemaining = bytesRemaining;
            if (this.bytesRemaining != 0) {
                return;
            }
            responseBodyComplete(Headers.EMPTY);
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.bytesRemaining == 0) {
                return -1L;
            }
            long read = super.read(sink, Math.min(this.bytesRemaining, byteCount));
            if (read == -1) {
                this.this$0.getCarrier().noNewExchanges();
                ProtocolException e = new ProtocolException("unexpected end of stream");
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw e;
            }
            this.bytesRemaining -= read;
            if (this.bytesRemaining == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
            return read;
        }

        @Override
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "bytesRemainingInChunk", _UrlKt.FRAGMENT_ENCODE_SET, "hasMoreChunks", _UrlKt.FRAGMENT_ENCODE_SET, "read", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "readChunkSize", _UrlKt.FRAGMENT_ENCODE_SET, "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final  Http1ExchangeCodec this$0;

        public ChunkedSource(Http1ExchangeCodec this$0, HttpUrl url) {
            super(this$0, url);
            Intrinsics.checkNotNullParameter(url, "url");
            this.this$0 = this$0;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long read = super.read(sink, Math.min(byteCount, this.bytesRemainingInChunk));
            if (read == -1) {
                this.this$0.getCarrier().noNewExchanges();
                ProtocolException e = new ProtocolException("unexpected end of stream");
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw e;
            }
            this.bytesRemainingInChunk -= read;
            return read;
        }

        private final void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                this.this$0.getSocket().getSource().readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.getSocket().getSource().readHexadecimalUnsignedLong();
                String extensions = StringsKt.trim((CharSequence) this.this$0.getSocket().getSource().readUtf8LineStrict()).toString();
                if (this.bytesRemainingInChunk >= 0) {
                    if (!(extensions.length() > 0) || StringsKt.startsWith$default(extensions, ";", false, 2, (Object) null)) {
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            Headers trailers = this.this$0.headersReader.readHeaders();
                            responseBodyComplete(trailers);
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + extensions + '\"');
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "inputExhausted", _UrlKt.FRAGMENT_ENCODE_SET, "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "close", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final  Http1ExchangeCodec this$0;

        public UnknownLengthSource(Http1ExchangeCodec this$0, HttpUrl url) {
            super(this$0, url);
            Intrinsics.checkNotNullParameter(url, "url");
            this.this$0 = this$0;
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long read = super.read(sink, byteCount);
            if (read == -1) {
                this.inputExhausted = true;
                responseBodyComplete(Headers.EMPTY);
                return -1L;
            }
            return read;
        }

        @Override
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/internal/http1/Http1ExchangeCodec$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "NO_CHUNK_YET", _UrlKt.FRAGMENT_ENCODE_SET, "STATE_IDLE", _UrlKt.FRAGMENT_ENCODE_SET, "STATE_OPEN_REQUEST_BODY", "STATE_WRITING_REQUEST_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_CLOSED", "TRAILERS_RESPONSE_BODY_TRUNCATED", "Lni/shikatu/okhttp3/Headers;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
