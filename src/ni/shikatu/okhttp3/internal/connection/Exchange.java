package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.EventListener;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.RequestBody;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.ResponseBody;
import ni.shikatu.okhttp3.internal.http.ExchangeCodec;
import ni.shikatu.okhttp3.internal.http.RealResponseBody;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ForwardingSink;
import ni.shikatu.okio.ForwardingSource;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002BCB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020 J\u0006\u0010'\u001a\u00020 J\u0006\u0010(\u001a\u00020 J\u0010\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0013J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020.J\b\u00101\u001a\u0004\u0018\u000102J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020 J\u0006\u00106\u001a\u00020 J\u0006\u00107\u001a\u00020 J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0002J8\u0010;\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00132\b\b\u0002\u0010?\u001a\u00020\u00132\b\b\u0002\u0010@\u001a\u00020\u00132\b\u00109\u001a\u0004\u0018\u00010:J\u0006\u0010A\u001a\u00020 R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016¨\u0006D"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/Exchange;", _UrlKt.FRAGMENT_ENCODE_SET, "call", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "eventListener", "Lni/shikatu/okhttp3/EventListener;", "finder", "Lni/shikatu/okhttp3/internal/connection/ExchangeFinder;", "codec", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "isDuplex", "isDuplex$okhttp", "()Z", "hasFailure", "getHasFailure$okhttp", "connection", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "isCoalescedConnection", "isCoalescedConnection$okhttp", "writeRequestHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "request", "Lni/shikatu/okhttp3/Request;", "createRequestBody", "Lni/shikatu/okio/Sink;", "duplex", "flushRequest", "finishRequest", "responseHeadersStart", "readResponseHeaders", "Lni/shikatu/okhttp3/Response$Builder;", "expectContinue", "responseHeadersEnd", "response", "Lni/shikatu/okhttp3/Response;", "openResponseBody", "Lni/shikatu/okhttp3/ResponseBody;", "peekTrailers", "Lni/shikatu/okhttp3/Headers;", "upgradeToSocket", "Lni/shikatu/okio/Socket;", "noNewExchangesOnConnection", "cancel", "detachWithViolence", "trackFailure", "e", "Ljava/io/IOException;", "bodyComplete", "bytesRead", _UrlKt.FRAGMENT_ENCODE_SET, "isSocket", "responseDone", "requestDone", "noRequestBody", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    public Exchange(RealCall call, EventListener eventListener, ExchangeFinder finder, ExchangeCodec codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final RealConnection getConnection$okhttp() {
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        RealConnection realConnection = carrier instanceof RealConnection ? (RealConnection) carrier : null;
        if (realConnection != null) {
            return realConnection;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels".toString());
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.areEqual(this.finder.getRoutePlanner().getAddress().url().host(), this.codec.getCarrier().getRoute().address().url().host());
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final Sink createRequestBody(Request request, boolean duplex) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.isDuplex = duplex;
        RequestBody requestBodyBody = request.body();
        Intrinsics.checkNotNull(requestBodyBody);
        long contentLength = requestBodyBody.contentLength();
        this.eventListener.requestBodyStart(this.call);
        Sink rawRequestBody = this.codec.createRequestBody(request, contentLength);
        return new RequestBodySink(this, rawRequestBody, contentLength, false);
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Response.Builder readResponseHeaders(boolean expectContinue) throws IOException {
        try {
            Response.Builder result = this.codec.readResponseHeaders(expectContinue);
            if (result != null) {
                result.initExchange$okhttp(this);
            }
            return result;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersEnd(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        Exchange exchange;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String contentType = Response.header$default(response, "Content-Type", null, 2, null);
            long contentLength = this.codec.reportedContentLength(response);
            Source rawSource = this.codec.openResponseBodySource(response);
            exchange = this;
            try {
                ResponseBodySource source = new ResponseBodySource(exchange, rawSource, contentLength, false);
                return new RealResponseBody(contentType, contentLength, Okio.buffer(source));
            } catch (IOException e) {
                e = e;
                exchange.eventListener.responseFailed(exchange.call, e);
                trackFailure(e);
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            exchange = this;
        }
    }

    public final Headers peekTrailers() throws IOException {
        return this.codec.peekTrailers();
    }

    public final Socket upgradeToSocket() throws SocketException {
        this.call.upgradeToSocket();
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        Intrinsics.checkNotNull(carrier, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        ((RealConnection) carrier).useAsSocket$okhttp();
        return new Socket() {
            private final RequestBodySink sink;
            private final ResponseBodySource source;

            {
                this.sink = new RequestBodySink(Exchange.this, Exchange.this.codec.getSocket().getSink(), -1L, true);
                this.source = new ResponseBodySource(Exchange.this, Exchange.this.codec.getSocket().getSource(), -1L, true);
            }

            @Override
            public void cancel() {
                Exchange.this.cancel();
            }

            @Override
            public RequestBodySink getSink() {
                return this.sink;
            }

            @Override
            public ResponseBodySource getSource() {
                return this.source;
            }
        };
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getCarrier().noNewExchanges();
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, true, true, null);
    }

    private final void trackFailure(IOException e) {
        this.hasFailure = true;
        this.codec.getCarrier().trackFailure(this.call, e);
    }

    public static  IOException bodyComplete$default(Exchange exchange, long j, boolean z, boolean z2, boolean z3, IOException iOException, int i, Object obj) {
        return exchange.bodyComplete((i & 1) != 0 ? -1L : j, z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, iOException);
    }

    public final IOException bodyComplete(long bytesRead, boolean isSocket, boolean responseDone, boolean requestDone, IOException e) {
        if (e != null) {
            trackFailure(e);
        }
        if (requestDone) {
            if (e != null) {
                this.eventListener.requestFailed(this.call, e);
            } else {
                this.eventListener.requestBodyEnd(this.call, bytesRead);
            }
        }
        if (responseDone) {
            if (e != null) {
                this.eventListener.responseFailed(this.call, e);
            } else {
                this.eventListener.responseBodyEnd(this.call, bytesRead);
            }
        }
        return this.call.messageDone$okhttp(this, requestDone && !isSocket, responseDone && !isSocket, responseDone && isSocket, requestDone && isSocket, e);
    }

    public final void noRequestBody() {
        RealCall.messageDone$okhttp$default(this.call, this, true, false, false, false, null, 28, null);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/Exchange$RequestBodySink;", "Lni/shikatu/okio/ForwardingSink;", "delegate", "Lni/shikatu/okio/Sink;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "isSocket", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;JZ)V", "completed", "bytesReceived", "invokeStartEvent", "closed", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", "flush", "close", "complete", "Ljava/io/IOException;", "e", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final  Exchange this$0;

        public RequestBodySink(Exchange this$0, Sink delegate, long contentLength, boolean isSocket) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = this$0;
            this.contentLength = contentLength;
            this.isSocket = isSocket;
            this.invokeStartEvent = this.isSocket;
        }

        @Override
        public void write(Buffer source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.contentLength != -1 && this.bytesReceived + byteCount > this.contentLength) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
            }
            try {
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().requestBodyStart(this.this$0.getCall$okhttp());
                }
                super.write(source, byteCount);
                this.bytesReceived += byteCount;
            } catch (IOException e) {
                IOException iOExceptionComplete = complete(e);
                Intrinsics.checkNotNull(iOExceptionComplete);
                throw iOExceptionComplete;
            }
        }

        @Override
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                IOException iOExceptionComplete = complete(e);
                Intrinsics.checkNotNull(iOExceptionComplete);
                throw iOExceptionComplete;
            }
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.contentLength != -1 && this.bytesReceived != this.contentLength) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                IOException iOExceptionComplete = complete(e);
                Intrinsics.checkNotNull(iOExceptionComplete);
                throw iOExceptionComplete;
            }
        }

        private final IOException complete(IOException e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, false, true, e, 4, null);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/Exchange$ResponseBodySource;", "Lni/shikatu/okio/ForwardingSource;", "delegate", "Lni/shikatu/okio/Source;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "isSocket", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;JZ)V", "bytesReceived", "invokeStartEvent", "completed", "closed", "read", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "close", _UrlKt.FRAGMENT_ENCODE_SET, "complete", "Ljava/io/IOException;", "e", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final  Exchange this$0;

        public ResponseBodySource(Exchange this$0, Source delegate, long contentLength, boolean isSocket) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = this$0;
            this.contentLength = contentLength;
            this.isSocket = isSocket;
            this.invokeStartEvent = true;
            if (this.contentLength != 0) {
                return;
            }
            complete(null);
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long read = delegate().read(sink, byteCount);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (read == -1) {
                    complete(null);
                    return -1L;
                }
                long newBytesReceived = this.bytesReceived + read;
                if (this.contentLength != -1 && newBytesReceived > this.contentLength) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + newBytesReceived);
                }
                this.bytesReceived = newBytesReceived;
                if (this.this$0.codec.isResponseComplete()) {
                    complete(null);
                }
                return read;
            } catch (IOException e) {
                IOException iOExceptionComplete = complete(e);
                Intrinsics.checkNotNull(iOExceptionComplete);
                throw iOExceptionComplete;
            }
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                IOException iOExceptionComplete = complete(e);
                Intrinsics.checkNotNull(iOExceptionComplete);
                throw iOExceptionComplete;
            }
        }

        public final IOException complete(IOException e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            if (e == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, true, false, e, 8, null);
        }
    }
}
