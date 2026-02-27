package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\fBC\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lni/shikatu/kotlin/sequences/Sequence;", "sequence", "transformer", "Lni/shikatu/kotlin/Function1;", "iterator", "", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "State", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlatteningSequence<T, R, E> implements Sequence<E> {
    private final Function1<R, Iterator<E>> iterator;
    private final Sequence<T> sequence;
    private final Function1<T, R> transformer;

    public FlatteningSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1, Function1<? super R, ? extends Iterator<? extends E>> function2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(function1, "transformer");
        Intrinsics.checkNotNullParameter(function2, "iterator");
        this.sequence = sequence;
        this.transformer = function1;
        this.iterator = function2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/sequences/FlatteningSequence$State;", "", "<init>", "()V", "UNDEFINED", "", "READY", "DONE", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class State {
        public static final int DONE = 2;
        public static final State INSTANCE = new State();
        public static final int READY = 1;
        public static final int UNDEFINED = 0;

        private State() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"ni/shikatu/kotlin/sequences/FlatteningSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "itemIterator", "getItemIterator", "setItemIterator", "(Ljava/util/Iterator;)V", "state", "", "getState", "()I", "setState", "(I)V", "next", "()Ljava/lang/Object;", "hasNext", "", "ensureItemIterator", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<E>, KMappedMarker {
        private Iterator<? extends E> itemIterator;
        private final Iterator<T> iterator;
        private int state;
        final  FlatteningSequence<T, R, E> this$0;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(FlatteningSequence<T, R, E> flatteningSequence) {
            this.this$0 = flatteningSequence;
            this.iterator = ((FlatteningSequence) flatteningSequence).sequence.iterator();
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final Iterator<E> getItemIterator() {
            return this.itemIterator;
        }

        public final void setItemIterator(Iterator<? extends E> it) {
            this.itemIterator = it;
        }

        public final int getState() {
            return this.state;
        }

        public final void setState(int i) {
            this.state = i;
        }

        @Override
        public E next() {
            if (this.state == 2) {
                throw new NoSuchElementException();
            }
            if (this.state == 0 && !ensureItemIterator()) {
                throw new NoSuchElementException();
            }
            this.state = 0;
            Iterator<? extends E> it = this.itemIterator;
            Intrinsics.checkNotNull(it);
            return it.next();
        }

        @Override
        public boolean hasNext() {
            if (this.state == 1) {
                return true;
            }
            if (this.state == 2) {
                return false;
            }
            return ensureItemIterator();
        }

        private final boolean ensureItemIterator() {
            Iterator<? extends E> it = this.itemIterator;
            if (it != null && it.hasNext()) {
                this.state = 1;
                return true;
            }
            while (this.iterator.hasNext()) {
                Iterator<? extends E> it2 = (Iterator) ((FlatteningSequence) this.this$0).iterator.invoke(((FlatteningSequence) this.this$0).transformer.invoke(this.iterator.next()));
                if (it2.hasNext()) {
                    this.itemIterator = it2;
                    this.state = 1;
                    return true;
                }
            }
            this.state = 2;
            this.itemIterator = null;
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new AnonymousClass1(this);
    }
}
