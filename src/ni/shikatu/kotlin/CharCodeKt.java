package ni.shikatu.kotlin;

import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\"6\u0010\u0002\u001a\u00020\u0003*\u00020\u00018Æ\u0002X\u0087\u0084\br\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006r\u0002\b\u0007r\u0002\b\f¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Char", _UrlKt.FRAGMENT_ENCODE_SET, "code", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.5", "Lni/shikatu/kotlin/internal/InlineOnly;", "getCode$annotations", "(C)V", "getCode", "(C)I", "Lni/shikatu/kotlin/internal/IntrinsicConstEvaluation;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class CharCodeKt {
    public static  void getCode$annotations(char c) {
    }

    private static final char Char(int code) {
        if (code < 0 || code > 65535) {
            throw new IllegalArgumentException("Invalid Char code: " + code);
        }
        return (char) code;
    }

    private static final int getCode(char $this$code) {
        return $this$code;
    }
}
