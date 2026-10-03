package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonElementSerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "<init>", "()V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonElementSerializer implements KSerializer<JsonElement> {
    public static final JsonElementSerializer INSTANCE = new JsonElementSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildSerialDescriptor("ni.shikatu.kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1() {
        @Override
        public final Object invoke(Object obj) {
            return JsonElementSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
        }
    });

    private JsonElementSerializer() {
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "JsonPrimitive", JsonElementSerializersKt.defer(new Function0() {
            @Override
            public final Object invoke() {
                return JsonElementSerializer.descriptor$lambda$0$0();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "JsonNull", JsonElementSerializersKt.defer(new Function0() {
            @Override
            public final Object invoke() {
                return JsonElementSerializer.descriptor$lambda$0$1();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "JsonLiteral", JsonElementSerializersKt.defer(new Function0() {
            @Override
            public final Object invoke() {
                return JsonElementSerializer.descriptor$lambda$0$2();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "JsonObject", JsonElementSerializersKt.defer(new Function0() {
            @Override
            public final Object invoke() {
                return JsonElementSerializer.descriptor$lambda$0$3();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "JsonArray", JsonElementSerializersKt.defer(new Function0() {
            @Override
            public final Object invoke() {
                return JsonElementSerializer.descriptor$lambda$0$4();
            }
        }), null, false, 12, null);
        return Unit.INSTANCE;
    }

    public static final SerialDescriptor descriptor$lambda$0$0() {
        return JsonPrimitiveSerializer.INSTANCE.getDescriptor();
    }

    public static final SerialDescriptor descriptor$lambda$0$1() {
        return JsonNullSerializer.INSTANCE.getDescriptor();
    }

    public static final SerialDescriptor descriptor$lambda$0$2() {
        return JsonLiteralSerializer.INSTANCE.getDescriptor();
    }

    public static final SerialDescriptor descriptor$lambda$0$3() {
        return JsonObjectSerializer.INSTANCE.getDescriptor();
    }

    public static final SerialDescriptor descriptor$lambda$0$4() {
        return JsonArraySerializer.INSTANCE.getDescriptor();
    }

    @Override
    public void serialize(Encoder encoder, JsonElement value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.verify(encoder);
        if (!(value instanceof JsonPrimitive)) {
            if (!(value instanceof JsonObject)) {
                if (!(value instanceof JsonArray)) {
                    throw new NoWhenBranchMatchedException();
                }
                encoder.encodeSerializableValue((ni.shikatu.kotlinx.serialization.SerializationStrategy) JsonArraySerializer.INSTANCE, value);
                return;
            }
            encoder.encodeSerializableValue((ni.shikatu.kotlinx.serialization.SerializationStrategy) JsonObjectSerializer.INSTANCE, value);
            return;
        }
        encoder.encodeSerializableValue((ni.shikatu.kotlinx.serialization.SerializationStrategy) JsonPrimitiveSerializer.INSTANCE, value);
    }

    @Override
    public JsonElement deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder input = JsonElementSerializersKt.asJsonDecoder(decoder);
        return input.decodeJsonElement();
    }
}
