package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u008c\u0004b\u0002\b\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u0005¨\u0006\n"}, d2 = {"compareTo", _UrlKt.FRAGMENT_ENCODE_SET, "T", _UrlKt.FRAGMENT_ENCODE_SET, "other", "(Ljava/lang/Comparable;Ljava/lang/Object;)I", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class CompareToKt {

    private static final <T> int compareTo(Comparable<? super T> comparable, T t) {
        Intrinsics.checkNotNullParameter(comparable, "<this>");
        return comparable.compareTo(t);
    }
}
