package ni.shikatu.kotlinx.serialization.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.kotlinx.serialization.json.internal.JavaStreamSerialReader;
import ni.shikatu.kotlinx.serialization.json.internal.JsonStreamsKt;
import ni.shikatu.kotlinx.serialization.json.internal.JsonToJavaStreamWriter;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001a+\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0088\u0004¢\u0006\u0002\u0010\n\u001a/\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000eH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000f\u001a#\u0010\u000b\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000eH\u0087\u0088\u0004¢\u0006\u0002\u0010\u0010\u001a:\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\u0080\u0004\u001a.\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\u0088\u0004¨\u0006\u0015"}, d2 = {"encodeToStream", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlinx/serialization/json/Json;", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "value", "stream", "Ljava/io/OutputStream;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Ljava/io/OutputStream;)V", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Ljava/io/OutputStream;)V", "decodeFromStream", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "Ljava/io/InputStream;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Ljava/io/InputStream;)Ljava/lang/Object;", "(Lkotlinx/serialization/json/Json;Ljava/io/InputStream;)Ljava/lang/Object;", "decodeToSequence", "Lni/shikatu/kotlin/sequences/Sequence;", "format", "Lni/shikatu/kotlinx/serialization/json/DecodeSequenceMode;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JvmStreamsKt {
    @ExperimentalSerializationApi
    public static final <T> void encodeToStream(Json $this$encodeToStream, SerializationStrategy<? super T> serializationStrategy, T t, OutputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter($this$encodeToStream, "<this>");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        Intrinsics.checkNotNullParameter(stream, "stream");
        JsonToJavaStreamWriter writer = new JsonToJavaStreamWriter(stream);
        try {
            JsonStreamsKt.encodeByWriter($this$encodeToStream, writer, serializationStrategy, t);
        } finally {
            writer.release();
        }
    }

    @ExperimentalSerializationApi
    public static final  <T> void encodeToStream(Json $this$encodeToStream, T t, OutputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter($this$encodeToStream, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        SerializersModule serializersModule = $this$encodeToStream.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        encodeToStream($this$encodeToStream, SerializersKt.serializer(serializersModule, (KType) null), t, stream);
    }

    @ExperimentalSerializationApi
    public static final <T> T decodeFromStream(Json json, DeserializationStrategy<? extends T> deserializationStrategy, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        JavaStreamSerialReader javaStreamSerialReader = new JavaStreamSerialReader(inputStream);
        try {
            return (T) JsonStreamsKt.decodeByReader(json, deserializationStrategy, javaStreamSerialReader);
        } finally {
            javaStreamSerialReader.release();
        }
    }

    @ExperimentalSerializationApi
    public static final  <T> T decodeFromStream(Json json, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return (T) decodeFromStream(json, SerializersKt.serializer(serializersModule, (KType) null), inputStream);
    }

    public static  Sequence decodeToSequence$default(Json json, InputStream inputStream, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i, Object obj) {
        if ((i & 4) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequence(json, inputStream, deserializationStrategy, decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final <T> Sequence<T> decodeToSequence(Json $this$decodeToSequence, InputStream stream, DeserializationStrategy<? extends T> deserializationStrategy, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeToSequence, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(format, "format");
        return JsonStreamsKt.decodeToSequenceByReader($this$decodeToSequence, new JavaStreamSerialReader(stream), deserializationStrategy, format);
    }

    public static  Sequence decodeToSequence$default(Json $this$decodeToSequence_u24default, InputStream stream, DecodeSequenceMode format, int i, Object obj) {
        if ((i & 2) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        Intrinsics.checkNotNullParameter($this$decodeToSequence_u24default, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = $this$decodeToSequence_u24default.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return decodeToSequence($this$decodeToSequence_u24default, stream, SerializersKt.serializer(serializersModule, (KType) null), format);
    }

    @ExperimentalSerializationApi
    public static final  <T> Sequence<T> decodeToSequence(Json $this$decodeToSequence, InputStream stream, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeToSequence, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = $this$decodeToSequence.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return decodeToSequence($this$decodeToSequence, stream, SerializersKt.serializer(serializersModule, (KType) null), format);
    }
}
