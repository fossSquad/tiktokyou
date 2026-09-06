package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.PolymorphicSerializerKt;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import ni.shikatu.kotlinx.serialization.internal.NamedValueDecoder;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonDecoder;
import ni.shikatu.kotlinx.serialization.json.JsonDecodingException;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonLiteral;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B%\bD\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u0017\u001a\u00020\u0006H\u0084\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0086\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0006H\u0096\u0080\u0004J#\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0096\u0080\u0004¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004J+\u0010'\u001a\u0002H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0086\u0088\u0004¢\u0006\u0002\u0010(J3\u0010'\u001a\u0002H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0086\u0088\u0004¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u00020-2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004J\n\u0010.\u001a\u00020/H\u0096\u0080\u0004J\u001a\u00100\u001a\u0002012\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0084\u0088\u0004JD\u00100\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u0002022\u0006\u0010*\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0019\u00104\u001a\u0015\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u0001H\u001c05¢\u0006\u0002\b6H\u0082\u0088\u0004¢\u0006\u0002\u00107J\"\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0082\u0080\u0004J\u0012\u0010<\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\bH¤\u0080\u0004J\u001a\u0010=\u001a\u00020>2\u0006\u0010*\u001a\u00020\b2\u0006\u0010?\u001a\u00020&H\u0094\u0080\u0004J\u0014\u0010@\u001a\u0004\u0018\u0001092\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010A\u001a\u00020/2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010B\u001a\u00020/2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010C\u001a\u00020D2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010E\u001a\u00020F2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010G\u001a\u00020>2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010H\u001a\u00020I2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010J\u001a\u00020K2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010L\u001a\u00020M2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010N\u001a\u00020O2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010P\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u001a\u0010Q\u001a\u00020R2\u0006\u0010*\u001a\u00020\b2\u0006\u0010S\u001a\u00020&H\u0094\u0080\u0004J\u0012\u0010T\u001a\u00020R2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00020\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168\u0004X\u0085\u0084\b¢\u0006\u0002\n\u0000\u0082\u0001\u0003UVW¨\u0006X"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lni/shikatu/kotlinx/serialization/internal/NamedValueDecoder;", "Lni/shikatu/kotlinx/serialization/json/JsonDecoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "value", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "polymorphicDiscriminator", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "getPolymorphicDiscriminator", "()Ljava/lang/String;", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "currentObject", "renderTagStack", "currentTag", "decodeJsonElement", "decodeSerializableValue", "T", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "composeName", "parentName", "childName", "beginStructure", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "cast", "(Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/JsonElement;", "serialName", "tag", "(Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "decodeNotNullMark", _UrlKt.FRAGMENT_ENCODE_SET, "getPrimitiveValue", "Lni/shikatu/kotlinx/serialization/json/JsonPrimitive;", _UrlKt.FRAGMENT_ENCODE_SET, "primitiveName", "convert", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "unparsedPrimitive", _UrlKt.FRAGMENT_ENCODE_SET, "literal", TreeJsonEncoderKt.PRIMITIVE_TAG, "currentElement", "decodeTaggedEnum", _UrlKt.FRAGMENT_ENCODE_SET, "enumDescriptor", "decodeTaggedNull", "decodeTaggedNotNullMark", "decodeTaggedBoolean", "decodeTaggedByte", _UrlKt.FRAGMENT_ENCODE_SET, "decodeTaggedShort", _UrlKt.FRAGMENT_ENCODE_SET, "decodeTaggedInt", "decodeTaggedLong", _UrlKt.FRAGMENT_ENCODE_SET, "decodeTaggedFloat", _UrlKt.FRAGMENT_ENCODE_SET, "decodeTaggedDouble", _UrlKt.FRAGMENT_ENCODE_SET, "decodeTaggedChar", _UrlKt.FRAGMENT_ENCODE_SET, "decodeTaggedString", "decodeTaggedInline", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeInline", "Lni/shikatu/kotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeDecoder;", "Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeListDecoder;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final String polymorphicDiscriminator;
    private final JsonElement value;

    public  AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement, str);
    }

    public abstract JsonElement currentElement(String str);

    private AbstractJsonTreeDecoder(Json json, JsonElement value, String polymorphicDiscriminator) {
        this.json = json;
        this.value = value;
        this.polymorphicDiscriminator = polymorphicDiscriminator;
        this.configuration = getJson().getConfiguration();
    }

    public  AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement, (i & 4) != 0 ? null : str, null);
    }

    @Override
    public Json getJson() {
        return this.json;
    }

    public JsonElement getValue() {
        return this.value;
    }

    protected final String getPolymorphicDiscriminator() {
        return this.polymorphicDiscriminator;
    }

    @Override
    public SerializersModule getSerializersModule() {
        return getJson().getSerializersModule();
    }

    protected final JsonElement currentObject() {
        JsonElement jsonElementCurrentElement;
        String it = getCurrentTagOrNull();
        return (it == null || (jsonElementCurrentElement = currentElement(it)) == null) ? getValue() : jsonElementCurrentElement;
    }

    public final String renderTagStack(String currentTag) {
        Intrinsics.checkNotNullParameter(currentTag, "currentTag");
        return renderTagStack() + '.' + currentTag;
    }

    @Override
    public JsonElement decodeJsonElement() {
        return currentObject();
    }

    @Override
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        AbstractJsonTreeDecoder abstractJsonTreeDecoder = this;
        if (!(deserializationStrategy instanceof AbstractPolymorphicSerializer) || abstractJsonTreeDecoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializationStrategy.deserialize(abstractJsonTreeDecoder);
        }
        String strClassDiscriminator = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor(), abstractJsonTreeDecoder.getJson());
        JsonElement jsonElementDecodeJsonElement = abstractJsonTreeDecoder.decodeJsonElement();
        String serialName = ((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor().getSerialName();
        String string = null;
        if (!(jsonElementDecodeJsonElement instanceof JsonObject)) {
            String str = "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName;
            String strRenderTagStack = renderTagStack();
            String string2 = abstractJsonTreeDecoder.getJson().getConfiguration().getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonElementDecodeJsonElement.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, str, strRenderTagStack, null, string2), str, -1, strRenderTagStack, string2, null);
        }
        JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) strClassDiscriminator);
        try {
            DeserializationStrategy deserializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializationStrategy, abstractJsonTreeDecoder, (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
            Intrinsics.checkNotNull(deserializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
            return (T) TreeJsonDecoderKt.readPolymorphicJson(abstractJsonTreeDecoder.getJson(), strClassDiscriminator, jsonObject, deserializationStrategyFindPolymorphicSerializer);
        } catch (SerializationException e) {
            String message = e.getMessage();
            Intrinsics.checkNotNull(message);
            if (abstractJsonTreeDecoder.getJson().getConfiguration().getExceptionsWithDebugInfo()) {
                string = JsonExceptionsKt.minify$default(jsonObject.toString(), 0, 1, null).toString();
            }
            String str2 = string;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, message, null, null, str2), message, -1, null, str2, null);
        }
    }

    @Override
    protected String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    @Override
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        CompositeDecoder jsonTreeMapDecoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonElement value$iv = currentObject();
        SerialKind kind = descriptor.getKind();
        String string = null;
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) || (kind instanceof PolymorphicKind)) {
            Json json = getJson();
            AbstractJsonTreeDecoder $this$cast$iv$iv = this;
            String serialName$iv$iv = descriptor.getSerialName();
            if (value$iv instanceof JsonArray) {
                return new JsonTreeListDecoder(json, (JsonArray) value$iv);
            }
            String shortMessage$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv$iv;
            String path$iv$iv$iv = renderTagStack();
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv = $this$cast$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv, path$iv$iv$iv, null, inputValue$iv$iv$iv), shortMessage$iv$iv$iv, -1, path$iv$iv$iv, inputValue$iv$iv$iv, null);
        }
        if (!Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            Json json2 = getJson();
            AbstractJsonTreeDecoder $this$cast$iv$iv2 = this;
            String serialName$iv$iv2 = descriptor.getSerialName();
            if (value$iv instanceof JsonObject) {
                return new JsonTreeDecoder(json2, (JsonObject) value$iv, this.polymorphicDiscriminator, null, 8, null);
            }
            String shortMessage$iv$iv$iv2 = "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv$iv2;
            String path$iv$iv$iv2 = renderTagStack();
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv2 = $this$cast$iv$iv2.getJson().getConfiguration();
            String inputValue$iv$iv$iv2 = $this$ifDebugInput$iv$iv$iv$iv2.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv2, path$iv$iv$iv2, null, inputValue$iv$iv$iv2), shortMessage$iv$iv$iv2, -1, path$iv$iv$iv2, inputValue$iv$iv$iv2, null);
        }
        Json $this$selectMapMode$iv = getJson();
        SerialDescriptor keyDescriptor$iv = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), $this$selectMapMode$iv.getSerializersModule());
        SerialKind keyKind$iv = keyDescriptor$iv.getKind();
        if ((keyKind$iv instanceof PrimitiveKind) || Intrinsics.areEqual(keyKind$iv, SerialKind.ENUM.INSTANCE)) {
            Json json3 = getJson();
            AbstractJsonTreeDecoder $this$cast$iv$iv3 = this;
            String serialName$iv$iv3 = descriptor.getSerialName();
            if (!(value$iv instanceof JsonObject)) {
                String shortMessage$iv$iv$iv3 = "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv$iv3;
                String path$iv$iv$iv3 = renderTagStack();
                JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv3 = $this$cast$iv$iv3.getJson().getConfiguration();
                String inputValue$iv$iv$iv3 = $this$ifDebugInput$iv$iv$iv$iv3.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString() : null;
                throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv3, path$iv$iv$iv3, null, inputValue$iv$iv$iv3), shortMessage$iv$iv$iv3, -1, path$iv$iv$iv3, inputValue$iv$iv$iv3, null);
            }
            jsonTreeMapDecoder = new JsonTreeMapDecoder(json3, (JsonObject) value$iv);
        } else {
            if (!$this$selectMapMode$iv.getConfiguration().getAllowStructuredMapKeys()) {
                throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor$iv);
            }
            Json json4 = getJson();
            AbstractJsonTreeDecoder $this$cast$iv$iv4 = this;
            String serialName$iv$iv4 = descriptor.getSerialName();
            if (!(value$iv instanceof JsonArray)) {
                String shortMessage$iv$iv$iv4 = "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv$iv4;
                String path$iv$iv$iv4 = renderTagStack();
                JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv4 = $this$cast$iv$iv4.getJson().getConfiguration();
                if ($this$ifDebugInput$iv$iv$iv$iv4.getExceptionsWithDebugInfo()) {
                    string = JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString();
                }
                String inputValue$iv$iv$iv4 = string;
                throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv4, path$iv$iv$iv4, null, inputValue$iv$iv$iv4), shortMessage$iv$iv$iv4, -1, path$iv$iv$iv4, inputValue$iv$iv$iv4, null);
            }
            jsonTreeMapDecoder = new JsonTreeListDecoder(json4, (JsonArray) value$iv);
        }
        return jsonTreeMapDecoder;
    }

    public final  <T extends JsonElement> T cast(JsonElement jsonElement, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(jsonElement, "value");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        AbstractJsonTreeDecoder $this$cast$iv = this;
        String serialName$iv = descriptor.getSerialName();
        Intrinsics.reifiedOperationMarker(3, "T");
        if (jsonElement instanceof JsonElement) {
            return jsonElement;
        }
        StringBuilder sbAppend = new StringBuilder().append("Expected ");
        Intrinsics.reifiedOperationMarker(4, "T");
        String shortMessage$iv$iv = sbAppend.append(Reflection.getOrCreateKotlinClass(JsonElement.class).getSimpleName()).append(", but had ").append(Reflection.getOrCreateKotlinClass(jsonElement.getClass()).getSimpleName()).append(" as the serialized body of ").append(serialName$iv).toString();
        String path$iv$iv = renderTagStack();
        JsonConfiguration $this$ifDebugInput$iv$iv$iv = $this$cast$iv.getJson().getConfiguration();
        String inputValue$iv$iv = $this$ifDebugInput$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonElement.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv, path$iv$iv, null, inputValue$iv$iv), shortMessage$iv$iv, -1, path$iv$iv, inputValue$iv$iv, null);
    }

    public final  <T extends JsonElement> T cast(JsonElement jsonElement, String serialName, String tag) {
        Intrinsics.checkNotNullParameter(jsonElement, "value");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(tag, "tag");
        AbstractJsonTreeDecoder $this$cast$iv = this;
        Intrinsics.reifiedOperationMarker(3, "T");
        if (jsonElement instanceof JsonElement) {
            return jsonElement;
        }
        StringBuilder sbAppend = new StringBuilder().append("Expected ");
        Intrinsics.reifiedOperationMarker(4, "T");
        String shortMessage$iv$iv = sbAppend.append(Reflection.getOrCreateKotlinClass(JsonElement.class).getSimpleName()).append(", but had ").append(Reflection.getOrCreateKotlinClass(jsonElement.getClass()).getSimpleName()).append(" as the serialized body of ").append(serialName).toString();
        String path$iv$iv = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv$iv = $this$cast$iv.getJson().getConfiguration();
        String inputValue$iv$iv = $this$ifDebugInput$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonElement.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv, path$iv$iv, null, inputValue$iv$iv), shortMessage$iv$iv, -1, path$iv$iv, inputValue$iv$iv, null);
    }

    @Override
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    protected final JsonPrimitive getPrimitiveValue(String tag, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonElement value$iv = currentElement(tag);
        String serialName$iv = descriptor.getSerialName();
        AbstractJsonTreeDecoder $this$cast$iv$iv = this;
        if (value$iv instanceof JsonPrimitive) {
            return (JsonPrimitive) value$iv;
        }
        String shortMessage$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv;
        String path$iv$iv$iv = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv = $this$cast$iv$iv.getJson().getConfiguration();
        String inputValue$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv, path$iv$iv$iv, null, inputValue$iv$iv$iv), shortMessage$iv$iv$iv, -1, path$iv$iv$iv, inputValue$iv$iv$iv, null);
    }

    private final <T> T getPrimitiveValue(String tag, String primitiveName, Function1<? super JsonPrimitive, ? extends T> function1) {
        JsonElement value$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv = this;
        if (!(value$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of " + primitiveName;
            String path$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv = $this$cast$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv, path$iv$iv$iv, null, inputValue$iv$iv$iv), shortMessage$iv$iv$iv, -1, path$iv$iv$iv, inputValue$iv$iv$iv, null);
        }
        JsonPrimitive literal = (JsonPrimitive) value$iv;
        try {
            T tInvoke = function1.invoke(literal);
            if (tInvoke != null) {
                return tInvoke;
            }
            unparsedPrimitive(literal, primitiveName, tag);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(literal, primitiveName, tag);
            throw new KotlinNothingValueException();
        }
    }

    private final Void unparsedPrimitive(JsonPrimitive literal, String primitive, String tag) {
        StringBuilder sb;
        String str;
        if (StringsKt.startsWith$default(primitive, "i", false, 2, (Object) null)) {
            sb = new StringBuilder();
            str = "an ";
        } else {
            sb = new StringBuilder();
            str = "a ";
        }
        String type = sb.append(str).append(primitive).toString();
        AbstractJsonTreeDecoder $this$decodingExceptionOf_u24default$iv = this;
        String shortMessage$iv = "Failed to parse literal '" + literal + "' as " + type + " value";
        String path$iv = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv = $this$decodingExceptionOf_u24default$iv.getJson().getConfiguration();
        String inputValue$iv = $this$ifDebugInput$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(currentObject().toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv, path$iv, null, inputValue$iv), shortMessage$iv, -1, path$iv, inputValue$iv, null);
    }

    @Override
    public int decodeTaggedEnum(String tag, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Json json = getJson();
        JsonElement value$iv$iv = currentElement(tag);
        String serialName$iv$iv = enumDescriptor.getSerialName();
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (value$iv$iv instanceof JsonPrimitive) {
            return JsonNamesMapKt.getJsonNameIndexOrThrow$default(enumDescriptor, json, ((JsonPrimitive) value$iv$iv).getContent(), null, 4, null);
        }
        String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv$iv;
        String path$iv$iv$iv$iv = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
        String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
    }

    @Override
    public Void decodeTaggedNull(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return null;
    }

    @Override
    public boolean decodeTaggedNotNullMark(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return currentElement(tag) != JsonNull.INSTANCE;
    }

    @Override
    public boolean decodeTaggedBoolean(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (!(value$iv$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of boolean";
            String path$iv$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
        }
        JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
        try {
            Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(literal$iv);
            if (booleanOrNull != null) {
                return booleanOrNull.booleanValue();
            }
            unparsedPrimitive(literal$iv, "boolean", tag);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(literal$iv, "boolean", tag);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public byte decodeTaggedByte(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (!(value$iv$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of byte";
            String path$iv$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
        }
        JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
        try {
            long result = JsonElementKt.parseLongImpl(literal$iv);
            Byte bValueOf = ((-128L) > result ? 1 : ((-128L) == result ? 0 : -1)) <= 0 && (result > 127L ? 1 : (result == 127L ? 0 : -1)) <= 0 ? Byte.valueOf((byte) result) : null;
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            unparsedPrimitive(literal$iv, "byte", tag);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(literal$iv, "byte", tag);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public short decodeTaggedShort(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (!(value$iv$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of short";
            String path$iv$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
        }
        JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
        try {
            long result = JsonElementKt.parseLongImpl(literal$iv);
            Short shValueOf = ((-32768L) > result ? 1 : ((-32768L) == result ? 0 : -1)) <= 0 && (result > 32767L ? 1 : (result == 32767L ? 0 : -1)) <= 0 ? Short.valueOf((short) result) : null;
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            unparsedPrimitive(literal$iv, "short", tag);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(literal$iv, "short", tag);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public int decodeTaggedInt(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (!(value$iv$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of int";
            String path$iv$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
        }
        JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
        try {
            long result = JsonElementKt.parseLongImpl(literal$iv);
            Integer numValueOf = ((-2147483648L) > result ? 1 : ((-2147483648L) == result ? 0 : -1)) <= 0 && (result > 2147483647L ? 1 : (result == 2147483647L ? 0 : -1)) <= 0 ? Integer.valueOf((int) result) : null;
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            unparsedPrimitive(literal$iv, "int", tag);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(literal$iv, "int", tag);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public long decodeTaggedLong(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (value$iv$iv instanceof JsonPrimitive) {
            JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
            try {
                return JsonElementKt.parseLongImpl(literal$iv);
            } catch (IllegalArgumentException e) {
                unparsedPrimitive(literal$iv, "long", tag);
                throw new KotlinNothingValueException();
            }
        }
        String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of long";
        String path$iv$iv$iv$iv = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
        String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
    }

    @Override
    public float decodeTaggedFloat(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (!(value$iv$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of float";
            String path$iv$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
        }
        JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
        try {
            float result = JsonElementKt.getFloat(literal$iv);
            boolean specialFp = getJson().getConfiguration().getAllowSpecialFloatingPointValues();
            if (!specialFp) {
                if (!(Math.abs(result) <= Float.MAX_VALUE)) {
                    AbstractJsonTreeDecoder $this$InvalidFloatingPointDecoded$iv = this;
                    Number value$iv = Float.valueOf(result);
                    String shortMessage$iv$iv = JsonExceptionsKt.nonFiniteFpMessage(value$iv, tag);
                    JsonConfiguration $this$ifDebugInput$iv$iv$iv = $this$InvalidFloatingPointDecoded$iv.getJson().getConfiguration();
                    String inputValue$iv$iv = $this$ifDebugInput$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(currentObject().toString(), 0, 1, null).toString() : null;
                    throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv, null, AbstractJsonLexerKt.specialFlowingValuesHint, inputValue$iv$iv), shortMessage$iv$iv, -1, null, inputValue$iv$iv, AbstractJsonLexerKt.specialFlowingValuesHint);
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(literal$iv, "float", tag);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public double decodeTaggedDouble(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (!(value$iv$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of double";
            String path$iv$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
            String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
        }
        JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
        try {
            double result = JsonElementKt.getDouble(literal$iv);
            boolean specialFp = getJson().getConfiguration().getAllowSpecialFloatingPointValues();
            if (!specialFp) {
                if (!(Math.abs(result) <= Double.MAX_VALUE)) {
                    AbstractJsonTreeDecoder $this$InvalidFloatingPointDecoded$iv = this;
                    Number value$iv = Double.valueOf(result);
                    String shortMessage$iv$iv = JsonExceptionsKt.nonFiniteFpMessage(value$iv, tag);
                    JsonConfiguration $this$ifDebugInput$iv$iv$iv = $this$InvalidFloatingPointDecoded$iv.getJson().getConfiguration();
                    String inputValue$iv$iv = $this$ifDebugInput$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(currentObject().toString(), 0, 1, null).toString() : null;
                    throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv, null, AbstractJsonLexerKt.specialFlowingValuesHint, inputValue$iv$iv), shortMessage$iv$iv, -1, null, inputValue$iv$iv, AbstractJsonLexerKt.specialFlowingValuesHint);
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(literal$iv, "double", tag);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public char decodeTaggedChar(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (value$iv$iv instanceof JsonPrimitive) {
            JsonPrimitive literal$iv = (JsonPrimitive) value$iv$iv;
            try {
                return StringsKt.single(literal$iv.getContent());
            } catch (IllegalArgumentException e) {
                unparsedPrimitive(literal$iv, "char", tag);
                throw new KotlinNothingValueException();
            }
        }
        String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of char";
        String path$iv$iv$iv$iv = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
        String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
    }

    @Override
    public String decodeTaggedString(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement value$iv = currentElement(tag);
        AbstractJsonTreeDecoder $this$cast$iv$iv = this;
        String string = null;
        if (!(value$iv instanceof JsonPrimitive)) {
            String shortMessage$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of string";
            String path$iv$iv$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv = $this$cast$iv$iv.getJson().getConfiguration();
            if ($this$ifDebugInput$iv$iv$iv$iv.getExceptionsWithDebugInfo()) {
                string = JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString();
            }
            String inputValue$iv$iv$iv = string;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv, path$iv$iv$iv, null, inputValue$iv$iv$iv), shortMessage$iv$iv$iv, -1, path$iv$iv$iv, inputValue$iv$iv$iv, null);
        }
        JsonPrimitive value = (JsonPrimitive) value$iv;
        if (!(value instanceof JsonLiteral)) {
            AbstractJsonTreeDecoder $this$decodingExceptionOf$iv = this;
            String shortMessage$iv = "Expected string value for a non-null key '" + tag + "', got null literal instead";
            String path$iv = renderTagStack(tag);
            JsonConfiguration $this$ifDebugInput$iv$iv = $this$decodingExceptionOf$iv.getJson().getConfiguration();
            String inputValue$iv = $this$ifDebugInput$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(currentObject().toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv, path$iv, AbstractJsonLexerKt.coerceInputValuesHint, inputValue$iv), shortMessage$iv, -1, path$iv, inputValue$iv, AbstractJsonLexerKt.coerceInputValuesHint);
        }
        if (((JsonLiteral) value).isString() || getJson().getConfiguration().isLenient()) {
            return ((JsonLiteral) value).getContent();
        }
        AbstractJsonTreeDecoder $this$decodingExceptionOf$iv2 = this;
        String shortMessage$iv2 = "String literal for value of key '" + tag + "' should be quoted";
        String path$iv2 = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv2 = $this$decodingExceptionOf$iv2.getJson().getConfiguration();
        String inputValue$iv2 = $this$ifDebugInput$iv$iv2.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(currentObject().toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv2, path$iv2, AbstractJsonLexerKt.lenientHint, inputValue$iv2), shortMessage$iv2, -1, path$iv2, inputValue$iv2, AbstractJsonLexerKt.lenientHint);
    }

    @Override
    public Decoder decodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (!StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor)) {
            return super.decodeTaggedInline(tag, inlineDescriptor);
        }
        Json json = getJson();
        JsonElement value$iv$iv = currentElement(tag);
        String serialName$iv$iv = inlineDescriptor.getSerialName();
        AbstractJsonTreeDecoder $this$cast$iv$iv$iv = this;
        if (value$iv$iv instanceof JsonPrimitive) {
            StringJsonLexer lexer = StringJsonLexerKt.StringJsonLexer(json, ((JsonPrimitive) value$iv$iv).getContent());
            return new JsonDecoderForUnsignedTypes(lexer, getJson());
        }
        String shortMessage$iv$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv$iv;
        String path$iv$iv$iv$iv = renderTagStack(tag);
        JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv$iv = $this$cast$iv$iv$iv.getJson().getConfiguration();
        String inputValue$iv$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv$iv.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv$iv, path$iv$iv$iv$iv, null, inputValue$iv$iv$iv$iv), shortMessage$iv$iv$iv$iv, -1, path$iv$iv$iv$iv, inputValue$iv$iv$iv$iv, null);
    }

    @Override
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return getCurrentTagOrNull() != null ? super.decodeInline(descriptor) : new JsonPrimitiveDecoder(getJson(), getValue(), this.polymorphicDiscriminator).decodeInline(descriptor);
    }
}
