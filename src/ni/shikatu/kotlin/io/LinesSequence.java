package ni.shikatu.kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/io/LinesSequence;", "Lni/shikatu/kotlin/sequences/Sequence;", _UrlKt.FRAGMENT_ENCODE_SET, "reader", "Ljava/io/BufferedReader;", "<init>", "(Ljava/io/BufferedReader;)V", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class LinesSequence implements Sequence<String> {
    private final BufferedReader reader;

    public LinesSequence(BufferedReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.reader = reader;
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0006\u001a\u00020\u0005H\u0096\u0082\u0004J\n\u0010\u0007\u001a\u00020\u0002H\u0096\u0082\u0004R\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ni/shikatu/kotlin/io/LinesSequence$iterator$1", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "nextValue", "done", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", "next", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<String>, KMappedMarker {
        private boolean done;
        private String nextValue;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
        }

        @Override
        public boolean hasNext() {
            if (this.nextValue == null && !this.done) {
                this.nextValue = LinesSequence.this.reader.readLine();
                if (this.nextValue == null) {
                    this.done = true;
                }
            }
            return this.nextValue != null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String answer = this.nextValue;
            this.nextValue = null;
            Intrinsics.checkNotNull(answer);
            return answer;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new AnonymousClass1();
    }
}
