package ni.shikatu.okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u001fJ\b\u0010*\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "isClient", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/BufferedSink;", "random", "Ljava/util/Random;", "perMessageDeflate", "noContextTakeover", "minimumDeflateSize", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "getSink", "()Lokio/BufferedSink;", "getRandom", "()Ljava/util/Random;", "messageBuffer", "Lni/shikatu/okio/Buffer;", "sinkBuffer", "writerClosed", "messageDeflater", "Lni/shikatu/okhttp3/internal/ws/MessageDeflater;", "maskKey", _UrlKt.FRAGMENT_ENCODE_SET, "maskCursor", "Lni/shikatu/okio/Buffer$UnsafeCursor;", "writePing", _UrlKt.FRAGMENT_ENCODE_SET, "payload", "Lni/shikatu/okio/ByteString;", "writePong", "writeClose", "code", _UrlKt.FRAGMENT_ENCODE_SET, "reason", "writeControlFrame", "opcode", "writeMessageFrame", "formatOpcode", "data", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean isClient, BufferedSink sink, Random random, boolean perMessageDeflate, boolean noContextTakeover, long minimumDeflateSize) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.isClient = isClient;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = perMessageDeflate;
        this.noContextTakeover = noContextTakeover;
        this.minimumDeflateSize = minimumDeflateSize;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = this.sink.getBuffer();
        this.maskKey = this.isClient ? new byte[4] : null;
        this.maskCursor = this.isClient ? new Buffer.UnsafeCursor() : null;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final Random getRandom() {
        return this.random;
    }

    public final void writePing(ByteString payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(ByteString payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        writeControlFrame(10, payload);
    }

    public final void writeClose(int code, ByteString reason) throws IOException {
        ByteString payload = ByteString.EMPTY;
        if (code != 0 || reason != null) {
            if (code != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(code);
            }
            Buffer $this$writeClose_u24lambda_u240 = new Buffer();
            $this$writeClose_u24lambda_u240.writeShort(code);
            if (reason != null) {
                $this$writeClose_u24lambda_u240.write(reason);
            }
            payload = $this$writeClose_u24lambda_u240.readByteString();
        }
        try {
            writeControlFrame(8, payload);
        } finally {
            this.writerClosed = true;
        }
    }

    private final void writeControlFrame(int opcode, ByteString payload) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int length = payload.size();
        if (!(((long) length) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        int b0 = opcode | 128;
        this.sinkBuffer.writeByte(b0);
        if (!this.isClient) {
            this.sinkBuffer.writeByte(length);
            this.sinkBuffer.write(payload);
        } else {
            int b1 = length | 128;
            this.sinkBuffer.writeByte(b1);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (length > 0) {
                long payloadStart = this.sinkBuffer.size();
                this.sinkBuffer.write(payload);
                Buffer buffer = this.sinkBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(payloadStart);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sink.flush();
    }

    public final void writeMessageFrame(int formatOpcode, ByteString data) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.write(data);
        int b0 = formatOpcode | 128;
        if (this.perMessageDeflate && data.size() >= this.minimumDeflateSize) {
            MessageDeflater it = this.messageDeflater;
            if (it == null) {
                it = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = it;
            }
            it.deflate(this.messageBuffer);
            b0 |= 64;
        }
        long dataSize = this.messageBuffer.size();
        this.sinkBuffer.writeByte(b0);
        int b1 = 0;
        if (this.isClient) {
            b1 = 0 | 128;
        }
        if (dataSize <= 125) {
            this.sinkBuffer.writeByte(b1 | ((int) dataSize));
        } else if (dataSize <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.writeByte(b1 | WebSocketProtocol.PAYLOAD_SHORT);
            this.sinkBuffer.writeShort((int) dataSize);
        } else {
            this.sinkBuffer.writeByte(b1 | 127);
            this.sinkBuffer.writeLong(dataSize);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (dataSize > 0) {
                Buffer buffer = this.messageBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, dataSize);
        this.sink.flush();
    }

    @Override
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            _UtilCommonKt.closeQuietly(messageDeflater);
        }
        _UtilCommonKt.closeQuietly(this.sink);
    }
}
