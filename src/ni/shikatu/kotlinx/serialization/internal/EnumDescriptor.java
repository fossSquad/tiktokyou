package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0080\u0004J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001a\u00020\u0003H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0005H\u0096\u0080\u0004R\u0015\u0010\b\u001a\u00020\tX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\n¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/EnumDescriptor;", "Lni/shikatu/kotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementDescriptors", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors$delegate", "Lni/shikatu/kotlin/Lazy;", "getElementDescriptor", "index", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "hashCode", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    private final Lazy elementDescriptors$delegate;
    private final SerialKind kind;

    public EnumDescriptor(final String name, final int elementsCount) {
        super(name, null, elementsCount, 2, null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.kind = SerialKind.ENUM.INSTANCE;
        this.elementDescriptors$delegate = LazyKt.lazy(new Function0() {
            @Override
            public final Object invoke() {
                return EnumDescriptor.elementDescriptors_delegate$lambda$0(elementsCount, name, this);
            }
        });
    }

    @Override
    public SerialKind getKind() {
        return this.kind;
    }

    private final SerialDescriptor[] getElementDescriptors() {
        return (SerialDescriptor[]) this.elementDescriptors$delegate.getValue();
    }

    public static final SerialDescriptor[] elementDescriptors_delegate$lambda$0(int $elementsCount, String $name, EnumDescriptor this$0) {
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[$elementsCount];
        for (int i = 0; i < $elementsCount; i++) {
            serialDescriptorArr[i] = SerialDescriptorsKt.buildSerialDescriptor$default($name + '.' + this$0.getElementName(i), StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], null, 8, null);
        }
        return serialDescriptorArr;
    }

    @Override
    public SerialDescriptor getElementDescriptor(int index) {
        return getElementDescriptors()[index];
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof SerialDescriptor) && ((SerialDescriptor) other).getKind() == SerialKind.ENUM.INSTANCE && Intrinsics.areEqual(getSerialName(), ((SerialDescriptor) other).getSerialName()) && Intrinsics.areEqual(Platform_commonKt.cachedSerialNames(this), Platform_commonKt.cachedSerialNames((SerialDescriptor) other))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return CollectionsKt.joinToString$default(SerialDescriptorKt.getElementNames(this), ", ", getSerialName() + '(', ")", 0, null, null, 56, null);
    }

    @Override
    public int hashCode() {
        int result = getSerialName().hashCode();
        int accumulator$iv$iv = 1;
        for (Object element$iv$iv : SerialDescriptorKt.getElementNames(this)) {
            int hash$iv = accumulator$iv$iv;
            String it = (String) element$iv$iv;
            accumulator$iv$iv = (hash$iv * 31) + (it != null ? it.hashCode() : 0);
        }
        return (result * 31) + accumulator$iv$iv;
    }
}
