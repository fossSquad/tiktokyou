package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0084\u0088\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0011H\u0086\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH¦\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0011H¦\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH¦\u0080\u0004J\n\u0010\u001b\u001a\u00020\u0011H\u0086\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0012H\u0084\u0080\u0004J\n\u0010\u001e\u001a\u00020\u0014H\u0086\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001aH\u0087\u0080\bJ\u0012\u0010\u0019\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0012H¦\u0080\u0004J\u0012\u0010)\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0012H\u0084\u0080\u0004J^\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001a2\b\b\u0002\u0010-\u001a\u00020\u001128\b\u0002\u0010.\u001a2\u0012\u0013\u0012\u00110 ¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b((\u0012\u0013\u0012\u00110 ¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020 0/H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b2J\n\u00103\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u00104\u001a\u00020\u00112\b\b\u0002\u00105\u001a\u00020\u0011H\u0086\u0080\u0004J\n\u00106\u001a\u00020\rH¦\u0080\u0004J\u001c\u00107\u001a\u0004\u0018\u00010 2\u0006\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u0011H¦\u0080\u0004J\u0014\u0010:\u001a\u0004\u0018\u00010 2\u0006\u00109\u001a\u00020\u0011H\u0086\u0080\u0004J\n\u0010;\u001a\u00020\u0014H\u0086\u0080\u0004J\u001a\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\rH\u0096\u0080\u0004J\u001a\u0010?\u001a\u00020 2\u0006\u0010>\u001a\u00020\r2\u0006\u0010@\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010A\u001a\u00020 H¦\u0080\u0004J\u001a\u0010B\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0012H\u0082\u0080\u0004J5\u0010C\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00112!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00140EH\u0096\u0080\u0004JE\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u00112!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00140EH\u0082\u0080\u0004J\n\u0010K\u001a\u00020 H\u0086\u0080\u0004J\"\u0010K\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\rH\u0085\u0080\u0004J\u001a\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\r2\u0006\u0010M\u001a\u00020\rH\u0082\u0080\u0004J\u001a\u0010P\u001a\u00020 2\u0006\u0010O\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0082\u0080\u0004J\n\u0010Q\u001a\u00020 H\u0082\u0080\u0004J\n\u0010R\u001a\u00020 H\u0086\u0080\u0004J\n\u0010S\u001a\u00020\u0011H\u0082\u0080\u0004J\n\u0010T\u001a\u00020 H\u0086\u0080\u0004J\u001a\u0010U\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\rH\u0094\u0080\u0004J\u0012\u0010V\u001a\u00020\r2\u0006\u0010L\u001a\u00020\rH\u0082\u0080\u0004J\u001a\u0010W\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010>\u001a\u00020\rH\u0082\u0080\u0004J2\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020 0ZH\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b[J\u001a\u0010\\\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u0011H\u0086\u0080\u0004J\n\u0010_\u001a\u00020 H\u0096\u0080\u0004J\u0012\u0010`\u001a\u00020\u00142\u0006\u0010a\u001a\u00020 H\u0086\u0080\u0004J(\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020 2\b\b\u0002\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010 H\u0086\u0080\u0004J\n\u0010c\u001a\u00020dH\u0086\u0080\u0004J\n\u0010e\u001a\u00020dH\u0086\u0080\u0004J\n\u0010f\u001a\u00020\u0011H\u0086\u0080\u0004J\n\u0010g\u001a\u00020\u0011H\u0086\u0080\u0004J\u0012\u0010f\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\rH\u0083\u0080\u0004J\u001a\u0010i\u001a\u00020\u00142\u0006\u0010j\u001a\u00020 2\u0006\u0010M\u001a\u00020\rH\u0082\u0080\u0004J#\u0010k\u001a\u0002Hl\"\u0004\b\u0000\u0010l2\f\u0010m\u001a\b\u0012\u0004\u0012\u0002Hl0ZH\u0082\u0088\u0004¢\u0006\u0002\u0010nR\u0015\u0010\u0002\u001a\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\tX¤\u0084\b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010!\u001a\u00060\"j\u0002`#X\u0084\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006o"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;)V", "getConfiguration$kotlinx_serialization_json", "()Lkotlinx/serialization/json/JsonConfiguration;", "source", _UrlKt.FRAGMENT_ENCODE_SET, "getSource", "()Ljava/lang/CharSequence;", "currentPosition", _UrlKt.FRAGMENT_ENCODE_SET, "path", "Lni/shikatu/kotlinx/serialization/json/internal/JsonPath;", "isWs", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "ensureHaveChars", _UrlKt.FRAGMENT_ENCODE_SET, "isNotEof", "prefetchOrEof", "position", "canConsumeValue", "consumeNextToken", _UrlKt.FRAGMENT_ENCODE_SET, "tryConsumeComma", "isValidValueStart", "c", "expectEof", "peekedString", _UrlKt.FRAGMENT_ENCODE_SET, "escapedString", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "expected", "unexpectedToken", "fail", _UrlKt.FRAGMENT_ENCODE_SET, "expectedToken", "wasConsumed", "message", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "fail$kotlinx_serialization_json", "peekNextToken", "tryConsumeNull", "doConsume", "skipWhitespaces", "peekLeadingMatchingValue", "keyToMatch", "isLenient", "peekString", "discardPeeked", "indexOf", "char", "startPos", "substring", "endPos", "consumeKeyString", "insideString", "consumeStringChunked", "consumeChunk", "Lni/shikatu/kotlin/Function1;", "stringChunk", "writeRange", "fromIndex", "toIndex", "currentChunkHasEscape", "consumeString", "startPosition", "current", "appendEscape", "lastPosition", "decodedString", "takePeeked", "consumeStringLenientNotNull", "wasUnquotedString", "consumeStringLenient", "appendRange", "appendEsc", "appendHex", "require", "condition", "Lni/shikatu/kotlin/Function0;", "require$kotlinx_serialization_json", "fromHexChar", "skipElement", "allowLenientStrings", "toString", "failOnUnknownKey", "key", "hint", "consumeNumericLiteral", _UrlKt.FRAGMENT_ENCODE_SET, "consumeNumericLiteralFully", "consumeBoolean", "consumeBooleanLenient", "start", "consumeBooleanLiteral", "literalSuffix", "withPositionRollback", "T", "action", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractJsonLexer {
    private final JsonConfiguration configuration;
    public int currentPosition;
    private StringBuilder escapedString;
    public final JsonPath path;
    private String peekedString;

    public abstract boolean canConsumeValue();

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public abstract void consumeNextToken(char c);

    public abstract CharSequence getSource();

    public abstract String peekLeadingMatchingValue(String str, boolean z);

    public abstract int prefetchOrEof(int i);

    public abstract int skipWhitespaces();

    public AbstractJsonLexer(JsonConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.configuration = configuration;
        this.path = new JsonPath(this.configuration);
        this.escapedString = new StringBuilder();
    }

    public final JsonConfiguration getConfiguration$kotlinx_serialization_json() {
        return this.configuration;
    }

    protected final boolean isWs(char $this$isWs) {
        return $this$isWs == ' ' || $this$isWs == '\n' || $this$isWs == '\r' || $this$isWs == '\t';
    }

    public void ensureHaveChars() {
    }

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    public final boolean tryConsumeComma() {
        int current = skipWhitespaces();
        CharSequence source = getSource();
        if (current >= source.length() || current == -1 || source.charAt(current) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    protected final boolean isValidValueStart(char c) {
        switch (c) {
            case ',':
            case ':':
            case ']':
            case '}':
                return false;
            default:
                return true;
        }
    }

    public final void expectEof() {
        byte nextToken = consumeNextToken();
        if (nextToken != 10) {
            fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    protected final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    protected final void setEscapedString(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.escapedString = sb;
    }

    @IgnorableReturnValue
    public final byte consumeNextToken(byte expected) {
        byte token = consumeNextToken();
        if (token == expected) {
            return token;
        }
        String expected$iv = AbstractJsonLexerKt.tokenDescription(expected);
        int position$iv = this.currentPosition > 0 ? this.currentPosition - 1 : this.currentPosition;
        String s$iv = (this.currentPosition == getSource().length() || position$iv < 0) ? "EOF" : String.valueOf(getSource().charAt(position$iv));
        fail$default(this, "Expected " + expected$iv + ", but had '" + s$iv + "' instead", position$iv, null, 4, null);
        throw new KotlinNothingValueException();
    }

    protected final void unexpectedToken(char expected) {
        if (this.currentPosition > 0 && expected == '\"') {
            int snapshot$iv = this.currentPosition;
            try {
                this.currentPosition--;
                String inputLiteral = consumeStringLenient();
                this.currentPosition = snapshot$iv;
                if (Intrinsics.areEqual(inputLiteral, AbstractJsonLexerKt.NULL)) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, AbstractJsonLexerKt.coerceInputValuesHint);
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.currentPosition = snapshot$iv;
                throw th;
            }
        }
        byte expectedToken$iv = AbstractJsonLexerKt.charToTokenClass(expected);
        String expected$iv = AbstractJsonLexerKt.tokenDescription(expectedToken$iv);
        int position$iv = this.currentPosition > 0 ? this.currentPosition - 1 : this.currentPosition;
        String s$iv = (this.currentPosition == getSource().length() || position$iv < 0) ? "EOF" : String.valueOf(getSource().charAt(position$iv));
        fail$default(this, "Expected " + expected$iv + ", but had '" + s$iv + "' instead", position$iv, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public static  Void fail$kotlinx_serialization_json$default(AbstractJsonLexer $this, byte expectedToken, boolean wasConsumed, Function2 message, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i & 2) != 0) {
            wasConsumed = true;
        }
        if ((i & 4) != 0) {
            Function2 message2 = new Function2<String, String, String>() {
                @Override
                public final String invoke(String expected, String source) {
                    Intrinsics.checkNotNullParameter(expected, "expected");
                    Intrinsics.checkNotNullParameter(source, "source");
                    return "Expected " + expected + ", but had '" + source + "' instead";
                }
            };
            message = message2;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        String expected = AbstractJsonLexerKt.tokenDescription(expectedToken);
        int position = (!wasConsumed || $this.currentPosition <= 0) ? $this.currentPosition : $this.currentPosition - 1;
        String s = ($this.currentPosition == $this.getSource().length() || position < 0) ? "EOF" : String.valueOf($this.getSource().charAt(position));
        fail$default($this, (String) message.invoke(expected, s), position, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final Void fail$kotlinx_serialization_json(byte expectedToken, boolean wasConsumed, Function2<? super String, ? super String, String> function2) {
        Intrinsics.checkNotNullParameter(function2, "message");
        String expected = AbstractJsonLexerKt.tokenDescription(expectedToken);
        int position = (!wasConsumed || this.currentPosition <= 0) ? this.currentPosition : this.currentPosition - 1;
        String s = (this.currentPosition == getSource().length() || position < 0) ? "EOF" : String.valueOf(getSource().charAt(position));
        fail$default(this, function2.invoke(expected, s), position, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public byte peekNextToken() {
        CharSequence source = getSource();
        int cpos = this.currentPosition;
        while (true) {
            int cpos2 = prefetchOrEof(cpos);
            if (cpos2 != -1) {
                char ch = source.charAt(cpos2);
                switch (ch) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        cpos = cpos2 + 1;
                        break;
                    default:
                        this.currentPosition = cpos2;
                        return AbstractJsonLexerKt.charToTokenClass(ch);
                }
            } else {
                this.currentPosition = cpos2;
                return (byte) 10;
            }
        }
    }

    public static  boolean tryConsumeNull$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return abstractJsonLexer.tryConsumeNull(z);
    }

    public final boolean tryConsumeNull(boolean doConsume) {
        int current = prefetchOrEof(skipWhitespaces());
        int len = getSource().length() - current;
        if (len < 4 || current == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (AbstractJsonLexerKt.NULL.charAt(i) != getSource().charAt(current + i)) {
                return false;
            }
        }
        if (len > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(current + 4)) == 0) {
            return false;
        }
        if (doConsume) {
            this.currentPosition = current + 4;
            return true;
        }
        return true;
    }

    public final String peekString(boolean isLenient) {
        String string;
        byte token = peekNextToken();
        if (isLenient) {
            if (token != 1 && token != 0) {
                return null;
            }
            string = consumeStringLenient();
        } else {
            if (token != 1) {
                return null;
            }
            string = consumeString();
        }
        this.peekedString = string;
        return string;
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public int indexOf(char c, int startPos) {
        return StringsKt.indexOf$default(getSource(), c, startPos, false, 4, (Object) null);
    }

    public String substring(int startPos, int endPos) {
        return getSource().subSequence(startPos, endPos).toString();
    }

    private final boolean insideString(boolean isLenient, char c) {
        if (isLenient) {
            return AbstractJsonLexerKt.charToTokenClass(c) == 0;
        }
        return c != '\"';
    }

    public void consumeStringChunked(boolean isLenient, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "consumeChunk");
        byte nextToken = peekNextToken();
        if (!isLenient || nextToken == 0) {
            if (!isLenient) {
                consumeNextToken('\"');
            }
            int currentPosition = this.currentPosition;
            int lastPosition = currentPosition;
            char cCharAt = getSource().charAt(currentPosition);
            boolean usedAppend = false;
            while (insideString(isLenient, cCharAt)) {
                if (!isLenient && cCharAt == '\\') {
                    usedAppend = true;
                    currentPosition = prefetchOrEof(appendEscape(lastPosition, currentPosition));
                    lastPosition = currentPosition;
                } else {
                    currentPosition++;
                }
                if (currentPosition >= getSource().length()) {
                    writeRange(lastPosition, currentPosition, usedAppend, function1);
                    usedAppend = false;
                    int currentPosition2 = prefetchOrEof(currentPosition);
                    if (currentPosition2 == -1) {
                        fail$default(this, "EOF", currentPosition2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    currentPosition = currentPosition2;
                    lastPosition = currentPosition;
                }
                cCharAt = getSource().charAt(currentPosition);
            }
            writeRange(lastPosition, currentPosition, usedAppend, function1);
            this.currentPosition = currentPosition;
            if (!isLenient) {
                consumeNextToken('\"');
            }
        }
    }

    private final void writeRange(int fromIndex, int toIndex, boolean currentChunkHasEscape, Function1<? super String, Unit> function1) {
        if (currentChunkHasEscape) {
            function1.invoke(decodedString(fromIndex, toIndex));
        } else {
            function1.invoke(substring(fromIndex, toIndex));
        }
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    protected final String consumeString(CharSequence source, int startPosition, int current) {
        String string;
        Intrinsics.checkNotNullParameter(source, "source");
        int currentPosition = current;
        boolean usedAppend = false;
        int lastPosition = startPosition;
        char cCharAt = source.charAt(currentPosition);
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                int currentPosition2 = prefetchOrEof(appendEscape(lastPosition, currentPosition));
                if (currentPosition2 == -1) {
                    fail$default(this, "Unexpected EOF", currentPosition2, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                currentPosition = currentPosition2;
                lastPosition = currentPosition;
                usedAppend = true;
            } else {
                currentPosition++;
                if (currentPosition >= source.length()) {
                    appendRange(lastPosition, currentPosition);
                    int currentPosition3 = prefetchOrEof(currentPosition);
                    if (currentPosition3 == -1) {
                        fail$default(this, "Unexpected EOF", currentPosition3, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    currentPosition = currentPosition3;
                    lastPosition = currentPosition;
                    usedAppend = true;
                } else {
                    continue;
                }
            }
            cCharAt = source.charAt(currentPosition);
        }
        if (!usedAppend) {
            string = substring(lastPosition, currentPosition);
        } else {
            string = decodedString(lastPosition, currentPosition);
        }
        this.currentPosition = currentPosition + 1;
        return string;
    }

    private final int appendEscape(int lastPosition, int current) {
        appendRange(lastPosition, current);
        return appendEsc(current + 1);
    }

    private final String decodedString(int lastPosition, int currentPosition) {
        appendRange(lastPosition, currentPosition);
        String result = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(result, "toString(...)");
        this.escapedString.setLength(0);
        return result;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenientNotNull() {
        String result = consumeStringLenient();
        if (Intrinsics.areEqual(result, AbstractJsonLexerKt.NULL) && wasUnquotedString()) {
            fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return result;
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    public final String consumeStringLenient() {
        String result;
        if (this.peekedString != null) {
            return takePeeked();
        }
        int current = skipWhitespaces();
        if (current >= getSource().length() || current == -1) {
            fail$default(this, "EOF", current, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte token = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(current));
        if (token == 1) {
            return consumeString();
        }
        if (token != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(current), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean usedAppend = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(current)) == 0) {
            current++;
            if (current >= getSource().length()) {
                usedAppend = true;
                appendRange(this.currentPosition, current);
                int eof = prefetchOrEof(current);
                if (eof == -1) {
                    this.currentPosition = current;
                    return decodedString(0, 0);
                }
                current = eof;
            }
        }
        if (!usedAppend) {
            result = substring(this.currentPosition, current);
        } else {
            result = decodedString(this.currentPosition, current);
        }
        this.currentPosition = current;
        return result;
    }

    protected void appendRange(int fromIndex, int toIndex) {
        this.escapedString.append(getSource(), fromIndex, toIndex);
    }

    private final int appendEsc(int startPosition) {
        int currentPosition = prefetchOrEof(startPosition);
        if (currentPosition == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int currentPosition2 = currentPosition + 1;
        char currentChar = getSource().charAt(currentPosition);
        if (currentChar == 'u') {
            return appendHex(getSource(), currentPosition2);
        }
        char c = AbstractJsonLexerKt.escapeToChar(currentChar);
        if (c == 0) {
            fail$default(this, "Invalid escaped char '" + currentChar + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        this.escapedString.append(c);
        return currentPosition2;
    }

    private final int appendHex(CharSequence source, int startPos) {
        if (startPos + 4 < source.length()) {
            this.escapedString.append((char) ((fromHexChar(source, startPos) << 12) + (fromHexChar(source, startPos + 1) << 8) + (fromHexChar(source, startPos + 2) << 4) + fromHexChar(source, startPos + 3)));
            return startPos + 4;
        }
        this.currentPosition = startPos;
        ensureHaveChars();
        if (this.currentPosition + 4 < source.length()) {
            return appendHex(source, this.currentPosition);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public static  void require$kotlinx_serialization_json$default(AbstractJsonLexer $this, boolean condition, int position, Function0 message, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: require");
        }
        if ((i & 2) != 0) {
            position = $this.currentPosition;
        }
        int position2 = position;
        Intrinsics.checkNotNullParameter(message, "message");
        if (!condition) {
            fail$default($this, (String) message.invoke(), position2, null, 4, null);
            throw new KotlinNothingValueException();
        }
    }

    public final void require$kotlinx_serialization_json(boolean condition, int position, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "message");
        if (!condition) {
            fail$default(this, function0.invoke(), position, null, 4, null);
            throw new KotlinNothingValueException();
        }
    }

    private final int fromHexChar(CharSequence source, int currentPosition) {
        char character = source.charAt(currentPosition);
        if ('0' <= character && character < ':') {
            return character - '0';
        }
        if ('a' <= character && character < 'g') {
            return (character - 'a') + 10;
        }
        if ('A' <= character && character < 'G') {
            return (character - 'A') + 10;
        }
        fail$default(this, "Invalid toHexChar char '" + character + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void skipElement(boolean allowLenientStrings) {
        List tokenStack = new ArrayList();
        byte lastToken = peekNextToken();
        if (lastToken != 8 && lastToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte lastToken2 = peekNextToken();
            if (lastToken2 == 1) {
                if (allowLenientStrings) {
                    consumeStringLenient();
                } else {
                    consumeKeyString();
                }
            } else {
                if (lastToken2 == 8 || lastToken2 == 6) {
                    tokenStack.add(Byte.valueOf(lastToken2));
                } else if (lastToken2 == 9) {
                    if (((Number) CollectionsKt.last(tokenStack)).byteValue() != 8) {
                        fail$default(this, "found ] instead of }", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    CollectionsKt.removeLast(tokenStack);
                } else if (lastToken2 == 7) {
                    if (((Number) CollectionsKt.last(tokenStack)).byteValue() != 6) {
                        fail$default(this, "found } instead of ]", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    CollectionsKt.removeLast(tokenStack);
                } else if (lastToken2 == 10) {
                    fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                consumeNextToken();
                if (tokenStack.size() == 0) {
                    return;
                }
            }
        }
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) getSource()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public final void failOnUnknownKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String processed = substring(0, this.currentPosition);
        int lastIndexOf = StringsKt.lastIndexOf$default((CharSequence) processed, key, 0, false, 6, (Object) null);
        fail("Encountered an unknown key '" + key + '\'', lastIndexOf, AbstractJsonLexerKt.ignoreUnknownKeysHint);
        throw new KotlinNothingValueException();
    }

    public static  Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i2 & 2) != 0) {
            i = abstractJsonLexer.currentPosition;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return abstractJsonLexer.fail(str, i, str2);
    }

    public final Void fail(String message, int position, String hint) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw JsonExceptionsKt.decodingExceptionOf(this, message, position, this.path.getPath(), hint, getSource());
    }

    public final long consumeNumericLiteral() {
        boolean z;
        int current;
        int current2 = prefetchOrEof(skipWhitespaces());
        if (current2 >= getSource().length() || current2 == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(current2) == '\"') {
            current2++;
            if (current2 == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            z = true;
        } else {
            z = false;
        }
        boolean hasQuotation = z;
        int start = current2;
        boolean isExponentPositive = false;
        boolean hasExponent = false;
        long exponentAccumulator = 0;
        long accumulator = 0;
        int current3 = current2;
        int current4 = 0;
        while (current3 != getSource().length()) {
            char ch = getSource().charAt(current3);
            if ((ch == 'e' || ch == 'E') && !hasExponent) {
                if (current3 == start) {
                    fail$default(this, "Unexpected symbol '" + ch + "' in numeric literal", current3, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                isExponentPositive = true;
                hasExponent = true;
                current3++;
            } else if (ch == '-' && hasExponent) {
                if (current3 == start) {
                    fail$default(this, "Unexpected symbol '-' in numeric literal", current3, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                isExponentPositive = false;
                current3++;
            } else if (ch == '+' && hasExponent) {
                if (current3 == start) {
                    fail$default(this, "Unexpected symbol '+' in numeric literal", current3, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                isExponentPositive = true;
                current3++;
            } else if (ch == '-') {
                if (current3 != start) {
                    fail$default(this, "Unexpected symbol '-' in numeric literal", current3, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                current4 = 1;
                current3++;
            } else {
                byte token = AbstractJsonLexerKt.charToTokenClass(ch);
                if (token != 0) {
                    break;
                }
                int current5 = current3 + 1;
                int digit = ch - '0';
                if (!(digit >= 0 && digit < 10)) {
                    fail$default(this, "Unexpected symbol '" + ch + "' in numeric literal", current5 - 1, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                if (hasExponent) {
                    exponentAccumulator = (((long) 10) * exponentAccumulator) + ((long) digit);
                    current3 = current5;
                } else {
                    accumulator = (((long) 10) * accumulator) - ((long) digit);
                    if (accumulator > 0) {
                        fail$default(this, "Numeric value overflow", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    current3 = current5;
                }
            }
        }
        boolean hasChars = current3 != start;
        if (start == current3 || (current4 != 0 && start == current3 - 1)) {
            fail$default(this, "Expected numeric literal", current3, null, 4, null);
            throw new KotlinNothingValueException();
        }
        if (!hasQuotation) {
            current = current3;
        } else {
            if (!hasChars) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (getSource().charAt(current3) != '\"') {
                fail$default(this, "Expected closing quotation mark", current3, null, 4, null);
                throw new KotlinNothingValueException();
            }
            current = current3 + 1;
        }
        this.currentPosition = current;
        if (hasExponent) {
            double doubleAccumulator = accumulator * consumeNumericLiteral$calculateExponent(exponentAccumulator, isExponentPositive);
            if (doubleAccumulator > 9.223372036854776E18d || doubleAccumulator < -9.223372036854776E18d) {
                fail$default(this, "Numeric value overflow", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (!(Math.floor(doubleAccumulator) == doubleAccumulator)) {
                fail$default(this, "Can't convert " + doubleAccumulator + " to Long", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            accumulator = (long) doubleAccumulator;
        }
        if (current4 != 0) {
            return accumulator;
        }
        if (accumulator != Long.MIN_VALUE) {
            return -accumulator;
        }
        fail$default(this, "Numeric value overflow", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private static final double consumeNumericLiteral$calculateExponent(long exponentAccumulator, boolean isExponentPositive) {
        if (!isExponentPositive) {
            return Math.pow(10.0d, -exponentAccumulator);
        }
        if (!isExponentPositive) {
            throw new NoWhenBranchMatchedException();
        }
        return Math.pow(10.0d, exponentAccumulator);
    }

    public final long consumeNumericLiteralFully() {
        long result = consumeNumericLiteral();
        byte next = consumeNextToken();
        if (next == 10) {
            return result;
        }
        AbstractJsonLexerKt.tokenDescription((byte) 10);
        int position$iv = this.currentPosition > 0 ? this.currentPosition - 1 : this.currentPosition;
        String source = (this.currentPosition == getSource().length() || position$iv < 0) ? "EOF" : String.valueOf(getSource().charAt(position$iv));
        fail$default(this, "Expected input to contain a single valid number, but got '" + source + "' after it", position$iv, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int current = skipWhitespaces();
        if (current == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(current) == '\"') {
            current++;
            z = true;
        } else {
            z = false;
        }
        boolean hasQuotation = z;
        boolean result = consumeBoolean(current);
        if (hasQuotation) {
            if (this.currentPosition == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (getSource().charAt(this.currentPosition) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            this.currentPosition++;
        }
        return result;
    }

    private final boolean consumeBoolean(int start) {
        int current = prefetchOrEof(start);
        if (current >= getSource().length() || current == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int current2 = current + 1;
        switch (getSource().charAt(current) | ' ') {
            case HttpStatusCodesKt.HTTP_PROCESSING /* 102 */:
                consumeBooleanLiteral("alse", current2);
                return false;
            case 116:
                consumeBooleanLiteral("rue", current2);
                return true;
            default:
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
        }
    }

    private final void consumeBooleanLiteral(String literalSuffix, int current) {
        if (getSource().length() - current < literalSuffix.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = literalSuffix.length();
        for (int i = 0; i < length; i++) {
            char expected = literalSuffix.charAt(i);
            char actual = getSource().charAt(current + i);
            if (expected != (actual | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        int i2 = literalSuffix.length();
        this.currentPosition = current + i2;
    }

    private final <T> T withPositionRollback(Function0<? extends T> function0) {
        int snapshot = this.currentPosition;
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.currentPosition = snapshot;
            InlineMarker.finallyEnd(1);
        }
    }
}
