package ni.shikatu.okhttp3.internal.http;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal.connection.RealCall;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 #2\u00020\u0001:\u0002\"#J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\u0014H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH&J\n\u0010\u001f\u001a\u0004\u0018\u00010 H&J\b\u0010!\u001a\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006$À\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/http/ExchangeCodec;", _UrlKt.FRAGMENT_ENCODE_SET, "carrier", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec$Carrier;", "getCarrier", "()Lokhttp3/internal/http/ExchangeCodec$Carrier;", "isResponseComplete", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "socket", "Lni/shikatu/okio/Socket;", "getSocket", "()Lokio/Socket;", "createRequestBody", "Lni/shikatu/okio/Sink;", "request", "Lni/shikatu/okhttp3/Request;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "writeRequestHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "flushRequest", "finishRequest", "readResponseHeaders", "Lni/shikatu/okhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "response", "Lni/shikatu/okhttp3/Response;", "openResponseBodySource", "Lni/shikatu/okio/Source;", "peekTrailers", "Lni/shikatu/okhttp3/Headers;", "cancel", "Carrier", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ExchangeCodec {
    public static final Companion Companion = ni.shikatu.okhttp3.internal.http.ExchangeCodec.Companion.$$INSTANCE;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/http/ExchangeCodec$Carrier;", _UrlKt.FRAGMENT_ENCODE_SET, "route", "Lni/shikatu/okhttp3/Route;", "getRoute", "()Lokhttp3/Route;", "trackFailure", _UrlKt.FRAGMENT_ENCODE_SET, "call", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "e", "Ljava/io/IOException;", "noNewExchanges", "cancel", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Carrier {

        void mo1740cancel();

        Route getRoute();

        void noNewExchanges();

        void trackFailure(RealCall realCall, IOException iOException);
    }

    void cancel();

    Sink createRequestBody(Request request, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    Carrier getCarrier();

    Socket getSocket();

    boolean isResponseComplete();

    Source openResponseBodySource(Response response) throws IOException;

    Headers peekTrailers() throws IOException;

    Response.Builder readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(Response response) throws IOException;

    void writeRequestHeaders(Request request) throws IOException;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/okhttp3/internal/http/ExchangeCodec$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "DISCARD_STREAM_TIMEOUT_MILLIS", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        private Companion() {
        }
    }
}
