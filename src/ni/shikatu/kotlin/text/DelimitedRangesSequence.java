package ni.shikatu.kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B]\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000RC\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/text/DelimitedRangesSequence;", "Lni/shikatu/kotlin/sequences/Sequence;", "Lni/shikatu/kotlin/ranges/IntRange;", "input", _UrlKt.FRAGMENT_ENCODE_SET, "startIndex", _UrlKt.FRAGMENT_ENCODE_SET, "limit", "getNextMatch", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "currentIndex", "Lni/shikatu/kotlin/Pair;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "<init>", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class DelimitedRangesSequence implements Sequence<IntRange> {
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
    private final CharSequence input;
    private final int limit;
    private final int startIndex;

    public DelimitedRangesSequence(CharSequence input, int startIndex, int limit, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(function2, "getNextMatch");
        this.input = input;
        this.startIndex = startIndex;
        this.limit = limit;
        this.getNextMatch = function2;
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0017\u001a\u00020\u0018H\u0082\u0080\u0004J\n\u0010\u0019\u001a\u00020\u0002H\u0096\u0082\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0082\u0004R\u001b\u0010\u0003\u001a\u00020\u0004X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\u0004X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001b\u0010\f\u001a\u00020\u0004X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u0004X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"ni/shikatu/kotlin/text/DelimitedRangesSequence$iterator$1", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ranges/IntRange;", "nextState", _UrlKt.FRAGMENT_ENCODE_SET, "getNextState", "()I", "setNextState", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "counter", "getCounter", "setCounter", "calcNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<IntRange>, KMappedMarker {
        private int counter;
        private int currentStartIndex;
        private IntRange nextItem;
        private int nextSearchIndex;
        private int nextState = -1;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
            this.currentStartIndex = RangesKt.coerceIn(DelimitedRangesSequence.this.startIndex, 0, DelimitedRangesSequence.this.input.length());
            this.nextSearchIndex = this.currentStartIndex;
        }

        public final int getNextState() {
            return this.nextState;
        }

        public final void setNextState(int i) {
            this.nextState = i;
        }

        public final int getCurrentStartIndex() {
            return this.currentStartIndex;
        }

        public final void setCurrentStartIndex(int i) {
            this.currentStartIndex = i;
        }

        public final int getNextSearchIndex() {
            return this.nextSearchIndex;
        }

        public final void setNextSearchIndex(int i) {
            this.nextSearchIndex = i;
        }

        public final IntRange getNextItem() {
            return this.nextItem;
        }

        public final void setNextItem(IntRange intRange) {
            this.nextItem = intRange;
        }

        public final int getCounter() {
            return this.counter;
        }

        public final void setCounter(int i) {
            this.counter = i;
        }

        private final void calcNext() {
            Pair match;
            if (this.nextSearchIndex >= 0) {
                if (DelimitedRangesSequence.this.limit > 0) {
                    this.counter++;
                    if (this.counter < DelimitedRangesSequence.this.limit) {
                        if (this.nextSearchIndex <= DelimitedRangesSequence.this.input.length() || (match = (Pair) DelimitedRangesSequence.this.getNextMatch.invoke(DelimitedRangesSequence.this.input, Integer.valueOf(this.nextSearchIndex))) == null) {
                            this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.this.input));
                            this.nextSearchIndex = -1;
                        } else {
                            int index = ((Number) match.component1()).intValue();
                            int length = ((Number) match.component2()).intValue();
                            this.nextItem = RangesKt.until(this.currentStartIndex, index);
                            this.currentStartIndex = index + length;
                            this.nextSearchIndex = this.currentStartIndex + (length == 0 ? 1 : 0);
                        }
                    } else {
                        this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.this.input));
                        this.nextSearchIndex = -1;
                    }
                } else if (this.nextSearchIndex <= DelimitedRangesSequence.this.input.length()) {
                    this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.this.input));
                    this.nextSearchIndex = -1;
                } else {
                    int index2 = ((Number) match.component1()).intValue();
                    int length2 = ((Number) match.component2()).intValue();
                    this.nextItem = RangesKt.until(this.currentStartIndex, index2);
                    this.currentStartIndex = index2 + length2;
                    this.nextSearchIndex = this.currentStartIndex + (length2 == 0 ? 1 : 0);
                }
                this.nextState = 1;
                return;
            }
            this.nextState = 0;
            this.nextItem = null;
        }

        @Override
        public IntRange next() {
            if (this.nextState == -1) {
                calcNext();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            IntRange result = this.nextItem;
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return result;
        }

        @Override
        public boolean hasNext() {
            if (this.nextState == -1) {
                calcNext();
            }
            return this.nextState == 1;
        }
    }

    @Override
    public Iterator<IntRange> iterator() {
        return new AnonymousClass1();
    }
}
