package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0080\u0004\u001a:\u0010\t\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\r¢\u0006\u0002\b\u000eH\u0082\u0088\u0004¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"decodeStringToJsonTree", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "T", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "source", _UrlKt.FRAGMENT_ENCODE_SET, "parseString", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "expectedType", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StreamingJsonDecoderKt {
    @JsonFriendModuleApi
    public static final <T> JsonElement decodeStringToJsonTree(Json json, DeserializationStrategy<? extends T> deserializationStrategy, String source) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(source, "source");
        StringJsonLexer lexer = StringJsonLexerKt.StringJsonLexer(json, source);
        StreamingJsonDecoder input = new StreamingJsonDecoder(json, WriteMode.OBJ, lexer, deserializationStrategy.getDescriptor(), null);
        JsonElement tree = input.decodeJsonElement();
        lexer.expectEof();
        return tree;
    }

    private static final <T> T parseString(AbstractJsonLexer $this$parseString, String expectedType, Function1<? super String, ? extends T> function1) {
        String input = $this$parseString.consumeStringLenient();
        try {
            return function1.invoke(input);
        } catch (IllegalArgumentException e) {
            AbstractJsonLexer.fail$default($this$parseString, "Failed to parse type '" + expectedType + "' for input '" + input + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
