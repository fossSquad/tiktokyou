package ni.shikatu.kotlin.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0082\u0080\u0004¢\u0006\u0004\b\b\u0010\t\u001a?\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0081\u0080\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013b\u0002\b\u0014¢\u0006\u0004\b\u000f\u0010\u0006\u001a?\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0015H\u0081\u0080\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013b\u0002\b\u0014¢\u0006\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"differenceModulo", "Lni/shikatu/kotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lni/shikatu/kotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", _UrlKt.FRAGMENT_ENCODE_SET, "getProgressionLastElement-Nkh28Cs", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/internal/UsedFromCompilerGeneratedCode;", _UrlKt.FRAGMENT_ENCODE_SET, "getProgressionLastElement-7ftBX0g", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class UProgressionUtilKt {

    private static final int m1240differenceModuloWZ9TVnA(int a, int b, int c) {
        int ac = Integer.remainderUnsigned(a, c);
        int bc = Integer.remainderUnsigned(b, c);
        return UInt.m101constructorimpl(Integer.compareUnsigned(ac, bc) >= 0 ? ac - bc : UInt.m101constructorimpl(ac - bc) + c);
    }

    private static final long m1241differenceModulosambcqE(long a, long b, long c) {
        long ac = Long.remainderUnsigned(a, c);
        long bc = Long.remainderUnsigned(b, c);
        return ULong.m180constructorimpl(Long.compareUnsigned(ac, bc) >= 0 ? ac - bc : ULong.m180constructorimpl(ac - bc) + c);
    }

    public static final int m1243getProgressionLastElementNkh28Cs(int start, int end, int step) {
        if (step > 0) {
            if (Integer.compareUnsigned(start, end) < 0) {
                return UInt.m101constructorimpl(end - m1240differenceModuloWZ9TVnA(end, start, UInt.m101constructorimpl(step)));
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (Integer.compareUnsigned(start, end) > 0) {
                return UInt.m101constructorimpl(m1240differenceModuloWZ9TVnA(start, end, UInt.m101constructorimpl(-step)) + end);
            }
        }
        return end;
    }

    public static final long m1242getProgressionLastElement7ftBX0g(long start, long end, long step) {
        if (step > 0) {
            if (Long.compareUnsigned(start, end) < 0) {
                return ULong.m180constructorimpl(end - m1241differenceModulosambcqE(end, start, ULong.m180constructorimpl(step)));
            }
        } else if (step < 0) {
            if (Long.compareUnsigned(start, end) > 0) {
                return ULong.m180constructorimpl(m1241differenceModulosambcqE(start, end, ULong.m180constructorimpl(-step)) + end);
            }
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return end;
    }
}
