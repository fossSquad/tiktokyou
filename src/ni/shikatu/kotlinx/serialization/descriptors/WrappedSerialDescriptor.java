package ni.shikatu.kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0082\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0003H\u0096\u0080\u0004J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0096\u0081\u0004J\u0012\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000eH\u0096\u0081\u0004J\u0012\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0081\u0004J\u0012\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000eH\u0096\u0081\u0004J\u0012\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000eH\u0096\u0081\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000f\u0010\u0004\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u00020\u000eX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u001f\u001a\u00020\n8VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0015\u0010!\u001a\u00020\n8VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0013\u0010\"\u001a\u00020#X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lni/shikatu/kotlinx/serialization/descriptors/WrappedSerialDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "original", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getSerialName", "()Ljava/lang/String;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "()Z", "isNullable", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WrappedSerialDescriptor implements SerialDescriptor {
    private final SerialDescriptor original;
    private final String serialName;

    @Override
    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    @Override
    public List<Annotation> getElementAnnotations(int i) {
        return this.original.getElementAnnotations(i);
    }

    @Override
    public SerialDescriptor getElementDescriptor(int i) {
        return this.original.getElementDescriptor(i);
    }

    @Override
    public int getElementIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.original.getElementIndex(str);
    }

    @Override
    public String getElementName(int i) {
        return this.original.getElementName(i);
    }

    @Override
    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override
    public SerialKind getKind() {
        return this.original.getKind();
    }

    @Override
    public boolean isElementOptional(int i) {
        return this.original.isElementOptional(i);
    }

    @Override
    public boolean isInline() {
        return this.original.isInline();
    }

    @Override
    public boolean isNullable() {
        return this.original.isNullable();
    }

    public WrappedSerialDescriptor(String serialName, SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(original, "original");
        this.serialName = serialName;
        this.original = original;
    }

    @Override
    public String getSerialName() {
        return this.serialName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WrappedSerialDescriptor) {
            return Intrinsics.areEqual(getSerialName(), ((WrappedSerialDescriptor) other).getSerialName()) && Intrinsics.areEqual(this.original, ((WrappedSerialDescriptor) other).original);
        }
        return false;
    }

    public int hashCode() {
        int result = getSerialName().hashCode();
        return (result * 31) + this.original.hashCode();
    }

    public String toString() {
        return PluginGeneratedSerialDescriptorKt.toStringImpl(this);
    }
}
