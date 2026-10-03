package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.PolymorphicSerializerKt;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.encoding.AbstractEncoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import ni.shikatu.kotlinx.serialization.internal.NamedValueEncoder;
import ni.shikatu.kotlinx.serialization.json.ClassDiscriminatorMode;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonElementSerializer;
import ni.shikatu.kotlinx.serialization.json.JsonEncoder;
import ni.shikatu.kotlinx.serialization.json.JsonLiteral;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002JM\b2\u0018\u00002\u00020\u00012\u00020\u0002B%\bD\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0094\u0080\u0004J\u0012\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0080\u0004J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0094\u0080\u0004J\u001a\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0007H¦\u0080\u0004J\n\u0010&\u001a\u00020\u0007H¦\u0080\u0004J\n\u0010'\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010(\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0016H\u0094\u0080\u0004J\u001a\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001cH\u0094\u0080\u0004J\u001a\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020.H\u0094\u0080\u0004J\u001a\u0010/\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u000200H\u0094\u0080\u0004J\u001a\u00101\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u000202H\u0094\u0080\u0004J\u001a\u00103\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u000204H\u0094\u0080\u0004J+\u00105\u001a\u00020\b\"\u0004\b\u0000\u001062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H6082\u0006\u0010,\u001a\u0002H6H\u0096\u0080\u0004¢\u0006\u0002\u00109J\u001a\u0010:\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020;H\u0094\u0080\u0004J\u001a\u0010<\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020 H\u0094\u0080\u0004J\u001a\u0010=\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020>H\u0094\u0080\u0004J\u001a\u0010?\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0094\u0080\u0004J\"\u0010@\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u001cH\u0094\u0080\u0004J\u001a\u0010C\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020DH\u0094\u0080\u0004J\u001a\u0010E\u001a\u00020F2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u001aH\u0094\u0080\u0004J\u0012\u0010H\u001a\u00020F2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0017\u0010I\u001a\u00020J2\u0006\u0010*\u001a\u00020\u0016H\u0083\u0080\u0004¢\u0006\u0002\u0010KJ\u001f\u0010L\u001a\u00020M2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u001aH\u0082\u0080\u0004¢\u0006\u0002\u0010NJ\u0012\u0010O\u001a\u00020P2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0012\u0010Q\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0094\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148\u0004X\u0085\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u008e\b¢\u0006\u0002\n\u0000\u0082\u0001\u0003RST¨\u0006U"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lni/shikatu/kotlinx/serialization/internal/NamedValueEncoder;", "Lni/shikatu/kotlinx/serialization/json/JsonEncoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "nodeConsumer", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "getNodeConsumer", "()Lkotlin/jvm/functions/Function1;", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "polymorphicDiscriminator", _UrlKt.FRAGMENT_ENCODE_SET, "polymorphicSerialName", "elementName", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "encodeJsonElement", "element", "shouldEncodeElementDefault", _UrlKt.FRAGMENT_ENCODE_SET, "composeName", "parentName", "childName", "putElement", "key", "getCurrent", "encodeNotNullMark", "encodeNull", "encodeTaggedNull", "tag", "encodeTaggedInt", "value", "encodeTaggedByte", _UrlKt.FRAGMENT_ENCODE_SET, "encodeTaggedShort", _UrlKt.FRAGMENT_ENCODE_SET, "encodeTaggedLong", _UrlKt.FRAGMENT_ENCODE_SET, "encodeTaggedFloat", _UrlKt.FRAGMENT_ENCODE_SET, "encodeSerializableValue", "T", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeTaggedDouble", _UrlKt.FRAGMENT_ENCODE_SET, "encodeTaggedBoolean", "encodeTaggedChar", _UrlKt.FRAGMENT_ENCODE_SET, "encodeTaggedString", "encodeTaggedEnum", "enumDescriptor", "ordinal", "encodeTaggedValue", _UrlKt.FRAGMENT_ENCODE_SET, "encodeTaggedInline", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "inlineDescriptor", "encodeInline", "inlineUnsignedNumberEncoder", "ni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1", "(Ljava/lang/String;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1;", "inlineUnquotedLiteralEncoder", "ni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1;", "beginStructure", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "endEncode", "Lni/shikatu/kotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeEncoder;", "Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeListEncoder;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final Function1<JsonElement, Unit> nodeConsumer;
    private String polymorphicDiscriminator;
    private String polymorphicSerialName;

    public  AbstractJsonTreeEncoder(Json json, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, function1);
    }

    public abstract JsonElement getCurrent();

    public abstract void putElement(String str, JsonElement jsonElement);

    private AbstractJsonTreeEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        this.json = json;
        this.nodeConsumer = (Function1) function1;
        this.configuration = this.json.getConfiguration();
    }

    @Override
    public final Json getJson() {
        return this.json;
    }

    protected final Function1<JsonElement, Unit> getNodeConsumer() {
        return this.nodeConsumer;
    }

    @Override
    public final SerializersModule getSerializersModule() {
        return this.json.getSerializersModule();
    }

    @Override
    protected String elementName(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return JsonNamesMapKt.getJsonElementName(descriptor, this.json, index);
    }

    @Override
    public void encodeJsonElement(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (this.polymorphicDiscriminator != null && !(element instanceof JsonObject)) {
            PolymorphicKt.throwJsonElementPolymorphicException(this.polymorphicSerialName, element);
            throw new KotlinNothingValueException();
        }
        encodeSerializableValue(JsonElementSerializer.INSTANCE, element);
    }

    @Override
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    @Override
    protected String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    @Override
    public void encodeNotNullMark() {
    }

    @Override
    public void encodeNull() {
        String tag = getCurrentTagOrNull();
        if (tag == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
        } else {
            encodeTaggedNull(tag);
        }
    }

    @Override
    public void encodeTaggedNull(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonNull.INSTANCE);
    }

    @Override
    public void encodeTaggedInt(String tag, int value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Integer.valueOf(value)));
    }

    @Override
    public void encodeTaggedByte(String tag, byte value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Byte.valueOf(value)));
    }

    @Override
    public void encodeTaggedShort(String tag, short value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Short.valueOf(value)));
    }

    @Override
    public void encodeTaggedLong(String tag, long value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Long.valueOf(value)));
    }

    @Override
    public void encodeTaggedFloat(String tag, float value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Float.valueOf(value)));
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (!(Math.abs(value) <= Float.MAX_VALUE)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(value), tag);
        }
    }

    @Override
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        SerializationStrategy<? super T> serializationStrategyFindPolymorphicSerializer;
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (getCurrentTagOrNull() != null || !TreeJsonEncoderKt.getRequiresTopLevelTag(WriteModeKt.carrierDescriptor(serializationStrategy.getDescriptor(), getSerializersModule()))) {
            AbstractJsonTreeEncoder $this$encodePolymorphically$iv = this;
            if ($this$encodePolymorphically$iv.getJson().getConfiguration().getUseArrayPolymorphism()) {
                serializationStrategy.serialize($this$encodePolymorphically$iv, t);
                return;
            }
            boolean isPolymorphicSerializer$iv = serializationStrategy instanceof AbstractPolymorphicSerializer;
            boolean needDiscriminator$iv = true;
            if (isPolymorphicSerializer$iv) {
                if ($this$encodePolymorphically$iv.getJson().getConfiguration().getClassDiscriminatorMode() == ClassDiscriminatorMode.NONE) {
                    needDiscriminator$iv = false;
                }
            } else {
                switch (PolymorphicKt.WhenMappings.$EnumSwitchMapping$0[$this$encodePolymorphically$iv.getJson().getConfiguration().getClassDiscriminatorMode().ordinal()]) {
                    case 1:
                    case 2:
                        needDiscriminator$iv = false;
                        break;
                    case 3:
                        SerialKind it$iv = serializationStrategy.getDescriptor().getKind();
                        if (!Intrinsics.areEqual(it$iv, StructureKind.CLASS.INSTANCE) && !Intrinsics.areEqual(it$iv, StructureKind.OBJECT.INSTANCE)) {
                            needDiscriminator$iv = false;
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            String baseClassDiscriminator$iv = needDiscriminator$iv ? PolymorphicKt.classDiscriminator(serializationStrategy.getDescriptor(), $this$encodePolymorphically$iv.getJson()) : null;
            if (isPolymorphicSerializer$iv) {
                AbstractPolymorphicSerializer casted$iv = (AbstractPolymorphicSerializer) serializationStrategy;
                if (t == null) {
                    throw new IllegalArgumentException(("Value for serializer " + ((AbstractPolymorphicSerializer) serializationStrategy).getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
                }
                serializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(casted$iv, $this$encodePolymorphically$iv, t);
                Intrinsics.checkNotNull(serializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>");
            } else {
                serializationStrategyFindPolymorphicSerializer = serializationStrategy;
            }
            if (baseClassDiscriminator$iv != null) {
                PolymorphicKt.checkEncodingConflicts($this$encodePolymorphically$iv.getJson(), serializationStrategy, serializationStrategyFindPolymorphicSerializer, baseClassDiscriminator$iv);
                PolymorphicKt.checkKind(serializationStrategyFindPolymorphicSerializer.getDescriptor().getKind());
                String serialName = serializationStrategyFindPolymorphicSerializer.getDescriptor().getSerialName();
                String discriminatorName = baseClassDiscriminator$iv;
                this.polymorphicDiscriminator = discriminatorName;
                this.polymorphicSerialName = serialName;
            }
            serializationStrategyFindPolymorphicSerializer.serialize($this$encodePolymorphically$iv, t);
            return;
        }
        JsonPrimitiveEncoder $this$encodeSerializableValue_u24lambda_u241 = new JsonPrimitiveEncoder(this.json, this.nodeConsumer);
        $this$encodeSerializableValue_u24lambda_u241.encodeSerializableValue(serializationStrategy, t);
    }

    @Override
    public void encodeTaggedDouble(String tag, double value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Double.valueOf(value)));
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (!(Math.abs(value) <= Double.MAX_VALUE)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(value), tag);
        }
    }

    @Override
    public void encodeTaggedBoolean(String tag, boolean value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Boolean.valueOf(value)));
    }

    @Override
    public void encodeTaggedChar(String tag, char value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(String.valueOf(value)));
    }

    @Override
    public void encodeTaggedString(String tag, String value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        putElement(tag, JsonElementKt.JsonPrimitive(value));
    }

    @Override
    public void encodeTaggedEnum(String tag, SerialDescriptor enumDescriptor, int ordinal) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        putElement(tag, JsonElementKt.JsonPrimitive(enumDescriptor.getElementName(ordinal)));
    }

    @Override
    public void encodeTaggedValue(String tag, Object value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        putElement(tag, JsonElementKt.JsonPrimitive(value.toString()));
    }

    @Override
    public Encoder encodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor)) {
            return inlineUnsignedNumberEncoder(tag);
        }
        return StreamingJsonEncoderKt.isUnquotedLiteral(inlineDescriptor) ? inlineUnquotedLiteralEncoder(tag, inlineDescriptor) : super.encodeTaggedInline(tag, inlineDescriptor);
    }

    @Override
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (getCurrentTagOrNull() != null) {
            if (this.polymorphicDiscriminator != null) {
                this.polymorphicSerialName = descriptor.getSerialName();
            }
            return super.encodeInline(descriptor);
        }
        return new JsonPrimitiveEncoder(this.json, this.nodeConsumer).encodeInline(descriptor);
    }

    private final AbstractEncoder inlineUnsignedNumberEncoder(final String tag) {
        return new AbstractEncoder() {
            private final SerializersModule serializersModule;

            {
                this.serializersModule = AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }

            @Override
            public SerializersModule getSerializersModule() {
                return this.serializersModule;
            }

            public final void putUnquotedString(String s) {
                Intrinsics.checkNotNullParameter(s, "s");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(s, false, null, 4, null));
            }

            @Override
            public void encodeInt(int value) {
                putUnquotedString(Integer.toUnsignedString(UInt.m101constructorimpl(value)));
            }

            @Override
            public void encodeLong(long value) {
                putUnquotedString(Long.toUnsignedString(ULong.m180constructorimpl(value)));
            }

            @Override
            public void encodeByte(byte value) {
                putUnquotedString(UByte.m68toStringimpl(UByte.m24constructorimpl(value)));
            }

            @Override
            public void encodeShort(short value) {
                putUnquotedString(UShort.m331toStringimpl(UShort.m287constructorimpl(value)));
            }
        };
    }

    private final AbstractEncoder inlineUnquotedLiteralEncoder(final String tag, final SerialDescriptor inlineDescriptor) {
        return new AbstractEncoder() {
            @Override
            public SerializersModule getSerializersModule() {
                return AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }

            @Override
            public void encodeString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(value, false, inlineDescriptor));
            }
        };
    }

    @Override
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        AbstractJsonTreeEncoder encoder;
        AbstractJsonTreeEncoder jsonTreeMapEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Function1<JsonElement, Unit> function1 = getCurrentTagOrNull() == null ? this.nodeConsumer : new Function1() {
            final AbstractJsonTreeEncoder f$0;

            {
                this.f$0 = AbstractJsonTreeEncoder.this;
            }

            @Override
            public final Object invoke(Object obj) {
                return AbstractJsonTreeEncoder.beginStructure$lambda$0(this.f$0, (JsonElement) obj);
            }
        };
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) || (kind instanceof PolymorphicKind)) {
            encoder = new JsonTreeListEncoder(this.json, function1);
        } else if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            Json $this$selectMapMode$iv = this.json;
            SerialDescriptor keyDescriptor$iv = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), $this$selectMapMode$iv.getSerializersModule());
            SerialKind keyKind$iv = keyDescriptor$iv.getKind();
            if ((keyKind$iv instanceof PrimitiveKind) || Intrinsics.areEqual(keyKind$iv, SerialKind.ENUM.INSTANCE)) {
                jsonTreeMapEncoder = new JsonTreeMapEncoder(this.json, function1);
            } else if ($this$selectMapMode$iv.getConfiguration().getAllowStructuredMapKeys()) {
                jsonTreeMapEncoder = new JsonTreeListEncoder(this.json, function1);
            } else {
                throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor$iv);
            }
            encoder = jsonTreeMapEncoder;
        } else {
            encoder = new JsonTreeEncoder(this.json, function1);
        }
        String discriminator = this.polymorphicDiscriminator;
        if (discriminator != null) {
            if (encoder instanceof JsonTreeMapEncoder) {
                ((JsonTreeMapEncoder) encoder).putElement("key", JsonElementKt.JsonPrimitive(discriminator));
                JsonTreeMapEncoder jsonTreeMapEncoder2 = (JsonTreeMapEncoder) encoder;
                String serialName = this.polymorphicSerialName;
                if (serialName == null) {
                    serialName = descriptor.getSerialName();
                }
                jsonTreeMapEncoder2.putElement("value", JsonElementKt.JsonPrimitive(serialName));
            } else {
                String serialName2 = this.polymorphicSerialName;
                if (serialName2 == null) {
                    serialName2 = descriptor.getSerialName();
                }
                encoder.putElement(discriminator, JsonElementKt.JsonPrimitive(serialName2));
            }
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        return encoder;
    }

    public static final Unit beginStructure$lambda$0(AbstractJsonTreeEncoder this$0, JsonElement node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this$0.putElement(this$0.getCurrentTag(), node);
        return Unit.INSTANCE;
    }

    @Override
    protected void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.nodeConsumer.invoke(getCurrent());
    }
}
