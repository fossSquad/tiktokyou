package ni.shikatu.okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.connection.RealCall;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0019\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u001aR\u00020\u001bH\u0000¢\u0006\u0002\b!J\u0016\u0010\"\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020\u001fJ4\u0010&\u001a\u00020\u001f2\u000e\b\u0002\u0010'\u001a\b\u0018\u00010\u001aR\u00020\u001b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001b2\u000e\b\u0002\u0010)\u001a\b\u0018\u00010\u001aR\u00020\u001bH\u0002J\u0015\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020\u001bH\u0000¢\u0006\u0002\b,J\u0019\u0010-\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u001aR\u00020\u001bH\u0000¢\u0006\u0002\b.J\u0015\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0000¢\u0006\u0002\b.J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\f\u00102\u001a\b\u0012\u0004\u0012\u00020100J\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\bJ\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b5R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0017R\u0018\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lni/shikatu/okhttp3/Dispatcher;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Ljava/util/concurrent/ExecutorService;)V", "maxRequests", _UrlKt.FRAGMENT_ENCODE_SET, "getMaxRequests", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "idleCallback", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "executorServiceOrNull", "()Ljava/util/concurrent/ExecutorService;", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "Lni/shikatu/okhttp3/internal/connection/RealCall$AsyncCall;", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "runningAsyncCalls", "runningSyncCalls", "enqueue", _UrlKt.FRAGMENT_ENCODE_SET, "call", "enqueue$okhttp", "findExistingCallWithHost", "host", _UrlKt.FRAGMENT_ENCODE_SET, "cancelAll", "promoteAndExecute", "enqueuedCall", "finishedCall", "finishedAsyncCall", "executed", _UrlKt.FRAGMENT_ENCODE_SET, "executed$okhttp", "finished", "finished$okhttp", "queuedCalls", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Call;", "runningCalls", "queuedCallsCount", "runningCallsCount", "-deprecated_executorService", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final void setMaxRequests(int maxRequests) {
        if (!(maxRequests >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + maxRequests).toString());
        }
        synchronized (this) {
            this.maxRequests = maxRequests;
            Unit unit = Unit.INSTANCE;
        }
        promoteAndExecute$default(this, null, null, null, 7, null);
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final void setMaxRequestsPerHost(int maxRequestsPerHost) {
        if (!(maxRequestsPerHost >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + maxRequestsPerHost).toString());
        }
        synchronized (this) {
            this.maxRequestsPerHost = maxRequestsPerHost;
            Unit unit = Unit.INSTANCE;
        }
        promoteAndExecute$default(this, null, null, null, 7, null);
    }

    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        if (this.executorServiceOrNull == null) {
            this.executorServiceOrNull = new ThreadPoolExecutor(0, IntCompanionObject.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), _UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " Dispatcher", false));
        }
        executorService = this.executorServiceOrNull;
        Intrinsics.checkNotNull(executorService);
        return executorService;
    }

    public Dispatcher(ExecutorService executorService) {
        this();
        this.executorServiceOrNull = executorService;
    }

    public final void enqueue$okhttp(RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        promoteAndExecute$default(this, call, null, null, 6, null);
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String host) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RealCall.AsyncCall existingCall = it.next();
            if (Intrinsics.areEqual(existingCall.getHost(), host)) {
                return existingCall;
            }
        }
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            RealCall.AsyncCall existingCall2 = it2.next();
            if (Intrinsics.areEqual(existingCall2.getHost(), host)) {
                return existingCall2;
            }
        }
        return null;
    }

    public final synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RealCall.AsyncCall call = it.next();
            call.getCall().cancel();
        }
        Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            RealCall.AsyncCall call2 = it2.next();
            call2.getCall().cancel();
        }
        Iterator<RealCall> it3 = this.runningSyncCalls.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            RealCall call3 = it3.next();
            call3.cancel();
        }
    }

    static  void promoteAndExecute$default(Dispatcher dispatcher, RealCall.AsyncCall asyncCall, RealCall realCall, RealCall.AsyncCall asyncCall2, int i, Object obj) {
        if ((i & 1) != 0) {
            asyncCall = null;
        }
        if ((i & 2) != 0) {
            realCall = null;
        }
        if ((i & 4) != 0) {
            asyncCall2 = null;
        }
        dispatcher.promoteAndExecute(asyncCall, realCall, asyncCall2);
    }

    private final void promoteAndExecute(RealCall.AsyncCall enqueuedCall, RealCall finishedCall, RealCall.AsyncCall finishedAsyncCall) {
        Effects effects;
        RealCall.AsyncCall existingCall;
        _UtilJvmKt.assertLockNotHeld(this);
        boolean executorIsShutdown = executorService().isShutdown();
        synchronized (this) {
            if (finishedCall != null) {
                try {
                    if (!this.runningSyncCalls.remove(finishedCall)) {
                        throw new IllegalStateException("Call wasn't in-flight!".toString());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (finishedAsyncCall != null) {
                finishedAsyncCall.getCallsPerHost().decrementAndGet();
                if (!this.runningAsyncCalls.remove(finishedAsyncCall)) {
                    throw new IllegalStateException("Call wasn't in-flight!".toString());
                }
            }
            if (enqueuedCall != null) {
                this.readyAsyncCalls.add(enqueuedCall);
                if (!enqueuedCall.getCall().getForWebSocket() && (existingCall = findExistingCallWithHost(enqueuedCall.getHost())) != null) {
                    enqueuedCall.reuseCallsPerHostFrom(existingCall);
                }
            }
            boolean becameIdle = !(finishedCall == null && finishedAsyncCall == null) && (executorIsShutdown || this.runningAsyncCalls.isEmpty()) && this.runningSyncCalls.isEmpty();
            Runnable idleCallbackToRun = becameIdle ? this.idleCallback : null;
            if (executorIsShutdown) {
                List list = CollectionsKt.toList(this.readyAsyncCalls);
                this.readyAsyncCalls.clear();
                effects = new Effects(list, idleCallbackToRun);
            } else {
                List callsToExecute = new ArrayList();
                Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    }
                    if (asyncCall.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        asyncCall.getCallsPerHost().incrementAndGet();
                        Intrinsics.checkNotNull(asyncCall);
                        callsToExecute.add(asyncCall);
                        this.runningAsyncCalls.add(asyncCall);
                    }
                }
                effects = new Effects(callsToExecute, idleCallbackToRun);
            }
        }
        boolean callDispatcherQueueStart = true;
        int size = effects.getCallsToExecute().size();
        for (int i = 0; i < size; i++) {
            RealCall.AsyncCall call = effects.getCallsToExecute().get(i);
            if (call == enqueuedCall) {
                callDispatcherQueueStart = false;
            } else {
                call.getCall().getEventListener$okhttp().dispatcherQueueEnd(call.getCall(), this);
            }
            if (executorIsShutdown) {
                RealCall.AsyncCall.failRejected$okhttp$default(call, null, 1, null);
            } else {
                call.executeOn(executorService());
            }
        }
        if (callDispatcherQueueStart && enqueuedCall != null) {
            enqueuedCall.getCall().getEventListener$okhttp().dispatcherQueueStart(enqueuedCall.getCall(), this);
        }
        Runnable idleCallbackToRun2 = effects.getIdleCallbackToRun();
        if (idleCallbackToRun2 != null) {
            idleCallbackToRun2.run();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"ni/shikatu/okhttp3/Dispatcher$promoteAndExecute$Effects", _UrlKt.FRAGMENT_ENCODE_SET, "callsToExecute", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/connection/RealCall$AsyncCall;", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "idleCallbackToRun", "Ljava/lang/Runnable;", "<init>", "(Ljava/util/List;Ljava/lang/Runnable;)V", "getCallsToExecute", "()Ljava/util/List;", "getIdleCallbackToRun", "()Ljava/lang/Runnable;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Effects {
        private final List<RealCall.AsyncCall> callsToExecute;
        private final Runnable idleCallbackToRun;

        public Effects(List<RealCall.AsyncCall> list, Runnable idleCallbackToRun) {
            Intrinsics.checkNotNullParameter(list, "callsToExecute");
            this.callsToExecute = list;
            this.idleCallbackToRun = idleCallbackToRun;
        }

        public final List<RealCall.AsyncCall> getCallsToExecute() {
            return this.callsToExecute;
        }

        public final Runnable getIdleCallbackToRun() {
            return this.idleCallbackToRun;
        }
    }

    public final synchronized boolean executed$okhttp(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return this.runningSyncCalls.add(call);
    }

    public final void finished$okhttp(RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        promoteAndExecute$default(this, null, null, call, 3, null);
    }

    public final void finished$okhttp(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        promoteAndExecute$default(this, null, call, null, 5, null);
    }

    public final synchronized List<Call> queuedCalls() {
        List<Call> listUnmodifiableList;
        Iterable $this$map$iv = this.readyAsyncCalls;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            RealCall.AsyncCall it = (RealCall.AsyncCall) item$iv$iv;
            destination$iv$iv.add(it.getCall());
        }
        List $this$unmodifiable$iv = (List) destination$iv$iv;
        listUnmodifiableList = Collections.unmodifiableList($this$unmodifiable$iv);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public final synchronized List<Call> runningCalls() {
        List<Call> listUnmodifiableList;
        ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
        Iterable $this$map$iv = this.runningAsyncCalls;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            RealCall.AsyncCall it = (RealCall.AsyncCall) item$iv$iv;
            destination$iv$iv.add(it.getCall());
        }
        List $this$unmodifiable$iv = CollectionsKt.plus((Collection) arrayDeque, destination$iv$iv);
        listUnmodifiableList = Collections.unmodifiableList($this$unmodifiable$iv);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "executorService", imports = {}))

    public final ExecutorService m1632deprecated_executorService() {
        return executorService();
    }
}
