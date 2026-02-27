package ni.shikatu.kotlin.collections;

import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugMetadata;
import ni.shikatu.kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequenceScope;
import ni.shikatu.kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aD\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001aH\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedSequence", "Lni/shikatu/kotlin/sequences/Sequence;", "", "T", "partialWindows", "", "reuseBuffer", "windowedIterator", "", "iterator", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int size, int step) {
        if (!(size > 0 && step > 0)) {
            throw new IllegalArgumentException((size != step ? "Both size " + size + " and step " + step + " must be greater than zero." : "size " + size + " must be greater than zero.").toString());
        }
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> sequence, final int i, final int i2, final boolean z, final boolean z2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        checkWindowSizeStep(i, i2);
        return new Sequence<List<? extends T>>() {
            @Override
            public Iterator<List<? extends T>> iterator() {
                return SlidingWindowKt.windowedIterator(sequence.iterator(), i, i2, z, z2);
            }
        };
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lni/shikatu/kotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final  Iterator<T> $iterator;
        final  boolean $partialWindows;
        final  boolean $reuseBuffer;
        final  int $size;
        final  int $step;
        int I$0;
        private  Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(int i, int i2, Iterator<? extends T> it, boolean z, boolean z2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$size = i;
            this.$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override
        public final Object invoke(SequenceScope<? super List<? extends T>> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {

            throw new UnsupportedOperationException("Method not decompiled: ni.shikatu.kotlin.collections.SlidingWindowKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int size, int step, boolean partialWindows, boolean reuseBuffer) {
        Intrinsics.checkNotNullParameter(it, "iterator");
        return !it.hasNext() ? EmptyIterator.INSTANCE : SequencesKt.iterator(new AnonymousClass1(size, step, it, reuseBuffer, partialWindows, null));
    }
}
