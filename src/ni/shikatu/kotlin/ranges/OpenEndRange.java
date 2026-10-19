package ni.shikatu.kotlin.ranges;

import java.lang.Comparable;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0017\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\nH\u0096\u0080\u0004R\u0013\u0010\u0004\u001a\u00028\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u00028\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011Ê\u0001\u0010\b\u0012\u0012\f\b\u0013\u0012\b\b\fJ\u0004\b\t0\u0014¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/ranges/OpenEndRange;", "T", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "start", "getStart", "()Ljava/lang/Comparable;", "endExclusive", "getEndExclusive", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface OpenEndRange<T extends Comparable<? super T>> {
    boolean contains(T t);

    T getEndExclusive();

    T getStart();

    boolean isEmpty();

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(OpenEndRange<T> openEndRange, T t) {
            Intrinsics.checkNotNullParameter(t, "value");
            return t.compareTo(openEndRange.getStart()) >= 0 && t.compareTo(openEndRange.getEndExclusive()) < 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(OpenEndRange<T> openEndRange) {
            return openEndRange.getStart().compareTo(openEndRange.getEndExclusive()) >= 0;
        }
    }
}
