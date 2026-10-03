package ni.shikatu.okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Regex;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Interceptor;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.RequestBody;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal.UnreadableResponseBodyKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.connection.Exchange;
import ni.shikatu.okhttp3.internal.connection.RealCall;
import ni.shikatu.okhttp3.internal.connection.RealConnection;
import ni.shikatu.okhttp3.internal.http2.ConnectionShutdownException;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lni/shikatu/okhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lni/shikatu/okhttp3/Interceptor;", "client", "Lni/shikatu/okhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;)V", "intercept", "Lni/shikatu/okhttp3/Response;", "chain", "Lni/shikatu/okhttp3/Interceptor$Chain;", "recover", _UrlKt.FRAGMENT_ENCODE_SET, "e", "Ljava/io/IOException;", "call", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "userRequest", "Lni/shikatu/okhttp3/Request;", "requestIsOneShot", "isRecoverable", "requestSendStarted", "followUpRequest", "userResponse", "exchange", "Lni/shikatu/okhttp3/internal/connection/Exchange;", "buildRedirectRequest", "method", _UrlKt.FRAGMENT_ENCODE_SET, "retryAfter", _UrlKt.FRAGMENT_ENCODE_SET, "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = ((RealInterceptorChain) chain).getRequest$okhttp();
        RealCall call = realChain.getCall$okhttp();
        List recoveredFailures = CollectionsKt.emptyList();
        boolean newRoutePlanner = true;
        Response priorResponse = null;
        int followUpCount = 0;
        Request request2 = request;
        while (true) {
            call.enterNetworkInterceptorExchange(request2, newRoutePlanner, (RealInterceptorChain) chain);
            try {
                if (call.isCanceled()) {
                    throw new IOException("Canceled");
                }
                try {
                    newRoutePlanner = true;
                    Response response = realChain.proceed(request2).newBuilder().request(request2).priorResponse(priorResponse != null ? UnreadableResponseBodyKt.stripBody(priorResponse) : null).build();
                    Exchange exchange = call.getInterceptorScopedExchange$okhttp();
                    Request followUp = followUpRequest(response, exchange);
                    if (followUp == null) {
                        if (exchange != null && exchange.isDuplex$okhttp()) {
                            call.timeoutEarlyExit();
                        }
                        call.getEventListener$okhttp().followUpDecision(call, response, null);
                        call.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    RequestBody followUpBody = followUp.body();
                    if (followUpBody != null && followUpBody.isOneShot()) {
                        call.getEventListener$okhttp().followUpDecision(call, response, null);
                        call.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    _UtilCommonKt.closeQuietly(response.body());
                    followUpCount++;
                    if (followUpCount > MAX_FOLLOW_UPS) {
                        call.getEventListener$okhttp().followUpDecision(call, response, null);
                        throw new ProtocolException("Too many follow-up requests: " + followUpCount);
                    }
                    call.getEventListener$okhttp().followUpDecision(call, response, followUp);
                    request2 = followUp;
                    priorResponse = response;
                    call.exitNetworkInterceptorExchange$okhttp(true);
                } catch (IOException e) {
                    boolean isRecoverable = recover(e, call, request2);
                    call.getEventListener$okhttp().retryDecision(call, e, isRecoverable);
                    if (!isRecoverable) {
                        throw _UtilCommonKt.withSuppressed(e, recoveredFailures);
                    }
                    recoveredFailures = CollectionsKt.plus((Collection<? extends IOException>) recoveredFailures, e);
                    newRoutePlanner = false;
                    call.exitNetworkInterceptorExchange$okhttp(true);
                }
            } catch (Throwable th) {
                call.exitNetworkInterceptorExchange$okhttp(true);
                throw th;
            }
        }
    }

    private final boolean recover(IOException e, RealCall call, Request userRequest) {
        boolean requestSendStarted = !(e instanceof ConnectionShutdownException);
        if (this.client.retryOnConnectionFailure()) {
            return !(requestSendStarted && requestIsOneShot(e, userRequest)) && isRecoverable(e, requestSendStarted) && call.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException e, Request userRequest) {
        RequestBody requestBody = userRequest.body();
        return (requestBody != null && requestBody.isOneShot()) || (e instanceof FileNotFoundException);
    }

    private final boolean isRecoverable(IOException e, boolean requestSendStarted) {
        if (e instanceof ProtocolException) {
            return false;
        }
        if (e instanceof InterruptedIOException) {
            return (e instanceof SocketTimeoutException) && !requestSendStarted;
        }
        return (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final Request followUpRequest(Response userResponse, Exchange exchange) throws IOException {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int responseCode = userResponse.code();
        String method = userResponse.request().method();
        switch (responseCode) {
            case 300:
            case 301:
            case 302:
            case 303:
            case HttpStatusCodesKt.HTTP_TEMP_REDIRECT /* 307 */:
            case HttpStatusCodesKt.HTTP_PERM_REDIRECT /* 308 */:
                return buildRedirectRequest(userResponse, method);
            case 401:
                return this.client.authenticator().authenticate(route, userResponse);
            case 407:
                Intrinsics.checkNotNull(route);
                Proxy selectedProxy = route.proxy();
                if (selectedProxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, userResponse);
            case 408:
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody requestBody = userResponse.request().body();
                if (requestBody != null && requestBody.isOneShot()) {
                    return null;
                }
                Response priorResponse = userResponse.priorResponse();
                if ((priorResponse != null && priorResponse.code() == 408) || retryAfter(userResponse, 0) > 0) {
                    return null;
                }
                return userResponse.request();
            case HttpStatusCodesKt.HTTP_MISDIRECTED_REQUEST /* 421 */:
                RequestBody requestBody2 = userResponse.request().body();
                if ((requestBody2 != null && requestBody2.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return userResponse.request();
            case 503:
                Response priorResponse2 = userResponse.priorResponse();
                if ((priorResponse2 != null && priorResponse2.code() == 503) || retryAfter(userResponse, IntCompanionObject.MAX_VALUE) != 0) {
                    return null;
                }
                return userResponse.request();
            default:
                return null;
        }
    }

    private final Request buildRedirectRequest(Response userResponse, String method) {
        String location;
        HttpUrl url;
        if (!this.client.followRedirects() || (location = Response.header$default(userResponse, "Location", null, 2, null)) == null || (url = userResponse.request().url().resolve(location)) == null) {
            return null;
        }
        boolean sameScheme = Intrinsics.areEqual(url.scheme(), userResponse.request().url().scheme());
        if (!sameScheme && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder requestBuilder = userResponse.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            int responseCode = userResponse.code();
            boolean maintainBody = HttpMethod.INSTANCE.redirectsWithBody(method) || responseCode == 308 || responseCode == 307;
            if (HttpMethod.INSTANCE.redirectsToGet(method) && responseCode != 308 && responseCode != 307) {
                requestBuilder.method("GET", null);
            } else {
                RequestBody requestBody = maintainBody ? userResponse.request().body() : null;
                requestBuilder.method(method, requestBody);
            }
            if (!maintainBody) {
                requestBuilder.removeHeader("Transfer-Encoding");
                requestBuilder.removeHeader("Content-Length");
                requestBuilder.removeHeader("Content-Type");
            }
        }
        if (!_UtilJvmKt.canReuseConnectionFor(userResponse.request().url(), url)) {
            requestBuilder.removeHeader("Authorization");
        }
        return requestBuilder.url(url).build();
    }

    private final int retryAfter(Response userResponse, int defaultDelay) {
        String header = Response.header$default(userResponse, "Retry-After", null, 2, null);
        if (header == null) {
            return defaultDelay;
        }
        if (new Regex("\\d+").matches(header)) {
            Integer numValueOf = Integer.valueOf(header);
            Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(...)");
            return numValueOf.intValue();
        }
        return IntCompanionObject.MAX_VALUE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/okhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MAX_FOLLOW_UPS", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
