package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0010\u0018\u00002\u00020\u0001B#\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0082\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\u0012\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004J\n\u0010\u001f\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010 \u001a\u00020\u0017H\u0096\u0080\u0004J\n\u0010!\u001a\u00020\"H\u0096\u0080\u0004J\u001a\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u000fH\u0096\u0080\u0004J\u001a\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0096\u0080\u0004J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fH\u0094\u0080\u0004J\u001c\u0010+\u001a\u0004\u0018\u00010\"2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0015H\u0096\u0080\u0004J\n\u0010.\u001a\u00020\u0017H\u0086\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f8\u0004@\u0004X\u0085\u008e\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0010\u001a\u00020\u0011X\u0094\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006/"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/ReaderJsonLexer;", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "reader", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonReader;", "buffer", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonReader;[CLkotlinx/serialization/json/JsonConfiguration;)V", "getReader", "()Lkotlinx/serialization/json/internal/InternalJsonReader;", "getBuffer", "()[C", "threshold", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/kotlinx/serialization/json/internal/ArrayAsSequence;", "getSource", "()Lkotlinx/serialization/json/internal/ArrayAsSequence;", "canConsumeValue", _UrlKt.FRAGMENT_ENCODE_SET, "preload", _UrlKt.FRAGMENT_ENCODE_SET, "unprocessedCount", "prefetchOrEof", "position", "consumeNextToken", _UrlKt.FRAGMENT_ENCODE_SET, "expected", _UrlKt.FRAGMENT_ENCODE_SET, "skipWhitespaces", "ensureHaveChars", "consumeKeyString", _UrlKt.FRAGMENT_ENCODE_SET, "indexOf", "char", "startPos", "substring", "endPos", "appendRange", "fromIndex", "toIndex", "peekLeadingMatchingValue", "keyToMatch", "isLenient", "release", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ReaderJsonLexer extends AbstractJsonLexer {
    private final char[] buffer;
    private final InternalJsonReader reader;
    private final ArrayAsSequence source;
    protected int threshold;

    public ReaderJsonLexer(InternalJsonReader reader, char[] buffer, JsonConfiguration configuration) {
        super(configuration);
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.reader = reader;
        this.buffer = buffer;
        this.threshold = 128;
        this.source = new ArrayAsSequence(this.buffer);
        preload(0);
    }

    public  ReaderJsonLexer(InternalJsonReader internalJsonReader, char[] cArr, JsonConfiguration jsonConfiguration, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalJsonReader, (i & 2) != 0 ? CharArrayPoolBatchSize.INSTANCE.take() : cArr, jsonConfiguration);
    }

    public final InternalJsonReader getReader() {
        return this.reader;
    }

    public final char[] getBuffer() {
        return this.buffer;
    }

    @Override
    public ArrayAsSequence getSource() {
        return this.source;
    }

    @Override
    public boolean canConsumeValue() {
        ensureHaveChars();
        int current = this.currentPosition;
        while (true) {
            int current2 = prefetchOrEof(current);
            if (current2 != -1) {
                char c = getSource().charAt(current2);
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    current = current2 + 1;
                } else {
                    this.currentPosition = current2;
                    return isValidValueStart(c);
                }
            } else {
                this.currentPosition = current2;
                return false;
            }
        }
    }

    private final void preload(int unprocessedCount) {
        char[] buffer = getSource().getBuffer$kotlinx_serialization_json();
        if (unprocessedCount != 0) {
            ArraysKt.copyInto(buffer, buffer, 0, this.currentPosition, this.currentPosition + unprocessedCount);
        }
        int filledCount = unprocessedCount;
        int sizeTotal = getSource().length();
        while (filledCount != sizeTotal) {
            int actual = this.reader.read(buffer, filledCount, sizeTotal - filledCount);
            if (actual == -1) {
                getSource().trim(filledCount);
                this.threshold = -1;
                break;
            }
            filledCount += actual;
        }
        this.currentPosition = 0;
    }

    @Override
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
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
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int cpos = this.currentPosition;
        while (true) {
            int cpos2 = prefetchOrEof(cpos);
            if (cpos2 != -1) {
                int cpos3 = cpos2 + 1;
                char ch = source.charAt(cpos2);
                byte tc = AbstractJsonLexerKt.charToTokenClass(ch);
                if (tc == 3) {
                    cpos = cpos3;
                } else {
                    this.currentPosition = cpos3;
                    return tc;
                }
            } else {
                this.currentPosition = cpos2;
                return (byte) 10;
            }
        }
    }

    @Override
    public void consumeNextToken(char expected) {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int cpos = this.currentPosition;
        while (true) {
            int cpos2 = prefetchOrEof(cpos);
            if (cpos2 != -1) {
                int cpos3 = cpos2 + 1;
                char c = source.charAt(cpos2);
                if (!(c == ' ' || c == '\n' || c == '\r' || c == '\t')) {
                    this.currentPosition = cpos3;
                    if (c == expected) {
                        return;
                    } else {
                        unexpectedToken(expected);
                    }
                }
                cpos = cpos3;
            } else {
                this.currentPosition = cpos2;
                unexpectedToken(expected);
                return;
            }
        }
    }

    @Override
    public int skipWhitespaces() {
        int current;
        int current2 = this.currentPosition;
        while (true) {
            current = prefetchOrEof(current2);
            if (current != -1) {
                char c = getSource().charAt(current);
                if (!(c == ' ' || c == '\n' || c == '\r' || c == '\t')) {
                    break;
                }
                current2 = current + 1;
            } else {
                break;
            }
        }
        this.currentPosition = current;
        return current;
    }

    @Override
    public void ensureHaveChars() {
        int cur = this.currentPosition;
        int oldSize = getSource().length();
        int spaceLeft = oldSize - cur;
        if (spaceLeft > this.threshold) {
            return;
        }
        preload(spaceLeft);
    }

    @Override
    public String consumeKeyString() {
        consumeNextToken('\"');
        int current = this.currentPosition;
        int closingQuote = indexOf('\"', current);
        if (closingQuote == -1) {
            int current2 = prefetchOrEof(current);
            if (current2 != -1) {
                return consumeString(getSource(), this.currentPosition, current2);
            }
            ReaderJsonLexer $this$iv = this;
            String expected$iv = AbstractJsonLexerKt.tokenDescription((byte) 1);
            int position$iv = $this$iv.currentPosition > 0 ? $this$iv.currentPosition - 1 : $this$iv.currentPosition;
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
        return substring(current, closingQuote);
    }

    @Override
    public int indexOf(char c, int startPos) {
        ArrayAsSequence src = getSource();
        int length = src.length();
        for (int i = startPos; i < length; i++) {
            if (src.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String substring(int startPos, int endPos) {
        return getSource().substring(startPos, endPos);
    }

    @Override
    protected void appendRange(int fromIndex, int toIndex) {
        Intrinsics.checkNotNullExpressionValue(getEscapedString().append(getSource().getBuffer$kotlinx_serialization_json(), fromIndex, toIndex - fromIndex), "append(...)");
    }

    @Override
    public String peekLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        return null;
    }

    public final void release() {
        CharArrayPoolBatchSize.INSTANCE.release(this.buffer);
    }
}
