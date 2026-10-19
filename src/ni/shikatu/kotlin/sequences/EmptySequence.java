package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.EmptyIterator;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\t\bB¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0082\u0004J\u0012\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0096\u0080\u0004J\u0012\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0096\u0080\u0004¨\u0006\f"}, d2 = {"Lni/shikatu/kotlin/sequences/EmptySequence;", "Lni/shikatu/kotlin/sequences/Sequence;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/sequences/DropTakeSequence;", "<init>", "()V", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "drop", "n", _UrlKt.FRAGMENT_ENCODE_SET, "take", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class EmptySequence implements Sequence, DropTakeSequence {
    public static final EmptySequence INSTANCE = new EmptySequence();

    private EmptySequence() {
    }

    @Override
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override
    public EmptySequence drop(int n) {
        return INSTANCE;
    }

    @Override
    public EmptySequence take(int n) {
        return INSTANCE;
    }
}
