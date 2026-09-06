package ni.shikatu.kotlinx.serialization.internal;

import java.util.Arrays;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b@\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0090\u0080\u0004¢\u0006\u0002\b\u0010J\u0019\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0002H\u0090\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0002X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u0007R\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u0090\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ULongArrayBuilder;", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lni/shikatu/kotlin/ULongArray;", "bufferWithData", "<init>", "([JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "buffer", "[J", "value", _UrlKt.FRAGMENT_ENCODE_SET, "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", "Lni/shikatu/kotlin/ULong;", "append-VKZWuLQ$kotlinx_serialization_core", "(J)V", "build", "build-Y2RjT0g$kotlinx_serialization_core", "()[J", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public final class ULongArrayBuilder extends PrimitiveArrayBuilder<ULongArray> {
    private long[] buffer;
    private int position;

    public  ULongArrayBuilder(long[] jArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr);
    }

    private ULongArrayBuilder(long[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = ULongArray.m241getSizeimpl(bufferWithData);
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override
    public /* bridge */  ULongArray build$kotlinx_serialization_core() {
        return ULongArray.m233boximpl(m1564buildY2RjT0g$kotlinx_serialization_core());
    }

    @Override
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    @Override
    public void ensureCapacity$kotlinx_serialization_core(int requiredCapacity) {
        if (ULongArray.m241getSizeimpl(this.buffer) < requiredCapacity) {
            long[] jArrCopyOf = Arrays.copyOf(this.buffer, RangesKt.coerceAtLeast(requiredCapacity, ULongArray.m241getSizeimpl(this.buffer) * 2));
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.buffer = ULongArray.m235constructorimpl(jArrCopyOf);
        }
    }

    public final void m1563appendVKZWuLQ$kotlinx_serialization_core(long c) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        long[] jArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        ULongArray.m245setk8EXiF4(jArr, position$kotlinx_serialization_core, c);
    }

    public long[] m1564buildY2RjT0g$kotlinx_serialization_core() {
        long[] jArrCopyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.m235constructorimpl(jArrCopyOf);
    }
}
