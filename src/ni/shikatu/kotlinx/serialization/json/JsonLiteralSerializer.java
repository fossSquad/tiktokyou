package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlin.text.UStringsKt;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.json.internal.JsonExceptionsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonLiteralSerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlinx/serialization/json/JsonLiteral;", "<init>", "()V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {
    public static final JsonLiteralSerializer INSTANCE = new JsonLiteralSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("ni.shikatu.kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING.INSTANCE);

    private JsonLiteralSerializer() {
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public void serialize(Encoder encoder, JsonLiteral value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.verify(encoder);
        if (value.isString()) {
            encoder.encodeString(value.getContent());
            return;
        }
        if (value.getCoerceToInlineType$kotlinx_serialization_json() != null) {
            encoder.encodeInline(value.getCoerceToInlineType$kotlinx_serialization_json()).encodeString(value.getContent());
            return;
        }
        Long longOrNull = StringsKt.toLongOrNull(value.getContent());
        if (longOrNull != null) {
            long it = longOrNull.longValue();
            encoder.encodeLong(it);
            return;
        }
        ULong uLongOrNull = UStringsKt.toULongOrNull(value.getContent());
        if (uLongOrNull != null) {
            long it2 = uLongOrNull.m232unboximpl();
            encoder.encodeInline(BuiltinSerializersKt.serializer(ULong.Companion).getDescriptor()).encodeLong(it2);
            return;
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(value.getContent());
        if (doubleOrNull != null) {
            double it3 = doubleOrNull.doubleValue();
            encoder.encodeDouble(it3);
            return;
        }
        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(value.getContent());
        if (booleanStrictOrNull != null) {
            boolean it4 = booleanStrictOrNull.booleanValue();
            encoder.encodeBoolean(it4);
        } else {
            encoder.encodeString(value.getContent());
        }
    }

    @Override
    public JsonLiteral deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = JsonElementSerializersKt.asJsonDecoder(decoder);
        JsonElement result = jsonDecoder.decodeJsonElement();
        if (result instanceof JsonLiteral) {
            return (JsonLiteral) result;
        }
        String shortMessage$iv = "Unexpected JSON element, expected JsonLiteral, had " + Reflection.getOrCreateKotlinClass(result.getClass());
        JsonConfiguration $this$ifDebugInput$iv$iv = jsonDecoder.getJson().getConfiguration();
        String inputValue$iv = $this$ifDebugInput$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(result.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv, null, null, inputValue$iv), shortMessage$iv, -1, null, inputValue$iv, null);
    }
}
