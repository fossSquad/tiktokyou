package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0000H¦\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0011H¦\u0002J\b\u0010\u0012\u001a\u00020\u000eH&¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/time/ComparableTimeMark;", "Lni/shikatu/kotlin/time/TimeMark;", "", "plus", "duration", "Lni/shikatu/kotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "compareTo", "", "equals", "", "", "hashCode", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {
    int compareTo(ComparableTimeMark comparableTimeMark);

    boolean equals(Object obj);

    int hashCode();

    @Override

    ComparableTimeMark mo1353minusLRDsOJo(long j);

    long mo1354minusUwyO8pc(ComparableTimeMark comparableTimeMark);

    @Override

    ComparableTimeMark mo1355plusLRDsOJo(long j);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(ComparableTimeMark $this) {
            return TimeMark.DefaultImpls.hasNotPassedNow($this);
        }

        public static boolean hasPassedNow(ComparableTimeMark $this) {
            return TimeMark.DefaultImpls.hasPassedNow($this);
        }

        public static ComparableTimeMark m1357minusLRDsOJo(ComparableTimeMark $this, long duration) {
            return $this.mo1355plusLRDsOJo(Duration.m1406unaryMinusUwyO8pc(duration));
        }

        public static int compareTo(ComparableTimeMark $this, ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return Duration.m1361compareToLRDsOJo($this.mo1354minusUwyO8pc(other), Duration.Companion.m1453getZEROUwyO8pc());
        }
    }
}
