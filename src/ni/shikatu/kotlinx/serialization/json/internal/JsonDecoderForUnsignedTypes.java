package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.UStringsKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.AbstractDecoder;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\tX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonDecoderForUnsignedTypes;", "Lni/shikatu/kotlinx/serialization/encoding/AbstractDecoder;", "lexer", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/json/Json;)V", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeElementIndex", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "decodeInt", "decodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "decodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "decodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {
    private final AbstractJsonLexer lexer;
    private final SerializersModule serializersModule;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer lexer, Json json) {
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(json, "json");
        this.lexer = lexer;
        this.serializersModule = json.getSerializersModule();
    }

    @Override
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override
    public int decodeInt() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            return UStringsKt.toUInt(input$iv);
        } catch (IllegalArgumentException e) {
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type 'UInt' for input '" + input$iv + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public long decodeLong() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            return UStringsKt.toULong(input$iv);
        } catch (IllegalArgumentException e) {
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type 'ULong' for input '" + input$iv + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public byte decodeByte() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            return UStringsKt.toUByte(input$iv);
        } catch (IllegalArgumentException e) {
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type 'UByte' for input '" + input$iv + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override
    public short decodeShort() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            return UStringsKt.toUShort(input$iv);
        } catch (IllegalArgumentException e) {
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type 'UShort' for input '" + input$iv + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
