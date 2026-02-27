package ni.shikatu.kotlin.ranges;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0005\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u0002¢\u0006\u0002\u0010\b\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0087\u0002\u001a\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0007*\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0087\u0002\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\t*\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\u0002\u001a\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007*\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\u0002\u001a@\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u000e\"\u0018\b\u0001\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0010*\u0002H\u000f2\b\u0010\u0011\u001a\u0004\u0018\u0001H\u0002H\u0087\n¢\u0006\u0002\u0010\u0012\u001a@\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u000e\"\u0018\b\u0001\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u0010*\u0002H\u000f2\b\u0010\u0011\u001a\u0004\u0018\u0001H\u0002H\u0087\n¢\u0006\u0002\u0010\u0013\u001a\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¨\u0006\u0019"}, d2 = {"rangeTo", "Lni/shikatu/kotlin/ranges/ClosedRange;", "T", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "rangeUntil", "Lni/shikatu/kotlin/ranges/OpenEndRange;", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "Lni/shikatu/kotlin/ranges/ClosedFloatingPointRange;", "", "", "contains", "", "", "R", "", "element", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "checkStepIsPositive", "", "isPositive", "step", "", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/ranges/RangesKt")
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

    private static final boolean contains(ClosedRange $this$contains, Object element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains((Comparable) element);
    }

    private static final boolean contains(OpenEndRange $this$contains, Object element) {
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
