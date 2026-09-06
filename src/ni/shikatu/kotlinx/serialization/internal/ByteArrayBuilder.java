package ni.shikatu.kotlinx.serialization.internal;

import java.util.Arrays;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b@\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0090\u0080\u0004¢\u0006\u0002\b\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\u0080\u0004¢\u0006\u0002\b\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0090\u0080\u0004¢\u0006\u0002\b\u0015R\u000f\u0010\u0006\u001a\u00020\u0002X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u0090\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ByteArrayBuilder;", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArrayBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "bufferWithData", "<init>", "([B)V", "buffer", "value", _UrlKt.FRAGMENT_ENCODE_SET, "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", _UrlKt.FRAGMENT_ENCODE_SET, "append$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ByteArrayBuilder extends PrimitiveArrayBuilder<byte[]> {
    private byte[] buffer;
    private int position;

    public ByteArrayBuilder(byte[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = bufferWithData.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    @Override
    public void ensureCapacity$kotlinx_serialization_core(int requiredCapacity) {
        if (this.buffer.length < requiredCapacity) {
            byte[] bArrCopyOf = Arrays.copyOf(this.buffer, RangesKt.coerceAtLeast(requiredCapacity, this.buffer.length * 2));
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            this.buffer = bArrCopyOf;
        }
    }

    public final void append$kotlinx_serialization_core(byte c) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        byte[] bArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        bArr[position$kotlinx_serialization_core] = c;
    }

    @Override
    public byte[] build$kotlinx_serialization_core() {
        byte[] bArrCopyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }
}
