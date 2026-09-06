package ni.shikatu.kotlin.sequences;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/sequences/DropTakeSequence;", "T", "Lni/shikatu/kotlin/sequences/Sequence;", "drop", "n", _UrlKt.FRAGMENT_ENCODE_SET, "take", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface DropTakeSequence<T> extends Sequence<T> {
    Sequence<T> drop(int i);

    Sequence<T> take(int i);
}
