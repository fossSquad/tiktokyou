package ni.shikatu.kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0011\bD\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0096\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\fH\u0096\u0080\u0004J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0011\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\fH\u0096\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0082\u0004J\n\u0010\u001c\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u00020\fX\u0096Ä\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0005\u001e\u001f !\"¨\u0006#"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ListLikeDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptor", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getElementDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "getElementsCount", "()I", "getElementName", _UrlKt.FRAGMENT_ENCODE_SET, "index", "getElementIndex", "name", "isElementOptional", _UrlKt.FRAGMENT_ENCODE_SET, "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", "Lni/shikatu/kotlinx/serialization/internal/ArrayClassDesc;", "Lni/shikatu/kotlinx/serialization/internal/ArrayListClassDesc;", "Lni/shikatu/kotlinx/serialization/internal/HashSetClassDesc;", "Lni/shikatu/kotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArrayDescriptor;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ListLikeDescriptor implements SerialDescriptor {
    private final SerialDescriptor elementDescriptor;
    private final int elementsCount;

    public  ListLikeDescriptor(SerialDescriptor serialDescriptor, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialDescriptor);
    }

    private ListLikeDescriptor(SerialDescriptor elementDescriptor) {
        this.elementDescriptor = elementDescriptor;
        this.elementsCount = 1;
    }

    public final SerialDescriptor getElementDescriptor() {
        return this.elementDescriptor;
    }

    @Override
    public SerialKind getKind() {
        return StructureKind.LIST.INSTANCE;
    }

    @Override
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override
    public String getElementName(int index) {
        return String.valueOf(index);
    }

    @Override
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer intOrNull = StringsKt.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override
    public boolean isElementOptional(int index) {
        if (index >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override
    public List<Annotation> getElementAnnotations(int index) {
        if (!(index >= 0)) {
            throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
        }
        return CollectionsKt.emptyList();
    }

    @Override
    public SerialDescriptor getElementDescriptor(int index) {
        if (!(index >= 0)) {
            throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
        }
        return this.elementDescriptor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ListLikeDescriptor) && Intrinsics.areEqual(this.elementDescriptor, ((ListLikeDescriptor) other).elementDescriptor) && Intrinsics.areEqual(getSerialName(), ((ListLikeDescriptor) other).getSerialName());
    }

    public int hashCode() {
        return (this.elementDescriptor.hashCode() * 31) + getSerialName().hashCode();
    }

    public String toString() {
        return getSerialName() + '(' + this.elementDescriptor + ')';
    }
}
