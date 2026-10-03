package ni.shikatu.kotlin.text;

import java.util.Locale;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\f\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\r\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\u000e\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u000e\u0010\u000f\u001a\u00020\u0006*\u00020\u0002H\u0086\u0080\u0004\u001a\u0012\u0010\u0010\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\u0011\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001aV\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0006\b\u001a\u0012\u0002\b\fb\u0016\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0002\b\u0007\u001a \u0010 \u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a \u0010#\u001a\u00020$*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a$\u0010#\u001a\u00020$*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0087\u0080\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001d\u001aV\u0010'\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b((\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b()\u0012\u0006\b\u001a\u0012\u0002\b\fb\u0016\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0002\b\u0007\u001a \u0010*\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a \u0010+\u001a\u00020$*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a$\u0010+\u001a\u00020$*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0087\u0080\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001d\u001a\u0012\u0010,\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001aV\u0010-\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(/\u0012\u0006\b\u001a\u0012\u0002\b\fb\u0016\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0002\b\u0007\u001a \u00100\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a$\u00101\u001a\u00020$*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0087\u0080\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001d\u001a\u0012\u00106\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u00107\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u001a\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u000209H\u0080\u0080\u0004\u001a\u001a\u0010<\u001a\u0002092\u0006\u0010;\u001a\u000209H\u0081\u0080\bb\u0002\b=b\u0002\b>\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u00102\u001a\u000203*\u00020\u00028FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006?"}, d2 = {"category", "Lni/shikatu/kotlin/text/CharCategory;", _UrlKt.FRAGMENT_ENCODE_SET, "getCategory", "(C)Lkotlin/text/CharCategory;", "isDefined", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "isLetter", "isLetterOrDigit", "isDigit", "isIdentifierIgnorable", "isISOControl", "isJavaIdentifierPart", "isJavaIdentifierStart", "isWhitespace", "isUpperCase", "isLowerCase", "toUpperCase", "Lni/shikatu/kotlin/Deprecated;", "message", "Use uppercaseChar() instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "uppercaseChar()", "imports", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.5", "errorSince", "2.1", "uppercaseChar", "Lni/shikatu/kotlin/SinceKotlin;", "version", "uppercase", _UrlKt.FRAGMENT_ENCODE_SET, "locale", "Ljava/util/Locale;", "toLowerCase", "Use lowercaseChar() instead.", "lowercaseChar()", "lowercaseChar", "lowercase", "isTitleCase", "toTitleCase", "Use titlecaseChar() instead.", "titlecaseChar()", "titlecaseChar", "titlecase", "directionality", "Lni/shikatu/kotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "isHighSurrogate", "isLowSurrogate", "digitOf", _UrlKt.FRAGMENT_ENCODE_SET, "char", "radix", "checkRadix", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/CharsKt")
public class CharsKt__CharJVMKt {
    public static final CharCategory getCategory(char $this$category) {
        return CharCategory.Companion.valueOf(Character.getType($this$category));
    }

    private static final boolean isDefined(char $this$isDefined) {
        return Character.isDefined($this$isDefined);
    }

    private static final boolean isLetter(char $this$isLetter) {
        return Character.isLetter($this$isLetter);
    }

    private static final boolean isLetterOrDigit(char $this$isLetterOrDigit) {
        return Character.isLetterOrDigit($this$isLetterOrDigit);
    }

    private static final boolean isDigit(char $this$isDigit) {
        return Character.isDigit($this$isDigit);
    }

    private static final boolean isIdentifierIgnorable(char $this$isIdentifierIgnorable) {
        return Character.isIdentifierIgnorable($this$isIdentifierIgnorable);
    }

    private static final boolean isISOControl(char $this$isISOControl) {
        return Character.isISOControl($this$isISOControl);
    }

    private static final boolean isJavaIdentifierPart(char $this$isJavaIdentifierPart) {
        return Character.isJavaIdentifierPart($this$isJavaIdentifierPart);
    }

    private static final boolean isJavaIdentifierStart(char $this$isJavaIdentifierStart) {
        return Character.isJavaIdentifierStart($this$isJavaIdentifierStart);
    }

    public static final boolean isWhitespace(char $this$isWhitespace) {
        return Character.isWhitespace($this$isWhitespace) || Character.isSpaceChar($this$isWhitespace);
    }

    private static final boolean isUpperCase(char $this$isUpperCase) {
        return Character.isUpperCase($this$isUpperCase);
    }

    private static final boolean isLowerCase(char $this$isLowerCase) {
        return Character.isLowerCase($this$isLowerCase);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toUpperCase(char $this$toUpperCase) {
        return Character.toUpperCase($this$toUpperCase);
    }

    private static final char uppercaseChar(char $this$uppercaseChar) {
        return Character.toUpperCase($this$uppercaseChar);
    }

    private static final String uppercase(char $this$uppercase) {
        String strValueOf = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static final String uppercase(char $this$uppercase, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strValueOf = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toLowerCase(char $this$toLowerCase) {
        return Character.toLowerCase($this$toLowerCase);
    }

    private static final char lowercaseChar(char $this$lowercaseChar) {
        return Character.toLowerCase($this$lowercaseChar);
    }

    private static final String lowercase(char $this$lowercase) {
        String strValueOf = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String lowercase(char $this$lowercase, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strValueOf = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final boolean isTitleCase(char $this$isTitleCase) {
        return Character.isTitleCase($this$isTitleCase);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toTitleCase(char $this$toTitleCase) {
        return Character.toTitleCase($this$toTitleCase);
    }

    private static final char titlecaseChar(char $this$titlecaseChar) {
        return Character.toTitleCase($this$titlecaseChar);
    }

    public static final String titlecase(char $this$titlecase, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String localizedUppercase = CharsKt.uppercase($this$titlecase, locale);
        if (localizedUppercase.length() > 1) {
            if ($this$titlecase == 329) {
                return localizedUppercase;
            }
            char cCharAt = localizedUppercase.charAt(0);
            Intrinsics.checkNotNull(localizedUppercase, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = localizedUppercase.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return cCharAt + lowerCase;
        }
        String strValueOf = String.valueOf($this$titlecase);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (!Intrinsics.areEqual(localizedUppercase, upperCase)) {
            return localizedUppercase;
        }
        return String.valueOf(Character.toTitleCase($this$titlecase));
    }

    public static final CharDirectionality getDirectionality(char $this$directionality) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality($this$directionality));
    }

    private static final boolean isHighSurrogate(char $this$isHighSurrogate) {
        return Character.isHighSurrogate($this$isHighSurrogate);
    }

    private static final boolean isLowSurrogate(char $this$isLowSurrogate) {
        return Character.isLowSurrogate($this$isLowSurrogate);
    }

    public static final int digitOf(char c, int radix) {
        return Character.digit((int) c, radix);
    }

    @IgnorableReturnValue
    public static final int checkRadix(int radix) {
        boolean z = false;
        if (2 <= radix && radix < 37) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("radix " + radix + " was not in valid range " + new IntRange(2, 36));
        }
        return radix;
    }
}
