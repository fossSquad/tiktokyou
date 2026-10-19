package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.MissingFieldException;
import ni.shikatu.kotlinx.serialization.PolymorphicSerializerKt;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.encoding.AbstractDecoder;
import ni.shikatu.kotlinx.serialization.encoding.ChunkedDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import ni.shikatu.kotlinx.serialization.internal.JsonInternalDependenciesKt;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonDecoder;
import ni.shikatu.kotlinx.serialization.json.JsonDecodingException;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB3\bF\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082\u0080\u0004J\n\u0010 \u001a\u00020!H\u0096\u0080\u0004J#\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0096\u0080\u0004¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020(2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010)\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010+\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000bH\u0082\u0080\u0004J\n\u0010,\u001a\u00020\u0013H\u0096\u0080\u0004J\f\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0080\u0004J\n\u0010/\u001a\u00020*H\u0082\u0080\u0004J=\u00100\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%2\b\u00102\u001a\u0004\u0018\u0001H#H\u0096\u0080\u0004¢\u0006\u0002\u00103J\u0012\u00104\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u00105\u001a\u00020\u001bH\u0082\u0080\u0004J\u001a\u00106\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001bH\u0082\u0080\u0004J\u0012\u00107\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0082\u0080\u0004J\u001a\u00108\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0015H\u0082\u0080\u0004J\n\u0010:\u001a\u00020\u001bH\u0082\u0080\u0004J\n\u0010;\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010<\u001a\u00020=H\u0096\u0080\u0004J\n\u0010>\u001a\u00020?H\u0096\u0080\u0004J\n\u0010@\u001a\u00020\u001bH\u0096\u0080\u0004J\n\u0010A\u001a\u00020BH\u0096\u0080\u0004J\n\u0010C\u001a\u00020DH\u0096\u0080\u0004J\n\u0010E\u001a\u00020FH\u0096\u0080\u0004J\n\u0010G\u001a\u00020HH\u0096\u0080\u0004J\n\u0010I\u001a\u00020\u0015H\u0082\u0080\u0004J\n\u0010J\u001a\u00020\u0015H\u0096\u0080\u0004J-\u0010K\u001a\u00020*2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020*0MH\u0096\u0080\u0004J\u0012\u0010Q\u001a\u00020R2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010S\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020\u000bH\u0096\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001a\u00020\u0017X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000f\u0010\u001a\u001a\u00020\u001bX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u001c\u001a\u00020\u001dX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lni/shikatu/kotlinx/serialization/json/JsonDecoder;", "Lni/shikatu/kotlinx/serialization/encoding/ChunkedDecoder;", "Lni/shikatu/kotlinx/serialization/encoding/AbstractDecoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "mode", "Lni/shikatu/kotlinx/serialization/json/internal/WriteMode;", "lexer", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "discriminatorHolder", "Lni/shikatu/kotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "trySkip", _UrlKt.FRAGMENT_ENCODE_SET, "unknownKey", _UrlKt.FRAGMENT_ENCODE_SET, "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "currentIndex", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "elementMarker", "Lni/shikatu/kotlinx/serialization/json/internal/JsonElementMarker;", "decodeJsonElement", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "decodeSerializableValue", "T", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "beginStructure", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "skipLeftoverElements", "decodeNotNullMark", "decodeNull", _UrlKt.FRAGMENT_ENCODE_SET, "checkLeadingComma", "decodeSerializableElement", "index", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeElementIndex", "decodeMapIndex", "coerceInputValue", "decodeObjectIndex", "handleUnknown", "key", "decodeListIndex", "decodeBoolean", "decodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "decodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "decodeInt", "decodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "decodeFloat", _UrlKt.FRAGMENT_ENCODE_SET, "decodeDouble", _UrlKt.FRAGMENT_ENCODE_SET, "decodeChar", _UrlKt.FRAGMENT_ENCODE_SET, "decodeStringKey", "decodeString", "decodeStringChunked", "consumeChunk", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "name", "chunk", "decodeInline", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "decodeEnum", "enumDescriptor", "DiscriminatorHolder", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder, ChunkedDecoder {
    private final JsonConfiguration configuration;
    private int currentIndex;
    private DiscriminatorHolder discriminatorHolder;
    private final JsonElementMarker elementMarker;
    private final Json json;
    public final AbstractJsonLexer lexer;
    private final WriteMode mode;
    private final SerializersModule serializersModule;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WriteMode.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StreamingJsonDecoder(Json json, WriteMode mode, AbstractJsonLexer lexer, SerialDescriptor descriptor, DiscriminatorHolder discriminatorHolder) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.json = json;
        this.mode = mode;
        this.lexer = lexer;
        this.serializersModule = this.json.getSerializersModule();
        this.currentIndex = -1;
        this.discriminatorHolder = discriminatorHolder;
        this.configuration = this.json.getConfiguration();
        this.elementMarker = this.configuration.getExplicitNulls() ? null : new JsonElementMarker(descriptor);
    }

    @Override
    public final Json getJson() {
        return this.json;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0013\bF\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", _UrlKt.FRAGMENT_ENCODE_SET, "discriminatorToSkip", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;)V", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DiscriminatorHolder {
        public String discriminatorToSkip;

        public DiscriminatorHolder(String discriminatorToSkip) {
            this.discriminatorToSkip = discriminatorToSkip;
        }
    }

    private final boolean trySkip(DiscriminatorHolder $this$trySkip, String unknownKey) {
        if ($this$trySkip == null || !Intrinsics.areEqual($this$trySkip.discriminatorToSkip, unknownKey)) {
            return false;
        }
        $this$trySkip.discriminatorToSkip = null;
        return true;
    }

    @Override
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override
    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.getConfiguration(), this.lexer).read();
    }

    @Override
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        String message;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        try {
            if ((deserializationStrategy instanceof AbstractPolymorphicSerializer) && !this.json.getConfiguration().getUseArrayPolymorphism()) {
                String strClassDiscriminator = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor(), this.json);
                String strPeekLeadingMatchingValue = this.lexer.peekLeadingMatchingValue(strClassDiscriminator, this.configuration.isLenient());
                if (strPeekLeadingMatchingValue != null) {
                    try {
                        DeserializationStrategy deserializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializationStrategy, this, strPeekLeadingMatchingValue);
                        Intrinsics.checkNotNull(deserializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
                        this.discriminatorHolder = new DiscriminatorHolder(strClassDiscriminator);
                        return (T) deserializationStrategyFindPolymorphicSerializer.deserialize(this);
                    } catch (SerializationException e) {
                        String message2 = e.getMessage();
                        Intrinsics.checkNotNull(message2);
                        String strRemoveSuffix = StringsKt.removeSuffix(StringsKt.substringBefore$default(message2, '\n', (String) null, 2, (Object) null), (CharSequence) ".");
                        String message3 = e.getMessage();
                        Intrinsics.checkNotNull(message3);
                        AbstractJsonLexer.fail$default(this.lexer, strRemoveSuffix, 0, StringsKt.substringAfter(message3, '\n', _UrlKt.FRAGMENT_ENCODE_SET), 2, null);
                        throw new KotlinNothingValueException();
                    }
                }
                StreamingJsonDecoder streamingJsonDecoder = this;
                if (!(deserializationStrategy instanceof AbstractPolymorphicSerializer) || streamingJsonDecoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
                    return deserializationStrategy.deserialize(streamingJsonDecoder);
                }
                String strClassDiscriminator2 = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor(), streamingJsonDecoder.getJson());
                JsonElement jsonElementDecodeJsonElement = streamingJsonDecoder.decodeJsonElement();
                String serialName = ((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor().getSerialName();
                if (!(jsonElementDecodeJsonElement instanceof JsonObject)) {
                    String str = "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName;
                    String path = this.lexer.path.getPath();
                    String string = streamingJsonDecoder.getJson().getConfiguration().getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonElementDecodeJsonElement.toString(), 0, 1, null).toString() : null;
                    throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, str, path, null, string), str, -1, path, string, null);
                }
                JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
                JsonElement jsonElement = (JsonElement) jsonObject.get((Object) strClassDiscriminator2);
                try {
                    DeserializationStrategy deserializationStrategyFindPolymorphicSerializer2 = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializationStrategy, streamingJsonDecoder, (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
                    Intrinsics.checkNotNull(deserializationStrategyFindPolymorphicSerializer2, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                    return (T) TreeJsonDecoderKt.readPolymorphicJson(streamingJsonDecoder.getJson(), strClassDiscriminator2, jsonObject, deserializationStrategyFindPolymorphicSerializer2);
                } catch (SerializationException e2) {
                    String message4 = e2.getMessage();
                    Intrinsics.checkNotNull(message4);
                    String string2 = streamingJsonDecoder.getJson().getConfiguration().getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonObject.toString(), 0, 1, null).toString() : null;
                    throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, message4, null, null, string2), message4, -1, null, string2, null);
                }
                message = e.getMessage();
                Intrinsics.checkNotNull(message);
                if (StringsKt.contains$default((CharSequence) message, (CharSequence) "at path", false, 2, (Object) null)) {
                    throw e;
                }
                throw JsonInternalDependenciesKt.missingFieldExceptionWithNewMessage(e, e.getMessage() + " at path: " + this.lexer.path.getPath());
            }
            return deserializationStrategy.deserialize(this);
        } catch (MissingFieldException e3) {
            message = e3.getMessage();
            Intrinsics.checkNotNull(message);
            if (StringsKt.contains$default((CharSequence) message, (CharSequence) "at path", false, 2, (Object) null)) {
                throw e3;
            }
            throw JsonInternalDependenciesKt.missingFieldExceptionWithNewMessage(e3, e3.getMessage() + " at path: " + this.lexer.path.getPath());
        }
    }

    @Override
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        StreamingJsonDecoder streamingJsonDecoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode newMode = WriteModeKt.switchMode(this.json, descriptor);
        this.lexer.path.pushDescriptor(descriptor);
        this.lexer.consumeNextToken(newMode.begin);
        checkLeadingComma();
        switch (WhenMappings.$EnumSwitchMapping$0[newMode.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return new StreamingJsonDecoder(this.json, newMode, this.lexer, descriptor, this.discriminatorHolder);
            default:
                if (this.mode != newMode || !this.json.getConfiguration().getExplicitNulls()) {
                    streamingJsonDecoder = new StreamingJsonDecoder(this.json, newMode, this.lexer, descriptor, this.discriminatorHolder);
                } else {
                    streamingJsonDecoder = this;
                }
                return streamingJsonDecoder;
        }
    }

    @Override
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor.getElementsCount() == 0 && JsonNamesMapKt.ignoreUnknownKeys(descriptor, this.json)) {
            skipLeftoverElements(descriptor);
        }
        if (this.lexer.tryConsumeComma() && !this.json.getConfiguration().getAllowTrailingComma()) {
            JsonExceptionsKt.invalidTrailingComma(this.lexer, _UrlKt.FRAGMENT_ENCODE_SET);
            throw new KotlinNothingValueException();
        }
        this.lexer.consumeNextToken(this.mode.end);
        this.lexer.path.popDescriptor();
    }

    private final void skipLeftoverElements(SerialDescriptor descriptor) {
        while (decodeElementIndex(descriptor) != -1) {
        }
    }

    @Override
    public boolean decodeNotNullMark() {
        JsonElementMarker jsonElementMarker = this.elementMarker;
        return ((jsonElementMarker != null ? jsonElementMarker.isUnmarkedNull$kotlinx_serialization_json() : false) || AbstractJsonLexer.tryConsumeNull$default(this.lexer, false, 1, null)) ? false : true;
    }

    @Override
    public Void decodeNull() {
        return null;
    }

    private final void checkLeadingComma() {
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<? extends T> deserializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        boolean z = this.mode == WriteMode.MAP && (i & 1) == 0;
        if (z) {
            this.lexer.path.resetCurrentMapKey();
        }
        T t2 = (T) super.decodeSerializableElement(serialDescriptor, i, deserializationStrategy, t);
        if (z) {
            this.lexer.path.updateCurrentMapKey(t2);
        }
        return t2;
    }

    @Override
    public int decodeElementIndex(SerialDescriptor descriptor) {
        int index;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        switch (WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()]) {
            case 2:
                index = decodeMapIndex();
                break;
            case 3:
            default:
                index = decodeListIndex();
                break;
            case 4:
                index = decodeObjectIndex(descriptor);
                break;
        }
        if (this.mode != WriteMode.MAP) {
            this.lexer.path.updateDescriptorIndex(index);
        }
        return index;
    }

    private final int decodeMapIndex() {
        boolean hasComma = false;
        boolean decodingKey = this.currentIndex % 2 != 0;
        if (decodingKey) {
            if (this.currentIndex != -1) {
                hasComma = this.lexer.tryConsumeComma();
            }
        } else {
            this.lexer.consumeNextToken(AbstractJsonLexerKt.COLON);
        }
        if (this.lexer.canConsumeValue()) {
            if (decodingKey) {
                if (this.currentIndex != -1) {
                    AbstractJsonLexer $this$iv = this.lexer;
                    boolean condition$iv = hasComma;
                    int position$iv = $this$iv.currentPosition;
                    if (!condition$iv) {
                        AbstractJsonLexer.fail$default($this$iv, "Expected comma after the key-value pair", position$iv, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer $this$iv2 = this.lexer;
                    boolean condition$iv2 = !hasComma;
                    int position$iv2 = $this$iv2.currentPosition;
                    if (!condition$iv2) {
                        AbstractJsonLexer.fail$default($this$iv2, "Unexpected leading comma", position$iv2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            this.currentIndex++;
            return this.currentIndex;
        }
        if (!hasComma || this.json.getConfiguration().getAllowTrailingComma()) {
            return -1;
        }
        JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
        throw new KotlinNothingValueException();
    }

    private final boolean coerceInputValue(SerialDescriptor descriptor, int index) {
        Json $this$tryCoerceValue$iv = this.json;
        boolean isOptional$iv = descriptor.isElementOptional(index);
        SerialDescriptor elementDescriptor$iv = descriptor.getElementDescriptor(index);
        if (isOptional$iv && !elementDescriptor$iv.isNullable()) {
            boolean it = this.lexer.tryConsumeNull(true);
            if (it) {
                return true;
            }
        }
        if (Intrinsics.areEqual(elementDescriptor$iv.getKind(), SerialKind.ENUM.INSTANCE)) {
            if (elementDescriptor$iv.isNullable()) {
                boolean it2 = this.lexer.tryConsumeNull(false);
                if (it2) {
                    return false;
                }
            }
            String enumValue$iv = this.lexer.peekString(this.configuration.isLenient());
            if (enumValue$iv == null) {
                return false;
            }
            int enumIndex$iv = JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue$iv, enumValue$iv);
            boolean coerceToNull$iv = !$this$tryCoerceValue$iv.getConfiguration().getExplicitNulls() && elementDescriptor$iv.isNullable();
            if (enumIndex$iv == -3 && (isOptional$iv || coerceToNull$iv)) {
                this.lexer.consumeString();
                return true;
            }
        }
        return false;
    }

    private final int decodeObjectIndex(SerialDescriptor descriptor) {
        boolean hasComma = this.lexer.tryConsumeComma();
        while (true) {
            boolean isUnknown = true;
            if (this.lexer.canConsumeValue()) {
                hasComma = false;
                String key = decodeStringKey();
                this.lexer.consumeNextToken(AbstractJsonLexerKt.COLON);
                int index = JsonNamesMapKt.getJsonNameIndex(descriptor, this.json, key);
                if (index != -3) {
                    if (this.configuration.getCoerceInputValues() && coerceInputValue(descriptor, index)) {
                        hasComma = this.lexer.tryConsumeComma();
                        isUnknown = false;
                    } else {
                        JsonElementMarker jsonElementMarker = this.elementMarker;
                        if (jsonElementMarker != null) {
                            jsonElementMarker.mark$kotlinx_serialization_json(index);
                        }
                        return index;
                    }
                }
                if (isUnknown) {
                    hasComma = handleUnknown(descriptor, key);
                }
            } else {
                if (hasComma && !this.json.getConfiguration().getAllowTrailingComma()) {
                    JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                    throw new KotlinNothingValueException();
                }
                JsonElementMarker jsonElementMarker2 = this.elementMarker;
                if (jsonElementMarker2 != null) {
                    return jsonElementMarker2.nextUnmarkedIndex$kotlinx_serialization_json();
                }
                return -1;
            }
        }
    }

    private final boolean handleUnknown(SerialDescriptor descriptor, String key) {
        if (JsonNamesMapKt.ignoreUnknownKeys(descriptor, this.json) || trySkip(this.discriminatorHolder, key)) {
            this.lexer.skipElement(this.configuration.isLenient());
        } else {
            this.lexer.path.popDescriptor();
            this.lexer.failOnUnknownKey(key);
        }
        return this.lexer.tryConsumeComma();
    }

    private final int decodeListIndex() {
        boolean hasComma = this.lexer.tryConsumeComma();
        if (this.lexer.canConsumeValue()) {
            if (this.currentIndex == -1 || hasComma) {
                this.currentIndex++;
                return this.currentIndex;
            }
            AbstractJsonLexer.fail$default(this.lexer, "Expected end of the array or comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (!hasComma || this.json.getConfiguration().getAllowTrailingComma()) {
            return -1;
        }
        JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean decodeBoolean() {
        return this.lexer.consumeBooleanLenient();
    }

    @Override
    public byte decodeByte() {
        long value = this.lexer.consumeNumericLiteral();
        if (value != ((byte) value)) {
            AbstractJsonLexer.fail$default(this.lexer, "Failed to parse byte for input '" + value + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return (byte) value;
    }

    @Override
    public short decodeShort() {
        long value = this.lexer.consumeNumericLiteral();
        if (value != ((short) value)) {
            AbstractJsonLexer.fail$default(this.lexer, "Failed to parse short for input '" + value + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return (short) value;
    }

    @Override
    public int decodeInt() {
        long value = this.lexer.consumeNumericLiteral();
        if (value != ((int) value)) {
            AbstractJsonLexer.fail$default(this.lexer, "Failed to parse int for input '" + value + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return (int) value;
    }

    @Override
    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    @Override
    public float decodeFloat() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            float result = Float.parseFloat(input$iv);
            boolean specialFp = this.json.getConfiguration().getAllowSpecialFloatingPointValues();
            if (!specialFp) {
                if (!(Math.abs(result) <= Float.MAX_VALUE)) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(result));
                    throw new KotlinNothingValueException();
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type 'float' for input '" + input$iv + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public double decodeDouble() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            double result = Double.parseDouble(input$iv);
            boolean specialFp = this.json.getConfiguration().getAllowSpecialFloatingPointValues();
            if (!specialFp) {
                if (!(Math.abs(result) <= Double.MAX_VALUE)) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(result));
                    throw new KotlinNothingValueException();
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type 'double' for input '" + input$iv + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public char decodeChar() {
        String string = this.lexer.consumeStringLenient();
        if (string.length() != 1) {
            AbstractJsonLexer.fail$default(this.lexer, "Expected single char, but got '" + string + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return string.charAt(0);
    }

    private final String decodeStringKey() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeKeyString();
    }

    @Override
    public String decodeString() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeString();
    }

    @Override
    public void decodeStringChunked(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "consumeChunk");
        this.lexer.consumeStringChunked(this.configuration.isLenient(), function1);
    }

    @Override
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(descriptor) ? new JsonDecoderForUnsignedTypes(this.lexer, this.json) : super.decodeInline(descriptor);
    }

    @Override
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(enumDescriptor, this.json, decodeString(), " at path " + this.lexer.path.getPath());
    }
}
