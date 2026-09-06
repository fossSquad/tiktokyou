package ni.shikatu.okhttp3.internal.idn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntProgression;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.CharsKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J(\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0017H\u0002J\u001c\u0010\"\u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0$*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\u00020\r*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lni/shikatu/okhttp3/internal/idn/Punycode;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "PREFIX_STRING", _UrlKt.FRAGMENT_ENCODE_SET, "getPREFIX_STRING", "()Ljava/lang/String;", "PREFIX", "Lni/shikatu/okio/ByteString;", "getPREFIX", "()Lokio/ByteString;", "BASE", _UrlKt.FRAGMENT_ENCODE_SET, "TMIN", "TMAX", "SKEW", "DAMP", "INITIAL_BIAS", "INITIAL_N", "encode", "string", "encodeLabel", _UrlKt.FRAGMENT_ENCODE_SET, "pos", "limit", "result", "Lni/shikatu/okio/Buffer;", "decode", "decodeLabel", "adapt", "delta", "numpoints", "first", "requiresEncode", "codePoints", _UrlKt.FRAGMENT_ENCODE_SET, "punycodeDigit", "getPunycodeDigit", "(I)I", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Punycode {
    private static final int BASE = 36;
    private static final int DAMP = 700;
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final int SKEW = 38;
    private static final int TMAX = 26;
    private static final int TMIN = 1;
    public static final Punycode INSTANCE = new Punycode();
    private static final String PREFIX_STRING = "xn--";
    private static final ByteString PREFIX = ByteString.Companion.encodeUtf8(PREFIX_STRING);

    private Punycode() {
    }

    public final String getPREFIX_STRING() {
        return PREFIX_STRING;
    }

    public final ByteString getPREFIX() {
        return PREFIX;
    }

    public final String encode(String string) {
        int dot;
        Intrinsics.checkNotNullParameter(string, "string");
        int limit = string.length();
        Buffer result = new Buffer();
        for (int pos = 0; pos < limit; pos = dot + 1) {
            dot = StringsKt.indexOf$default((CharSequence) string, '.', pos, false, 4, (Object) null);
            if (dot == -1) {
                dot = limit;
            }
            if (!encodeLabel(string, pos, dot, result)) {
                return null;
            }
            if (dot >= limit) {
                break;
            }
            result.writeByte(46);
        }
        return result.readUtf8();
    }

    private final boolean encodeLabel(String string, int pos, int limit, Buffer result) {
        int i;
        int increment;
        int increment2;
        int i2 = 1;
        if (!requiresEncode(string, pos, limit)) {
            result.writeUtf8(string, pos, limit);
            return true;
        }
        result.write(PREFIX);
        List<Integer> listCodePoints = codePoints(string, pos, limit);
        int b = 0;
        Iterator<Integer> it = listCodePoints.iterator();
        while (it.hasNext()) {
            int codePoint = it.next().intValue();
            if (codePoint < 128) {
                result.writeByte(codePoint);
                b++;
            }
        }
        if (b > 0) {
            result.writeByte(45);
        }
        int n = 128;
        int delta = 0;
        int bias = INITIAL_BIAS;
        int h = b;
        while (h < listCodePoints.size()) {
            List<Integer> $this$minBy$iv = listCodePoints;
            Iterator iterator$iv = $this$minBy$iv.iterator();
            if (!iterator$iv.hasNext()) {
                throw new NoSuchElementException();
            }
            Object minElem$iv = iterator$iv.next();
            int i3 = i2;
            if (iterator$iv.hasNext()) {
                i = IntCompanionObject.MAX_VALUE;
                int it2 = ((Number) minElem$iv).intValue();
                if (it2 < n) {
                    it2 = Integer.MAX_VALUE;
                }
                while (true) {
                    Object e$iv = iterator$iv.next();
                    int it3 = ((Number) e$iv).intValue();
                    if (it3 < n) {
                        it3 = i;
                    }
                    if (it2 > it3) {
                        minElem$iv = e$iv;
                        it2 = it3;
                    }
                    if (!iterator$iv.hasNext()) {
                        break;
                    }
                    i = IntCompanionObject.MAX_VALUE;
                }
            } else {
                i = IntCompanionObject.MAX_VALUE;
            }
            int m = ((Number) minElem$iv).intValue();
            int increment3 = (m - n) * (h + 1);
            boolean z = false;
            if (delta > i - increment3) {
                return false;
            }
            int delta2 = delta + increment3;
            Iterator<Integer> it4 = listCodePoints.iterator();
            while (it4.hasNext()) {
                int c = it4.next().intValue();
                if (c < m) {
                    if (delta2 == i) {
                        return z;
                    }
                    delta2++;
                    i = IntCompanionObject.MAX_VALUE;
                } else if (c == m) {
                    int q = delta2;
                    int m2 = m;
                    IntProgression intProgressionStep = RangesKt.step(RangesKt.until(BASE, IntCompanionObject.MAX_VALUE), BASE);
                    int k = intProgressionStep.getFirst();
                    int last = intProgressionStep.getLast();
                    int step = intProgressionStep.getStep();
                    if ((step > 0 && k <= last) || (step < 0 && last <= k)) {
                        while (true) {
                            if (k <= bias) {
                                increment = increment3;
                                increment2 = i3;
                            } else {
                                increment = increment3;
                                increment2 = k >= bias + TMAX ? TMAX : k - bias;
                            }
                            if (q < increment2) {
                                break;
                            }
                            int t = increment2;
                            result.writeByte(getPunycodeDigit(t + ((q - increment2) % (36 - increment2))));
                            q = (q - t) / (36 - t);
                            if (k == last) {
                                break;
                            }
                            k += step;
                            increment3 = increment;
                        }
                    } else {
                        increment = increment3;
                    }
                    result.writeByte(getPunycodeDigit(q));
                    bias = adapt(delta2, h + 1, h == b ? i3 : false);
                    delta2 = 0;
                    h++;
                    m = m2;
                    increment3 = increment;
                    z = false;
                    i = IntCompanionObject.MAX_VALUE;
                } else {
                    z = false;
                    i = IntCompanionObject.MAX_VALUE;
                }
            }
            delta = delta2 + 1;
            n = m + 1;
            i2 = i3;
        }
        return i2;
    }

    public final String decode(String string) {
        int dot;
        Intrinsics.checkNotNullParameter(string, "string");
        int limit = string.length();
        Buffer result = new Buffer();
        for (int pos = 0; pos < limit; pos = dot + 1) {
            dot = StringsKt.indexOf$default((CharSequence) string, '.', pos, false, 4, (Object) null);
            if (dot == -1) {
                dot = limit;
            }
            if (!decodeLabel(string, pos, dot, result)) {
                return null;
            }
            if (dot >= limit) {
                break;
            }
            result.writeByte(46);
        }
        return result.readUtf8();
    }

    private final boolean decodeLabel(String str, int i, int i2, Buffer buffer) {
        boolean z;
        boolean z2;
        int i3;
        int i4;
        boolean z3 = true;
        if (!StringsKt.regionMatches(str, i, PREFIX_STRING, 0, 4, true)) {
            buffer.writeUtf8(str, i, i2);
            return true;
        }
        int i5 = i + 4;
        ArrayList arrayList = new ArrayList();
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, '-', i2, false, 4, (Object) null);
        char c = AbstractJsonLexerKt.BEGIN_OBJ;
        char c2 = 'A';
        char c3 = 'a';
        boolean z4 = false;
        if (iLastIndexOf$default < i5) {
            z = true;
            z2 = false;
        } else {
            while (i5 < iLastIndexOf$default) {
                int i6 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (!(('a' > cCharAt || cCharAt >= '{') ? z4 : z3)) {
                    if (!(('A' > cCharAt || cCharAt >= '[') ? z4 : z3)) {
                        if (!(('0' > cCharAt || cCharAt >= ':') ? z4 : z3)) {
                            if (cCharAt != '-') {
                                return z4;
                            }
                        }
                    }
                }
                arrayList.add(Integer.valueOf(cCharAt));
                i5 = i6;
                z3 = z3;
                z4 = z4;
            }
            z = z3;
            z2 = z4;
            i5++;
        }
        int i7 = 128;
        int i8 = 0;
        int iAdapt = INITIAL_BIAS;
        while (i5 < i2) {
            int i9 = i8;
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(BASE, IntCompanionObject.MAX_VALUE), BASE);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                i3 = iLastIndexOf$default;
            } else {
                int i10 = 1;
                while (i5 != i2) {
                    int i11 = i5 + 1;
                    char cCharAt2 = str.charAt(i5);
                    ?? r25 = 26;
                    if ((c3 > cCharAt2 || cCharAt2 >= c) ? z2 : z) {
                        i4 = cCharAt2 - 'a';
                    } else {
                        if ((c2 > cCharAt2 || cCharAt2 >= '[') ? z2 : z) {
                            i4 = cCharAt2 - 'A';
                        } else {
                            if (!(('0' > cCharAt2 || cCharAt2 >= ':') ? z2 : z)) {
                                return z2;
                            }
                            i4 = (cCharAt2 - '0') + TMAX;
                        }
                    }
                    int i12 = i4;
                    int i13 = i10;
                    int i14 = i12 * i13;
                    if (i8 > IntCompanionObject.MAX_VALUE - i14) {
                        return z2;
                    }
                    i8 += i14;
                    if (first <= iAdapt) {
                        r25 = z;
                    } else if (first < iAdapt + TMAX) {
                        r25 = first - iAdapt;
                    }
                    ?? r6 = r25;
                    if (i12 < r6) {
                        i3 = iLastIndexOf$default;
                        i5 = i11;
                    } else {
                        int i15 = 36 - (r6 == true ? 1 : 0);
                        i3 = iLastIndexOf$default;
                        if (i13 > IntCompanionObject.MAX_VALUE / i15) {
                            return z2;
                        }
                        i10 = i13 * i15;
                        if (first != last) {
                            first += step;
                            i5 = i11;
                            iLastIndexOf$default = i3;
                            c = AbstractJsonLexerKt.BEGIN_OBJ;
                            c2 = 'A';
                            c3 = 'a';
                        } else {
                            i5 = i11;
                        }
                    }
                }
                return z2;
            }
            iAdapt = adapt(i8 - i9, arrayList.size() + 1, i9 == 0 ? z : z2);
            int size = i8 / (arrayList.size() + 1);
            if (i7 > IntCompanionObject.MAX_VALUE - size) {
                return z2;
            }
            i7 += size;
            int size2 = i8 % (arrayList.size() + 1);
            if (i7 > 1114111) {
                return z2;
            }
            arrayList.add(size2, Integer.valueOf(i7));
            i8 = size2 + 1;
            iLastIndexOf$default = i3;
            c = AbstractJsonLexerKt.BEGIN_OBJ;
            c2 = 'A';
            c3 = 'a';
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            buffer.writeUtf8CodePoint(((Number) it.next()).intValue());
        }
        return z;
    }

    private final int adapt(int delta, int numpoints, boolean first) {
        int delta2 = first ? delta / DAMP : delta / 2;
        int delta3 = delta2 + (delta2 / numpoints);
        int k = 0;
        while (delta3 > 455) {
            delta3 /= 35;
            k += BASE;
        }
        return ((delta3 * BASE) / (delta3 + SKEW)) + k;
    }

    private final boolean requiresEncode(String $this$requiresEncode, int pos, int limit) {
        for (int i = pos; i < limit; i++) {
            if ($this$requiresEncode.charAt(i) >= 128) {
                return true;
            }
        }
        return false;
    }

    private final List<Integer> codePoints(String $this$codePoints, int pos, int limit) {
        int i;
        List result = new ArrayList();
        int i2 = pos;
        while (i2 < limit) {
            char c = $this$codePoints.charAt(i2);
            List list = result;
            if (CharsKt.isSurrogate(c)) {
                char low = i2 + 1 < limit ? $this$codePoints.charAt(i2 + 1) : (char) 0;
                if (Character.isLowSurrogate(c) || !Character.isLowSurrogate(low)) {
                    i = 63;
                } else {
                    i2++;
                    i = (((c & 1023) << 10) | (low & 1023)) + 65536;
                }
            } else {
                i = c;
            }
            list.add(Integer.valueOf(i));
            i2++;
        }
        return result;
    }

    private final int getPunycodeDigit(int $this$punycodeDigit) {
        if ($this$punycodeDigit < TMAX) {
            return $this$punycodeDigit + 97;
        }
        if ($this$punycodeDigit < BASE) {
            return ($this$punycodeDigit - 26) + 48;
        }
        throw new IllegalStateException(("unexpected digit: " + $this$punycodeDigit).toString());
    }
}
