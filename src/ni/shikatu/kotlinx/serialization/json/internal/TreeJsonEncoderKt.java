package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonDecoder;
import ni.shikatu.kotlinx.serialization.json.JsonDecodingException;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001a@\u0010\u0010\u001a\u0002H\u0002\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0019\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u000f\u0010\u000e\u001a\u00020\u000fX\u0080Ô\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"writeJson", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "T", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "value", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Lkotlinx/serialization/json/JsonElement;", "requiresTopLevelTag", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getRequiresTopLevelTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "PRIMITIVE_TAG", _UrlKt.FRAGMENT_ENCODE_SET, "cast", "Lni/shikatu/kotlinx/serialization/json/JsonDecoder;", "serialName", "path", "Lni/shikatu/kotlin/Function0;", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lkotlinx/serialization/json/JsonElement;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TreeJsonEncoderKt {
    public static final String PRIMITIVE_TAG = "primitive";

    @JsonFriendModuleApi
    public static final <T> JsonElement writeJson(Json json, T t, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        new JsonTreeEncoder(json, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return TreeJsonEncoderKt.writeJson$lambda$0(objectRef, (JsonElement) obj);
            }
        }).encodeSerializableValue(serializationStrategy, t);
        if (objectRef.element != null) {
            return (JsonElement) objectRef.element;
        }
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    }

    public static final Unit writeJson$lambda$0(Ref.ObjectRef $result, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "it");
        $result.element = jsonElement;
        return Unit.INSTANCE;
    }

    public static final boolean getRequiresTopLevelTag(SerialDescriptor $this$requiresTopLevelTag) {
        return ($this$requiresTopLevelTag.getKind() instanceof PrimitiveKind) || $this$requiresTopLevelTag.getKind() == SerialKind.ENUM.INSTANCE;
    }

    public static final  <T extends JsonElement> T cast(JsonDecoder $this$cast, JsonElement jsonElement, String serialName, Function0<String> function0) {
        Intrinsics.checkNotNullParameter($this$cast, "<this>");
        Intrinsics.checkNotNullParameter(jsonElement, "value");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(function0, "path");
        Intrinsics.reifiedOperationMarker(3, "T");
        if (jsonElement instanceof JsonElement) {
            return jsonElement;
        }
        StringBuilder sbAppend = new StringBuilder().append("Expected ");
        Intrinsics.reifiedOperationMarker(4, "T");
        String shortMessage$iv = sbAppend.append(Reflection.getOrCreateKotlinClass(JsonElement.class).getSimpleName()).append(", but had ").append(Reflection.getOrCreateKotlinClass(jsonElement.getClass()).getSimpleName()).append(" as the serialized body of ").append(serialName).toString();
        String path$iv = function0.invoke();
        JsonConfiguration $this$ifDebugInput$iv$iv = $this$cast.getJson().getConfiguration();
        String inputValue$iv = $this$ifDebugInput$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonElement.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv, path$iv, null, inputValue$iv), shortMessage$iv, -1, path$iv, inputValue$iv, null);
    }
}
