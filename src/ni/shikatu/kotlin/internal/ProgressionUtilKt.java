package ni.shikatu.kotlin.internal;

import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a \u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0001\u001a \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0001¨\u0006\u000b"}, d2 = {"mod", "", "a", "b", "", "differenceModulo", "c", "getProgressionLastElement", "start", "end", "step", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
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
