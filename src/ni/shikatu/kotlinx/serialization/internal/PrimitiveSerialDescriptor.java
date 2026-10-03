package ni.shikatu.kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0003H\u0096\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0003H\u0096\u0080\u0004J\u0014\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0082\u0004J\n\u0010\u001e\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u001f\u001a\u00020 H\u0082\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u00020\r8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "kind", "Lni/shikatu/kotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", _UrlKt.FRAGMENT_ENCODE_SET, "getElementDescriptor", "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "toString", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "error", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PrimitiveSerialDescriptor implements SerialDescriptor {
    private final PrimitiveKind kind;
    private final String serialName;

    public PrimitiveSerialDescriptor(String serialName, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.serialName = serialName;
        this.kind = kind;
    }

    @Override
    public String getSerialName() {
        return this.serialName;
    }

    @Override
    public PrimitiveKind getKind() {
        return this.kind;
    }

    @Override
    public int getElementsCount() {
        return 0;
    }

    @Override
    public String getElementName(int index) {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isElementOptional(int index) {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public SerialDescriptor getElementDescriptor(int index) {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public List<Annotation> getElementAnnotations(int index) {
        error();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return "PrimitiveDescriptor(" + getSerialName() + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PrimitiveSerialDescriptor) && Intrinsics.areEqual(getSerialName(), ((PrimitiveSerialDescriptor) other).getSerialName()) && Intrinsics.areEqual(getKind(), ((PrimitiveSerialDescriptor) other).getKind());
    }

    public int hashCode() {
        return getSerialName().hashCode() + (getKind().hashCode() * 31);
    }

    private final Void error() {
        throw new IllegalStateException("Primitive descriptor " + getSerialName() + " does not have elements");
    }
}
