package ni.shikatu.okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000 N2\u00020\u0001:\u0003MNOB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J+\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J+\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0018\u001a\r\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b\u00130\u0011H\u0016J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J*\u0010\"\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J2\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u00101\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010:\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00102\u001a\u000203H\u0016J\u0018\u0010;\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010=\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010?\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010@\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010B\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010C\u001a\u000208H\u0016J \u0010D\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020GH\u0016J\"\u0010H\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010/H\u0016J\u0011\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0000H\u0086\u0002¨\u0006P"}, d2 = {"Lni/shikatu/okhttp3/EventListener;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "callStart", _UrlKt.FRAGMENT_ENCODE_SET, "call", "Lni/shikatu/okhttp3/Call;", "dispatcherQueueStart", "dispatcher", "Lni/shikatu/okhttp3/Dispatcher;", "dispatcherQueueEnd", "proxySelectStart", "url", "Lni/shikatu/okhttp3/HttpUrl;", "proxySelectEnd", "proxies", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/net/Proxy;", "Lni/shikatu/kotlin/jvm/JvmSuppressWildcards;", "dnsStart", "domainName", _UrlKt.FRAGMENT_ENCODE_SET, "dnsEnd", "inetAddressList", "Ljava/net/InetAddress;", "connectStart", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "secureConnectStart", "secureConnectEnd", "handshake", "Lni/shikatu/okhttp3/Handshake;", "connectEnd", "protocol", "Lni/shikatu/okhttp3/Protocol;", "connectFailed", "ioe", "Ljava/io/IOException;", "connectionAcquired", "connection", "Lni/shikatu/okhttp3/Connection;", "connectionReleased", "requestHeadersStart", "requestHeadersEnd", "request", "Lni/shikatu/okhttp3/Request;", "requestBodyStart", "requestBodyEnd", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "requestFailed", "responseHeadersStart", "responseHeadersEnd", "response", "Lni/shikatu/okhttp3/Response;", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cacheConditionalHit", "cachedResponse", "retryDecision", "exception", "retry", _UrlKt.FRAGMENT_ENCODE_SET, "followUpDecision", "networkResponse", "nextRequest", "plus", "other", "Factory", "Companion", "AggregateEventListener", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() {
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/EventListener$Factory;", _UrlKt.FRAGMENT_ENCODE_SET, "create", "Lni/shikatu/okhttp3/EventListener;", "call", "Lni/shikatu/okhttp3/Call;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        EventListener create(Call call);
    }

    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> list) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(list, "proxies");
    }

    public void dnsStart(Call call, String domainName) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> list) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(list, "inetAddressList");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void secureConnectStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
    }

    public void requestBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void requestBodyEnd(Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void responseBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void responseBodyEnd(Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void callFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void canceled(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void cacheHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void cacheMiss(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void cacheConditionalHit(Call call, Response cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
    }

    public void retryDecision(Call call, IOException exception, boolean retry) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    public void followUpDecision(Call call, Response networkResponse, Request nextRequest) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
    }

    public final EventListener plus(EventListener other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this == NONE) {
            return other;
        }
        EventListener[] left = this instanceof AggregateEventListener ? ((AggregateEventListener) this).getEventListeners() : new EventListener[]{this};
        if (other == NONE) {
            return this;
        }
        EventListener[] right = other instanceof AggregateEventListener ? ((AggregateEventListener) other).getEventListeners() : new EventListener[]{other};
        return new AggregateEventListener((EventListener[]) ArraysKt.plus((Object[]) left, (Object[]) right));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/okhttp3/EventListener$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "NONE", "Lni/shikatu/okhttp3/EventListener;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J+\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0011\u0010\u0015\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b\u00180\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J+\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u001d\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b\u00180\u0016H\u0016J \u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J*\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J2\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u00102\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u00106\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010:\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010;\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010?\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010@\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010A\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010B\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010C\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010D\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010<\u001a\u00020=H\u0016J\u0018\u0010E\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010H\u001a\u00020=H\u0016J \u0010I\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020LH\u0016J\"\u0010M\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010N\u001a\u00020=2\b\u0010O\u001a\u0004\u0018\u000104H\u0016R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006P"}, d2 = {"Lni/shikatu/okhttp3/EventListener$AggregateEventListener;", "Lni/shikatu/okhttp3/EventListener;", "eventListeners", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([Lokhttp3/EventListener;)V", "getEventListeners", "()[Lokhttp3/EventListener;", "[Lni/shikatu/okhttp3/EventListener;", "callStart", _UrlKt.FRAGMENT_ENCODE_SET, "call", "Lni/shikatu/okhttp3/Call;", "dispatcherQueueStart", "dispatcher", "Lni/shikatu/okhttp3/Dispatcher;", "dispatcherQueueEnd", "proxySelectStart", "url", "Lni/shikatu/okhttp3/HttpUrl;", "proxySelectEnd", "proxies", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/net/Proxy;", "Lni/shikatu/kotlin/jvm/JvmSuppressWildcards;", "dnsStart", "domainName", _UrlKt.FRAGMENT_ENCODE_SET, "dnsEnd", "inetAddressList", "Ljava/net/InetAddress;", "connectStart", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "secureConnectStart", "secureConnectEnd", "handshake", "Lni/shikatu/okhttp3/Handshake;", "connectEnd", "protocol", "Lni/shikatu/okhttp3/Protocol;", "connectFailed", "ioe", "Ljava/io/IOException;", "connectionAcquired", "connection", "Lni/shikatu/okhttp3/Connection;", "connectionReleased", "requestHeadersStart", "requestHeadersEnd", "request", "Lni/shikatu/okhttp3/Request;", "requestBodyStart", "requestBodyEnd", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "requestFailed", "responseHeadersStart", "responseHeadersEnd", "response", "Lni/shikatu/okhttp3/Response;", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cacheConditionalHit", "cachedResponse", "retryDecision", "exception", "retry", _UrlKt.FRAGMENT_ENCODE_SET, "followUpDecision", "networkResponse", "nextRequest", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class AggregateEventListener extends EventListener {
        private final EventListener[] eventListeners;

        public AggregateEventListener(EventListener[] eventListeners) {
            Intrinsics.checkNotNullParameter(eventListeners, "eventListeners");
            this.eventListeners = eventListeners;
        }

        public final EventListener[] getEventListeners() {
            return this.eventListeners;
        }

        @Override
        public void callStart(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.callStart(call);
            }
        }

        @Override
        public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            for (EventListener delegate : this.eventListeners) {
                delegate.dispatcherQueueStart(call, dispatcher);
            }
        }

        @Override
        public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            for (EventListener delegate : this.eventListeners) {
                delegate.dispatcherQueueEnd(call, dispatcher);
            }
        }

        @Override
        public void proxySelectStart(Call call, HttpUrl url) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(url, "url");
            for (EventListener delegate : this.eventListeners) {
                delegate.proxySelectStart(call, url);
            }
        }

        @Override
        public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> list) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(list, "proxies");
            for (EventListener delegate : this.eventListeners) {
                delegate.proxySelectEnd(call, url, list);
            }
        }

        @Override
        public void dnsStart(Call call, String domainName) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(domainName, "domainName");
            for (EventListener delegate : this.eventListeners) {
                delegate.dnsStart(call, domainName);
            }
        }

        @Override
        public void dnsEnd(Call call, String domainName, List<InetAddress> list) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(domainName, "domainName");
            Intrinsics.checkNotNullParameter(list, "inetAddressList");
            for (EventListener delegate : this.eventListeners) {
                delegate.dnsEnd(call, domainName, list);
            }
        }

        @Override
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            for (EventListener delegate : this.eventListeners) {
                delegate.connectStart(call, inetSocketAddress, proxy);
            }
        }

        @Override
        public void secureConnectStart(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.secureConnectStart(call);
            }
        }

        @Override
        public void secureConnectEnd(Call call, Handshake handshake) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.secureConnectEnd(call, handshake);
            }
        }

        @Override
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            for (EventListener delegate : this.eventListeners) {
                delegate.connectEnd(call, inetSocketAddress, proxy, protocol);
            }
        }

        @Override
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            for (EventListener delegate : this.eventListeners) {
                delegate.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
            }
        }

        @Override
        public void connectionAcquired(Call call, Connection connection) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(connection, "connection");
            for (EventListener delegate : this.eventListeners) {
                delegate.connectionAcquired(call, connection);
            }
        }

        @Override
        public void connectionReleased(Call call, Connection connection) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(connection, "connection");
            for (EventListener delegate : this.eventListeners) {
                delegate.connectionReleased(call, connection);
            }
        }

        @Override
        public void requestHeadersStart(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.requestHeadersStart(call);
            }
        }

        @Override
        public void requestHeadersEnd(Call call, Request request) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(request, "request");
            for (EventListener delegate : this.eventListeners) {
                delegate.requestHeadersEnd(call, request);
            }
        }

        @Override
        public void requestBodyStart(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.requestBodyStart(call);
            }
        }

        @Override
        public void requestBodyEnd(Call call, long byteCount) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.requestBodyEnd(call, byteCount);
            }
        }

        @Override
        public void requestFailed(Call call, IOException ioe) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            for (EventListener delegate : this.eventListeners) {
                delegate.requestFailed(call, ioe);
            }
        }

        @Override
        public void responseHeadersStart(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.responseHeadersStart(call);
            }
        }

        @Override
        public void responseHeadersEnd(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            for (EventListener delegate : this.eventListeners) {
                delegate.responseHeadersEnd(call, response);
            }
        }

        @Override
        public void responseBodyStart(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.responseBodyStart(call);
            }
        }

        @Override
        public void responseBodyEnd(Call call, long byteCount) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.responseBodyEnd(call, byteCount);
            }
        }

        @Override
        public void responseFailed(Call call, IOException ioe) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            for (EventListener delegate : this.eventListeners) {
                delegate.responseFailed(call, ioe);
            }
        }

        @Override
        public void callEnd(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.callEnd(call);
            }
        }

        @Override
        public void callFailed(Call call, IOException ioe) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            for (EventListener delegate : this.eventListeners) {
                delegate.callFailed(call, ioe);
            }
        }

        @Override
        public void canceled(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.canceled(call);
            }
        }

        @Override
        public void satisfactionFailure(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            for (EventListener delegate : this.eventListeners) {
                delegate.satisfactionFailure(call, response);
            }
        }

        @Override
        public void cacheHit(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            for (EventListener delegate : this.eventListeners) {
                delegate.cacheHit(call, response);
            }
        }

        @Override
        public void cacheMiss(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            for (EventListener delegate : this.eventListeners) {
                delegate.cacheMiss(call);
            }
        }

        @Override
        public void cacheConditionalHit(Call call, Response cachedResponse) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            for (EventListener delegate : this.eventListeners) {
                delegate.cacheConditionalHit(call, cachedResponse);
            }
        }

        @Override
        public void retryDecision(Call call, IOException exception, boolean retry) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(exception, "exception");
            for (EventListener delegate : this.eventListeners) {
                delegate.retryDecision(call, exception, retry);
            }
        }

        @Override
        public void followUpDecision(Call call, Response networkResponse, Request nextRequest) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
            for (EventListener delegate : this.eventListeners) {
                delegate.followUpDecision(call, networkResponse, nextRequest);
            }
        }
    }
}
