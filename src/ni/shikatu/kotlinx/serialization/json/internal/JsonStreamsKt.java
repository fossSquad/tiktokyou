package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.kotlinx.serialization.json.DecodeSequenceMode;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonEncoder;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\r\u001a\u0002H\u0006H\u0087\u0080\u0004¢\u0006\u0002\u0010\u000e\u001a3\u0010\u000f\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a>\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0016\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\u0080\u0004\u001a2\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0016\"\u0006\b\u0000\u0010\u0006\u0018\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\u0088\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0002\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0003\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"SINGLE_CHAR_MAX_CODEPOINT", _UrlKt.FRAGMENT_ENCODE_SET, "HIGH_SURROGATE_HEADER", "LOW_SURROGATE_HEADER", "encodeByWriter", _UrlKt.FRAGMENT_ENCODE_SET, "T", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "writer", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "decodeByReader", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "reader", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/internal/InternalJsonReader;)Ljava/lang/Object;", "decodeToSequenceByReader", "Lni/shikatu/kotlin/sequences/Sequence;", "format", "Lni/shikatu/kotlinx/serialization/json/DecodeSequenceMode;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonStreamsKt {
    private static final int HIGH_SURROGATE_HEADER = 55232;
    private static final int LOW_SURROGATE_HEADER = 56320;
    private static final int SINGLE_CHAR_MAX_CODEPOINT = 65535;

    @JsonFriendModuleApi
    public static final <T> void encodeByWriter(Json json, InternalJsonWriter writer, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        StreamingJsonEncoder encoder = new StreamingJsonEncoder(writer, json, WriteMode.OBJ, new JsonEncoder[WriteMode.getEntries().size()]);
        encoder.encodeSerializableValue(serializationStrategy, t);
    }

    @JsonFriendModuleApi
    public static final <T> T decodeByReader(Json json, DeserializationStrategy<? extends T> deserializationStrategy, InternalJsonReader internalJsonReader) throws Throwable {
        Throwable th;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(internalJsonReader, "reader");
        ReaderJsonLexer readerJsonLexerReaderJsonLexer$default = ReaderJsonLexerKt.ReaderJsonLexer$default(json, internalJsonReader, null, 4, null);
        try {
            try {
                T t = (T) new StreamingJsonDecoder(json, WriteMode.OBJ, readerJsonLexerReaderJsonLexer$default, deserializationStrategy.getDescriptor(), null).decodeSerializableValue(deserializationStrategy);
                readerJsonLexerReaderJsonLexer$default.expectEof();
                readerJsonLexerReaderJsonLexer$default.release();
                return t;
            } catch (Throwable th2) {
                th = th2;
                readerJsonLexerReaderJsonLexer$default.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static  Sequence decodeToSequenceByReader$default(Json json, InternalJsonReader internalJsonReader, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i, Object obj) {
        if ((i & 8) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequenceByReader(json, internalJsonReader, deserializationStrategy, decodeSequenceMode);
    }

    @JsonFriendModuleApi
    @ExperimentalSerializationApi
    public static final <T> Sequence<T> decodeToSequenceByReader(Json json, InternalJsonReader reader, DeserializationStrategy<? extends T> deserializationStrategy, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(format, "format");
        ReaderJsonLexer lexer = ReaderJsonLexerKt.ReaderJsonLexer(json, reader, new char[16384]);
        final Iterator iter = JsonIteratorKt.JsonIterator(format, json, lexer, deserializationStrategy);
        return SequencesKt.constrainOnce(new Sequence<T>() {
            @Override
            public Iterator<T> iterator() {
                return iter;
            }
        });
    }

    public static  Sequence decodeToSequenceByReader$default(Json json, InternalJsonReader reader, DecodeSequenceMode format, int i, Object obj) {
        if ((i & 4) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return decodeToSequenceByReader(json, reader, SerializersKt.serializer(serializersModule, (KType) null), format);
    }

    @JsonFriendModuleApi
    @ExperimentalSerializationApi
    public static final  <T> Sequence<T> decodeToSequenceByReader(Json json, InternalJsonReader reader, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return decodeToSequenceByReader(json, reader, SerializersKt.serializer(serializersModule, (KType) null), format);
    }
}
