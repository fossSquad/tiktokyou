package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\u0004*\u00020\u0002H\u0094\u0080\u0004J\u0012\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0086\u0080\u0004J\n\u0010\f\u001a\u00020\u0002H\u0086\u0080\u0004R\u000f\u0010\u0007\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/IntSpreadBuilder;", "Lni/shikatu/kotlin/jvm/internal/PrimitiveSpreadBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "size", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(I)V", "values", "getSize", "add", _UrlKt.FRAGMENT_ENCODE_SET, "value", "toArray", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class IntSpreadBuilder extends PrimitiveSpreadBuilder<int[]> {
    private final int[] values;

    public IntSpreadBuilder(int size) {
        super(size);
        this.values = new int[size];
    }

    @Override
    public int getSize(int[] $this$getSize) {
        Intrinsics.checkNotNullParameter($this$getSize, "<this>");
        return $this$getSize.length;
    }

    public final void add(int value) {
        int[] iArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        iArr[position] = value;
    }

    public final int[] toArray() {
        return toArray(this.values, new int[size()]);
    }
}
