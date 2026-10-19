package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.internal.InlineClassDescriptorKt;
import ni.shikatu.kotlinx.serialization.json.internal.StringJsonLexerKt;
import ni.shikatu.kotlinx.serialization.json.internal.StringOpsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0005H\u0086\u0080\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0086\u0080\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000fH\u0087\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0012H\u0086\u0080\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u00132\b\u0010\u0002\u001a\u0004\u0018\u00010\u0014H\u0086\u0080\u0004\u001a\u0014\u0010\u0015\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0012H\u0086\u0080\u0004\u001a\u0016\u0010N\u001a\u00020\u0014*\u00020\u001b2\u0006\u0010O\u001a\u00020\u0012H\u0082\u0080\u0004\u001a%\u0010P\u001a\u0004\u0018\u0001HQ\"\u0004\b\u0000\u0010Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u0002HQ0SH\u0082\u0088\u0004¢\u0006\u0002\u0010T\u001a#\u0010U\u001a\u0002HQ\"\u0004\b\u0000\u0010Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u0002HQ0SH\u0082\u0088\u0004¢\u0006\u0002\u0010T\u001a\u001a\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\u0012H\u0081\u0080\u0004\u001a\u000e\u0010Y\u001a\u000201*\u00020\u0001H\u0080\u0080\u0004\"\u0015\u0010\u0016\u001a\u00020\u0017X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0019\u0010\u001a\u001a\u00020\u0001*\u00020\u001b8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0019\u0010\u001e\u001a\u00020\u001f*\u00020\u001b8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0019\u0010\"\u001a\u00020#*\u00020\u001b8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0019\u0010&\u001a\u00020\u0013*\u00020\u001b8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0019\u0010)\u001a\u00020**\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u001b\u0010-\u001a\u0004\u0018\u00010**\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0019\u00100\u001a\u000201*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b2\u00103\"\u001b\u00104\u001a\u0004\u0018\u000101*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b5\u00106\"\u0019\u00107\u001a\u000208*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b9\u0010:\"\u001b\u0010;\u001a\u0004\u0018\u000108*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b<\u0010=\"\u0019\u0010>\u001a\u00020?*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b@\u0010A\"\u001b\u0010B\u001a\u0004\u0018\u00010?*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bC\u0010D\"\u0019\u0010E\u001a\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bF\u0010G\"\u001b\u0010H\u001a\u0004\u0018\u00010\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bI\u0010J\"\u001b\u0010K\u001a\u0004\u0018\u00010\u0012*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006Z"}, d2 = {"JsonPrimitive", "Lni/shikatu/kotlinx/serialization/json/JsonPrimitive;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UByte;", "JsonPrimitive-7apg3OU", "(B)Lkotlinx/serialization/json/JsonPrimitive;", "Lni/shikatu/kotlin/UShort;", "JsonPrimitive-xj2QHRw", "(S)Lkotlinx/serialization/json/JsonPrimitive;", "Lni/shikatu/kotlin/UInt;", "JsonPrimitive-WZ4Q5Ns", "(I)Lkotlinx/serialization/json/JsonPrimitive;", "Lni/shikatu/kotlin/ULong;", "JsonPrimitive-VKZWuLQ", "(J)Lkotlinx/serialization/json/JsonPrimitive;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/json/JsonNull;", _UrlKt.FRAGMENT_ENCODE_SET, "JsonUnquotedLiteral", "jsonUnquotedLiteralDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getJsonUnquotedLiteralDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "jsonPrimitive", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "jsonObject", "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonArray", "Lni/shikatu/kotlinx/serialization/json/JsonArray;", "getJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "jsonNull", "getJsonNull", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonNull;", "int", _UrlKt.FRAGMENT_ENCODE_SET, "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "intOrNull", "getIntOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;", "long", _UrlKt.FRAGMENT_ENCODE_SET, "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "longOrNull", "getLongOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Long;", "double", _UrlKt.FRAGMENT_ENCODE_SET, "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "doubleOrNull", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Double;", "float", _UrlKt.FRAGMENT_ENCODE_SET, "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "floatOrNull", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Float;", "boolean", "getBoolean", "(Lkotlinx/serialization/json/JsonPrimitive;)Z", "booleanOrNull", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "contentOrNull", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "error", "element", "exceptionToNull", "T", "f", "Lni/shikatu/kotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "exceptionToNumberFormatException", "unexpectedJson", "key", "expected", "parseLongImpl", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonElementKt {
    private static final SerialDescriptor jsonUnquotedLiteralDescriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("ni.shikatu.kotlinx.serialization.json.JsonUnquotedLiteral", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));

    public static final JsonPrimitive JsonPrimitive(Boolean value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, false, null, 4, null);
    }

    public static final JsonPrimitive JsonPrimitive(Number value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, false, null, 4, null);
    }

    public static final JsonPrimitive m1580JsonPrimitive7apg3OU(byte value) {
        return m1581JsonPrimitiveVKZWuLQ(ULong.m180constructorimpl(((long) value) & 255));
    }

    public static final JsonPrimitive m1583JsonPrimitivexj2QHRw(short value) {
        return m1581JsonPrimitiveVKZWuLQ(ULong.m180constructorimpl(((long) value) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    public static final JsonPrimitive m1582JsonPrimitiveWZ4Q5Ns(int value) {
        return m1581JsonPrimitiveVKZWuLQ(ULong.m180constructorimpl(((long) value) & 4294967295L));
    }

    public static final JsonPrimitive m1581JsonPrimitiveVKZWuLQ(long value) {
        return JsonUnquotedLiteral(Long.toUnsignedString(value));
    }

    public static final JsonPrimitive JsonPrimitive(String value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, true, null, 4, null);
    }

    public static final JsonNull JsonPrimitive(Void value) {
        return JsonNull.INSTANCE;
    }

    public static final JsonPrimitive JsonUnquotedLiteral(String value) {
        if (value == null) {
            return JsonNull.INSTANCE;
        }
        if (Intrinsics.areEqual(value, JsonNull.INSTANCE.getContent())) {
            throw new JsonEncodingException("Creating a literal unquoted value of 'null' is forbidden.", null, "If you want to create JSON null literal, use JsonNull object, otherwise, use JsonPrimitive", 2, null);
        }
        return new JsonLiteral(value, false, jsonUnquotedLiteralDescriptor);
    }

    public static final SerialDescriptor getJsonUnquotedLiteralDescriptor() {
        return jsonUnquotedLiteralDescriptor;
    }

    public static final JsonPrimitive getJsonPrimitive(JsonElement $this$jsonPrimitive) {
        Intrinsics.checkNotNullParameter($this$jsonPrimitive, "<this>");
        JsonPrimitive jsonPrimitive = $this$jsonPrimitive instanceof JsonPrimitive ? (JsonPrimitive) $this$jsonPrimitive : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        error($this$jsonPrimitive, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final JsonObject getJsonObject(JsonElement $this$jsonObject) {
        Intrinsics.checkNotNullParameter($this$jsonObject, "<this>");
        JsonObject jsonObject = $this$jsonObject instanceof JsonObject ? (JsonObject) $this$jsonObject : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        error($this$jsonObject, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final JsonArray getJsonArray(JsonElement $this$jsonArray) {
        Intrinsics.checkNotNullParameter($this$jsonArray, "<this>");
        JsonArray jsonArray = $this$jsonArray instanceof JsonArray ? (JsonArray) $this$jsonArray : null;
        if (jsonArray != null) {
            return jsonArray;
        }
        error($this$jsonArray, "JsonArray");
        throw new KotlinNothingValueException();
    }

    public static final JsonNull getJsonNull(JsonElement $this$jsonNull) {
        Intrinsics.checkNotNullParameter($this$jsonNull, "<this>");
        JsonNull jsonNull = $this$jsonNull instanceof JsonNull ? (JsonNull) $this$jsonNull : null;
        if (jsonNull != null) {
            return jsonNull;
        }
        error($this$jsonNull, "JsonNull");
        throw new KotlinNothingValueException();
    }

    public static final int getInt(JsonPrimitive $this$int) {
        Intrinsics.checkNotNullParameter($this$int, "<this>");
        try {
            long result = parseLongImpl($this$int);
            boolean z = false;
            if (-2147483648L <= result && result <= 2147483647L) {
                z = true;
            }
            if (!z) {
                throw new NumberFormatException($this$int.getContent() + " is not an Int");
            }
            return (int) result;
        } catch (JsonDecodingException e$iv) {
            throw new NumberFormatException(e$iv.getMessage());
        }
    }

    public static final Integer getIntOrNull(JsonPrimitive $this$intOrNull) {
        Long lValueOf;
        Intrinsics.checkNotNullParameter($this$intOrNull, "<this>");
        try {
            lValueOf = Long.valueOf(parseLongImpl($this$intOrNull));
        } catch (JsonDecodingException e) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        long result = lValueOf.longValue();
        boolean z = false;
        if (-2147483648L <= result && result <= 2147483647L) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) result);
        }
        return null;
    }

    public static final long getLong(JsonPrimitive $this$long) {
        Intrinsics.checkNotNullParameter($this$long, "<this>");
        try {
            return parseLongImpl($this$long);
        } catch (JsonDecodingException e$iv) {
            throw new NumberFormatException(e$iv.getMessage());
        }
    }

    public static final Long getLongOrNull(JsonPrimitive $this$longOrNull) {
        Intrinsics.checkNotNullParameter($this$longOrNull, "<this>");
        try {
            return Long.valueOf(parseLongImpl($this$longOrNull));
        } catch (JsonDecodingException e) {
            return null;
        }
    }

    public static final double getDouble(JsonPrimitive $this$double) {
        Intrinsics.checkNotNullParameter($this$double, "<this>");
        return Double.parseDouble($this$double.getContent());
    }

    public static final Double getDoubleOrNull(JsonPrimitive $this$doubleOrNull) {
        Intrinsics.checkNotNullParameter($this$doubleOrNull, "<this>");
        return StringsKt.toDoubleOrNull($this$doubleOrNull.getContent());
    }

    public static final float getFloat(JsonPrimitive $this$float) {
        Intrinsics.checkNotNullParameter($this$float, "<this>");
        return Float.parseFloat($this$float.getContent());
    }

    public static final Float getFloatOrNull(JsonPrimitive $this$floatOrNull) {
        Intrinsics.checkNotNullParameter($this$floatOrNull, "<this>");
        return StringsKt.toFloatOrNull($this$floatOrNull.getContent());
    }

    public static final boolean getBoolean(JsonPrimitive $this$boolean) {
        Intrinsics.checkNotNullParameter($this$boolean, "<this>");
        Boolean booleanStrictOrNull = StringOpsKt.toBooleanStrictOrNull($this$boolean.getContent());
        if (booleanStrictOrNull != null) {
            return booleanStrictOrNull.booleanValue();
        }
        throw new IllegalStateException($this$boolean + " does not represent a Boolean");
    }

    public static final Boolean getBooleanOrNull(JsonPrimitive $this$booleanOrNull) {
        Intrinsics.checkNotNullParameter($this$booleanOrNull, "<this>");
        return StringOpsKt.toBooleanStrictOrNull($this$booleanOrNull.getContent());
    }

    public static final String getContentOrNull(JsonPrimitive $this$contentOrNull) {
        Intrinsics.checkNotNullParameter($this$contentOrNull, "<this>");
        if ($this$contentOrNull instanceof JsonNull) {
            return null;
        }
        return $this$contentOrNull.getContent();
    }

    private static final Void error(JsonElement $this$error, String element) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass($this$error.getClass()) + " is not a " + element);
    }

    private static final <T> T exceptionToNull(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (JsonDecodingException e) {
            return null;
        }
    }

    private static final <T> T exceptionToNumberFormatException(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final Void unexpectedJson(String key, String expected) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(expected, "expected");
        throw new IllegalArgumentException("Element " + key + " is not a " + expected);
    }

    public static final long parseLongImpl(JsonPrimitive $this$parseLongImpl) {
        Intrinsics.checkNotNullParameter($this$parseLongImpl, "<this>");
        return StringJsonLexerKt.StringJsonLexer(Json.Default, $this$parseLongImpl.getContent()).consumeNumericLiteralFully();
    }
}
