package ni.shikatu.kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u0002H\u0086\u0080\u0004\u001ac\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010\t\u001a\u008a\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\u0088\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b( \u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010#j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`$H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(&\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b('\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010%\u001ac\u0010(\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b()\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(*\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010\t\u001a\u008a\u0001\u0010+\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\u0088\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(,\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(-\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010#j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`$H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(/\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(0\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010%\u001aN\u00101\u001a\u000202*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002020\u001dH\u0087\u0088\u0004b\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0014b\u0002\b6b\f\b7\u0012\b\b8\u0012\u0004\b\b(3b\u0002\b\u0005ø\u0001\u0000¢\u0006\u0002\b3\u001aN\u00101\u001a\u000209*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090\u001dH\u0087\u0088\u0004b\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0014b\u0002\b6b\f\b7\u0012\b\b8\u0012\u0004\b\b(:b\u0002\b\u0005ø\u0001\u0000¢\u0006\u0002\b:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"elementAt", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "toSortedSet", "Ljava/util/SortedSet;", "max", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "maxBy", "R", _UrlKt.FRAGMENT_ENCODE_SET, "selector", "Lni/shikatu/kotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lni/shikatu/kotlin/SinceKotlin;", "version", "Lni/shikatu/kotlin/OverloadResolutionByLambdaReturnType;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "Ljava/math/BigInteger;", "sumOfBigInteger", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    private static final char elementAt(CharSequence $this$elementAt, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "<this>");
        return $this$elementAt.charAt(index);
    }

    public static final SortedSet<Character> toSortedSet(CharSequence $this$toSortedSet) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        return (SortedSet) StringsKt.toCollection($this$toSortedSet, new TreeSet());
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Character max(CharSequence $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return StringsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  <R extends Comparable<? super R>> Character maxBy(CharSequence $this$maxBy, Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if ($this$maxBy.length() == 0) {
            return null;
        }
        char maxElem$iv = $this$maxBy.charAt(0);
        int lastIndex$iv = StringsKt.getLastIndex($this$maxBy);
        if (lastIndex$iv == 0) {
            return Character.valueOf(maxElem$iv);
        }
        Comparable maxValue$iv = function1.invoke(Character.valueOf(maxElem$iv));
        int i$iv = 1;
        if (1 <= lastIndex$iv) {
            while (true) {
                char e$iv = $this$maxBy.charAt(i$iv);
                R rInvoke = function1.invoke(Character.valueOf(e$iv));
                if (maxValue$iv.compareTo(rInvoke) < 0) {
                    maxElem$iv = e$iv;
                    maxValue$iv = rInvoke;
                }
                if (i$iv == lastIndex$iv) {
                    break;
                }
                i$iv++;
            }
        }
        return Character.valueOf(maxElem$iv);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Character maxWith(CharSequence $this$maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.maxWithOrNull($this$maxWith, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Character min(CharSequence $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return StringsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  <R extends Comparable<? super R>> Character minBy(CharSequence $this$minBy, Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if ($this$minBy.length() == 0) {
            return null;
        }
        char minElem$iv = $this$minBy.charAt(0);
        int lastIndex$iv = StringsKt.getLastIndex($this$minBy);
        if (lastIndex$iv == 0) {
            return Character.valueOf(minElem$iv);
        }
        Comparable minValue$iv = function1.invoke(Character.valueOf(minElem$iv));
        int i$iv = 1;
        if (1 <= lastIndex$iv) {
            while (true) {
                char e$iv = $this$minBy.charAt(i$iv);
                R rInvoke = function1.invoke(Character.valueOf(e$iv));
                if (minValue$iv.compareTo(rInvoke) > 0) {
                    minElem$iv = e$iv;
                    minValue$iv = rInvoke;
                }
                if (i$iv == lastIndex$iv) {
                    break;
                }
                i$iv++;
            }
        }
        return Character.valueOf(minElem$iv);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Character minWith(CharSequence $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.minWithOrNull($this$minWith, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(CharSequence $this$sumOf, Function1<? super Character, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        for (int i = 0; i < $this$sumOf.length(); i++) {
            char element = $this$sumOf.charAt(i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(Character.valueOf(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(CharSequence $this$sumOf, Function1<? super Character, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        for (int i = 0; i < $this$sumOf.length(); i++) {
            char element = $this$sumOf.charAt(i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(Character.valueOf(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }
}
