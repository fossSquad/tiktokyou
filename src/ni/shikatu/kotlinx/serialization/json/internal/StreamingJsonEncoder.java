package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.PolymorphicSerializerKt;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.encoding.AbstractEncoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import ni.shikatu.kotlinx.serialization.json.ClassDiscriminatorMode;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementSerializer;
import ni.shikatu.kotlinx.serialization.json.JsonEncoder;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB1\bP\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b\u000b\u0010\u000fJ\u0012\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096\u0080\u0004J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004J+\u0010'\u001a\u00020\u001f\"\u0004\b\u0000\u0010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0*2\u0006\u0010+\u001a\u0002H(H\u0096\u0080\u0004¢\u0006\u0002\u0010,J\u001a\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001cH\u0082\u0080\u0004J\u0012\u00100\u001a\u0002012\u0006\u0010#\u001a\u00020$H\u0096\u0080\u0004J\u0012\u00102\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0096\u0080\u0004J\u001a\u00103\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004JA\u00104\u001a\u00020\u001f\"\b\b\u0000\u0010(*\u0002052\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0*2\b\u0010+\u001a\u0004\u0018\u0001H(H\u0096\u0080\u0004¢\u0006\u0002\u00106J\u0012\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020$H\u0096\u0080\u0004JS\u00109\u001a\u0002H(\"\n\b\u0000\u0010(\u0018\u0001*\u00020\u000426\u0010:\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H(0;H\u0082\u0088\u0004¢\u0006\u0002\u0010?J\n\u0010@\u001a\u00020\u001fH\u0096\u0080\u0004J\u0012\u0010A\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001aH\u0096\u0080\u0004J\u0012\u0010B\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020CH\u0096\u0080\u0004J\u0012\u0010D\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020EH\u0096\u0080\u0004J\u0012\u0010F\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020&H\u0096\u0080\u0004J\u0012\u0010G\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020HH\u0096\u0080\u0004J\u0012\u0010I\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020JH\u0096\u0080\u0004J\u0012\u0010K\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020LH\u0096\u0080\u0004J\u0012\u0010M\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020NH\u0096\u0080\u0004J\u0012\u0010O\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001cH\u0096\u0080\u0004J\u001a\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0012R\u0015\u0010\u0013\u001a\u00020\u0014X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000f\u0010\u0017\u001a\u00020\u0018X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0019\u001a\u00020\u001aX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/StreamingJsonEncoder;", "Lni/shikatu/kotlinx/serialization/json/JsonEncoder;", "Lni/shikatu/kotlinx/serialization/encoding/AbstractEncoder;", "composer", "Lni/shikatu/kotlinx/serialization/json/internal/Composer;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "mode", "Lni/shikatu/kotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/internal/Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "output", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lni/shikatu/kotlinx/serialization/json/JsonEncoder;", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "forceQuoting", _UrlKt.FRAGMENT_ENCODE_SET, "polymorphicDiscriminator", _UrlKt.FRAGMENT_ENCODE_SET, "polymorphicSerialName", "encodeJsonElement", _UrlKt.FRAGMENT_ENCODE_SET, "element", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "shouldEncodeElementDefault", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "encodeSerializableValue", "T", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeTypeInfo", "discriminator", "serialName", "beginStructure", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "endStructure", "encodeElement", "encodeNullableSerializableElement", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeInline", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "composerAs", "composerCreator", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "writer", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/serialization/json/internal/Composer;", "encodeNull", "encodeBoolean", "encodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "encodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "encodeInt", "encodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "encodeFloat", _UrlKt.FRAGMENT_ENCODE_SET, "encodeDouble", _UrlKt.FRAGMENT_ENCODE_SET, "encodeChar", _UrlKt.FRAGMENT_ENCODE_SET, "encodeString", "encodeEnum", "enumDescriptor", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {
    private final Composer composer;
    private final JsonConfiguration configuration;
    private boolean forceQuoting;
    private final Json json;
    private final WriteMode mode;
    private final JsonEncoder[] modeReuseCache;
    private String polymorphicDiscriminator;
    private String polymorphicSerialName;
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode mode, JsonEncoder[] modeReuseCache) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.composer = composer;
        this.json = json;
        this.mode = mode;
        this.modeReuseCache = modeReuseCache;
        this.serializersModule = getJson().getSerializersModule();
        this.configuration = getJson().getConfiguration();
        int i = this.mode.ordinal();
        if (this.modeReuseCache == null) {
            return;
        }
        if (this.modeReuseCache[i] == null && this.modeReuseCache[i] == this) {
            return;
        }
        this.modeReuseCache[i] = this;
    }

    @Override
    public Json getJson() {
        return this.json;
    }

    public StreamingJsonEncoder(InternalJsonWriter output, Json json, WriteMode mode, JsonEncoder[] modeReuseCache) {
        this(ComposersKt.Composer(output, json), json, mode, modeReuseCache);
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(modeReuseCache, "modeReuseCache");
    }

    @Override
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
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
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        SerializationStrategy<? super T> serializationStrategyFindPolymorphicSerializer;
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        StreamingJsonEncoder $this$encodePolymorphically$iv = this;
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
            if (t == 0) {
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
    }

    private final void encodeTypeInfo(String discriminator, String serialName) {
        this.composer.nextItem();
        encodeString(discriminator);
        this.composer.print(AbstractJsonLexerKt.COLON);
        this.composer.space();
        encodeString(serialName);
    }

    @Override
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        JsonEncoder streamingJsonEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode newMode = WriteModeKt.switchMode(getJson(), descriptor);
        if (newMode.begin != 0) {
            this.composer.print(newMode.begin);
            this.composer.indent();
        }
        String discriminator = this.polymorphicDiscriminator;
        if (discriminator != null) {
            String serialName = this.polymorphicSerialName;
            if (serialName == null) {
                serialName = descriptor.getSerialName();
            }
            encodeTypeInfo(discriminator, serialName);
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        if (this.mode == newMode) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.modeReuseCache;
        if (jsonEncoderArr == null || (streamingJsonEncoder = jsonEncoderArr[newMode.ordinal()]) == null) {
            streamingJsonEncoder = new StreamingJsonEncoder(this.composer, getJson(), newMode, this.modeReuseCache);
        }
        return streamingJsonEncoder;
    }

    @Override
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.mode.end != 0) {
            this.composer.unIndent();
            this.composer.nextItemIfNotFirst();
            this.composer.print(this.mode.end);
        }
    }

    @Override
    public boolean encodeElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        boolean z = false;
        switch (WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()]) {
            case 1:
                if (!this.composer.getWritingFirst()) {
                    this.composer.print(AbstractJsonLexerKt.COMMA);
                }
                this.composer.nextItem();
                return true;
            case 2:
                if (!this.composer.getWritingFirst()) {
                    if (index % 2 == 0) {
                        this.composer.print(AbstractJsonLexerKt.COMMA);
                        this.composer.nextItem();
                        z = true;
                    } else {
                        this.composer.print(AbstractJsonLexerKt.COLON);
                        this.composer.space();
                    }
                    this.forceQuoting = z;
                } else {
                    this.forceQuoting = true;
                    this.composer.nextItem();
                }
                return true;
            case 3:
                if (index == 0) {
                    this.forceQuoting = true;
                }
                if (index == 1) {
                    this.composer.print(AbstractJsonLexerKt.COMMA);
                    this.composer.space();
                    this.forceQuoting = false;
                }
                return true;
            default:
                if (!this.composer.getWritingFirst()) {
                    this.composer.print(AbstractJsonLexerKt.COMMA);
                }
                this.composer.nextItem();
                encodeString(JsonNamesMapKt.getJsonElementName(descriptor, getJson(), index));
                this.composer.print(AbstractJsonLexerKt.COLON);
                this.composer.space();
                return true;
        }
    }

    @Override
    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (t != null || this.configuration.getExplicitNulls()) {
            super.encodeNullableSerializableElement(descriptor, index, serializationStrategy, t);
        }
    }

    @Override
    public Encoder encodeInline(SerialDescriptor descriptor) {
        ComposerForUnquotedLiterals composerForUnquotedLiterals;
        ComposerForUnsignedNumbers composerForUnsignedNumbers;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!StreamingJsonEncoderKt.isUnsignedNumber(descriptor)) {
            if (!StreamingJsonEncoderKt.isUnquotedLiteral(descriptor)) {
                if (this.polymorphicDiscriminator != null) {
                    StreamingJsonEncoder $this$encodeInline_u24lambda_u241 = this;
                    $this$encodeInline_u24lambda_u241.polymorphicSerialName = descriptor.getSerialName();
                    return this;
                }
                return super.encodeInline(descriptor);
            }
            if (this.composer instanceof ComposerForUnquotedLiterals) {
                composerForUnquotedLiterals = this.composer;
            } else {
                InternalJsonWriter p0 = this.composer.writer;
                boolean p1 = this.forceQuoting;
                composerForUnquotedLiterals = new ComposerForUnquotedLiterals(p0, p1);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, getJson(), this.mode, (JsonEncoder[]) null);
        }
        if (this.composer instanceof ComposerForUnsignedNumbers) {
            composerForUnsignedNumbers = this.composer;
        } else {
            InternalJsonWriter p2 = this.composer.writer;
            boolean p3 = this.forceQuoting;
            composerForUnsignedNumbers = new ComposerForUnsignedNumbers(p2, p3);
        }
        return new StreamingJsonEncoder(composerForUnsignedNumbers, getJson(), this.mode, (JsonEncoder[]) null);
    }

    private final  <T extends Composer> T composerAs(Function2<? super InternalJsonWriter, ? super Boolean, ? extends T> function2) {
        Composer composer = this.composer;
        Intrinsics.reifiedOperationMarker(3, "T");
        return composer instanceof Composer ? (T) this.composer : function2.invoke(this.composer.writer, Boolean.valueOf(this.forceQuoting));
    }

    @Override
    public void encodeNull() {
        this.composer.print(AbstractJsonLexerKt.NULL);
    }

    @Override
    public void encodeBoolean(boolean value) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(value));
        } else {
            this.composer.print(value);
        }
    }

    @Override
    public void encodeByte(byte value) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) value));
        } else {
            this.composer.print(value);
        }
    }

    @Override
    public void encodeShort(short value) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) value));
        } else {
            this.composer.print(value);
        }
    }

    @Override
    public void encodeInt(int value) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(value));
        } else {
            this.composer.print(value);
        }
    }

    @Override
    public void encodeLong(long value) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(value));
        } else {
            this.composer.print(value);
        }
    }

    @Override
    public void encodeFloat(float value) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(value));
        } else {
            this.composer.print(value);
        }
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (!(Math.abs(value) <= Float.MAX_VALUE)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded$default(Float.valueOf(value), null, 2, null);
        }
    }

    @Override
    public void encodeDouble(double value) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(value));
        } else {
            this.composer.print(value);
        }
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (!(Math.abs(value) <= Double.MAX_VALUE)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded$default(Double.valueOf(value), null, 2, null);
        }
    }

    @Override
    public void encodeChar(char value) {
        encodeString(String.valueOf(value));
    }

    @Override
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.composer.printQuoted(value);
    }

    @Override
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeString(enumDescriptor.getElementName(index));
    }
}
