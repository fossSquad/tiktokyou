package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\r\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0003H\u0096\u0080\u0004J5\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0096\u0080\u0004J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0094\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/StringJsonLexer;", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "source", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonConfiguration;)V", "getSource", "()Ljava/lang/String;", "prefetchOrEof", _UrlKt.FRAGMENT_ENCODE_SET, "position", "consumeNextToken", _UrlKt.FRAGMENT_ENCODE_SET, "canConsumeValue", _UrlKt.FRAGMENT_ENCODE_SET, "skipWhitespaces", _UrlKt.FRAGMENT_ENCODE_SET, "expected", _UrlKt.FRAGMENT_ENCODE_SET, "consumeKeyString", "consumeStringChunked", "isLenient", "consumeChunk", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "name", "stringChunk", "peekLeadingMatchingValue", "keyToMatch", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class StringJsonLexer extends AbstractJsonLexer {
    private final String source;

    public StringJsonLexer(String source, JsonConfiguration configuration) {
        super(configuration);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.source = source;
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        return -1;
    }

    @Override
    public byte consumeNextToken() {
        String source = getSource();
        int cpos = this.currentPosition;
        while (cpos != -1 && cpos < source.length()) {
            int cpos2 = cpos + 1;
            char c = source.charAt(cpos);
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                cpos = cpos2;
            } else {
                this.currentPosition = cpos2;
                return AbstractJsonLexerKt.charToTokenClass(c);
            }
        }
        int cpos3 = source.length();
        this.currentPosition = cpos3;
        return (byte) 10;
    }

    @Override
    public boolean canConsumeValue() {
        int current = this.currentPosition;
        if (current == -1) {
            return false;
        }
        String source = getSource();
        while (current < source.length()) {
            char c = source.charAt(current);
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                current++;
            } else {
                this.currentPosition = current;
                return isValidValueStart(c);
            }
        }
        this.currentPosition = current;
        return false;
    }

    @Override
    public int skipWhitespaces() {
        int current = this.currentPosition;
        if (current == -1) {
            return current;
        }
        String source = getSource();
        while (current < source.length()) {
            char c = source.charAt(current);
            if (!(c == ' ' || c == '\n' || c == '\r' || c == '\t')) {
                break;
            }
            current++;
        }
        this.currentPosition = current;
        return current;
    }

    @Override
    public void consumeNextToken(char expected) {
        if (this.currentPosition == -1) {
            unexpectedToken(expected);
        }
        String source = getSource();
        int cpos = this.currentPosition;
        while (cpos < source.length()) {
            int cpos2 = cpos + 1;
            char c = source.charAt(cpos);
            if (!(c == ' ' || c == '\n' || c == '\r' || c == '\t')) {
                this.currentPosition = cpos2;
                if (c == expected) {
                    return;
                } else {
                    unexpectedToken(expected);
                }
            }
            cpos = cpos2;
        }
        this.currentPosition = -1;
        unexpectedToken(expected);
    }

    @Override
    public String consumeKeyString() {
        consumeNextToken('\"');
        int current = this.currentPosition;
        int closingQuote = StringsKt.indexOf$default((CharSequence) getSource(), '\"', current, false, 4, (Object) null);
        if (closingQuote == -1) {
            consumeStringLenient();
            StringJsonLexer $this$iv = this;
            String expected$iv = AbstractJsonLexerKt.tokenDescription((byte) 1);
            int position$iv = $this$iv.currentPosition;
            String s$iv = ($this$iv.currentPosition == $this$iv.getSource().length() || position$iv < 0) ? "EOF" : String.valueOf($this$iv.getSource().charAt(position$iv));
            AbstractJsonLexer.fail$default($this$iv, "Expected " + expected$iv + ", but had '" + s$iv + "' instead", position$iv, null, 4, null);
            throw new KotlinNothingValueException();
        }
        for (int i = current; i < closingQuote; i++) {
            if (getSource().charAt(i) == '\\') {
                return consumeString(getSource(), this.currentPosition, i);
            }
        }
        int i2 = closingQuote + 1;
        this.currentPosition = i2;
        String strSubstring = getSource().substring(current, closingQuote);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override
    public void consumeStringChunked(boolean isLenient, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "consumeChunk");
        Iterable $this$forEach$iv = StringsKt.chunked(isLenient ? consumeStringLenient() : consumeString(), 16384);
        for (Object element$iv : $this$forEach$iv) {
            function1.invoke(element$iv);
        }
    }

    @Override
    public String peekLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int positionSnapshot = this.currentPosition;
        try {
            if (consumeNextToken() != 6) {
                return null;
            }
            String firstKey = peekString(isLenient);
            if (!Intrinsics.areEqual(firstKey, keyToMatch)) {
                return null;
            }
            discardPeeked();
            if (consumeNextToken() != 5) {
                return null;
            }
            return peekString(isLenient);
        } finally {
            this.currentPosition = positionSnapshot;
            discardPeeked();
        }
    }
}
