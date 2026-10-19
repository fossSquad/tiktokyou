package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010\n\u001a\u00020\tH\u0082\u0080\u0004J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082\u0080\u0004J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082\u0080\u0004J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082\u0080\u0004J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082\u0080\u0004R\u0011\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/CharMappings;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ESCAPE_2_CHAR", _UrlKt.FRAGMENT_ENCODE_SET, "CHAR_TO_TOKEN", _UrlKt.FRAGMENT_ENCODE_SET, "initEscape", _UrlKt.FRAGMENT_ENCODE_SET, "initCharToToken", "initC2ESC", "c", _UrlKt.FRAGMENT_ENCODE_SET, "esc", _UrlKt.FRAGMENT_ENCODE_SET, "initC2TC", "cl", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CharMappings {
    public static final CharMappings INSTANCE = new CharMappings();
    public static final char[] ESCAPE_2_CHAR = new char[117];
    public static final byte[] CHAR_TO_TOKEN = new byte[WebSocketProtocol.PAYLOAD_SHORT];

    private CharMappings() {
    }

    static {
        INSTANCE.initEscape();
        INSTANCE.initCharToToken();
    }

    private final void initEscape() {
        for (int i = 0; i < 32; i++) {
            initC2ESC(i, AbstractJsonLexerKt.UNICODE_ESC);
        }
        initC2ESC(8, 'b');
        initC2ESC(9, 't');
        initC2ESC(10, 'n');
        initC2ESC(12, 'f');
        initC2ESC(13, 'r');
        initC2ESC('/', '/');
        initC2ESC('\"', '\"');
        initC2ESC(AbstractJsonLexerKt.STRING_ESC, AbstractJsonLexerKt.STRING_ESC);
    }

    private final void initCharToToken() {
        for (int i = 0; i < 33; i++) {
            initC2TC(i, (byte) 127);
        }
        initC2TC(9, (byte) 3);
        initC2TC(10, (byte) 3);
        initC2TC(13, (byte) 3);
        initC2TC(32, (byte) 3);
        initC2TC(AbstractJsonLexerKt.COMMA, (byte) 4);
        initC2TC(AbstractJsonLexerKt.COLON, (byte) 5);
        initC2TC(AbstractJsonLexerKt.BEGIN_OBJ, (byte) 6);
        initC2TC(AbstractJsonLexerKt.END_OBJ, (byte) 7);
        initC2TC(AbstractJsonLexerKt.BEGIN_LIST, (byte) 8);
        initC2TC(AbstractJsonLexerKt.END_LIST, (byte) 9);
        initC2TC('\"', (byte) 1);
        initC2TC(AbstractJsonLexerKt.STRING_ESC, (byte) 2);
    }

    private final void initC2ESC(int c, char esc) {
        if (esc != 'u') {
            ESCAPE_2_CHAR[esc] = (char) c;
        }
    }

    private final void initC2ESC(char c, char esc) {
        initC2ESC((int) c, esc);
    }

    private final void initC2TC(int c, byte cl) {
        CHAR_TO_TOKEN[c] = cl;
    }

    private final void initC2TC(char c, byte cl) {
        initC2TC((int) c, cl);
    }
}
