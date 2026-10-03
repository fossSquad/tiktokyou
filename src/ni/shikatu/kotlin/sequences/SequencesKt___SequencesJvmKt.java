package ni.shikatu.kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001aI\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0080\bb\u0002\b\n¢\u0006\u0002\u0010\t\u001a*\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0086\u0080\u0004\u001a<\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0086\u0080\u0004\u001aw\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010\u0014\u001aw\u0010\u0012\u001a\u0004\u0018\u00010'*\b\u0012\u0004\u0012\u00020'0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010(\u001ay\u0010\u0012\u001a\u0004\u0018\u0001H\r\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010)\u001a\u0096\u0001\u0010*\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020,H\u0087\u0088\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(.\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(/\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u008b\u0001\u00100\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u00101\u001aw\u00104\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010\u0014\u001aw\u00104\u001a\u0004\u0018\u00010'*\b\u0012\u0004\u0012\u00020'0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010(\u001ay\u00104\u001a\u0004\u0018\u0001H\r\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010)\u001a\u0096\u0001\u00107\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020,H\u0087\u0088\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(8\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u008b\u0001\u0010:\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(;\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(<\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u00101\u001aZ\u0010=\u001a\u00020>\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020>0,H\u0087\u0088\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001fb\u0002\b@b\f\bA\u0012\b\bB\u0012\u0004\b\b(?b\u0002\bCø\u0001\u0000¢\u0006\u0002\b?\u001aZ\u0010=\u001a\u00020D\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020D0,H\u0087\u0088\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001fb\u0002\b@b\f\bA\u0012\b\bB\u0012\u0004\b\b(Eb\u0002\bCø\u0001\u0000¢\u0006\u0002\bE\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"filterIsInstance", "Lni/shikatu/kotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", _UrlKt.FRAGMENT_ENCODE_SET, "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "toSortedSet", "Ljava/util/SortedSet;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "max", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "maxBy", "selector", "Lni/shikatu/kotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lni/shikatu/kotlin/OverloadResolutionByLambdaReturnType;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "Lni/shikatu/kotlin/internal/InlineOnly;", "Ljava/math/BigInteger;", "sumOfBigInteger", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/sequences/SequencesKt")
class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    public static final <R> Sequence<R> filterIsInstance(Sequence<?> sequence, final Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(cls, "klass");
        Sequence<R> sequenceFilter = SequencesKt.filter(sequence, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return Boolean.valueOf(cls.isInstance(obj));
            }
        });
        Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return sequenceFilter;
    }

    @IgnorableReturnValue
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Sequence<?> sequence, C c, Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(cls, "klass");
        for (Object element : sequence) {
            if (cls.isInstance(element)) {
                c.add(element);
            }
        }
        return c;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet(comparator));
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Double m1315max(Sequence $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return SequencesKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Float m1316max(Sequence $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return SequencesKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Comparable max(Sequence $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return SequencesKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  <T, R extends Comparable<? super R>> T maxBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = function1.invoke(next);
        do {
            Object next2 = it.next();
            R rInvoke2 = function1.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                next = (T) next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Object maxWith(Sequence $this$maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return SequencesKt.maxWithOrNull($this$maxWith, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Double m1317min(Sequence $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return SequencesKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Float m1318min(Sequence $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return SequencesKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Comparable min(Sequence $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return SequencesKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  <T, R extends Comparable<? super R>> T minBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = function1.invoke(next);
        do {
            Object next2 = it.next();
            R rInvoke2 = function1.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                next = (T) next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Object minWith(Sequence $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return SequencesKt.minWithOrNull($this$minWith, comparator);
    }

    private static final <T> BigDecimal sumOfBigDecimal(Sequence<? extends T> sequence, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        for (Object element : sequence) {
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(element));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final <T> BigInteger sumOfBigInteger(Sequence<? extends T> sequence, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        for (Object element : sequence) {
            BigInteger bigIntegerAdd = sum.add(function1.invoke(element));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }
}
