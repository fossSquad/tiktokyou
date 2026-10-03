package ni.shikatu.okio.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.AsyncTimeout;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.Segment;
import ni.shikatu.okio.SegmentPool;
import ni.shikatu.okio.SegmentedByteString;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lni/shikatu/okio/internal/DefaultSocket;", "Lni/shikatu/okio/Socket;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "getSocket", "()Ljava/net/Socket;", "closeBits", "Ljava/util/concurrent/atomic/AtomicInteger;", "source", "Lni/shikatu/okio/Source;", "getSource", "()Lokio/Source;", "sink", "Lni/shikatu/okio/Sink;", "getSink", "()Lokio/Sink;", "cancel", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "SocketSink", "SocketSource", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultSocket implements Socket {
    private AtomicInteger closeBits;
    private final Sink sink;
    private final java.net.Socket socket;
    private final Source source;

    public DefaultSocket(java.net.Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.socket = socket;
        this.closeBits = new AtomicInteger();
        this.source = new SocketSource();
        this.sink = new SocketSink();
    }

    public final java.net.Socket getSocket() {
        return this.socket;
    }

    @Override
    public Source getSource() {
        return this.source;
    }

    @Override
    public Sink getSink() {
        return this.sink;
    }

    @Override
    public void cancel() throws IOException {
        this.socket.close();
    }

    public String toString() {
        String string = this.socket.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/okio/internal/DefaultSocket$SocketSink;", "Lni/shikatu/okio/Sink;", "<init>", "(Lokio/internal/DefaultSocket;)V", "outputStream", "Ljava/io/OutputStream;", "ni.shikatu.kotlin.jvm.PlatformType", "timeout", "Lni/shikatu/okio/internal/SocketAsyncTimeout;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "flush", "close", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class SocketSink implements Sink {
        private final OutputStream outputStream;
        private final SocketAsyncTimeout timeout;

        public SocketSink() {
            this.outputStream = DefaultSocket.this.getSocket().getOutputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override
        public void write(Buffer source, long remaining) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            SegmentedByteString.checkOffsetAndCount(source.size(), 0L, remaining);
            while (remaining > 0) {
                this.timeout.throwIfReached();
                Segment head = source.head;
                Intrinsics.checkNotNull(head);
                int b$iv = head.limit - head.pos;
                long a$iv = remaining;
                int toCopy = (int) Math.min(a$iv, b$iv);
                AsyncTimeout this_$iv = this.timeout;
                this_$iv.enter();
                try {
                    try {
                        this.outputStream.write(head.data, head.pos, toCopy);
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                            head.pos += toCopy;
                            remaining -= (long) toCopy;
                            source.setSize$okio(source.size() - ((long) toCopy));
                            if (head.pos == head.limit) {
                                source.head = head.pop();
                                SegmentPool.recycle(head);
                            }
                        } else {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }
        }

        @Override
        public void flush() throws IOException {
            AsyncTimeout this_$iv = this.timeout;
            this_$iv.enter();
            try {
                try {
                    this.outputStream.flush();
                    Unit unit = Unit.INSTANCE;
                    boolean timedOut$iv = this_$iv.exit();
                    if (!timedOut$iv) {
                    } else {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                } catch (IOException e$iv) {
                    if (!this_$iv.exit()) {
                        throw e$iv;
                    }
                    throw this_$iv.access$newTimeoutException(e$iv);
                }
            } catch (Throwable th) {
                boolean timedOut$iv2 = this_$iv.exit();
                if (timedOut$iv2 && 0 != 0) {
                    throw this_$iv.access$newTimeoutException(null);
                }
                throw th;
            }
        }

        @Override
        public void close() throws IOException {
            AsyncTimeout this_$iv = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            this_$iv.enter();
            try {
                try {
                    switch (_AtomicKt.setBitsOrZero(defaultSocket.closeBits, 1)) {
                        case 0:
                            this_$iv.exit();
                            return;
                        case 3:
                            defaultSocket.getSocket().close();
                            break;
                        default:
                            if (!defaultSocket.getSocket().isClosed() && !defaultSocket.getSocket().isOutputShutdown()) {
                                this.outputStream.flush();
                                try {
                                    defaultSocket.getSocket().shutdownOutput();
                                } catch (UnsupportedOperationException e) {
                                    this.outputStream.close();
                                }
                                break;
                            }
                            this_$iv.exit();
                            return;
                    }
                    Unit unit = Unit.INSTANCE;
                    boolean timedOut$iv = this_$iv.exit();
                    if (timedOut$iv) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                } catch (IOException e$iv) {
                    if (!this_$iv.exit()) {
                        throw e$iv;
                    }
                    throw this_$iv.access$newTimeoutException(e$iv);
                }
            } catch (Throwable th) {
                boolean timedOut$iv2 = this_$iv.exit();
                if (timedOut$iv2 && 0 != 0) {
                    throw this_$iv.access$newTimeoutException(null);
                }
                throw th;
            }
        }

        @Override
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        public String toString() {
            return "sink(" + DefaultSocket.this.getSocket() + ')';
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okio/internal/DefaultSocket$SocketSource;", "Lni/shikatu/okio/Source;", "<init>", "(Lokio/internal/DefaultSocket;)V", "inputStream", "Ljava/io/InputStream;", "ni.shikatu.kotlin.jvm.PlatformType", "timeout", "Lni/shikatu/okio/internal/SocketAsyncTimeout;", "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "close", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class SocketSource implements Source {
        private final InputStream inputStream;
        private final SocketAsyncTimeout timeout;

        public SocketSource() {
            this.inputStream = DefaultSocket.this.getSocket().getInputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount == 0) {
                return 0L;
            }
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            this.timeout.throwIfReached();
            Segment tail = sink.writableSegment$okio(1);
            int b$iv = 8192 - tail.limit;
            int b$iv2 = (int) Math.min(byteCount, b$iv);
            try {
                AsyncTimeout this_$iv = this.timeout;
                this_$iv.enter();
                try {
                    try {
                        int bytesRead = this.inputStream.read(tail.data, tail.limit, b$iv2);
                        boolean timedOut$iv = this_$iv.exit();
                        if (timedOut$iv) {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                        if (bytesRead != -1) {
                            tail.limit += bytesRead;
                            sink.setSize$okio(sink.size() + ((long) bytesRead));
                            return bytesRead;
                        }
                        if (tail.pos != tail.limit) {
                            return -1L;
                        }
                        sink.head = tail.pop();
                        SegmentPool.recycle(tail);
                        return -1L;
                    } catch (IOException e$iv) {
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                        throw e$iv;
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (!timedOut$iv2 || 0 == 0) {
                        throw th;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                }
            } catch (AssertionError e) {
                if (_JavaIoKt.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override
        public void close() throws IOException {
            AsyncTimeout this_$iv = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            this_$iv.enter();
            try {
                try {
                    switch (_AtomicKt.setBitsOrZero(defaultSocket.closeBits, 2)) {
                        case 0:
                            this_$iv.exit();
                            return;
                        case 3:
                            defaultSocket.getSocket().close();
                            break;
                        default:
                            if (defaultSocket.getSocket().isClosed() || defaultSocket.getSocket().isInputShutdown()) {
                                this_$iv.exit();
                                return;
                            } else {
                                try {
                                    defaultSocket.getSocket().shutdownInput();
                                } catch (UnsupportedOperationException e) {
                                    this.inputStream.close();
                                }
                            }
                            break;
                    }
                    Unit unit = Unit.INSTANCE;
                    boolean timedOut$iv = this_$iv.exit();
                    if (timedOut$iv) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                } catch (IOException e$iv) {
                    if (!this_$iv.exit()) {
                        throw e$iv;
                    }
                    throw this_$iv.access$newTimeoutException(e$iv);
                }
            } catch (Throwable th) {
                boolean timedOut$iv2 = this_$iv.exit();
                if (timedOut$iv2 && 0 != 0) {
                    throw this_$iv.access$newTimeoutException(null);
                }
                throw th;
            }
        }

        @Override
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        public String toString() {
            return "source(" + DefaultSocket.this.getSocket() + ')';
        }
    }
}
