package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0082\u0080\u0004\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0080\u0080\u0004\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0017\"'\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0006X\u0087\u0084\b¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0015\u0010\f\u001a\u00020\rX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"toHexChar", _UrlKt.FRAGMENT_ENCODE_SET, "i", _UrlKt.FRAGMENT_ENCODE_SET, "ESCAPE_STRINGS", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getESCAPE_STRINGS$annotations", "()V", "getESCAPE_STRINGS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "ESCAPE_MARKERS", _UrlKt.FRAGMENT_ENCODE_SET, "getESCAPE_MARKERS", "()[B", "printQuoted", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "value", "toBooleanStrictOrNull", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)Ljava/lang/Boolean;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StringOpsKt {
    private static final byte[] ESCAPE_MARKERS;
    private static final String[] ESCAPE_STRINGS;

    @JsonFriendModuleApi
    public static  void getESCAPE_STRINGS$annotations() {
    }

    private static final char toHexChar(int i) {
        int d = i & 15;
        return d < 10 ? (char) (d + 48) : (char) ((d - 10) + 97);
    }

    static {
        String[] $this$ESCAPE_STRINGS_u24lambda_u240 = new String[93];
        for (int c = 0; c < 32; c++) {
            char c1 = toHexChar(c >> 12);
            char c2 = toHexChar(c >> 8);
            char c3 = toHexChar(c >> 4);
            char c4 = toHexChar(c);
            $this$ESCAPE_STRINGS_u24lambda_u240[c] = "\\u" + c1 + c2 + c3 + c4;
        }
        $this$ESCAPE_STRINGS_u24lambda_u240[34] = "\\\"";
        $this$ESCAPE_STRINGS_u24lambda_u240[92] = "\\\\";
        $this$ESCAPE_STRINGS_u24lambda_u240[9] = "\\t";
        $this$ESCAPE_STRINGS_u24lambda_u240[8] = "\\b";
        $this$ESCAPE_STRINGS_u24lambda_u240[10] = "\\n";
        $this$ESCAPE_STRINGS_u24lambda_u240[13] = "\\r";
        $this$ESCAPE_STRINGS_u24lambda_u240[12] = "\\f";
        ESCAPE_STRINGS = $this$ESCAPE_STRINGS_u24lambda_u240;
        byte[] $this$ESCAPE_MARKERS_u24lambda_u240 = new byte[93];
        for (int c5 = 0; c5 < 32; c5++) {
            $this$ESCAPE_MARKERS_u24lambda_u240[c5] = 1;
        }
        $this$ESCAPE_MARKERS_u24lambda_u240[34] = 34;
        $this$ESCAPE_MARKERS_u24lambda_u240[92] = 92;
        $this$ESCAPE_MARKERS_u24lambda_u240[9] = 116;
        $this$ESCAPE_MARKERS_u24lambda_u240[8] = 98;
        $this$ESCAPE_MARKERS_u24lambda_u240[10] = 110;
        $this$ESCAPE_MARKERS_u24lambda_u240[13] = 114;
        $this$ESCAPE_MARKERS_u24lambda_u240[12] = 102;
        ESCAPE_MARKERS = $this$ESCAPE_MARKERS_u24lambda_u240;
    }

    public static final String[] getESCAPE_STRINGS() {
        return ESCAPE_STRINGS;
    }

    public static final byte[] getESCAPE_MARKERS() {
        return ESCAPE_MARKERS;
    }

    public static final void printQuoted(StringBuilder $this$printQuoted, String value) {
        Intrinsics.checkNotNullParameter($this$printQuoted, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$printQuoted.append('\"');
        int lastPos = 0;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            int c = value.charAt(i);
            if (c < ESCAPE_STRINGS.length && ESCAPE_STRINGS[c] != null) {
                $this$printQuoted.append((CharSequence) value, lastPos, i);
                $this$printQuoted.append(ESCAPE_STRINGS[c]);
                lastPos = i + 1;
            }
        }
        if (lastPos != 0) {
            $this$printQuoted.append((CharSequence) value, lastPos, value.length());
        } else {
            $this$printQuoted.append(value);
        }
        $this$printQuoted.append('\"');
    }

    public static final Boolean toBooleanStrictOrNull(String $this$toBooleanStrictOrNull) {
        Intrinsics.checkNotNullParameter($this$toBooleanStrictOrNull, "<this>");
        if (StringsKt.equals($this$toBooleanStrictOrNull, "true", true)) {
            return true;
        }
        return StringsKt.equals($this$toBooleanStrictOrNull, "false", true) ? false : null;
    }
}
