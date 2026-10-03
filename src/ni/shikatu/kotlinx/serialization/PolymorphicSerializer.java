package ni.shikatu.kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.LazyThreadSafetyMode;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.ContextAwareKt;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\bF\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\bQ\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0006\u0010\u000bJ\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004R\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\n¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlinx/serialization/PolymorphicSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lni/shikatu/kotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "classAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/KClass;[Ljava/lang/annotation/Annotation;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "_annotations", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lni/shikatu/kotlin/Lazy;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {
    private List<? extends Annotation> _annotations;
    private final KClass<T> baseClass;
    private final Lazy descriptor$delegate;

    public PolymorphicSerializer(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        this.baseClass = kClass;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() {
            @Override
            public final Object invoke() {
                return PolymorphicSerializer.descriptor_delegate$lambda$0(this.f$0);
            }
        });
    }

    @Override
    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    public PolymorphicSerializer(KClass<T> kClass, Annotation[] classAnnotations) {
        this(kClass);
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    public static final SerialDescriptor descriptor_delegate$lambda$0(final PolymorphicSerializer this$0) {
        return ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("ni.shikatu.kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.INSTANCE, new SerialDescriptor[0], new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return PolymorphicSerializer.descriptor_delegate$lambda$0$0(this.f$0, (ClassSerialDescriptorBuilder) obj);
            }
        }), this$0.getBaseClass());
    }

    public static final Unit descriptor_delegate$lambda$0$0(PolymorphicSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor$default("ni.shikatu.kotlinx.serialization.Polymorphic<" + this$0.getBaseClass().getSimpleName() + Typography.greater, SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
        $this$buildSerialDescriptor.setAnnotations(this$0._annotations);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "ni.shikatu.kotlinx.serialization.PolymorphicSerializer(baseClass: " + getBaseClass() + ')';
    }
}
