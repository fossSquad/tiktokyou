package ni.shikatu.kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010\u0016\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004J\u0012\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004J\u0012\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\tH\u0096\u0081\u0004J\u0012\u0010 \u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004J\u0012\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004R\u0015\u0010\u0003\u001a\u00020\u0001X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\tX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u00020\u0018X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0015\u0010(\u001a\u00020\u00118VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b(\u0010\u0012R\u0013\u0010)\u001a\u00020*X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/SerialDescriptorForNullable;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "Lni/shikatu/kotlinx/serialization/internal/CachedNames;", "original", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getOriginal$kotlinx_serialization_core", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialName", "()Ljava/lang/String;", "serialNames", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialNames", "()Ljava/util/Set;", "isNullable", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {
    private final SerialDescriptor original;
    private final String serialName;
    private final Set<String> serialNames;

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

    public SerialDescriptorForNullable(SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
        this.serialName = this.original.getSerialName() + '?';
        this.serialNames = Platform_commonKt.cachedSerialNames(this.original);
    }

    public final SerialDescriptor getOriginal$kotlinx_serialization_core() {
        return this.original;
    }

    @Override
    public String getSerialName() {
        return this.serialName;
    }

    @Override
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    @Override
    public boolean isNullable() {
        return true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SerialDescriptorForNullable) && Intrinsics.areEqual(this.original, ((SerialDescriptorForNullable) other).original);
    }

    public String toString() {
        return new StringBuilder().append(this.original).append('?').toString();
    }

    public int hashCode() {
        return this.original.hashCode() * 31;
    }
}
