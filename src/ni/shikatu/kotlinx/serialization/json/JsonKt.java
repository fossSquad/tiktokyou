package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\u0080\u0004\u001a#\u0010\b\u001a\u00020\t\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\nH\u0086\u0088\u0004¢\u0006\u0002\u0010\f\u001a#\u0010\r\u001a\u0002H\n\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0088\u0004¢\u0006\u0002\u0010\u000f\"\u000f\u0010\u0010\u001a\u00020\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0012\u001a\u00020\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Json", "Lni/shikatu/kotlinx/serialization/json/Json;", "from", "builderAction", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/json/JsonBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "encodeToJsonElement", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "T", "value", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "decodeFromJsonElement", "json", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "defaultIndent", _UrlKt.FRAGMENT_ENCODE_SET, "defaultDiscriminator", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonKt {
    private static final String defaultDiscriminator = "type";
    private static final String defaultIndent = "    ";

    public static  Json Json$default(Json json, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            json = Json.Default;
        }
        return Json(json, function1);
    }

    public static final Json Json(Json from, Function1<? super JsonBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonBuilder builder = new JsonBuilder(from);
        function1.invoke(builder);
        JsonConfiguration conf = builder.build$kotlinx_serialization_json();
        return new JsonImpl(conf, builder.getSerializersModule());
    }

    public static final  <T> JsonElement encodeToJsonElement(Json $this$encodeToJsonElement, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToJsonElement, "<this>");
        SerializersModule serializersModule = $this$encodeToJsonElement.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return $this$encodeToJsonElement.encodeToJsonElement(SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public static final  <T> T decodeFromJsonElement(Json json, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return (T) json.decodeFromJsonElement(SerializersKt.serializer(serializersModule, (KType) null), jsonElement);
    }
}
