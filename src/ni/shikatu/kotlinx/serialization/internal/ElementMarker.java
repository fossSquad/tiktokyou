package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@CoreFriendModuleApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B+\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0006H\u0086\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0082\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0082\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0006H\u0082\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R!\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u000bX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\rX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ElementMarker;", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "readIfAbsent", "Lni/shikatu/kotlin/Function2;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function2;)V", "lowerMarks", _UrlKt.FRAGMENT_ENCODE_SET, "highMarksArray", _UrlKt.FRAGMENT_ENCODE_SET, "mark", _UrlKt.FRAGMENT_ENCODE_SET, "index", "nextUnmarkedIndex", "prepareHighMarksArray", "elementsCount", "markHigh", "nextUnmarkedHighIndex", "Companion", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ElementMarker {
    private static final Companion Companion = new Companion(null);
    private static final long[] EMPTY_HIGH_MARKS = new long[0];
    private final SerialDescriptor descriptor;
    private final long[] highMarksArray;
    private long lowerMarks;
    private final Function2<SerialDescriptor, Integer, Boolean> readIfAbsent;

    public ElementMarker(SerialDescriptor descriptor, Function2<? super SerialDescriptor, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function2, "readIfAbsent");
        this.descriptor = descriptor;
        this.readIfAbsent = function2;
        int elementsCount = this.descriptor.getElementsCount();
        if (elementsCount <= 64) {
            this.lowerMarks = elementsCount != 64 ? (-1) << elementsCount : 0L;
            this.highMarksArray = EMPTY_HIGH_MARKS;
        } else {
            this.lowerMarks = 0L;
            this.highMarksArray = prepareHighMarksArray(elementsCount);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ElementMarker$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMPTY_HIGH_MARKS", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void mark(int index) {
        if (index < 64) {
            this.lowerMarks |= 1 << index;
        } else {
            markHigh(index);
        }
    }

    public final int nextUnmarkedIndex() {
        int elementsCount = this.descriptor.getElementsCount();
        while (this.lowerMarks != -1) {
            int index = Long.numberOfTrailingZeros(~this.lowerMarks);
            this.lowerMarks |= 1 << index;
            if (this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(index)).booleanValue()) {
                return index;
            }
        }
        if (elementsCount > 64) {
            return nextUnmarkedHighIndex();
        }
        return -1;
    }

    private final long[] prepareHighMarksArray(int elementsCount) {
        int slotsCount = (elementsCount - 1) >>> 6;
        int elementsInLastSlot = elementsCount & 63;
        long[] highMarks = new long[slotsCount];
        if (elementsInLastSlot != 0) {
            highMarks[ArraysKt.getLastIndex(highMarks)] = (-1) << elementsCount;
        }
        return highMarks;
    }

    private final void markHigh(int index) {
        int slot = (index >>> 6) - 1;
        int offsetInSlot = index & 63;
        this.highMarksArray[slot] = this.highMarksArray[slot] | (1 << offsetInSlot);
    }

    private final int nextUnmarkedHighIndex() {
        int length = this.highMarksArray.length;
        for (int slot = 0; slot < length; slot++) {
            int slotOffset = (slot + 1) * 64;
            long slotMarks = this.highMarksArray[slot];
            while (slotMarks != -1) {
                int indexInSlot = Long.numberOfTrailingZeros(~slotMarks);
                slotMarks |= 1 << indexInSlot;
                int index = slotOffset + indexInSlot;
                if (this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(index)).booleanValue()) {
                    this.highMarksArray[slot] = slotMarks;
                    return index;
                }
            }
            this.highMarksArray[slot] = slotMarks;
        }
        return -1;
    }
}
