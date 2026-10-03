package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonLiteral;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001a7\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0080\u0080\u0004¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"readJson", "T", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "element", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "readPolymorphicJson", "discriminator", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TreeJsonDecoderKt {
    @JsonFriendModuleApi
    public static final <T> T readJson(Json json, JsonElement jsonElement, DeserializationStrategy<? extends T> deserializationStrategy) {
        JsonPrimitiveDecoder jsonPrimitiveDecoder;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        if (jsonElement instanceof JsonObject) {
            jsonPrimitiveDecoder = new JsonTreeDecoder(json, (JsonObject) jsonElement, null, null, 12, null);
        } else if (jsonElement instanceof JsonArray) {
            jsonPrimitiveDecoder = new JsonTreeListDecoder(json, (JsonArray) jsonElement);
        } else {
            if (!(jsonElement instanceof JsonLiteral) && !Intrinsics.areEqual(jsonElement, JsonNull.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            jsonPrimitiveDecoder = new JsonPrimitiveDecoder(json, (JsonPrimitive) jsonElement, null, 4, null);
        }
        return (T) jsonPrimitiveDecoder.decodeSerializableValue(deserializationStrategy);
    }

    public static final <T> T readPolymorphicJson(Json json, String str, JsonObject jsonObject, DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(str, "discriminator");
        Intrinsics.checkNotNullParameter(jsonObject, "element");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return (T) new JsonTreeDecoder(json, jsonObject, str, deserializationStrategy.getDescriptor()).decodeSerializableValue(deserializationStrategy);
    }
}
