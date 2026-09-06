package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonDecoder;
import ni.shikatu.kotlinx.serialization.json.JsonDecodingException;
import ni.shikatu.kotlinx.serialization.json.JsonEncodingException;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0080\u0004\u001a?\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0080\u0088\u0004ø\u0001\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\tH\u0080\u0080\u0004\u001a\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0082\u0088\u0004\u001a\u001c\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0080\u0080\u0004\u001a8\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0082\u0080\u0004\u001a\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0012\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\u0080\u0004\u001a\u0016\u0010\u0019\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0080\u0080\u0004\u001a\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0080\u0080\u0004\u001a/\u0010\u001f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0080\u0088\u0004ø\u0001\u0000\u001a\u001c\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0082\u0080\u0004\u001a\u0018\u0010!\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"decodingExceptionOf", "Lni/shikatu/kotlinx/serialization/json/JsonDecodingException;", "shortMessage", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/json/JsonDecoder;", "path", "hint", "input", "Lni/shikatu/kotlin/Function0;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "offset", _UrlKt.FRAGMENT_ENCODE_SET, "ifDebugInput", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "block", "formatEncodingException", "formatDecodingException", "invalidTrailingComma", _UrlKt.FRAGMENT_ENCODE_SET, "entity", "InvalidKeyKindException", "Lni/shikatu/kotlinx/serialization/json/JsonEncodingException;", "keyDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "throwInvalidFloatingPointDecoded", "result", _UrlKt.FRAGMENT_ENCODE_SET, "InvalidFloatingPointEncoded", "value", "key", "InvalidFloatingPointDecoded", "nonFiniteFpMessage", "minify", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonExceptionsKt {
    public static final JsonDecodingException decodingExceptionOf(String shortMessage) {
        Intrinsics.checkNotNullParameter(shortMessage, "shortMessage");
        return new JsonDecodingException(formatDecodingException(-1, shortMessage, null, null, null), shortMessage, -1, null, null, null);
    }

    public static  JsonDecodingException decodingExceptionOf$default(JsonDecoder $this$decodingExceptionOf_u24default, String shortMessage, String path, String hint, Function0 input, int i, Object obj) {
        String path2;
        String hint2;
        if ((i & 2) == 0) {
            path2 = path;
        } else {
            path2 = null;
        }
        if ((i & 4) == 0) {
            hint2 = hint;
        } else {
            hint2 = null;
        }
        Intrinsics.checkNotNullParameter($this$decodingExceptionOf_u24default, "<this>");
        Intrinsics.checkNotNullParameter(shortMessage, "shortMessage");
        Intrinsics.checkNotNullParameter(input, "input");
        JsonConfiguration $this$ifDebugInput$iv = $this$decodingExceptionOf_u24default.getJson().getConfiguration();
        String inputValue = $this$ifDebugInput$iv.getExceptionsWithDebugInfo() ? minify$default((CharSequence) input.invoke(), 0, 1, null).toString() : null;
        return new JsonDecodingException(formatDecodingException(-1, shortMessage, path2, hint2, inputValue), shortMessage, -1, path2, inputValue, hint2);
    }

    public static final JsonDecodingException decodingExceptionOf(JsonDecoder $this$decodingExceptionOf, String shortMessage, String path, String hint, Function0<? extends CharSequence> function0) {
        Intrinsics.checkNotNullParameter($this$decodingExceptionOf, "<this>");
        Intrinsics.checkNotNullParameter(shortMessage, "shortMessage");
        Intrinsics.checkNotNullParameter(function0, "input");
        JsonConfiguration $this$ifDebugInput$iv = $this$decodingExceptionOf.getJson().getConfiguration();
        String inputValue = $this$ifDebugInput$iv.getExceptionsWithDebugInfo() ? minify$default(function0.invoke(), 0, 1, null).toString() : null;
        return new JsonDecodingException(formatDecodingException(-1, shortMessage, path, hint, inputValue), shortMessage, -1, path, inputValue, hint);
    }

    public static final JsonDecodingException decodingExceptionOf(AbstractJsonLexer $this$decodingExceptionOf, String shortMessage, int offset, String path, String hint, CharSequence input) {
        Intrinsics.checkNotNullParameter($this$decodingExceptionOf, "<this>");
        Intrinsics.checkNotNullParameter(shortMessage, "shortMessage");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(input, "input");
        JsonConfiguration $this$ifDebugInput$iv = $this$decodingExceptionOf.getConfiguration$kotlinx_serialization_json();
        String inputValue = $this$ifDebugInput$iv.getExceptionsWithDebugInfo() ? minify(input, offset).toString() : null;
        return new JsonDecodingException(formatDecodingException(offset, shortMessage, path, hint, inputValue), shortMessage, offset, path, inputValue, hint);
    }

    private static final String ifDebugInput(JsonConfiguration $this$ifDebugInput, Function0<String> function0) {
        if ($this$ifDebugInput.getExceptionsWithDebugInfo()) {
            return function0.invoke();
        }
        return null;
    }

    public static final String formatEncodingException(String shortMessage, String hint) {
        Intrinsics.checkNotNullParameter(shortMessage, "shortMessage");
        String str = hint;
        return shortMessage + (str == null || StringsKt.isBlank(str) ? _UrlKt.FRAGMENT_ENCODE_SET : '\n' + hint);
    }

    public static final String formatDecodingException(int offset, String shortMessage, String path, String hint, String input) {
        StringBuilder $this$formatDecodingException_u24lambda_u240 = new StringBuilder();
        if (offset >= 0) {
            $this$formatDecodingException_u24lambda_u240.append("Unexpected JSON token at offset " + offset + ": ");
        }
        $this$formatDecodingException_u24lambda_u240.append(shortMessage);
        String str = path;
        if (!(str == null || StringsKt.isBlank(str))) {
            $this$formatDecodingException_u24lambda_u240.append(" at path: ");
            $this$formatDecodingException_u24lambda_u240.append(path);
        }
        String str2 = hint;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            $this$formatDecodingException_u24lambda_u240.append('\n' + hint);
        }
        if (input != null) {
            $this$formatDecodingException_u24lambda_u240.append("\nJSON input: ");
            $this$formatDecodingException_u24lambda_u240.append(input);
        }
        return $this$formatDecodingException_u24lambda_u240.toString();
    }

    public static  Void invalidTrailingComma$default(AbstractJsonLexer abstractJsonLexer, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "object";
        }
        return invalidTrailingComma(abstractJsonLexer, str);
    }

    public static final Void invalidTrailingComma(AbstractJsonLexer $this$invalidTrailingComma, String entity) {
        Intrinsics.checkNotNullParameter($this$invalidTrailingComma, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        $this$invalidTrailingComma.fail("Trailing comma before the end of JSON " + entity, $this$invalidTrailingComma.currentPosition - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingComma = true' in 'Json {}' builder to support them.");
        throw new KotlinNothingValueException();
    }

    public static final JsonEncodingException InvalidKeyKindException(SerialDescriptor keyDescriptor) {
        Intrinsics.checkNotNullParameter(keyDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + keyDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.getKind() + '\'', keyDescriptor.getSerialName(), AbstractJsonLexerKt.allowStructuredMapKeysHint);
    }

    public static final Void throwInvalidFloatingPointDecoded(AbstractJsonLexer $this$throwInvalidFloatingPointDecoded, Number result) {
        Intrinsics.checkNotNullParameter($this$throwInvalidFloatingPointDecoded, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        AbstractJsonLexer.fail$default($this$throwInvalidFloatingPointDecoded, nonFiniteFpMessage(result, null), 0, AbstractJsonLexerKt.specialFlowingValuesHint, 2, null);
        throw new KotlinNothingValueException();
    }

    public static  JsonEncodingException InvalidFloatingPointEncoded$default(Number number, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return InvalidFloatingPointEncoded(number, str);
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number value, String key) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new JsonEncodingException(nonFiniteFpMessage(value, key), null, AbstractJsonLexerKt.specialFlowingValuesHint, 2, null);
    }

    public static final JsonDecodingException InvalidFloatingPointDecoded(JsonDecoder $this$InvalidFloatingPointDecoded, Number value, String key, Function0<? extends CharSequence> function0) {
        Intrinsics.checkNotNullParameter($this$InvalidFloatingPointDecoded, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "input");
        String shortMessage$iv = nonFiniteFpMessage(value, key);
        JsonConfiguration $this$ifDebugInput$iv$iv = $this$InvalidFloatingPointDecoded.getJson().getConfiguration();
        String inputValue$iv = null;
        if ($this$ifDebugInput$iv$iv.getExceptionsWithDebugInfo()) {
            inputValue$iv = minify$default(function0.invoke(), 0, 1, null).toString();
        }
        return new JsonDecodingException(formatDecodingException(-1, shortMessage$iv, null, AbstractJsonLexerKt.specialFlowingValuesHint, inputValue$iv), shortMessage$iv, -1, null, inputValue$iv, AbstractJsonLexerKt.specialFlowingValuesHint);
    }

    public static final String nonFiniteFpMessage(Number value, String key) {
        return "Unexpected special floating-point value " + value + (key != null ? " with key " + key + ". " : ". ") + "By default, non-finite floating point values are prohibited because they do not conform JSON specification.";
    }

    public static  CharSequence minify$default(CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return minify(charSequence, i);
    }

    public static final CharSequence minify(CharSequence $this$minify, int offset) {
        Intrinsics.checkNotNullParameter($this$minify, "<this>");
        if ($this$minify.length() < 200) {
            return $this$minify;
        }
        if (offset == -1) {
            int start = $this$minify.length() - 60;
            return start <= 0 ? $this$minify : "....." + $this$minify.subSequence(start, $this$minify.length()).toString();
        }
        int start2 = offset - 30;
        int end = offset + 30;
        String prefix = start2 <= 0 ? _UrlKt.FRAGMENT_ENCODE_SET : ".....";
        String suffix = end >= $this$minify.length() ? _UrlKt.FRAGMENT_ENCODE_SET : ".....";
        return prefix + $this$minify.subSequence(RangesKt.coerceAtLeast(start2, 0), RangesKt.coerceAtMost(end, $this$minify.length())).toString() + suffix;
    }
}
