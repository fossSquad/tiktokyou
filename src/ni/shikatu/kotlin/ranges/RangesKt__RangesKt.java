package ni.shikatu.kotlin.ranges;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0005\u001aQ\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000e¢\u0006\u0002\u0010\b\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0010H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u001a<\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0010H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000e\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u001a<\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000e\u001aY\u0010\u0013\u001a\u00020\u0014\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019b\u0002\b\u001a¢\u0006\u0002\u0010\u0018\u001ao\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0002*\u00020\u001b\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b \u0012\b\b!\u0012\u0004\b\b(\u0019b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"b\u0002\b\u001a¢\u0006\u0002\u0010\u001c\u001ak\u0010\u0013\u001a\u00020\u0014\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019b\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000eb\u0002\b\u001a¢\u0006\u0002\u0010#\u001ao\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0002*\u00020\u001b\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b \u0012\b\b!\u0012\u0004\b\b(\u0019b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u001a¢\u0006\u0002\u0010$\u001a\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0080\u0080\u0004¨\u0006*"}, d2 = {"rangeTo", "Lni/shikatu/kotlin/ranges/ClosedRange;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "rangeUntil", "Lni/shikatu/kotlin/ranges/OpenEndRange;", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "Lni/shikatu/kotlin/ranges/ClosedFloatingPointRange;", _UrlKt.FRAGMENT_ENCODE_SET, "1.1", _UrlKt.FRAGMENT_ENCODE_SET, "contains", _UrlKt.FRAGMENT_ENCODE_SET, "R", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;)Z", "2.3", "Lni/shikatu/kotlin/internal/InlineOnly;", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "Lni/shikatu/kotlin/Deprecated;", "message", "The signature violates type safety guarantees", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "hiddenSince", "1.3", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Comparable;)Z", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "checkStepIsPositive", _UrlKt.FRAGMENT_ENCODE_SET, "isPositive", "step", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/ranges/RangesKt")
class RangesKt__RangesKt {
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(t2, "that");
        return new ComparableRange(t, t2);
    }

    public static final <T extends Comparable<? super T>> OpenEndRange<T> rangeUntil(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(t2, "that");
        return new ComparableOpenEndRange(t, t2);
    }

    public static final ClosedFloatingPointRange<Double> rangeTo(double $this$rangeTo, double that) {
        return new ClosedDoubleRange($this$rangeTo, that);
    }

    public static final OpenEndRange<Double> rangeUntil(double $this$rangeUntil, double that) {
        return new OpenEndDoubleRange($this$rangeUntil, that);
    }

    public static final ClosedFloatingPointRange<Float> rangeTo(float $this$rangeTo, float that) {
        return new ClosedFloatRange($this$rangeTo, that);
    }

    public static final OpenEndRange<Float> rangeUntil(float $this$rangeUntil, float that) {
        return new OpenEndFloatRange($this$rangeUntil, that);
    }

    private static final boolean contains(ClosedRange $this$contains, Comparable element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element);
    }

    @Deprecated(message = "The signature violates type safety guarantees")
    @DeprecatedSinceKotlin(hiddenSince = "2.3")
    private static final  boolean contains(ClosedRange $this$contains, Object element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains((Comparable) element);
    }

    private static final boolean contains(OpenEndRange $this$contains, Comparable element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element);
    }

    @Deprecated(message = "The signature violates type safety guarantees")
    @DeprecatedSinceKotlin(hiddenSince = "2.3")
    private static final  boolean contains(OpenEndRange $this$contains, Object element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains((Comparable) element);
    }

    public static final void checkStepIsPositive(boolean isPositive, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (!isPositive) {
            throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
        }
    }
}
