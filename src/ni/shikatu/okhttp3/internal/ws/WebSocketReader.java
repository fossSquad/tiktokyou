package ni.shikatu.okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.http2.Settings;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001'B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lni/shikatu/okhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "isClient", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/BufferedSource;", "frameCallback", "Lni/shikatu/okhttp3/internal/ws/WebSocketReader$FrameCallback;", "perMessageDeflate", "noContextTakeover", "<init>", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "getSource", "()Lokio/BufferedSource;", "closed", "opcode", _UrlKt.FRAGMENT_ENCODE_SET, "frameLength", _UrlKt.FRAGMENT_ENCODE_SET, "isFinalFrame", "isControlFrame", "readingCompressedMessage", "controlFrameBuffer", "Lni/shikatu/okio/Buffer;", "messageFrameBuffer", "messageInflater", "Lni/shikatu/okhttp3/internal/ws/MessageInflater;", "maskKey", _UrlKt.FRAGMENT_ENCODE_SET, "maskCursor", "Lni/shikatu/okio/Buffer$UnsafeCursor;", "processNextFrame", _UrlKt.FRAGMENT_ENCODE_SET, "readHeader", "readControlFrame", "readMessageFrame", "readUntilNonControlFrame", "readMessage", "close", "FrameCallback", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final Buffer controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final BufferedSource source;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/WebSocketReader$FrameCallback;", _UrlKt.FRAGMENT_ENCODE_SET, "onReadMessage", _UrlKt.FRAGMENT_ENCODE_SET, "text", _UrlKt.FRAGMENT_ENCODE_SET, "bytes", "Lni/shikatu/okio/ByteString;", "onReadPing", "payload", "onReadPong", "onReadClose", "code", _UrlKt.FRAGMENT_ENCODE_SET, "reason", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean isClient, BufferedSource source, FrameCallback frameCallback, boolean perMessageDeflate, boolean noContextTakeover) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(frameCallback, "frameCallback");
        this.isClient = isClient;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = perMessageDeflate;
        this.noContextTakeover = noContextTakeover;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        this.maskKey = this.isClient ? null : new byte[4];
        this.maskCursor = this.isClient ? null : new Buffer.UnsafeCursor();
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    private final void readHeader() throws IOException {
        boolean z;
        String str;
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutBefore = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int b0 = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
            this.source.timeout().timeout(timeoutBefore, TimeUnit.NANOSECONDS);
            this.opcode = b0 & 15;
            this.isFinalFrame = (b0 & 128) != 0;
            this.isControlFrame = (b0 & 8) != 0;
            if (this.isControlFrame && !this.isFinalFrame) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean reservedFlag1 = (b0 & 64) != 0;
            switch (this.opcode) {
                case 1:
                case 2:
                    if (reservedFlag1) {
                        if (!this.perMessageDeflate) {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    this.readingCompressedMessage = z;
                    break;
                default:
                    if (reservedFlag1) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    break;
            }
            boolean reservedFlag2 = (b0 & 32) != 0;
            if (reservedFlag2) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            boolean reservedFlag3 = (b0 & 16) != 0;
            if (reservedFlag3) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int b1 = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
            boolean isMasked = (b1 & 128) != 0;
            if (isMasked == this.isClient) {
                if (this.isClient) {
                    str = "Server-sent frames must not be masked.";
                } else {
                    str = "Client-sent frames must be masked.";
                }
                throw new ProtocolException(str);
            }
            this.frameLength = b1 & 127;
            if (this.frameLength == 126) {
                this.frameLength = _UtilCommonKt.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            } else if (this.frameLength == 127) {
                this.frameLength = this.source.readLong();
                if (this.frameLength < 0) {
                    throw new ProtocolException("Frame length 0x" + _UtilJvmKt.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (isMasked) {
                BufferedSource bufferedSource = this.source;
                byte[] bArr = this.maskKey;
                Intrinsics.checkNotNull(bArr);
                bufferedSource.readFully(bArr);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(timeoutBefore, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void readControlFrame() throws IOException {
        if (this.frameLength > 0) {
            this.source.readFully(this.controlFrameBuffer, this.frameLength);
            if (!this.isClient) {
                Buffer buffer = this.controlFrameBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                Intrinsics.checkNotNull(bArr);
                webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                int code = WebSocketProtocol.CLOSE_NO_STATUS_CODE;
                String reason = _UrlKt.FRAGMENT_ENCODE_SET;
                long bufferSize = this.controlFrameBuffer.size();
                if (bufferSize == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (bufferSize != 0) {
                    code = this.controlFrameBuffer.readShort();
                    reason = this.controlFrameBuffer.readUtf8();
                    String codeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(code);
                    if (codeExceptionMessage != null) {
                        throw new ProtocolException(codeExceptionMessage);
                    }
                }
                this.frameCallback.onReadClose(code, reason);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + _UtilJvmKt.toHexString(this.opcode));
        }
    }

    private final void readMessageFrame() throws IOException {
        int opcode = this.opcode;
        if (opcode != 1 && opcode != 2) {
            throw new ProtocolException("Unknown opcode: " + _UtilJvmKt.toHexString(opcode));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater it = this.messageInflater;
            if (it == null) {
                it = new MessageInflater(this.noContextTakeover);
                this.messageInflater = it;
            }
            it.inflate(this.messageFrameBuffer);
        }
        if (opcode == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            if (this.frameLength > 0) {
                this.source.readFully(this.messageFrameBuffer, this.frameLength);
                if (!this.isClient) {
                    Buffer buffer = this.messageFrameBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    Intrinsics.checkNotNull(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    Intrinsics.checkNotNull(bArr);
                    webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + _UtilJvmKt.toHexString(this.opcode));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    @Override
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            _UtilCommonKt.closeQuietly(messageInflater);
        }
        _UtilCommonKt.closeQuietly(this.source);
    }
}
