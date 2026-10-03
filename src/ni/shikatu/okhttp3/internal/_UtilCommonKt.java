package ni.shikatu.okhttp3.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.Options;
import ni.shikatu.okio.Path;

@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aG\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u001a\u0010\n\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\b0\u000bj\n\u0012\u0006\b\u0000\u0012\u00020\b`\fH\u0000¢\u0006\u0002\u0010\r\u001aC\u0010\u000e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u001a\u0010\n\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\b0\u000bj\n\u0012\u0006\b\u0000\u0012\u00020\b`\fH\u0000¢\u0006\u0002\u0010\u0010\u001a7\u0010\u0011\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0013\u001a\u00020\b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\fH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0016\u001a \u0010\u0017\u001a\u00020\u0012*\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0012H\u0000\u001a \u0010\u001a\u001a\u00020\u0012*\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0012H\u0000\u001a\u001e\u0010\u001b\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u001a&\u0010\u001c\u001a\u00020\u0012*\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u001a&\u0010\u001c\u001a\u00020\u0012*\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u001a\f\u0010 \u001a\u00020\u0012*\u00020\bH\u0000\u001a\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\bH\u0000\u001a\f\u0010#\u001a\u00020\u0012*\u00020\u001fH\u0000\u001a\u0015\u0010$\u001a\u00020\u0012*\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0080\u0004\u001a\u0015\u0010$\u001a\u00020\u0012*\u00020'2\u0006\u0010&\u001a\u00020\u0012H\u0080\u0004\u001a\u0015\u0010$\u001a\u00020(*\u00020\u00122\u0006\u0010&\u001a\u00020(H\u0080\u0004\u001a\u0014\u0010)\u001a\u00020**\u00020+2\u0006\u0010,\u001a\u00020\u0012H\u0000\u001a\f\u0010-\u001a\u00020\u0012*\u00020.H\u0000\u001a\u001a\u0010/\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020*01H\u0080\bø\u0001\u0000\u001a\u0014\u00102\u001a\u00020\u0012*\u0002032\u0006\u00104\u001a\u00020%H\u0000\u001a\u0016\u00105\u001a\u00020\u0012*\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0012H\u0000\u001a\u0012\u00106\u001a\u00020(*\u00020\b2\u0006\u00107\u001a\u00020(\u001a\u0016\u00108\u001a\u00020\u0012*\u0004\u0018\u00010\b2\u0006\u00107\u001a\u00020\u0012H\u0000\u001a\u000e\u00109\u001a\u00020**\u00060:j\u0002`;\u001a\u0014\u0010<\u001a\u00020\u000f*\u00020=2\u0006\u0010>\u001a\u00020?H\u0000\u001a\u0014\u0010@\u001a\u00020**\u00020=2\u0006\u0010A\u001a\u00020?H\u0000\u001a\u0014\u0010B\u001a\u00020**\u00020=2\u0006\u0010C\u001a\u00020?H\u0000\u001a%\u0010D\u001a\u00020*\"\u0004\b\u0000\u0010E*\b\u0012\u0004\u0012\u0002HE0F2\u0006\u0010G\u001a\u0002HEH\u0000¢\u0006\u0002\u0010H\u001a\"\u0010I\u001a\u00020J*\u00060Kj\u0002`L2\u0010\u0010M\u001a\f\u0012\b\u0012\u00060Kj\u0002`L0NH\u0000\u001a;\u0010O\u001a\b\u0012\u0004\u0012\u0002HP0N\"\u0004\b\u0000\u0010P*\b\u0012\u0004\u0012\u0002HP0Q2\u0017\u0010R\u001a\u0013\u0012\u0004\u0012\u0002HP\u0012\u0004\u0012\u00020\u000f0S¢\u0006\u0002\bTH\u0080\bø\u0001\u0000\u001a \u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020(2\u0006\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020(H\u0000\u001a0\u0010Z\u001a\b\u0012\u0004\u0012\u0002HP0N\"\u0004\b\u0000\u0010P2\f\u0010[\u001a\b\u0012\u0004\u0012\u0002HP0Q2\f\u00104\u001a\b\u0012\u0004\u0012\u0002HP0QH\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010U\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\\"}, d2 = {"EMPTY_BYTE_ARRAY", _UrlKt.FRAGMENT_ENCODE_SET, "UNICODE_BOMS", "Lni/shikatu/okio/Options;", "getUNICODE_BOMS", "()Lokio/Options;", "intersect", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "other", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "indexOf", _UrlKt.FRAGMENT_ENCODE_SET, "value", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "indexOfFirstNonAsciiWhitespace", "startIndex", "endIndex", "indexOfLastNonAsciiWhitespace", "trimSubstring", "delimiterOffset", "delimiters", "delimiter", _UrlKt.FRAGMENT_ENCODE_SET, "indexOfControlOrNonAscii", "isSensitiveHeader", "name", "parseHexDigit", "and", _UrlKt.FRAGMENT_ENCODE_SET, "mask", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "writeMedium", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/BufferedSink;", "medium", "readMedium", "Lni/shikatu/okio/BufferedSource;", "ignoreIoExceptions", "block", "Lni/shikatu/kotlin/Function0;", "skipAll", "Lni/shikatu/okio/Buffer;", "b", "indexOfNonWhitespace", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "closeQuietly", "Ljava/io/Closeable;", "Lni/shikatu/okio/Closeable;", "isCivilized", "Lni/shikatu/okio/FileSystem;", "file", "Lni/shikatu/okio/Path;", "deleteIfExists", "path", "deleteContents", "directory", "addIfAbsent", "E", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/util/List;Ljava/lang/Object;)V", "withSuppressed", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/Exception;", "Lni/shikatu/kotlin/Exception;", "suppressed", _UrlKt.FRAGMENT_ENCODE_SET, "filterList", "T", _UrlKt.FRAGMENT_ENCODE_SET, "predicate", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "USER_AGENT", "checkOffsetAndCount", "arrayLength", "offset", "count", "interleave", "a", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final Options UNICODE_BOMS = Options.Companion.of(ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe0000"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000feff"));
    public static final String USER_AGENT = "okhttp/5.3.0";

    public static final Options getUNICODE_BOMS() {
        return UNICODE_BOMS;
    }

    public static final String[] intersect(String[] $this$intersect, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter($this$intersect, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        List result = new ArrayList();
        for (String a : $this$intersect) {
            for (String b : other) {
                if (comparator.compare(a, b) == 0) {
                    result.add(a);
                    break;
                }
            }
        }
        List $this$toTypedArray$iv = result;
        return (String[]) $this$toTypedArray$iv.toArray(new String[0]);
    }

    public static final boolean hasIntersection(String[] $this$hasIntersection, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter($this$hasIntersection, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!($this$hasIntersection.length == 0) && other != null) {
            if (!(other.length == 0)) {
                for (String a : $this$hasIntersection) {
                    for (String b : other) {
                        if (comparator.compare(a, b) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static final int indexOf(String[] $this$indexOf, String value, Comparator<String> comparator) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = $this$indexOf.length;
        for (int index$iv = 0; index$iv < length; index$iv++) {
            String it = $this$indexOf[index$iv];
            if (comparator.compare(it, value) == 0) {
                return index$iv;
            }
        }
        return -1;
    }

    public static final String[] concat(String[] $this$concat, String value) {
        Intrinsics.checkNotNullParameter($this$concat, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf($this$concat, $this$concat.length + 1);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        String[] result = (String[]) objArrCopyOf;
        result[ArraysKt.getLastIndex(result)] = value;
        return result;
    }

    public static  int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfFirstNonAsciiWhitespace(String $this$indexOfFirstNonAsciiWhitespace, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfFirstNonAsciiWhitespace, "<this>");
        for (int i = startIndex; i < endIndex; i++) {
            switch ($this$indexOfFirstNonAsciiWhitespace.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i;
            }
        }
        return endIndex;
    }

    public static  int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String $this$indexOfLastNonAsciiWhitespace, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfLastNonAsciiWhitespace, "<this>");
        int i = endIndex - 1;
        if (startIndex <= i) {
            while (true) {
                switch ($this$indexOfLastNonAsciiWhitespace.charAt(i)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        if (i != startIndex) {
                            i--;
                        }
                        break;
                    default:
                        return i + 1;
                }
            }
        }
        return startIndex;
    }

    public static  String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final String trimSubstring(String $this$trimSubstring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$trimSubstring, "<this>");
        int start = indexOfFirstNonAsciiWhitespace($this$trimSubstring, startIndex, endIndex);
        int end = indexOfLastNonAsciiWhitespace($this$trimSubstring, start, endIndex);
        String strSubstring = $this$trimSubstring.substring(start, end);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final int delimiterOffset(String $this$delimiterOffset, String delimiters, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$delimiterOffset, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        for (int i = startIndex; i < endIndex; i++) {
            if (StringsKt.contains$default((CharSequence) delimiters, $this$delimiterOffset.charAt(i), false, 2, (Object) null)) {
                return i;
            }
        }
        return endIndex;
    }

    public static  int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final int delimiterOffset(String $this$delimiterOffset, char delimiter, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$delimiterOffset, "<this>");
        for (int i = startIndex; i < endIndex; i++) {
            if ($this$delimiterOffset.charAt(i) == delimiter) {
                return i;
            }
        }
        return endIndex;
    }

    public static final int indexOfControlOrNonAscii(String $this$indexOfControlOrNonAscii) {
        Intrinsics.checkNotNullParameter($this$indexOfControlOrNonAscii, "<this>");
        int length = $this$indexOfControlOrNonAscii.length();
        for (int i = 0; i < length; i++) {
            char c = $this$indexOfControlOrNonAscii.charAt(i);
            if (Intrinsics.compare((int) c, 31) <= 0 || Intrinsics.compare((int) c, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean isSensitiveHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.equals(name, "Authorization", true) || StringsKt.equals(name, "Cookie", true) || StringsKt.equals(name, "Proxy-Authorization", true) || StringsKt.equals(name, "Set-Cookie", true);
    }

    public static final int parseHexDigit(char $this$parseHexDigit) {
        if ('0' <= $this$parseHexDigit && $this$parseHexDigit < ':') {
            return $this$parseHexDigit - '0';
        }
        if ('a' <= $this$parseHexDigit && $this$parseHexDigit < 'g') {
            return ($this$parseHexDigit - 'a') + 10;
        }
        if ('A' <= $this$parseHexDigit && $this$parseHexDigit < 'G') {
            return ($this$parseHexDigit - 'A') + 10;
        }
        return -1;
    }

    public static final int and(byte $this$and, int mask) {
        return $this$and & mask;
    }

    public static final int and(short $this$and, int mask) {
        return $this$and & mask;
    }

    public static final long and(int $this$and, long mask) {
        return ((long) $this$and) & mask;
    }

    public static final void writeMedium(BufferedSink $this$writeMedium, int medium) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeMedium, "<this>");
        $this$writeMedium.writeByte((medium >>> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
        $this$writeMedium.writeByte((medium >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        $this$writeMedium.writeByte(medium & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    public static final int readMedium(BufferedSource $this$readMedium) throws IOException {
        Intrinsics.checkNotNullParameter($this$readMedium, "<this>");
        return (and($this$readMedium.readByte(), KotlinVersion.MAX_COMPONENT_VALUE) << 16) | (and($this$readMedium.readByte(), KotlinVersion.MAX_COMPONENT_VALUE) << 8) | and($this$readMedium.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
    }

    public static final void ignoreIoExceptions(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            function0.invoke();
        } catch (IOException e) {
        }
    }

    public static final int skipAll(Buffer $this$skipAll, byte b) throws EOFException {
        Intrinsics.checkNotNullParameter($this$skipAll, "<this>");
        int count = 0;
        while (!$this$skipAll.exhausted() && $this$skipAll.getByte(0L) == b) {
            count++;
            $this$skipAll.readByte();
        }
        return count;
    }

    public static  int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    public static final int indexOfNonWhitespace(String $this$indexOfNonWhitespace, int startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfNonWhitespace, "<this>");
        int length = $this$indexOfNonWhitespace.length();
        for (int i = startIndex; i < length; i++) {
            char c = $this$indexOfNonWhitespace.charAt(i);
            if (c != ' ' && c != '\t') {
                return i;
            }
        }
        int i2 = $this$indexOfNonWhitespace.length();
        return i2;
    }

    public static final long toLongOrDefault(String $this$toLongOrDefault, long defaultValue) {
        Intrinsics.checkNotNullParameter($this$toLongOrDefault, "<this>");
        try {
            return Long.parseLong($this$toLongOrDefault);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static final int toNonNegativeInt(String $this$toNonNegativeInt, int defaultValue) {
        if ($this$toNonNegativeInt == null) {
            return defaultValue;
        }
        try {
            long value = Long.parseLong($this$toNonNegativeInt);
            if (value > 2147483647L) {
                return IntCompanionObject.MAX_VALUE;
            }
            if (value < 0) {
                return 0;
            }
            return (int) value;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static final void closeQuietly(Closeable $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (RuntimeException rethrown) {
            throw rethrown;
        } catch (Exception e) {
        }
    }

    public static final boolean isCivilized(FileSystem $this$isCivilized, Path file) throws Throwable {
        Intrinsics.checkNotNullParameter($this$isCivilized, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        Closeable $this$use$iv = $this$isCivilized.sink(file);
        Throwable thrown$iv = null;
        try {
            try {
                $this$isCivilized.delete(file);
                if ($this$use$iv != null) {
                    try {
                        $this$use$iv.close();
                        return true;
                    } catch (Throwable th) {
                        return true;
                    }
                }
                return true;
            } catch (IOException e) {
                Unit unit = Unit.INSTANCE;
                if ($this$use$iv != null) {
                    try {
                        $this$use$iv.close();
                    } catch (Throwable t$iv) {
                        thrown$iv = t$iv;
                    }
                }
                if (thrown$iv == null) {
                    $this$isCivilized.delete(file);
                    return false;
                }
                throw thrown$iv;
            }
        } catch (Throwable t$iv2) {
            thrown$iv = t$iv2;
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv, t$iv3);
                }
            }
            if (thrown$iv == null) {
                $this$isCivilized.delete(file);
                return false;
            }
            throw thrown$iv;
        }
    }

    public static final void deleteIfExists(FileSystem $this$deleteIfExists, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteIfExists, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            $this$deleteIfExists.delete(path);
        } catch (FileNotFoundException e) {
        }
    }

    public static final void deleteContents(FileSystem $this$deleteContents, Path directory) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteContents, "<this>");
        Intrinsics.checkNotNullParameter(directory, "directory");
        IOException exception = null;
        try {
            for (Path file : $this$deleteContents.list(directory)) {
                try {
                    if ($this$deleteContents.metadata(file).isDirectory()) {
                        deleteContents($this$deleteContents, file);
                    }
                    $this$deleteContents.delete(file);
                } catch (IOException ioe) {
                    if (exception == null) {
                        exception = ioe;
                    }
                }
            }
            if (exception != null) {
                throw exception;
            }
        } catch (FileNotFoundException e) {
        }
    }

    public static final <E> void addIfAbsent(List<E> list, E e) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.contains(e)) {
            list.add(e);
        }
    }

    public static final Throwable withSuppressed(Exception $this$withSuppressed, List<? extends Exception> list) {
        Intrinsics.checkNotNullParameter($this$withSuppressed, "<this>");
        Intrinsics.checkNotNullParameter(list, "suppressed");
        for (Exception e : list) {
            ExceptionsKt.addSuppressed($this$withSuppressed, e);
        }
        return $this$withSuppressed;
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        List listEmptyList = CollectionsKt.emptyList();
        for (Object i : iterable) {
            if (function1.invoke(i).booleanValue()) {
                if (listEmptyList.isEmpty()) {
                    List result = new ArrayList();
                    listEmptyList = result;
                }
                Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal._UtilCommonKt.filterList>");
                TypeIntrinsics.asMutableList(listEmptyList).add(i);
            }
        }
        return listEmptyList;
    }

    public static final void checkOffsetAndCount(long arrayLength, long offset, long count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException("length=" + arrayLength + ", offset=" + offset + ", count=" + offset);
        }
    }

    public static final <T> List<T> interleave(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "a");
        Intrinsics.checkNotNullParameter(iterable2, "b");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends T> it2 = iterable2.iterator();
        List $this$interleave_u24lambda_u240 = CollectionsKt.createListBuilder();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return CollectionsKt.build($this$interleave_u24lambda_u240);
            }
            if (it.hasNext()) {
                $this$interleave_u24lambda_u240.add(it.next());
            }
            if (it2.hasNext()) {
                $this$interleave_u24lambda_u240.add(it2.next());
            }
        }
    }
}
