package ni.shikatu.kotlin.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0082\u0080\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\"\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0082\u0080\u0004\u001a\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0082\u0080\u0004\u001a*\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\u000bb\u0002\b\f\u001a*\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0081\u0080\u0004b\u0002\b\u000bb\u0002\b\f¨\u0006\r"}, d2 = {"mod", _UrlKt.FRAGMENT_ENCODE_SET, "a", "b", _UrlKt.FRAGMENT_ENCODE_SET, "differenceModulo", "c", "getProgressionLastElement", "start", "end", "step", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/internal/UsedFromCompilerGeneratedCode;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ProgressionUtilKt {
    private static final int mod(int a, int b) {
        int mod = a % b;
        return mod >= 0 ? mod : mod + b;
    }

    private static final long mod(long a, long b) {
        long mod = a % b;
        return mod >= 0 ? mod : mod + b;
    }

    private static final int differenceModulo(int a, int b, int c) {
        return mod(mod(a, c) - mod(b, c), c);
    }

    private static final long differenceModulo(long a, long b, long c) {
        return mod(mod(a, c) - mod(b, c), c);
    }

    public static final int getProgressionLastElement(int start, int end, int step) {
        if (step > 0) {
            if (start < end) {
                return end - differenceModulo(end, start, step);
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (start > end) {
                return differenceModulo(start, end, -step) + end;
            }
        }
        return end;
    }

    public static final long getProgressionLastElement(long start, long end, long step) {
        if (step > 0) {
            if (start < end) {
                return end - differenceModulo(end, start, step);
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (start > end) {
                return differenceModulo(start, end, -step) + end;
            }
        }
        return end;
    }
}
