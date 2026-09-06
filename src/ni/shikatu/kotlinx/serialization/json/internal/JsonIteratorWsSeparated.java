package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\u000eH\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonIteratorWsSeparated;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "lexer", "Lni/shikatu/kotlinx/serialization/json/internal/ReaderJsonLexer;", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/ReaderJsonLexer;Lkotlinx/serialization/DeserializationStrategy;)V", "next", "()Ljava/lang/Object;", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class JsonIteratorWsSeparated<T> implements Iterator<T>, KMappedMarker {
    private final DeserializationStrategy<T> deserializer;
    private final Json json;
    private final ReaderJsonLexer lexer;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonIteratorWsSeparated(Json json, ReaderJsonLexer lexer, DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        this.json = json;
        this.lexer = lexer;
        this.deserializer = deserializationStrategy;
    }

    @Override
    public T next() {
        return (T) new StreamingJsonDecoder(this.json, WriteMode.OBJ, this.lexer, this.deserializer.getDescriptor(), null).decodeSerializableValue(this.deserializer);
    }

    @Override
    public boolean hasNext() {
        return this.lexer.isNotEof();
    }
}
