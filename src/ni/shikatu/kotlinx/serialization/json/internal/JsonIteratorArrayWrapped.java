package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Iterator;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u00020\fH\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\r\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonIteratorArrayWrapped;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "lexer", "Lni/shikatu/kotlinx/serialization/json/internal/ReaderJsonLexer;", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/ReaderJsonLexer;Lkotlinx/serialization/DeserializationStrategy;)V", "first", _UrlKt.FRAGMENT_ENCODE_SET, "finished", "next", "()Ljava/lang/Object;", "hasNext", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class JsonIteratorArrayWrapped<T> implements Iterator<T>, KMappedMarker {
    private final DeserializationStrategy<T> deserializer;
    private boolean finished;
    private boolean first;
    private final Json json;
    private final ReaderJsonLexer lexer;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonIteratorArrayWrapped(Json json, ReaderJsonLexer lexer, DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        this.json = json;
        this.lexer = lexer;
        this.deserializer = deserializationStrategy;
        this.first = true;
    }

    @Override
    public T next() {
        if (this.first) {
            this.first = false;
        } else {
            this.lexer.consumeNextToken(AbstractJsonLexerKt.COMMA);
        }
        return (T) new StreamingJsonDecoder(this.json, WriteMode.OBJ, this.lexer, this.deserializer.getDescriptor(), null).decodeSerializableValue(this.deserializer);
    }

    @Override
    public boolean hasNext() {
        if (this.finished) {
            return false;
        }
        if (this.lexer.peekNextToken() == 9) {
            this.finished = true;
            this.lexer.consumeNextToken((byte) 9);
            if (this.lexer.isNotEof()) {
                if (this.lexer.peekNextToken() == 8) {
                    AbstractJsonLexer.fail$default(this.lexer, "There is a start of the new array after the one parsed to sequence. ARRAY_WRAPPED mode doesn't merge consecutive arrays.\nIf you need to parse a stream of arrays, please use WHITESPACE_SEPARATED mode instead.", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                this.lexer.expectEof();
            }
            return false;
        }
        if (this.lexer.isNotEof() || this.finished) {
            return true;
        }
        AbstractJsonLexer $this$iv = this.lexer;
        String expected$iv = AbstractJsonLexerKt.tokenDescription((byte) 9);
        int position$iv = $this$iv.currentPosition > 0 ? $this$iv.currentPosition - 1 : $this$iv.currentPosition;
        String s$iv = ($this$iv.currentPosition == $this$iv.getSource().length() || position$iv < 0) ? "EOF" : String.valueOf($this$iv.getSource().charAt(position$iv));
        String source = s$iv;
        AbstractJsonLexer.fail$default($this$iv, "Expected " + expected$iv + ", but had '" + source + "' instead", position$iv, null, 4, null);
        throw new KotlinNothingValueException();
    }
}
