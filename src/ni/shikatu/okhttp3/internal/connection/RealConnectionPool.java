package ni.shikatu.okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Address;
import ni.shikatu.okhttp3.ConnectionPool;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.concurrent.Task;
import ni.shikatu.okhttp3.internal.concurrent.TaskQueue;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0016\u0018\u0000 22\u00020\u0001:\u00012B1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J?\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\u0006\u0010'\u001a\u00020\u001fH\u0000¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001aJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010-\u001a\u00020*J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007J\u0018\u00100\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0006\u00101\u001a\u00020*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealConnectionPool;", _UrlKt.FRAGMENT_ENCODE_SET, "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", _UrlKt.FRAGMENT_ENCODE_SET, "keepAliveDuration", _UrlKt.FRAGMENT_ENCODE_SET, "timeUnit", "Ljava/util/concurrent/TimeUnit;", "connectionListener", "Lni/shikatu/okhttp3/internal/connection/ConnectionListener;", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;Lokhttp3/internal/connection/ConnectionListener;)V", "getConnectionListener$okhttp", "()Lokhttp3/internal/connection/ConnectionListener;", "keepAliveDurationNs", "getKeepAliveDurationNs$okhttp", "()J", "cleanupQueue", "Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "ni/shikatu/okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lni/shikatu/okhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "idleConnectionCount", "connectionCount", "callAcquirePooledConnection", "doExtensiveHealthChecks", _UrlKt.FRAGMENT_ENCODE_SET, "address", "Lni/shikatu/okhttp3/Address;", "call", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "routes", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Route;", "requireMultiplexed", "callAcquirePooledConnection$okhttp", "put", _UrlKt.FRAGMENT_ENCODE_SET, "connection", "connectionBecameIdle", "evictAll", "closeConnections", "now", "pruneAndGetAllocationCount", "scheduleCloser", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final Task cleanupTask;
    private final ConnectionListener connectionListener;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public RealConnectionPool(TaskRunner taskRunner, int maxIdleConnections, long keepAliveDuration, TimeUnit timeUnit, ConnectionListener connectionListener) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics.checkNotNullParameter(connectionListener, "connectionListener");
        this.maxIdleConnections = maxIdleConnections;
        this.connectionListener = connectionListener;
        this.keepAliveDurationNs = timeUnit.toNanos(keepAliveDuration);
        this.cleanupQueue = taskRunner.newQueue();
        final String str = _UtilJvmKt.okHttpName + " ConnectionPool connection closer";
        this.cleanupTask = new Task(str) {
            @Override
            public long runOnce() {
                return this.this$0.closeConnections(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (keepAliveDuration > 0) {
        } else {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + keepAliveDuration).toString());
        }
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public final long getKeepAliveDurationNs$okhttp() {
        return this.keepAliveDurationNs;
    }

    public final int idleConnectionCount() {
        boolean zIsEmpty;
        Iterable $this$count$iv = this.connections;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            return 0;
        }
        int count$iv = 0;
        for (Object element$iv : $this$count$iv) {
            RealConnection it = (RealConnection) element$iv;
            Intrinsics.checkNotNull(it);
            RealConnection $this$withLock$iv = it;
            synchronized ($this$withLock$iv) {
                zIsEmpty = it.getCalls().isEmpty();
            }
            if (zIsEmpty && (count$iv = count$iv + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return count$iv;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final RealConnection callAcquirePooledConnection$okhttp(boolean doExtensiveHealthChecks, Address address, RealCall call, List<Route> list, boolean requireMultiplexed) {
        boolean acquired;
        boolean noNewExchangesEvent;
        Socket toClose;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<RealConnection> it = this.connections.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RealConnection connection = it.next();
            Intrinsics.checkNotNull(connection);
            RealConnection $this$withLock$iv = connection;
            synchronized ($this$withLock$iv) {
                if (requireMultiplexed) {
                    if (!connection.isMultiplexed$okhttp()) {
                        acquired = false;
                    } else if (connection.isEligible$okhttp(address, list)) {
                        call.acquireConnectionNoEvents(connection);
                        acquired = true;
                    } else {
                        acquired = false;
                    }
                } else if (connection.isEligible$okhttp(address, list)) {
                    acquired = false;
                } else {
                    call.acquireConnectionNoEvents(connection);
                    acquired = true;
                }
            }
            if (acquired) {
                if (connection.isHealthy(doExtensiveHealthChecks)) {
                    return connection;
                }
                RealConnection $this$withLock$iv2 = connection;
                synchronized ($this$withLock$iv2) {
                    noNewExchangesEvent = connection.getNoNewExchanges() ? false : true;
                    connection.setNoNewExchanges(true);
                    toClose = call.releaseConnectionNoEvents$okhttp();
                }
                if (toClose != null) {
                    _UtilJvmKt.closeQuietly(toClose);
                    this.connectionListener.connectionClosed(connection);
                } else if (noNewExchangesEvent) {
                    this.connectionListener.noNewExchanges(connection);
                }
            }
        }
        return null;
    }

    public final void put(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        RealConnection $this$assertLockHeld$iv = connection;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            this.connections.add(connection);
            scheduleCloser();
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public final boolean connectionBecameIdle(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        RealConnection $this$assertLockHeld$iv = connection;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            if (connection.getNoNewExchanges() || this.maxIdleConnections == 0) {
                connection.setNoNewExchanges(true);
                this.connections.remove(connection);
                if (this.connections.isEmpty()) {
                    this.cleanupQueue.cancelAll();
                    return true;
                }
                return true;
            }
            scheduleCloser();
            return false;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public final void evictAll() {
        Socket socketToClose;
        Iterator<RealConnection> it = this.connections.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RealConnection connection = it.next();
            Intrinsics.checkNotNull(connection);
            RealConnection $this$withLock$iv = connection;
            synchronized ($this$withLock$iv) {
                if (connection.getCalls().isEmpty()) {
                    it.remove();
                    connection.setNoNewExchanges(true);
                    socketToClose = connection.socket();
                } else {
                    socketToClose = null;
                }
            }
            if (socketToClose != null) {
                _UtilJvmKt.closeQuietly(socketToClose);
                this.connectionListener.connectionClosed(connection);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final long closeConnections(long now) {
        long toEvictIdleAtNs;
        RealConnection toEvict;
        long earliestOldIdleAtNs = (now - this.keepAliveDurationNs) + 1;
        Iterator<RealConnection> it = this.connections.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int evictableConnectionCount = 0;
        int inUseConnectionCount = 0;
        RealConnection realConnection = null;
        long earliestOldIdleAtNs2 = earliestOldIdleAtNs;
        long earliestEvictableIdleAtNs = Long.MAX_VALUE;
        RealConnection realConnection2 = null;
        while (it.hasNext()) {
            RealConnection connection = it.next();
            Intrinsics.checkNotNull(connection);
            RealConnection $this$withLock$iv = connection;
            synchronized ($this$withLock$iv) {
                if (pruneAndGetAllocationCount(connection, now) > 0) {
                    inUseConnectionCount++;
                } else {
                    long idleAtNs = connection.getIdleAtNs();
                    if (idleAtNs < earliestOldIdleAtNs2) {
                        earliestOldIdleAtNs2 = idleAtNs;
                        realConnection2 = connection;
                    }
                    evictableConnectionCount++;
                    if (idleAtNs < earliestEvictableIdleAtNs) {
                        earliestEvictableIdleAtNs = idleAtNs;
                        realConnection = connection;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        if (realConnection2 != null) {
            RealConnection toEvict2 = realConnection2;
            toEvictIdleAtNs = earliestOldIdleAtNs2;
            toEvict = toEvict2;
        } else if (evictableConnectionCount > this.maxIdleConnections) {
            RealConnection toEvict3 = realConnection;
            toEvictIdleAtNs = earliestEvictableIdleAtNs;
            toEvict = toEvict3;
        } else {
            toEvictIdleAtNs = -1;
            toEvict = null;
        }
        if (toEvict == null) {
            if (realConnection != null) {
                return (this.keepAliveDurationNs + earliestEvictableIdleAtNs) - now;
            }
            if (inUseConnectionCount > 0) {
                return this.keepAliveDurationNs;
            }
            return -1L;
        }
        Lockable $this$withLock$iv2 = toEvict;
        synchronized ($this$withLock$iv2) {
            if (toEvict.getCalls().isEmpty() && toEvict.getIdleAtNs() == toEvictIdleAtNs) {
                toEvict.setNoNewExchanges(true);
                this.connections.remove(toEvict);
                _UtilJvmKt.closeQuietly(toEvict.socket());
                this.connectionListener.connectionClosed(toEvict);
                if (this.connections.isEmpty()) {
                    this.cleanupQueue.cancelAll();
                }
                return 0L;
            }
            return 0L;
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection connection, long now) {
        RealConnection $this$assertLockHeld$iv = connection;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            List<Reference<RealCall>> calls = connection.getCalls();
            int i = 0;
            while (i < calls.size()) {
                Reference<RealCall> reference = calls.get(i);
                if (reference.get() != null) {
                    i++;
                } else {
                    Intrinsics.checkNotNull(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                    RealCall.CallReference callReference = (RealCall.CallReference) reference;
                    String message = "A connection to " + connection.route().address().url() + " was leaked. Did you forget to close a response body?";
                    Platform.Companion.get().logCloseableLeak(message, callReference.getCallStackTrace());
                    calls.remove(i);
                    if (calls.isEmpty()) {
                        connection.setIdleAtNs(now - this.keepAliveDurationNs);
                        return 0;
                    }
                }
            }
            return calls.size();
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public final void scheduleCloser() {
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealConnectionPool$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "get", "Lni/shikatu/okhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lni/shikatu/okhttp3/ConnectionPool;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }
}
