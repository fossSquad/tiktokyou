package ni.shikatu.okio;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0002J\u0015\u0010\u0012\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0082\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lni/shikatu/okio/PriorityQueue;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "size", _UrlKt.FRAGMENT_ENCODE_SET, "array", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/AsyncTimeout;", "[Lni/shikatu/okio/AsyncTimeout;", "first", "add", _UrlKt.FRAGMENT_ENCODE_SET, "node", "remove", "heapifyUp", "vacantIndex", "heapifyDown", "compareTo", "other", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PriorityQueue {
    public AsyncTimeout[] array = new AsyncTimeout[8];
    public int size;

    public final AsyncTimeout first() {
        return this.array[1];
    }

    public final void add(AsyncTimeout node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int newSize = this.size + 1;
        this.size = newSize;
        if (newSize == this.array.length) {
            AsyncTimeout[] doubledArray = new AsyncTimeout[newSize * 2];
            ArraysKt.copyInto$default(this.array, doubledArray, 0, 0, 0, 14, (Object) null);
            this.array = doubledArray;
        }
        heapifyUp(newSize, node);
    }

    public final void remove(AsyncTimeout node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!(node.index != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int oldSize = this.size;
        int removedIndex = node.index;
        AsyncTimeout last = this.array[oldSize];
        Intrinsics.checkNotNull(last);
        node.index = -1;
        this.array[oldSize] = null;
        this.size = oldSize - 1;
        if (node == last) {
            return;
        }
        long a$iv = node.timeoutNanos();
        long b$iv = last.timeoutNanos();
        int nodeCompareToLast = Intrinsics.compare(0L, b$iv - a$iv);
        if (nodeCompareToLast == 0) {
            this.array[removedIndex] = last;
            last.index = removedIndex;
        } else if (nodeCompareToLast >= 0) {
            heapifyUp(removedIndex, last);
        } else {
            heapifyDown(removedIndex, last);
        }
    }

    private final void heapifyUp(int vacantIndex, AsyncTimeout node) {
        int vacantIndex2 = vacantIndex;
        while (true) {
            int parentIndex = vacantIndex2 >> 1;
            if (parentIndex == 0) {
                break;
            }
            AsyncTimeout parentNode = this.array[parentIndex];
            Intrinsics.checkNotNull(parentNode);
            long a$iv = parentNode.timeoutNanos();
            long b$iv = node.timeoutNanos();
            if (Intrinsics.compare(0L, b$iv - a$iv) <= 0) {
                break;
            }
            parentNode.index = vacantIndex2;
            this.array[vacantIndex2] = parentNode;
            vacantIndex2 = parentIndex;
        }
        this.array[vacantIndex2] = node;
        node.index = vacantIndex2;
    }

    private final void heapifyDown(int vacantIndex, AsyncTimeout node) {
        AsyncTimeout smallestChild;
        int vacantIndex2 = vacantIndex;
        while (true) {
            int leftIndex = vacantIndex2 << 1;
            int rightIndex = leftIndex + 1;
            if (rightIndex > this.size) {
                if (leftIndex > this.size) {
                    break;
                }
                smallestChild = this.array[leftIndex];
                Intrinsics.checkNotNull(smallestChild);
            } else {
                AsyncTimeout leftNode = this.array[leftIndex];
                Intrinsics.checkNotNull(leftNode);
                AsyncTimeout rightNode = this.array[rightIndex];
                Intrinsics.checkNotNull(rightNode);
                long a$iv = leftNode.timeoutNanos();
                long b$iv = rightNode.timeoutNanos();
                smallestChild = Intrinsics.compare(0L, b$iv - a$iv) < 0 ? leftNode : rightNode;
            }
            AsyncTimeout other$iv = smallestChild;
            long a$iv2 = node.timeoutNanos();
            long b$iv2 = other$iv.timeoutNanos();
            if (Intrinsics.compare(0L, b$iv2 - a$iv2) <= 0) {
                break;
            }
            int newVacantIndex = smallestChild.index;
            smallestChild.index = vacantIndex2;
            this.array[vacantIndex2] = smallestChild;
            vacantIndex2 = newVacantIndex;
        }
        this.array[vacantIndex2] = node;
        node.index = vacantIndex2;
    }

    private final int compareTo(AsyncTimeout $this$compareTo, AsyncTimeout other) {
        Intrinsics.checkNotNullParameter($this$compareTo, "<this>");
        long a = $this$compareTo.timeoutNanos();
        long b = other.timeoutNanos();
        return Intrinsics.compare(0L, b - a);
    }
}
