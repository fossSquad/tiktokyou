package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Iterator;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.json.DecodeSequenceMode;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0080\u0080\u0004\u001a\u0016\u0010\u000b\u001a\u00020\u0004*\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\u000e\u0010\u000e\u001a\u00020\u000f*\u00020\fH\u0082\u0080\u0004¨\u0006\u0010"}, d2 = {"JsonIterator", _UrlKt.FRAGMENT_ENCODE_SET, "T", "mode", "Lni/shikatu/kotlinx/serialization/json/DecodeSequenceMode;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "lexer", "Lni/shikatu/kotlinx/serialization/json/internal/ReaderJsonLexer;", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "determineFormat", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "suggested", "tryConsumeStartArray", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonIteratorKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DecodeSequenceMode.values().length];
            try {
                iArr[DecodeSequenceMode.WHITESPACE_SEPARATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DecodeSequenceMode.ARRAY_WRAPPED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DecodeSequenceMode.AUTO_DETECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T> Iterator<T> JsonIterator(DecodeSequenceMode mode, Json json, ReaderJsonLexer lexer, DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        switch (WhenMappings.$EnumSwitchMapping$0[determineFormat(lexer, mode).ordinal()]) {
            case 1:
                return new JsonIteratorWsSeparated(json, lexer, deserializationStrategy);
            case 2:
                return new JsonIteratorArrayWrapped(json, lexer, deserializationStrategy);
            case 3:
                throw new IllegalStateException("AbstractJsonLexer.determineFormat must be called beforehand.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final DecodeSequenceMode determineFormat(AbstractJsonLexer $this$determineFormat, DecodeSequenceMode suggested) {
        switch (WhenMappings.$EnumSwitchMapping$0[suggested.ordinal()]) {
            case 1:
                return DecodeSequenceMode.WHITESPACE_SEPARATED;
            case 2:
                if (tryConsumeStartArray($this$determineFormat)) {
                    return DecodeSequenceMode.ARRAY_WRAPPED;
                }
                String expected$iv = AbstractJsonLexerKt.tokenDescription((byte) 8);
                int position$iv = $this$determineFormat.currentPosition > 0 ? $this$determineFormat.currentPosition - 1 : $this$determineFormat.currentPosition;
                String s$iv = ($this$determineFormat.currentPosition == $this$determineFormat.getSource().length() || position$iv < 0) ? "EOF" : String.valueOf($this$determineFormat.getSource().charAt(position$iv));
                AbstractJsonLexer.fail$default($this$determineFormat, "Expected " + expected$iv + ", but had '" + s$iv + "' instead", position$iv, null, 4, null);
                throw new KotlinNothingValueException();
            case 3:
                return tryConsumeStartArray($this$determineFormat) ? DecodeSequenceMode.ARRAY_WRAPPED : DecodeSequenceMode.WHITESPACE_SEPARATED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean tryConsumeStartArray(AbstractJsonLexer $this$tryConsumeStartArray) {
        if ($this$tryConsumeStartArray.peekNextToken() == 8) {
            $this$tryConsumeStartArray.consumeNextToken((byte) 8);
            return true;
        }
        return false;
    }
}
