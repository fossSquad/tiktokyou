package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B+\bF\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0096\u0082\u0004J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003\"\u0004\b\u0002\u0010\f2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u0006H\u0080\u0080\u0004¢\u0006\u0002\b\rR\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/sequences/TransformingSequence;", "T", "R", "Lni/shikatu/kotlin/sequences/Sequence;", "sequence", "transformer", "Lni/shikatu/kotlin/Function1;", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "flatten", "E", "flatten$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TransformingSequence<T, R> implements Sequence<R> {
    private final Sequence<T> sequence;
    private final Function1<T, R> transformer;

    public TransformingSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(function1, "transformer");
        this.sequence = sequence;
        this.transformer = function1;
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0005\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u00020\bH\u0096\u0082\u0004R\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"ni/shikatu/kotlin/sequences/TransformingSequence$iterator$1", _UrlKt.FRAGMENT_ENCODE_SET, "iterator", "getIterator", "()Ljava/util/Iterator;", "next", "()Ljava/lang/Object;", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<R>, KMappedMarker {
        private final Iterator<T> iterator;
        final  TransformingSequence<T, R> this$0;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(TransformingSequence<T, R> transformingSequence) {
            this.this$0 = transformingSequence;
            this.iterator = ((TransformingSequence) transformingSequence).sequence.iterator();
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        @Override
        public R next() {
            return (R) ((TransformingSequence) this.this$0).transformer.invoke(this.iterator.next());
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }
    }

    @Override
    public Iterator<R> iterator() {
        return new AnonymousClass1(this);
    }

    public final <E> Sequence<E> flatten$kotlin_stdlib(Function1<? super R, ? extends Iterator<? extends E>> function1) {
        Intrinsics.checkNotNullParameter(function1, "iterator");
        return new FlatteningSequence(this.sequence, this.transformer, function1);
    }
}
