package ni.shikatu.kotlin.system;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a'\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"measureTimeMillis", "", "block", "Lni/shikatu/kotlin/Function0;", "", "measureNanoTime", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TimingKt {
    public static final long measureTimeMillis(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        long start = System.currentTimeMillis();
        function0.invoke();
        return System.currentTimeMillis() - start;
    }

    public static final long measureNanoTime(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        long start = System.nanoTime();
        function0.invoke();
        return System.nanoTime() - start;
    }
}
