package ni.shikatu.okhttp3.internal.http2;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007J&\u0010'\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)J\u0015\u0010*\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0007H\u0000¢\u0006\u0002\b+J\u0016\u0010,\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006-"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "CONNECTION_PREFACE", "Lni/shikatu/okio/ByteString;", "INITIAL_MAX_FRAME_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "TYPE_DATA", "TYPE_HEADERS", "TYPE_PRIORITY", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_PUSH_PROMISE", "TYPE_PING", "TYPE_GOAWAY", "TYPE_WINDOW_UPDATE", "TYPE_CONTINUATION", "FLAG_NONE", "FLAG_ACK", "FLAG_END_STREAM", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_PADDED", "FLAG_PRIORITY", "FLAG_COMPRESSED", "FRAME_NAMES", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/String;", "FLAGS", "BINARY", "frameLog", "inbound", _UrlKt.FRAGMENT_ENCODE_SET, "streamId", "length", "type", "flags", "frameLogWindowUpdate", "windowSizeIncrement", _UrlKt.FRAGMENT_ENCODE_SET, "formattedType", "formattedType$okhttp", "formatFlags", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Http2 {
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final Http2 INSTANCE = new Http2();
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] FLAGS = new String[64];

    private Http2() {
    }

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
            strArr[i] = StringsKt.replace$default(_UtilJvmKt.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        FLAGS[0] = _UrlKt.FRAGMENT_ENCODE_SET;
        FLAGS[1] = "END_STREAM";
        int[] prefixFlags = {1};
        FLAGS[8] = "PADDED";
        for (int prefixFlag : prefixFlags) {
            FLAGS[prefixFlag | 8] = FLAGS[prefixFlag] + "|PADDED";
        }
        FLAGS[4] = "END_HEADERS";
        FLAGS[32] = "PRIORITY";
        FLAGS[36] = "END_HEADERS|PRIORITY";
        int[] frameFlags = {4, 32, 36};
        for (int frameFlag : frameFlags) {
            for (int prefixFlag2 : prefixFlags) {
                FLAGS[prefixFlag2 | frameFlag] = FLAGS[prefixFlag2] + '|' + FLAGS[frameFlag];
                FLAGS[prefixFlag2 | frameFlag | 8] = FLAGS[prefixFlag2] + '|' + FLAGS[frameFlag] + "|PADDED";
            }
        }
        int length = FLAGS.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (FLAGS[i2] == null) {
                FLAGS[i2] = BINARY[i2];
            }
        }
    }

    public final String frameLog(boolean inbound, int streamId, int length, int type, int flags) {
        String formattedType = formattedType$okhttp(type);
        String formattedFlags = formatFlags(type, flags);
        String direction = inbound ? "<<" : ">>";
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %s", direction, Integer.valueOf(streamId), Integer.valueOf(length), formattedType, formattedFlags);
    }

    public final String frameLogWindowUpdate(boolean inbound, int streamId, int length, long windowSizeIncrement) {
        String formattedType = formattedType$okhttp(8);
        String direction = inbound ? "<<" : ">>";
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %d", direction, Integer.valueOf(streamId), Integer.valueOf(length), formattedType, Long.valueOf(windowSizeIncrement));
    }

    public final String formattedType$okhttp(int type) {
        return type < FRAME_NAMES.length ? FRAME_NAMES[type] : _UtilJvmKt.format("0x%02x", Integer.valueOf(type));
    }

    public final String formatFlags(int type, int flags) {
        String str;
        if (flags == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        switch (type) {
            case 2:
            case 3:
            case TYPE_GOAWAY /* 7 */:
            case 8:
                return BINARY[flags];
            case 4:
            case 6:
                return flags == 1 ? "ACK" : BINARY[flags];
            case 5:
            default:
                if (flags < FLAGS.length) {
                    str = FLAGS[flags];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = BINARY[flags];
                }
                String result = str;
                if (type == 5 && (flags & 4) != 0) {
                    return StringsKt.replace$default(result, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                }
                if (type == 0 && (flags & 32) != 0) {
                    return StringsKt.replace$default(result, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                }
                return result;
        }
    }
}
