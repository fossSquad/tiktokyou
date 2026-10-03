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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B!\bD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0096\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0003H\u0096\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0012H\u0096\u0080\u0004J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0016\u001a\u00020\u0012H\u0096\u0080\u0004J\u0012\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0012H\u0096\u0080\u0004J\u0014\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0082\u0004J\n\u0010\"\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010#\u001a\u00020\u0003H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00020\u0012X\u0096Ä\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0002$%¨\u0006&"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/MapLikeDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "keyDescriptor", "valueDescriptor", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getSerialName", "()Ljava/lang/String;", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getValueDescriptor", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", _UrlKt.FRAGMENT_ENCODE_SET, "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getElementDescriptor", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", "Lni/shikatu/kotlinx/serialization/internal/HashMapClassDesc;", "Lni/shikatu/kotlinx/serialization/internal/LinkedHashMapClassDesc;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MapLikeDescriptor implements SerialDescriptor {
    private final int elementsCount;
    private final SerialDescriptor keyDescriptor;
    private final String serialName;
    private final SerialDescriptor valueDescriptor;

    public  MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, serialDescriptor, serialDescriptor2);
    }

    private MapLikeDescriptor(String serialName, SerialDescriptor keyDescriptor, SerialDescriptor valueDescriptor) {
        this.serialName = serialName;
        this.keyDescriptor = keyDescriptor;
        this.valueDescriptor = valueDescriptor;
        this.elementsCount = 2;
    }

    @Override
    public String getSerialName() {
        return this.serialName;
    }

    public final SerialDescriptor getKeyDescriptor() {
        return this.keyDescriptor;
    }

    public final SerialDescriptor getValueDescriptor() {
        return this.valueDescriptor;
    }

    @Override
    public SerialKind getKind() {
        return StructureKind.MAP.INSTANCE;
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
        throw new IllegalArgumentException(name + " is not a valid map index");
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
        switch (index % 2) {
            case 0:
                return this.keyDescriptor;
            case 1:
                return this.valueDescriptor;
            default:
                throw new IllegalStateException("Unreached".toString());
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MapLikeDescriptor) && Intrinsics.areEqual(getSerialName(), ((MapLikeDescriptor) other).getSerialName()) && Intrinsics.areEqual(this.keyDescriptor, ((MapLikeDescriptor) other).keyDescriptor) && Intrinsics.areEqual(this.valueDescriptor, ((MapLikeDescriptor) other).valueDescriptor);
    }

    public int hashCode() {
        int result = getSerialName().hashCode();
        return (((result * 31) + this.keyDescriptor.hashCode()) * 31) + this.valueDescriptor.hashCode();
    }

    public String toString() {
        return getSerialName() + '(' + this.keyDescriptor + ", " + this.valueDescriptor + ')';
    }
}
