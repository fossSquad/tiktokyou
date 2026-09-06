package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007Jw\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlin/time/LongParser;", _UrlKt.FRAGMENT_ENCODE_SET, "overflowLimit", _UrlKt.FRAGMENT_ENCODE_SET, "allowSign", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(JZ)V", "overflowThreshold", "lastDigitMax", "parse", "value", _UrlKt.FRAGMENT_ENCODE_SET, "startIndex", _UrlKt.FRAGMENT_ENCODE_SET, "callback", "Lni/shikatu/kotlin/Function3;", "Lni/shikatu/kotlin/ParameterName;", "name", "endIndex", "sign", "hasOverflow", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LongParser {
    private final boolean allowSign;
    private final long lastDigitMax;
    private final long overflowLimit;
    private final long overflowThreshold;
    public static final Companion Companion = new Companion(null);
    private static final LongParser iso = new LongParser(DurationKt.MAX_MILLIS, true);

    private static final LongParser f3default = new LongParser(LongCompanionObject.MAX_VALUE, false);

    private LongParser(long overflowLimit, boolean allowSign) {
        this.overflowLimit = overflowLimit;
        this.allowSign = allowSign;
        long j = 10;
        this.overflowThreshold = this.overflowLimit / j;
        this.lastDigitMax = this.overflowLimit % j;
    }

    public final long parse(String value, int startIndex, Function3<? super Integer, ? super Integer, ? super Boolean, Unit> function3) {
        char c;
        boolean z;
        char c2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(function3, "callback");
        int sign = 1;
        int index = startIndex;
        if (this.allowSign) {
            char firstChar = value.charAt(index);
            switch (firstChar) {
                case '+':
                    index++;
                    break;
                case '-':
                    sign = -1;
                    index++;
                    break;
            }
        }
        int startIndex$iv = index;
        int i$iv = startIndex$iv;
        while (true) {
            c = 1;
            if (i$iv < value.length()) {
                if ((value.charAt(i$iv) == '0' ? (char) 1 : (char) 0) != 0) {
                    i$iv++;
                }
            }
        }
        long result = 0;
        while (true) {
            if (i$iv >= value.length()) {
                z = false;
            } else {
                char ch = value.charAt(i$iv);
                if ((('0' > ch || ch >= ':') ? (char) 0 : c) == 0) {
                    z = false;
                } else {
                    int digit = ch - '0';
                    if (result > this.overflowThreshold) {
                        c2 = 0;
                    } else if (result != this.overflowThreshold || digit <= this.lastDigitMax) {
                        result = (result << 3) + (result << c) + ((long) digit);
                        i$iv++;
                        c = c;
                    } else {
                        c2 = 0;
                    }
                }
            }
            function3.invoke(Integer.valueOf(i$iv), Integer.valueOf(sign), Boolean.valueOf(z));
            return result;
        }
        int startIndex$iv2 = i$iv;
        int i$iv2 = startIndex$iv2;
        while (true) {
            char c3 = c2;
            if (i$iv2 < value.length()) {
                char it = value.charAt(i$iv2);
                if ((('0' > it || it >= ':') ? c3 : c) != 0) {
                    i$iv2++;
                    c2 = c3;
                }
            }
        }
        function3.invoke(Integer.valueOf(i$iv2), Integer.valueOf(sign), Boolean.valueOf((boolean) c));
        return this.overflowLimit;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lni/shikatu/kotlin/time/LongParser$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "iso", "Lni/shikatu/kotlin/time/LongParser;", "getIso", "()Lkotlin/time/LongParser;", "default", "getDefault", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LongParser getIso() {
            return LongParser.iso;
        }

        public final LongParser getDefault() {
            return LongParser.f3default;
        }
    }
}
