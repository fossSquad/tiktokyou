package ni.shikatu.okhttp3.internal.url;

import java.nio.charset.Charset;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okio.Buffer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aV\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000\u001a\\\u0010\u001f\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000\u001a,\u0010 \u001a\u00020\u0011*\u00020\u00122\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0019H\u0000\u001aP\u0010\"\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0000\u001a*\u0010#\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\u0000\u001a\u001c\u0010$\u001a\u00020\u0019*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"HEX_DIGITS", _UrlKt.FRAGMENT_ENCODE_SET, "getHEX_DIGITS", "()[C", "USERNAME_ENCODE_SET", _UrlKt.FRAGMENT_ENCODE_SET, "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_ENCODE_SET", "QUERY_COMPONENT_REENCODE_SET", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "FORM_ENCODE_SET", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "writeCanonicalized", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/Buffer;", "input", "pos", _UrlKt.FRAGMENT_ENCODE_SET, "limit", "encodeSet", "alreadyEncoded", _UrlKt.FRAGMENT_ENCODE_SET, "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalizeWithCharset", "writePercentDecoded", "encoded", "canonicalize", "percentDecode", "isPercentEncoded", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _UrlKt {
    public static final String FORM_ENCODE_SET = " !\"#$&'()+,/:;<=>?@[\\]^`{|}~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    public static final char[] getHEX_DIGITS() {
        return HEX_DIGITS;
    }

    public static final void writeCanonicalized(Buffer $this$writeCanonicalized, String input, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean unicodeAllowed, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writeCanonicalized, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
        Buffer encodedCharBuffer = null;
        int i = pos;
        while (i < limit) {
            int codePoint = input.codePointAt(i);
            if (alreadyEncoded && (codePoint == 9 || codePoint == 10 || codePoint == 12 || codePoint == 13)) {
                Unit unit = Unit.INSTANCE;
            } else {
                if (codePoint == 32 && encodeSet == FORM_ENCODE_SET) {
                    $this$writeCanonicalized.writeUtf8("+");
                } else if (codePoint == 43 && plusIsSpace) {
                    $this$writeCanonicalized.writeUtf8(alreadyEncoded ? "+" : "%2B");
                } else if (codePoint < 32 || codePoint == 127 || ((codePoint >= 128 && !unicodeAllowed) || StringsKt.contains$default((CharSequence) encodeSet, (char) codePoint, false, 2, (Object) null) || (codePoint == 37 && (!alreadyEncoded || (strict && !isPercentEncoded(input, i, limit)))))) {
                    if (encodedCharBuffer == null) {
                        encodedCharBuffer = new Buffer();
                    }
                    if (charset == null || Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                        encodedCharBuffer.writeUtf8CodePoint(codePoint);
                    } else {
                        encodedCharBuffer.writeString(input, i, Character.charCount(codePoint) + i, charset);
                    }
                    while (!encodedCharBuffer.exhausted()) {
                        int b = encodedCharBuffer.readByte() & UByte.MAX_VALUE;
                        $this$writeCanonicalized.writeByte(37);
                        $this$writeCanonicalized.writeByte((int) HEX_DIGITS[(b >> 4) & 15]);
                        $this$writeCanonicalized.writeByte((int) HEX_DIGITS[b & 15]);
                    }
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    $this$writeCanonicalized.writeUtf8CodePoint(codePoint);
                }
            }
            i += Character.charCount(codePoint);
        }
    }

    public static  String canonicalizeWithCharset$default(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 8) != 0) {
            z = false;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            z3 = false;
        }
        if ((i3 & 64) != 0) {
            z4 = false;
        }
        if ((i3 & 128) != 0) {
            charset = null;
        }
        return canonicalizeWithCharset(str, i, i2, str2, z, z2, z3, z4, charset);
    }

    public static final String canonicalizeWithCharset(String $this$canonicalizeWithCharset, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean unicodeAllowed, Charset charset) {
        Intrinsics.checkNotNullParameter($this$canonicalizeWithCharset, "<this>");
        Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
        int i = pos;
        while (i < limit) {
            int codePoint = $this$canonicalizeWithCharset.codePointAt(i);
            if (codePoint < 32 || codePoint == 127 || ((codePoint >= 128 && !unicodeAllowed) || StringsKt.contains$default((CharSequence) encodeSet, (char) codePoint, false, 2, (Object) null) || ((codePoint == 37 && (!alreadyEncoded || (strict && !isPercentEncoded($this$canonicalizeWithCharset, i, limit)))) || (codePoint == 43 && plusIsSpace)))) {
                Buffer out = new Buffer();
                out.writeUtf8($this$canonicalizeWithCharset, pos, i);
                writeCanonicalized(out, $this$canonicalizeWithCharset, i, limit, encodeSet, alreadyEncoded, strict, plusIsSpace, unicodeAllowed, charset);
                return out.readUtf8();
            }
            i += Character.charCount(codePoint);
        }
        String strSubstring = $this$canonicalizeWithCharset.substring(pos, limit);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void writePercentDecoded(Buffer $this$writePercentDecoded, String encoded, int pos, int limit, boolean plusIsSpace) {
        Intrinsics.checkNotNullParameter($this$writePercentDecoded, "<this>");
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        int i = pos;
        while (i < limit) {
            int codePoint = encoded.codePointAt(i);
            if (codePoint == 37 && i + 2 < limit) {
                int d1 = _UtilCommonKt.parseHexDigit(encoded.charAt(i + 1));
                int d2 = _UtilCommonKt.parseHexDigit(encoded.charAt(i + 2));
                if (d1 != -1 && d2 != -1) {
                    $this$writePercentDecoded.writeByte((d1 << 4) + d2);
                    i = i + 2 + Character.charCount(codePoint);
                } else {
                    $this$writePercentDecoded.writeUtf8CodePoint(codePoint);
                    i += Character.charCount(codePoint);
                }
            } else if (codePoint == 43 && plusIsSpace) {
                $this$writePercentDecoded.writeByte(32);
                i++;
            } else {
                $this$writePercentDecoded.writeUtf8CodePoint(codePoint);
                i += Character.charCount(codePoint);
            }
        }
    }

    public static  String canonicalize$default(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 8) != 0) {
            z = false;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            z3 = false;
        }
        if ((i3 & 64) != 0) {
            z4 = false;
        }
        return canonicalize(str, i, i2, str2, z, z2, z3, z4);
    }

    public static final String canonicalize(String $this$canonicalize, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean unicodeAllowed) {
        Intrinsics.checkNotNullParameter($this$canonicalize, "<this>");
        Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
        return canonicalizeWithCharset$default($this$canonicalize, pos, limit, encodeSet, alreadyEncoded, strict, plusIsSpace, unicodeAllowed, null, 128, null);
    }

    public static  String percentDecode$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return percentDecode(str, i, i2, z);
    }

    public static final String percentDecode(String $this$percentDecode, int pos, int limit, boolean plusIsSpace) {
        Intrinsics.checkNotNullParameter($this$percentDecode, "<this>");
        for (int i = pos; i < limit; i++) {
            char c = $this$percentDecode.charAt(i);
            if (c == '%' || (c == '+' && plusIsSpace)) {
                Buffer out = new Buffer();
                out.writeUtf8($this$percentDecode, pos, i);
                writePercentDecoded(out, $this$percentDecode, i, limit, plusIsSpace);
                return out.readUtf8();
            }
        }
        String strSubstring = $this$percentDecode.substring(pos, limit);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean isPercentEncoded(String $this$isPercentEncoded, int pos, int limit) {
        Intrinsics.checkNotNullParameter($this$isPercentEncoded, "<this>");
        return pos + 2 < limit && $this$isPercentEncoded.charAt(pos) == '%' && _UtilCommonKt.parseHexDigit($this$isPercentEncoded.charAt(pos + 1)) != -1 && _UtilCommonKt.parseHexDigit($this$isPercentEncoded.charAt(pos + 2)) != -1;
    }
}
