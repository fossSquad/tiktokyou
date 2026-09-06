package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bH\u0086\u0088\u0004ø\u0001\u0000JA\u0010\u0010\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bH\u0082\u0088\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlin/time/FractionalParser;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "parse", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "startIndex", _UrlKt.FRAGMENT_ENCODE_SET, "callback", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "name", "endIndex", _UrlKt.FRAGMENT_ENCODE_SET, "parseDigits", "maxDigits", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class FractionalParser {
    public static final FractionalParser INSTANCE = new FractionalParser();

    private FractionalParser() {
    }

    public final long parse(String value, int startIndex, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(function1, "callback");
        int index$iv = startIndex;
        int endIndex$iv = Math.min(index$iv + 6, value.length());
        int result$iv = 0;
        while (index$iv < endIndex$iv) {
            char ch$iv = value.charAt(index$iv);
            if (!('0' <= ch$iv && ch$iv < ':')) {
                break;
            }
            result$iv = (result$iv << 3) + (result$iv << 1) + (ch$iv - '0');
            index$iv++;
        }
        for (int i = 0; i < 6 - (index$iv - startIndex); i++) {
            result$iv = (result$iv << 3) + (result$iv << 1);
        }
        int index = index$iv;
        int index$iv2 = index;
        int endIndex$iv2 = Math.min(index$iv2 + 9, value.length());
        int result$iv2 = 0;
        while (index$iv2 < endIndex$iv2) {
            char ch$iv2 = value.charAt(index$iv2);
            if (!('0' <= ch$iv2 && ch$iv2 < ':')) {
                break;
            }
            result$iv2 = (result$iv2 << 3) + (result$iv2 << 1) + (ch$iv2 - '0');
            index$iv2++;
        }
        for (int i2 = 0; i2 < 9 - (index$iv2 - index); i2++) {
            result$iv2 = (result$iv2 << 3) + (result$iv2 << 1);
        }
        int i$iv = index$iv2;
        while (i$iv < value.length()) {
            char it = value.charAt(i$iv);
            if ((('0' > it || it >= ':') ? (char) 0 : (char) 1) == 0) {
                break;
            }
            i$iv++;
        }
        function1.invoke(Integer.valueOf(i$iv));
        return (((long) result$iv) * ((long) 1000000000)) + ((long) result$iv2);
    }

    private final int parseDigits(String $this$parseDigits, int startIndex, int maxDigits, Function1<? super Integer, Unit> function1) {
        int i;
        int index = startIndex;
        int endIndex = Math.min(index + maxDigits, $this$parseDigits.length());
        int result = 0;
        while (true) {
            if (index >= endIndex) {
                break;
            }
            char ch = $this$parseDigits.charAt(index);
            if (!('0' <= ch && ch < ':')) {
                break;
            }
            result = (result << 3) + (result << 1) + (ch - '0');
            index++;
        }
        for (i = 0; i < maxDigits - (index - startIndex); i++) {
            result = (result << 3) + (result << 1);
        }
        function1.invoke(Integer.valueOf(index));
        return result;
    }
}
