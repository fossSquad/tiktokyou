package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.okhttp3.Call;
import ni.shikatu.okhttp3.Callback;
import ni.shikatu.okhttp3.Dispatcher;
import ni.shikatu.okhttp3.EventListener;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal.Tags;
import ni.shikatu.okhttp3.internal.TagsKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.cache.CacheInterceptor;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.http.BridgeInterceptor;
import ni.shikatu.okhttp3.internal.http.CallServerInterceptor;
import ni.shikatu.okhttp3.internal.http.ExchangeCodec;
import ni.shikatu.okhttp3.internal.http.RealInterceptorChain;
import ni.shikatu.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.AsyncTimeout;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0019\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002uvB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0018\u001a\u00020;H\u0016J'\u0010<\u001a\u0004\u0018\u0001H=\"\b\b\u0000\u0010=*\u00020\u001e2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H=0?H\u0016¢\u0006\u0002\u0010@J%\u0010<\u001a\u0004\u0018\u0001H=\"\u0004\b\u0000\u0010=2\u000e\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u0002H=0AH\u0016¢\u0006\u0002\u0010BJ3\u0010<\u001a\u0002H=\"\b\b\u0000\u0010=*\u00020\u001e2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H=0?2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H=0DH\u0016¢\u0006\u0002\u0010EJ3\u0010<\u001a\u0002H=\"\b\b\u0000\u0010=*\u00020\u001e2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H=0A2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H=0DH\u0016¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020\u0001H\u0016J\b\u0010H\u001a\u00020\u0007H\u0016J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020\tH\u0016J\b\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020J2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020\tH\u0016J\b\u0010R\u001a\u00020JH\u0002J\r\u0010S\u001a\u00020MH\u0000¢\u0006\u0002\bTJ\u001e\u0010U\u001a\u00020J2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020XJ\u0015\u0010Y\u001a\u00020'2\u0006\u0010W\u001a\u00020XH\u0000¢\u0006\u0002\bZJ\u000e\u0010[\u001a\u00020J2\u0006\u0010#\u001a\u00020\"JI\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u00101\u001a\u00020'2\b\b\u0002\u0010^\u001a\u00020\t2\b\b\u0002\u0010_\u001a\u00020\t2\b\b\u0002\u0010`\u001a\u00020\t2\b\b\u0002\u0010a\u001a\u00020\t2\b\u0010b\u001a\u0004\u0018\u00010]H\u0000¢\u0006\u0002\bcJ\u0019\u0010d\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]H\u0000¢\u0006\u0002\beJ\u0014\u0010f\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]H\u0002J\u000f\u0010g\u001a\u0004\u0018\u00010hH\u0000¢\u0006\u0002\biJ\u0014\u0010j\u001a\u0004\u0018\u00010]2\b\u0010k\u001a\u0004\u0018\u00010]H\u0002J\u0006\u0010&\u001a\u00020JJ\u0006\u0010l\u001a\u00020JJ\u0015\u0010m\u001a\u00020J2\u0006\u0010n\u001a\u00020\tH\u0000¢\u0006\u0002\boJ\u0006\u0010p\u001a\u00020\tJ\b\u0010q\u001a\u00020rH\u0002J\r\u0010s\u001a\u00020rH\u0000¢\u0006\u0002\btR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010(\u001a\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001c\u00107\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u0001090908X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealCall;", "Lni/shikatu/okhttp3/Call;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "client", "Lni/shikatu/okhttp3/OkHttpClient;", "originalRequest", "Lni/shikatu/okhttp3/Request;", "forWebSocket", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "getClient", "()Lokhttp3/OkHttpClient;", "getOriginalRequest", "()Lokhttp3/Request;", "getForWebSocket", "()Z", "connectionPool", "Lni/shikatu/okhttp3/internal/connection/RealConnectionPool;", "eventListener", "Lni/shikatu/okhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "timeout", "ni/shikatu/okhttp3/internal/connection/RealCall$timeout$1", "Lni/shikatu/okhttp3/internal/connection/RealCall$timeout$1;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "callStackTrace", _UrlKt.FRAGMENT_ENCODE_SET, "exchangeFinder", "Lni/shikatu/okhttp3/internal/connection/ExchangeFinder;", "value", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "connection", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "timeoutEarlyExit", "Lni/shikatu/okhttp3/internal/connection/Exchange;", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "requestBodyOpen", "responseBodyOpen", "socketSinkOpen", "socketSourceOpen", "expectMoreExchanges", "canceled", "exchange", "plansToCancel", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$Plan;", "getPlansToCancel$okhttp", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "tags", "Ljava/util/concurrent/atomic/AtomicReference;", "Lni/shikatu/okhttp3/internal/Tags;", "ni.shikatu.kotlin.jvm.PlatformType", "Lni/shikatu/okio/Timeout;", "tag", "T", "type", "Lni/shikatu/kotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "computeIfAbsent", "Lni/shikatu/kotlin/Function0;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "clone", "request", "cancel", _UrlKt.FRAGMENT_ENCODE_SET, "isCanceled", "execute", "Lni/shikatu/okhttp3/Response;", "enqueue", "responseCallback", "Lni/shikatu/okhttp3/Callback;", "isExecuted", "callStart", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "enterNetworkInterceptorExchange", "newRoutePlanner", "chain", "Lni/shikatu/okhttp3/internal/http/RealInterceptorChain;", "initExchange", "initExchange$okhttp", "acquireConnectionNoEvents", "messageDone", "Ljava/io/IOException;", "requestDone", "responseDone", "socketSourceDone", "socketSinkDone", "e", "messageDone$okhttp", "noMoreExchanges", "noMoreExchanges$okhttp", "callDone", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "timeoutExit", "cause", "upgradeToSocket", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "retryAfterFailure", "toLoggableString", _UrlKt.FRAGMENT_ENCODE_SET, "redactedUrl", "redactedUrl$okhttp", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealCall implements Call, Cloneable, Lockable {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> plansToCancel;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private boolean socketSinkOpen;
    private boolean socketSourceOpen;
    private final AtomicReference<Tags> tags;
    private final AsyncTimeout timeout;
    private boolean timeoutEarlyExit;

    public RealCall(OkHttpClient client, Request originalRequest, boolean forWebSocket) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = forWebSocket;
        this.connectionPool = this.client.connectionPool().getDelegate$okhttp();
        this.eventListener = this.client.eventListenerFactory().create(this);
        AsyncTimeout r0 = new AsyncTimeout() {
            @Override
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        r0.timeout(this.client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r0;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
        this.plansToCancel = new CopyOnWriteArrayList<>();
        this.tags = new AtomicReference<>(this.originalRequest.getTags$okhttp());
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final CopyOnWriteArrayList<RoutePlanner.Plan> getPlansToCancel$okhttp() {
        return this.plansToCancel;
    }

    @Override
    public Timeout timeout() {
        return this.timeout;
    }

    @Override
    public <T> T tag(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        return (T) JvmClassMappingKt.getJavaClass((KClass) kClass).cast(this.tags.get().get(kClass));
    }

    @Override
    public <T> T tag(Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        return (T) tag(JvmClassMappingKt.getKotlinClass(cls));
    }

    @Override
    public <T> T tag(KClass<T> kClass, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(function0, "computeIfAbsent");
        return (T) TagsKt.computeIfAbsent(this.tags, kClass, function0);
    }

    @Override
    public <T> T tag(Class<T> cls, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(function0, "computeIfAbsent");
        return (T) TagsKt.computeIfAbsent(this.tags, JvmClassMappingKt.getKotlinClass(cls), function0);
    }

    @Override
    public Call clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override
    public Request request() {
        return this.originalRequest;
    }

    @Override
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        Iterator<RoutePlanner.Plan> it = this.plansToCancel.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RoutePlanner.Plan plan = it.next();
            plan.mo1740cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    @Override
    public void enqueue(Callback responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
    }

    @Override
    public boolean isExecuted() {
        return this.executed.get();
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        List interceptors = new ArrayList();
        CollectionsKt.addAll(interceptors, this.client.interceptors());
        interceptors.add(new RetryAndFollowUpInterceptor(this.client));
        interceptors.add(new BridgeInterceptor(this.client.cookieJar()));
        interceptors.add(new CacheInterceptor(this.client.cache()));
        interceptors.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt.addAll(interceptors, this.client.networkInterceptors());
        }
        interceptors.add(CallServerInterceptor.INSTANCE);
        RealInterceptorChain chain = new RealInterceptorChain(this, interceptors, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        try {
            try {
                Response response = chain.proceed(this.originalRequest);
                if (isCanceled()) {
                    _UtilCommonKt.closeQuietly(response);
                    throw new IOException("Canceled");
                }
                noMoreExchanges$okhttp(null);
                return response;
            } catch (IOException e) {
                IOException iOExceptionNoMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
                Intrinsics.checkNotNull(iOExceptionNoMoreExchanges$okhttp, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionNoMoreExchanges$okhttp;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean newRoutePlanner, RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(chain, "chain");
        boolean z = true;
        if (!(this.interceptorScopedExchange == null)) {
            throw new IllegalStateException("Check failed.");
        }
        RealCall $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.INSTANCE;
        }
        if (newRoutePlanner) {
            RealRoutePlanner routePlanner = new RealRoutePlanner(this.client.getTaskRunner$okhttp(), this.connectionPool, this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), this.client.pingIntervalMillis(), this.client.retryOnConnectionFailure(), this.client.fastFallback(), this.client.address(request.url()), this.client.getRouteDatabase$okhttp(), this, request);
            this.exchangeFinder = this.client.fastFallback() ? new FastFallbackExchangeFinder(routePlanner, this.client.getTaskRunner$okhttp()) : new SequentialExchangeFinder(routePlanner);
        }
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealCall $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (!((this.responseBodyOpen || this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) ? false : true)) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.INSTANCE;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        RealConnection connection = exchangeFinder.find();
        ExchangeCodec codec = connection.newCodec$okhttp(this.client, chain);
        Exchange result = new Exchange(this, this.eventListener, exchangeFinder, codec);
        this.interceptorScopedExchange = result;
        this.exchange = result;
        RealCall $this$withLock$iv2 = this;
        synchronized ($this$withLock$iv2) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return result;
    }

    public final void acquireConnectionNoEvents(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        RealConnection $this$assertLockHeld$iv = connection;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            if (!(this.connection == null)) {
                throw new IllegalStateException("Check failed.");
            }
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public static  IOException messageDone$okhttp$default(RealCall realCall, Exchange exchange, boolean z, boolean z2, boolean z3, boolean z4, IOException iOException, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = false;
        }
        if ((i & 16) != 0) {
            z4 = false;
        }
        return realCall.messageDone$okhttp(exchange, z, z2, z3, z4, iOException);
    }

    public final IOException messageDone$okhttp(Exchange exchange, boolean requestDone, boolean responseDone, boolean socketSourceDone, boolean socketSinkDone, IOException e) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (!Intrinsics.areEqual(exchange, this.exchange)) {
            return e;
        }
        boolean allStreamsDone = false;
        boolean callDone = false;
        RealCall $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (requestDone) {
                try {
                    if (this.requestBodyOpen) {
                        z = false;
                        if (requestDone) {
                            this.requestBodyOpen = false;
                        }
                        if (responseDone) {
                            this.responseBodyOpen = false;
                        }
                        if (socketSinkDone) {
                            this.socketSinkOpen = false;
                        }
                        if (socketSourceDone) {
                            this.socketSourceOpen = false;
                        }
                        if (this.requestBodyOpen) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        allStreamsDone = z2;
                        if (allStreamsDone) {
                            z = true;
                        }
                        callDone = z;
                    } else if ((responseDone && this.responseBodyOpen) || ((socketSinkDone && this.socketSinkOpen) || (socketSourceDone && this.socketSourceOpen))) {
                        z = false;
                        if (requestDone) {
                            this.requestBodyOpen = false;
                        }
                        if (responseDone) {
                            this.responseBodyOpen = false;
                        }
                        if (socketSinkDone) {
                            this.socketSinkOpen = false;
                        }
                        if (socketSourceDone) {
                            this.socketSourceOpen = false;
                        }
                        if (this.requestBodyOpen || this.responseBodyOpen || this.socketSinkOpen || this.socketSourceOpen) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        allStreamsDone = z2;
                        if (allStreamsDone && !this.expectMoreExchanges) {
                            z = true;
                        }
                        callDone = z;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else if (responseDone) {
                z = false;
                if (requestDone) {
                    this.requestBodyOpen = false;
                }
                if (responseDone) {
                    this.responseBodyOpen = false;
                }
                if (socketSinkDone) {
                    this.socketSinkOpen = false;
                }
                if (socketSourceDone) {
                    this.socketSourceOpen = false;
                }
                if (this.requestBodyOpen) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                allStreamsDone = z2;
                if (allStreamsDone) {
                    z = true;
                }
                callDone = z;
            } else {
                z = false;
                if (requestDone) {
                    this.requestBodyOpen = false;
                }
                if (responseDone) {
                    this.responseBodyOpen = false;
                }
                if (socketSinkDone) {
                    this.socketSinkOpen = false;
                }
                if (socketSourceDone) {
                    this.socketSourceOpen = false;
                }
                if (this.requestBodyOpen) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                allStreamsDone = z2;
                if (allStreamsDone) {
                    z = true;
                }
                callDone = z;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (allStreamsDone) {
            this.exchange = null;
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                realConnection.incrementSuccessCount$okhttp();
            }
        }
        return callDone ? callDone(e) : e;
    }

    public final IOException noMoreExchanges$okhttp(IOException e) {
        boolean callDone = false;
        RealCall $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.expectMoreExchanges) {
                boolean z = false;
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen && !this.socketSinkOpen && !this.socketSourceOpen) {
                    z = true;
                }
                callDone = z;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (callDone) {
            return callDone(e);
        }
        return e;
    }

    private final IOException callDone(IOException e) {
        Socket toClose;
        RealCall $this$assertLockNotHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            RealConnection connection = this.connection;
            if (connection != null) {
                RealConnection $this$assertLockNotHeld$iv2 = connection;
                if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv2)) {
                    RealConnection $this$withLock$iv = connection;
                    synchronized ($this$withLock$iv) {
                        toClose = releaseConnectionNoEvents$okhttp();
                    }
                    if (this.connection == null) {
                        if (toClose != null) {
                            _UtilJvmKt.closeQuietly(toClose);
                        }
                        this.eventListener.connectionReleased(this, connection);
                        connection.getConnectionListener$okhttp().connectionReleased(connection, this);
                        if (toClose != null) {
                            connection.getConnectionListener$okhttp().connectionClosed(connection);
                        }
                    } else {
                        if (!(toClose == null)) {
                            throw new IllegalStateException("Check failed.");
                        }
                    }
                } else {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv2);
                }
            }
            IOException result = timeoutExit(e);
            if (e != null) {
                Intrinsics.checkNotNull(result);
                this.eventListener.callFailed(this, result);
            } else {
                this.eventListener.callEnd(this);
            }
            return result;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection connection = this.connection;
        Intrinsics.checkNotNull(connection);
        RealConnection $this$assertLockHeld$iv = connection;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            List<Reference<RealCall>> calls = connection.getCalls();
            int index$iv = 0;
            Iterator<Reference<RealCall>> it = calls.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object item$iv = it.next();
                    if (Intrinsics.areEqual(((Reference) item$iv).get(), this)) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
            if (!(index$iv != -1)) {
                throw new IllegalStateException("Check failed.");
            }
            calls.remove(index$iv);
            this.connection = null;
            if (calls.isEmpty()) {
                connection.setIdleAtNs(System.nanoTime());
                if (this.connectionPool.connectionBecameIdle(connection)) {
                    return connection.socket();
                }
            }
            return null;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    private final IOException timeoutExit(IOException cause) {
        if (this.timeoutEarlyExit || !exit()) {
            return cause;
        }
        InterruptedIOException e = new InterruptedIOException("timeout");
        if (cause != null) {
            e.initCause(cause);
        }
        return e;
    }

    public final void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.");
        }
        this.timeoutEarlyExit = true;
        exit();
    }

    public final void upgradeToSocket() {
        timeoutEarlyExit();
        RealCall $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (!(this.exchange != null)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!((this.socketSinkOpen || this.socketSourceOpen) ? false : true)) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (!this.responseBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            this.responseBodyOpen = false;
            this.socketSinkOpen = true;
            this.socketSourceOpen = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean closeExchange) {
        Exchange exchange;
        RealCall $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (closeExchange && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final boolean retryAfterFailure() {
        Exchange exchange = this.exchange;
        if (exchange != null && exchange.getHasFailure$okhttp()) {
            ExchangeFinder exchangeFinder = this.exchangeFinder;
            Intrinsics.checkNotNull(exchangeFinder);
            RoutePlanner routePlanner = exchangeFinder.getRoutePlanner();
            Exchange exchange2 = this.exchange;
            if (routePlanner.hasNext(exchange2 != null ? exchange2.getConnection$okhttp() : null)) {
                return true;
            }
        }
        return false;
    }

    public final String toLoggableString() {
        return (isCanceled() ? "canceled " : _UrlKt.FRAGMENT_ENCODE_SET) + (this.forWebSocket ? "web socket" : "call") + " to " + redactedUrl$okhttp();
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0000R\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0019\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b J\b\u0010!\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lni/shikatu/okhttp3/Callback;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "value", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "reuseCallsPerHostFrom", _UrlKt.FRAGMENT_ENCODE_SET, "other", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "host", _UrlKt.FRAGMENT_ENCODE_SET, "getHost", "()Ljava/lang/String;", "request", "Lni/shikatu/okhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "call", "getCall", "()Lokhttp3/internal/connection/RealCall;", "executeOn", "executorService", "Ljava/util/concurrent/ExecutorService;", "failRejected", "e", "Ljava/util/concurrent/RejectedExecutionException;", "failRejected$okhttp", "run", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final  RealCall this$0;

        public AsyncCall(RealCall this$0, Callback responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.this$0 = this$0;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final void reuseCallsPerHostFrom(AsyncCall other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final void executeOn(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            _UtilJvmKt.assertLockNotHeld(this.this$0.getClient().dispatcher());
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    failRejected$okhttp(e);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        public static  void failRejected$okhttp$default(AsyncCall asyncCall, RejectedExecutionException rejectedExecutionException, int i, Object obj) {
            if ((i & 1) != 0) {
                rejectedExecutionException = null;
            }
            asyncCall.failRejected$okhttp(rejectedExecutionException);
        }

        public final void failRejected$okhttp(RejectedExecutionException e) {
            InterruptedIOException ioException = new InterruptedIOException("executor rejected");
            ioException.initCause(e);
            this.this$0.noMoreExchanges$okhttp(ioException);
            this.responseCallback.onFailure(this.this$0, ioException);
        }

        @Override
        public void run() {
            Dispatcher dispatcher;
            String name$iv = "OkHttp " + this.this$0.redactedUrl$okhttp();
            RealCall realCall = this.this$0;
            Thread currentThread$iv = Thread.currentThread();
            String oldName$iv = currentThread$iv.getName();
            currentThread$iv.setName(name$iv);
            boolean signalledCallback = false;
            try {
                try {
                    realCall.timeout.enter();
                    try {
                        try {
                            Response response = realCall.getResponseWithInterceptorChain$okhttp();
                            signalledCallback = true;
                            this.responseCallback.onResponse(realCall, response);
                            dispatcher = realCall.getClient().dispatcher();
                        } catch (IOException e) {
                            if (signalledCallback) {
                                Platform.Companion.get().log("Callback failure for " + realCall.toLoggableString(), 4, e);
                            } else {
                                this.responseCallback.onFailure(realCall, e);
                            }
                            dispatcher = realCall.getClient().dispatcher();
                        }
                    } catch (Throwable t) {
                        realCall.cancel();
                        if (!signalledCallback) {
                            IOException canceledException = new IOException("canceled due to " + t);
                            canceledException.initCause(t);
                            this.responseCallback.onFailure(realCall, canceledException);
                        }
                        if (!(t instanceof InterruptedException)) {
                            throw t;
                        }
                        Thread.currentThread().interrupt();
                        dispatcher = realCall.getClient().dispatcher();
                    }
                    dispatcher.finished$okhttp(this);
                    currentThread$iv.setName(oldName$iv);
                } catch (Throwable t2) {
                    realCall.getClient().dispatcher().finished$okhttp(this);
                    throw t2;
                }
            } catch (Throwable th) {
                currentThread$iv.setName(oldName$iv);
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "referent", "callStackTrace", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        public CallReference(RealCall referent, Object callStackTrace) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = callStackTrace;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }
}
