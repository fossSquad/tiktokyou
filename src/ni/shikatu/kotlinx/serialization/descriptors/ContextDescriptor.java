package ni.shikatu.kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0082\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\bH\u0096\u0080\u0004J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0081\u0004J\u0012\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0081\u0004J\u0012\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bH\u0096\u0081\u0004J\u0012\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0081\u0004J\u0012\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0081\u0004R\u000f\u0010\u0002\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u00020\bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u00020\u0010X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0015\u0010!\u001a\u00020\f8VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0015\u0010#\u001a\u00020\f8VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0013\u0010$\u001a\u00020%X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lni/shikatu/kotlinx/serialization/descriptors/ContextDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lni/shikatu/kotlin/reflect/KClass;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialName", "()Ljava/lang/String;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "()Z", "isNullable", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ContextDescriptor implements SerialDescriptor {
    public final KClass<?> kClass;
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

    public ContextDescriptor(SerialDescriptor original, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        this.original = original;
        this.kClass = kClass;
        this.serialName = this.original.getSerialName() + Typography.less + this.kClass.getSimpleName() + Typography.greater;
    }

    @Override
    public String getSerialName() {
        return this.serialName;
    }

    public boolean equals(Object other) {
        ContextDescriptor another = other instanceof ContextDescriptor ? (ContextDescriptor) other : null;
        return another != null && Intrinsics.areEqual(this.original, another.original) && Intrinsics.areEqual(another.kClass, this.kClass);
    }

    public int hashCode() {
        int result = this.kClass.hashCode();
        return (result * 31) + getSerialName().hashCode();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}
