package ni.shikatu.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSink;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0006\u0010\u001d\u001a\u00020\u0013J\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\fJ(\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\fJ(\u0010&\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0016J\u001e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fJ\u001e\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u000201J\u0016\u00102\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00103\u001a\u000204J&\u00105\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fJ\b\u00108\u001a\u00020\u0013H\u0016J\u0018\u00109\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010%\u001a\u000204H\u0002J$\u0010:\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006="}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "sink", "Lni/shikatu/okio/BufferedSink;", "client", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokio/BufferedSink;Z)V", "hpackBuffer", "Lni/shikatu/okio/Buffer;", "maxFrameSize", _UrlKt.FRAGMENT_ENCODE_SET, "closed", "hpackWriter", "Lni/shikatu/okhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "connectionPreface", _UrlKt.FRAGMENT_ENCODE_SET, "applyAndAckSettings", "peerSettings", "Lni/shikatu/okhttp3/internal/http2/Settings;", "pushPromise", "streamId", "promisedStreamId", "requestHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "flush", "rstStream", "errorCode", "Lni/shikatu/okhttp3/internal/http2/ErrorCode;", "maxDataLength", "data", "outFinished", "source", "byteCount", "dataFrame", "flags", "buffer", "settings", "ping", "ack", "payload1", "payload2", "goAway", "lastGoodStreamId", "debugData", _UrlKt.FRAGMENT_ENCODE_SET, "windowUpdate", "windowSizeIncrement", _UrlKt.FRAGMENT_ENCODE_SET, "frameHeader", "length", "type", "close", "writeContinuationFrames", "headers", "headerBlock", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Http2Writer implements Closeable, Lockable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public Http2Writer(BufferedSink sink, boolean client) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.client = client;
        this.hpackBuffer = new Buffer();
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, this.hpackBuffer, 3, null);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final void connectionPreface() throws IOException {
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void applyAndAckSettings(Settings peerSettings) throws IOException {
        Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void pushPromise(int streamId, int promisedStreamId, List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(list);
            long byteCount = this.hpackBuffer.size();
            int length = (int) Math.min(((long) this.maxFrameSize) - 4, byteCount);
            frameHeader(streamId, length + 4, 5, byteCount == ((long) length) ? 4 : 0);
            this.sink.writeInt(Integer.MAX_VALUE & promisedStreamId);
            this.sink.write(this.hpackBuffer, length);
            if (byteCount > length) {
                writeContinuationFrames(streamId, byteCount - ((long) length));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void flush() throws IOException {
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void rstStream(int streamId, ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (!(errorCode.getHttpCode() != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            frameHeader(streamId, 4, 3, 0);
            this.sink.writeInt(errorCode.getHttpCode());
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void data(boolean outFinished, int streamId, Buffer source, int byteCount) throws IOException {
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            int flags = outFinished ? 0 | 1 : 0;
            dataFrame(streamId, flags, source, byteCount);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void dataFrame(int streamId, int flags, Buffer buffer, int byteCount) throws IOException {
        frameHeader(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(buffer);
            bufferedSink.write(buffer, byteCount);
        }
    }

    public final void settings(Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, settings.size() * 6, 4, 0);
            for (int i = 0; i < 10; i++) {
                if (settings.isSet(i)) {
                    this.sink.writeShort(i);
                    this.sink.writeInt(settings.get(i));
                }
            }
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void ping(boolean ack, int payload1, int payload2) throws IOException {
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, 8, 6, ack ? 1 : 0);
            this.sink.writeInt(payload1);
            this.sink.writeInt(payload2);
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void goAway(int lastGoodStreamId, ErrorCode errorCode, byte[] debugData) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            boolean z = true;
            if (!(errorCode.getHttpCode() != -1)) {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
            frameHeader(0, debugData.length + 8, 7, 0);
            this.sink.writeInt(lastGoodStreamId);
            this.sink.writeInt(errorCode.getHttpCode());
            if (debugData.length != 0) {
                z = false;
            }
            if (!z) {
                this.sink.write(debugData);
            }
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void windowUpdate(int streamId, long windowSizeIncrement) throws IOException {
        Throwable th;
        int streamId2;
        long windowSizeIncrement2;
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            try {
                try {
                    if (this.closed) {
                        throw new IOException("closed");
                    }
                    if (!(windowSizeIncrement != 0 && windowSizeIncrement <= 2147483647L)) {
                        throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + windowSizeIncrement).toString());
                    }
                    if (!logger.isLoggable(Level.FINE)) {
                        streamId2 = streamId;
                        windowSizeIncrement2 = windowSizeIncrement;
                    } else {
                        streamId2 = streamId;
                        windowSizeIncrement2 = windowSizeIncrement;
                        logger.fine(Http2.INSTANCE.frameLogWindowUpdate(false, streamId2, 4, windowSizeIncrement2));
                    }
                    frameHeader(streamId2, 4, 8, 0);
                    this.sink.writeInt((int) windowSizeIncrement2);
                    this.sink.flush();
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw th;
        }
    }

    public final void frameHeader(int streamId, int length, int type, int flags) throws IOException {
        int streamId2;
        int length2;
        int type2;
        int flags2;
        if (type == 8 || !logger.isLoggable(Level.FINE)) {
            streamId2 = streamId;
            length2 = length;
            type2 = type;
            flags2 = flags;
        } else {
            streamId2 = streamId;
            length2 = length;
            type2 = type;
            flags2 = flags;
            logger.fine(Http2.INSTANCE.frameLog(false, streamId2, length2, type2, flags2));
        }
        if (!(length2 <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + length2).toString());
        }
        if (!((Integer.MIN_VALUE & streamId2) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + streamId2).toString());
        }
        _UtilCommonKt.writeMedium(this.sink, length2);
        this.sink.writeByte(type2 & KotlinVersion.MAX_COMPONENT_VALUE);
        this.sink.writeByte(flags2 & KotlinVersion.MAX_COMPONENT_VALUE);
        this.sink.writeInt(Integer.MAX_VALUE & streamId2);
    }

    @Override
    public void close() throws IOException {
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            this.closed = true;
            this.sink.close();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void writeContinuationFrames(int streamId, long byteCount) throws IOException {
        long byteCount2 = byteCount;
        while (byteCount2 > 0) {
            long length = Math.min(this.maxFrameSize, byteCount2);
            byteCount2 -= length;
            frameHeader(streamId, (int) length, 9, byteCount2 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, length);
        }
    }

    public final void headers(boolean outFinished, int streamId, List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "headerBlock");
        Http2Writer $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(list);
            long byteCount = this.hpackBuffer.size();
            long length = Math.min(this.maxFrameSize, byteCount);
            int flags = byteCount == length ? 4 : 0;
            if (outFinished) {
                flags |= 1;
            }
            frameHeader(streamId, (int) length, 1, flags);
            this.sink.write(this.hpackBuffer, length);
            if (byteCount > length) {
                writeContinuationFrames(streamId, byteCount - length);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Writer$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "logger", "Ljava/util/logging/Logger;", "ni.shikatu.kotlin.jvm.PlatformType", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
