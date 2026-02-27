package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/time/TimeMark;", "", "elapsedNow", "Lni/shikatu/kotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "minus", "minus-LRDsOJo", "hasPassedNow", "", "hasNotPassedNow", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TimeMark {

    long mo1352elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    TimeMark mo1353minusLRDsOJo(long j);

    TimeMark mo1355plusLRDsOJo(long j);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {

        public static TimeMark m1470plusLRDsOJo(TimeMark $this, long duration) {
            return new AdjustedTimeMark($this, duration, null);
        }

        public static TimeMark m1469minusLRDsOJo(TimeMark $this, long duration) {
            return $this.mo1355plusLRDsOJo(Duration.m1406unaryMinusUwyO8pc(duration));
        }

        public static boolean hasPassedNow(TimeMark $this) {
            return !Duration.m1388isNegativeimpl($this.mo1352elapsedNowUwyO8pc());
        }

        public static boolean hasNotPassedNow(TimeMark $this) {
            return Duration.m1388isNegativeimpl($this.mo1352elapsedNowUwyO8pc());
        }
    }
}
