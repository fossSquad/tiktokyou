package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/StringJsonLexerWithComments;", "Lni/shikatu/kotlinx/serialization/json/internal/StringJsonLexer;", "source", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonConfiguration;)V", "consumeNextToken", _UrlKt.FRAGMENT_ENCODE_SET, "canConsumeValue", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "expected", _UrlKt.FRAGMENT_ENCODE_SET, "peekNextToken", "skipWhitespaces", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StringJsonLexerWithComments extends StringJsonLexer {

    public StringJsonLexerWithComments(String source, JsonConfiguration configuration) {
        super(source, configuration);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    @Override
    public byte consumeNextToken() {
        String source = getSource();
        int cpos = skipWhitespaces();
        if (cpos >= source.length() || cpos == -1) {
            return (byte) 10;
        }
        this.currentPosition = cpos + 1;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(cpos));
    }

    @Override
    public boolean canConsumeValue() {
        int current = skipWhitespaces();
        if (current >= getSource().length() || current == -1) {
            return false;
        }
        return isValidValueStart(getSource().charAt(current));
    }

    @Override
    public void consumeNextToken(char expected) {
        String source = getSource();
        int current = skipWhitespaces();
        if (current >= source.length() || current == -1) {
            this.currentPosition = -1;
            unexpectedToken(expected);
        }
        char c = source.charAt(current);
        this.currentPosition = current + 1;
        if (c == expected) {
            return;
        }
        unexpectedToken(expected);
    }

    @Override
    public byte peekNextToken() {
        String source = getSource();
        int cpos = skipWhitespaces();
        if (cpos >= source.length() || cpos == -1) {
            return (byte) 10;
        }
        this.currentPosition = cpos;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(cpos));
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
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                current++;
            } else {
                if (c == '/' && current + 1 < source.length()) {
                    switch (source.charAt(current + 1)) {
                        case '*':
                            int current2 = StringsKt.indexOf$default((CharSequence) source, "*/", current + 2, false, 4, (Object) null);
                            if (current2 == -1) {
                                this.currentPosition = source.length();
                                AbstractJsonLexer.fail$default(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                                throw new KotlinNothingValueException();
                            }
                            current = current2 + 2;
                            continue;
                            break;
                        case '/':
                            int current3 = StringsKt.indexOf$default((CharSequence) source, '\n', current + 2, false, 4, (Object) null);
                            if (current3 != -1) {
                                current = current3 + 1;
                                continue;
                            } else {
                                current = source.length();
                            }
                            break;
                    }
                }
                this.currentPosition = current;
                return current;
            }
        }
        this.currentPosition = current;
        return current;
    }
}
