package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
final  class SequencesKt___SequencesKt$flatMapIndexed$1<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$1 INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$1();

    SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override
    public final Iterator<R> invoke(Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "p0");
        return iterable.iterator();
    }
}
