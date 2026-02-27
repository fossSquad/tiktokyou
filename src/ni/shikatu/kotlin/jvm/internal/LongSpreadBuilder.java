package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\b\u001a\u00020\u0004*\u00020\u0002H\u0014J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0002R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/LongSpreadBuilder;", "Lni/shikatu/kotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "<init>", "(I)V", "values", "getSize", "add", "", "value", "", "toArray", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LongSpreadBuilder extends PrimitiveSpreadBuilder<long[]> {
    private final long[] values;

    public LongSpreadBuilder(int size) {
        super(size);
        this.values = new long[size];
    }

    @Override
    public int getSize(long[] $this$getSize) {
        Intrinsics.checkNotNullParameter($this$getSize, "<this>");
        return $this$getSize.length;
    }

    public final void add(long value) {
        long[] jArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        jArr[position] = value;
    }

    public final long[] toArray() {
        return toArray(this.values, new long[size()]);
    }
}
