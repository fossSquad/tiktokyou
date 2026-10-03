package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\n\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0010H\u0096\u0080\u0004J\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0014H\u0096\u0080\u0004¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/ReaderJsonLexerWithComments;", "Lni/shikatu/kotlinx/serialization/json/internal/ReaderJsonLexer;", "reader", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonReader;", "buffer", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonReader;[CLkotlinx/serialization/json/JsonConfiguration;)V", "consumeNextToken", _UrlKt.FRAGMENT_ENCODE_SET, "expected", _UrlKt.FRAGMENT_ENCODE_SET, "canConsumeValue", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "peekNextToken", "handleComment", "Lni/shikatu/kotlin/Pair;", _UrlKt.FRAGMENT_ENCODE_SET, "position", "prefetchWithinThreshold", "skipWhitespaces", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReaderJsonLexerWithComments extends ReaderJsonLexer {

    public ReaderJsonLexerWithComments(InternalJsonReader reader, char[] buffer, JsonConfiguration configuration) {
        super(reader, buffer, configuration);
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    @Override
    public void consumeNextToken(char expected) {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
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
    public boolean canConsumeValue() {
        ensureHaveChars();
        int current = skipWhitespaces();
        if (current >= getSource().length() || current == -1) {
            return false;
        }
        return isValidValueStart(getSource().charAt(current));
    }

    @Override
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int cpos = skipWhitespaces();
        if (cpos >= source.length() || cpos == -1) {
            return (byte) 10;
        }
        this.currentPosition = cpos + 1;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(cpos));
    }

    @Override
    public byte peekNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int cpos = skipWhitespaces();
        if (cpos >= source.length() || cpos == -1) {
            return (byte) 10;
        }
        this.currentPosition = cpos;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(cpos));
    }

    private final Pair<Integer, Boolean> handleComment(int position) {
        int current = position;
        int startIndex = current + 2;
        switch (getSource().charAt(current + 1)) {
            case '*':
                boolean rareCaseHit = false;
                int startIndex2 = startIndex;
                while (current != -1) {
                    int current2 = StringsKt.indexOf$default((CharSequence) getSource(), "*/", startIndex2, false, 4, (Object) null);
                    if (current2 == -1) {
                        if (getSource().charAt(getSource().length() - 1) != '*') {
                            current = prefetchOrEof(getSource().length());
                            startIndex2 = current;
                        } else {
                            current = prefetchWithinThreshold(getSource().length() - 1);
                            if (rareCaseHit) {
                                this.currentPosition = getSource().length();
                                AbstractJsonLexer.fail$default(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                                throw new KotlinNothingValueException();
                            }
                            rareCaseHit = true;
                            startIndex2 = current;
                        }
                    } else {
                        return TuplesKt.to(Integer.valueOf(current2 + 2), true);
                    }
                }
                this.currentPosition = getSource().length();
                AbstractJsonLexer.fail$default(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                throw new KotlinNothingValueException();
            case '/':
                int startIndex3 = startIndex;
                while (current != -1) {
                    int current3 = StringsKt.indexOf$default((CharSequence) getSource(), '\n', startIndex3, false, 4, (Object) null);
                    if (current3 == -1) {
                        current = prefetchOrEof(getSource().length());
                        startIndex3 = current;
                    } else {
                        return TuplesKt.to(Integer.valueOf(current3 + 1), true);
                    }
                }
                return TuplesKt.to(-1, true);
            default:
                return TuplesKt.to(Integer.valueOf(current), false);
        }
    }

    private final int prefetchWithinThreshold(int position) {
        if (getSource().length() - position > this.threshold) {
            return position;
        }
        this.currentPosition = position;
        ensureHaveChars();
        if (this.currentPosition == 0) {
            return getSource().length() == 0 ? -1 : 0;
        }
        return -1;
    }

    @Override
    public int skipWhitespaces() {
        int current = this.currentPosition;
        while (true) {
            current = prefetchOrEof(current);
            if (current == -1) {
                break;
            }
            char c = getSource().charAt(current);
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                current++;
            } else {
                if (c != '/' || current + 1 >= getSource().length()) {
                    break;
                }
                Pair<Integer, Boolean> pairHandleComment = handleComment(current);
                int iIntValue = pairHandleComment.component1().intValue();
                boolean cont = pairHandleComment.component2().booleanValue();
                current = iIntValue;
                if (!cont) {
                    break;
                }
            }
        }
        this.currentPosition = current;
        return current;
    }
}
