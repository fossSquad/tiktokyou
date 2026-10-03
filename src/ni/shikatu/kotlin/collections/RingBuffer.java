package ni.shikatu.kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B!\bF\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\bV\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0017\u001a\u00020\u0018H\u0086\u0080\u0004J\u0010\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096\u0082\u0004J)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0001\u0010\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001dJ\u0017\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010 \u001a\u00020\tH\u0086\u0080\u0004J\u0017\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\tH\u0086\u0080\u0004J\u0016\u0010'\u001a\u00020\t*\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0082\u0088\u0004R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u000eR\u000f\u0010\f\u001a\u00020\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000f\u001a\u00020\tX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@RX\u0096\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lni/shikatu/kotlin/collections/RingBuffer;", "T", "Lni/shikatu/kotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "buffer", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "filledSize", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([Ljava/lang/Object;I)V", "capacity", "(I)V", "[Ljava/lang/Object;", "startIndex", "value", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "isFull", _UrlKt.FRAGMENT_ENCODE_SET, "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "toArray", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "expanded", "maxCapacity", "add", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;)V", "removeFirst", "n", "forward", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] buffer, int filledSize) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (!(filledSize >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + filledSize).toString());
        }
        if (!(filledSize <= this.buffer.length)) {
            throw new IllegalArgumentException(("ring buffer filled size: " + filledSize + " cannot be larger than the buffer size: " + this.buffer.length).toString());
        }
        this.capacity = this.buffer.length;
        this.size = filledSize;
    }

    public RingBuffer(int capacity) {
        this(new Object[capacity], 0);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public T get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.buffer[(this.startIndex + i) % this.capacity];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) {
            private int count;
            private int index;
            final  RingBuffer<T> this$0;

            {
                this.this$0 = (RingBuffer<T>) (this);
                this.count = this.size();
                this.index = ((RingBuffer) this).startIndex;
            }

            @Override
            protected void computeNext() {
                if (this.count != 0) {
                    setNext(((RingBuffer) this.this$0).buffer[this.index]);
                    RingBuffer<T> ringBuffer = this.this$0;
                    int $this$forward$iv = this.index;
                    this.index = ($this$forward$iv + 1) % ((RingBuffer) ringBuffer).capacity;
                    this.count--;
                    return;
                }
                done();
            }
        };
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        Object[] objArrCopyOf;
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            objArrCopyOf = Arrays.copyOf(tArr, size());
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        } else {
            objArrCopyOf = tArr;
        }
        int size = size();
        int i = 0;
        for (int i2 = this.startIndex; i < size && i2 < this.capacity; i2++) {
            objArrCopyOf[i] = this.buffer[i2];
            i++;
        }
        int i3 = 0;
        while (i < size) {
            objArrCopyOf[i] = this.buffer[i3];
            i++;
            i3++;
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size, objArrCopyOf);
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public final RingBuffer<T> expanded(int maxCapacity) {
        Object[] newBuffer;
        int newCapacity = RangesKt.coerceAtMost(this.capacity + (this.capacity >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            newBuffer = Arrays.copyOf(this.buffer, newCapacity);
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(...)");
        } else {
            newBuffer = toArray(new Object[newCapacity]);
        }
        return new RingBuffer<>(newBuffer, size());
    }

    @Override
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        Object[] objArr = this.buffer;
        int $this$forward$iv = this.startIndex;
        int n$iv = size();
        objArr[($this$forward$iv + n$iv) % this.capacity] = t;
        this.size = size() + 1;
    }

    public final void removeFirst(int n) {
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + n).toString());
        }
        if (!(n <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + n + ", size = " + size()).toString());
        }
        if (n > 0) {
            int start = this.startIndex;
            int end = (start + n) % this.capacity;
            if (start > end) {
                ArraysKt.fill(this.buffer, (Object) null, start, this.capacity);
                ArraysKt.fill(this.buffer, (Object) null, 0, end);
            } else {
                ArraysKt.fill(this.buffer, (Object) null, start, end);
            }
            this.startIndex = end;
            this.size = size() - n;
        }
    }

    private final int forward(int $this$forward, int n) {
        return ($this$forward + n) % this.capacity;
    }
}
