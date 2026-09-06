package ni.shikatu.kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\tH\u0096\u0080\u0004J\u0014\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0082\u0004J\n\u0010\u001e\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u001f\u001a\u00020 H\u0082\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\tX\u0096Ä\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u00020\r8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/NothingSerialDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "()V", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialName", "()Ljava/lang/String;", "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", _UrlKt.FRAGMENT_ENCODE_SET, "getElementDescriptor", "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "toString", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "error", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NothingSerialDescriptor implements SerialDescriptor {
    public static final NothingSerialDescriptor INSTANCE = new NothingSerialDescriptor();
    private static final SerialKind kind = StructureKind.OBJECT.INSTANCE;
    private static final String serialName = "ni.shikatu.kotlin.Nothing";

    private NothingSerialDescriptor() {
    }

    @Override
    public /* bridge */ List<Annotation> getAnnotations() {
        return super.getAnnotations();
    }

    @Override
    public /* bridge */ boolean isInline() {
        return super.isInline();
    }

    @Override
    public /* bridge */ boolean isNullable() {
        return super.isNullable();
    }

    @Override
    public SerialKind getKind() {
        return kind;
    }

    @Override
    public String getSerialName() {
        return serialName;
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
        return "NothingSerialDescriptor";
    }

    public boolean equals(Object other) {
        return this == other;
    }

    public int hashCode() {
        return getSerialName().hashCode() + (getKind().hashCode() * 31);
    }

    private final Void error() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }
}
