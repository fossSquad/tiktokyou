package ni.shikatu.kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.ContextAwareKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.Platform_commonKt;
import ni.shikatu.kotlinx.serialization.internal.PluginHelperInterfacesKt;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B9\bF\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\b¢\u0006\u0004\b\t\u0010\nB\u0017\bV\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0082\u0080\u0004J\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004¢\u0006\u0002\u0010\u001dR\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0010\u001a\u00020\u0011X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlinx/serialization/ContextualSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/KSerializer;", "serializableClass", "Lni/shikatu/kotlin/reflect/KClass;", "fallbackSerializer", "typeArgumentsSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;[Lkotlinx/serialization/KSerializer;)V", "(Lkotlin/reflect/KClass;)V", _UrlKt.FRAGMENT_ENCODE_SET, "serializer", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public final class ContextualSerializer<T> implements KSerializer<T> {
    private final SerialDescriptor descriptor;
    private final KSerializer<T> fallbackSerializer;
    private final KClass<T> serializableClass;
    private final List<KSerializer<?>> typeArgumentsSerializers;

    public ContextualSerializer(KClass<T> kClass, KSerializer<T> kSerializer, KSerializer<?>[] kSerializerArr) {
        Intrinsics.checkNotNullParameter(kClass, "serializableClass");
        Intrinsics.checkNotNullParameter(kSerializerArr, "typeArgumentsSerializers");
        this.serializableClass = kClass;
        this.fallbackSerializer = kSerializer;
        this.typeArgumentsSerializers = ArraysKt.asList(kSerializerArr);
        this.descriptor = ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("ni.shikatu.kotlinx.serialization.ContextualSerializer", SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return ContextualSerializer.descriptor$lambda$0(this.f$0, (ClassSerialDescriptorBuilder) obj);
            }
        }), this.serializableClass);
    }

    private final KSerializer<T> serializer(SerializersModule serializersModule) {
        KSerializer<T> contextual = serializersModule.getContextual(this.serializableClass, this.typeArgumentsSerializers);
        if (contextual != null || (contextual = this.fallbackSerializer) != null) {
            return contextual;
        }
        Platform_commonKt.serializerNotRegistered(this.serializableClass);
        throw new KotlinNothingValueException();
    }

    public ContextualSerializer(KClass<T> kClass) {
        this(kClass, null, PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY);
        Intrinsics.checkNotNullParameter(kClass, "serializableClass");
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public static final Unit descriptor$lambda$0(ContextualSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        SerialDescriptor descriptor;
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        KSerializer<T> kSerializer = this$0.fallbackSerializer;
        List<Annotation> annotations = (kSerializer == null || (descriptor = kSerializer.getDescriptor()) == null) ? null : descriptor.getAnnotations();
        if (annotations == null) {
            annotations = CollectionsKt.emptyList();
        }
        $this$buildSerialDescriptor.setAnnotations(annotations);
        return Unit.INSTANCE;
    }

    @Override
    public void serialize(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        encoder.encodeSerializableValue(serializer(encoder.getSerializersModule()), t);
    }

    @Override
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return (T) decoder.decodeSerializableValue(serializer(decoder.getSerializersModule()));
    }
}
