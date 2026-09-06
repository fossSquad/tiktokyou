package ni.shikatu.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntProgression;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0003$%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "source", "Lni/shikatu/okio/BufferedSource;", "client", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokio/BufferedSource;Z)V", "continuation", "Lni/shikatu/okhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lni/shikatu/okhttp3/internal/http2/Hpack$Reader;", "readConnectionPreface", _UrlKt.FRAGMENT_ENCODE_SET, "handler", "Lni/shikatu/okhttp3/internal/http2/Http2Reader$Handler;", "nextFrame", "requireSettings", "readHeaders", "length", _UrlKt.FRAGMENT_ENCODE_SET, "flags", "streamId", "readHeaderBlock", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "padding", "readData", "readPriority", "readRstStream", "readSettings", "readPushPromise", "readPing", "readGoAway", "readWindowUpdate", "close", "ContinuationSource", "Handler", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J.\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H&J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H&J(\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0005H&J&\u0010&\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J8\u0010)\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020!H&¨\u00060À\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Reader$Handler;", _UrlKt.FRAGMENT_ENCODE_SET, "data", _UrlKt.FRAGMENT_ENCODE_SET, "inFinished", _UrlKt.FRAGMENT_ENCODE_SET, "streamId", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/BufferedSource;", "length", "headers", "associatedStreamId", "headerBlock", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "rstStream", "errorCode", "Lni/shikatu/okhttp3/internal/http2/ErrorCode;", "settings", "clearPrevious", "Lni/shikatu/okhttp3/internal/http2/Settings;", "ackSettings", "ping", "ack", "payload1", "payload2", "goAway", "lastGoodStreamId", "debugData", "Lni/shikatu/okio/ByteString;", "windowUpdate", "windowSizeIncrement", _UrlKt.FRAGMENT_ENCODE_SET, "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "alternateService", "origin", _UrlKt.FRAGMENT_ENCODE_SET, "protocol", "host", "port", "maxAge", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    public Http2Reader(BufferedSource source, boolean client) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.client = client;
        this.continuation = new ContinuationSource(this.source);
        this.hpackReader = new Hpack.Reader(this.continuation, 4096, 0, 4, null);
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ByteString connectionPreface = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(_UtilJvmKt.format("<< CONNECTION " + connectionPreface.hex(), new Object[0]));
        }
        if (!Intrinsics.areEqual(Http2.CONNECTION_PREFACE, connectionPreface)) {
            throw new IOException("Expected a connection header but was " + connectionPreface.utf8());
        }
    }

    public final boolean nextFrame(boolean requireSettings, Handler handler) throws Exception {
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.source.require(9L);
            int length = _UtilCommonKt.readMedium(this.source);
            if (length > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + length);
            }
            int type = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
            int flags = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
            int streamId = this.source.readInt() & IntCompanionObject.MAX_VALUE;
            if (type != 8 && logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.INSTANCE.frameLog(true, streamId, length, type, flags));
            }
            if (requireSettings && type != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(type));
            }
            switch (type) {
                case 0:
                    readData(handler, length, flags, streamId);
                    return true;
                case 1:
                    readHeaders(handler, length, flags, streamId);
                    return true;
                case 2:
                    readPriority(handler, length, flags, streamId);
                    return true;
                case 3:
                    readRstStream(handler, length, flags, streamId);
                    return true;
                case 4:
                    readSettings(handler, length, flags, streamId);
                    return true;
                case 5:
                    readPushPromise(handler, length, flags, streamId);
                    return true;
                case 6:
                    readPing(handler, length, flags, streamId);
                    return true;
                case Http2.TYPE_GOAWAY /* 7 */:
                    readGoAway(handler, length, flags, streamId);
                    return true;
                case 8:
                    readWindowUpdate(handler, length, flags, streamId);
                    return true;
                default:
                    this.source.skip(length);
                    return true;
            }
        } catch (EOFException e) {
            return false;
        }
    }

    private final void readHeaders(Handler handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean endStream = (flags & 1) != 0;
        int padding = (flags & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE) : 0;
        int headerBlockLength = length;
        if ((flags & 32) != 0) {
            readPriority(handler, streamId);
            headerBlockLength -= 5;
        }
        handler.headers(endStream, streamId, -1, readHeaderBlock(Companion.lengthWithoutPadding(headerBlockLength, flags, padding), padding, flags, streamId));
    }

    private final List<Header> readHeaderBlock(int length, int padding, int flags, int streamId) throws IOException {
        this.continuation.setLeft(length);
        this.continuation.setLength(this.continuation.getLeft());
        this.continuation.setPadding(padding);
        this.continuation.setFlags(flags);
        this.continuation.setStreamId(streamId);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readData(Handler handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean inFinished = (flags & 1) != 0;
        boolean gzipped = (flags & 32) != 0;
        if (gzipped) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int padding = (flags & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE) : 0;
        int dataLength = Companion.lengthWithoutPadding(length, flags, padding);
        handler.data(inFinished, streamId, this.source, dataLength);
        this.source.skip(padding);
    }

    private final void readPriority(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length != 5) {
            throw new IOException("TYPE_PRIORITY length: " + length + " != 5");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        readPriority(handler, streamId);
    }

    private final void readPriority(Handler handler, int streamId) throws IOException {
        int w1 = this.source.readInt();
        boolean exclusive = (Integer.MIN_VALUE & w1) != 0;
        int streamDependency = Integer.MAX_VALUE & w1;
        int weight = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE) + 1;
        handler.priority(streamId, streamDependency, weight, exclusive);
    }

    private final void readRstStream(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + length + " != 4");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int errorCodeInt = this.source.readInt();
        ErrorCode errorCode = ErrorCode.Companion.fromHttp2(errorCodeInt);
        if (errorCode == null) {
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + errorCodeInt);
        }
        handler.rstStream(streamId, errorCode);
    }

    private final void readSettings(Handler handler, int length, int flags, int streamId) throws IOException {
        if (streamId != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((flags & 1) != 0) {
            if (length != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (length % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + length);
        }
        Settings settings = new Settings();
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, length), 6);
        int i = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
            while (true) {
                int id = _UtilCommonKt.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                int value = this.source.readInt();
                switch (id) {
                    case 1:
                    case 3:
                    default:
                        settings.set(id, value);
                        if (i != last) {
                            i += step;
                        }
                        break;
                    case 2:
                        if (value != 0 && value != 1) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                        }
                        settings.set(id, value);
                        if (i != last) {
                            i += step;
                        }
                        break;
                    case 4:
                        if (value < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        settings.set(id, value);
                        if (i != last) {
                            i += step;
                        }
                        break;
                    case 5:
                        if (value < 16384 || value > 16777215) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + value);
                        }
                        settings.set(id, value);
                        if (i != last) {
                            i += step;
                        }
                        break;
                }
            }
        }
        handler.settings(false, settings);
    }

    private final void readPushPromise(Handler handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int padding = (flags & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE) : 0;
        int promisedStreamId = this.source.readInt() & IntCompanionObject.MAX_VALUE;
        int headerBlockLength = Companion.lengthWithoutPadding(length - 4, flags, padding);
        handler.pushPromise(streamId, promisedStreamId, readHeaderBlock(headerBlockLength, padding, flags, streamId));
    }

    private final void readPing(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length != 8) {
            throw new IOException("TYPE_PING length != 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        int payload1 = this.source.readInt();
        int payload2 = this.source.readInt();
        boolean ack = (flags & 1) != 0;
        handler.ping(ack, payload1, payload2);
    }

    private final void readGoAway(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int lastStreamId = this.source.readInt();
        int errorCodeInt = this.source.readInt();
        int opaqueDataLength = length - 8;
        ErrorCode errorCode = ErrorCode.Companion.fromHttp2(errorCodeInt);
        if (errorCode == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + errorCodeInt);
        }
        ByteString debugData = ByteString.EMPTY;
        if (opaqueDataLength > 0) {
            debugData = this.source.readByteString(opaqueDataLength);
        }
        handler.goAway(lastStreamId, errorCode, debugData);
    }

    private final void readWindowUpdate(Handler handler, int length, int flags, int streamId) throws Exception {
        int length2;
        Exception e;
        int streamId2;
        if (length != 4) {
            length2 = length;
            try {
                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + length2);
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            try {
                long increment = _UtilCommonKt.and(this.source.readInt(), 2147483647L);
                if (increment == 0) {
                    length2 = length;
                    try {
                        throw new IOException("windowSizeIncrement was 0");
                    } catch (Exception e3) {
                        e = e3;
                    }
                } else {
                    if (logger.isLoggable(Level.FINE)) {
                        Logger logger2 = logger;
                        String strFrameLogWindowUpdate = Http2.INSTANCE.frameLogWindowUpdate(true, streamId, length, increment);
                        streamId2 = streamId;
                        logger2.fine(strFrameLogWindowUpdate);
                    } else {
                        streamId2 = streamId;
                    }
                    handler.windowUpdate(streamId2, increment);
                    return;
                }
            } catch (Exception e4) {
                length2 = length;
                e = e4;
            }
        }
        logger.fine(Http2.INSTANCE.frameLog(true, streamId, length2, 8, flags));
        throw e;
    }

    @Override
    public void close() throws IOException {
        this.source.close();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\""}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lni/shikatu/okio/Source;", "source", "Lni/shikatu/okio/BufferedSource;", "<init>", "(Lokio/BufferedSource;)V", "length", _UrlKt.FRAGMENT_ENCODE_SET, "getLength", "()I", "setLength", "(I)V", "flags", "getFlags", "setFlags", "streamId", "getStreamId", "setStreamId", "left", "getLeft", "setLeft", "padding", "getPadding", "setPadding", "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "timeout", "Lni/shikatu/okio/Timeout;", "close", _UrlKt.FRAGMENT_ENCODE_SET, "readContinuationHeader", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(BufferedSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        public final int getLength() {
            return this.length;
        }

        public final void setLength(int i) {
            this.length = i;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final void setFlags(int i) {
            this.flags = i;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        public final void setStreamId(int i) {
            this.streamId = i;
        }

        public final int getLeft() {
            return this.left;
        }

        public final void setLeft(int i) {
            this.left = i;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final void setPadding(int i) {
            this.padding = i;
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            while (this.left == 0) {
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
            long read = this.source.read(sink, Math.min(byteCount, this.left));
            if (read == -1) {
                return -1L;
            }
            this.left -= (int) read;
            return read;
        }

        @Override
        public Timeout timeout() {
            return this.source.timeout();
        }

        @Override
        public void close() throws IOException {
        }

        private final void readContinuationHeader() throws IOException {
            int previousStreamId = this.streamId;
            this.left = _UtilCommonKt.readMedium(this.source);
            this.length = this.left;
            int type = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
            this.flags = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
            if (Http2Reader.Companion.getLogger().isLoggable(Level.FINE)) {
                Http2Reader.Companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, type, this.flags));
            }
            this.streamId = this.source.readInt() & IntCompanionObject.MAX_VALUE;
            if (type != 9) {
                throw new IOException(type + " != TYPE_CONTINUATION");
            }
            if (this.streamId != previousStreamId) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2Reader$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", _UrlKt.FRAGMENT_ENCODE_SET, "length", "flags", "padding", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int length, int flags, int padding) throws IOException {
            int result = length;
            if ((flags & 8) != 0) {
                result--;
            }
            if (padding > result) {
                throw new IOException("PROTOCOL_ERROR padding " + padding + " > remaining length " + result);
            }
            return result - padding;
        }
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        logger = logger2;
    }
}
