package ni.shikatu.okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002/0B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u001e\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0014J&\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u00020!2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020!J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020$2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0006\u0010%\u001a\u00020$J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020$J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010&\u001a\u00020\u001dJ(\u0010'\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH$J(\u0010(\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH$J\b\u0010)\u001a\u00020\u001dH$J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0014H$J\b\u0010+\u001a\u00020\u0014H$J\b\u0010,\u001a\u00020\u001dH$J \u0010-\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J \u0010.\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\u00060\rj\u0002`\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u00061"}, d2 = {"Lni/shikatu/okio/FileHandle;", "Ljava/io/Closeable;", "Lni/shikatu/okio/Closeable;", "readWrite", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Z)V", "getReadWrite", "()Z", "closed", "openStreamCount", _UrlKt.FRAGMENT_ENCODE_SET, "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lni/shikatu/okio/Lock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "read", "fileOffset", _UrlKt.FRAGMENT_ENCODE_SET, "array", _UrlKt.FRAGMENT_ENCODE_SET, "arrayOffset", "byteCount", "sink", "Lni/shikatu/okio/Buffer;", "size", "resize", _UrlKt.FRAGMENT_ENCODE_SET, "write", "source", "flush", "Lni/shikatu/okio/Source;", "position", "reposition", "Lni/shikatu/okio/Sink;", "appendingSink", "close", "protectedRead", "protectedWrite", "protectedFlush", "protectedResize", "protectedSize", "protectedClose", "readNoCloseCheck", "writeNoCloseCheck", "FileHandleSink", "FileHandleSource", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private final ReentrantLock lock = _JvmPlatformKt.newLock();
    private int openStreamCount;
    private final boolean readWrite;

    protected abstract void protectedClose() throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract int protectedRead(long j, byte[] bArr, int i, int i2) throws IOException;

    protected abstract void protectedResize(long j) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedWrite(long j, byte[] bArr, int i, int i2) throws IOException;

    public FileHandle(boolean readWrite) {
        this.readWrite = readWrite;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final int read(long fileOffset, byte[] array, int arrayOffset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(array, "array");
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return protectedRead(fileOffset, array, arrayOffset, byteCount);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long read(long fileOffset, Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return readNoCloseCheck(fileOffset, sink, byteCount);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() throws IOException {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return protectedSize();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void resize(long size) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            protectedResize(size);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void write(long fileOffset, byte[] array, int arrayOffset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(array, "array");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            protectedWrite(fileOffset, array, arrayOffset, byteCount);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void write(long fileOffset, Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            writeNoCloseCheck(fileOffset, source, byteCount);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void flush() throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            protectedFlush();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static  Source source$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        return fileHandle.source(j);
    }

    public final Source source(long fileOffset) throws IOException {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSource(this, fileOffset);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long position(Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Source source2 = source;
        long bufferSize = 0;
        if (source2 instanceof RealBufferedSource) {
            RealBufferedSource this_$iv = (RealBufferedSource) source2;
            bufferSize = this_$iv.bufferField.size();
            source2 = ((RealBufferedSource) source2).source;
        }
        if (!((source2 instanceof FileHandleSource) && ((FileHandleSource) source2).getFileHandle() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        if (((FileHandleSource) source2).getClosed()) {
            throw new IllegalStateException("closed".toString());
        }
        return ((FileHandleSource) source2).getPosition() - bufferSize;
    }

    public final void reposition(Source source, long position) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof RealBufferedSource) {
            Source fileHandleSource = ((RealBufferedSource) source).source;
            if (!((fileHandleSource instanceof FileHandleSource) && ((FileHandleSource) fileHandleSource).getFileHandle() == this)) {
                throw new IllegalArgumentException("source was not created by this FileHandle".toString());
            }
            if (((FileHandleSource) fileHandleSource).getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            RealBufferedSource this_$iv = (RealBufferedSource) source;
            long bufferSize = this_$iv.bufferField.size();
            long toSkip = position - (((FileHandleSource) fileHandleSource).getPosition() - bufferSize);
            if (0 <= toSkip && toSkip < bufferSize) {
                ((RealBufferedSource) source).skip(toSkip);
                return;
            }
            RealBufferedSource this_$iv2 = (RealBufferedSource) source;
            this_$iv2.bufferField.clear();
            ((FileHandleSource) fileHandleSource).setPosition(position);
            return;
        }
        if (!((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        if (((FileHandleSource) source).getClosed()) {
            throw new IllegalStateException("closed".toString());
        }
        ((FileHandleSource) source).setPosition(position);
    }

    public static  Sink sink$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        return fileHandle.sink(j);
    }

    public final Sink sink(long fileOffset) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSink(this, fileOffset);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    public final long position(Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Sink sink2 = sink;
        long bufferSize = 0;
        if (sink2 instanceof RealBufferedSink) {
            RealBufferedSink this_$iv = (RealBufferedSink) sink2;
            bufferSize = this_$iv.bufferField.size();
            sink2 = ((RealBufferedSink) sink2).sink;
        }
        if (!((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this)) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if (((FileHandleSink) sink2).getClosed()) {
            throw new IllegalStateException("closed".toString());
        }
        return ((FileHandleSink) sink2).getPosition() + bufferSize;
    }

    public final void reposition(Sink sink, long position) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            Sink fileHandleSink = ((RealBufferedSink) sink).sink;
            if (!((fileHandleSink instanceof FileHandleSink) && ((FileHandleSink) fileHandleSink).getFileHandle() == this)) {
                throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
            }
            if (((FileHandleSink) fileHandleSink).getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            ((RealBufferedSink) sink).emit();
            ((FileHandleSink) fileHandleSink).setPosition(position);
            return;
        }
        if (!((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this)) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if (((FileHandleSink) sink).getClosed()) {
            throw new IllegalStateException("closed".toString());
        }
        ((FileHandleSink) sink).setPosition(position);
    }

    @Override
    public final void close() throws IOException {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                this.closed = true;
                if (this.openStreamCount == 0) {
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    protectedClose();
                    return;
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long readNoCloseCheck(long fileOffset, Buffer sink, long byteCount) throws IOException {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        long targetOffset = fileOffset + byteCount;
        long currentOffset = fileOffset;
        while (currentOffset < targetOffset) {
            Segment tail = sink.writableSegment$okio(1);
            byte[] bArr = tail.data;
            int i = tail.limit;
            long a$iv = targetOffset - currentOffset;
            int b$iv = 8192 - tail.limit;
            long targetOffset2 = targetOffset;
            long targetOffset3 = b$iv;
            int $i$f$minOf = (int) Math.min(a$iv, targetOffset3);
            int readByteCount = protectedRead(currentOffset, bArr, i, $i$f$minOf);
            if (readByteCount == -1) {
                if (tail.pos == tail.limit) {
                    sink.head = tail.pop();
                    SegmentPool.recycle(tail);
                }
                if (fileOffset != currentOffset) {
                    break;
                }
                return -1L;
            }
            tail.limit += readByteCount;
            currentOffset += (long) readByteCount;
            sink.setSize$okio(sink.size() + ((long) readByteCount));
            targetOffset = targetOffset2;
        }
        return currentOffset - fileOffset;
    }

    public final void writeNoCloseCheck(long fileOffset, Buffer source, long byteCount) throws IOException {
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, byteCount);
        long targetOffset = fileOffset + byteCount;
        long currentOffset = fileOffset;
        while (currentOffset < targetOffset) {
            Segment head = source.head;
            Intrinsics.checkNotNull(head);
            long a$iv = targetOffset - currentOffset;
            int b$iv = head.limit - head.pos;
            int toCopy = (int) Math.min(a$iv, b$iv);
            protectedWrite(currentOffset, head.data, head.pos, toCopy);
            head.pos += toCopy;
            currentOffset += (long) toCopy;
            source.setSize$okio(source.size() - ((long) toCopy));
            if (head.pos == head.limit) {
                source.head = head.pop();
                SegmentPool.recycle(head);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lni/shikatu/okio/FileHandle$FileHandleSink;", "Lni/shikatu/okio/Sink;", "fileHandle", "Lni/shikatu/okio/FileHandle;", "position", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokio/FileHandle;J)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "getClosed", "()Z", "setClosed", "(Z)V", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", "flush", "timeout", "Lni/shikatu/okio/Timeout;", "close", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle, long position) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = position;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override
        public void write(Buffer source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.writeNoCloseCheck(this.position, source, byteCount);
            this.position += byteCount;
        }

        @Override
        public void flush() throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.protectedFlush();
        }

        @Override
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock $this$withLock$iv = this.fileHandle.getLock();
            ReentrantLock reentrantLock = $this$withLock$iv;
            reentrantLock.lock();
            try {
                this.fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    this.fileHandle.protectedClose();
                    return;
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lni/shikatu/okio/FileHandle$FileHandleSource;", "Lni/shikatu/okio/Source;", "fileHandle", "Lni/shikatu/okio/FileHandle;", "position", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokio/FileHandle;J)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "getClosed", "()Z", "setClosed", "(Z)V", "read", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "timeout", "Lni/shikatu/okio/Timeout;", "close", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle fileHandle, long position) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = position;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            long result = this.fileHandle.readNoCloseCheck(this.position, sink, byteCount);
            if (result != -1) {
                this.position += result;
            }
            return result;
        }

        @Override
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock $this$withLock$iv = this.fileHandle.getLock();
            ReentrantLock reentrantLock = $this$withLock$iv;
            reentrantLock.lock();
            try {
                this.fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    this.fileHandle.protectedClose();
                    return;
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }
}
