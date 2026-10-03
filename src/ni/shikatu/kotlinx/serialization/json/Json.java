package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.kotlinx.serialization.StringFormat;
import ni.shikatu.kotlinx.serialization.json.internal.DescriptorSchemaCache;
import ni.shikatu.kotlinx.serialization.json.internal.JsonStreamsKt;
import ni.shikatu.kotlinx.serialization.json.internal.JsonToStringWriter;
import ni.shikatu.kotlinx.serialization.json.internal.StreamingJsonDecoder;
import ni.shikatu.kotlinx.serialization.json.internal.StringJsonLexer;
import ni.shikatu.kotlinx.serialization.json.internal.StringJsonLexerKt;
import ni.shikatu.kotlinx.serialization.json.internal.TreeJsonDecoderKt;
import ni.shikatu.kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import ni.shikatu.kotlinx.serialization.json.internal.WriteMode;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.kotlinx.serialization.modules.SerializersModuleBuildersKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 '2\u00020\u0001:\u0001'B\u0019\bD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u0017\u001a\u0002H\u0014H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0002\u0010\u001dJ+\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u0017\u001a\u0002H\u0014H\u0086\u0080\u0004¢\u0006\u0002\u0010 J+\u0010!\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001b2\u0006\u0010\"\u001a\u00020\u001fH\u0086\u0080\u0004¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020\u001f2\b\b\u0001\u0010\u001c\u001a\u00020\u0013H\u0086\u0080\u0004J\u001f\u0010\u0012\u001a\u00020\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0017\u001a\u0002H\u0014H\u0086\u0088\u0004¢\u0006\u0002\u0010%J!\u0010\u0019\u001a\u0002H\u0014\"\u0006\b\u0000\u0010\u0014\u0018\u00012\b\b\u0001\u0010\u001c\u001a\u00020\u0013H\u0086\u0088\u0004¢\u0006\u0002\u0010&R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u00020\r8\u0000X\u0081\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0002()¨\u0006*"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/Json;", "Lni/shikatu/kotlinx/serialization/StringFormat;", "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerializersModule;)V", "getConfiguration", "()Lkotlinx/serialization/json/JsonConfiguration;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "_schemaCache", "Lni/shikatu/kotlinx/serialization/json/internal/DescriptorSchemaCache;", "get_schemaCache$kotlinx_serialization_json$annotations", "()V", "get_schemaCache$kotlinx_serialization_json", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "encodeToString", _UrlKt.FRAGMENT_ENCODE_SET, "T", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromString", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "string", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "encodeToJsonElement", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "decodeFromJsonElement", "element", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "parseToJsonElement", "(Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;)Ljava/lang/Object;", "Default", "Lni/shikatu/kotlinx/serialization/json/Json$Default;", "Lni/shikatu/kotlinx/serialization/json/JsonImpl;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Json implements StringFormat {
    public static final Default Default = new Default(null);
    private final DescriptorSchemaCache _schemaCache;
    private final JsonConfiguration configuration;
    private final SerializersModule serializersModule;

    public  Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonConfiguration, serializersModule);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Should not be accessed directly, use Json.schemaCache accessor instead", replaceWith = @ReplaceWith(expression = "schemaCache", imports = {}))
    public static  void get_schemaCache$kotlinx_serialization_json$annotations() {
    }

    private Json(JsonConfiguration configuration, SerializersModule serializersModule) {
        this.configuration = configuration;
        this.serializersModule = serializersModule;
        this._schemaCache = new DescriptorSchemaCache();
    }

    public final JsonConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final DescriptorSchemaCache get_schemaCache$kotlinx_serialization_json() {
        return this._schemaCache;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/Json$Default;", "Lni/shikatu/kotlinx/serialization/json/Json;", "<init>", "()V", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Default extends Json {
        public  Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Default() {
            super(new JsonConfiguration(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, false, 262143, null), SerializersModuleBuildersKt.EmptySerializersModule(), null);
        }
    }

    @Override
    public final <T> String encodeToString(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        JsonToStringWriter result = new JsonToStringWriter();
        try {
            JsonStreamsKt.encodeByWriter(this, result, serializationStrategy, t);
            return result.toString();
        } finally {
            result.release();
        }
    }

    @Override
    public final <T> T decodeFromString(DeserializationStrategy<? extends T> deserializationStrategy, String str) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(str, "string");
        StringJsonLexer StringJsonLexer = StringJsonLexerKt.StringJsonLexer(this, str);
        T t = (T) new StreamingJsonDecoder(this, WriteMode.OBJ, StringJsonLexer, deserializationStrategy.getDescriptor(), null).decodeSerializableValue(deserializationStrategy);
        StringJsonLexer.expectEof();
        return t;
    }

    public final <T> JsonElement encodeToJsonElement(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        return TreeJsonEncoderKt.writeJson(this, t, serializationStrategy);
    }

    public final <T> T decodeFromJsonElement(DeserializationStrategy<? extends T> deserializationStrategy, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return (T) TreeJsonDecoderKt.readJson(this, jsonElement, deserializationStrategy);
    }

    public final JsonElement parseToJsonElement(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return (JsonElement) decodeFromString(JsonElementSerializer.INSTANCE, string);
    }

    public final  <T> String encodeToString(T t) {
        SerializersModule serializersModule = getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public final  <T> T decodeFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "string");
        SerializersModule serializersModule = getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return (T) decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), str);
    }
}
