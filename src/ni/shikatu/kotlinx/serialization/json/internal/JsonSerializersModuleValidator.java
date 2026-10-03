package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.json.ClassDiscriminatorMode;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.modules.SerializersModuleCollector;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JS\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2/\u0010\u000f\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010H\u0096\u0080\u0004JH\u0010\u0016\u001a\u00020\n\"\b\b\u0000\u0010\u0017*\u00020\f\"\b\b\u0001\u0010\u0018*\u0002H\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0012H\u0096\u0080\u0004J\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0082\u0080\u0004JM\u0010\u001f\u001a\u00020\n\"\b\b\u0000\u0010\u0017*\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000e2)\u0010 \u001a%\u0012\u0013\u0012\u0011H\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(!\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\"0\u0010H\u0096\u0080\u0004JO\u0010#\u001a\u00020\n\"\b\b\u0000\u0010\u0017*\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000e2+\u0010$\u001a'\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(&\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010'0\u0010H\u0096\u0080\u0004R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonSerializersModuleValidator;", "Lni/shikatu/kotlinx/serialization/modules/SerializersModuleCollector;", "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;)V", "useArrayPolymorphism", _UrlKt.FRAGMENT_ENCODE_SET, "isDiscriminatorRequired", "contextual", _UrlKt.FRAGMENT_ENCODE_SET, "T", _UrlKt.FRAGMENT_ENCODE_SET, "kClass", "Lni/shikatu/kotlin/reflect/KClass;", "provider", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/ParameterName;", "name", "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "checkKind", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", _UrlKt.FRAGMENT_ENCODE_SET, "className", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonSerializersModuleValidator implements SerializersModuleCollector {
    private final boolean isDiscriminatorRequired;
    private final boolean useArrayPolymorphism;

    public JsonSerializersModuleValidator(JsonConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.useArrayPolymorphism = configuration.getUseArrayPolymorphism();
        this.isDiscriminatorRequired = configuration.getClassDiscriminatorMode() != ClassDiscriminatorMode.NONE;
    }

    @Override
    public <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(function1, "provider");
    }

    @Override
    public <Base, Sub extends Base> void polymorphic(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "actualClass");
        Intrinsics.checkNotNullParameter(kSerializer, "actualSerializer");
        SerialDescriptor descriptor = kSerializer.getDescriptor();
        checkKind(descriptor, kClass2);
    }

    private final void checkKind(SerialDescriptor descriptor, KClass<?> kClass) {
        SerialKind kind = descriptor.getKind();
        if ((kind instanceof PolymorphicKind) || Intrinsics.areEqual(kind, SerialKind.CONTEXTUAL.INSTANCE)) {
            throw new IllegalArgumentException("Serializer for " + kClass.getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (!this.useArrayPolymorphism && this.isDiscriminatorRequired) {
            if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) || Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE) || (kind instanceof PrimitiveKind) || (kind instanceof SerialKind.ENUM)) {
                throw new IllegalArgumentException("Serializer for " + kClass.getSimpleName() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
            }
        }
    }

    @Override
    public <Base> void polymorphicDefaultSerializer(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
    }

    @Override
    public <Base> void polymorphicDefaultDeserializer(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
    }
}
