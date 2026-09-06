package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\bF\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0018\u001a\u00020\u0019H¤\u0080\u0004J\"\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0082\u0080\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\tX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonContentPolymorphicSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/KSerializer;", "baseClass", "Lni/shikatu/kotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "selectDeserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "element", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "throwSubtypeNotRegistered", _UrlKt.FRAGMENT_ENCODE_SET, "subClass", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class JsonContentPolymorphicSerializer<T> implements KSerializer<T> {
    private final KClass<T> baseClass;
    private final SerialDescriptor descriptor;

    protected abstract DeserializationStrategy<T> selectDeserializer(JsonElement jsonElement);

    public JsonContentPolymorphicSerializer(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        this.baseClass = kClass;
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor$default("JsonContentPolymorphicSerializer<" + this.baseClass.getSimpleName() + Typography.greater, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], null, 8, null);
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    public final void serialize(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        KSerializer actualSerializer = encoder.getSerializersModule().getPolymorphic(this.baseClass, t);
        if (actualSerializer == null) {
            KSerializer kSerializerSerializerOrNull = SerializersKt.serializerOrNull(Reflection.getOrCreateKotlinClass(t.getClass()));
            if (kSerializerSerializerOrNull == null) {
                throwSubtypeNotRegistered(Reflection.getOrCreateKotlinClass(t.getClass()), this.baseClass);
                throw new KotlinNothingValueException();
            }
            actualSerializer = kSerializerSerializerOrNull;
        }
        ((KSerializer) actualSerializer).serialize(encoder, t);
    }

    @Override
    public final T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoderAsJsonDecoder = JsonElementSerializersKt.asJsonDecoder(decoder);
        JsonElement jsonElementDecodeJsonElement = jsonDecoderAsJsonDecoder.decodeJsonElement();
        DeserializationStrategy<T> deserializationStrategySelectDeserializer = selectDeserializer(jsonElementDecodeJsonElement);
        Intrinsics.checkNotNull(deserializationStrategySelectDeserializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.json.JsonContentPolymorphicSerializer>");
        return (T) jsonDecoderAsJsonDecoder.getJson().decodeFromJsonElement((KSerializer) deserializationStrategySelectDeserializer, jsonElementDecodeJsonElement);
    }

    private final Void throwSubtypeNotRegistered(KClass<?> kClass, KClass<?> kClass2) {
        String subClassName = kClass.getSimpleName();
        if (subClassName == null) {
            subClassName = String.valueOf(kClass);
        }
        String scope = "in the scope of '" + kClass2.getSimpleName() + '\'';
        throw new SerializationException("Class '" + subClassName + "' is not registered for polymorphic serialization " + scope + ".\nMark the base class as 'sealed' or register the serializer explicitly.");
    }
}
