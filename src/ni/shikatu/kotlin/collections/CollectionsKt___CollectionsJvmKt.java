package ni.shikatu.kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\u0080\u0004\u001aI\u0010\u0006\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\b\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\t\u001a\u0002H\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0080\bb\u0002\b\u000b¢\u0006\u0002\u0010\n\u001a\u001a\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000fH\u0086\u0080\u0004\u001a*\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u0003H\u0086\u0080\u0004\u001a<\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0014j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u0015H\u0086\u0080\u0004\u001aw\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\b\u0012\u0004\u0012\u00020\u00170\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010\u0018\u001aw\u0010\u0016\u001a\u0004\u0018\u00010+*\b\u0012\u0004\u0012\u00020+0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010,\u001ay\u0010\u0016\u001a\u0004\u0018\u0001H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u0010-\u001a\u0096\u0001\u0010.\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000200H\u0087\u0088\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(2\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(3\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u008b\u0001\u00104\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0014j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u0015H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(7\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u00105\u001aw\u00108\u001a\u0004\u0018\u00010\u0017*\b\u0012\u0004\u0012\u00020\u00170\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010\u0018\u001aw\u00108\u001a\u0004\u0018\u00010+*\b\u0012\u0004\u0012\u00020+0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010,\u001ay\u00108\u001a\u0004\u0018\u0001H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u0010-\u001a\u0096\u0001\u0010;\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000200H\u0087\u0088\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(<\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(=\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u008b\u0001\u0010>\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0014j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u0015H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(?\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(@\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u00105\u001aZ\u0010A\u001a\u00020B\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020B00H\u0087\u0088\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(#b\u0002\bDb\f\bE\u0012\b\bF\u0012\u0004\b\b(Cb\u0002\bGø\u0001\u0000¢\u0006\u0002\bC\u001aZ\u0010A\u001a\u00020H\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020H00H\u0087\u0088\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(#b\u0002\bDb\f\bE\u0012\b\bF\u0012\u0004\b\b(Ib\u0002\bGø\u0001\u0000¢\u0006\u0002\bI\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006J"}, d2 = {"filterIsInstance", _UrlKt.FRAGMENT_ENCODE_SET, "R", _UrlKt.FRAGMENT_ENCODE_SET, "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", _UrlKt.FRAGMENT_ENCODE_SET, "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "reverse", _UrlKt.FRAGMENT_ENCODE_SET, "T", _UrlKt.FRAGMENT_ENCODE_SET, "toSortedSet", "Ljava/util/SortedSet;", _UrlKt.FRAGMENT_ENCODE_SET, "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "max", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Iterable;)Ljava/lang/Double;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Iterable;)Ljava/lang/Float;", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "maxBy", "selector", "Lni/shikatu/kotlin/Function1;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lni/shikatu/kotlin/OverloadResolutionByLambdaReturnType;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "Lni/shikatu/kotlin/internal/InlineOnly;", "Ljava/math/BigInteger;", "sumOfBigInteger", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/CollectionsKt")
public class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> cls) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(cls, "klass");
        return (List) CollectionsKt.filterIsInstanceTo(iterable, new ArrayList(), cls);
    }

    @IgnorableReturnValue
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C c, Class<R> cls) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(cls, "klass");
        for (Object element : iterable) {
            if (cls.isInstance(element)) {
                c.add(element);
            }
        }
        return c;
    }

    public static final <T> void reverse(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.reverse(list);
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (SortedSet) CollectionsKt.toCollection(iterable, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) CollectionsKt.toCollection(iterable, new TreeSet(comparator));
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Double m435max(Iterable $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return CollectionsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Float m436max(Iterable $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return CollectionsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Comparable max(Iterable $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return CollectionsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = iterable.iterator();
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
    public static final  Object maxWith(Iterable $this$maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt.maxWithOrNull($this$maxWith, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Double m437min(Iterable $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return CollectionsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  Float m438min(Iterable $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return CollectionsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  Comparable min(Iterable $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return CollectionsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final  <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = iterable.iterator();
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
    public static final  Object minWith(Iterable $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt.minWithOrNull($this$minWith, comparator);
    }

    private static final <T> BigDecimal sumOfBigDecimal(Iterable<? extends T> iterable, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        for (Object element : iterable) {
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(element));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final <T> BigInteger sumOfBigInteger(Iterable<? extends T> iterable, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        for (Object element : iterable) {
            BigInteger bigIntegerAdd = sum.add(function1.invoke(element));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }
}
